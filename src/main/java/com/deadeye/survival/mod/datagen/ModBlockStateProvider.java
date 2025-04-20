package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeadeyeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DAVITE_BLOCK);

        blockWithItem(ModBlocks.DAVITE_ORE);
        blockWithItem(ModBlocks.DAVITE_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.DAVITE_STAIRS.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));
        slabBlock(ModBlocks.DAVITE_SLAB.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()), blockTexture(ModBlocks.DAVITE_BLOCK.get()));

        buttonBlock(ModBlocks.DAVITE_BUTTON.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.DAVITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));

        fenceBlock(ModBlocks.DAVITE_FENCE.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.DAVITE_FENCE_GATE.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));
        wallBlock(ModBlocks.DAVITE_WALL.get(), blockTexture(ModBlocks.DAVITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.DAVITE_DOOR.get(), modLoc("block/davite_door_bottom"), modLoc("block/davite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.DAVITE_TRAPDOOR.get(), modLoc("block/davite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.DAVITE_STAIRS);
        blockItem(ModBlocks.DAVITE_SLAB);
        blockItem(ModBlocks.DAVITE_PRESSURE_PLATE);
        blockItem(ModBlocks.DAVITE_FENCE_GATE);
        blockItem(ModBlocks.DAVITE_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("deadeyesurvivalmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("deadeyesurvivalmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
