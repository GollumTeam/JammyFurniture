package mods.jammyfurniture.common.crafting;

import java.util.HashMap;
import java.util.Map;

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
		this.addSmelting(Item.bucketEmpty, new ItemStack(Item.bucketWater, 1, 0));
		this.addSmelting(Item.glassBottle, new ItemStack(Item.potion, 1, 0));
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
