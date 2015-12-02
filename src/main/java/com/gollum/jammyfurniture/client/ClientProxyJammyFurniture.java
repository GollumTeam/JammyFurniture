package com.gollum.jammyfurniture.client;

import com.gollum.core.tools.registry.RenderingRegistry;
import com.gollum.jammyfurniture.client.render.BathRenderer;
import com.gollum.jammyfurniture.client.render.JFInventoryRenderer;
import com.gollum.jammyfurniture.client.render.LightsRenderer;
import com.gollum.jammyfurniture.client.render.SofaRenderer;
import com.gollum.jammyfurniture.client.render.ceramic.CeramicBlocksRendererOne;
import com.gollum.jammyfurniture.client.render.head.MobHeadsFourRenderer;
import com.gollum.jammyfurniture.client.render.head.MobHeadsOneRenderer;
import com.gollum.jammyfurniture.client.render.head.MobHeadsThreeRenderer;
import com.gollum.jammyfurniture.client.render.head.MobHeadsTwoRenderer;
import com.gollum.jammyfurniture.client.render.iron.IronBlocksRendererOne;
import com.gollum.jammyfurniture.client.render.iron.IronBlocksRendererTwo;
import com.gollum.jammyfurniture.client.render.misc.MiscBlocksOneRenderer;
import com.gollum.jammyfurniture.client.render.roofing.RoofingBlocksRendererOne;
import com.gollum.jammyfurniture.client.render.wood.WoodBlocksFourRenderer;
import com.gollum.jammyfurniture.client.render.wood.WoodBlocksOneRenderer;
import com.gollum.jammyfurniture.client.render.wood.WoodBlocksThreeRenderer;
import com.gollum.jammyfurniture.client.render.wood.WoodBlocksTwoRenderer;
import com.gollum.jammyfurniture.common.CommonProxyJammyFurniture;
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

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxyJammyFurniture extends CommonProxyJammyFurniture {
	
	/////////////////
	// Renders IDs //
	/////////////////
	
	public static int woodBlocksOneRenderID;
	public static int woodBlocksTwoRenderID;
	public static int woodBlocksThreeRenderID;
	public static int woodBlocksFourRenderID;
	public static int bathTubRenderID;
	public static int ironBlocksOneRenderID;
	public static int ironBlocksTwoRenderID;
	public static int ceramicBlocksOneRenderID;
	public static int roofingBlocksOneRenderID;
	public static int mobHeadsOneRenderID;
	public static int mobHeadsTwoRenderID;
	public static int mobHeadsThreeRenderID;
	public static int mobHeadsFourRenderID;
	public static int sofaRenderID;
	public static int miscBlocksOneRenderID;
	public static int lightsRenderID;
	
	public void registerRenderers() {
		
		this.woodBlocksOneRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.woodBlocksTwoRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.woodBlocksThreeRenderID  = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.woodBlocksFourRenderID   = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.bathTubRenderID          = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.ironBlocksOneRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.ironBlocksTwoRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.ceramicBlocksOneRenderID = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.roofingBlocksOneRenderID = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.mobHeadsOneRenderID      = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.mobHeadsTwoRenderID      = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.mobHeadsThreeRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.mobHeadsFourRenderID     = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.sofaRenderID             = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.miscBlocksOneRenderID    = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		this.lightsRenderID           = RenderingRegistry.registerBlockHandler(new JFInventoryRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksOne.class   , new WoodBlocksOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksTwo.class   , new WoodBlocksTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksThree.class , new WoodBlocksThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksFour.class  , new WoodBlocksFourRenderer());
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
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiscBlockOne.class    , new MiscBlocksOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightsOn.class        , new LightsRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightsOff.class       , new LightsRenderer());
	}
}