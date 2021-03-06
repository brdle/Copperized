package net.onvoid.copperized.common;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EnchantedChanceItemLootModifier extends LootModifier {
    private final Item item;
    private final Enchantment enchantment;
    private final int level;
    private final double chance;
    private final boolean unique;

    public EnchantedChanceItemLootModifier(LootItemCondition[] conditions, Item item, Enchantment enchantment, int level, double chance, boolean unique) {
        super(conditions);
        this.item = item;
        this.enchantment = enchantment;
        this.level = level;
        this.chance = chance;
        this.unique = unique;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (this.unique) {
            if (generatedLoot.stream().anyMatch(stack -> stack.getItem().equals(this.item))) {
                return generatedLoot;
            }
        }
        if (new Random().nextDouble(1.0) <= this.chance) {
            ItemStack enchantedItem = new ItemStack(this.item, 1);
            EnchantmentHelper.setEnchantments(Map.of(this.enchantment, this.level), enchantedItem);
            generatedLoot.add(enchantedItem);
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<EnchantedChanceItemLootModifier> {

        @Override
        public EnchantedChanceItemLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditions) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation((GsonHelper.getAsString(object, "item"))));
            Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "enchantment")));
            int level = GsonHelper.getAsInt(object, "level");
            double chance = GsonHelper.getAsDouble(object, "chance");
            boolean unique = GsonHelper.getAsBoolean(object, "unique");
            return new EnchantedChanceItemLootModifier(conditions, item, enchantment, level, chance, unique);
        }

        @Override
        public JsonObject write(EnchantedChanceItemLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            json.addProperty("enchantment", ForgeRegistries.ENCHANTMENTS.getKey(instance.enchantment).toString());
            json.addProperty("level", instance.level);
            json.addProperty("chance", instance.chance);
            json.addProperty("unique", instance.unique);
            return json;
        }
    }
}