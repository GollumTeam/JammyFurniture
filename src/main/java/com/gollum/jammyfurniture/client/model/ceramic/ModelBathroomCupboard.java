package com.gollum.jammyfurniture.client.model.ceramic;

import com.gollum.jammyfurniture.client.model.JFIModelDoor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBathroomCupboard extends ModelBase implements JFIModelDoor {
	ModelRenderer cupboardMain;
	ModelRenderer cupboardDoorRight;

	public ModelBathroomCupboard() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.cupboardMain = new ModelRenderer(this, 0, 0);
		this.cupboardMain.addBox(0.0F, 0.0F, 0.0F, 12, 12, 5);
		this.cupboardMain.setRotationPoint(-6.0F, 10.0F, 3.0F);
		this.cupboardMain.setTextureSize(64, 64);
		this.cupboardMain.mirror = true;
		this.setRotation(this.cupboardMain, 0.0F, 0.0F, 0.0F);
		
		this.cupboardDoorRight = new ModelRenderer(this, 0, 20);
		this.cupboardDoorRight.addBox(-12.0F, 0.0F, -1.0F, 12, 12, 1);
		this.cupboardDoorRight.setRotationPoint(6.0F, 10.0F, 3.0F);
		this.cupboardDoorRight.setTextureSize(64, 64);
		this.cupboardDoorRight.mirror = true;
		this.setRotation(this.cupboardDoorRight, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.cupboardMain.render(f5);
		this.cupboardDoorRight.render(f5);
	}

	public void renderModel(float f5) {
		this.cupboardMain.render(f5);
		this.cupboardDoorRight.render(f5);
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
		this.cupboardDoorRight.rotateAngleY = -doorProgess * (float) Math.PI / 1.5F;
		
	}
}
