package mods.jammyfurniture.client.render;

import java.util.HashMap;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public abstract class JFTileEntitySpecialRenderer extends TileEntitySpecialRenderer {

	private static HashMap<String, JFIModel> models = new HashMap<String, JFIModel>();
	private static HashMap<String, ResourceLocation> textures = new HashMap<String, ResourceLocation>();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

		try {
			
			int metadata;
			boolean invRender = false;
		
			if (tileentity.worldObj == null) {
				metadata = JFInventoryRenderer.getCurrentMetadata();
				invRender = true;
			} else {
				metadata = tileentity.getBlockMetadata();
			}
			
			this.renderTileEntityAt(tileentity, x,  y, z, f, metadata, invRender);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ResourceLocation getTexture (String name) {
		if (this.textures.containsKey(name)) {
			return this.textures.get (name);
		}
		
		ResourceLocation texture = new ResourceLocation(ModJammyFurniture.MODID.toLowerCase()+":textures/models/"+name+".png");
		if (texture != null) {
			this.textures.put(name, texture);
		}
		return texture;
	}
	
	private JFIModel getModel (Class<? extends JFIModel> modelClass) throws Exception {
		if (this.models.containsKey(modelClass.getName())) {
			return this.models.get (modelClass.getName());
		}
		
		return this.models.put (modelClass.getName(), modelClass.newInstance());
	}

	protected void renderModel(Class<? extends JFIModel> modelClass, String textureName, double x, double y, double z, float rotation) {
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		ResourceLocation texture = this.getTexture(textureName);
		if (texture != null) {
			this.bindTexture(texture);
		} else {
			ModJammyFurniture.log.warning("Error load texture model : "+textureName);
		}
		GL11.glPushMatrix();
		try {
			this.getModel(modelClass).renderModel(0.0625F);
//			modelClass.newInstance().renderModel(0.0625F);
		} catch (Exception e) {
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	protected abstract void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender);
	
}
