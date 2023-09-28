package electrodynamics.prefab.screen.component.types;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import electrodynamics.common.tile.pipelines.fluids.TileFluidPipeFilter;
import electrodynamics.prefab.inventory.container.GenericContainerBlockEntity;
import electrodynamics.prefab.properties.Property;
import electrodynamics.prefab.screen.GenericScreen;
import electrodynamics.prefab.screen.component.types.gauges.AbstractScreenComponentGauge.GaugeTextures;
import electrodynamics.prefab.utilities.CapabilityUtils;
import electrodynamics.prefab.utilities.RenderingUtils;
import electrodynamics.prefab.utilities.math.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class ScreenComponentFluidFilter extends ScreenComponentGeneric {

	private final int index;

	public ScreenComponentFluidFilter(int x, int y, int index) {
		super(GaugeTextures.BACKGROUND_DEFAULT, x, y);
		this.index = index;
	}

	@Override
	public void renderBackground(GuiGraphics graphics, int xAxis, int yAxis, int guiWidth, int guiHeight) {
		super.renderBackground(graphics, xAxis, yAxis, guiWidth, guiHeight);

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) ((GenericScreen<?>) gui).getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		FluidStack fluid = property.get();

		if (!fluid.isEmpty()) {

			ResourceLocation fluidText = IClientFluidTypeExtensions.of(fluid.getFluid()).getStillTexture();

			if (fluidText != null) {

				ResourceLocation blocks = InventoryMenu.BLOCK_ATLAS;
				TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(blocks).apply(fluidText);
				RenderingUtils.bindTexture(sprite.atlasLocation());

				int scale = GaugeTextures.BACKGROUND_DEFAULT.textureHeight() - 2;

				RenderingUtils.setShaderColor(new Color(IClientFluidTypeExtensions.of(fluid.getFluid()).getTintColor(fluid)));

				for (int i = 0; i < 16; i += 16) {
					for (int j = 0; j < scale; j += 16) {
						int drawWidth = Math.min(super.texture.textureWidth() - 2 - i, 16);
						int drawHeight = Math.min(scale - j, 16);

						int drawX = guiWidth + xLocation + 1;
						int drawY = guiHeight + yLocation - 1 + super.texture.textureHeight() - Math.min(scale - j, super.texture.textureHeight());
						graphics.blit(drawX, drawY, 0, drawWidth, drawHeight, sprite);
					}
				}
				RenderSystem.setShaderColor(1, 1, 1, 1);

			}

		}

		graphics.blit(GaugeTextures.LEVEL_DEFAULT.getLocation(), guiWidth + xLocation, guiHeight + yLocation, GaugeTextures.LEVEL_DEFAULT.textureU(), 0, GaugeTextures.LEVEL_DEFAULT.textureWidth(), GaugeTextures.LEVEL_DEFAULT.textureHeight(), GaugeTextures.LEVEL_DEFAULT.imageWidth(), GaugeTextures.LEVEL_DEFAULT.imageHeight());

	}

	@Override
	public void renderForeground(GuiGraphics graphics, int xAxis, int yAxis, int guiWidth, int guiHeight) {

		if (!isPointInRegion(xLocation, yLocation, xAxis, yAxis, super.texture.textureWidth(), super.texture.textureHeight())) {
			return;
		}

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) ((GenericScreen<?>) gui).getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		List<FormattedCharSequence> tooltips = new ArrayList<>();

		tooltips.add(property.get().getDisplayName().getVisualOrderText());

		graphics.renderTooltip(gui.getFontRenderer(), tooltips, xAxis, yAxis);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if (isActiveAndVisible() && isValidClick(button) && isInClickRegion(mouseX, mouseY)) {

			onMouseClick(mouseX, mouseY);

			return true;
		}
		return false;
	}

	@Override
	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		if (isValidClick(button)) {
			onMouseRelease(mouseX, mouseY);
			return true;
		}
		return false;
	}

	@Override
	public void onMouseClick(double mouseX, double mouseY) {

		GenericScreen<?> screen = (GenericScreen<?>) gui;

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) screen.getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		ItemStack holding = screen.getMenu().getCarried();

		if (holding.isEmpty()) {

			if (!Screen.hasShiftDown()) {
				return;
			}
			property.set(FluidStack.EMPTY);
			property.updateServer();

		}

		FluidStack taken = CapabilityUtils.drainFluidItem(holding, Integer.MAX_VALUE, FluidAction.SIMULATE);

		if (taken.isEmpty()) {
			return;
		}

		property.set(taken);
		property.updateServer();

	}

}
