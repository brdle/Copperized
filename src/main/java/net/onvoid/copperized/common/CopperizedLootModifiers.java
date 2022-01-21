package net.onvoid.copperized.common;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.copperized.Copperized;

public class CopperizedLootModifiers {

    private static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Copperized.MODID);

    public static final RegistryObject<ChanceItemLootModifier.Serializer> CHANCE_ITEM = LOOT_MODIFIERS.register("chance_item",
            ChanceItemLootModifier.Serializer::new);

    public static final RegistryObject<UnbreakingChanceItemLootModifier.Serializer> UNBREAKING_CHANCE_ITEM = LOOT_MODIFIERS.register("unbreaking_chance_item",
            UnbreakingChanceItemLootModifier.Serializer::new);

    public static void create(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }

}
