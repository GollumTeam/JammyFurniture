package mods.jammyfurniture.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class jfm_ContainerBathroomCupboard extends Container
{
    private IInventory bathroomCupboardInv;
    private int numRows;

    public jfm_ContainerBathroomCupboard(IInventory par1IInventory, IInventory par2IInventory)
    {
        this.bathroomCupboardInv = par2IInventory;
        this.numRows = par2IInventory.getSizeInventory() / 4;
        par2IInventory.openChest();
        int i = (this.numRows - 4) * 18;
        int l;
        int j1;

        for (l = 0; l < this.numRows; ++l)
        {
            for (j1 = 0; j1 < 4; ++j1)
            {
                this.addSlotToContainer(new Slot(par2IInventory, j1 + l * 4, 54 + j1 * 18, 16 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(par1IInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(par1IInventory, l, 8 + l * 18, 161 + i));
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.bathroomCupboardInv.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 < this.numRows * 4)
            {
                if (!this.mergeItemStack(var5, this.numRows * 4, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 0, this.numRows * 4, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }
        }

        return var3;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);
        this.bathroomCupboardInv.closeChest();
    }
}
