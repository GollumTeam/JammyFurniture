package com.gollum.jammyfurniture.client.render.wood;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelChair;
import com.gollum.jammyfurniture.client.model.wood.ModelRadio;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;

public class WoodBlocksThreeRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelChair  chair = new ModelChair();
	private ModelRadio  radio = new ModelRadio();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
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
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		ResourceLocation texture = this.getTexture("blinds");
		if (texture != null) {
			this.bindTexture(texture);
		} else {
			ModJammyFurniture.log.warning("Error load texture model : blinds");
		}
		GL11.glPushMatrix();
		this.blinds.renderModelClosed(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void renderModelBlindsHalfOpen(double x, double y, double z, float rotation) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		ResourceLocation texture = this.getTexture("blinds");
		if (texture != null) this.bindTexture(texture);
		GL11.glPushMatrix();
		this.blinds.shape1.rotateAngleX = 26.0F;
		this.blinds.shape2.rotateAngleX = 26.0F;
		this.blinds.shape3.rotateAngleX = 26.0F;
		this.blinds.shape4.rotateAngleX = 26.0F;
		this.blinds.shape5.rotateAngleX = 26.0F;
		this.blinds.shape6.rotateAngleX = 26.0F;
		this.blinds.shape7.rotateAngleX = 26.0F;
		this.blinds.shape8.rotateAngleX = 26.0F;
		this.blinds.shape9.rotateAngleX = 26.0F;
		this.blinds.shape10.rotateAngleX = 26.0F;
		this.blinds.shape11.rotateAngleX = 26.0F;
		this.blinds.shape12.rotateAngleX = 26.0F;
		this.blinds.shape13.rotateAngleX = 26.0F;
		this.blinds.shape14.rotateAngleX = 26.0F;
		this.blinds.shape15.rotateAngleX = 26.0F;
		this.blinds.shape16.rotateAngleX = 26.0F;
		this.blinds.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
}
