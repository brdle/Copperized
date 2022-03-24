package net.onvoid.copperized.common.blocks;

import java.util.Optional;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.onvoid.copperized.common.CopperMaps;
import net.onvoid.copperized.common.CopperizedWeathering;

public class WeatheringCopperDoorBlock extends DoorBlock implements CopperizedWeathering {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperDoorBlock(WeatheringCopper.WeatherState pWeatherState, BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = pWeatherState;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        this.onRandomTick(pState, pLevel, pPos, pRandom);
    }

    /**
     * @return whether this block needs random ticking.
     */
    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return Optional.ofNullable(CopperMaps.NEXT_BY_BLOCK.get().get(pState.getBlock())).isPresent();
    }

    /**
     * @return the weather state of this block.
     */
    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        var stack = player.getItemInHand(hand);
        if (stack.getItem() == Items.HONEYCOMB) {
            var block = CopperMaps.getWaxed(state.getBlock());
            if (block.isPresent() && state.getBlock() instanceof WeatheringCopperDoorBlock) {
                var below = pos.below();
                var above = pos.above();
                var belowState = world.getBlockState(below);
                var aboveState = world.getBlockState(above);
                if (world.isLoaded(above) && aboveState.getBlock() instanceof WeatheringCopperDoorBlock && aboveState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                    world.setBlock(above, block.map(b -> b.withPropertiesOf(aboveState)).get(), 27);
                    world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 27);
                    world.levelEvent(player, 3003, pos, 0);
                    world.levelEvent(player, 3003, above, 0);
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                } else if (world.isLoaded(below) && belowState.getBlock() instanceof WeatheringCopperDoorBlock && belowState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.LOWER)) {
                    world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 27);
                    world.setBlock(below, block.map(b -> b.withPropertiesOf(belowState)).get(), 27);
                    world.levelEvent(player, 3003, pos, 0);
                    world.levelEvent(player, 3003, below, 0);
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.PASS;
            }
            world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 11);
            world.levelEvent(player, 3003, pos, 0);
            stack.shrink(1);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
        if (!stack.canPerformAction(toolAction) || !ToolActions.AXE_SCRAPE.equals(toolAction)) {
            return null;
        }
        var block = CopperMaps.getPrevious(state.getBlock());
        if (block.isPresent() && state.getBlock() instanceof WeatheringCopperDoorBlock) {
            var below = pos.below();
            var above = pos.above();
            var belowState = world.getBlockState(below);
            var aboveState = world.getBlockState(above);
            var newState = block.map(b -> b.withPropertiesOf(state)).get();
            if (world.isLoaded(above) && aboveState.getBlock() instanceof WeatheringCopperDoorBlock && aboveState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                world.setBlock(above, block.map(b -> b.withPropertiesOf(aboveState)).get(), 27);
                world.levelEvent(player, 3005, above, 0);
                stack.shrink(1);
                return newState;
            } else if (world.isLoaded(below) && belowState.getBlock() instanceof WeatheringCopperDoorBlock && belowState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.LOWER)) {
                world.setBlock(below, block.map(b -> b.withPropertiesOf(belowState)).get(), 27);
                world.levelEvent(player, 3005, below, 0);
                stack.shrink(1);
                return newState;
            }
            return newState;
        }
        return null;
    }

    @Override
    public void applyChangeOverTime(BlockState state, ServerLevel world, BlockPos pos, Random pRandom) {
        int i = this.getAge().ordinal();
        int j = 0;
        int k = 0;
        for (var blockpos : BlockPos.withinManhattan(pos, 4, 4, 4)) {
            int l = blockpos.distManhattan(pos);
            if (l > 4) {
                break;
            }
            if (!blockpos.equals(pos)) {
                var blockstate = world.getBlockState(blockpos);
                var block = blockstate.getBlock();
                if (block instanceof ChangeOverTimeBlock && !(block instanceof WeatheringCopperDoorBlock)) {
                    var oenum = ((ChangeOverTimeBlock)block).getAge();
                    if (this.getAge().getClass() == oenum.getClass()) {
                        int i1 = oenum.ordinal();
                        if (i1 < i) {
                            return;
                        }
                        if (i1 > i) {
                            ++k;
                        } else {
                            ++j;
                        }
                    }
                }
            }
        }
        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        if (pRandom.nextFloat() < f1) {
            var block = CopperMaps.getNext(state.getBlock());
            if (block.isPresent()) {
                var below = pos.below();
                var above = pos.above();
                var belowState = world.getBlockState(below);
                var aboveState = world.getBlockState(above);
                var newState = block.map(b -> b.withPropertiesOf(state)).get();
                if (world.isLoaded(above) && aboveState.getBlock() instanceof WeatheringCopperDoorBlock && aboveState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                    world.setBlock(above, block.map(b -> b.withPropertiesOf(aboveState)).get(), 27);
                    world.setBlock(pos, newState, 27);
                } else if (world.isLoaded(below) && belowState.getBlock() instanceof WeatheringCopperDoorBlock && belowState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.LOWER)) {
                    world.setBlock(below, block.map(b -> b.withPropertiesOf(belowState)).get(), 27);
                    world.setBlock(pos, newState, 27);
                }
            }
        }
    }
}