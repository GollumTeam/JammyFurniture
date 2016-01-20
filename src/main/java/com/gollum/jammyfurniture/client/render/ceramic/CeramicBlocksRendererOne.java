package com.gollum.jammyfurniture.client.render.ceramic;

import static com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.TYPE;

import com.gollum.jammyfurniture.client.model.ceramic.ModelBathroomCupboard;
import com.gollum.jammyfurniture.client.model.ceramic.ModelBathroomSink;
import com.gollum.jammyfurniture.client.model.ceramic.ModelKitchenSink;
import com.gollum.jammyfurniture.client.model.ceramic.ModelToilet;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class CeramicBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	
	private ModelBathroomCupboard modelBathroomCupboard = new ModelBathroomCupboard();
	private ModelBathroomSink     modelBathroomSink     = new ModelBathroomSink();
	private ModelKitchenSink      modelKitchenSink      = new ModelKitchenSink();
	private ModelToilet           modelToilet           = new ModelToilet();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockCeramicBlocksOne.getStateFromMeta(metadata);
		EnumFacing facing = state.getValue(FACING);
		EnumType type = state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		TileEntityCeramicBlocksOne tileentityCeramic = (TileEntityCeramicBlocksOne)tileEntity;
		float doorProgess = tileentityCeramic.getPreviousDoorOpenProgress() + (tileentityCeramic.getDoorOpenProgress() - tileentityCeramic.getPreviousDoorOpenProgress()) * f;
		
		if (type == EnumType.BATHROOM_CUPBOARD) {
			this.renderModel(this.modelBathroomCupboard, "bathroomcupboard", x, y, z, rotation, doorProgess);
		} else
		if (type == EnumType.BATHROOM_SINK) {
			this.renderModel(this.modelBathroomSink, "sink", x, y, z, (rotation + 90) % 360);
			this.renderModelBathroomWater(tileentityCeramic.waterIsOn(), x, y, z, rotation);
		} else
		if (type == EnumType.KITCHEN) {
			this.renderModel(this.modelKitchenSink, "kitchensink", x, y, z, rotation); 
			this.renderModelKitchenWater(tileentityCeramic.waterIsOn(), x, y, z, rotation);
		} else
		if (type == EnumType.TOILET) {
			this.renderModel(this.modelToilet, "toilet", x, y, z, rotation);
		}
		
	}
	
	private void renderModelBathroomWater(boolean open, double x, double y, double z, float rotation) {
		this.alpha = 0.60f;
		this.beforeRender("sink", x, y, z, (rotation + 90) % 360);
		this.modelBathroomSink.renderWatter(open, 0.0625F);
		this.endRender();
		this.alpha = 1.0f;
	}
	
	private void renderModelKitchenWater(boolean open, double x, double y, double z, float rotation) {
		this.alpha = 0.60f;
		this.beforeRender("kitchensink", x, y, z, rotation);
		this.modelKitchenSink.renderWatter(open, 0.0625F);
		this.endRender();
		this.alpha = 1.0f;
	}
}
