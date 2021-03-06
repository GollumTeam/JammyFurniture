package com.gollum.jammyfurniture.client.render.wood;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelChair;
import com.gollum.jammyfurniture.client.model.wood.ModelRadio;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;

import net.minecraft.tileentity.TileEntity;

public class WoodBlocksThreeRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelChair  chair = new ModelChair();
	private ModelRadio  radio = new ModelRadio();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata) {
		
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
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		
		switch (metadata) {
			default:
			case 0:
			case 1:
			case 2:
			case 3:
				this.renderModel(this.chair, "chair", x, y, z, rotation);
				break;
			
			case 4:
			case 5:
			case 6:
			case 7:
				this.renderModel(this.radio, "radio", x, y, z, rotation);
				break;

			case 8:
			case 9:
			case 10:
			case 11:
				this.renderModelBlindsHalfOpen(x, y, z, rotation);
				break;

			case 12:
			case 13:
			case 14:
			case 15:
				this.renderModelBlindsCloses(x, y, z, rotation);
				break;
		}
	}
	
	private void renderModelBlindsCloses(double x, double y, double z, float rotation) {
		this.beforeRender("blinds", x, y, z, rotation);
		this.blinds.renderModelClosed(0.0625F);
		this.endRender();
	}
	
	private void renderModelBlindsHalfOpen(double x, double y, double z, float rotation) {
		this.beforeRender("blinds", x, y, z, rotation);
		this.blinds.renderModelHalfOpen(0.0625F);
		this.endRender();
	}
	
}
