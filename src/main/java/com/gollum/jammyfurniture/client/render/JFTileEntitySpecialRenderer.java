package com.gollum.jammyfurniture.client.render;

import java.util.HashMap;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.JFIModelDoor;

public abstract class JFTileEntitySpecialRenderer extends TileEntitySpecialRenderer {

	private HashMap<String, ResourceLocation> textures = new HashMap<String, ResourceLocation>();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {

		try {
			
			int metadata;
			boolean invRender = false;
		
			if (tileEntity.worldObj == null) {
				metadata = JFInventoryRenderer.getCurrentMetadata();
				invRender = true;
			} else {
				metadata = tileEntity.getBlockMetadata();
			}
			
			this.renderTileEntityAt(tileEntity, x,  y, z, f, metadata, invRender);
			
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
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(this.getTexture(textureName));
		GL11.glPushMatrix();
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}


	protected void renderModel(JFIModelDoor model, String textureName, double x, double y, double z, float rotation, float doorProgess) {
		model.setDoorProgess(doorProgess);
		this.renderModel(model, textureName, x, y, z, rotation);
	}
	
	protected abstract void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender);
	
}