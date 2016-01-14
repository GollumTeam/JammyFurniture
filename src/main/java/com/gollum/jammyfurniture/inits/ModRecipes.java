package com.gollum.jammyfurniture.inits;

import com.gollum.jammyfurniture.ModJammyFurniture;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes extends ModJammyFurniture {
	
	public static void init() {
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 0), new Object[] { " W ", "WWW", "WWW", 'W', Blocks.planks });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 1), new Object[] { " WW", "IWW", " WW", 'W', Blocks.planks, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 5), new Object[] { " W ", "WCW", "WWW", 'W', Blocks.planks, 'C', Items.clock });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 9), new Object[] { "BBB", "BBB", 'B', ModItems.itemBlindPart });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 2, 13), new Object[] { Blocks.crafting_table });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 2, 14), new Object[] { Blocks.wooden_slab });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne  , 1, 15), new Object[] { "PPP", "S S", "S S", 'P', Blocks.planks, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 0) , new Object[] { "PPP", "I P", "PPP", 'P', Blocks.planks, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 4) , new Object[] { "SSS", "I P", "PPP", 'S', new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 14), 'I', Items.iron_ingot, 'P', Blocks.planks });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 8) , new Object[] { "WIW", "WGW", "WWB", 'W', Blocks.log, 'I', Items.iron_ingot, 'G', Blocks.glass, 'B', Blocks.stone_button });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 12), new Object[] { "PWP", "PPP", 'P', Blocks.planks, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 13), new Object[] { "PWP", "PPP", 'P', Blocks.planks, 'W', new ItemStack(Blocks.wool, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 14), new Object[] { "PWP", "PPP", 'P', Blocks.planks, 'W', new ItemStack(Blocks.wool, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 15), new Object[] { "PWP", "PPP", 'P', Blocks.planks, 'W', new ItemStack(Blocks.wool, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksThree, 1, 0) , new Object[] { "P  ", "PP ", "SS ", 'P', Blocks.planks, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksThree, 1, 4) , new Object[] { "I  ", "PPB", "PPP", 'I', Items.iron_ingot, 'P', Blocks.planks, 'B', Blocks.stone_button });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksFour, 1, 0) , new Object[] { "WWW", "WPW", "SPS", 'W', Blocks.log, 'P', Blocks.planks, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksFour, 1, 8) , new Object[] { "SSS", "BSB", " S ", 'S', Items.stick, 'B', Items.slime_ball });
		
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockBathTub      , 1, 0) , new Object[] { "I I", "III", 'I', Blocks.iron_block });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 0) , new Object[] { "III", "ISI", "III", 'I', Items.iron_ingot, 'S', ModItems.itemLightBulb });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 4) , new Object[] { "III", "ISI", "III", 'I', Items.iron_ingot, 'S', Blocks.snow });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 8) , new Object[] { "I I", "IFI", "III", 'I', Items.iron_ingot, 'F', Blocks.furnace });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 12), new Object[] { " I ", "IBI", "III", 'B', Items.lava_bucket, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 13), new Object[] { "IGI", "I I", 'G',  Blocks.glass, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksTwo, 1, 0) , new Object[] { "BBI", "I I", "III", 'I', Items.iron_ingot, 'B', Blocks.stone_button });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksTwo, 1, 4) , new Object[] { "BBB", "IDI", "III", 'B', Blocks.stone_button, 'I', Items.iron_ingot, 'D', ModItems.itemWMDrum });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 0),  new Object[] { "CCC", "I C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 4),  new Object[] { "CIC", " C ", " C ", 'C', ModItems.itemCeramicPanel, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 8),  new Object[] { " I ", "C C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 12), new Object[] { "CI ", "C C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 0),  new Object[] { "  B", " BB", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 4),  new Object[] { " B ", " B ", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 8),  new Object[] { "B B", "BBB", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 12), new Object[] { "S" , "I" , 'S', Blocks.stone, 'I', new ItemStack(Items.dye, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 0), 'R', Items.redstone, 'S', Items.egg });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 12), 'R', Items.redstone, 'S', Items.leather });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 5), 'R', Items.redstone, 'S', Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 15), 'R', Items.redstone, 'S', Items.ender_eye });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 6), 'R', Items.redstone, 'S', Items.porkchop });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 4) , new Object[] { "WWW", "WWW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 0), 'R', Items.redstone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 8), 'R', Items.redstone, 'S', Items.bone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 15), 'R', Items.redstone, 'S', Items.spider_eye });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 0) , new Object[] { "WWW", "ASA", "ARA", 'W', new ItemStack(Blocks.wool, 1, 12), 'A', new ItemStack(Blocks.wool, 1, 6), 'R', Items.redstone, 'S', Items.wooden_pickaxe });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 0), 'R', Items.redstone, 'S', Items.bone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 13), 'R', Items.redstone, 'S', Items.rotten_flesh });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 15), 'R', Items.redstone, 'S', new ItemStack(Items.dye, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 15), 'R', Items.redstone, 'S', Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 5), 'R', Items.redstone, 'S', Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Blocks.wool, 1, 1), 'R', Items.redstone, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 12), new Object[] { "WAA", "WSA", "WRW", 'W', new ItemStack(Blocks.wool, 1, 6), 'A', new ItemStack(Blocks.wool, 1, 13), 'R', Items.redstone, 'S', Items.ender_eye });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 0) , new Object[] { "P P", "PWP", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 4) , new Object[] { "P P", "PWP", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 8) , new Object[] { "P P", "PWP", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 12), new Object[] { "P P", "PWP", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 0) , new Object[] { "P  ", "PW ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 4) , new Object[] { "P  ", "PW ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 8) , new Object[] { "P  ", "PW ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 12), new Object[] { "P  ", "PW ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 0) , new Object[] { " P ", "WP ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 4) , new Object[] { " P ", "WP ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 8) , new Object[] { " P ", "WP ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 12), new Object[] { " P ", "WP ", "SS ", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 0) , new Object[] { "   ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 4) , new Object[] { "   ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 8) , new Object[] { "   ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 12), new Object[] { "   ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 0) , new Object[] { " W ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 4) , new Object[] { " W ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 8) , new Object[] { " W ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 12), new Object[] { " W ", "WWW", "S S", 'P', Blocks.planks, 'S', Items.stick, 'W', new ItemStack(Blocks.wool, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 0), new Object[] { "CBC", "BBB", "BBB", 'B', Blocks.brick_block, 'C', Items.clay_ball });
		
		GameRegistry.addSmelting(ModItems.itemMantlePieceUnf, new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 4), 0.5F);
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 8), new Object[] {
			"ABC", 
			"GDR", 
			"SWS",
			'W', Blocks.log    ,
			'S', Blocks.stone   ,
			'R', Items.redstone, 
			'G', Items.glowstone_dust, 
			'A', new ItemStack(Blocks.wool, 1, 14),
			'B', new ItemStack(Blocks.wool, 1, 3) ,
			'C', new ItemStack(Blocks.wool, 1, 1) ,
			'D', new ItemStack(Blocks.wool, 1, 5)
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 0), new Object[] { " S ", "WLW", 'S', Blocks.tallgrass, 'L', ModItems.itemLightBulb, 'W', Blocks.wool });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 4), new Object[] { " I ", "GLG", " II", 'G', Blocks.glass, 'L', ModItems.itemLightBulb, 'I', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 8), new Object[] { "WBW", "WSW", "SSS", 'S', Items.stick, 'B', ModItems.itemLightBulb, 'W', Blocks.wool });
		
		GameRegistry.addRecipe(new ItemStack(ModItems.itemLightBulb      , 1), new Object[] { " G ", "GTG", " G ", 'G',  Blocks.glass, 'T', Blocks.torch });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemMantlePieceUnf , 1), new Object[] { "CCC", "C C", "C C", 'C', Items.clay_ball });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCeramicPanelUnf, 1), new Object[] { "CCC", "CCC", 'C', Items.clay_ball });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemWMDrum         , 1), new Object[] { " I ", "IFI", " I ", 'I', Items.iron_ingot, 'F', Blocks.red_flower });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemWMDrum         , 1), new Object[] { " I ", "IFI", " I ", 'I', Items.iron_ingot, 'F', Blocks.yellow_flower });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBlindPart      , 6), new Object[] { "WWW", 'W', Blocks.wooden_slab });
		
		GameRegistry.addSmelting(ModItems.itemCeramicPanelUnf, new ItemStack(ModItems.itemCeramicPanel, 1, 0), 0.5F);
	}
}
