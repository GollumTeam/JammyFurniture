package net.minecraft.jammy780.furniture.gui.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksOne;

public class jfm_ContainerCooker extends Container
{
    private jfm_TileEntityIronBlocksOne oven;
    private int CookTime = 0;
    private int CookTime2 = 0;
    private int BurnTime = 0;
    private int ItemBurnTime = 0;

    public jfm_ContainerCooker(InventoryPlayer inventoryplayer, jfm_TileEntityIronBlocksOne teCooker)
    {
        this.oven = teCooker;
        this.addSlotToContainer(new Slot(teCooker, 0, 77, 20));
        this.addSlotToContainer(new Slot(teCooker, 1, 20, 44));
        this.addSlotToContainer(new SlotFurnace(inventoryplayer.player, teCooker, 2, 143, 22));
        this.addSlotToContainer(new Slot(teCooker, 3, 77, 49));
        this.addSlotToContainer(new SlotFurnace(inventoryplayer.player, teCooker, 4, 143, 49));
        int j;

        for (j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventoryplayer, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.oven.cookerCookTime = par2;
        }

        if (par1 == 1)
        {
            this.oven.cookerCookTime2 = par2;
        }

        if (par1 == 2)
        {
            this.oven.cookerBurnTime = par2;
        }

        if (par1 == 3)
        {
            this.oven.currentItemBurnTime = par2;
        }
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.CookTime != this.oven.cookerCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.oven.cookerCookTime);
            }

            if (this.CookTime2 != this.oven.cookerCookTime2)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.oven.cookerCookTime2);
            }

            if (this.BurnTime != this.oven.cookerBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.oven.cookerBurnTime);
            }

            if (this.ItemBurnTime != this.oven.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 3, this.oven.currentItemBurnTime);
            }
        }

        this.CookTime = this.oven.cookerCookTime;
        this.CookTime2 = this.oven.cookerCookTime2;
        this.BurnTime = this.oven.cookerBurnTime;
        this.ItemBurnTime = this.oven.currentItemBurnTime;
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return this.oven.isUseableByPlayer(entityplayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer pl, int i)
    {
        return null;
    }
}
