package net.minecraft.jammy780.furniture.gui.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class jfm_ContainerRubbishBin extends Container
{
    private IInventory rubbishBinInv;
    private int numRows;

    public jfm_ContainerRubbishBin(IInventory par1IInventory, IInventory par2IInventory)
    {
        this.rubbishBinInv = par2IInventory;
        this.numRows = par2IInventory.getSizeInventory() / 9;
        par2IInventory.openChest();
        int i = (this.numRows - 4) * 18;
        int l;
        int j1;

        for (l = 0; l < this.numRows; ++l)
        {
            for (j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(par2IInventory, j1 + l * 9, 8 + j1 * 18, 16 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(par1IInventory, j1 + l * 9 + 9, 8 + j1 * 18, 122 + l * 18 + i));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(par1IInventory, l, 8 + l * 18, 180 + i));
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.rubbishBinInv.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer ep, int par1)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par1);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par1 < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);
        this.rubbishBinInv.closeChest();
    }
}
