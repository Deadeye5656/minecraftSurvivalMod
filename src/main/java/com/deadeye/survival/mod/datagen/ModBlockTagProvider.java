package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeadeyeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DAVITE_BLOCK.get())
                .add(ModBlocks.DAVITE_ORE.get())
                .add(ModBlocks.DAVITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DAVITE_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.DAVITE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.DAVITE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.DAVITE_WALL.get());

        tag(ModTags.Blocks.NEEDS_DAVITE_TOOL)
                .add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_DAVITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_DAVITE_TOOL);
    }
}
