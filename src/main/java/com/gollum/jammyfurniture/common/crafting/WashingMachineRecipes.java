package com.gollum.jammyfurniture.common.crafting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class WashingMachineRecipes {
	
	private static final WashingMachineRecipes smeltingBase = new WashingMachineRecipes();
	
	private class RecipesResult {
		
		public ItemStack itemStack;
		public int smeltTime;
		
		public RecipesResult (ItemStack itemStack, int smeltTime) {
			this.itemStack = itemStack;
			this.smeltTime = smeltTime;
		}
		
	}
	
	private Map<Item, RecipesResult> smeltingList = new HashMap<Item, RecipesResult>();
	
	public static final WashingMachineRecipes smelting() {
		return smeltingBase;
	}
	

	private WashingMachineRecipes() {
		
		this.addSmelting(Items.leather_boots     , new ItemStack(Items.leather_boots     ), 1500);
		this.addSmelting(Items.leather_helmet    , new ItemStack(Items.leather_helmet    ), 1500);
		this.addSmelting(Items.leather_chestplate, new ItemStack(Items.leather_chestplate), 1500);
		this.addSmelting(Items.leather_leggings  , new ItemStack(Items.leather_leggings  ), 1500);
		
		this.addSmelting(Items.iron_boots     , new ItemStack(Items.iron_boots     ), 4000);
		this.addSmelting(Items.iron_helmet    , new ItemStack(Items.iron_helmet    ), 4000);
		this.addSmelting(Items.iron_chestplate, new ItemStack(Items.iron_chestplate), 4000);
		this.addSmelting(Items.iron_leggings  , new ItemStack(Items.iron_leggings  ), 4000);
		
		this.addSmelting(Items.golden_boots     , new ItemStack(Items.golden_boots     ), 4800);
		this.addSmelting(Items.golden_helmet    , new ItemStack(Items.golden_helmet    ), 4800);
		this.addSmelting(Items.golden_chestplate, new ItemStack(Items.golden_chestplate), 4800);
		this.addSmelting(Items.golden_leggings  , new ItemStack(Items.golden_leggings  ), 4800);
		
		this.addSmelting(Items.chainmail_boots     , new ItemStack(Items.chainmail_boots     ), 6000);
		this.addSmelting(Items.chainmail_helmet    , new ItemStack(Items.chainmail_helmet    ), 6000);
		this.addSmelting(Items.chainmail_chestplate, new ItemStack(Items.chainmail_chestplate), 6000);
		this.addSmelting(Items.chainmail_leggings  , new ItemStack(Items.chainmail_leggings  ), 6000);
		
		this.addSmelting(Items.diamond_boots     , new ItemStack(Items.diamond_boots     ), 7200);
		this.addSmelting(Items.diamond_helmet    , new ItemStack(Items.diamond_helmet    ), 7200);
		this.addSmelting(Items.diamond_chestplate, new ItemStack(Items.diamond_chestplate), 7200);
		this.addSmelting(Items.diamond_leggings  , new ItemStack(Items.diamond_leggings  ), 7200);
	}
	
	public void addSmelting(Item itemArmor, ItemStack itemStack, int smeltTime) {
		this.smeltingList.put(itemArmor, new RecipesResult (itemStack, smeltTime));
	}
	
	public ItemStack getSmeltingResult(ItemStack itemStack) {
		
		if (itemStack == null || itemStack.getItemDamage() == 0) {
			return null;
		}
		
		Item item = itemStack.getItem();
		ItemStack rtn = null;
		
		if (this.smeltingList.containsKey(item)) {
			rtn = this.smeltingList.get (item).itemStack.copy();
		}
		
		if (item instanceof ItemArmor) {
			rtn  = itemStack.copy();
			rtn.setItemDamage(0);
		}
		
		return rtn;
	}
	
	public int getSmeltingTime(ItemStack itemStack) {
		
		if (itemStack == null || itemStack.getItemDamage() == 0) {
			return 0;
		}
		
		Item item = itemStack.getItem();
		int time = 0;
		
		if (this.smeltingList.containsKey(item)) {
			time = this.smeltingList.get (item).smeltTime;
		} else if (item instanceof ItemArmor) {
			time  = 8000;
		}
		
		return time;
	}
	
}
