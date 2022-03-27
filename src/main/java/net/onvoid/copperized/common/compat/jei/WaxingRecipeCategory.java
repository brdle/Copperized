package net.onvoid.copperized.common.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.onvoid.copperized.Copperized;
import javax.annotation.Nonnull;

public class WaxingRecipeCategory implements IRecipeCategory<WaxingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "waxing");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawable icon;

    public WaxingRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(CopperizedJEIPlugin.GUI_TEXTURE, 0, 18, 70, 18);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(Items.HONEYCOMB));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends WaxingRecipe> getRecipeClass() {
        return WaxingRecipe.class;
    }

    @Override
    @Deprecated
    public Component getTitle() {
        return new TranslatableComponent("jei." + Copperized.MODID + ".waxing");
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
    public void setIngredients(WaxingRecipe recipe, IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, recipe.getInput());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout layout, WaxingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = layout.getItemStacks();
        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, false, 52, 0);
        guiItemStacks.set(ingredients);
    }

    /*@Override
    public List<Component> getTooltipStrings(WaxingRecipe recipe, double mouseX, double mouseY) {
        return Collections.emptyList();
    }*/
}