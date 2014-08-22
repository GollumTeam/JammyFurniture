package net.minecraft.jammy780.furniture.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class jfm_ItemWoodBlocksOne extends ItemBlock
{
    public static Block theBlock;

    public jfm_ItemWoodBlocksOne(int par1, Block block)
    {
        super(par1);
        this.setHasSubtypes(true);
        theBlock = block;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
            case 0:
                name = "ClockBase";
                break;

            case 1:
            case 2:
            case 3:
            case 4:
                name = "ClockMiddle";
                break;

            case 5:
            case 6:
            case 7:
            case 8:
                name = "ClockTop";
                break;

            case 9:
            case 10:
            case 11:
            case 12:
                name = "Blinds";
                break;

            case 13:
                name = "CraftingSide";
                break;

            case 14:
                name = "KitchenSide";
                break;

            case 15:
                name = "Table";
                break;

            default:
                name = "ClockBase";
        }

        return this.getUnlocalizedName() + "." + name;
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }
}
