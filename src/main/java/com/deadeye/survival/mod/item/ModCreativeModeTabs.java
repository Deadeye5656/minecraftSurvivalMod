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
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
