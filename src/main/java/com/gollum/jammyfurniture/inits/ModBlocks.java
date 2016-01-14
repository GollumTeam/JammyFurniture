package com.gollum.jammyfurniture.inits;

import com.gollum.core.inits.ModItems;
import com.gollum.core.tools.registry.BuildingBlockRegistry;
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
import com.gollum.jammyfurniture.common.building.handler.BathBlockBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.BlockLightsBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.BlockSofaBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.CeramicBlocksOneBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.IronBlocksOneBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.IronBlocksTwoBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.JFMobHeadsBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.MiscBlocksOneBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.RoofingBlocksOneBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.WoodBlocksFourBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.WoodBlocksOneBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.WoodBlocksThreeBuildingHandler;
import com.gollum.jammyfurniture.common.building.handler.WoodBlocksTwoBuildingHandler;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;

import net.minecraft.block.Block;

public class ModBlocks {

	/////////////////////
	// Liste des blocs //
	/////////////////////
	
	public static WoodBlocksOne   blockWoodBlocksOne;
	public static WoodBlocksTwo   blockWoodBlocksTwo;
	public static WoodBlocksThree blockWoodBlocksThree;
	public static WoodBlocksFour  blockWoodBlocksFour;
	public static BathBlock blockBathTub;
	public static IronBlocksOne blockIronBlocksOne;
	public static IronBlocksTwo blockIronBlocksTwo;
	public static CeramicBlocksOne blockCeramicBlocksOne;
	public static RoofingBlocksOne blockRoofingBlocksOne;
	public static MobHeadsOne   blockMobHeadsOne;
	public static MobHeadsTwo   blockMobHeadsTwo;
	public static MobHeadsThree blockMobHeadsThree;
	public static MobHeadsFour  blockMobHeadsFour;
	public static BlockSofa blockArmChair;
	public static BlockSofa blockSofaPartLeft;
	public static BlockSofa blockSofaPartRight;
	public static BlockSofa blockSofaPartCenter;
	public static BlockSofa blockSofaPartCorner;
	public static MiscBlocksOne blockMiscBlocksOne;
	public static BlockLights blockLightsOn;
	public static BlockLights blockLightsOff;
	
	public static void init() {
		initBlock ();
		initHandlerRotation ();
	}

	public static void initBlock() {
		
//		ModBlocks.blockBathTub          = (BathBlock)  new BathBlock       ("Bath"            ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
		ModBlocks.blockLightsOn         = (BlockLights)new BlockLights     ("LightsOn" ,true  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.3F);
		ModBlocks.blockLightsOff        = (BlockLights)new BlockLights     ("LightsOff",false )                                       .setHardness(0.3F);
		
		ModBlocks.blockWoodBlocksOne    = (WoodBlocksOne)  new WoodBlocksOne   ("WoodBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		ModBlocks.blockWoodBlocksTwo    = (WoodBlocksTwo)  new WoodBlocksTwo   ("WoodBlocksTwo"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		ModBlocks.blockWoodBlocksThree  = (WoodBlocksThree)new WoodBlocksThree ("WoodBlocksThree" ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		ModBlocks.blockWoodBlocksFour   = (WoodBlocksFour) new WoodBlocksFour  ("WoodBlocksFour"  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
//		
//		ModBlocks.blockIronBlocksOne    = (IronBlocksOne)new IronBlocksOne   ("IronBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
//		ModBlocks.blockIronBlocksTwo    = (IronBlocksTwo)new IronBlocksTwo   ("IronBlocksTwo"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundTypeWood);
//		
//		ModBlocks.blockCeramicBlocksOne = (CeramicBlocksOne)new CeramicBlocksOne("CeramicBlocksOne").setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F);
//		
//		ModBlocks.blockRoofingBlocksOne = (RoofingBlocksOne)new RoofingBlocksOne("RoofingBlocksOne").setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		
//		ModBlocks.blockMiscBlocksOne    = (MiscBlocksOne)new MiscBlocksOne   ("MiscBlocksOne"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(2.0F).setResistance(10.0F);
//		
//		ModBlocks.blockMobHeadsOne      = (MobHeadsOne)  new MobHeadsOne     ("MobHeadsOne"     ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsTwo      = (MobHeadsTwo)  new MobHeadsTwo     ("MobHeadsTwo"     ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsThree    = (MobHeadsThree)new MobHeadsThree   ("MobHeadsThree"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		ModBlocks.blockMobHeadsFour     = (MobHeadsFour) new MobHeadsFour    ("MobHeadsFour"    ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(0.8F);
//		
//		ModBlocks.blockArmChair         = (BlockSofa)new BlockSofa("ArmChair"  , TileEntityArmChair.class  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartLeft     = (BlockSofa)new BlockSofa("SofaLeft"  , TileEntitySofaLeft.class  ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartRight    = (BlockSofa)new BlockSofa("SofaRight" , TileEntitySofaRight.class ).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartCenter   = (BlockSofa)new BlockSofa("SofaCenter", TileEntitySofaCenter.class).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
//		ModBlocks.blockSofaPartCorner   = (BlockSofa)new BlockSofa("SofaCorner", TileEntitySofaCorner.class).setCreativeTab(ModCreativeTab.tabJammyFurniture).setHardness(1.2F);
		
	}
	
	public static void initHandlerRotation () {
		
		BuildingBlockRegistry.register(new BathBlockBuildingHandler());
		BuildingBlockRegistry.register(new BlockLightsBuildingHandler());
		BuildingBlockRegistry.register(new WoodBlocksOneBuildingHandler());
		BuildingBlockRegistry.register(new WoodBlocksTwoBuildingHandler());
		BuildingBlockRegistry.register(new WoodBlocksThreeBuildingHandler());
		BuildingBlockRegistry.register(new WoodBlocksFourBuildingHandler());
		BuildingBlockRegistry.register(new IronBlocksOneBuildingHandler());
		BuildingBlockRegistry.register(new IronBlocksTwoBuildingHandler());
		BuildingBlockRegistry.register(new CeramicBlocksOneBuildingHandler());
		BuildingBlockRegistry.register(new RoofingBlocksOneBuildingHandler());
		BuildingBlockRegistry.register(new MiscBlocksOneBuildingHandler());
		BuildingBlockRegistry.register(new JFMobHeadsBuildingHandler());
		BuildingBlockRegistry.register(new BlockSofaBuildingHandler());
		
	}
	
	
}
