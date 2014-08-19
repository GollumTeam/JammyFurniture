package net.minecraft.jammy780.furniture.gui.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class jfm_DishwasherRecipes
{
    private static final jfm_DishwasherRecipes smeltingBase = new jfm_DishwasherRecipes();
    private Map smeltingList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    public static final jfm_DishwasherRecipes smelting()
    {
        return smeltingBase;
    }

    private jfm_DishwasherRecipes()
    {
        this.addSmelting(Item.pickaxeWood.itemID, new ItemStack(Item.pickaxeWood));
        this.addSmelting(Item.pickaxeStone.itemID, new ItemStack(Item.pickaxeStone));
        this.addSmelting(Item.pickaxeIron.itemID, new ItemStack(Item.pickaxeIron));
        this.addSmelting(Item.pickaxeGold.itemID, new ItemStack(Item.pickaxeGold));
        this.addSmelting(Item.pickaxeDiamond.itemID, new ItemStack(Item.pickaxeDiamond));
        this.addSmelting(Item.shovelWood.itemID, new ItemStack(Item.shovelWood));
        this.addSmelting(Item.shovelStone.itemID, new ItemStack(Item.shovelStone));
        this.addSmelting(Item.shovelIron.itemID, new ItemStack(Item.shovelIron));
        this.addSmelting(Item.shovelGold.itemID, new ItemStack(Item.shovelGold));
        this.addSmelting(Item.shovelDiamond.itemID, new ItemStack(Item.shovelDiamond));
        this.addSmelting(Item.axeWood.itemID, new ItemStack(Item.axeWood));
        this.addSmelting(Item.axeStone.itemID, new ItemStack(Item.axeStone));
        this.addSmelting(Item.axeIron.itemID, new ItemStack(Item.axeIron));
        this.addSmelting(Item.axeGold.itemID, new ItemStack(Item.axeGold));
        this.addSmelting(Item.axeDiamond.itemID, new ItemStack(Item.axeDiamond));
        this.addSmelting(Item.hoeWood.itemID, new ItemStack(Item.hoeWood));
        this.addSmelting(Item.hoeStone.itemID, new ItemStack(Item.hoeStone));
        this.addSmelting(Item.hoeIron.itemID, new ItemStack(Item.hoeIron));
        this.addSmelting(Item.hoeGold.itemID, new ItemStack(Item.hoeGold));
        this.addSmelting(Item.hoeDiamond.itemID, new ItemStack(Item.hoeDiamond));
        this.addSmelting(Item.swordWood.itemID, new ItemStack(Item.swordWood));
        this.addSmelting(Item.swordStone.itemID, new ItemStack(Item.swordStone));
        this.addSmelting(Item.swordIron.itemID, new ItemStack(Item.swordIron));
        this.addSmelting(Item.swordGold.itemID, new ItemStack(Item.swordGold));
        this.addSmelting(Item.swordDiamond.itemID, new ItemStack(Item.swordDiamond));
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
