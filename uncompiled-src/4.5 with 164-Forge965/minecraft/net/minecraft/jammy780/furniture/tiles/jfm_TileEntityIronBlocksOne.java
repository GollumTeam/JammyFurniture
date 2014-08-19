package net.minecraft.jammy780.furniture.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.jammy780.furniture.gui.recipes.jfm_CookerRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;

public class jfm_TileEntityIronBlocksOne extends TileEntity implements IInventory
{
    public static int md = 0;
    private ItemStack[] FriFreContents;
    private ItemStack[] cookerItemStacks;
    private ItemStack[] binContents;
    public int numUsingPlayers;
    public static int metadata;
    public int cookerBurnTime;
    public int currentItemBurnTime;
    public int cookerCookTime;
    public int cookerCookTime2;
    private int ticksSinceSync;
    long lastClearance = System.currentTimeMillis();
    public float lidAngle;
    public float prevLidAngle;
    public static boolean debug = false;

    public jfm_TileEntityIronBlocksOne()
    {
        this.FriFreContents = new ItemStack[9];
        this.cookerItemStacks = new ItemStack[5];
        this.binContents = new ItemStack[27];
        this.cookerBurnTime = 0;
        this.currentItemBurnTime = 0;
        this.cookerCookTime = 0;
        this.cookerCookTime2 = 0;
    }

