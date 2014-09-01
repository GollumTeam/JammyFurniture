package mods.jammyfurniture.common.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		
		this.addSmelting(Item.bootsLeather  , new ItemStack(Item.bootsLeather) , 1500);
		this.addSmelting(Item.helmetLeather , new ItemStack(Item.helmetLeather), 1500);
		this.addSmelting(Item.plateLeather  , new ItemStack(Item.plateLeather) , 1500);
		this.addSmelting(Item.legsLeather   , new ItemStack(Item.legsLeather)  , 1500);

		this.addSmelting(Item.bootsIron     , new ItemStack(Item.bootsIron)    , 4000);
		this.addSmelting(Item.helmetIron    , new ItemStack(Item.helmetIron)   , 4000);
		this.addSmelting(Item.plateIron     , new ItemStack(Item.plateIron)    , 4000);
		this.addSmelting(Item.legsIron      , new ItemStack(Item.legsIron)     , 4000);

		this.addSmelting(Item.bootsGold     , new ItemStack(Item.bootsGold)    , 4800);
		this.addSmelting(Item.helmetGold    , new ItemStack(Item.helmetGold)   , 4800);
		this.addSmelting(Item.plateGold     , new ItemStack(Item.plateGold)    , 4800);
		this.addSmelting(Item.legsGold      , new ItemStack(Item.legsGold)     , 4800);
		
		this.addSmelting(Item.bootsChain    , new ItemStack(Item.bootsChain)   , 6000);
		this.addSmelting(Item.helmetChain   , new ItemStack(Item.helmetChain)  , 6000);
		this.addSmelting(Item.plateChain    , new ItemStack(Item.plateChain)   , 6000);
		this.addSmelting(Item.legsChain     , new ItemStack(Item.legsChain)    , 6000);
		
		this.addSmelting(Item.bootsDiamond  , new ItemStack(Item.bootsDiamond) , 7200);
		this.addSmelting(Item.helmetDiamond , new ItemStack(Item.helmetDiamond), 7200);
		this.addSmelting(Item.plateDiamond  , new ItemStack(Item.plateDiamond) , 7200);
		this.addSmelting(Item.legsDiamond   , new ItemStack(Item.legsDiamond)  , 7200);
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
			rtn = this.smeltingList.get (item).itemStack;
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
