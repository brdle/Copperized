package net.onvoid.copperized.common.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.onvoid.copperized.Copperized;
import net.onvoid.copperized.common.CopperMaps;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

@JeiPlugin
public class CopperizedJEIPlugin implements IModPlugin {
    private static final ResourceLocation UID = new ResourceLocation(Copperized.MODID, "jei");
    public static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Copperized.MODID, "textures/jei/gui.png");
    private static final ArrayList<OxidationRecipe> oxidationRecipes = new ArrayList<>();
    private static final ArrayList<WaxingRecipe> waxingRecipes = new ArrayList<>();
    private static final ArrayList<AxeScrapingRecipe> axeScrapingRecipes = new ArrayList<>();

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        IModPlugin.super.registerCategories(registration);
        registration.addRecipeCategories(new OxidationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new WaxingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new AxeScrapingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        IModPlugin.super.registerRecipes(registration);

        // Oxidation
        WeatheringCopper.NEXT_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                oxidationRecipes.add(new OxidationRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        CopperMaps.NEXT_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                oxidationRecipes.add(new OxidationRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        registration.addRecipes(oxidationRecipes, OxidationRecipeCategory.UID);

        // Waxing
        HoneycombItem.WAXABLES.get().forEach((Block blockFrom, Block blockTo) ->
                waxingRecipes.add(new WaxingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        CopperMaps.WAXABLES.get().forEach((Block blockFrom, Block blockTo) ->
                waxingRecipes.add(new WaxingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        registration.addRecipes(waxingRecipes, WaxingRecipeCategory.UID);

        // Axe Scraping
        HoneycombItem.WAX_OFF_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                axeScrapingRecipes.add(new AxeScrapingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        CopperMaps.WAX_OFF_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                axeScrapingRecipes.add(new AxeScrapingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        WeatheringCopper.PREVIOUS_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                axeScrapingRecipes.add(new AxeScrapingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        CopperMaps.PREVIOUS_BY_BLOCK.get().forEach((Block blockFrom, Block blockTo) ->
                axeScrapingRecipes.add(new AxeScrapingRecipe(new ItemStack(blockFrom), new ItemStack(blockTo))));
        registration.addRecipes(axeScrapingRecipes, AxeScrapingRecipeCategory.UID);
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(new ItemStack(Items.HONEYCOMB), WaxingRecipeCategory.UID);
    }
}