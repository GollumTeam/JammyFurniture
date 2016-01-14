package com.gollum.jammyfurniture.inits;

import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes extends ModJammyFurniture {
	
	public static void init() {
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 0), new Object[] { " W ", "WWW", "WWW", 'W', Block.planks });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 1), new Object[] { " WW", "IWW", " WW", 'W', Block.planks, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 5), new Object[] { " W ", "WCW", "WWW", 'W', Block.planks, 'C', Item.pocketSundial });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 9), new Object[] { "BBB", "BBB", 'B', ModItems.itemBlindPart });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 2, 13), new Object[] { Block.workbench });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne, 2, 14), new Object[] { Block.woodSingleSlab });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksOne  , 1, 15), new Object[] { "PPP", "S S", "S S", 'P', Block.planks, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 0) , new Object[] { "PPP", "I P", "PPP", 'P', Block.planks, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 4) , new Object[] { "SSS", "I P", "PPP", 'S', new ItemStack(ModBlocks.blockWoodBlocksOne, 1, 14), 'I', Item.ingotIron, 'P', Block.planks });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 8) , new Object[] { "WIW", "WGW", "WWB", 'W', Block.wood, 'I', Item.ingotIron, 'G', Block.glass, 'B', Block.stoneButton });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 12), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 13), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 14), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksTwo  , 1, 15), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksThree, 1, 0) , new Object[] { "P  ", "PP ", "SS ", 'P', Block.planks, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksThree, 1, 4) , new Object[] { "I  ", "PPB", "PPP", 'I', Item.ingotIron, 'P', Block.planks, 'B', Block.stoneButton });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksFour, 1, 0) , new Object[] { "WWW", "WPW", "SPS", 'W', Block.wood, 'P', Block.planks, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWoodBlocksFour, 1, 8) , new Object[] { "SSS", "BSB", " S ", 'S', Item.stick, 'B', Item.slimeBall });
		
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockBathTub      , 1, 0) , new Object[] { "I I", "III", 'I', Block.blockIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 0) , new Object[] { "III", "ISI", "III", 'I', Item.ingotIron, 'S', ModItems.itemLightBulb });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 4) , new Object[] { "III", "ISI", "III", 'I', Item.ingotIron, 'S', Block.blockSnow });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 8) , new Object[] { "I I", "IFI", "III", 'I', Item.ingotIron, 'F', Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 12), new Object[] { " I ", "IBI", "III", 'B', Item.bucketLava, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksOne, 1, 13), new Object[] { "IGI", "I I", 'G', Block.thinGlass, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksTwo, 1, 0) , new Object[] { "BBI", "I I", "III", 'I', Item.ingotIron, 'B', Block.stoneButton });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockIronBlocksTwo, 1, 4) , new Object[] { "BBB", "IDI", "III", 'B', Block.stoneButton, 'I', Item.ingotIron, 'D', ModItems.itemWMDrum });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 0),  new Object[] { "CCC", "I C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 4),  new Object[] { "CIC", " C ", " C ", 'C', ModItems.itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 8),  new Object[] { " I ", "C C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockCeramicBlocksOne, 1, 12), new Object[] { "CI ", "C C", "CCC", 'C', ModItems.itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 0),  new Object[] { "  B", " BB", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 4),  new Object[] { " B ", " B ", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 8),  new Object[] { "B B", "BBB", "BBB", 'B', new ItemStack(ModBlocks.blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRoofingBlocksOne, 6, 12), new Object[] { "S" , "I" , 'S', Block.stone, 'I', new ItemStack(Item.dyePowder, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone, 'S', Item.egg });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 12), 'R', Item.redstone, 'S', Item.leather });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 5), 'R', Item.redstone, 'S', Item.gunpowder });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsOne  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.eyeOfEnder });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 6), 'R', Item.redstone, 'S', Item.porkRaw });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 4) , new Object[] { "WWW", "WWW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 8), 'R', Item.redstone, 'S', Item.bone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsTwo  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.spiderEye });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 0) , new Object[] { "WWW", "ASA", "ARA", 'W', new ItemStack(Block.cloth, 1, 12), 'A', new ItemStack(Block.cloth, 1, 6), 'R', Item.redstone, 'S', Item.pickaxeWood });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone, 'S', Item.bone });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 13), 'R', Item.redstone, 'S', Item.rottenFlesh });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsThree, 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', new ItemStack(Item.dyePowder, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.enderPearl });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 5), 'R', Item.redstone, 'S', Item.slimeBall });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 1), 'R', Item.redstone, 'S', Item.blazeRod });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMobHeadsFour , 1, 12), new Object[] { "WAA", "WSA", "WRW", 'W', new ItemStack(Block.cloth, 1, 6), 'A', new ItemStack(Block.cloth, 1, 13), 'R', Item.redstone, 'S', Item.eyeOfEnder });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 0) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 4) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 8) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockArmChair, 1, 12), new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 0) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 4) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 8) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartLeft  , 1, 12), new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 0) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 4) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 8) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartRight , 1, 12), new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 0) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 4) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 8) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCenter, 1, 12), new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 0) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 4) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 8) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSofaPartCorner, 1, 12), new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 0), new Object[] { "CBC", "BBB", "BBB", 'B', Block.brick, 'C', Item.clay });
		
		GameRegistry.addSmelting(ModItems.itemMantlePieceUnf.itemID, new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 4), 0.5F);
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMiscBlocksOne, 1, 8), new Object[] {
			"ABC", 
			"GDR", 
			"SWS",
			'W', Block.wood   ,
			'S', Block.stone   ,
			'R',  Item.redstone, 
			'G', Item.glowstone, 
			'A', new ItemStack(Block.cloth, 1, 14),
			'B', new ItemStack(Block.cloth, 1, 3) ,
			'C', new ItemStack(Block.cloth, 1, 1) ,
			'D', new ItemStack(Block.cloth, 1, 5)
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 0), new Object[] { " S ", "WLW", 'S', Item.silk, 'L', ModItems.itemLightBulb, 'W', Block.cloth });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 4), new Object[] { " I ", "GLG", " II", 'G', Block.thinGlass, 'L', ModItems.itemLightBulb, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLightsOn, 1, 8), new Object[] { "WBW", "WSW", "SSS", 'S', Item.stick, 'B', ModItems.itemLightBulb, 'W', Block.cloth });
		
		GameRegistry.addRecipe(new ItemStack(ModItems.itemLightBulb      , 1), new Object[] { " G ", "GTG", " G ", 'G', Block.thinGlass, 'T', Block.torchWood });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemMantlePieceUnf , 1), new Object[] { "CCC", "C C", "C C", 'C', Item.clay });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCeramicPanelUnf, 1), new Object[] { "CCC", "CCC", 'C', Item.clay });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemWMDrum         , 1), new Object[] { " I ", "IFI", " I ", 'I', Item.ingotIron, 'F', Block.plantRed });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemWMDrum         , 1), new Object[] { " I ", "IFI", " I ", 'I', Item.ingotIron, 'F', Block.plantYellow });
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBlindPart      , 6), new Object[] { "WWW", 'W', Block.woodSingleSlab });
		
		GameRegistry.addSmelting(ModItems.itemCeramicPanelUnf.itemID, new ItemStack(ModItems.itemCeramicPanel, 1, 0), 0.5F);
	}
}
