package mods.jammyfurniture.client.render;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.ModelBath;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BathRenderer extends JFTileEntitySpecialRenderer {
	
	private static final ModelBath modelBath = new ModelBath();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
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
		
		if (invRender) {
			
			renderInINv(x, y, z);
			
		} else {
			switch (metadata) {
				case 0:
				case 1:
				case 2:
				case 3:
//					GL11.glPushMatrix();
//					GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
//					GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
//					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
//					ResourceLocation texture = this.getTexture("bath");
//					if (texture != null) {
//						this.bindTexture(texture);
//					} else {
//						ModJammyFurniture.log.warning("Error load texture model : clocktop-dial");
//					}
//					GL11.glPushMatrix();
//					this.modelBath.renderModelLeft(0.0625F);
//					GL11.glPopMatrix();
//					GL11.glPopMatrix();
//					break;
	
				case 4:
				case 5:
				case 6:
				case 7:
				default:
					GL11.glPushMatrix();
					GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
					GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					ResourceLocation texture = this.getTexture("bath");
					if (texture != null) {
						this.bindTexture(texture);
					} else {
						ModJammyFurniture.log.warning("Error load texture model : clocktop-dial");
					}
					GL11.glPushMatrix();
					this.modelBath.renderModelLeft(0.0625F);
					GL11.glPopMatrix();
					GL11.glPopMatrix();
					break;
	
				case 8:
				case 9:
				case 10:
				case 11:
//					GL11.glPushMatrix();
//					GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
//					GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
//					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
//					ResourceLocation texture = this.getTexture("bath");
//					if (texture != null) {
//						this.bindTexture(texture);
//					} else {
//						ModJammyFurniture.log.warning("Error load texture model : clocktop-dial");
//					}
//					GL11.glPushMatrix();
//					this.modelBath.renderModelRight(0.0625F);
//					GL11.glPopMatrix();
//					GL11.glPopMatrix();
			}
		}
	}

	private void renderInINv(double x, double y, double z) {
		ResourceLocation texture = this.getTexture("bath");
		if (texture != null) {
			ModJammyFurniture.log.warning("Error load texture model : clocktop-dial");
			return;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.modelBath.renderModelLeft(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 1.5F);
		GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.modelBath.renderModelRight(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
