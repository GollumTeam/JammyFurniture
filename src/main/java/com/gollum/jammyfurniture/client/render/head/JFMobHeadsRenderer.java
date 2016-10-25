package com.gollum.jammyfurniture.client.render.head;

import static com.gollum.jammyfurniture.common.block.head.JFMobHeads.FACING;
import static com.gollum.jammyfurniture.common.block.head.JFMobHeads.TYPE;

import java.util.List;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.head.JFMobHeads;
import com.gollum.jammyfurniture.common.block.head.JFMobHeads.EnumType;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public abstract class JFMobHeadsRenderer extends JFTileEntitySpecialRenderer {
	
	JFMobHeads block;
	List<JFIModel> models;
	List<String> textures;
	
	public void init(JFMobHeads block, List<JFIModel> models, List<String> textures) {
		this.block = block;
		this.models = models;
		this.textures = textures;
	}
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = this.block.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.HEAD_1) { this.renderModel(this.models.get(0), this.textures.get(0), x, y, z, rotation); } else
		if (type == EnumType.HEAD_2) { this.renderModel(this.models.get(1), this.textures.get(1), x, y, z, rotation); } else
		if (type == EnumType.HEAD_3) { this.renderModel(this.models.get(2), this.textures.get(2), x, y, z, rotation); } else
		if (type == EnumType.HEAD_4) { this.renderModel(this.models.get(3), this.textures.get(3), x, y, z, rotation); }
		
	}
}