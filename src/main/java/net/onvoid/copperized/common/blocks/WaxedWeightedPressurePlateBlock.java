package net.onvoid.copperized.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.onvoid.copperized.common.CopperMaps;

public class WaxedWeightedPressurePlateBlock extends WeightedPressurePlateBlock {

    public WaxedWeightedPressurePlateBlock(Properties properties) {
            super(60, properties);
        }

    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
        if (stack.canPerformAction(toolAction) && ToolActions.AXE_WAX_OFF.equals(toolAction)) {
            var block = CopperMaps.getUnwaxed(state.getBlock());
            if (block.isPresent() && state.getBlock() instanceof WaxedWeightedPressurePlateBlock) {
                return block.map(b -> b.withPropertiesOf(state)).get();
            }
        }
        return null;
    }
}
