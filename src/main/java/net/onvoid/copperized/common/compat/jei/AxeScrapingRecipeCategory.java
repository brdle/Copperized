package net.onvoid.copperized.common.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.onvoid.copperized.Copperized;
import net.onvoid.copperized.common.CopperizedItems;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AxeScrapingRecipeCategory implements IRecipeCategory<AxeScrapingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "axe_scraping");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawable icon;

    public AxeScrapingRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(CopperizedJEIPlugin.GUI_TEXTURE, 0, 36, 70, 18);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(CopperizedItems.COPPER_AXE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends AxeScrapingRecipe> getRecipeClass() {
        return AxeScrapingRecipe.class;
    }

    @Override
    @Deprecated
    public Component getTitle() {
        return new TranslatableComponent("jei." + Copperized.MODID + ".axe_scraping");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setIngredients(AxeScrapingRecipe recipe, IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, recipe.getInput());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout layout, AxeScrapingRecipe recipe, IIngredients ingredients) {
        var guiItemStacks = layout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 52, 0);
        guiItemStacks.set(ingredients);
        guiItemStacks.init(2, true, 26, 0);
        guiItemStacks.set(2, ItemTags
                .createOptional(new ResourceLocation("forge", "tools/axes"))
                .getValues()
                .stream()
                .map(ItemStack::new)
                .collect(Collectors.toList()));
    }

    /*@Override
    public List<Component> getTooltipStrings(AxeScrapingRecipe recipe, double mouseX, double mouseY) {
        return Collections.emptyList();
    }*/
}