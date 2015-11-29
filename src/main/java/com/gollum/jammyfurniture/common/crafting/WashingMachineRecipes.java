package com.gollum.jammyfurniture.common.crafting;

import static com.gollum.jammyfurniture.ModJammyFurniture.log;

import java.util.HashMap;
import java.util.Map;

import com.gollum.core.tools.registered.RegisteredObjects;

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
		this.addSmelting(Items.leather_boots     , 1500);
		this.addSmelting(Items.leather_helmet    , 1500);
		this.addSmelting(Items.leather_chestplate, 1500);
		this.addSmelting(Items.leather_leggings  , 1500);
		
		this.addSmelting(Items.iron_boots     , 4000);
		this.addSmelting(Items.iron_helmet    , 4000);
		this.addSmelting(Items.iron_chestplate, 4000);
		this.addSmelting(Items.iron_leggings  , 4000);
		
		this.addSmelting(Items.golden_boots     , 4800);
		this.addSmelting(Items.golden_helmet    , 4800);
		this.addSmelting(Items.golden_chestplate, 4800);
		this.addSmelting(Items.golden_leggings  , 4800);
		
		this.addSmelting(Items.chainmail_boots     , 6000);
		this.addSmelting(Items.chainmail_helmet    , 6000);
		this.addSmelting(Items.chainmail_chestplate, 6000);
		this.addSmelting(Items.chainmail_leggings  , 6000);
		
		this.addSmelting(Items.diamond_boots     , 7200);
		this.addSmelting(Items.diamond_helmet    , 7200);
		this.addSmelting(Items.diamond_chestplate, 7200);
		this.addSmelting(Items.diamond_leggings  , 7200);
	}
	
	public void addSmelting(String registerName, int smeltTime) {
		Item item = RegisteredObjects.instance().getItem(registerName);
		if (item != null) {
			this.addSmelting(item, smeltTime);
		} else {
			log.severe("Item "+registerName+" for smeating Dishwasher");
		}
	}
	
	public void addSmelting(Item item, int smeltTime) {
		this.addSmelting(item, new ItemStack(item), smeltTime);
	}
	
	public void addSmelting(Item item, ItemStack itemStack, int smeltTime) {
		this.smeltingList.put(item, new RecipesResult (itemStack, smeltTime));
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
