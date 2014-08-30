package mods.jammyfurniture.client.gui;

import mods.gollum.core.common.container.GCLContainer;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.containers.ContainerCooker;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiCooker extends GuiContainer {

	private InventoryPlayer inventoryPlayer;
	private TileEntityIronBlocksOne tileEntityCooker;
	protected static final ResourceLocation texture = new ResourceLocation(ModJammyFurniture.MODID.toLowerCase()+":gui/cooker.png");
	
	
	
	public GuiCooker(InventoryPlayer inventoryPlayer, TileEntityIronBlocksOne tileEntityCooker) {
		super(new ContainerCooker(inventoryPlayer, tileEntityCooker));
		this.inventoryPlayer  = inventoryPlayer;
		this.tileEntityCooker = (TileEntityIronBlocksOne) tileEntityCooker;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(StatCollector.translateToLocal(this.tileEntityCooker.getInvName()), 8, 6                  , 0x404040);
		this.fontRenderer.drawString(StatCollector.translateToLocal(this.inventoryPlayer.getInvName()) , 8, this.ySize - 96 + 2, 0x404040);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int posX = (this.width - this.xSize) / 2;
		int posY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);
		
		if (this.tileEntityCooker.isBurning()) {
			int burnProgress = this.tileEntityCooker.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(posX + 20, posY + 36 + 4 - burnProgress, 176, 12 - burnProgress, 14, burnProgress + 2);
		}

		int progress0 = this.tileEntityCooker.getCookProgressScaled0(24);
		int progress1 = this.tileEntityCooker.getCookProgressScaled1(24);
		this.drawTexturedModalRect(posX + 118, posY + 22, 176, 14, progress0 + 1, 16);
		this.drawTexturedModalRect(posX + 118, posY + 50, 176, 14, progress1 + 1, 16);
	}
}
