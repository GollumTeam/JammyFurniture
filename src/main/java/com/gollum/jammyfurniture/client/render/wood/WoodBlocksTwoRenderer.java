package com.gollum.jammyfurniture.client.render.wood;

import net.minecraft.tileentity.TileEntity;

import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.jammyfurniture.client.model.wood.ModelBasket;
import com.gollum.jammyfurniture.client.model.wood.ModelKitchenCupboard;
import com.gollum.jammyfurniture.client.model.wood.ModelTV;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class WoodBlocksTwoRenderer extends JFTileEntitySpecialRenderer {
	
	
	private ModelKitchenCupboard modelKitchenCupboard = new ModelKitchenCupboard();
	private ModelTV              modelTV = new ModelTV();
	private ModelBasket          modelBasket = new ModelBasket();
	
	private long lastSwitch = 0;
	private boolean switchTvTexture = false;
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModBlocks.blockWoodBlocksTwo).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		switch (subBlock) {
			default:
			case 0: this.renderModel(this.modelKitchenCupboard, "kitchencupboardnotop", x, y, z, rotation); break;
			case 4: this.renderModel(this.modelKitchenCupboard, "kitchencupboard"     , x, y, z, rotation); break;
			case 8:
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
				break;
			case 12: 
			case 13: 
			case 14: 
			case 15: 
				
				String textureBasket = "basket_red";
				
				if (subBlock == 13) { textureBasket = "basket_blue"; } else
				if (subBlock == 14) { textureBasket = "basket_green"; } else
				if (subBlock == 15) { textureBasket = "basket_grey"; }
				
				this.renderModel(this.modelBasket, textureBasket   , x, y, z, rotation);
				break;
		}
	}
}
