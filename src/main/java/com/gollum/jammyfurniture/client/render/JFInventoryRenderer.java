package com.gollum.jammyfurniture.client.render;

import com.gollum.core.client.handlers.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class JFInventoryRenderer implements ISimpleBlockRenderingHandler {
	
	private static int currentMetadata;
	
	public static int getCurrentMetadata() {
		return currentMetadata;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderItem renderer) {
		
		this.currentMetadata = metadata;
		
		TileEntityRendererDispatcher.instance.renderTileEntityAt(((BlockContainer)block).createNewTileEntity(null, metadata), 0.0D, 0.0D, 0.0D, 0.0F);
		
	}
	
}
