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

    public static final RegistryObject<DoorBlock> COPPER_DOOR = BLOCKS.register("copper_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<TrapDoorBlock> COPPER_TRAPDOOR = BLOCKS.register("copper_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(4.0F).sound(SoundType.METAL).noOcclusion().isValidSpawn(CopperizedBlocks::never)));

    public static void create(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return (boolean)false;
    }
}
