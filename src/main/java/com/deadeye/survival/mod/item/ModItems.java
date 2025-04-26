package com.deadeye.survival.mod.item;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.item.custom.ChiselItem;
import com.deadeye.survival.mod.item.custom.FuelItem;
import com.deadeye.survival.mod.item.custom.HammerItem;
import com.deadeye.survival.mod.entity.ModEntities;
import net.minecraftforge.common.ForgeSpawnEggItem;
import com.deadeye.survival.mod.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeadeyeMod.MOD_ID);

    public static final RegistryObject<Item> DAVITE = ITEMS.register("davite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_DAVITE = ITEMS.register("raw_davite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.deadeyesurvivalmod.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> KOHLRABI_SEEDS = ITEMS.register("kohlrabi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.KOHLRABI_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> DAVITE_SWORD = ITEMS.register("davite_sword",
            () -> new SwordItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.DAVITE, 3, -2.4f))));
    public static final RegistryObject<Item> DAVITE_PICKAXE = ITEMS.register("davite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.DAVITE, 1, -2.8f))));
    public static final RegistryObject<Item> DAVITE_SHOVEL = ITEMS.register("davite_shovel",
            () -> new ShovelItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.DAVITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> DAVITE_AXE = ITEMS.register("davite_axe",
            () -> new AxeItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.DAVITE, 6, -3.2f))));
    public static final RegistryObject<Item> DAVITE_HOE = ITEMS.register("davite_hoe",
            () -> new HoeItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.DAVITE, 0, -3.0f))));
    public static final RegistryObject<Item> DAVITE_HAMMER = ITEMS.register("davite_hammer",
            () -> new HammerItem(ModToolTiers.DAVITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.DAVITE, 7, -3.5f))));

    public static final RegistryObject<Item> DAVITE_HELMET = ITEMS.register("davite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.DAVITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> DAVITE_CHESTPLATE = ITEMS.register("davite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DAVITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> DAVITE_LEGGINGS = ITEMS.register("davite_leggings",
            () -> new ArmorItem(ModArmorMaterials.DAVITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> DAVITE_BOOTS = ITEMS.register("davite_boots",
            () -> new ArmorItem(ModArmorMaterials.DAVITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> DAVES_BOW = ITEMS.register("daves_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> TRICERATOPS_SPAWN_EGG = ITEMS.register("triceratops_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TRICERATOPS, 0x53524b, 0xdac741, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
