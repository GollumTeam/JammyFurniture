package com.gollum.jammyfurniture.common.config;

import com.gollum.core.common.config.Config;
import com.gollum.core.common.config.ConfigProp;
import com.gollum.core.common.config.ConfigProp.Type;

public class ConfigJammyFuniture extends Config {
	
	////////////////
	// Blocks IDs //
	////////////////
	
	@ConfigProp(group = "Blocks Ids") public int blockWoodBlocksOneID = 1200;
	@ConfigProp(group = "Blocks Ids") public int blockWoodBlocksTwoID = 1201;
	@ConfigProp(group = "Blocks Ids") public int blockWoodBlocksThreeID = 1203;
	@ConfigProp(group = "Blocks Ids") public int blockWoodBlocksFourID = 1221;
	@ConfigProp(group = "Blocks Ids") public int blockBathTubID = 1204;
	@ConfigProp(group = "Blocks Ids") public int blockIronBlocksOneID = 1205;
	@ConfigProp(group = "Blocks Ids") public int blockIronBlocksTwoID = 1206;
	@ConfigProp(group = "Blocks Ids") public int blockCeramicBlocksOneID = 1207;
	@ConfigProp(group = "Blocks Ids") public int blockRoofingBlocksOneID = 1208;
	@ConfigProp(group = "Blocks Ids") public int blockMobHeadsOneID = 1209;
	@ConfigProp(group = "Blocks Ids") public int blockMobHeadsTwoID = 1210;
	@ConfigProp(group = "Blocks Ids") public int blockMobHeadsThreeID = 1211;
	@ConfigProp(group = "Blocks Ids") public int blockMobHeadsFourID = 1212;
	@ConfigProp(group = "Blocks Ids") public int blockArmChairID = 1213;
	@ConfigProp(group = "Blocks Ids") public int blockSofaPartLeftID = 1214;
	@ConfigProp(group = "Blocks Ids") public int blockSofaPartRightID = 1215;
	@ConfigProp(group = "Blocks Ids") public int blockSofaPartCenterID = 1216;
	@ConfigProp(group = "Blocks Ids") public int blockSofaPartCornerID = 1217;
	@ConfigProp(group = "Blocks Ids") public int blockMiscBlocksOneID = 1218;
	@ConfigProp(group = "Blocks Ids") public int blockLightsOnID = 1219;
	@ConfigProp(group = "Blocks Ids") public int blockLightsOffID = 1220;

	///////////////
	// Items IDs //
	///////////////
	
	@ConfigProp(group = "Items Ids") public int itemLightBulbID = 5000;
	@ConfigProp(group = "Items Ids") public int itemMantlePieceUnfID = 5001;
	@ConfigProp(group = "Items Ids") public int itemCeramicPanelUnfID = 5002;
	@ConfigProp(group = "Items Ids") public int itemCeramicPanelID = 5003;
	@ConfigProp(group = "Items Ids") public int itemWMDrumID = 5004;
	@ConfigProp(group = "Items Ids") public int itemBlindPartID = 5005;
	
	/////////////////
	// Head Sounds //
	/////////////////
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadChicken   = "mob.chicken.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadCow       = "mob.cow.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadCreeper   = "random.fuse";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadPig       = "mob.pig.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSheep     = "mob.sheep.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSkeleton  = "mob.skeleton.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSpider    = "mob.spider.say";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSteve     = "random.eat";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadWolf      = "mob.wolf.growl";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadZombie    = "mob.zombie.say";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadEnderman  = "mob.endermen.idle";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSlim      = "mob.slime.big";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadBlaze     = "mob.blaze.breathe";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadZombiepig = "mob.zombiepig.zpig";
	
}
