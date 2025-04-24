package com.deadeye.survival.mod.worldgen.tree;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower WALNUT = new TreeGrower(DeadeyeMod.MOD_ID + ":walnut",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WALNUT_KEY), Optional.empty());
}
