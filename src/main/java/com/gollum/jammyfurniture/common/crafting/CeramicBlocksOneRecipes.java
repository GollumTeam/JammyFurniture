package com.gollum.jammyfurniture.common.crafting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CeramicBlocksOneRecipes {

	private static final CeramicBlocksOneRecipes smeltingBase = new CeramicBlocksOneRecipes();
	
	private class RecipesResult {
		
		public ItemStack itemStack;
		public int smeltTime;
		
		
	}
	
	private Map<Item, ItemStack> smeltingList = new HashMap<Item, ItemStack>();
	
	public static final CeramicBlocksOneRecipes smelting() {
		return smeltingBase;
	}
	
	private CeramicBlocksOneRecipes() {
		this.addSmelting(Items.bucket      , new ItemStack(Items.water_bucket, 1, 0));
		this.addSmelting(Items.glass_bottle, new ItemStack(Items.potionitem, 1, 0));
	}

	
	public void addSmelting(Item itemArmor, ItemStack itemStack) {
		this.smeltingList.put(itemArmor, itemStack);
	}
	
	public ItemStack getSmeltingResult(ItemStack itemStack) {
		
		if (itemStack == null) {
			return null;
		}
		
		Item item = itemStack.getItem();
		ItemStack rtn = null;
		
		if (this.smeltingList.containsKey(item)) {
			rtn = this.smeltingList.get (item).copy();
		}
		
		return rtn;
	}
}
