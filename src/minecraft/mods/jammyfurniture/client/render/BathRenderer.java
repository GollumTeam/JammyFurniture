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
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
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
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(this.getTexture("bath"));
		GL11.glPushMatrix();
		if (left) {
			this.modelBath.renderModelLeft(0.0625F);
		} else {
			this.modelBath.renderModelRight(0.0625F);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	private void renderInInventory(double x, double y, double z) {
		ResourceLocation texture = this.getTexture("bath");
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
