package mods.jammyfurniture.common.containers;

import mods.gollum.core.common.container.GCLContainer;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerCooker extends Container {
	private TileEntityIronBlocksOne tileEntity;
	private int CookTime = 0;
	private int CookTime2 = 0;
	private int BurnTime = 0;
	private int ItemBurnTime = 0;

	public ContainerCooker(InventoryPlayer inventoryPlayer, TileEntityIronBlocksOne tileEntityCooker) {
		
		this.tileEntity = tileEntityCooker;
		
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
	
	
	// TODO a revoir
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.tileEntity.cookerCookTime = par2;
		}

		if (par1 == 1) {
			this.tileEntity.cookerCookTime2 = par2;
		}

		if (par1 == 2) {
			this.tileEntity.cookerBurnTime = par2;
		}

		if (par1 == 3) {
			this.tileEntity.currentItemBurnTime = par2;
		}
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.CookTime != this.tileEntity.cookerCookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.cookerCookTime);
			}

			if (this.CookTime2 != this.tileEntity.cookerCookTime2) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.cookerCookTime2);
			}

			if (this.BurnTime != this.tileEntity.cookerBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.cookerBurnTime);
			}

			if (this.ItemBurnTime != this.tileEntity.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.currentItemBurnTime);
			}
		}

		this.CookTime = this.tileEntity.cookerCookTime;
		this.CookTime2 = this.tileEntity.cookerCookTime2;
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
	public ItemStack transferStackInSlot(EntityPlayer pl, int i) {
		return null;
	}
}
