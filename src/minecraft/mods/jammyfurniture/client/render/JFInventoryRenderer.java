package mods.jammyfurniture.client.render;

import mods.jammyfurniture.ModJammyFurniture;
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

		if (block == ModJammyFurniture.blockLightsOn) {
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityLightsOn(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
			return;
		}
		
		TileEntityRenderer.instance.renderTileEntityAt(((BlockContainer)block).createNewTileEntity(null), 0.0D, -0.1D, 0.0D, 0.0F);
		
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
