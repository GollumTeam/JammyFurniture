package mods.jammyfurniture.client;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.render.BathRenderer;
import mods.jammyfurniture.client.render.JFInventoryRenderer;
import mods.jammyfurniture.client.render.SofaRenderer;
import mods.jammyfurniture.client.render.jfm_LightsRenderer;
import mods.jammyfurniture.client.render.ceramic.CeramicBlocksRendererOne;
import mods.jammyfurniture.client.render.head.MobHeadsFourRenderer;
import mods.jammyfurniture.client.render.head.MobHeadsOneRenderer;
import mods.jammyfurniture.client.render.head.MobHeadsThreeRenderer;
import mods.jammyfurniture.client.render.head.MobHeadsTwoRenderer;
import mods.jammyfurniture.client.render.iron.IronBlocksRendererOne;
import mods.jammyfurniture.client.render.iron.IronBlocksRendererTwo;
import mods.jammyfurniture.client.render.misc.MiscBlocksOneRenderer;
import mods.jammyfurniture.client.render.roofing.RoofingBlocksRendererOne;
import mods.jammyfurniture.client.render.wood.WoodBlocksOneRenderer;
import mods.jammyfurniture.client.render.wood.WoodBlocksThreeRenderer;
import mods.jammyfurniture.client.render.wood.WoodBlocksTwoRenderer;
import mods.jammyfurniture.common.CommonProxyJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.TileEntityMiscBlockOne;
import mods.jammyfurniture.common.tilesentities.TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaRight;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
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
		ModJammyFurniture.sofaRenderID             = RenderingRegistry.getNextAvailableRenderId();
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
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaRenderID            , new JFInventoryRenderer());
//		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartLeftRenderID    , new JFInventoryRenderer());
//		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartRightRenderID   , new JFInventoryRenderer());
//		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCenterRenderID  , new JFInventoryRenderer());
//		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCornerRenderID  , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.miscBlocksOneRenderID   , new JFInventoryRenderer());
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.lightsRenderID          , new JFInventoryRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksOne.class   , new WoodBlocksOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksTwo.class   , new WoodBlocksTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksThree.class , new WoodBlocksThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBath.class            , new BathRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksOne.class   , new IronBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksTwo.class   , new IronBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCeramicBlocksOne.class, new CeramicBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoofingBlocksOne.class, new RoofingBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsOne.class     , new MobHeadsOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsTwo.class     , new MobHeadsTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsThree.class   , new MobHeadsThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsFour.class    , new MobHeadsFourRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmChair.class        , new SofaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaLeft.class        , new SofaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaRight.class       , new SofaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCenter.class      , new SofaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCorner.class      , new SofaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiscBlockOne.class         , new MiscBlocksOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightsOn.class        , new jfm_LightsRenderer());
	}
}