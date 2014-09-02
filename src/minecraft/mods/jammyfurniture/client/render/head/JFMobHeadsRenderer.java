package mods.jammyfurniture.client.render.head;

import java.util.List;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class JFMobHeadsRenderer extends JFTileEntitySpecialRenderer {

	List<JFIModel> models;
	List<String> textures;
	
	public void init(List<JFIModel> models, List<String> textures) {
		this.models = models;
		this.textures = textures;
	}
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {

		float rotation = 0;
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
			case 15:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
			case 14:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
			case 13:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}

		switch (metadata) {
			default:
			case 0:
			case 1:
			case 2:
			case 3:  this.renderModel(this.models.get(0), this.textures.get(0), x, y, z, rotation); break;
			case 4:
			case 5:
			case 6:
			case 7:  this.renderModel(this.models.get(1), this.textures.get(1), x, y, z, rotation); break;
			case 8:
			case 9:
			case 10:
			case 11:  this.renderModel(this.models.get(2), this.textures.get(2), x, y, z, rotation); break;
			case 12:
			case 13:
			case 14:
			case 15: this.renderModel(this.models.get(3), this.textures.get(3), x, y, z, rotation); break;
		}
		
	}
}