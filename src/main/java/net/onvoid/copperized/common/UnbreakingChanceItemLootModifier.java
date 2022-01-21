package net.onvoid.copperized.common;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UnbreakingChanceItemLootModifier extends LootModifier {
    private final Item item;
    private final double chance;

    public UnbreakingChanceItemLootModifier(LootItemCondition[] conditions, Item item, double chance) {
        super(conditions);
        this.item = item;
        this.chance = chance;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        Random rand = new Random();
        if (rand.nextDouble(1.0) <= this.chance) {
            ItemStack enchantedItem = new ItemStack(this.item, 1);
            EnchantmentHelper.setEnchantments(Map.of(Enchantments.UNBREAKING, 2), enchantedItem);
            generatedLoot.add(enchantedItem);
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<UnbreakingChanceItemLootModifier> {

        @Override
        public UnbreakingChanceItemLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditions) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation((GsonHelper.getAsString(object, "item"))));
            double chance = GsonHelper.getAsDouble(object, "chance");
            return new UnbreakingChanceItemLootModifier(conditions, item, chance);
        }

        @Override
        public JsonObject write(UnbreakingChanceItemLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            json.addProperty("chance", instance.chance);
            return json;
        }
    }
}