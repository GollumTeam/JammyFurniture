package com.gollum.jammyfurniture.client.gui;

import org.lwjgl.opengl.GL11;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.containers.ContainerDishwasher;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiDishwasher extends GuiContainer {

	private InventoryPlayer inventoryPlayer;
	private TileEntityIronBlocksTwo dwInv;
	protected ResourceLocation texture = new ResourceLocation(ModJammyFurniture.MODID.toLowerCase()+":gui/jammy_dishwasher.png");

	public GuiDishwasher(InventoryPlayer inventoryPlayer, TileEntityIronBlocksTwo teDishwasher) { 
		super(new ContainerDishwasher(inventoryPlayer, teDishwasher));
		this.inventoryPlayer  = inventoryPlayer;
		this.dwInv = teDishwasher;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		this.fontRendererObj.drawString(this.dwInv.getInventoryName(), 8, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.inventoryPlayer.getInventoryName()), 8, this.ySize - 96 + 2, 4210752);
		
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		this.mc.renderEngine.bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
		if (this.dwInv.isBurning()) {
			int burnProgress  = this.dwInv.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(x + 16, y + 48 - burnProgress, 176, 12 - burnProgress, 14, burnProgress + 2);
		}
		
		int progress0 = this.dwInv.getProgressSlot0(24);
		int progress1 = this.dwInv.getProgressSlot1(24);
		int progress2 = this.dwInv.getProgressSlot2(24);
		int progress3 = this.dwInv.getProgressSlot3(24);
		
		this.drawTexturedModalRect(x + 65 - progress0, y + 27, 201 - progress0, 31, 25           , 16);
		this.drawTexturedModalRect(x + 145           , y + 27, 176            , 14, 1 + progress1, 16);
		this.drawTexturedModalRect(x + 65 - progress2, y + 58, 201 - progress2, 31, 25           , 16);
		this.drawTexturedModalRect(x + 145           , y + 58, 176            , 14, 1 + progress3, 16);
	}
}
