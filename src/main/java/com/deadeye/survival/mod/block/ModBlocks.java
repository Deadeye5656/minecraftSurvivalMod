package com.deadeye.survival.mod.block;

import com.deadeye.survival.mod.DeadeyeMod;
import com.deadeye.survival.mod.block.custom.DaviteLampBlock;
import com.deadeye.survival.mod.block.custom.KohlrabiCropBlock;
import com.deadeye.survival.mod.block.custom.MagicBlock;
import com.deadeye.survival.mod.item.ModItems;
import com.deadeye.survival.mod.sound.ModSounds;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DeadeyeMod.MOD_ID);

    public static final RegistryObject<Block> DAVITE_BLOCK = registerBlock("davite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> DAVITE_ORE = registerBlock("davite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DAVITE_DEEPSLATE_ORE = registerBlock("davite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final RegistryObject<StairBlock> DAVITE_STAIRS = registerBlock("davite_stairs",
            () -> new StairBlock(ModBlocks.DAVITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> DAVITE_SLAB = registerBlock("davite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> DAVITE_PRESSURE_PLATE = registerBlock("davite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> DAVITE_BUTTON = registerBlock("davite_button",
            () -> new ButtonBlock(BlockSetType.IRON,1, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> DAVITE_FENCE = registerBlock("davite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> DAVITE_FENCE_GATE = registerBlock("davite_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> DAVITE_WALL = registerBlock("davite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> DAVITE_DOOR = registerBlock("davite_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> DAVITE_TRAPDOOR = registerBlock("davite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> DAVITE_LAMP = registerBlock("davite_lamp",
            () -> new DaviteLampBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(DaviteLampBlock.CLICKED) ? 15 : 0)));

    public static final RegistryObject<Block> KOHLRABI_CROP = BLOCKS.register("kohlrabi_crop",
            () -> new KohlrabiCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
