package mods.jammyfurniture.common.containers;

import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerWashingMachine extends Container {
	private TileEntityIronBlocksTwo washingMachine;
	public int wmSlot1Time = 0;
	public int wmSlot2Time = 0;
	public int wmSlot3Time = 0;
	public int wmSlot4Time = 0;
	private int BurnTime = 0;
	private int ItemBurnTime = 0;

	public ContainerWashingMachine(InventoryPlayer inventoryplayer, TileEntityIronBlocksTwo teWashingMachine) {
		this.washingMachine = teWashingMachine;
		teWashingMachine.openChest();
		this.addSlotToContainer(new Slot(teWashingMachine, 0, 79, 22));
		this.addSlotToContainer(new Slot(teWashingMachine, 1, 15, 52));
		this.addSlotToContainer(new Slot(teWashingMachine, 2, 113, 22));
		this.addSlotToContainer(new Slot(teWashingMachine, 3, 79, 56));
		this.addSlotToContainer(new Slot(teWashingMachine, 4, 113, 56));
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

			if (this.wmSlot1Time != this.washingMachine.slot0Time) {
				icrafting.sendProgressBarUpdate(this, 0, this.washingMachine.slot0Time);
			}

			if (this.wmSlot2Time != this.washingMachine.slot1Time) {
				icrafting.sendProgressBarUpdate(this, 1, this.washingMachine.slot1Time);
			}

			if (this.wmSlot3Time != this.washingMachine.slot2Time) {
				icrafting.sendProgressBarUpdate(this, 2, this.washingMachine.slot2Time);
			}

			if (this.wmSlot4Time != this.washingMachine.slot3Time) {
				icrafting.sendProgressBarUpdate(this, 3, this.washingMachine.slot3Time);
			}

			if (this.BurnTime != this.washingMachine.burnTime) {
				icrafting.sendProgressBarUpdate(this, 4, this.washingMachine.burnTime);
			}

			if (this.ItemBurnTime != this.washingMachine.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 5, this.washingMachine.currentItemBurnTime);
			}
		}

		this.wmSlot1Time = this.washingMachine.slot0Time;
		this.wmSlot2Time = this.washingMachine.slot1Time;
		this.wmSlot3Time = this.washingMachine.slot2Time;
		this.wmSlot4Time = this.washingMachine.slot3Time;
		this.BurnTime = this.washingMachine.burnTime;
		this.ItemBurnTime = this.washingMachine.currentItemBurnTime;
	}

	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			this.washingMachine.slot0Time = j;
		}

		if (i == 1) {
			this.washingMachine.slot1Time = j;
		}

		if (i == 2) {
			this.washingMachine.slot2Time = j;
		}

		if (i == 3) {
			this.washingMachine.slot3Time = j;
		}

		if (i == 4) {
			this.washingMachine.burnTime = j;
		}

		if (i == 5) {
			this.washingMachine.currentItemBurnTime = j;
		}
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.washingMachine.isUseableByPlayer(entityplayer);
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
		this.washingMachine.closeChest();
	}
}
