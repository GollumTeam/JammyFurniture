package mods.jammyfurniture.client;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.render.JFInventoryRenderer;
import mods.jammyfurniture.client.render.jfm_ArmChairRenderer;
import mods.jammyfurniture.client.render.jfm_BathRenderer;
import mods.jammyfurniture.client.render.jfm_CeramicBlocksRendererOne;
import mods.jammyfurniture.client.render.jfm_IronBlocksRendererOne;
import mods.jammyfurniture.client.render.jfm_IronBlocksRendererTwo;
import mods.jammyfurniture.client.render.jfm_LightsRenderer;
import mods.jammyfurniture.client.render.jfm_MiscOneRenderer;
import mods.jammyfurniture.client.render.jfm_MobHeadsFourRenderer;
import mods.jammyfurniture.client.render.jfm_MobHeadsOneRenderer;
import mods.jammyfurniture.client.render.jfm_MobHeadsThreeRenderer;
import mods.jammyfurniture.client.render.jfm_MobHeadsTwoRenderer;
import mods.jammyfurniture.client.render.jfm_RoofingBlocksRendererOne;
import mods.jammyfurniture.client.render.jfm_SofaCenterRenderer;
import mods.jammyfurniture.client.render.jfm_SofaCornerRenderer;
import mods.jammyfurniture.client.render.jfm_SofaLeftRenderer;
import mods.jammyfurniture.client.render.jfm_SofaRightRenderer;
import mods.jammyfurniture.client.render.wood.WoodBlocksOneRenderer;
import mods.jammyfurniture.client.render.wood.WoodBlocksTwoRenderer;
import mods.jammyfurniture.client.render.wood.WoodBlocksThreeRenderer;
import mods.jammyfurniture.common.CommonProxyJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.TileEntityMiscOne;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaRight;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyJammyFurniture extends CommonProxyJammyFurniture {

	public void registerRenderers() {
		
		ModJammyFurniture.woodBlocksOneRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.woodBlocksTwoRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.woodBlocksThreeRenderID  = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.bathTubRenderID          = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.ironBlocksOneRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.ironBlocksTwoRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.ceramicBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.roofingBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.mobHeadsOneRenderID      = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.mobHeadsTwoRenderID      = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.mobHeadsThreeRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.mobHeadsFourRenderID     = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.armChairRenderID         = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.sofaPartLeftRenderID     = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.sofaPartRightRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.sofaPartCenterRenderID   = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.sofaPartCornerRenderID   = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.miscBlocksOneRenderID    = RenderingRegistry.getNextAvailableRenderId();
		ModJammyFurniture.lightsRenderID           = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksOneRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksTwoRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksThreeRenderID , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.bathTubRenderID         , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ironBlocksOneRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ironBlocksTwoRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ceramicBlocksOneRenderID, new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.roofingBlocksOneRenderID, new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsOneRenderID     , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsTwoRenderID     , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsThreeRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsFourRenderID    , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.armChairRenderID        , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartLeftRenderID    , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartRightRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCenterRenderID  , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCornerRenderID  , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.miscBlocksOneRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.lightsRenderID          , new JFInventoryRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksOne.class   , new WoodBlocksOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksTwo.class   , new WoodBlocksTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksThree.class , new WoodBlocksThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBath.class            , new jfm_BathRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksOne.class   , new jfm_IronBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksTwo.class   , new jfm_IronBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCeramicBlocksOne.class, new jfm_CeramicBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoofingBlocksOne.class, new jfm_RoofingBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsOne.class     , new jfm_MobHeadsOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsTwo.class     , new jfm_MobHeadsTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsThree.class   , new jfm_MobHeadsThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsFour.class    , new jfm_MobHeadsFourRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmChair.class        , new jfm_ArmChairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaLeft.class        , new jfm_SofaLeftRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaRight.class       , new jfm_SofaRightRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCenter.class      , new jfm_SofaCenterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCorner.class      , new jfm_SofaCornerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiscOne.class         , new jfm_MiscOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightsOn.class        , new jfm_LightsRenderer());
	}
}