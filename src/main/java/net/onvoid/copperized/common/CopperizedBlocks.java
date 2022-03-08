package net.onvoid.copperized.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.copperized.Copperized;

public class CopperizedBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Copperized.MODID);

    public static final RegistryObject<DoorBlock> COPPER_DOOR = BLOCKS.register("copper_door", () ->
            new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<DoorBlock> EXPOSED_COPPER_DOOR = BLOCKS.register("exposed_copper_door", () ->
            new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<DoorBlock> WEATHERED_COPPER_DOOR = BLOCKS.register("weathered_copper_door", () ->
            new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<DoorBlock> OXIDIZED_COPPER_DOOR = BLOCKS.register("oxidized_copper_door", () ->
            new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<DoorBlock> WAXED_COPPER_DOOR = BLOCKS.register("waxed_copper_door", () ->
            new WaxedDoorBlock(BlockBehaviour.Properties.copy(COPPER_DOOR.get())));
    public static final RegistryObject<DoorBlock> WAXED_EXPOSED_COPPER_DOOR = BLOCKS.register("waxed_exposed_copper_door", () ->
            new WaxedDoorBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_DOOR.get())));
    public static final RegistryObject<DoorBlock> WAXED_WEATHERED_COPPER_DOOR = BLOCKS.register("waxed_weathered_copper_door", () ->
            new WaxedDoorBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_DOOR.get())));
    public static final RegistryObject<DoorBlock> WAXED_OXIDIZED_COPPER_DOOR = BLOCKS.register("waxed_oxidized_copper_door", () ->
            new WaxedDoorBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_DOOR.get())));

    public static final RegistryObject<TrapDoorBlock> COPPER_TRAPDOOR = BLOCKS.register("copper_trapdoor", () ->
            new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn((BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) -> false)));
    public static final RegistryObject<TrapDoorBlock> EXPOSED_COPPER_TRAPDOOR = BLOCKS.register("exposed_copper_trapdoor", () ->
            new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()
                            .isValidSpawn((BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) -> false)));
    public static final RegistryObject<TrapDoorBlock> WEATHERED_COPPER_TRAPDOOR = BLOCKS.register("weathered_copper_trapdoor", () ->
            new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()
                            .isValidSpawn((BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) -> false)));
    public static final RegistryObject<TrapDoorBlock> OXIDIZED_COPPER_TRAPDOOR = BLOCKS.register("oxidized_copper_trapdoor", () ->
            new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()
                            .isValidSpawn((BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) -> false)));
    public static final RegistryObject<TrapDoorBlock> WAXED_COPPER_TRAPDOOR = BLOCKS.register("waxed_copper_trapdoor", () ->
            new WaxedTrapDoorBlock(BlockBehaviour.Properties.copy(COPPER_TRAPDOOR.get())));
    public static final RegistryObject<TrapDoorBlock> WAXED_EXPOSED_COPPER_TRAPDOOR = BLOCKS.register("waxed_exposed_copper_trapdoor", () ->
            new WaxedTrapDoorBlock(BlockBehaviour.Properties.copy(EXPOSED_COPPER_TRAPDOOR.get())));
    public static final RegistryObject<TrapDoorBlock> WAXED_WEATHERED_COPPER_TRAPDOOR = BLOCKS.register("waxed_weathered_copper_trapdoor", () ->
            new WaxedTrapDoorBlock(BlockBehaviour.Properties.copy(WEATHERED_COPPER_TRAPDOOR.get())));
    public static final RegistryObject<TrapDoorBlock> WAXED_OXIDIZED_COPPER_TRAPDOOR = BLOCKS.register("waxed_oxidized_copper_trapdoor", () ->
            new WaxedTrapDoorBlock(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_TRAPDOOR.get())));

    public static final RegistryObject<IronBarsBlock> COPPER_BARS = BLOCKS.register("copper_bars", () ->
            new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(4.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<WeightedPressurePlateBlock> MEDIUM_WEIGHTED_PRESSURE_PLATE = BLOCKS.register("medium_weighted_pressure_plate", () ->
            new WeightedPressurePlateBlock(60, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().noCollission().strength(0.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<StoneButtonBlock> COPPER_BUTTON = BLOCKS.register("copper_button", () ->
            new StoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_ORANGE).noCollission().strength(0.75F)));

    public static void create(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
