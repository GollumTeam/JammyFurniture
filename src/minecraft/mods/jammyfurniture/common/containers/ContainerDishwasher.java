package mods.jammyfurniture.common.containers;

import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksTwo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDishwasher extends Container {
	
	private TileEntityIronBlocksTwo dishwasher;
	private int BurnTime = 0;
	private int ItemBurnTime = 0;
	
	public int dwSlot1Time = 0;
	public int dwSlot2Time = 0;
	public int dwSlot3Time = 0;
	public int dwSlot4Time = 0;
	
	public ContainerDishwasher(InventoryPlayer inventoryplayer, TileEntityIronBlocksTwo teDishwasher) {
		
		this.dishwasher = teDishwasher;
		this.dishwasher.openChest();
		
		this.addSlotToContainer(new Slot(teDishwasher, 0, 79, 27));
		this.addSlotToContainer(new Slot(teDishwasher, 1, 15, 52));
		this.addSlotToContainer(new Slot(teDishwasher, 2, 113, 27));
		this.addSlotToContainer(new Slot(teDishwasher, 3, 79, 56));
		this.addSlotToContainer(new Slot(teDishwasher, 4, 113, 56));
		int j;

		for (j = 0; j < 3; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(inventoryplayer, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
		}
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.dwSlot1Time != this.dishwasher.dwSlot1Time) {
				icrafting.sendProgressBarUpdate(this, 0, this.dishwasher.dwSlot1Time);
			}

			if (this.dwSlot2Time != this.dishwasher.dwSlot2Time) {
				icrafting.sendProgressBarUpdate(this, 1, this.dishwasher.dwSlot2Time);
			}

			if (this.dwSlot3Time != this.dishwasher.dwSlot3Time) {
				icrafting.sendProgressBarUpdate(this, 2, this.dishwasher.dwSlot3Time);
			}

			if (this.dwSlot4Time != this.dishwasher.dwSlot4Time) {
				icrafting.sendProgressBarUpdate(this, 3, this.dishwasher.dwSlot4Time);
			}

			if (this.BurnTime != this.dishwasher.dwBurnTime) {
				icrafting.sendProgressBarUpdate(this, 4, this.dishwasher.dwBurnTime);
			}

			if (this.ItemBurnTime != this.dishwasher.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 5, this.dishwasher.dwItemBurnTime);
			}
		}

		this.dwSlot1Time = this.dishwasher.dwSlot1Time;
		this.dwSlot2Time = this.dishwasher.dwSlot2Time;
		this.dwSlot3Time = this.dishwasher.dwSlot3Time;
		this.dwSlot4Time = this.dishwasher.dwSlot4Time;
		this.BurnTime = this.dishwasher.dwBurnTime;
		this.ItemBurnTime = this.dishwasher.dwItemBurnTime;
	}

	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			this.dishwasher.dwSlot1Time = j;
		}

		if (i == 1) {
			this.dishwasher.dwSlot2Time = j;
		}

		if (i == 2) {
			this.dishwasher.dwSlot3Time = j;
		}

		if (i == 3) {
			this.dishwasher.dwSlot4Time = j;
		}

		if (i == 4) {
			this.dishwasher.dwBurnTime = j;
		}

		if (i == 5) {
			this.dishwasher.dwItemBurnTime = j;
		}
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.dishwasher.isUseableByPlayer(entityplayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer pl, int i) {
		return null;
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		this.dishwasher.closeChest();
	}
}
