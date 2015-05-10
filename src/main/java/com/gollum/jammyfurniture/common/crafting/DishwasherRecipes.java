package com.gollum.jammyfurniture.common.crafting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
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
		
		this.addSmelting(Items.wooden_pickaxe, new ItemStack(Items.wooden_pickaxe), 1500);
		this.addSmelting(Items.wooden_shovel , new ItemStack(Items.wooden_shovel ), 1500);
		this.addSmelting(Items.wooden_axe    , new ItemStack(Items.wooden_axe    ), 1500);
		this.addSmelting(Items.wooden_hoe    , new ItemStack(Items.wooden_hoe    ), 1500);
		this.addSmelting(Items.wooden_sword  , new ItemStack(Items.wooden_sword  ), 1500);

		this.addSmelting(Items.stone_pickaxe, new ItemStack(Items.stone_pickaxe), 4000);
		this.addSmelting(Items.stone_shovel , new ItemStack(Items.stone_shovel ), 4000);
		this.addSmelting(Items.stone_axe    , new ItemStack(Items.stone_axe    ), 4000);
		this.addSmelting(Items.stone_hoe    , new ItemStack(Items.stone_hoe    ), 4000);
		this.addSmelting(Items.stone_sword  , new ItemStack(Items.stone_sword  ), 4000);

		this.addSmelting(Items.iron_pickaxe, new ItemStack(Items.iron_pickaxe), 4800);
		this.addSmelting(Items.iron_shovel , new ItemStack(Items.iron_shovel ), 4800);
		this.addSmelting(Items.iron_axe    , new ItemStack(Items.iron_axe    ), 4800);
		this.addSmelting(Items.iron_hoe    , new ItemStack(Items.iron_hoe    ), 4800);
		this.addSmelting(Items.iron_sword  , new ItemStack(Items.iron_sword  ), 4800);

		this.addSmelting(Items.golden_pickaxe, new ItemStack(Items.golden_pickaxe), 6000);
		this.addSmelting(Items.golden_shovel , new ItemStack(Items.golden_shovel ), 6000);
		this.addSmelting(Items.golden_axe    , new ItemStack(Items.golden_axe    ), 6000);
		this.addSmelting(Items.golden_hoe    , new ItemStack(Items.golden_hoe    ), 6000);
		this.addSmelting(Items.golden_sword  , new ItemStack(Items.golden_sword  ), 6000);

		this.addSmelting(Items.diamond_pickaxe, new ItemStack(Items.diamond_pickaxe), 7200);
		this.addSmelting(Items.diamond_shovel , new ItemStack(Items.diamond_shovel ), 7200);
		this.addSmelting(Items.diamond_axe    , new ItemStack(Items.diamond_axe    ), 7200);
		this.addSmelting(Items.diamond_hoe    , new ItemStack(Items.diamond_hoe    ), 7200);
		this.addSmelting(Items.diamond_sword  , new ItemStack(Items.diamond_sword  ), 7200);
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
