package net.onvoid.copperized.common;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.Optional;

public class CopperizedEvents {

    /*@SubscribeEvent
    public void playerInteract(PlayerInteractEvent e) {
        if (e.getItemStack().getItem().equals(Items.HONEYCOMB)) {
            Level level = e.getWorld();
            BlockPos blockpos = e.getPos();
            Optional<BlockState> waxed = HoneycombItem.getWaxed(level.getBlockState(blockpos));
            if (waxed.isPresent()) {
                BlockState state = waxed.get();
                Player player = e.getPlayer();
                ItemStack itemstack = e.getItemStack();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }
                itemstack.shrink(1);
                if (state.getBlock() instanceof DoorBlock) {
                    BlockPos below = blockpos.below();
                    BlockPos above = blockpos.above();
                    BlockState belowState = level.getBlockState(below);
                    BlockState aboveState = level.getBlockState(above);
                    if (aboveState.getBlock() instanceof DoorBlock && aboveState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.UPPER)) {
                        aboveState.setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER);
                        aboveState = state.getBlock().withPropertiesOf(aboveState);
                        level.setBlock(above, aboveState, 27);
                        level.setBlock(blockpos, state, 27);
                        level.levelEvent(player, 3003, blockpos, 0);
                        level.levelEvent(player, 3003, above, 0);
                        return;
                    } else if (belowState.getBlock() instanceof DoorBlock && belowState.getValue(DoorBlock.HALF).equals(DoubleBlockHalf.LOWER)) {
                        belowState.setValue(DoorBlock.HALF, DoubleBlockHalf.LOWER);
                        belowState = state.getBlock().withPropertiesOf(belowState);
                        level.setBlock(blockpos, state, 27);
                        level.setBlock(below, belowState, 27);
                        level.levelEvent(player, 3003, blockpos, 0);
                        level.levelEvent(player, 3003, below, 0);
                        return;
                    }
                }
                level.setBlock(blockpos, state, 11);
                level.levelEvent(player, 3003, blockpos, 0);
            }
        }
    }*/
}
