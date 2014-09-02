package mods.jammyfurniture.client.render;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;
import mods.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;
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
