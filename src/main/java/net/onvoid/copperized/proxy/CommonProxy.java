package net.onvoid.copperized.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.onvoid.copperized.common.CopperizedBlocks;
import net.onvoid.copperized.common.CopperizedEvents;
import net.onvoid.copperized.common.CopperizedItems;
import net.onvoid.copperized.common.CopperizedLootModifiers;

public class CommonProxy {

    public void start() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        CopperizedBlocks.create(modBus);
        CopperizedItems.create(modBus);
        CopperizedLootModifiers.create(modBus);
        forgeBus.register(new CopperizedEvents());
    }
}
