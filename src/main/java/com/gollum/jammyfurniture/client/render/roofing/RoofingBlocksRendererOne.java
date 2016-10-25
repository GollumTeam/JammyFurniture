package com.gollum.jammyfurniture.client.render.roofing;

import static com.gollum.jammyfurniture.common.block.roofing.RoofingBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.roofing.RoofingBlocksOne.TYPE;

import com.gollum.jammyfurniture.client.model.roofing.ModelRoofing;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingBlock;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingCorner;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingInverted;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.roofing.RoofingBlocksOne.EnumType;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class RoofingBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private ModelRoofing         modelRoofing         = new ModelRoofing();
	private ModelRoofingCorner   modelRoofingCorner   = new ModelRoofingCorner();
	private ModelRoofingInverted modelRoofingInverted = new ModelRoofingInverted();
	private ModelRoofingBlock    modelRoofingBlock    = new ModelRoofingBlock();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockRoofingBlocksOne.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.ROOFING1) { this.renderModel(this.modelRoofing        , "roofing", x, y, z, rotation); } else
		if (type == EnumType.ROOFING2) { this.renderModel(this.modelRoofingCorner  , "roofing", x, y, z, rotation); } else
		if (type == EnumType.ROOFING3) { this.renderModel(this.modelRoofingInverted, "roofing", x, y, z, rotation); } else
		if (type == EnumType.ROOFING4) { this.renderModel(this.modelRoofingBlock   , "roofing", x, y, z, rotation); }
		
	}
}
