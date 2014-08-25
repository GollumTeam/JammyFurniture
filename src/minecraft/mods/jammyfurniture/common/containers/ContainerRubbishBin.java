package mods.jammyfurniture.common.containers;

import mods.gollum.core.common.container.GCLContainer;
import mods.jammyfurniture.ModJammyFurniture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRubbishBin extends GCLContainer {
	
	public ContainerRubbishBin(IInventory inventoryPlayer, IInventory inventoryBlock) {
		super(inventoryPlayer, inventoryBlock, 9);
	}
}
