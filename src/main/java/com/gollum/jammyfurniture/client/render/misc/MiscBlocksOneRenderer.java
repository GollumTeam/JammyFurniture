package com.gollum.jammyfurniture.client.render.misc;

import static com.gollum.jammyfurniture.common.block.misc.MiscBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.misc.MiscBlocksOne.TYPE;

import com.gollum.jammyfurniture.client.model.misc.ModelChimney;
import com.gollum.jammyfurniture.client.model.misc.ModelChristmasTree;
import com.gollum.jammyfurniture.client.model.misc.ModelMantlePiece;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.misc.MiscBlocksOne.EnumType;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class MiscBlocksOneRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelChimney       modelChimney       = new ModelChimney();
	private ModelMantlePiece   modelMantlePiece   = new ModelMantlePiece();
	private ModelChristmasTree modelChristmasTree = new ModelChristmasTree();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockMiscBlocksOne.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.CHIMNEY       ) { this.renderModel(this.modelChimney      , "chimney"    , x, y, z, rotation); } else
		if (type == EnumType.MANTLE_PIECE  ) { this.renderModel(this.modelMantlePiece  , "mantlepiece", x, y, z, rotation); } else
		if (type == EnumType.CHRISTMAS_TREE) { this.renderModel(this.modelChristmasTree, "tree"       , x, y, z, rotation); }
		
	}
}
