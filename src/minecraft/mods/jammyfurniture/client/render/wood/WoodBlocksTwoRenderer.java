package mods.jammyfurniture.client.render.wood;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.wood.ModelBasket;
import mods.jammyfurniture.client.model.wood.ModelKitchenCupboard;
import mods.jammyfurniture.client.model.wood.ModelTV;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class WoodBlocksTwoRenderer extends JFTileEntitySpecialRenderer {
	
	
	private final static ModelKitchenCupboard modelKitchenCupboard = new ModelKitchenCupboard();
	private final static ModelTV              modelTV = new ModelTV();
	private final static ModelBasket          modelBasket = new ModelBasket();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockWoodBlocksTwo).getEnabledMetadata(metadata);
		
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
			case 0:  this.renderModel(this.modelKitchenCupboard, "kitchencupboardnotop", x, y, z, rotation); break;
			case 4:  this.renderModel(this.modelKitchenCupboard, "kitchencupboard"     , x, y, z, rotation); break;
			case 8:  this.renderModel(this.modelTV             , "tv"                  , x, y, z, rotation); break;
			case 12: 
			case 13: 
			case 14: 
			case 15: 
				
				String texture = "basket_red";
				
				if (subBlock == 13) { texture = "basket_blue"; } else
				if (subBlock == 14) { texture = "basket_green"; } else
				if (subBlock == 15) { texture = "basket_grey"; }
				
				this.renderModel(this.modelBasket, texture   , x, y, z, rotation);
				break;
		}
	}
}
