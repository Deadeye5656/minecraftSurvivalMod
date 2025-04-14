package com.deadeye.survival.mod.item;

import com.deadeye.survival.mod.DeadeyeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeadeyeMod.MOD_ID);

    public static final RegistryObject<Item> DAVITE = ITEMS.register("davite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_DAVITE = ITEMS.register("raw_davite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
