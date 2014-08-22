package mods.jammyfurniture.client.gui;

import mods.jammyfurniture.common.containers.jfm_ContainerCooker;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksOne;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_GuiCooker extends GuiContainer {
	private jfm_TileEntityIronBlocksOne cookerInventory;
	protected static final ResourceLocation texture = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.GUI_PATH + "jammy_cooker.png");

	public jfm_GuiCooker(InventoryPlayer inventoryplayer, jfm_TileEntityIronBlocksOne teCooker) {
		super(new jfm_ContainerCooker(inventoryplayer, teCooker));
		this.cookerInventory = teCooker;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString("Cooker", 8, 6, 4210752);
		this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int j1 = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j1, k, 0, 0, this.xSize, this.ySize);
		int i11;

		if (this.cookerInventory.isBurning()) {
			i11 = this.cookerInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j1 + 20, k + 36 + 4 - i11, 176, 12 - i11, 14, i11 + 2);
		}

		i11 = this.cookerInventory.getCookProgressScaled(24);
		int m = this.cookerInventory.getCookProgressScaled2(24);
		this.drawTexturedModalRect(j1 + 118, k + 22, 176, 14, i11 + 1, 16);
		this.drawTexturedModalRect(j1 + 118, k + 50, 176, 14, m + 1, 16);
	}
}
