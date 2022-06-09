package net.onvoid.copperized.common.blocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.onvoid.copperized.common.CopperMaps;

public class WaxedTrapDoorBlock extends TrapDoorBlock {

    public WaxedTrapDoorBlock(Properties properties) {
            super(properties);
        }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().canPerformAction(toolAction) && ToolActions.AXE_WAX_OFF.equals(toolAction)) {
            var block = CopperMaps.getUnwaxed(state.getBlock());
            if (block.isPresent() && state.getBlock() instanceof WaxedTrapDoorBlock) {
                return block.map(b -> b.withPropertiesOf(state)).get();
            }
        }
        return null;
    }
}
