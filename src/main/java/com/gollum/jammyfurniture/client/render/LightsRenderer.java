package com.gollum.jammyfurniture.client.render;

import static com.gollum.jammyfurniture.common.block.BlockLights.FACING;
import static com.gollum.jammyfurniture.common.block.BlockLights.TYPE;
import com.gollum.jammyfurniture.client.model.lights.ModelLight;
import com.gollum.jammyfurniture.client.model.lights.ModelOutsideLamp;
import com.gollum.jammyfurniture.client.model.lights.ModelTableLamp;
import com.gollum.jammyfurniture.common.block.BlockLights.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class LightsRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelLight       modeLight        = new ModelLight();
	private ModelOutsideLamp modelOutsideLamp = new ModelOutsideLamp();
	private ModelTableLamp   modelTableLamp   = new ModelTableLamp();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockLightsOn.getStateFromMeta(metadata);
		EnumFacing facing = state.getValue(FACING);
		EnumType type = state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		} else {
			this.light = tileEntity instanceof TileEntityLightsOn;
		}
		
		String status = (tileEntity instanceof TileEntityLightsOn) ? "_on" : "_off";
		
		if (type == EnumType.LIGHT       ) { this.renderModel(this.modeLight       , "lightbulb" + status, x, y, z, rotation); } else
		if (type == EnumType.OUTDOOR_LAMP) { this.renderModel(this.modelOutsideLamp, "lamp"      + status, x, y, z, rotation); } else
		if (type == EnumType.TABLE_LAMP  ) { this.renderModel(this.modelTableLamp  , "tablelamp" + status, x, y, z, rotation); }
		
	}
}
