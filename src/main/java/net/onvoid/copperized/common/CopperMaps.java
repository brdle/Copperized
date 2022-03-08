package net.onvoid.copperized.common;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.function.Supplier;

public class CopperMaps {
    public static final Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(CopperizedBlocks.COPPER_DOOR.get(), CopperizedBlocks.EXPOSED_COPPER_DOOR.get())
            .put(CopperizedBlocks.EXPOSED_COPPER_DOOR.get(), CopperizedBlocks.WEATHERED_COPPER_DOOR.get())
            .put(CopperizedBlocks.WEATHERED_COPPER_DOOR.get(), CopperizedBlocks.OXIDIZED_COPPER_DOOR.get())
            .put(CopperizedBlocks.COPPER_TRAPDOOR.get(), CopperizedBlocks.EXPOSED_COPPER_TRAPDOOR.get())
            .put(CopperizedBlocks.EXPOSED_COPPER_TRAPDOOR.get(), CopperizedBlocks.WEATHERED_COPPER_TRAPDOOR.get())
            .put(CopperizedBlocks.WEATHERED_COPPER_TRAPDOOR.get(), CopperizedBlocks.OXIDIZED_COPPER_TRAPDOOR.get())
            .build());
    public static final Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
            .put(CopperizedBlocks.COPPER_DOOR.get(), CopperizedBlocks.WAXED_COPPER_DOOR.get())
            .put(CopperizedBlocks.EXPOSED_COPPER_DOOR.get(), CopperizedBlocks.WAXED_EXPOSED_COPPER_DOOR.get())
            .put(CopperizedBlocks.WEATHERED_COPPER_DOOR.get(), CopperizedBlocks.WAXED_WEATHERED_COPPER_DOOR.get())
            .put(CopperizedBlocks.OXIDIZED_COPPER_DOOR.get(), CopperizedBlocks.WAXED_OXIDIZED_COPPER_DOOR.get())
            .put(CopperizedBlocks.COPPER_TRAPDOOR.get(), CopperizedBlocks.WAXED_COPPER_TRAPDOOR.get())
            .put(CopperizedBlocks.EXPOSED_COPPER_TRAPDOOR.get(), CopperizedBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get())
            .put(CopperizedBlocks.WEATHERED_COPPER_TRAPDOOR.get(), CopperizedBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get())
            .put(CopperizedBlocks.OXIDIZED_COPPER_TRAPDOOR.get(), CopperizedBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get())
            .build());
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> WAXABLES.get().inverse());

    public static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    public static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }

    public static Optional<Block> getWaxed(Block block) {
        return Optional.ofNullable(WAXABLES.get().get(block));
    }

    public static Optional<Block> getUnwaxed(Block block) {
        return Optional.ofNullable(WAX_OFF_BY_BLOCK.get().get(block));
    }
}
