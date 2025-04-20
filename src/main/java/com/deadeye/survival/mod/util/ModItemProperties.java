package com.deadeye.survival.mod.util;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.component.ModDataComponentTypes;
import com.deadeye.survival.mod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f : 0f);

    }
}
