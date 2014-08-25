package mods.jammyfurniture.client;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.render.jfm_ArmChairRenderer;
import mods.jammyfurniture.client.render.jfm_BathRenderer;
import mods.jammyfurniture.client.render.jfm_CeramicBlocksRendererOne;
import mods.jammyfurniture.client.render.jfm_InvRenderer;
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
import mods.jammyfurniture.client.render.jfm_WoodBlocksRendererOne;
import mods.jammyfurniture.client.render.jfm_WoodBlocksRendererThree;
import mods.jammyfurniture.client.render.jfm_WoodBlocksRendererTwo;
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
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksTwo;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyJammyFurniture extends CommonProxyJammyFurniture {

	public void registerRenderers() {
		ModJammyFurniture.woodBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksOneRenderID, new jfm_InvRenderer());

		ModJammyFurniture.woodBlocksTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksTwoRenderID, new jfm_InvRenderer());

		ModJammyFurniture.woodBlocksThreeRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.woodBlocksThreeRenderID, new jfm_InvRenderer());

		ModJammyFurniture.bathTubRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.bathTubRenderID, new jfm_InvRenderer());

		ModJammyFurniture.ironBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ironBlocksOneRenderID, new jfm_InvRenderer());

		ModJammyFurniture.ironBlocksTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ironBlocksTwoRenderID, new jfm_InvRenderer());

		ModJammyFurniture.ceramicBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.ceramicBlocksOneRenderID, new jfm_InvRenderer());
		
		ModJammyFurniture.roofingBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.roofingBlocksOneRenderID, new jfm_InvRenderer());

		ModJammyFurniture.mobHeadsOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsOneRenderID, new jfm_InvRenderer());

		ModJammyFurniture.mobHeadsTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsTwoRenderID, new jfm_InvRenderer());

		ModJammyFurniture.mobHeadsThreeRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsThreeRenderID, new jfm_InvRenderer());

		ModJammyFurniture.mobHeadsFourRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.mobHeadsFourRenderID, new jfm_InvRenderer());

		ModJammyFurniture.armChairRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.armChairRenderID, new jfm_InvRenderer());

		ModJammyFurniture.sofaPartLeftRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartLeftRenderID, new jfm_InvRenderer());

		ModJammyFurniture.sofaPartRightRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartRightRenderID, new jfm_InvRenderer());

		ModJammyFurniture.sofaPartCenterRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCenterRenderID, new jfm_InvRenderer());

		ModJammyFurniture.sofaPartCornerRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.sofaPartCornerRenderID, new jfm_InvRenderer());

		ModJammyFurniture.miscBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.miscBlocksOneRenderID, new jfm_InvRenderer());

		ModJammyFurniture.lightsRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ModJammyFurniture.lightsRenderID, new jfm_InvRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksOne.class, new jfm_WoodBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksTwo.class, new jfm_WoodBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocksThree.class, new jfm_WoodBlocksRendererThree());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBath.class, new jfm_BathRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksOne.class, new jfm_IronBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronBlocksTwo.class, new jfm_IronBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCeramicBlocksOne.class, new jfm_CeramicBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoofingBlocksOne.class, new jfm_RoofingBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsOne.class, new jfm_MobHeadsOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsTwo.class, new jfm_MobHeadsTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsThree.class, new jfm_MobHeadsThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMobHeadsFour.class, new jfm_MobHeadsFourRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmChair.class, new jfm_ArmChairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaLeft.class, new jfm_SofaLeftRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaRight.class, new jfm_SofaRightRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCenter.class, new jfm_SofaCenterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySofaCorner.class, new jfm_SofaCornerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiscOne.class, new jfm_MiscOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightsOn.class, new jfm_LightsRenderer());
	}
}