    public jfm_TileEntityIronBlocksOne(int meta)
    {
        md = meta;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord))
        {
            int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
            return meta <= 7 ? this.FriFreContents.length : (meta != 8 && meta != 9 && meta != 10 && meta != 11 ? (meta == 12 ? this.binContents.length : 0) : this.cookerItemStacks.length);
        }
        else
        {
            return 0;
        }
    }

    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord))
        {
            switch (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord))
            {
                case 0:
                case 1:
                case 2:
                case 3:
                    return this.FriFreContents[par1];

                case 4:
                case 5:
                case 6:
                case 7:
                    return this.FriFreContents[par1];

                case 8:
                case 9:
                case 10:
                case 11:
                    return this.cookerItemStacks[par1];

                case 12:
                    return this.binContents[par1];

                default:
                    return null;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        ItemStack itemstack1;

        if (this.binContents[par1] != null)
        {
            if (this.binContents[par1].stackSize <= par2)
            {
                itemstack1 = this.binContents[par1];
                this.binContents[par1] = null;
                this.onInventoryChanged();
                return itemstack1;
            }
            else
            {
                itemstack1 = this.binContents[par1].splitStack(par2);

                if (this.binContents[par1].stackSize == 0)
                {
                    this.binContents[par1] = null;
                }

                this.onInventoryChanged();
                return itemstack1;
            }
        }
        else if (this.FriFreContents[par1] != null)
        {
            if (this.FriFreContents[par1].stackSize <= par2)
            {
                itemstack1 = this.FriFreContents[par1];
                this.FriFreContents[par1] = null;
                this.onInventoryChanged();
                return itemstack1;
            }
            else
            {
                itemstack1 = this.FriFreContents[par1].splitStack(par2);

                if (this.FriFreContents[par1].stackSize == 0)
                {
                    this.FriFreContents[par1] = null;
                }

                this.onInventoryChanged();
                return itemstack1;
            }
        }
        else if (this.cookerItemStacks[par1] != null)
        {
            if (this.cookerItemStacks[par1].stackSize <= par2)
            {
                itemstack1 = this.cookerItemStacks[par1];
                this.cookerItemStacks[par1] = null;
                this.onInventoryChanged();
                return itemstack1;
            }
            else
            {
                itemstack1 = this.cookerItemStacks[par1].splitStack(par2);

                if (this.cookerItemStacks[par1].stackSize == 0)
                {
                    this.cookerItemStacks[par1] = null;
                }

                this.onInventoryChanged();
                return itemstack1;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        ItemStack itemstack;

        if (this.FriFreContents[par1] != null)
        {
            itemstack = this.FriFreContents[par1];
            this.FriFreContents[par1] = null;
            return itemstack;
        }
        else if (this.cookerItemStacks[par1] != null)
        {
            itemstack = this.cookerItemStacks[par1];
            this.cookerItemStacks[par1] = null;
            return itemstack;
        }
        else if (this.binContents[par1] != null)
        {
            itemstack = this.binContents[par1];
            this.binContents[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);

        if (meta <= 7)
        {
            this.FriFreContents[par1] = par2ItemStack;
        }
        else if (meta != 8 && meta != 9 && meta != 10 && meta != 11)
        {
            this.binContents[par1] = par2ItemStack;
        }
        else
        {
            this.cookerItemStacks[par1] = par2ItemStack;
        }

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        switch (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord))
        {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Fridge";

            case 4:
            case 5:
            case 6:
            case 7:
                return "Freezer";

            case 8:
            case 9:
            case 10:
            case 11:
                return "Cooker";

            case 12:
                return "Rubbish Bin";

            default:
                return "ERROR";
        }
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("FriFreItems");
        NBTTagList nbttaglist2 = par1NBTTagCompound.getTagList("CookerItems");
        NBTTagList nbttaglist3 = par1NBTTagCompound.getTagList("BinItems");
        this.FriFreContents = new ItemStack[9];
        this.cookerItemStacks = new ItemStack[5];
        this.binContents = new ItemStack[27];
        int i;
        NBTTagCompound nbttagcompound3;
        int j;

        for (i = 0; i < nbttaglist.tagCount(); ++i)
        {
            nbttagcompound3 = (NBTTagCompound)nbttaglist.tagAt(i);
            j = nbttagcompound3.getByte("Slot") & 255;

            if (j >= 0 && j < this.FriFreContents.length)
            {
                this.FriFreContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound3);
            }
        }

        for (i = 0; i < nbttaglist2.tagCount(); ++i)
        {
            nbttagcompound3 = (NBTTagCompound)nbttaglist2.tagAt(i);
            byte var8 = nbttagcompound3.getByte("Slot");

            if (var8 >= 0 && var8 < this.cookerItemStacks.length)
            {
                this.cookerItemStacks[var8] = ItemStack.loadItemStackFromNBT(nbttagcompound3);
            }
        }

        this.cookerBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.cookerCookTime = par1NBTTagCompound.getShort("CookTime");
        this.cookerCookTime2 = par1NBTTagCompound.getShort("CookTime2");
        this.currentItemBurnTime = getItemBurnTime(this.cookerItemStacks[1]);

        for (i = 0; i < nbttaglist3.tagCount(); ++i)
        {
            nbttagcompound3 = (NBTTagCompound)nbttaglist3.tagAt(i);
            j = nbttagcompound3.getByte("Slot") & 255;

            if (j >= 0 && j < this.binContents.length)
            {
                this.binContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound3);
            }
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();
        int meta = 1;

        if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord))
        {
            meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        }

        int i;
        NBTTagCompound nbttagcompound;

        if (meta <= 7)
        {
            for (i = 0; i < this.FriFreContents.length; ++i)
            {
                if (this.FriFreContents[i] != null)
                {
                    nbttagcompound = new NBTTagCompound();
                    nbttagcompound.setByte("Slot", (byte)i);
                    this.FriFreContents[i].writeToNBT(nbttagcompound);
                    nbttaglist.appendTag(nbttagcompound);
                }
            }

            par1NBTTagCompound.setTag("FriFreItems", nbttaglist);
        }
        else if (meta != 8 && meta != 9 && meta != 10 && meta != 11)
        {
            if (meta == 12)
            {
                for (i = 0; i < this.binContents.length; ++i)
                {
                    if (this.binContents[i] != null)
                    {
                        nbttagcompound = new NBTTagCompound();
                        nbttagcompound.setByte("Slot", (byte)i);
                        this.binContents[i].writeToNBT(nbttagcompound);
                        nbttaglist.appendTag(nbttagcompound);
                    }
                }

                par1NBTTagCompound.setTag("BinItems", nbttaglist);
            }
        }
        else
        {
            par1NBTTagCompound.setShort("BurnTime", (short)this.cookerBurnTime);
            par1NBTTagCompound.setShort("CookTime", (short)this.cookerCookTime);
            par1NBTTagCompound.setShort("CookTime2", (short)this.cookerCookTime2);

            for (i = 0; i < this.cookerItemStacks.length; ++i)
            {
                if (this.cookerItemStacks[i] != null)
                {
                    nbttagcompound = new NBTTagCompound();
                    nbttagcompound.setByte("Slot", (byte)i);
                    this.cookerItemStacks[i].writeToNBT(nbttagcompound);
                    nbttaglist.appendTag(nbttagcompound);
                }
            }

            par1NBTTagCompound.setTag("CookerItems", nbttaglist);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Causes the TileEntity to reset all it's cached values for it's container block, blockID, metaData and in the case
     * of chests, the adjcacent chest check
     */
    public void updateContainingBlockInfo()
    {
        super.updateContainingBlockInfo();
    }

    public void onTileEntityPowered(int par1, int par2)
    {
        if (par1 == 1)
        {
            this.numUsingPlayers = par2;
        }
    }

    public int getCookProgressScaled(int par1)
    {
        return this.cookerCookTime * par1 / 200;
    }

    public int getCookProgressScaled2(int par1)
    {
        return this.cookerCookTime2 * par1 / 200;
    }

    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.cookerBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.cookerBurnTime > 0;
    }

    public void removeItems(jfm_TileEntityIronBlocksOne te)
    {
        if (te != null && te.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 12)
        {
            for (int i = 0; i < te.getSizeInventory(); ++i)
            {
                ItemStack itemstack = te.getStackInSlot(i);

                if (itemstack != null)
                {
                    te.setInventorySlotContents(i, (ItemStack)null);
                }
            }
        }
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        if (debug)
        {
            System.out.println("World Obj = " + this.worldObj);
            System.out.println("X: " + this.xCoord);
            System.out.println("Y: " + this.yCoord);
            System.out.println("Z: " + this.zCoord);
            System.out.println("Meta: " + this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
            System.out.println("Bin - Time Left " + (int)Math.floor((double)((300000L - (System.currentTimeMillis() - this.lastClearance)) / 1000L)) / 60 + ":" + (300000L - (System.currentTimeMillis() - this.lastClearance)) / 1000L % 60L);
        }

        int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);

        if (meta <= 7)
        {
            if (++this.ticksSinceSync % 20 * 4 == 0)
            {
                ;
            }

            this.prevLidAngle = this.lidAngle;
            float flag = 0.1F;
            double flag1;

            if (this.numUsingPlayers > 0 && this.lidAngle == 0.0F)
            {
                double var8 = (double)this.xCoord + 0.5D;
                flag1 = (double)this.zCoord + 0.5D;
                this.worldObj.playSoundEffect(var8, (double)this.yCoord + 0.5D, flag1, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.numUsingPlayers == 0 && this.lidAngle > 0.0F || this.numUsingPlayers > 0 && this.lidAngle < 1.0F)
            {
                float var11 = this.lidAngle;

                if (this.numUsingPlayers > 0)
                {
                    this.lidAngle += flag;
                }
                else
                {
                    this.lidAngle -= flag;
                }

                if (this.lidAngle > 1.0F)
                {
                    this.lidAngle = 1.0F;
                }

                float var3 = 0.5F;

                if (this.lidAngle < var3 && var11 >= var3)
                {
                    flag1 = (double)this.xCoord + 0.5D;
                    double var6 = (double)this.zCoord + 0.5D;
                    this.worldObj.playSoundEffect(flag1, (double)this.yCoord + 0.5D, var6, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
                }

                if (this.lidAngle < 0.0F)
                {
                    this.lidAngle = 0.0F;
                }
            }
        }

        if (meta != 8 && meta != 9 && meta != 10 && meta != 11)
        {
            if (meta == 12 && System.currentTimeMillis() - this.lastClearance >= 300000L)
            {
                this.removeItems(this);
                this.lastClearance = System.currentTimeMillis();
            }
        }
        else
        {
            boolean var9 = this.cookerBurnTime > 0;
            boolean var10 = false;

            if (this.cookerBurnTime > 0)
            {
                --this.cookerBurnTime;
            }

            if (!this.worldObj.isRemote)
            {
                if (this.cookerBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.cookerBurnTime = getItemBurnTime(this.cookerItemStacks[1]);

                    if (this.cookerBurnTime > 0)
                    {
                        var10 = true;

                        if (this.cookerItemStacks[1] != null)
                        {
                            --this.cookerItemStacks[1].stackSize;

                            if (this.cookerItemStacks[1].stackSize == 0)
                            {
                                this.cookerItemStacks[1] = this.cookerItemStacks[1].getItem().getContainerItemStack(this.cookerItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.cookerBurnTime == 0 && this.canSmelt2())
                {
                    this.currentItemBurnTime = this.cookerBurnTime = getItemBurnTime(this.cookerItemStacks[1]);

                    if (this.cookerBurnTime > 0)
                    {
                        var10 = true;

                        if (this.cookerItemStacks[1] != null)
                        {
                            --this.cookerItemStacks[1].stackSize;

                            if (this.cookerItemStacks[1].stackSize == 0)
                            {
                                this.cookerItemStacks[1] = this.cookerItemStacks[1].getItem().getContainerItemStack(this.cookerItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookerCookTime;

                    if (this.cookerCookTime == 200)
                    {
                        this.cookerCookTime = 0;
                        this.smeltItem();
                        var10 = true;
                    }
                }
                else
                {
                    this.cookerCookTime = 0;
                }

                if (this.isBurning() && this.canSmelt2())
                {
                    ++this.cookerCookTime2;

                    if (this.cookerCookTime2 == 200)
                    {
                        this.cookerCookTime2 = 0;
                        this.smeltItem2();
                        var10 = true;
                    }
                }
                else
                {
                    this.cookerCookTime2 = 0;
                }
            }

            if (var10)
            {
                this.onInventoryChanged();
            }
        }
    }

    private boolean canSmelt()
    {
        if (this.cookerItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[0].getItem().itemID);
            return itemstack == null ? false : (this.cookerItemStacks[2] == null ? true : (!this.cookerItemStacks[2].isItemEqual(itemstack) ? false : (this.cookerItemStacks[2].stackSize < this.getInventoryStackLimit() && this.cookerItemStacks[2].stackSize < this.cookerItemStacks[2].getMaxStackSize() ? true : this.cookerItemStacks[2].stackSize < itemstack.getMaxStackSize())));
        }
    }

    private boolean canSmelt2()
    {
        if (this.cookerItemStacks[3] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[3].getItem().itemID);
            return itemstack == null ? false : (this.cookerItemStacks[4] == null ? true : (!this.cookerItemStacks[4].isItemEqual(itemstack) ? false : (this.cookerItemStacks[4].stackSize < this.getInventoryStackLimit() && this.cookerItemStacks[4].stackSize < this.cookerItemStacks[4].getMaxStackSize() ? true : this.cookerItemStacks[4].stackSize < itemstack.getMaxStackSize())));
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[0].getItem().itemID);

            if (this.cookerItemStacks[2] == null)
            {
                this.cookerItemStacks[2] = itemstack.copy();
            }
            else if (this.cookerItemStacks[2].itemID == itemstack.itemID)
            {
                this.cookerItemStacks[2].stackSize += itemstack.stackSize;
            }

            --this.cookerItemStacks[0].stackSize;

            if (this.cookerItemStacks[0].stackSize <= 0)
            {
                this.cookerItemStacks[0] = null;
            }
        }
    }

    public void smeltItem2()
    {
        if (this.canSmelt2())
        {
            ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[3].getItem().itemID);

            if (this.cookerItemStacks[4] == null)
            {
                this.cookerItemStacks[4] = itemstack.copy();
            }
            else if (this.cookerItemStacks[4].itemID == itemstack.itemID)
            {
                this.cookerItemStacks[4].stackSize += itemstack.stackSize;
            }

            --this.cookerItemStacks[3].stackSize;

            if (this.cookerItemStacks[3].stackSize <= 0)
            {
                this.cookerItemStacks[3] = null;
            }
        }
    }

    private static int getItemBurnTime(ItemStack par1ItemStack)
    {
        if (par1ItemStack == null)
        {
            return 0;
        }
        else
        {
            int i = par1ItemStack.getItem().itemID;
            return i < 256 && Block.blocksList[i].blockMaterial == Material.wood ? 300 : (i == Item.stick.itemID ? 100 : (i == Item.coal.itemID ? 1600 : (i == Item.bucketLava.itemID ? 20000 : (i == Block.sapling.blockID ? 100 : (i == Item.blazeRod.itemID ? 2400 : ModLoader.addAllFuel(par1ItemStack.itemID, par1ItemStack.getItemDamage()))))));
        }
    }

    public void openChest()
    {
        ++this.numUsingPlayers;
    }

    public void closeChest()
    {
        --this.numUsingPlayers;
    }

    /**
     * invalidates a tile entity
     */
    public void invalidate()
    {
        this.updateContainingBlockInfo();
        super.invalidate();
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean isInvNameLocalized()
    {
        return true;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return false;
    }
}
