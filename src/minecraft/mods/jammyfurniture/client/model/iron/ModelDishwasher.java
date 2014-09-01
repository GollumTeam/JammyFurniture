package mods.jammyfurniture.client.model.iron;

import org.lwjgl.opengl.GL11;

import mods.jammyfurniture.client.model.JFIModelDoor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDishwasher extends ModelBase implements JFIModelDoor {
	ModelRenderer dishwasherMain;
	public ModelRenderer dishwasherDoor;
	ModelRenderer controlPanel;
	ModelRenderer dialp1;
	ModelRenderer button4;
	ModelRenderer dialp2;
	ModelRenderer button1;
	ModelRenderer button2;
	ModelRenderer button3;

	public ModelDishwasher() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.dishwasherMain = new ModelRenderer(this, 0, 0);
		this.dishwasherMain.addBox(0.0F, 0.0F, 0.0F, 16, 16, 14);
		this.dishwasherMain.setRotationPoint(-8.0F, 8.0F, -6.0F);
		this.dishwasherMain.setTextureSize(128, 64);
		this.dishwasherMain.mirror = true;
		this.setRotation(this.dishwasherMain, 0.0F, 0.0F, 0.0F);
		this.dishwasherDoor = new ModelRenderer(this, 0, 32);
		this.dishwasherDoor.addBox(-8.0F, -13.0F, -1.0F, 16, 13, 1);
		this.dishwasherDoor.setRotationPoint(0.0F, 24.0F, -6.0F);
		this.dishwasherDoor.setTextureSize(128, 64);
		this.dishwasherDoor.mirror = true;
		this.setRotation(this.dishwasherDoor, 0.0F, 0.0F, 0.0F);
		this.controlPanel = new ModelRenderer(this, 0, 49);
		this.controlPanel.addBox(0.0F, 0.0F, 0.0F, 16, 3, 1);
		this.controlPanel.setRotationPoint(-8.0F, 8.0F, -7.0F);
		this.controlPanel.setTextureSize(128, 64);
		this.controlPanel.mirror = true;
		this.setRotation(this.controlPanel, 0.0F, 0.0F, 0.0F);
		this.dialp1 = new ModelRenderer(this, 37, 33);
		this.dialp1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
		this.dialp1.setRotationPoint(5.0F, 8.5F, -7.5F);
		this.dialp1.setTextureSize(128, 64);
		this.dialp1.mirror = true;
		this.setRotation(this.dialp1, 0.0F, 0.0F, 0.0F);
		this.button4 = new ModelRenderer(this, 37, 37);
		this.button4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button4.setRotationPoint(-2.6F, 9.0F, -7.8F);
		this.button4.setTextureSize(128, 64);
		this.button4.mirror = true;
		this.setRotation(this.button4, 0.0F, 0.0F, 0.0F);
		this.dialp2 = new ModelRenderer(this, 37, 37);
		this.dialp2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.dialp2.setRotationPoint(5.5F, 9.0F, -7.8F);
		this.dialp2.setTextureSize(128, 64);
		this.dialp2.mirror = true;
		this.setRotation(this.dialp2, 0.0F, 0.0F, 0.0F);
		this.button1 = new ModelRenderer(this, 37, 37);
		this.button1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button1.setRotationPoint(-6.5F, 9.0F, -7.8F);
		this.button1.setTextureSize(128, 64);
		this.button1.mirror = true;
		this.setRotation(this.button1, 0.0F, 0.0F, 0.0F);
		this.button2 = new ModelRenderer(this, 37, 37);
		this.button2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button2.setRotationPoint(-5.2F, 9.0F, -7.8F);
		this.button2.setTextureSize(128, 64);
		this.button2.mirror = true;
		this.setRotation(this.button2, 0.0F, 0.0F, 0.0F);
		this.button3 = new ModelRenderer(this, 37, 37);
		this.button3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button3.setRotationPoint(-3.9F, 9.0F, -7.8F);
		this.button3.setTextureSize(128, 64);
		this.button3.mirror = true;
		this.setRotation(this.button3, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.dishwasherMain.render(f5);
		this.dishwasherDoor.render(f5);
		this.controlPanel.render(f5);
		this.dialp1.render(f5);
		this.button4.render(f5);
		this.dialp2.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
		this.button3.render(f5);
	}

	public void renderModel(float f5) {
		this.dishwasherMain.render(f5);
		this.dishwasherDoor.render(f5);
		this.controlPanel.render(f5);
		this.dialp1.render(f5);
		this.button4.render(f5);
		this.dialp2.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
		this.button3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are
	 * used for animating the movement of arms and legs, where par1 represents
	 * the time(so that arms and legs swing back and forth) and par2 represents
	 * how "far" arms and legs can swing at most.
	 */
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

	@Override
	public void setDoorProgess(float doorProgess) {
		this.dishwasherDoor.rotateAngleX = doorProgess * (float) Math.PI / 3.0F;
	}
}
