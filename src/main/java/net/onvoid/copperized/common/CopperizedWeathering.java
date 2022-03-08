package net.onvoid.copperized.common;

import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Optional;

public interface CopperizedWeathering extends WeatheringCopper {
    @Override
    default Optional<BlockState> getNext(BlockState state) {
        return CopperMaps.getNext(state.getBlock()).map((next) -> next.withPropertiesOf(state));
    }
}
