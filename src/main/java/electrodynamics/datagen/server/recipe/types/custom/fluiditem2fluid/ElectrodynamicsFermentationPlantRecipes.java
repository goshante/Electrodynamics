package electrodynamics.datagen.server.recipe.types.custom.fluiditem2fluid;

import java.util.function.Consumer;

import electrodynamics.api.References;
import electrodynamics.common.recipe.ElectrodynamicsRecipeInit;
import electrodynamics.datagen.utils.recipe.AbstractElectrodynamicsFinishedRecipe.RecipeCategory;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.FinishedRecipeFluidOutput;
import electrodynamics.registers.ElectrodynamicsFluids;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidStack;

public class ElectrodynamicsFermentationPlantRecipes extends AbstractRecipeGenerator {

	public static double FERMENTATIONPLANT_USAGE_PER_TICK = 20.0;
	public static int FERMENTATIONPLANT_REQUIRED_TICKS = 2000;

	public static int DefaultTPS = 20;

	public static float TicksToTime(int ticks)
	{
		float tpsTime = 1.0f / DefaultTPS;
		return ticks * tpsTime;
	}

	public static int TimeToTicks(float time)
	{
		float tpsTime = 1.0f / DefaultTPS;
		return Math.round(time / tpsTime);
	}

	private final String modID;

	public ElectrodynamicsFermentationPlantRecipes(String modID) {
		this.modID = modID;
	}

	public ElectrodynamicsFermentationPlantRecipes() {
		this(References.ID);
	}

	@Override
	public void addRecipes(Consumer<FinishedRecipe> consumer) {

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 200), 0, TimeToTicks(10), 10.0, "ethanol_from_carrots")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemTagInput(Tags.Items.CROPS_CARROT, 9)
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 300), 0, TimeToTicks(10), 10.0, "ethanol_from_melon_slices")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemStackInput(new ItemStack(Items.MELON_SLICE, 4))
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 150), 0, TimeToTicks(20), 10.0, "ethanol_from_mushrooms")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemTagInput(Tags.Items.MUSHROOMS, 9)
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 400), 0, TimeToTicks(8), 10.0, "ethanol_from_potatos")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemTagInput(Tags.Items.CROPS_POTATO, 7)
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 100), 0, TimeToTicks(17.5f), 10.0, "ethanol_from_pumpkins")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemStackInput(new ItemStack(Items.PUMPKIN, 12))
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 300), 0, TimeToTicks(10), 10.0, "ethanol_from_seeds")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemTagInput(Tags.Items.SEEDS, 20)
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 500), 0, TimeToTicks(17.5f), 10.0, "ethanol_from_sugar_cane")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemStackInput(new ItemStack(Items.SUGAR_CANE, 6))
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 1000), 0, TimeToTicks(15), 10.0, "ethanol_from_sugar")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemStackInput(new ItemStack(Items.SUGAR, 3))
				//
				.complete(consumer);

		newRecipe(new FluidStack(ElectrodynamicsFluids.fluidEthanol, 300), 0, TimeToTicks(8), 10.0, "ethanol_from_wheat")
				//
				.addFluidTagInput(FluidTags.WATER, 1000)
				//
				.addItemTagInput(Tags.Items.CROPS_WHEAT, 9)
				//
				.complete(consumer);

	}

	public FinishedRecipeFluidOutput newRecipe(FluidStack stack, float xp, int ticks, double usagePerTick, String name) {
		return FinishedRecipeFluidOutput.of(ElectrodynamicsRecipeInit.FERMENTATION_PLANT_SERIALIZER.get(), stack, xp, ticks, usagePerTick).name(RecipeCategory.FLUID_ITEM_2_FLUID, modID, "fermentation_plant/" + name);
	}

}
