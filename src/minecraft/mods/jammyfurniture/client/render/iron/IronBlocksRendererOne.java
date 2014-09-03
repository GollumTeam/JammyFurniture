package mods.jammyfurniture.client.render.iron;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.iron.ModelCoffeeTable;
import mods.jammyfurniture.client.model.iron.ModelCooker;
import mods.jammyfurniture.client.model.iron.ModelFridge;
import mods.jammyfurniture.client.model.iron.ModelRubbishBin;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class IronBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private ModelFridge      modelFridge      = new ModelFridge();
	private ModelCooker      modelCooker      = new ModelCooker();
	private ModelRubbishBin  modelRubbishBin  = new ModelRubbishBin();
	private ModelCoffeeTable modelCoffeetable = new ModelCoffeeTable();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		TileEntityIronBlocksOne tileEntityIron = (TileEntityIronBlocksOne)tileEntity;
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockIronBlocksOne).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 1:
			case 5:
			case 11:
				rotation = 90; break;
			case 0:
			case 4:
			case 10:
				rotation = 180; break;
			case 3:
			case 7:
			case 9:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		if (subBlock == 12) {
			switch (tileEntityIron.rubishBinOrientation) {
				default:
				case 0: rotation = 270;   break;
				case 1: rotation = 180;  break;
				case 2: rotation = 90; break;
				case 3: rotation = 0; break;
			}
		}
		
		float doorProgess = tileEntityIron.getPreviousDoorOpenProgress() + (tileEntityIron.getDoorOpenProgress() - tileEntityIron.getPreviousDoorOpenProgress()) * f;
		
		switch (subBlock) {
		default:
			case 0:  
				this.modelFridge.setFridge();
				this.renderModel(this.modelFridge, "fridge", x, y, z, (invRender) ? 0 : rotation, doorProgess);
				break;

			case 4:  
				this.modelFridge.setFreezer();
				this.renderModel(this.modelFridge, "freezer", x, y, z, (invRender) ? 0 : rotation, doorProgess);
				break;
			case 8:  this.renderModel(this.modelCooker     , "cooker"     , x, y, z, rotation, doorProgess); break;
			case 12: this.renderModel(this.modelRubbishBin , "rubbishbin" , x, y, z, rotation, doorProgess); break;
			case 13: this.renderModel(this.modelCoffeetable, "coffeetable", x, y, z, rotation); break;
		}
	}
}
