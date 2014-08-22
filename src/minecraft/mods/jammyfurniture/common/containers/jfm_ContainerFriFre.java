package mods.jammyfurniture.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class jfm_ContainerFriFre extends Container {
	private IInventory freezerInv;
	private int numRows;

	public jfm_ContainerFriFre(IInventory par1IInventory, IInventory par2IInventory) {
		this.freezerInv = par2IInventory;
		this.numRows = par2IInventory.getSizeInventory() / 3;
		par2IInventory.openChest();
		int i = (this.numRows - 4) * 18;
		int l;
		int j1;

		for (l = 0; l < this.numRows; ++l) {
			for (j1 = 0; j1 < 3; ++j1) {
				this.addSlotToContainer(new Slot(par2IInventory, j1 + l * 3, 62 + j1 * 18, 16 + l * 18));
			}
		}

		for (l = 0; l < 3; ++l) {
			for (j1 = 0; j1 < 9; ++j1) {
				this.addSlotToContainer(new Slot(par1IInventory, j1 + l * 9 + 9, 8 + j1 * 18, 104 + l * 18 + i));
			}
		}

		for (l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(par1IInventory, l, 8 + l * 18, 162 + i));
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.freezerInv.isUseableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.inventorySlots.get(par2);

		if (var4 != null && var4.getHasStack()) {
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();

			if (par2 < this.numRows * 3) {
				if (!this.mergeItemStack(var5, this.numRows * 3, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(var5, 0, this.numRows * 3, false)) {
				return null;
			}

			if (var5.stackSize == 0) {
				var4.putStack((ItemStack) null);
			} else {
				var4.onSlotChanged();
			}
		}

		return var3;
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

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		this.freezerInv.closeChest();
	}
}
