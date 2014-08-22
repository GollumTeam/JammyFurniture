package mods.jammyfurniture.client;

import mods.jammyfurniture.JammyFurnitureModCore;
import mods.jammyfurniture.jfm_CommonProxy;
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
import mods.jammyfurniture.common.util.jfm_SoundManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class jfm_ClientProxy extends jfm_CommonProxy {
	public void preloadTextures() {
	}

	public void preInitLoading() {
		MinecraftForge.EVENT_BUS.register(new jfm_SoundManager());
	}

	public void initRendering() {
		JammyFurnitureModCore.woodBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.woodBlocksOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.woodBlocksTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.woodBlocksTwoRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.woodBlocksThreeRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.woodBlocksThreeRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.bathTubRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.bathTubRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.ironBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.ironBlocksOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.ironBlocksTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.ironBlocksTwoRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.ceramicBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.ceramicBlocksOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.roofingBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.roofingBlocksOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.mobHeadsOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.mobHeadsOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.mobHeadsTwoRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.mobHeadsTwoRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.mobHeadsThreeRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.mobHeadsThreeRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.mobHeadsFourRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.mobHeadsFourRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.armChairRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.armChairRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.sofaPartLeftRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.sofaPartLeftRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.sofaPartRightRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.sofaPartRightRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.sofaPartCenterRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.sofaPartCenterRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.sofaPartCornerRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.sofaPartCornerRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.miscBlocksOneRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.miscBlocksOneRenderID, new jfm_InvRenderer());

		JammyFurnitureModCore.lightsRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(JammyFurnitureModCore.lightsRenderID, new jfm_InvRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityWoodBlocks.class, new jfm_WoodBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityWoodBlocksTwo.class, new jfm_WoodBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityWoodBlocksThree.class, new jfm_WoodBlocksRendererThree());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityBath.class, new jfm_BathRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityIronBlocksOne.class, new jfm_IronBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityIronBlocksTwo.class, new jfm_IronBlocksRendererTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityCeramicBlocksOne.class, new jfm_CeramicBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityRoofingBlocksOne.class, new jfm_RoofingBlocksRendererOne());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityMobHeadsOne.class, new jfm_MobHeadsOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityMobHeadsTwo.class, new jfm_MobHeadsTwoRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityMobHeadsThree.class, new jfm_MobHeadsThreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityMobHeadsFour.class, new jfm_MobHeadsFourRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityArmChair.class, new jfm_ArmChairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntitySofaLeft.class, new jfm_SofaLeftRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntitySofaRight.class, new jfm_SofaRightRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntitySofaCenter.class, new jfm_SofaCenterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntitySofaCorner.class, new jfm_SofaCornerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityMiscOne.class, new jfm_MiscOneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(jfm_TileEntityLightsOn.class, new jfm_LightsRenderer());
	}
}