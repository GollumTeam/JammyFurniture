package mods.jammyfurniture.client.gui;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import mods.gollum.core.client.gui.GCLGuiContainer;
import mods.jammyfurniture.common.containers.ContainerRubbishBin;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class GuiRubbishBin extends GCLGuiContainer {
//	
//	public static TileEntityIronBlocksOne teRB;
//	
	public GuiRubbishBin(IInventory inventoryPlayer, IInventory inventoryBlock) throws Exception {
		super(inventoryPlayer, inventoryBlock, ContainerRubbishBin.class);
		
	}
	
//	public void removeItems(TileEntityIronBlocksOne te) {
//		if (te != null) {
//			for (int i = 0; i < te.getSizeInventory(); ++i) {
//				ItemStack itemstack = te.getStackInSlot(i);
//
//				if (itemstack != null) {
//					te.setInventorySlotContents(i, (ItemStack) null);
//				}
//			}
//		}
//	}

}
