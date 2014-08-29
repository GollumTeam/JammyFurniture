package mods.jammyfurniture.common.crafting;

import net.minecraft.item.ItemStack;

public class CookerRecipes {
	
	private CookerRecipes() {
	}

	private static CookerRecipes smeltingBase = new CookerRecipes();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static CookerRecipes smelting()
	{
		return smeltingBase;
	}
	
	
	// TODO a faire hérité :)
	public ItemStack getSmeltingResult(int itemId) {
		
		
		return null;
//		return (ItemStack) this.smeltingList.get(Integer.valueOf(par1));
	}

//
	public ItemStack getSmeltingResult(ItemStack item) {
//		if (item == null) {
			return null;
//		} else {
//			ItemStack ret = (ItemStack) this.metaSmeltingList.get(Arrays.asList(new Integer[] { Integer.valueOf(item.itemID), Integer.valueOf(item.getItemDamage()) }));
//			return ret != null ? ret : (ItemStack) this.smeltingList.get(Integer.valueOf(item.itemID));
//		}
	}
}
