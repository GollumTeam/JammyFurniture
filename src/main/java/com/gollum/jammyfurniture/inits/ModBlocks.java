package com.gollum.jammyfurniture.inits;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import net.minecraft.block.Block;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.blocks.BlockProximitySpawn;
import com.gollum.jammyfurniture.common.block.BathBlock;
import com.gollum.jammyfurniture.common.block.BlockLights;
import com.gollum.jammyfurniture.common.block.BlockSofa;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne;
import com.gollum.jammyfurniture.common.block.head.MobHeadsFour;
import com.gollum.jammyfurniture.common.block.head.MobHeadsOne;
import com.gollum.jammyfurniture.common.block.head.MobHeadsThree;
import com.gollum.jammyfurniture.common.block.head.MobHeadsTwo;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo;
import com.gollum.jammyfurniture.common.block.misc.MiscBlocksOne;
import com.gollum.jammyfurniture.common.block.roofing.RoofingBlocksOne;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;

public class ModBlocks {

	/////////////////////
	// Liste des blocs //
	/////////////////////
	
	public static Block blockWoodBlocksOne;
	public static Block blockWoodBlocksTwo;
	public static Block blockWoodBlocksThree;
	public static Block blockWoodBlocksFour;
	public static Block blockBathTub;
	public static Block blockIronBlocksOne;
	public static Block blockIronBlocksTwo;
	public static Block blockCeramicBlocksOne;
	public static Block blockRoofingBlocksOne;
	public static Block blockMobHeadsOne;
	public static Block blockMobHeadsTwo;
	public static Block blockMobHeadsThree;
	public static Block blockMobHeadsFour;
	public static Block blockArmChair;
	public static Block blockSofaPartLeft;
	public static Block blockSofaPartRight;
	public static Block blockSofaPartCenter;
	public static Block blockSofaPartCorner;
	public static Block blockMiscBlocksOne;
	public static Block blockLightsOn;
	public static Block blockLightsOff;
	
	public static void init() {
		
//		ModBlocks.blockBathTub          = new BathBlock       (config.blockBathTubID         , "BathBlock"       ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
//		ModBlocks.blockLightsOn         = new BlockLights     (config.blockLightsOnID        , "LightsOn" ,true  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.3F);
//		ModBlocks.blockLightsOff        = new BlockLights     (config.blockLightsOffID       , "LightsOff",false )                                       .setHardness(0.3F);
//		
//		
		ModBlocks.blockWoodBlocksOne    = new WoodBlocksOne   (config.blockWoodBlocksOneID   , "WoodBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		ModBlocks.blockWoodBlocksTwo    = new WoodBlocksTwo   (config.blockWoodBlocksTwoID   , "WoodBlocksTwo"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		ModBlocks.blockWoodBlocksThree  = new WoodBlocksThree (config.blockWoodBlocksThreeID , "WoodBlocksThree" ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		ModBlocks.blockWoodBlocksFour   = new WoodBlocksFour  (config.blockWoodBlocksFourID  , "WoodBlocksFour"  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		
//		ModBlocks.blockIronBlocksOne    = new IronBlocksOne   (config.blockIronBlocksOneID   , "IronBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
//		ModBlocks.blockIronBlocksTwo    = new IronBlocksTwo   (config.blockIronBlocksTwoID   , "IronBlocksTwo"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
//		
//		ModBlocks.blockCeramicBlocksOne = new CeramicBlocksOne(config.blockCeramicBlocksOneID, "CeramicBlocksOne").setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F);
//		
//		ModBlocks.blockRoofingBlocksOne = new RoofingBlocksOne(config.blockRoofingBlocksOneID, "RoofingBlocksOne").setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		
//		ModBlocks.blockMiscBlocksOne    = new MiscBlocksOne   (config.blockMiscBlocksOneID   , "MiscBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(10.0F);
//		
//		ModBlocks.blockMobHeadsOne      = new MobHeadsOne     (config.blockMobHeadsOneID     , "MobHeadsOne"     ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsTwo      = new MobHeadsTwo     (config.blockMobHeadsTwoID     , "MobHeadsTwo"     ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsThree    = new MobHeadsThree   (config.blockMobHeadsThreeID   , "MobHeadsThree"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsFour     = new MobHeadsFour    (config.blockMobHeadsFourID    , "MobHeadsFour"    ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		
//		ModBlocks.blockArmChair         = new BlockSofa(config.blockArmChairID      , "ArmChair"  , TileEntityArmChair.class  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartLeft     = new BlockSofa(config.blockSofaPartLeftID  , "SofaLeft"  , TileEntitySofaLeft.class  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartRight    = new BlockSofa(config.blockSofaPartRightID , "SofaRight" , TileEntitySofaRight.class ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartCenter   = new BlockSofa(config.blockSofaPartCenterID, "SofaCenter", TileEntitySofaCenter.class).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartCorner   = new BlockSofa(config.blockSofaPartCornerID, "SofaCorner", TileEntitySofaCorner.class).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
		
	}
}
