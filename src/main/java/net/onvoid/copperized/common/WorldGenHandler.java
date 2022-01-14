package net.onvoid.simplicity.common;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WorldGenHandler {
    public static PlacedFeature PATCH_PINEAPPLE_BUSH;
    public static PlacedFeature PATCH_PINEAPPLE_SPARSE;
    public static PlacedFeature PATCH_PINEAPPLE_DECORATED;

    @SubscribeEvent (priority = EventPriority.NORMAL)
    public void biomeLoading(BiomeLoadingEvent e){
        // PINEAPPLE GENERATION
        if (e.getCategory().equals(Biome.BiomeCategory.JUNGLE)){
            e.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PATCH_PINEAPPLE_BUSH);
            e.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PATCH_PINEAPPLE_SPARSE);
            e.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PATCH_PINEAPPLE_DECORATED);
        }
    }
}
