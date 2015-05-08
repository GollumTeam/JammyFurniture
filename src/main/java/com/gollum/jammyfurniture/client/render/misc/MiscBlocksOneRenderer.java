package com.gollum.jammyfurniture.client.render.misc;

import net.minecraft.tileentity.TileEntity;

import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.jammyfurniture.client.model.misc.ModelChimney;
import com.gollum.jammyfurniture.client.model.misc.ModelChristmasTree;
import com.gollum.jammyfurniture.client.model.misc.ModelMantlePiece;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class MiscBlocksOneRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelChimney       modelChimney       = new ModelChimney();
	private ModelMantlePiece   modelMantlePiece   = new ModelMantlePiece();
	private ModelChristmasTree modelChristmasTree = new ModelChristmasTree();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModBlocks.blockIronBlocksOne).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
			case 15:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
			case 14:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
			case 13:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		switch (subBlock) {
			default:
			case 0:  this.renderModel(this.modelChimney      , "chimney"    , x, y, z, rotation); break;
			case 4:  this.renderModel(this.modelMantlePiece  , "mantlepiece", x, y, z, rotation); break;
			case 8:  this.renderModel(this.modelChristmasTree, "tree"       , x, y, z, rotation); break;
		}
		
	}
}
