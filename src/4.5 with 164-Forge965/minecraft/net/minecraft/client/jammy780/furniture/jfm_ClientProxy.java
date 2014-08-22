package net.minecraft.client.jammy780.furniture;

import net.minecraft.jammy780.furniture.JammyFurnitureModCore;
import net.minecraft.jammy780.furniture.jfm_CommonProxy;
import net.minecraft.jammy780.furniture.render.jfm_ArmChairRenderer;
import net.minecraft.jammy780.furniture.render.jfm_BathRenderer;
import net.minecraft.jammy780.furniture.render.jfm_CeramicBlocksRendererOne;
import net.minecraft.jammy780.furniture.render.jfm_InvRenderer;
import net.minecraft.jammy780.furniture.render.jfm_IronBlocksRendererOne;
import net.minecraft.jammy780.furniture.render.jfm_IronBlocksRendererTwo;
import net.minecraft.jammy780.furniture.render.jfm_LightsRenderer;
import net.minecraft.jammy780.furniture.render.jfm_MiscOneRenderer;
import net.minecraft.jammy780.furniture.render.jfm_MobHeadsFourRenderer;
import net.minecraft.jammy780.furniture.render.jfm_MobHeadsOneRenderer;
import net.minecraft.jammy780.furniture.render.jfm_MobHeadsThreeRenderer;
import net.minecraft.jammy780.furniture.render.jfm_MobHeadsTwoRenderer;
import net.minecraft.jammy780.furniture.render.jfm_RoofingBlocksRendererOne;
import net.minecraft.jammy780.furniture.render.jfm_SofaCenterRenderer;
import net.minecraft.jammy780.furniture.render.jfm_SofaCornerRenderer;
import net.minecraft.jammy780.furniture.render.jfm_SofaLeftRenderer;
import net.minecraft.jammy780.furniture.render.jfm_SofaRightRenderer;
import net.minecraft.jammy780.furniture.render.jfm_WoodBlocksRendererOne;
import net.minecraft.jammy780.furniture.render.jfm_WoodBlocksRendererThree;
import net.minecraft.jammy780.furniture.render.jfm_WoodBlocksRendererTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityArmChair;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityBath;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityCeramicBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityLightsOn;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMiscOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsFour;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsThree;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityRoofingBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaCenter;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaCorner;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaLeft;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaRight;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocks;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocksThree;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocksTwo;
import net.minecraft.jammy780.furniture.util.jfm_SoundManager;
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