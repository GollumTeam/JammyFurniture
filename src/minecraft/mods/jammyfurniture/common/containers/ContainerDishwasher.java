package mods.jammyfurniture.common.containers;

import mods.jammyfurniture.common.crafting.CookerRecipes;
import mods.jammyfurniture.common.crafting.DishwasherRecipes;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDishwasher extends Container {
	
	private TileEntityIronBlocksTwo tileEntity;
	private int burnTime = 0;
	private int currentItemBurnTime = 0;
	
	public int slot0Time = 0;
	public int slot1Time = 0;
	public int slot2Time = 0;
	public int slot3Time = 0;
	
	public ContainerDishwasher(InventoryPlayer inventoryplayer, TileEntityIronBlocksTwo teDishwasher) {
		
		this.tileEntity = teDishwasher;
		this.tileEntity.openChest();
		
		this.addSlotToContainer(new Slot(teDishwasher, 0, 79, 27));
		this.addSlotToContainer(new Slot(teDishwasher, 1, 15, 52));
		this.addSlotToContainer(new Slot(teDishwasher, 2, 113, 27));
		this.addSlotToContainer(new Slot(teDishwasher, 3, 79, 56));
		this.addSlotToContainer(new Slot(teDishwasher, 4, 113, 56));
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
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		this.tileEntity.closeChest();
	}
	
	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.slot0Time != this.tileEntity.slot0Time) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.slot0Time);
			}
			
			if (this.slot1Time != this.tileEntity.slot1Time) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.slot1Time);
			}
			
			if (this.slot2Time != this.tileEntity.slot0Time) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.slot2Time);
			}
			
			if (this.slot3Time != this.tileEntity.slot3Time) {
				icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.slot3Time);
			}
			
			if (this.burnTime != this.tileEntity.burnTime) {
				icrafting.sendProgressBarUpdate(this, 4, this.tileEntity.burnTime);
			}
			
			if (this.currentItemBurnTime != this.tileEntity.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 5, this.tileEntity.currentItemBurnTime);
			}
		}
		
		this.slot0Time           = this.tileEntity.slot0Time;
		this.slot1Time           = this.tileEntity.slot1Time;
		this.slot2Time           = this.tileEntity.slot2Time;
		this.slot3Time           = this.tileEntity.slot3Time;
		this.burnTime            = this.tileEntity.burnTime;
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
					
					if (DishwasherRecipes.smelting().getSmeltingResult(itemstack1) == null) {
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
