package com.gollum.jammyfurniture.client.render.roofing;

import com.gollum.jammyfurniture.client.model.roofing.ModelRoofing;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingBlock;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingCorner;
import com.gollum.jammyfurniture.client.model.roofing.ModelRoofingInverted;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;

import net.minecraft.tileentity.TileEntity;

public class RoofingBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private ModelRoofing         modelRoofing         = new ModelRoofing();
	private ModelRoofingCorner   modelRoofingCorner   = new ModelRoofingCorner();
	private ModelRoofingInverted modelRoofingInverted = new ModelRoofingInverted();
	private ModelRoofingBlock    modelRoofingBlock    = new ModelRoofingBlock();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {

		float rotation = 0;
		int subBlock = 0;
		
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
				rotation = 270; break;
		}
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		switch (subBlock) {
		default:
			case 0:  this.renderModel(this.modelRoofing        , "roofing", x, y, z, rotation); break;
			case 4:  this.renderModel(this.modelRoofingCorner  , "roofing", x, y, z, rotation); break;
			case 8:  this.renderModel(this.modelRoofingInverted, "roofing", x, y, z, rotation); break;
			case 12: this.renderModel(this.modelRoofingBlock   , "roofing", x, y, z, rotation); break;
		}
	}
}
