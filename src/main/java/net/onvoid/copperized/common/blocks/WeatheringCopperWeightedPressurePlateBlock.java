package net.onvoid.copperized.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.onvoid.copperized.common.CopperMaps;
import net.onvoid.copperized.common.CopperizedWeathering;

import java.util.Optional;
import java.util.Random;

public class WeatheringCopperWeightedPressurePlateBlock extends WeightedPressurePlateBlock implements CopperizedWeathering {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperWeightedPressurePlateBlock(WeatheringCopper.WeatherState pWeatherState, Properties properties) {
        super(60, properties);
        this.weatherState = pWeatherState;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    public void onRandomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
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
            if (block.isPresent() && state.getBlock() instanceof WeatheringCopperWeightedPressurePlateBlock) {
                world.setBlockAndUpdate(pos, block.map(b -> b.withPropertiesOf(state)).get());
                world.levelEvent(player, 3003, pos, 0);
                if (!world.isClientSide()) {
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().canPerformAction(toolAction) && ToolActions.AXE_SCRAPE.equals(toolAction)) {
            var block = CopperMaps.getPrevious(state.getBlock());
            if (block.isPresent() && state.getBlock() instanceof WeatheringCopperWeightedPressurePlateBlock) {
                return block.map(b -> b.withPropertiesOf(state)).get();
            }
        }
        return null;
    }
}
