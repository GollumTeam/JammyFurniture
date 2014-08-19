package net.minecraft.jammy780.furniture.gui.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class jfm_CookerRecipes
{
    private static final jfm_CookerRecipes smeltingBase = new jfm_CookerRecipes();
    private Map smeltingList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    public static final jfm_CookerRecipes smelting()
    {
        return smeltingBase;
    }

    private jfm_CookerRecipes()
    {
        this.addSmelting(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
        this.addSmelting(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
        this.addSmelting(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
        this.addSmelting(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
        this.addSmelting(Item.potato.itemID, new ItemStack(Item.bakedPotato));
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
