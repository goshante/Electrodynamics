package electrodynamics.datagen.server.recipe.types.custom.item2item;

import java.util.function.Consumer;

import electrodynamics.api.References;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.item.subtype.SubtypeNugget;
import electrodynamics.common.recipe.ElectrodynamicsRecipeInit;
import electrodynamics.common.recipe.recipeutils.ProbableItem;
import electrodynamics.common.tags.ElectrodynamicsTags;
import electrodynamics.datagen.utils.recipe.AbstractElectrodynamicsFinishedRecipe.RecipeCategory;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.FinishedRecipeItemOutput;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

public class ElectrodynamicsWireMillRecipes extends AbstractRecipeGenerator {

	public static double WIREMILL_USAGE_PER_TICK = 125.0;
	public static int WIREMILL_REQUIRED_TICKS = 200;

	private final String modID;

	public ElectrodynamicsWireMillRecipes(String modID) {
		this.modID = modID;
	}

	public ElectrodynamicsWireMillRecipes() {
		this(References.ID);
	}

	private static ItemStack makeItemStack(Item item, int count)
	{
		ItemStack stack = new ItemStack(item);
		stack.setCount(count);
		return stack;
	}

	@Override
	public void addRecipes(Consumer<FinishedRecipe> consumer) {

		newRecipe(makeItemStack(WIRES[SubtypeWire.copper.ordinal()], 4), 0.1F, 200, 125.0, "copper_wire_from_ingot")
				//
				.addItemTagInput(Tags.Items.INGOTS_COPPER, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(ElectrodynamicsItems.getItem(SubtypeNugget.copper)), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(WIRES[SubtypeWire.gold.ordinal()], 4), 0.2F, 200, 125.0, "gold_wire_from_ingot")
				//
				.addItemTagInput(Tags.Items.INGOTS_GOLD, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(Items.GOLD_NUGGET), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(WIRES[SubtypeWire.iron.ordinal()], 4), 0.1F, 200, 125.0, "iron_wire_from_ingot")
				//
				.addItemTagInput(Tags.Items.INGOTS_IRON, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(Items.IRON_NUGGET), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(WIRES[SubtypeWire.silver.ordinal()], 4), 0.1F, 200, 125.0, "silver_wire_from_ingot")
				//
				.addItemTagInput(ElectrodynamicsTags.Items.INGOT_SILVER, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(ElectrodynamicsItems.getItem(SubtypeNugget.silver)), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(WIRES[SubtypeWire.superconductive.ordinal()], 4), 0.1F, 200, 125.0, "superconductive_wire_from_ingot")
				//
				.addItemTagInput(ElectrodynamicsTags.Items.INGOT_SUPERCONDUCTIVE, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(ElectrodynamicsItems.getItem(SubtypeNugget.superconductive)), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(WIRES[SubtypeWire.tin.ordinal()], 4), 0.1F, 200, 125.0, "tin_wire_from_ingot")
				//
				.addItemTagInput(ElectrodynamicsTags.Items.INGOT_TIN, 1)
				//
				.addItemBiproduct(new ProbableItem(new ItemStack(ElectrodynamicsItems.getItem(SubtypeNugget.tin)), 1))
				//
				.complete(consumer);

		newRecipe(makeItemStack(ElectrodynamicsItems.ITEM_TITANIUM_COIL.get(), 1), 0.1F, 200, 125.0, "titanium_coil")
				//
				.addItemTagInput(ElectrodynamicsTags.Items.INGOT_TITANIUM, 9)
				//
				.complete(consumer);

	}

	public FinishedRecipeItemOutput newRecipe(ItemStack stack, float xp, int ticks, double usagePerTick, String name) {
		return FinishedRecipeItemOutput.of(ElectrodynamicsRecipeInit.WIRE_MILL_SERIALIZER.get(), stack, xp, ticks, usagePerTick).name(RecipeCategory.ITEM_2_ITEM, modID, "wire_mill/" + name);
	}

}
