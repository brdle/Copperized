package net.onvoid.copperized.common;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.HoeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.copperized.common.CopperizedArmorMaterials;
import net.onvoid.copperized.common.CopperizedTiers;

public class CopperizedItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, net.onvoid.copperized.Copperized.MODID);

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () ->
            new Item((new Item.Properties())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food((new FoodProperties.Builder())
                            .nutrition(4)
                            .saturationMod(0.3F).build())));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () ->
            new Item((new Item.Properties())
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food((new FoodProperties.Builder())
                            .nutrition(4)
                            .saturationMod(0.3F).build())));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_LEGGINGSS = ITEMS.register("copper_leggings", () -> new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CopperizedTiers.COPPER, 0, -2.4F, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CopperizedTiers.COPPER, -2, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CopperizedTiers.COPPER, 2.0F, -3.2F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(CopperizedTiers.COPPER, -2, 0.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CopperizedTiers.COPPER, -1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<HorseArmorItem> HORSE_ARMOR_COPPER = ITEMS.register("copper_horse_armor", () -> new HorseArmorItem(3, "copper", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));


    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
