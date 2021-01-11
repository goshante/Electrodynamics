package electrodynamics.client;

import javax.annotation.Nullable;

import electrodynamics.DeferredRegisters;
import electrodynamics.client.screen.ScreenBatteryBox;
import electrodynamics.client.screen.ScreenCoalGenerator;
import electrodynamics.client.screen.ScreenDO2OProcessor;
import electrodynamics.client.screen.ScreenElectricFurnace;
import electrodynamics.client.screen.ScreenO2OProcessor;
import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.tile.wire.TileWire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientRegister {

	public static void setup() {
		ScreenManager.registerFactory(DeferredRegisters.CONTAINER_COALGENERATOR.get(), ScreenCoalGenerator::new);
		ScreenManager.registerFactory(DeferredRegisters.CONTAINER_ELECTRICFURNACE.get(), ScreenElectricFurnace::new);
		ScreenManager.registerFactory(DeferredRegisters.CONTAINER_O2OPROCESSOR.get(), ScreenO2OProcessor::new);
		ScreenManager.registerFactory(DeferredRegisters.CONTAINER_DO2OPROCESSOR.get(), ScreenDO2OProcessor::new);
		ScreenManager.registerFactory(DeferredRegisters.CONTAINER_BATTERYBOX.get(), ScreenBatteryBox::new);

		RenderTypeLookup.setRenderLayer(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.coalgeneratorrunning), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.wiremill), RenderType.getCutout());
		ItemModelsProperties.registerProperty(DeferredRegisters.ITEM_MULTIMETER.get(), new ResourceLocation("number"), new IItemPropertyGetter() {
			private double num = 0;
			private long lastCheck = 0;

			public float call(ItemStack p_call_1_, @Nullable ClientWorld p_call_2_, @Nullable LivingEntity p_call_3_) {
				boolean goesUp = false;
				if (p_call_3_ instanceof PlayerEntity) {
					RayTraceResult res = Minecraft.getInstance().objectMouseOver;
					if (res.getType() == Type.BLOCK) {
						BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) res;
						TileEntity tile = p_call_3_.world.getTileEntity(blockraytraceresult.getPos());
						if (tile instanceof TileWire) {
							TileWire wire = (TileWire) tile;
							if (wire.transmit > 0) {
								goesUp = true;
							}
						}
					}
				}
				if (lastCheck != p_call_3_.world.getGameTime()) {
					lastCheck = p_call_3_.world.getGameTime();
					num = (float) Math.min(0.9, Math.max(0.1, num + (goesUp ? 0.1 : -0.1)));
				}
				return (float) num;
			}
		});

	}
}
