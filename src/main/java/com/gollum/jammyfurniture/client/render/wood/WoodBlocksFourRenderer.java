package com.gollum.jammyfurniture.client.render.wood;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardBottom;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardTop;
import com.gollum.jammyfurniture.client.model.wood.ModelStandBase;
import com.gollum.jammyfurniture.client.model.wood.ModelStandTop;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.tileentity.TileEntity;

public class WoodBlocksFourRenderer extends JFTileEntitySpecialRenderer {

	private ModelCupboardTop    modelCupboardTop    = new ModelCupboardTop();
	private ModelCupboardBottom modelCupboardBottom = new ModelCupboardBottom();
	private ModelStandTop       modelStandTop       = new ModelStandTop();
	private ModelStandBase      modelStandBase      = new ModelStandBase();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {

//		TileEntityWoodBlocksFour tileEntityWood = (TileEntityWoodBlocksFour)tileEntity;
//		int subBlock = ((WoodBlocksFour)ModBlocks.blockWoodBlocksFour).getEnabledMetadata(metadata);
//		
//		float rotation = 0;
//		
//		switch (metadata) {
//			default:
//				rotation = 0; break;
//			case 3:
//			case 7:
//			case 9:
//			case 13:
//				rotation = 90; break;
//			case 2:
//			case 6:
//			case 10:
//			case 14:
//				rotation = 180; break;
//			case 1:
//			case 5:
//			case 11:
//			case 15:
//				rotation = 270; break;
//		}
//		
//		if (this.isInventory) {
//			this.renderInInventory(subBlock, x, y, z);
//			return;
//		}
//		
//		float doorProgess = tileEntityWood.getPreviousDoorOpenProgress() + (tileEntityWood.getDoorOpenProgress() - tileEntityWood.getPreviousDoorOpenProgress()) * f;
//		
//		switch (metadata) {
//			default:
//			case 0:
//			case 1:
//			case 2:
//			case 3:
//				this.renderModel(this.modelCupboardBottom, "cupboard", x, y, z, rotation);
//				break;
//			case 4:
//			case 5:
//			case 6:
//			case 7:
//				this.renderModel(this.modelCupboardTop, "cupboard", x, y, z, rotation, doorProgess);
//				break;
//			case 8:
//			case 9:
//			case 10:
//			case 11:
//				this.renderModel(this.modelStandBase, "coatstandbase", x, y, z, rotation);
//				break;
//			case 12:
//			case 13:
//			case 14:
//			case 15:
//				this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, rotation);
//				break;
//		}
	}
	
	private void renderInInventory(int subBlock, double x, double y, double z) {
		switch (subBlock) {
			default:
			case 0:
				this.renderModel(this.modelCupboardTop   , "cupboard", x, y + 1.0F, z, 180.0F);
				this.renderModel(this.modelCupboardBottom, "cupboard", x, y       , z, 180.0F);
				break;
			case 8:
				this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, 180.0F);
				break;
		}
	}
	
}
