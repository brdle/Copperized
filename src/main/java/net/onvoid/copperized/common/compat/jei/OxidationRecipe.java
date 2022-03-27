package net.onvoid.copperized.common.compat.jei;

import net.minecraft.world.item.ItemStack;

public class OxidationRecipe {
    private final ItemStack input;
    private final ItemStack output;

    public OxidationRecipe(ItemStack input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public ItemStack getInput() {
        return this.input;
    }

    public ItemStack getOutput() {
        return this.output;
    }
}