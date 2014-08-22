package mods.jammyfurniture.client.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksOne;
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
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;

public class jfm_InvRenderer implements ISimpleBlockRenderingHandler {
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if (block == ModJammyFurniture.blockWoodBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWoodBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockWoodBlocksTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWoodBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockWoodBlocksThree) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWoodBlocksThree(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockBathTub) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityBath(), 0.0D, 0.0D, -0.5D, 0.0F);
		}

		if (block == ModJammyFurniture.blockIronBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityIronBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockIronBlocksTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityIronBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockCeramicBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityCeramicBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockRoofingBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityRoofingBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockMobHeadsOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMobHeadsOne(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == ModJammyFurniture.blockMobHeadsTwo) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMobHeadsTwo(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == ModJammyFurniture.blockMobHeadsThree) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMobHeadsThree(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == ModJammyFurniture.blcokMobHeadsFour) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMobHeadsFour(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
		}

		if (block == ModJammyFurniture.blockArmChair) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityArmChair(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockSofaPartLeft) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntitySofaLeft(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockSofaPartRight) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntitySofaRight(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockSofaPartCenter) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntitySofaCenter(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockSofaPartCorner) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntitySofaCorner(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockMiscBlocksOne) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMiscOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
		}

		if (block == ModJammyFurniture.blockLightsOn) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityLightsOn(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
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
