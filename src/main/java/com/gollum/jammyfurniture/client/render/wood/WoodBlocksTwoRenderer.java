package com.gollum.jammyfurniture.client.render.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo.FACING;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo.TYPE;

import com.gollum.jammyfurniture.client.model.wood.ModelBasket;
import com.gollum.jammyfurniture.client.model.wood.ModelKitchenCupboard;
import com.gollum.jammyfurniture.client.model.wood.ModelTV;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class WoodBlocksTwoRenderer extends JFTileEntitySpecialRenderer {
	
	
	private ModelKitchenCupboard modelKitchenCupboard = new ModelKitchenCupboard();
	private ModelTV              modelTV = new ModelTV();
	private ModelBasket          modelBasket = new ModelBasket();
	
	private long lastSwitch = 0;
	private boolean switchTvTexture = false;
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockWoodBlocksTwo.getStateFromMeta(metadata);
		EnumFacing facing = state.getValue(FACING);
		EnumType type = state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.CUPBOARD_SHELF) { this.renderModel(this.modelKitchenCupboard  , "kitchencupboardnotop"  , x, y, z, rotation); } else
		if (type == EnumType.CUPBOARD      ) { this.renderModel(this.modelKitchenCupboard, "kitchencupboard", x, y, z, rotation); } else
		if (type == EnumType.TELEVISION    ) {
			String textureTv = "tv";
			if (((TileEntityWoodBlocksTwo)tileentity).tvIsOn()) {
				if (this.switchTvTexture) {
					textureTv = "tv_on1";
				} else {
					textureTv = "tv_on2";
				}
				if (System.currentTimeMillis() - this.lastSwitch > 50) {
					this.switchTvTexture = !this.switchTvTexture;
					this.lastSwitch = System.currentTimeMillis();
				}
			}
			this.renderModel(this.modelTV, textureTv, x, y, z, rotation);
		} else	 { 
			String textureBasket = "basket_red";
			
			if (type == EnumType.BASKET_BLUE)  { textureBasket = "basket_blue";  } else
			if (type == EnumType.BASKET_GREEN) { textureBasket = "basket_green"; } else
			if (type == EnumType.BASKET_GREY)  { textureBasket = "basket_grey";  }
			
			this.renderModel(this.modelBasket, textureBasket   , x, y, z, rotation);
		}
	}
}
