package net.onvoid.copperized.common.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagManager;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.onvoid.copperized.Copperized;
import net.onvoid.copperized.common.CopperizedItems;
import org.checkerframework.checker.guieffect.qual.UI;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class AxeScrapingRecipeCategory implements IRecipeCategory<AxeScrapingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "axe_scraping");
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final IDrawable icon;

    public AxeScrapingRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(CopperizedJEIPlugin.GUI_TEXTURE, 0, 36, 70, 18);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(CopperizedItems.COPPER_AXE.get()));
    }

    @Override
    public @NotNull RecipeType<AxeScrapingRecipe> getRecipeType() {
        return CopperizedJEIPlugin.AXE_SCRAPING;
    }

    @SuppressWarnings("removal")
    @Override
    public @NotNull ResourceLocation getUid() {
        return getRecipeType().getUid();
    }

    @SuppressWarnings("removal")
    @Override
    public @NotNull Class<? extends AxeScrapingRecipe> getRecipeClass() {
        return getRecipeType().getRecipeClass();
    }

    @Override
    public @NotNull Component getTitle() {
        return new TranslatableComponent("jei." + Copperized.MODID + ".axe_scraping");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AxeScrapingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 53, 1)
                .addItemStack(recipe.getOutput());
        builder.addSlot(RecipeIngredientRole.CATALYST, 27, 1)
                .addItemStacks(Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                        .getTag(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "tools/axes")))
                        .stream()
                        .map(ItemStack::new)
                        .collect(Collectors.toList())
                );
    }
}