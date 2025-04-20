package com.deadeye.survival.mod.item;

import com.deadeye.survival.mod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier DAVITE = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_DAVITE_TOOL, () -> Ingredient.of(ModItems.DAVITE.get()),
            ModTags.Blocks.INCORRECT_FOR_DAVITE_TOOL);
}
