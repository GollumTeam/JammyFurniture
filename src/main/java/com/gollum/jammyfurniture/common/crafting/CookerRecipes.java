package mods.jammyfurniture.common.crafting;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;


public class CookerRecipes {
	
	private static CookerRecipes smelting = new CookerRecipes();
	
	public static CookerRecipes smelting () {
		return smelting;
	}
	
	public ItemStack getSmeltingResult(ItemStack item) {
		ItemStack rtn = FurnaceRecipes.smelting().getSmeltingResult(item);
		
		if (rtn == null || !(rtn.getItem() instanceof ItemFood)) {
			return null;
		}
		
		return rtn;
	}
}
