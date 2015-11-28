package com.gollum.jammyfurniture.client.render.iron;

import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.jammyfurniture.client.model.iron.ModelDishwasher;
import com.gollum.jammyfurniture.client.model.iron.ModelWashingMachine;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.tileentity.TileEntity;

public class IronBlocksRendererTwo extends JFTileEntitySpecialRenderer {
	
	private ModelDishwasher     modelDishwasher      = new ModelDishwasher();
	private ModelWashingMachine modelWashingMachine = new ModelWashingMachine();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata) {

		TileEntityIronBlocksTwo tileentityIron = (TileEntityIronBlocksTwo)tileEntity;
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModBlocks.blockIronBlocksTwo).getEnabledMetadata(metadata);
		
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
				rotation = 90; break;
			case 2:
			case 6:
				rotation = 180; break;
			case 1:
			case 5:
				rotation = 270; break;
		}
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		float doorProgess = tileentityIron.getPreviousDoorOpenProgress() + (tileentityIron.getDoorOpenProgress() - tileentityIron.getPreviousDoorOpenProgress()) * f;
		String texture;
		
		switch (subBlock) {
			default:
			case 0:
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
				break;

			case 4:
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
				break;
		}
	}
}
