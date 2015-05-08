package com.gollum.jammyfurniture.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import com.gollum.core.common.container.GCLContainer;
import com.gollum.jammyfurniture.common.crafting.CookerRecipes;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;

public class ContainerCooker extends Container {
	private TileEntityIronBlocksOne tileEntity;
	private int CookTime = 0;
	private int CookTime2 = 0;
	private int BurnTime = 0;
	private int ItemBurnTime = 0;

	public ContainerCooker(InventoryPlayer inventoryPlayer, TileEntityIronBlocksOne tileEntityCooker) {
		
		this.tileEntity = tileEntityCooker;
		
		tileEntityCooker.openChest();
		
		this.addSlotToContainer(new Slot(tileEntityCooker, 0, 77, 20));
		this.addSlotToContainer(new Slot(tileEntityCooker, 1, 20, 44));
		this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntityCooker, 2, 143, 22));
		this.addSlotToContainer(new Slot(tileEntityCooker, 3, 77, 49));
		this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntityCooker, 4, 143, 49));
		int j;

		for (j = 0; j < 3; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(inventoryPlayer, k + j * 9 + 9, 8 + k * GCLContainer.SIZE_ITEM, 84 + j * GCLContainer.SIZE_ITEM));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * GCLContainer.SIZE_ITEM, 142));
		}
	}
	
	/**
	 * Called when the container is closed.
	 */
	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		
		super.onContainerClosed(par1EntityPlayer);
		this.tileEntity.closeChest();
		
	}
	
	public void updateProgressBar(int progressID, int value) {
		if (progressID == 0) {
			this.tileEntity.cookerCookTime0 = value;
		}

		if (progressID == 1) {
			this.tileEntity.cookerCookTime1 = value;
		}

		if (progressID == 2) {
			this.tileEntity.cookerBurnTime = value;
		}

		if (progressID == 3) {
			this.tileEntity.currentItemBurnTime = value;
		}
	}
	
	/**
	 * Envoie un event quand il y a un chagement coté server
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.CookTime != this.tileEntity.cookerCookTime0) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.cookerCookTime0);
			}

			if (this.CookTime2 != this.tileEntity.cookerCookTime1) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.cookerCookTime1);
			}

			if (this.BurnTime != this.tileEntity.cookerBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.cookerBurnTime);
			}

			if (this.ItemBurnTime != this.tileEntity.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.currentItemBurnTime);
			}
		}

		this.CookTime = this.tileEntity.cookerCookTime0;
		this.CookTime2 = this.tileEntity.cookerCookTime1;
		this.BurnTime = this.tileEntity.cookerBurnTime;
		this.ItemBurnTime = this.tileEntity.currentItemBurnTime;
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return this.tileEntity.isUseableByPlayer(entityplayer);
	}
	
	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	@Override
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
					
					if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksOne.INDEX_SLOT_BURN, TileEntityIronBlocksOne.INDEX_SLOT_BURN+1, false)) {
						return null;
					}
					
				} else {
					
					if (CookerRecipes.smelting().getSmeltingResult(itemstack1) == null) {
						return null;
					}
					
					if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksOne.INDEX_SLOT_BEFORE0, TileEntityIronBlocksOne.INDEX_SLOT_BEFORE0+1, false)) {
						if (!this.mergeItemStack(itemstack1, TileEntityIronBlocksOne.INDEX_SLOT_BEFORE1, TileEntityIronBlocksOne.INDEX_SLOT_BEFORE1+1, false)) {
							return null;
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
