package mods.jammyfurniture.client.gui;

import mods.jammyfurniture.common.containers.ContainerWashingMachine;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiWashingMachine extends GuiContainer {

	private InventoryPlayer inventoryPlayer;
	private TileEntityIronBlocksTwo wmInv;
	protected ResourceLocation texture = new ResourceLocation("jammyfurniture:gui/jammy_washingmachine.png");

	public GuiWashingMachine(InventoryPlayer inventoryPlayer, TileEntityIronBlocksTwo teWashingMachine) {
		super(new ContainerWashingMachine(inventoryPlayer, teWashingMachine));
		this.inventoryPlayer  = inventoryPlayer;
		this.wmInv = teWashingMachine;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String line1 = this.wmInv.getInvName();
		String line2 = "";
		if (line1.contains(" ")) {
			line2=line1.substring(line1.indexOf(" ")+1);
			line1=line1.substring(0, line1.indexOf(" "));
		}
		this.fontRenderer.drawString(line1, 8, 6, 4210752);
		this.fontRenderer.drawString(line2, 8, 15, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal(this.inventoryPlayer.getInvName()), 8, this.ySize - 96 + 2, 4210752);
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

		if (this.wmInv.isBurning()) {
			int burnProgress  = this.wmInv.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(x + 16, y + 48 - burnProgress, 176, 12 - burnProgress, 14, burnProgress + 2);
		}

		int progress0 = this.wmInv.getProgressSlot0(24);
		int progress1 = this.wmInv.getProgressSlot1(24);
		int progress2 = this.wmInv.getProgressSlot2(24);
		int progress3 = this.wmInv.getProgressSlot3(24);
		this.drawTexturedModalRect(x + 65 - progress0, y + 24, 201 - progress0, 31, 25           , 16);
		this.drawTexturedModalRect(x + 145           , y + 24, 176            , 14, 1 + progress1, 16);
		this.drawTexturedModalRect(x + 65 - progress2, y + 58, 201 - progress2, 31, 25           , 16);
		this.drawTexturedModalRect(x + 145           , y + 58, 176            , 14, progress3 + 1, 16);
	}
}
