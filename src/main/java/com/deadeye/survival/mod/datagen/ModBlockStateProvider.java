package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.block.custom.DaviteLampBlock;
import com.deadeye.survival.mod.block.custom.KohlrabiCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        customLamp();

        makeCrop(((CropBlock) ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_crop_stage", "kohlrabi_crop_stage");

        logBlock(ModBlocks.WALNUT_LOG.get());
        axisBlock(ModBlocks.WALNUT_WOOD.get(), blockTexture(ModBlocks.WALNUT_LOG.get()), blockTexture(ModBlocks.WALNUT_LOG.get()));
        logBlock(ModBlocks.STRIPPED_WALNUT_LOG.get());
        axisBlock(ModBlocks.STRIPPED_WALNUT_WOOD.get(), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()));

        blockItem(ModBlocks.WALNUT_LOG);
        blockItem(ModBlocks.WALNUT_WOOD);
        blockItem(ModBlocks.STRIPPED_WALNUT_LOG);
        blockItem(ModBlocks.STRIPPED_WALNUT_WOOD);

        blockWithItem(ModBlocks.WALNUT_PLANKS);

        leavesBlock(ModBlocks.WALNUT_LEAVES);
        saplingBlock(ModBlocks.WALNUT_SAPLING);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.DAVITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(DaviteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("davite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID, "block/" + "davite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("davite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID, "block/" + "davite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.DAVITE_LAMP.get(), models().cubeAll("davite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(DeadeyeMod.MOD_ID, "block/" + "davite_lamp_on")));
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
