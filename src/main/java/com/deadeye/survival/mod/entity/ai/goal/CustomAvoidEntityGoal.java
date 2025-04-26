package com.deadeye.survival.mod.entity.ai.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;

import static com.mojang.text2speech.Narrator.LOGGER;

public class CustomAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {

    private final float extraDistanceToCrouch;
    private final float avoidDistance;

    public CustomAvoidEntityGoal(LivingEntity entity, Class<T> classToAvoid, float avoidDistance, float extraDistanceToCrouch, double walkSpeedModifier, double sprintSpeedModifier) {
        super((PathfinderMob) entity, classToAvoid, avoidDistance, walkSpeedModifier, sprintSpeedModifier);
        this.extraDistanceToCrouch = extraDistanceToCrouch;
        this.avoidDistance = avoidDistance;
    }

    @Override
    public boolean canUse() {
        if (this.toAvoid instanceof Player player) {
            float adjustedAvoidDistance = this.avoidDistance;

            if (player.isCrouching()) {
                adjustedAvoidDistance -= this.extraDistanceToCrouch;
            }

            return this.mob.distanceToSqr(player) < (adjustedAvoidDistance * adjustedAvoidDistance);
        }
        return super.canUse();
    }
}