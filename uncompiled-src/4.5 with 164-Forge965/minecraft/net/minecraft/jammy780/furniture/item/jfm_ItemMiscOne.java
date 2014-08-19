package net.minecraft.jammy780.furniture.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class jfm_ItemMiscOne extends ItemBlock
{
    public static Block theBlock;

    public jfm_ItemMiscOne(int par1, Block block)
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
            case 1:
            case 2:
            case 3:
                name = "Chimney";
                break;

            case 4:
            case 5:
            case 6:
            case 7:
                name = "MantlePiece";
                break;

            case 8:
                name = "ChristmasTree";
                break;

            default:
                name = "Chimney";
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
