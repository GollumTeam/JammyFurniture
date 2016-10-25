package com.gollum.jammyfurniture.client.render.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.FACING;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.TYPE;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelChair;
import com.gollum.jammyfurniture.client.model.wood.ModelRadio;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.EnumType;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class WoodBlocksThreeRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelChair  chair = new ModelChair();
	private ModelRadio  radio = new ModelRadio();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockWoodBlocksThree.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.CHAIR       ) { this.renderModel(this.chair, "chair", x, y, z, rotation); } else
		if (type == EnumType.RADIO       ) { this.renderModel(this.radio, "radio", x, y, z, rotation); } else
		if (type == EnumType.BLINDS_HALF ) { this.renderModelBlindsHalfOpen(x, y, z, rotation);        } else
		if (type == EnumType.BLINDS_CLOSE) { this.renderModelBlindsCloses  (x, y, z, rotation);        }
		
	}
	
	private void renderModelBlindsCloses(double x, double y, double z, float rotation) {
		this.beforeRender("blinds", x, y, z, rotation);
		this.blinds.renderModelClosed(0.0625F);
		this.endRender();
	}
	
	private void renderModelBlindsHalfOpen(double x, double y, double z, float rotation) {
		this.beforeRender("blinds", x, y, z, rotation);
		this.blinds.renderModelHalfOpen(0.0625F);
		this.endRender();
	}
	
}
