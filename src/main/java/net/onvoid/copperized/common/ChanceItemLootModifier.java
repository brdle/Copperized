package net.onvoid.copperized.common;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class ChanceItemLootModifier extends LootModifier {
    private final Item item;
    private final double chance;
    private final int minAmount;
    private final int maxAmount;

    public ChanceItemLootModifier(LootItemCondition[] conditions, Item item, double chance, int minAmount, int maxAmount) {
        super(conditions);
        this.item = item;
        this.chance = chance;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        Random rand = new Random();
        if (rand.nextDouble(1.0) <= this.chance) {
            int amount = rand.nextInt(this.maxAmount + 1 - this.minAmount) + this.minAmount;
            generatedLoot.add(new ItemStack(this.item, amount));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ChanceItemLootModifier> {

        @Override
        public ChanceItemLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditions) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation((GsonHelper.getAsString(object, "item"))));
            double chance = GsonHelper.getAsDouble(object, "chance");
            int minAmount = GsonHelper.getAsInt(object, "minAmount");
            int maxAmount = GsonHelper.getAsInt(object, "maxAmount");
            return new ChanceItemLootModifier(conditions, item, chance, minAmount, maxAmount);
        }

        @Override
        public JsonObject write(ChanceItemLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            json.addProperty("chance", instance.chance);
            json.addProperty("minAmount", instance.minAmount);
            json.addProperty("maxAmount", instance.maxAmount);
            return json;
        }
    }
}