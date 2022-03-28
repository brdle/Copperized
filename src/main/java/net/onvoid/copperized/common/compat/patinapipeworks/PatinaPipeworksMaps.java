package net.onvoid.copperized.common.compat.patinapipeworks;

import com.google.common.collect.BiMap;
import net.minecraft.world.level.block.Block;
import patinapipeworks.block.WeatheringCopperPP;
import patinapipeworks.init.ModVanillaCompat;
import java.util.function.Supplier;

public class PatinaPipeworksMaps {
    public static final Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = WeatheringCopperPP.NEXT_BY_BLOCK;
    public static final Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = WeatheringCopperPP.PREVIOUS_BY_BLOCK;
    public static final Supplier<BiMap<Block, Block>> WAXABLES = ModVanillaCompat.WAXABLES;
    public static final Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK = ModVanillaCompat.WAX_OFF_BY_BLOCK;
}