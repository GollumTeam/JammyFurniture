package mods.jammyfurniture.client.gui;

import java.util.Random;

import mods.jammyfurniture.common.containers.jfm_ContainerRubbishBin;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class jfm_GuiRubbishBin extends GuiContainer {
	private IInventory upperChestInventory;
	private IInventory lowerChestInventory;
	public static int x;
	public static int y;
	public static int z;
	public Random random;
	public static TileEntityIronBlocksOne teRB;
	private int inventoryRows = 0;
	protected static final ResourceLocation texture = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.GUI_PATH + "jammy_rubbishbin.png");

	public jfm_GuiRubbishBin(IInventory par1IInventory, IInventory par2IInventory, int f, int h, int g) {
		super(new jfm_ContainerRubbishBin(par1IInventory, par2IInventory));
		this.upperChestInventory = par1IInventory;
		this.lowerChestInventory = par2IInventory;
		this.allowUserInput = false;
		short c = 222;
		int i = c - 108;
		this.inventoryRows = par2IInventory.getSizeInventory() / 9;
		this.ySize = i + this.inventoryRows * 18;
		x = f;
		y = h;
		z = g;
		this.random = new Random();
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(StatCollector.translateToLocal(this.lowerChestInventory.getInvName()), 8, 5, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal(this.upperChestInventory.getInvName()), 8, this.ySize - 80 + 3, 4210752);
	}

	public void removeItems(TileEntityIronBlocksOne te) {
		if (te != null) {
			for (int i = 0; i < te.getSizeInventory(); ++i) {
				ItemStack itemstack = te.getStackInSlot(i);

				if (itemstack != null) {
					te.setInventorySlotContents(i, (ItemStack) null);
				}
			}
		}
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j, k - 2, 0, 0, this.xSize, 188);
	}
}
