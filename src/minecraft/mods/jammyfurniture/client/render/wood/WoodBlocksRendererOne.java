package mods.jammyfurniture.client.render.wood;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.wood.ModelBlinds;
import mods.jammyfurniture.client.model.wood.ModelClockBase;
import mods.jammyfurniture.client.model.wood.ModelClockMiddle;
import mods.jammyfurniture.client.model.wood.ModelClockTop;
import mods.jammyfurniture.client.model.wood.ModelKitchenSide;
import mods.jammyfurniture.client.model.wood.ModelTable;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class WoodBlocksRendererOne extends JFTileEntitySpecialRenderer {
		
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockWoodBlocksOne).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 4:
			case 8:
			case 12:
				rotation = 90; break;
			case 3:
			case 7:
			case 11:
				rotation = 180; break;
			case 2:
			case 6:
			case 10:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}

		switch (subBlock) {
			default:
			case 0:  this.renderModel(ModelClockBase.class  , "clockbase"  , x, y, z, rotation); break;
			case 1:  this.renderModel(ModelClockMiddle.class, "clockmiddle", x, y, z, rotation); break;
			case 5:  this.renderModel(ModelClockTop.class   , "clocktop"   , x, y, z, rotation); break;
			case 9:  this.renderModel(ModelBlinds.class     , "blinds"     , x, y, z, rotation); break;
			case 13: this.renderModel(ModelKitchenSide.class, "craftside"  , x, y, z, rotation); break;
			case 14: this.renderModel(ModelKitchenSide.class, "kitchenside", x, y, z, rotation); break;
			case 15:this.renderModel(ModelTable.class       , "table"      , x, y, z, rotation);
		}
	}
}
