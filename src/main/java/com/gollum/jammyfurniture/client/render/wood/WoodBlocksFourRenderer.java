package com.gollum.jammyfurniture.client.render.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.FACING;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.TYPE;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.PART;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardBottom;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardTop;
import com.gollum.jammyfurniture.client.model.wood.ModelStandBase;
import com.gollum.jammyfurniture.client.model.wood.ModelStandTop;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumType;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumPart;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class WoodBlocksFourRenderer extends JFTileEntitySpecialRenderer {

	private ModelCupboardTop    modelCupboardTop    = new ModelCupboardTop();
	private ModelCupboardBottom modelCupboardBottom = new ModelCupboardBottom();
	private ModelStandTop       modelStandTop       = new ModelStandTop();
	private ModelStandBase      modelStandBase      = new ModelStandBase();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		TileEntityWoodBlocksFour tileEntityWood = (TileEntityWoodBlocksFour)tileEntity;
		float rotation = 0;
		IBlockState state = ModBlocks.blockWoodBlocksFour.getStateFromMeta(metadata);
		EnumFacing facing = state.getValue(FACING);
		EnumType type = state.getValue(TYPE);
		EnumPart part = state.getValue(PART);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			this.renderInInventory(type, x, y, z);
			return;
		}
		
		float doorProgess = tileEntityWood.getPreviousDoorOpenProgress() + (tileEntityWood.getDoorOpenProgress() - tileEntityWood.getPreviousDoorOpenProgress()) * f;
		
		if (type == EnumType.WARDROBE) {
			if (part == EnumPart.FOOT) {
				this.renderModel(this.modelCupboardBottom, "cupboard", x, y, z, rotation);
			} else {
				this.renderModel(this.modelCupboardTop, "cupboard", x, y, z, rotation, doorProgess);
			}
		} else {
			if (part == EnumPart.FOOT) {
				this.renderModel(this.modelStandBase, "coatstandbase", x, y, z, rotation);
			} else {
				this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, rotation);
			}
		}
		
	}
	
	private void renderInInventory(EnumType type, double x, double y, double z) {
		if (type == EnumType.WARDROBE) {
			this.renderModel(this.modelCupboardTop   , "cupboard", x, y + 0.95F, z, 180.0F);
			this.renderModel(this.modelCupboardBottom, "cupboard", x, y - 0.05 , z, 180.0F);
		} else {
			this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, 180.0F);
		}
	}
	
}
