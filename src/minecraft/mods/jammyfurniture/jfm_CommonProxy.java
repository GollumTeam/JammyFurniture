package mods.jammyfurniture;

import mods.jammyfurniture.common.tilesentities.jfm_TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityBath;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMiscOne;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntitySofaRight;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityWoodBlocks;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityWoodBlocksTwo;
import cpw.mods.fml.common.registry.GameRegistry;

public class jfm_CommonProxy {
	public void preloadTextures() {
	}

	public void initRendering() {
	}

	public void preInitLoading() {
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(jfm_TileEntityWoodBlocks.class, "TileEntityWoodBlocks");
		GameRegistry.registerTileEntity(jfm_TileEntityWoodBlocksTwo.class, "TileEntityWoodBlocksTwo");
		GameRegistry.registerTileEntity(jfm_TileEntityWoodBlocksThree.class, "TileEntityWoodBlocksThree");
		GameRegistry.registerTileEntity(jfm_TileEntityBath.class, "TileEntityBath");
		GameRegistry.registerTileEntity(jfm_TileEntityIronBlocksOne.class, "TileEntityIronBlocksOne");
		GameRegistry.registerTileEntity(jfm_TileEntityIronBlocksTwo.class, "TileEntityIronBlocksTwo");
		GameRegistry.registerTileEntity(jfm_TileEntityCeramicBlocksOne.class, "TileEntityCeramicBlocksOne");
		GameRegistry.registerTileEntity(jfm_TileEntityRoofingBlocksOne.class, "TileEntityRoofingBlocksOne");
		GameRegistry.registerTileEntity(jfm_TileEntityMobHeadsOne.class, "TileEntityMobHeadsOne");
		GameRegistry.registerTileEntity(jfm_TileEntityMobHeadsTwo.class, "TileEntityMobHeadsTwo");
		GameRegistry.registerTileEntity(jfm_TileEntityMobHeadsThree.class, "TileEntityMobHeadsThree");
		GameRegistry.registerTileEntity(jfm_TileEntityMobHeadsFour.class, "TileEntityMobHeadsFour");
		GameRegistry.registerTileEntity(jfm_TileEntityArmChair.class, "TileEntityArmChair");
		GameRegistry.registerTileEntity(jfm_TileEntitySofaLeft.class, "TileEntitySofaLeft");
		GameRegistry.registerTileEntity(jfm_TileEntitySofaRight.class, "TileEntitySofaRight");
		GameRegistry.registerTileEntity(jfm_TileEntitySofaCenter.class, "TileEntitySofaCenter");
		GameRegistry.registerTileEntity(jfm_TileEntitySofaCorner.class, "TileEntitySofaCorner");
		GameRegistry.registerTileEntity(jfm_TileEntityMiscOne.class, "TileEntityMiscOne");
		GameRegistry.registerTileEntity(jfm_TileEntityLightsOn.class, "TileEntityLightsOn");
	}
}
