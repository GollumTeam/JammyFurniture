package com.gollum.jammyfurniture.client.render;

import com.gollum.jammyfurniture.client.model.ModelBath;

import net.minecraft.tileentity.TileEntity;

public class BathRenderer extends JFTileEntitySpecialRenderer {
	
	private static final ModelBath modelBath = new ModelBath();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata) {
		
		float rotation = 0;
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 0:
			case 10:
				rotation = 90; break;
			case 3:
			case 9:
				rotation = 180; break;
			case 2:
			case 8:
				rotation = 270; break;
		}
		
		if (this.isInventory) {
			
			renderInInventory(x, y, z);
			
		} else {
			
			if (metadata > 7) {
				renderModel(x, y, z, rotation, false);
			} else {
				renderModel(x, y, z, rotation, true);
			}
		}
	}

	private void renderModel(double x, double y, double z, float rotation, boolean left) {
		this.beforeRender("bath", x, y, z, rotation);
		if (left) {
			this.modelBath.renderModelLeft(0.0625F);
		} else {
			this.modelBath.renderModelRight(0.0625F);
		}
		this.endRender();
	}
	
	private void renderInInventory(double x, double y, double z) {
		this.beforeRender("bath", x, y, z-0.3F, 90.0F);
		this.modelBath.renderModelLeft(0.0625F);
		this.endRender();
		this.beforeRender("bath", x, y, z + 0.7F, 270.0F);
		this.modelBath.renderModelRight(0.0625F);
		this.endRender();
	}
}
