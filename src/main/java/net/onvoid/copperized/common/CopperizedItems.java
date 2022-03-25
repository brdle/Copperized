package net.onvoid.copperized.common;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.onvoid.copperized.Copperized;

public class CopperizedItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Copperized.MODID);

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () ->
            new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", () ->
            new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () ->
            new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () ->
            new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", () ->
            new ArmorItem(CopperizedArmorMaterials.COPPER, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () ->
            new SwordItem(CopperizedTiers.COPPER, 3, -2.4F, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () ->
            new PickaxeItem(CopperizedTiers.COPPER, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () ->
            new AxeItem(CopperizedTiers.COPPER, 6.5F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () ->
            new HoeItem(CopperizedTiers.COPPER_HOE, -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () ->
            new ShovelItem(CopperizedTiers.COPPER, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<HorseArmorItem> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor", () ->
            new HorseArmorItem(4, "copper", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<DoubleHighBlockItem> COPPER_DOOR = ITEMS.register("copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> EXPOSED_COPPER_DOOR = ITEMS.register("exposed_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.EXPOSED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> WEATHERED_COPPER_DOOR = ITEMS.register("weathered_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.WEATHERED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> OXIDIZED_COPPER_DOOR = ITEMS.register("oxidized_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.OXIDIZED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> WAXED_COPPER_DOOR = ITEMS.register("waxed_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.WAXED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> WAXED_EXPOSED_COPPER_DOOR = ITEMS.register("waxed_exposed_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.WAXED_EXPOSED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> WAXED_WEATHERED_COPPER_DOOR = ITEMS.register("waxed_weathered_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.WAXED_WEATHERED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<DoubleHighBlockItem> WAXED_OXIDIZED_COPPER_DOOR = ITEMS.register("waxed_oxidized_copper_door", () ->
            new DoubleHighBlockItem(CopperizedBlocks.WAXED_OXIDIZED_COPPER_DOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> COPPER_TRAPDOOR = ITEMS.register("copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> EXPOSED_COPPER_TRAPDOOR = ITEMS.register("exposed_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.EXPOSED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WEATHERED_COPPER_TRAPDOOR = ITEMS.register("weathered_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.WEATHERED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> OXIDIZED_COPPER_TRAPDOOR = ITEMS.register("oxidized_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.OXIDIZED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_COPPER_TRAPDOOR = ITEMS.register("waxed_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.WAXED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_COPPER_TRAPDOOR = ITEMS.register("waxed_exposed_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_COPPER_TRAPDOOR = ITEMS.register("waxed_weathered_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_COPPER_TRAPDOOR = ITEMS.register("waxed_oxidized_copper_trapdoor", () ->
            new BlockItem(CopperizedBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("exposed_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("weathered_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("oxidized_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("waxed_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("waxed_exposed_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("waxed_weathered_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = ITEMS.register("waxed_oxidized_medium_weighted_pressure_plate", () ->
            new BlockItem(CopperizedBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> COPPER_BUTTON = ITEMS.register("copper_button", () ->
            new BlockItem(CopperizedBlocks.COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> EXPOSED_COPPER_BUTTON = ITEMS.register("exposed_copper_button", () ->
            new BlockItem(CopperizedBlocks.EXPOSED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WEATHERED_COPPER_BUTTON = ITEMS.register("weathered_copper_button", () ->
            new BlockItem(CopperizedBlocks.WEATHERED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> OXIDIZED_COPPER_BUTTON = ITEMS.register("oxidized_copper_button", () ->
            new BlockItem(CopperizedBlocks.OXIDIZED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_COPPER_BUTTON = ITEMS.register("waxed_copper_button", () ->
            new BlockItem(CopperizedBlocks.WAXED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_COPPER_BUTTON = ITEMS.register("waxed_exposed_copper_button", () ->
            new BlockItem(CopperizedBlocks.WAXED_EXPOSED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_COPPER_BUTTON = ITEMS.register("waxed_weathered_copper_button", () ->
            new BlockItem(CopperizedBlocks.WAXED_WEATHERED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_COPPER_BUTTON = ITEMS.register("waxed_oxidized_copper_button", () ->
            new BlockItem(CopperizedBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> COPPER_BARS = ITEMS.register("copper_bars", () ->
            new BlockItem(CopperizedBlocks.COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> EXPOSED_COPPER_BARS = ITEMS.register("exposed_copper_bars", () ->
            new BlockItem(CopperizedBlocks.EXPOSED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> WEATHERED_COPPER_BARS = ITEMS.register("weathered_copper_bars", () ->
            new BlockItem(CopperizedBlocks.WEATHERED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> OXIDIZED_COPPER_BARS = ITEMS.register("oxidized_copper_bars", () ->
            new BlockItem(CopperizedBlocks.OXIDIZED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> WAXED_COPPER_BARS = ITEMS.register("waxed_copper_bars", () ->
            new BlockItem(CopperizedBlocks.WAXED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_COPPER_BARS = ITEMS.register("waxed_exposed_copper_bars", () ->
            new BlockItem(CopperizedBlocks.WAXED_EXPOSED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_COPPER_BARS = ITEMS.register("waxed_weathered_copper_bars", () ->
            new BlockItem(CopperizedBlocks.WAXED_WEATHERED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_COPPER_BARS = ITEMS.register("waxed_oxidized_copper_bars", () ->
            new BlockItem(CopperizedBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));

    public static void create(IEventBus bus) {
        ITEMS.register(bus);
    }
}
