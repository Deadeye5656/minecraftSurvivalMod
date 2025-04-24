package com.deadeye.survival.mod.datagen;

import com.deadeye.survival.mod.block.ModBlocks;
import com.deadeye.survival.mod.item.ModItems;
import com.deadeye.survival.mod.block.custom.KohlrabiCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.DAVITE_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.DAVITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DAVITE_ORE.get(), ModItems.RAW_DAVITE.get()));
        this.add(ModBlocks.DAVITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DAVITE_DEEPSLATE_ORE.get(), ModItems.RAW_DAVITE.get(), 2, 6));

        dropSelf(ModBlocks.DAVITE_STAIRS.get());
        this.add(ModBlocks.DAVITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DAVITE_SLAB.get()));

        dropSelf(ModBlocks.DAVITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DAVITE_BUTTON.get());
        dropSelf(ModBlocks.DAVITE_FENCE.get());
        dropSelf(ModBlocks.DAVITE_FENCE_GATE.get());
        dropSelf(ModBlocks.DAVITE_WALL.get());
        dropSelf(ModBlocks.DAVITE_TRAPDOOR.get());

        this.add(ModBlocks.DAVITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.DAVITE_DOOR.get()));

        dropSelf(ModBlocks.DAVITE_LAMP.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.KOHLRABI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KohlrabiCropBlock.AGE, KohlrabiCropBlock.MAX_AGE));

        this.add(ModBlocks.KOHLRABI_CROP.get(), this.createCropDrops(ModBlocks.KOHLRABI_CROP.get(),
                ModItems.KOHLRABI.get(), ModItems.KOHLRABI_SEEDS.get(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.WALNUT_LOG.get());
        this.dropSelf(ModBlocks.WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.WALNUT_PLANKS.get());
        this.dropSelf(ModBlocks.WALNUT_SAPLING.get());

        this.add(ModBlocks.WALNUT_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
