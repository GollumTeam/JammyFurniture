package com.gollum.jammyfurniture.inits;

import com.gollum.core.common.tileentities.TileEntityBlockProximitySpawn;
import com.gollum.jammyfurniture.common.tilesentities.TileEntityBath;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;
import com.gollum.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void init() {
		
		GameRegistry.registerTileEntity(TileEntityWoodBlocksOne.class   , "TileEntityWoodBlocks");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksTwo.class   , "TileEntityWoodBlocksTwo");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksThree.class , "TileEntityWoodBlocksThree");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksFour.class  , "TileEntityWoodBlocksFour");
		GameRegistry.registerTileEntity(TileEntityBath.class            , "TileEntityBath");
		GameRegistry.registerTileEntity(TileEntityIronBlocksOne.class   , "TileEntityIronBlocksOne");
		GameRegistry.registerTileEntity(TileEntityIronBlocksTwo.class   , "TileEntityIronBlocksTwo");
		GameRegistry.registerTileEntity(TileEntityCeramicBlocksOne.class, "TileEntityCeramicBlocksOne");
		GameRegistry.registerTileEntity(TileEntityRoofingBlocksOne.class, "TileEntityRoofingBlocksOne");
		GameRegistry.registerTileEntity(TileEntityMobHeadsOne.class     , "TileEntityMobHeadsOne");
		GameRegistry.registerTileEntity(TileEntityMobHeadsTwo.class     , "TileEntityMobHeadsTwo");
		GameRegistry.registerTileEntity(TileEntityMobHeadsThree.class   , "TileEntityMobHeadsThree");
		GameRegistry.registerTileEntity(TileEntityMobHeadsFour.class    , "TileEntityMobHeadsFour");
		GameRegistry.registerTileEntity(TileEntityArmChair.class        , "TileEntityArmChair");
		GameRegistry.registerTileEntity(TileEntitySofaLeft.class        , "TileEntitySofaLeft");
		GameRegistry.registerTileEntity(TileEntitySofaRight.class       , "TileEntitySofaRight");
		GameRegistry.registerTileEntity(TileEntitySofaCenter.class      , "TileEntitySofaCenter");
		GameRegistry.registerTileEntity(TileEntitySofaCorner.class      , "TileEntitySofaCorner");
		GameRegistry.registerTileEntity(TileEntityMiscBlockOne.class    , "TileEntityMiscOne");
		GameRegistry.registerTileEntity(TileEntityLightsOn.class        , "TileEntityLightsOn");
		GameRegistry.registerTileEntity(TileEntityLightsOff.class       , "TileEntityLightsOff");
		
	}
	
}
