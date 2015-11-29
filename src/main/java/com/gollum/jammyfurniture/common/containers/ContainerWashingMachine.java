package com.gollum.jammyfurniture.common.containers;

import com.gollum.jammyfurniture.common.crafting.WashingMachineRecipes;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerWashingMachine extends Container {
	private TileEntityIronBlocksTwo tileEntity;
	public int wmSlot1Time = 0;
	public int wmSlot2Time = 0;
	public int wmSlot3Time = 0;
	public int wmSlot4Time = 0;
	private int BurnTime = 0;
	private int currentItemBurnTime = 0;

	public ContainerWashingMachine(InventoryPlayer inventoryplayer, TileEntityIronBlocksTwo teWashingMachine, EntityPlayer player) {
		this.tileEntity = teWashingMachine;
		teWashingMachine.openInventory(player);
		this.addSlotToContainer(new Slot(teWashingMachine, 0, 79, 22));
		this.addSlotToContainer(new Slot(teWashingMachine, 1, 15, 52));
		this.addSlotToContainer(new Slot(teWashingMachine, 2, 113, 22));
		this.addSlotToContainer(new Slot(teWashingMachine, 3, 79, 56));
		this.addSlotToContainer(new Slot(teWashingMachine, 4, 113, 56));
		int i;

		for (i = 0; i < 3; ++i) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 142));
		}
	}
	
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			this.tileEntity.slot0Time = j;
		}
		
		if (i == 1) {
			this.tileEntity.slot1Time = j;
		}
		
		if (i == 2) {
			this.tileEntity.slot2Time = j;
		}
		
		if (i == 3) {
			this.tileEntity.slot3Time = j;
		}
		
		if (i == 4) {
			this.tileEntity.burnTime = j;
		}
		
		if (i == 5) {
			this.tileEntity.currentItemBurnTime = j;
		}
	}
	
	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		this.tileEntity.closeInventory(player);
	}
	
	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.wmSlot1Time != this.tileEntity.slot0Time) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.slot0Time);
			}
			
			if (this.wmSlot2Time != this.tileEntity.slot1Time) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.slot1Time);
			}
			
			if (this.wmSlot3Time != this.tileEntity.slot2Time) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.slot2Time);
			}
			
			if (this.wmSlot4Time != this.tileEntity.slot3Time) {
				icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.slot3Time);
			}
			
			if (this.BurnTime != this.tileEntity.burnTime) {
				icrafting.sendProgressBarUpdate(this, 4, this.tileEntity.burnTime);
			}
			
			if (this.currentItemBurnTime != this.tileEntity.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 5, this.tileEntity.currentItemBurnTime);
			}
		}
		
		this.wmSlot1Time         = this.tileEntity.slot0Time;
		this.wmSlot2Time         = this.tileEntity.slot1Time;
		this.wmSlot3Time         = this.tileEntity.slot2Time;
		this.wmSlot4Time         = this.tileEntity.slot3Time;
		this.BurnTime            = this.tileEntity.burnTime;
		this.currentItemBurnTime = this.tileEntity.currentItemBurnTime;
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.tileEntity.isUseableByPlayer(entityplayer);
	}
	
	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int slotId) {
		
		ItemStack itemStack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotId);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemStack = itemstack1.copy();
			
			if (slotId < this.tileEntity.getSizeInventory()) {
				if (!this.mergeItemStack(itemstack1, this.tileEntity.getSizeInventory(), this.inventorySlots.size(), true)) {
					return null;
				}
			} else {
				
				if (this.tileEntity.isItemFuel(itemstack1)) {
					
					if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksTwo.INDEX_SLOT_BURN, TileEntityIronBlocksTwo.INDEX_SLOT_BURN+1, false)) {
						return null;
					}
					
				} else {
					
					if (WashingMachineRecipes.smelting().getSmeltingResult(itemstack1) == null) {
						return null;
					}
					
					if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksTwo.INDEX_SLOT_0, TileEntityIronBlocksTwo.INDEX_SLOT_0+1, false)) {
						if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksTwo.INDEX_SLOT_1, TileEntityIronBlocksTwo.INDEX_SLOT_1+1, false)) {
							if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksTwo.INDEX_SLOT_2, TileEntityIronBlocksTwo.INDEX_SLOT_2+1, false)) {
								if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksTwo.INDEX_SLOT_3, TileEntityIronBlocksTwo.INDEX_SLOT_3+1, false)) {
									return null;
								}
							}
						}
					}
				}
			}
			
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemStack;
	}
}
