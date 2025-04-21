package com.deadeye.survival.mod.item;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeadeyeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DEADEYE_ITEMS_TAB = CREATIVE_MODE_TABS.register("deadeye_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DAVITE.get()))
                    .title(Component.translatable("creativetab.deadeyesurvivalmod.deadeye_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DAVITE.get());
                        output.accept(ModItems.RAW_DAVITE.get());
                        output.accept(ModBlocks.DAVITE_BLOCK.get());
                        output.accept(ModBlocks.DAVITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.DAVITE_ORE.get());
                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.AURORA_ASHES.get());
                        output.accept(ModBlocks.DAVITE_STAIRS.get());
                        output.accept(ModBlocks.DAVITE_SLAB.get());
                        output.accept(ModBlocks.DAVITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DAVITE_BUTTON.get());
                        output.accept(ModBlocks.DAVITE_FENCE.get());
                        output.accept(ModBlocks.DAVITE_FENCE_GATE.get());
                        output.accept(ModBlocks.DAVITE_WALL.get());
                        output.accept(ModBlocks.DAVITE_DOOR.get());
                        output.accept(ModBlocks.DAVITE_TRAPDOOR.get());
                        output.accept(ModBlocks.DAVITE_LAMP.get());
                        output.accept(ModItems.DAVITE_SWORD.get());
                        output.accept(ModItems.DAVITE_PICKAXE.get());
                        output.accept(ModItems.DAVITE_SHOVEL.get());
                        output.accept(ModItems.DAVITE_AXE.get());
                        output.accept(ModItems.DAVITE_HOE.get());
                        output.accept(ModItems.DAVITE_HAMMER.get());
                        output.accept(ModItems.DAVITE_HELMET.get());
                        output.accept(ModItems.DAVITE_CHESTPLATE.get());
                        output.accept(ModItems.DAVITE_LEGGINGS.get());
                        output.accept(ModItems.DAVITE_BOOTS.get());
                        output.accept(ModItems.DAVES_BOW.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
