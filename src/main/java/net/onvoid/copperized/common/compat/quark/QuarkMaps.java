package net.onvoid.copperized.common.compat.quark;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class QuarkMaps {
    public static final Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> (BiMap)ImmutableBiMap.builder()
            .put(lookupQuarkBlock("cut_copper_vertical_slab"), lookupQuarkBlock("exposed_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("exposed_cut_copper_vertical_slab"), lookupQuarkBlock("weathered_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("weathered_cut_copper_vertical_slab"), lookupQuarkBlock("oxidized_cut_copper_vertical_slab"))
    .build());
    public static final Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> ((BiMap)NEXT_BY_BLOCK.get()).inverse());
    public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> (BiMap)ImmutableBiMap.builder()
            .put(lookupQuarkBlock("cut_copper_vertical_slab"), lookupQuarkBlock("waxed_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("exposed_cut_copper_vertical_slab"), lookupQuarkBlock("waxed_exposed_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("weathered_cut_copper_vertical_slab"), lookupQuarkBlock("waxed_weathered_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("oxidized_cut_copper_vertical_slab"), lookupQuarkBlock("waxed_oxidized_cut_copper_vertical_slab"))
            .put(lookupQuarkBlock("red_corundum"), lookupQuarkBlock("waxed_red_corundum"))
            .put(lookupQuarkBlock("orange_corundum"), lookupQuarkBlock("waxed_orange_corundum"))
            .put(lookupQuarkBlock("yellow_corundum"), lookupQuarkBlock("waxed_yellow_corundum"))
            .put(lookupQuarkBlock("green_corundum"), lookupQuarkBlock("waxed_green_corundum"))
            .put(lookupQuarkBlock("blue_corundum"), lookupQuarkBlock("waxed_blue_corundum"))
            .put(lookupQuarkBlock("indigo_corundum"), lookupQuarkBlock("waxed_indigo_corundum"))
            .put(lookupQuarkBlock("violet_corundum"), lookupQuarkBlock("waxed_violet_corundum"))
            .put(lookupQuarkBlock("white_corundum"), lookupQuarkBlock("waxed_white_corundum"))
            .put(lookupQuarkBlock("black_corundum"), lookupQuarkBlock("waxed_black_corundum"))
    .build());
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> ((BiMap)WAXABLES.get()).inverse());

    private static Block lookupQuarkBlock(String blockName) {
        return lookupBlock("quark", blockName);
    }

    public static Block lookupBlock(String modid, String blockName){
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, blockName));
    }
}