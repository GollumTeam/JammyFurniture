package com.gollum.jammyfurniture.client.render;

import java.util.HashMap;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.JFIModelDoor;

public abstract class JFTileEntitySpecialRenderer extends TileEntitySpecialRenderer {
	private HashMap<String, ResourceLocation> textures = new HashMap<String, ResourceLocation>();
	protected boolean isInventory;
	protected boolean light = false;
	protected boolean lightInventory = true;
	protected double scale = 1.0;
	protected double scaleInventory = 1.0;
	protected float alpha = 1.0F;
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {

		try {
			
			int metadata;
			this.isInventory = tileEntity.getWorldObj() == null;
			
			if (this.isInventory) {
				metadata = JFInventoryRenderer.getCurrentMetadata();
			} else {
				metadata = tileEntity.getBlockMetadata();
			}
			
			this.renderTileEntityAt(tileEntity, x,  y, z, f, metadata);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected ResourceLocation getTexture (String name) {
		if (this.textures.containsKey(name)) {
			return this.textures.get (name);
		}
		ResourceLocation texture = new ResourceLocation(ModJammyFurniture.MODID.toLowerCase()+":textures/models/"+name+".png");
		this.textures.put(name, texture);
		return texture;
	}
	
	protected void renderModel(JFIModel model, String textureName, double x, double y, double z, float rotation) {
		this.beforeRender(textureName, x, y, z, rotation);
		model.renderModel(0.0625F);
		this.endRender();
	}
	
	protected void beforeRender(String textureName, double x, double y, double z, float rotation) {
		
		this.bindTexture(this.getTexture(textureName));
		
		if (this.isInventory && this.lightInventory) {
			RenderHelper.enableGUIStandardItemLighting();
		} else {
			if (this.light) {
				RenderHelper.disableStandardItemLighting();
			} else {
				RenderHelper.enableStandardItemLighting();
			}
		}
		
		GL11.glPushMatrix();
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F + (float)(this.isInventory ? this.scaleInventory : 1.0), (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScaled(
			this.scale * (this.isInventory ? this.scaleInventory : 1.0),
			this.scale * (this.isInventory ? this.scaleInventory : 1.0), 
			this.scale * (this.isInventory ? this.scaleInventory : 1.0)
		);
		
		if (this.alpha != 1.0F && !this.isInventory) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1F, 1F, 1F, this.alpha);
		}
	}
	
	protected void endRender() {
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glPopMatrix();
		if (this.alpha != 1.0F && !this.isInventory) {
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor4f(1f, 1f, 1f, 1f);
		}
		GL11.glPopMatrix();
	}
	
	protected void renderModel(JFIModelDoor model, String textureName, double x, double y, double z, float rotation, float doorProgess) {
		model.setDoorProgess(doorProgess);
		this.renderModel(model, textureName, x, y, z, rotation);
	}
	
	protected abstract void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata);
	
}
