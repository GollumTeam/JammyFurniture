package com.gollum.jammyfurniture.client.render;

import static com.gollum.jammyfurniture.common.block.BlockSofa.FACING;
import static com.gollum.jammyfurniture.common.block.BlockSofa.COLOR;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.sofa.ModelArmChair;
import com.gollum.jammyfurniture.client.model.sofa.ModelSofaCenter;
import com.gollum.jammyfurniture.client.model.sofa.ModelSofaCorner;
import com.gollum.jammyfurniture.client.model.sofa.ModelSofaLeft;
import com.gollum.jammyfurniture.client.model.sofa.ModelSofaRight;
import com.gollum.jammyfurniture.common.block.BlockSofa;
import com.gollum.jammyfurniture.common.block.BlockSofa.EnumColor;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class SofaRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelArmChair   modelArmChair   = new ModelArmChair ();
	private ModelSofaCenter modelSofaCenter = new ModelSofaCenter();
	private ModelSofaCorner modelSofaCorner = new ModelSofaCorner();
	private ModelSofaRight  modelSofaRight  = new ModelSofaRight();
	private ModelSofaLeft   modelSofaLeft   = new ModelSofaLeft();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state  = this.getBlock(tileentity).getStateFromMeta(metadata);
		EnumFacing facing  = (EnumFacing) state.getValue(FACING);
		EnumColor  color   = (EnumColor) state.getValue(COLOR);
		String     texture = this.getPrefrixeTexture (tileentity)+"_"+color.getName();
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		this.renderModel(this.getModel(tileentity), texture, x, y, z, rotation);
	}

	private String getPrefrixeTexture(TileEntity tileentity) {
		if (tileentity instanceof TileEntitySofaCenter) {
			return "sofacenter";
		}
		if (tileentity instanceof TileEntitySofaCorner) {
			return "sofacorner";
		}
		if (tileentity instanceof TileEntitySofaLeft) {
			return "sofaleft";
		}
		if (tileentity instanceof TileEntitySofaRight) {
			return "sofaright";
		}
		return "armchair";
	}
	
	private JFIModel getModel(TileEntity tileentity) {
		if (tileentity instanceof TileEntitySofaCenter) {
			return this.modelSofaCenter;
		}
		if (tileentity instanceof TileEntitySofaCorner) {
			return this.modelSofaCorner;
		}
		if (tileentity instanceof TileEntitySofaLeft) {
			return this.modelSofaLeft;
		}
		if (tileentity instanceof TileEntitySofaRight) {
			return this.modelSofaRight;
		}
		return this.modelArmChair;
	}
	
	private BlockSofa getBlock(TileEntity tileentity) {
		if (tileentity instanceof TileEntitySofaCenter) {
			return ModBlocks.blockArmChair;
		}
		if (tileentity instanceof TileEntitySofaCorner) {
			return ModBlocks.blockSofaPartCorner;
		}
		if (tileentity instanceof TileEntitySofaLeft) {
			return ModBlocks.blockSofaPartLeft;
		}
		if (tileentity instanceof TileEntitySofaRight) {
			return ModBlocks.blockSofaPartRight;
		}
		return ModBlocks.blockArmChair;
	}
	
}
