package mods.jammyfurniture.common.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.jammyfurniture.ModJammyFurniture;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JFRecipes extends ModJammyFurniture {
	
	public static void initRecipes() {
		
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksOne, 1, 0), new Object[] { " W ", "WWW", "WWW", 'W', Block.planks });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksOne, 1, 4), new Object[] { " WW", "IWW", " WW", 'W', Block.planks, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksOne, 1, 5), new Object[] { " W ", "WCW", "WWW", 'W', Block.planks, 'C', Item.pocketSundial });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksOne, 1, 9), new Object[] { "BBB", "BBB", 'B', itemBlindPart });
		
		GameRegistry.addShapelessRecipe(new ItemStack(blockWoodBlocksOne, 2, 13), new Object[] { Block.workbench });
		GameRegistry.addShapelessRecipe(new ItemStack(blockWoodBlocksOne, 2, 14), new Object[] { Block.woodSingleSlab });
		
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksOne  , 1, 15), new Object[] { "PPP", "S S", "S S", 'P', Block.planks, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 0) , new Object[] { "PPP", "I P", "PPP", 'P', Block.planks, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 4) , new Object[] { "SSS", "I P", "PPP", 'S', new ItemStack(blockWoodBlocksOne, 1, 14), 'I', Item.ingotIron, 'P', Block.planks });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 8) , new Object[] { "WIW", "WGW", "WWB", 'W', Block.wood, 'I', Item.ingotIron, 'G', Block.glass, 'B', Block.stoneButton });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 12), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 13), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 14), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksTwo  , 1, 15), new Object[] { "PWP", "PPP", 'P', Block.planks, 'W', new ItemStack(Block.cloth, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksThree, 1, 0) , new Object[] { "P  ", "PP ", "SS ", 'P', Block.planks, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(blockWoodBlocksThree, 1, 4) , new Object[] { "I  ", "PPB", "PPP", 'I', Item.ingotIron, 'P', Block.planks, 'B', Block.stoneButton });
		
		GameRegistry.addRecipe(new ItemStack(itemBathTub       , 1, 0) , new Object[] { "I I", "III", 'I', Block.blockIron });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksOne, 1, 0) , new Object[] { "III", "ISI", "III", 'I', Item.ingotIron, 'S', itemLightBulb });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksOne, 1, 4) , new Object[] { "III", "ISI", "III", 'I', Item.ingotIron, 'S', Block.blockSnow });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksOne, 1, 8) , new Object[] { "I I", "IFI", "III", 'I', Item.ingotIron, 'F', Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksOne, 1, 12), new Object[] { " I ", "IBI", "III", 'B', Item.bucketLava, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksOne, 1, 13), new Object[] { "IGI", "I I", 'G', Block.thinGlass, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksTwo, 1, 0) , new Object[] { "BBI", "I I", "III", 'I', Item.ingotIron, 'B', Block.stoneButton });
		GameRegistry.addRecipe(new ItemStack(blockIronBlocksTwo, 1, 4) , new Object[] { "BBB", "IDI", "III", 'B', Block.stoneButton, 'I', Item.ingotIron, 'D', itemWMDrum });
		
		GameRegistry.addRecipe(new ItemStack(blockCeramicBlocksOne, 1, 0), new Object[] { "CCC", "I C", "CCC", 'C', itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockCeramicBlocksOne, 1, 4), new Object[] { "CIC", " C ", " C ", 'C', itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockCeramicBlocksOne, 1, 8), new Object[] { " I ", "C C", "CCC", 'C', itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockCeramicBlocksOne, 1, 12), new Object[] { "CI ", "C C", "CCC", 'C', itemCeramicPanel, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockRoofingBlocksOne, 6, 0), new Object[] { "  B", " BB", "BBB", 'B', new ItemStack(blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(blockRoofingBlocksOne, 6, 4), new Object[] { " B ", " B ", "BBB", 'B', new ItemStack(blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(blockRoofingBlocksOne, 6, 8), new Object[] { "B B", "BBB", "BBB", 'B', new ItemStack(blockRoofingBlocksOne, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(blockRoofingBlocksOne, 6, 12), new Object[] { "S", "I", 'S', Block.stone, 'I', new ItemStack(Item.dyePowder, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsOne  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone, 'S', Item.egg });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsOne  , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 12), 'R', Item.redstone, 'S', Item.leather });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsOne  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 5), 'R', Item.redstone, 'S', Item.gunpowder });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsOne  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.eyeOfEnder });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsTwo  , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 6), 'R', Item.redstone, 'S', Item.porkRaw });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsTwo  , 1, 4) , new Object[] { "WWW", "WWW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsTwo  , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 8), 'R', Item.redstone, 'S', Item.bone });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsTwo  , 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.spiderEye });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsThree, 1, 0) , new Object[] { "WWW", "ASA", "ARA", 'W', new ItemStack(Block.cloth, 1, 12), 'A', new ItemStack(Block.cloth, 1, 6), 'R', Item.redstone, 'S', Item.pickaxeWood });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsThree, 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 0), 'R', Item.redstone, 'S', Item.bone });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsThree, 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 13), 'R', Item.redstone, 'S', Item.rottenFlesh });
		GameRegistry.addRecipe(new ItemStack(blockMobHeadsThree, 1, 12), new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', new ItemStack(Item.dyePowder, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(blcokMobHeadsFour , 1, 0) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 15), 'R', Item.redstone, 'S', Item.enderPearl });
		GameRegistry.addRecipe(new ItemStack(blcokMobHeadsFour , 1, 4) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 5), 'R', Item.redstone, 'S', Item.slimeBall });
		GameRegistry.addRecipe(new ItemStack(blcokMobHeadsFour , 1, 8) , new Object[] { "WWW", "WSW", "WRW", 'W', new ItemStack(Block.cloth, 1, 1), 'R', Item.redstone, 'S', Item.blazeRod });
		GameRegistry.addRecipe(new ItemStack(blcokMobHeadsFour , 1, 12), new Object[] { "WAA", "WSA", "WRW", 'W', new ItemStack(Block.cloth, 1, 6), 'A', new ItemStack(Block.cloth, 1, 13), 'R', Item.redstone, 'S', Item.eyeOfEnder });
		
		GameRegistry.addRecipe(new ItemStack(blockArmChair, 1, 0) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockArmChair, 1, 4) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(blockArmChair, 1, 8) , new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(blockArmChair, 1, 12), new Object[] { "P P", "PWP", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(blockSofaPartLeft  , 1, 0) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartLeft  , 1, 4) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartLeft  , 1, 8) , new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartLeft  , 1, 12), new Object[] { "P  ", "PW ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartRight , 1, 0) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartRight , 1, 4) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartRight , 1, 8) , new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartRight , 1, 12), new Object[] { " P ", "WP ", "SS ", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCenter, 1, 0) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCenter, 1, 4) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCenter, 1, 8) , new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCenter, 1, 12), new Object[] { "   ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCorner, 1, 0) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCorner, 1, 4) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 3)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCorner, 1, 8) , new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 5)  });
		GameRegistry.addRecipe(new ItemStack(blockSofaPartCorner, 1, 12), new Object[] { " W ", "WWW", "S S", 'P', Block.planks, 'S', Item.stick, 'W', new ItemStack(Block.cloth, 1, 7)  });
		
		GameRegistry.addRecipe(new ItemStack(blockMiscBlocksOne, 1, 0), new Object[] { "CBC", "BBB", "BBB", 'B', Block.brick, 'C', Item.clay });
		
		GameRegistry.addSmelting(itemMantlePieceUnf.itemID, new ItemStack(blockMiscBlocksOne, 1, 4), 0.5F);
		
		GameRegistry.addRecipe(new ItemStack(blockMiscBlocksOne, 1, 8), new Object[] {
			"ABC"        , "GDR", "SWS"         , 'W', 
			Block.wood   , 'S'  , Block.stone   , 'R', 
			Item.redstone, 'G'  , Item.glowstone, 'A', 
			new ItemStack(Block.cloth, 1, 14), 'B', 
			new ItemStack(Block.cloth, 1, 3) , 'C', 
			new ItemStack(Block.cloth, 1, 1) , 'D',
			new ItemStack(Block.cloth, 1, 5)
		});
		
		GameRegistry.addRecipe(new ItemStack(blockLightsOn, 1, 0), new Object[] { " S ", "WLW", 'S', Item.silk, 'L', itemLightBulb, 'W', Block.cloth });
		GameRegistry.addRecipe(new ItemStack(blockLightsOn, 1, 4), new Object[] { " I ", "GLG", " II", 'G', Block.thinGlass, 'L', itemLightBulb, 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(blockLightsOn, 1, 8), new Object[] { "WBW", "WSW", "SSS", 'S', Item.stick, 'B', itemLightBulb, 'W', Block.cloth });
		
		GameRegistry.addRecipe(new ItemStack(itemLightBulb      , 1), new Object[] { " G ", "GTG", " G ", 'G', Block.thinGlass, 'T', Block.torchWood });
		GameRegistry.addRecipe(new ItemStack(itemMantlePieceUnf , 1), new Object[] { "CCC", "C C", "C C", 'C', Item.clay });
		GameRegistry.addRecipe(new ItemStack(itemCeramicPanelUnf, 1), new Object[] { "CCC", "CCC", 'C', Item.clay });
		GameRegistry.addRecipe(new ItemStack(itemWMDrum         , 1), new Object[] { " I ", "I I", " I ", 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(itemBlindPart      , 6), new Object[] { "WWW", 'W', Block.woodSingleSlab });
		
		GameRegistry.addSmelting(itemCeramicPanelUnf.itemID, new ItemStack(itemCeramicPanel, 1, 0), 0.5F);
	}
}
