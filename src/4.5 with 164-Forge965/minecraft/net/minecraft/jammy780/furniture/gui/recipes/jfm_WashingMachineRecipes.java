package net.minecraft.jammy780.furniture.gui.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class jfm_WashingMachineRecipes
{
    private static final jfm_WashingMachineRecipes smeltingBase = new jfm_WashingMachineRecipes();
    private Map smeltingList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    public static final jfm_WashingMachineRecipes smelting()
    {
        return smeltingBase;
    }

    private jfm_WashingMachineRecipes()
    {
        this.addSmelting(Item.bootsDiamond.itemID, new ItemStack(Item.bootsDiamond));
        this.addSmelting(Item.bootsChain.itemID, new ItemStack(Item.bootsChain));
        this.addSmelting(Item.bootsLeather.itemID, new ItemStack(Item.bootsLeather));
        this.addSmelting(Item.bootsIron.itemID, new ItemStack(Item.bootsIron));
        this.addSmelting(Item.bootsGold.itemID, new ItemStack(Item.bootsGold));
        this.addSmelting(Item.helmetDiamond.itemID, new ItemStack(Item.helmetDiamond));
        this.addSmelting(Item.helmetChain.itemID, new ItemStack(Item.helmetChain));
        this.addSmelting(Item.helmetLeather.itemID, new ItemStack(Item.helmetLeather));
        this.addSmelting(Item.helmetIron.itemID, new ItemStack(Item.helmetIron));
        this.addSmelting(Item.helmetGold.itemID, new ItemStack(Item.helmetGold));
        this.addSmelting(Item.plateDiamond.itemID, new ItemStack(Item.plateDiamond));
        this.addSmelting(Item.plateChain.itemID, new ItemStack(Item.plateChain));
        this.addSmelting(Item.plateLeather.itemID, new ItemStack(Item.plateLeather));
        this.addSmelting(Item.plateIron.itemID, new ItemStack(Item.plateIron));
        this.addSmelting(Item.plateGold.itemID, new ItemStack(Item.plateGold));
        this.addSmelting(Item.legsDiamond.itemID, new ItemStack(Item.legsDiamond));
        this.addSmelting(Item.legsChain.itemID, new ItemStack(Item.legsChain));
        this.addSmelting(Item.legsLeather.itemID, new ItemStack(Item.legsLeather));
        this.addSmelting(Item.legsIron.itemID, new ItemStack(Item.legsIron));
        this.addSmelting(Item.legsGold.itemID, new ItemStack(Item.legsGold));
    }

    public void addSmelting(int par1, ItemStack par2ItemStack)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    @Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public void addSmelting(int itemID, int metadata, ItemStack itemstack)
    {
        this.metaSmeltingList.put(Arrays.asList(new Integer[] {Integer.valueOf(itemID), Integer.valueOf(metadata)}), itemstack);
    }

    public ItemStack getSmeltingResult(ItemStack item)
    {
        if (item == null)
        {
            return null;
        }
        else
        {
            ItemStack ret = (ItemStack)this.metaSmeltingList.get(Arrays.asList(new Integer[] {Integer.valueOf(item.itemID), Integer.valueOf(item.getItemDamage())}));
            return ret != null ? ret : (ItemStack)this.smeltingList.get(Integer.valueOf(item.itemID));
        }
    }
}
