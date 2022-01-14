package net.onvoid.simplicity.common;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.Random;

public class EventHandler {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void biomeLoading(BlockEvent.BreakEvent e) {
        if (!e.getWorld().isClientSide() && !e.isCanceled()) {
            if (BlockTags.LEAVES.contains(e.getState().getBlock()) &&
                    (e.getWorld().getBiome(e.getPos()).getBiomeCategory() == Biome.BiomeCategory.PLAINS ||
                            e.getWorld().getBiome(e.getPos()).getBiomeCategory() == Biome.BiomeCategory.FOREST)
                                    && new Random().nextInt(5) == 0) {
                                        Item drop;
                                        if (new Random().nextBoolean()) {
                                            drop = SimplicityItems.ORANGE.get();
                                        } else {
                                            drop = SimplicityItems.BANANA.get();
                                        }
                                        Level level = e.getPlayer().getLevel();
                                        level.addFreshEntity(new ItemEntity(level,
                                                (double) e.getPos().getX(),
                                                (double) e.getPos().getY() + 0.1,
                                                (double) e.getPos().getZ(),
                                                new ItemStack(drop)));
            }
        }
    }
}
