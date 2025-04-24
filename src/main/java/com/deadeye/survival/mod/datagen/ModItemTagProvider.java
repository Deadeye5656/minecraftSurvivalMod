package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.item.ModItems;
import com.deadeye.survival.mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, DeadeyeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.DAVITE.get())
                .add(ModItems.RAW_DAVITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.DAVITE_HELMET.get())
                .add(ModItems.DAVITE_CHESTPLATE.get())
                .add(ModItems.DAVITE_LEGGINGS.get())
                .add(ModItems.DAVITE_BOOTS.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.WALNUT_LOG.get().asItem())
                .add(ModBlocks.WALNUT_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.WALNUT_PLANKS.get().asItem());
    }
}
