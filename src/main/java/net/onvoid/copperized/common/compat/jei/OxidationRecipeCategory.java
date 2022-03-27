package net.onvoid.copperized.common.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.onvoid.copperized.Copperized;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;

public class OxidationRecipeCategory implements IRecipeCategory<OxidationRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "oxidation");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawable icon;

    public OxidationRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(CopperizedJEIPlugin.GUI_TEXTURE, 0, 0, 70, 18);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(Items.RAW_COPPER));
    }

    @Override
    public @NotNull ResourceLocation getUid() {
        return UID;
    }

    @Override
    public @NotNull Class<? extends OxidationRecipe> getRecipeClass() {
        return OxidationRecipe.class;
    }

    @Override
    @Deprecated
    public @NotNull Component getTitle() {
        return new TranslatableComponent("jei." + Copperized.MODID + ".oxidation");
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
    public void setRecipe(IRecipeLayoutBuilder builder, OxidationRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 53, 1)
                .addItemStack(recipe.getOutput());
    }
}