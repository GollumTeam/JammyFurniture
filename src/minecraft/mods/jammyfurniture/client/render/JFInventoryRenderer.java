package mods.jammyfurniture.client.render;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityCeramicBlocksOne;
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
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class JFInventoryRenderer implements ISimpleBlockRenderingHandler {
	
	private static int currentMetadata;

	public static int getCurrentMetadata() {
		return currentMetadata;
	}
	
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		
		this.currentMetadata = metadata;
		
		// TODO unifier
		if (
			block == ModJammyFurniture.blockWoodBlocksOne   || 
			block == ModJammyFurniture.blockWoodBlocksTwo   || 
			block == ModJammyFurniture.blockWoodBlocksThree || 
			block == ModJammyFurniture.blockBathTub         || 
			block == ModJammyFurniture.blockIronBlocksOne   ||
			block == ModJammyFurniture.blockIronBlocksTwo
		) {
			TileEntityRenderer.instance.renderTileEntityAt(((BlockContainer)block).createNewTileEntity(null), 0.0D, -0.1D, 0.0D, 0.0F);
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
