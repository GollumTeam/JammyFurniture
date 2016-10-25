package com.gollum.jammyfurniture.client.render.iron;

import static com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.TYPE;

import com.gollum.jammyfurniture.client.model.iron.ModelCoffeeTable;
import com.gollum.jammyfurniture.client.model.iron.ModelCooker;
import com.gollum.jammyfurniture.client.model.iron.ModelFridge;
import com.gollum.jammyfurniture.client.model.iron.ModelRubbishBin;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class IronBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private ModelFridge      modelFridge      = new ModelFridge();
	private ModelCooker      modelCooker      = new ModelCooker();
	private ModelRubbishBin  modelRubbishBin  = new ModelRubbishBin();
	private ModelCoffeeTable modelCoffeetable = new ModelCoffeeTable();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {

		TileEntityIronBlocksOne tileEntityIron = (TileEntityIronBlocksOne)tileEntity;
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockIronBlocksOne.getStateFromMeta(metadata);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		EnumType type = (EnumType) state.getValue(TYPE);

		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.RUBBISH_BIN) {
			switch (tileEntityIron.rubishBinOrientation) {
				default:
				case 0: rotation = 90;  break;
				case 1: rotation = 0;   break;
				case 2: rotation = 270; break;
				case 3: rotation = 180; break;
			}
		}
		
		float doorProgess = tileEntityIron.getPreviousDoorOpenProgress() + (tileEntityIron.getDoorOpenProgress() - tileEntityIron.getPreviousDoorOpenProgress()) * f;
		
		if (type == EnumType.FRIDGE   ) {
			this.modelFridge.setFridge();
			this.renderModel(this.modelFridge, "fridge", x, y, z, (rotation+180)%360, doorProgess);
		} else
		if (type == EnumType.FREEZER   ) {
			this.modelFridge.setFreezer();
			this.renderModel(this.modelFridge, "freezer", x, y, z, (rotation+180)%360, doorProgess);
		} else
		if (type == EnumType.COOKER      ) { this.renderModel(this.modelCooker     , "cooker"     , x, y, z, rotation, doorProgess); } else
		if (type == EnumType.RUBBISH_BIN ) { this.renderModel(this.modelRubbishBin , "rubbishbin" , x, y, z, rotation, doorProgess); } else
		if (type == EnumType.COFFEE_TABLE) { this.renderModel(this.modelCoffeetable, "coffeetable", x, y, z, rotation); }
		
	}
}
