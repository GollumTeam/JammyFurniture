package mods.jammyfurniture.client.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mods.jammyfurniture.JammyFurnitureModCore;
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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;

public class jfm_InvRenderer implements ISimpleBlockRenderingHandler {
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if (block == JammyFurnitureModCore.woodBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocks(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.woodBlocksTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.woodBlocksThree) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocksThree(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.bathTub) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityBath(), 0.0D, 0.0D, -0.5D, 0.0F);
		}

		if (block == JammyFurnitureModCore.ironBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityIronBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.ironBlocksTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityIronBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.ceramicBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityCeramicBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.roofingBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityRoofingBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.mobHeadsOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsOne(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == JammyFurnitureModCore.mobHeadsTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsTwo(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == JammyFurnitureModCore.mobHeadsThree) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsThree(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == JammyFurnitureModCore.mobHeadsFour) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsFour(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == JammyFurnitureModCore.armChair) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityArmChair(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.sofaPartLeft) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaLeft(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.sofaPartRight) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaRight(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.sofaPartCenter) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaCenter(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.sofaPartCorner) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaCorner(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.miscBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMiscOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == JammyFurnitureModCore.lightsOn) {
			TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityLightsOn(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}
	}

	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	public boolean shouldRender3DInInventory() {
		return true;
	}

	public int getRenderId() {
		return 0;
	}
}
