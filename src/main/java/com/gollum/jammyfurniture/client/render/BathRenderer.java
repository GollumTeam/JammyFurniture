package com.gollum.jammyfurniture.client.render;

import static com.gollum.jammyfurniture.common.block.BathBlock.FACING;
import static com.gollum.jammyfurniture.common.block.BathBlock.PART;

import com.gollum.jammyfurniture.client.model.ModelBath;
import com.gollum.jammyfurniture.common.block.BathBlock.EnumPart;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class BathRenderer extends JFTileEntitySpecialRenderer {
	
	private static final ModelBath modelBath = new ModelBath();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockBathTub.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumPart type = (EnumPart) state.getValue(PART);

		if (facing == EnumFacing.NORTH ) { rotation = 90 ; } else
		if (facing == EnumFacing.WEST) { rotation = 180; } else
		if (facing == EnumFacing.SOUTH ) { rotation = 270; }
		
		if (this.isInventory) {
			
			renderInInventory(x, y, z);
			
		} else {
			
			if (type == EnumPart.LEFT) {
				renderModel(x, y, z, rotation, false);
			} else {
				renderModel(x, y, z, rotation, true);
			}
		}
	}

	private void renderModel(double x, double y, double z, float rotation, boolean left) {
		this.beforeRender("bath", x, y, z, rotation);
		if (left) {
			this.modelBath.renderModelLeft(0.0625F);
		} else {
			this.modelBath.renderModelRight(0.0625F);
		}
		this.endRender();
	}
	
	private void renderInInventory(double x, double y, double z) {
		this.beforeRender("bath", x, y, z-0.3F, 90.0F);
		this.modelBath.renderModelLeft(0.0625F);
		this.endRender();
		this.beforeRender("bath", x, y, z + 0.7F, 270.0F);
		this.modelBath.renderModelRight(0.0625F);
		this.endRender();
	}
}
