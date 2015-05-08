package com.gollum.jammyfurniture.client.model.iron;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.JFIModelDoor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCooker extends ModelBase implements JFIModel, JFIModelDoor {
	ModelRenderer cookerBase;
	ModelRenderer cookerRing1;
	ModelRenderer cookerRing2;
	ModelRenderer cookerRing3;
	ModelRenderer cookerRing4;
	ModelRenderer cookerDoor;
	ModelRenderer cookerHandle;
	ModelRenderer cookerDoor2;
	ModelRenderer cookerHandle2;

	public ModelCooker() {
		
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.cookerBase = new ModelRenderer(this, 0, 31);
		this.cookerBase.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
		this.cookerBase.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.cookerBase.setTextureSize(128, 128);
		this.cookerBase.mirror = true;
		this.setRotation(this.cookerBase, 0.0F, 0.0F, 0.0F);
		
		this.cookerRing1 = new ModelRenderer(this, 0, 0);
		this.cookerRing1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
		this.cookerRing1.setRotationPoint(-6.0F, 7.0F, -6.0F);
		this.cookerRing1.setTextureSize(128, 128);
		this.cookerRing1.mirror = true;
		this.setRotation(this.cookerRing1, 0.0F, 0.0F, 0.0F);
		
		this.cookerRing2 = new ModelRenderer(this, 17, 0);
		this.cookerRing2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
		this.cookerRing2.setRotationPoint(-6.0F, 7.0F, 2.0F);
		this.cookerRing2.setTextureSize(128, 128);
		this.cookerRing2.mirror = true;
		this.setRotation(this.cookerRing2, 0.0F, 0.0F, 0.0F);
		
		this.cookerRing3 = new ModelRenderer(this, 0, 6);
		this.cookerRing3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
		this.cookerRing3.setRotationPoint(2.0F, 7.0F, 2.0F);
		this.cookerRing3.setTextureSize(128, 128);
		this.cookerRing3.mirror = true;
		this.setRotation(this.cookerRing3, 0.0F, 0.0F, 0.0F);
		
		this.cookerRing4 = new ModelRenderer(this, 17, 6);
		this.cookerRing4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
		this.cookerRing4.setRotationPoint(2.0F, 7.0F, -6.0F);
		this.cookerRing4.setTextureSize(128, 128);
		this.cookerRing4.mirror = true;
		this.setRotation(this.cookerRing4, 0.0F, 0.0F, 0.0F);
		
		this.cookerDoor = new ModelRenderer(this, 0, 12);
		this.cookerDoor.addBox(0.0F, 0.0F, 0.0F, 12, 5, 1);
		this.cookerDoor.setRotationPoint(-6.0F, 9.0F, -9.0F);
		this.cookerDoor.setTextureSize(128, 128);
		this.cookerDoor.mirror = true;
		this.setRotation(this.cookerDoor, 0.0F, 0.0F, 0.0F);

		this.cookerHandle = new ModelRenderer(this, 29, 12);
//		this.cookerHandle.addBox(0.0F, 0.0F, 1.0F, 1, 3, 1);
//		this.cookerHandle.setRotationPoint(4.0F, 10.0F, -10.0F);
//		this.cookerHandle = new ModelRenderer(this, 0, 12);
		this.cookerHandle.addBox(10.0F, 1.0F, -1.0F, 1, 3, 1);
		this.cookerHandle.setRotationPoint(-6.0F, 9.0F, -9.0F);
		this.cookerHandle.setTextureSize(128, 128);
		this.cookerHandle.mirror = true;
		this.setRotation(this.cookerHandle, 0.0F, 0.0F, 0.0F);
		
		this.cookerDoor2 = new ModelRenderer(this, 0, 20);
		this.cookerDoor2.addBox(0.0F, 0.0F, 0.0F, 12, 8, 1);
		this.cookerDoor2.setRotationPoint(-6.0F, 15.0F, -9.0F);
		this.cookerDoor2.setTextureSize(128, 128);
		this.cookerDoor2.mirror = true;
		this.setRotation(this.cookerDoor2, 0.0F, 0.0F, 0.0F);
		
		this.cookerHandle2 = new ModelRenderer(this, 29, 20);
		this.cookerHandle2.addBox(10.0F, 1.0F, -1.0F, 1, 6, 1);
		this.cookerHandle2.setRotationPoint(-6.0F, 15.0F, -9.0F);
		this.cookerHandle2.setTextureSize(128, 128);
		this.cookerHandle2.mirror = true;
		this.setRotation(this.cookerHandle2, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.cookerBase.render(f5);
		this.cookerRing1.render(f5);
		this.cookerRing2.render(f5);
		this.cookerRing3.render(f5);
		this.cookerRing4.render(f5);
		this.cookerDoor.render(f5);
		this.cookerHandle.render(f5);
		this.cookerDoor2.render(f5);
		this.cookerHandle2.render(f5);
	}

	public void renderModel(float f5) {
		this.cookerBase.render(f5);
		this.cookerRing1.render(f5);
		this.cookerRing2.render(f5);
		this.cookerRing3.render(f5);
		this.cookerRing4.render(f5);
		this.cookerDoor.render(f5);
		this.cookerHandle.render(f5);
		this.cookerDoor2.render(f5);
		this.cookerHandle2.render(f5);
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
		float rotation = (doorProgess * (float) Math.PI / 2.0F)*1.15F;
		this.cookerDoor.rotateAngleY    = rotation;
		this.cookerHandle.rotateAngleY  = rotation;
		this.cookerDoor2.rotateAngleY   = rotation;
		this.cookerHandle2.rotateAngleY = rotation;
	}
}
