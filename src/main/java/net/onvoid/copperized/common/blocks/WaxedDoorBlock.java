package net.onvoid.copperized.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.onvoid.copperized.common.CopperMaps;

public class WaxedDoorBlock extends DoorBlock {
    public WaxedDoorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
        if (!stack.canPerformAction(toolAction) || !ToolActions.AXE_WAX_OFF.equals(toolAction)) {
            return null;
        }
        var block = CopperMaps.getUnwaxed(state.getBlock());
        if (block.isPresent() && state.getBlock() instanceof WaxedDoorBlock) {
            var below = pos.below();
            var above = pos.above();
            var belowState = world.getBlockState(below);
            var aboveState = world.getBlockState(above);
            var newState = block.map(b -> b.withPropertiesOf(state)).get();
            if (world.isLoaded(above) && aboveState.getBlock() instanceof WaxedDoorBlock && aboveState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                world.setBlock(above, block.map(b -> b.withPropertiesOf(aboveState)).get(), 27);
                world.levelEvent(player, 3004, above, 0);
                stack.shrink(1);
                return newState;
            } else if (world.isLoaded(below) && belowState.getBlock() instanceof WaxedDoorBlock && belowState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.LOWER)) {
                world.setBlock(below, block.map(b -> b.withPropertiesOf(belowState)).get(), 27);
                world.levelEvent(player, 3004, below, 0);
                stack.shrink(1);
                return newState;
            }
            stack.shrink(1);
            return newState;
        }
        return null;
    }
}
