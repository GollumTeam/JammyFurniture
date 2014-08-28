package mods.jammyfurniture.common.containers;

import mods.gollum.core.common.container.GCLContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

// TODO a supprimer
public class ContainerFriFre extends GCLContainer {
	
	public ContainerFriFre(IInventory inventoryPlayer, IInventory inventoryBlock) {
		super(inventoryPlayer, inventoryBlock, 3);
	}

	public boolean isFood(int itemID) {
		int[] itemids = new int[] { 319, 363, 365, 349 };
		int[] arr$ = itemids;
		int len$ = itemids.length;

		for (int i$ = 0; i$ < len$; ++i$) {
			int id = arr$[i$];

			if (id == itemID) {
				return true;
			}
		}

		return false;
	}
}
