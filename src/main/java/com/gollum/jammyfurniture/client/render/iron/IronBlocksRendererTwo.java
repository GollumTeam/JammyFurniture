package com.gollum.jammyfurniture.client.render.iron;

import static com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo.FACING;
import static com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo.TYPE;

import com.gollum.jammyfurniture.client.model.iron.ModelDishwasher;
import com.gollum.jammyfurniture.client.model.iron.ModelWashingMachine;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class IronBlocksRendererTwo extends JFTileEntitySpecialRenderer {
	
	private ModelDishwasher     modelDishwasher      = new ModelDishwasher();
	private ModelWashingMachine modelWashingMachine = new ModelWashingMachine();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		TileEntityIronBlocksTwo tileentityIron = (TileEntityIronBlocksTwo)tileEntity;
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockIronBlocksTwo.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		float doorProgess = tileentityIron.getPreviousDoorOpenProgress() + (tileentityIron.getDoorOpenProgress() - tileentityIron.getPreviousDoorOpenProgress()) * f;
		String texture;
		
		if (type == EnumType.DISHWASHER   ) {
			
			texture = "dishwasher";
			if (
				(
					!tileentityIron.isBurning() ||
					!tileentityIron.canSmelt()
				) && 
				(
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_0) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_1) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_2) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_3) != null
				)
			) {
				texture = "dishwasher_finish";
			}
			if (tileentityIron.isBurning() && tileentityIron.canSmelt()) {
				texture = "dishwasher_run";
			}
			this.renderModel(this.modelDishwasher, texture, x, y, z, rotation, doorProgess);
		
		} else
		if (type == EnumType.WASHING_MACHINE ) {
			
			texture = "washingmachine";
			if (
				(
					!tileentityIron.isBurning() ||
					!tileentityIron.canSmelt()
				) && 
				(
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_0) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_1) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_2) != null ||
					tileentityIron.getStackInSlot(TileEntityIronBlocksTwo.INDEX_SLOT_3) != null
				)
			) {
				texture = "washingmachine_finish";
			}
			if (tileentityIron.isBurning() && tileentityIron.canSmelt()) {
				texture = "washingmachine_run";
			}
			this.renderModel(this.modelWashingMachine, texture, x, y, z, rotation, doorProgess);
			
		}
		
	}
}
