package net.onvoid.copperized.proxy;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.onvoid.copperized.common.CopperizedBlocks;

public class ClientProxy extends CommonProxy {

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void registerListeners(){
        super.registerListeners();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modBus.addListener(this::setupClient);
        modBus.addListener(this::loadComplete);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void setupClient(FMLClientSetupEvent e){
        ItemBlockRenderTypes.setRenderLayer(CopperizedBlocks.COPPER_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CopperizedBlocks.COPPER_TRAPDOOR.get(), RenderType.cutout());
        return;
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void loadComplete(FMLLoadCompleteEvent e){
        return;
    }
}
