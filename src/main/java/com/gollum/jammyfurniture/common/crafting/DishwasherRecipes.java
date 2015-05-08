package com.gollum.jammyfurniture.common.crafting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class DishwasherRecipes {

	private static final DishwasherRecipes smeltingBase = new DishwasherRecipes();
	
	private class RecipesResult {
		
		public ItemStack itemStack;
		public int smeltTime;
		
		public RecipesResult (ItemStack itemStack, int smeltTime) {
			this.itemStack = itemStack;
			this.smeltTime = smeltTime;
		}
		
	}
	
	private Map<Item, RecipesResult> smeltingList = new HashMap<Item, RecipesResult>();
	
	public static final DishwasherRecipes smelting() {
		return smeltingBase;
	}
	
	private DishwasherRecipes() {
		this.addSmelting(Item.pickaxeWood   , new ItemStack(Item.pickaxeWood)   , 1500);
		this.addSmelting(Item.shovelWood    , new ItemStack(Item.shovelWood)    , 1500);
		this.addSmelting(Item.axeWood       , new ItemStack(Item.axeWood)       , 1500);
		this.addSmelting(Item.hoeWood       , new ItemStack(Item.hoeWood)       , 1500);
		this.addSmelting(Item.swordWood     , new ItemStack(Item.swordWood)     , 1500);
		
		
		this.addSmelting(Item.pickaxeStone  , new ItemStack(Item.pickaxeStone)  , 4000);
		this.addSmelting(Item.shovelStone   , new ItemStack(Item.shovelStone)   , 4000);
		this.addSmelting(Item.axeStone      , new ItemStack(Item.axeStone)      , 4000);
		this.addSmelting(Item.hoeStone      , new ItemStack(Item.hoeStone)      , 4000);
		this.addSmelting(Item.swordStone    , new ItemStack(Item.swordStone)    , 4000);
		
		this.addSmelting(Item.pickaxeIron   , new ItemStack(Item.pickaxeIron)   , 4800);
		this.addSmelting(Item.shovelIron    , new ItemStack(Item.shovelIron)    , 4800);
		this.addSmelting(Item.axeIron       , new ItemStack(Item.axeIron)       , 4800);
		this.addSmelting(Item.hoeIron       , new ItemStack(Item.hoeIron)       , 4800);
		this.addSmelting(Item.swordIron     , new ItemStack(Item.swordIron)     , 4800);
		
		this.addSmelting(Item.pickaxeGold   , new ItemStack(Item.pickaxeGold)   , 6000);
		this.addSmelting(Item.shovelGold    , new ItemStack(Item.shovelGold)    , 6000);
		this.addSmelting(Item.axeGold       , new ItemStack(Item.axeGold)       , 6000);
		this.addSmelting(Item.hoeGold       , new ItemStack(Item.hoeGold)       , 6000);
		this.addSmelting(Item.swordGold     , new ItemStack(Item.swordGold)     , 6000);
		
		this.addSmelting(Item.shovelDiamond , new ItemStack(Item.shovelDiamond) , 7200);
		this.addSmelting(Item.axeDiamond    , new ItemStack(Item.axeDiamond)    , 7200);
		this.addSmelting(Item.hoeDiamond    , new ItemStack(Item.hoeDiamond)    , 7200);
		this.addSmelting(Item.swordDiamond  , new ItemStack(Item.swordDiamond)  , 7200);
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

		if (item instanceof ItemSword) {
			rtn  = itemStack.copy();
			rtn.setItemDamage(0);
		}
		if (item instanceof ItemAxe) {
			rtn  = itemStack.copy();
			rtn.setItemDamage(0);
		}
		if (item instanceof ItemPickaxe) {
			rtn  = itemStack.copy();
			rtn.setItemDamage(0);
		}
		if (item instanceof ItemHoe) {
			rtn  = itemStack.copy();
			rtn.setItemDamage(0);
		}
		if (item instanceof ItemSpade) {
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
		} else if (
			item instanceof ItemSword || 
			item instanceof ItemAxe || 
			item instanceof ItemPickaxe || 
			item instanceof ItemHoe || 
			item instanceof ItemSpade
		) {
			time  = 8000;
		}
		
		return time;
	}
}
