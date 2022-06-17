package net.onvoid.copperized.common.compat.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.onvoid.copperized.Copperized;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;

public class WaxingRecipeCategory implements IRecipeCategory<WaxingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "waxing");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawable icon;

    public WaxingRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(CopperizedJEIPlugin.GUI_TEXTURE, 0, 18, 70, 18);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.HONEYCOMB));
    }

    @Override
    public @NotNull RecipeType<WaxingRecipe> getRecipeType() {
        return CopperizedJEIPlugin.WAXING;
    }

    @Override
    @Deprecated
    public @NotNull Component getTitle() {
        return Component.translatable("jei." + Copperized.MODID + ".waxing");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WaxingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 53, 1)
                .addItemStack(recipe.getOutput());
    }
}