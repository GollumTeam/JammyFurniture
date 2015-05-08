package com.gollum.jammyfurniture.inits;

import com.gollum.core.common.creativetab.GollumCreativeTabs;

public class ModCreativeTab {

	public static GollumCreativeTabs tabJammyFurniture = new GollumCreativeTabs("JammyFurniture");
	
	public static void init() {
		ModCreativeTab.tabJammyFurniture.setIcon(ModBlocks.blockArmChair);
	}
}
