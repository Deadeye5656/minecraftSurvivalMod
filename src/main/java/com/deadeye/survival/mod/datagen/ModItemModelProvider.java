package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeadeyeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.DAVITE.get());
        basicItem(ModItems.RAW_DAVITE.get());

//        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.AURORA_ASHES.get());
        buttonItem(ModBlocks.DAVITE_BUTTON, ModBlocks.DAVITE_BLOCK);
        fenceItem(ModBlocks.DAVITE_FENCE, ModBlocks.DAVITE_BLOCK);
        wallItem(ModBlocks.DAVITE_WALL, ModBlocks.DAVITE_BLOCK);

        simpleBlockItem(ModBlocks.DAVITE_DOOR);

        handheldItem(ModItems.DAVITE_SWORD);
        handheldItem(ModItems.DAVITE_PICKAXE);
        handheldItem(ModItems.DAVITE_SHOVEL);
        handheldItem(ModItems.DAVITE_AXE);
        handheldItem(ModItems.DAVITE_HOE);
        handheldItem(ModItems.DAVITE_HAMMER);

        armorItem(ModItems.DAVITE_HELMET);
        armorItem(ModItems.DAVITE_CHESTPLATE);
        armorItem(ModItems.DAVITE_LEGGINGS);
        armorItem(ModItems.DAVITE_BOOTS);

        basicItem(ModItems.KOHLRABI_SEEDS.get());
    }

    private void armorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = DeadeyeMod.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            this.withExistingParent(itemRegistryObject.getId().getPath(),
                            mcLoc("item/generated"))
                    .texture("layer0",
                            ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                    "item/" + itemRegistryObject.getId().getPath()));
        }
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
