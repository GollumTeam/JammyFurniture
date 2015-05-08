package com.gollum.jammyfurniture.client.model.iron;

import com.gollum.jammyfurniture.client.model.JFIModelDoor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFridge extends ModelBase implements JFIModelDoor {
	
	private boolean isFridge = true;
	
	ModelRenderer fridgeMain;
	ModelRenderer p7;
	ModelRenderer p1;
	ModelRenderer p9;
	ModelRenderer p8;
	ModelRenderer p11;
	ModelRenderer p6;
	ModelRenderer p4;
	ModelRenderer p5;
	ModelRenderer p10;
	ModelRenderer p3;
	ModelRenderer p2;
	public ModelRenderer door;
	public ModelRenderer handle;
	public ModelRenderer handle2;

	public ModelFridge() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.fridgeMain = new ModelRenderer(this, 0, 28);
		this.fridgeMain.addBox(0.0F, 0.0F, 0.0F, 14, 16, 11);
		this.fridgeMain.setRotationPoint(-7.0F, 8.0F, -6.0F);
		this.fridgeMain.setTextureSize(64, 64);
		this.fridgeMain.mirror = true;
		this.setRotation(this.fridgeMain, 0.0F, 0.0F, 0.0F);
		this.p7 = new ModelRenderer(this, 0, 0);
		this.p7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.p7.setRotationPoint(4.0F, 16.0F, -6.5F);
		this.p7.setTextureSize(64, 64);
		this.p7.mirror = true;
		this.setRotation(this.p7, 0.0F, 0.0F, 0.0F);
		this.p1 = new ModelRenderer(this, 0, 0);
		this.p1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.p1.setRotationPoint(-5.0F, 10.0F, -6.5F);
		this.p1.setTextureSize(64, 64);
		this.p1.mirror = true;
		this.setRotation(this.p1, 0.0F, 0.0F, 0.0F);
		this.p9 = new ModelRenderer(this, 0, 0);
		this.p9.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.p9.setRotationPoint(-5.0F, 18.0F, -6.5F);
		this.p9.setTextureSize(64, 64);
		this.p9.mirror = true;
		this.setRotation(this.p9, 0.0F, 0.0F, 0.0F);
		this.p8 = new ModelRenderer(this, 0, 6);
		this.p8.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
		this.p8.setRotationPoint(-5.0F, 17.0F, -6.5F);
		this.p8.setTextureSize(64, 64);
		this.p8.mirror = true;
		this.setRotation(this.p8, 0.0F, 0.0F, 0.0F);
		this.p11 = new ModelRenderer(this, 0, 0);
		this.p11.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.p11.setRotationPoint(4.0F, 19.0F, -6.5F);
		this.p11.setTextureSize(64, 64);
		this.p11.mirror = true;
		this.setRotation(this.p11, 0.0F, 0.0F, 0.0F);
		this.p6 = new ModelRenderer(this, 0, 6);
		this.p6.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
		this.p6.setRotationPoint(-4.0F, 15.0F, -6.5F);
		this.p6.setTextureSize(64, 64);
		this.p6.mirror = true;
		this.setRotation(this.p6, 0.0F, 0.0F, 0.0F);
		this.p4 = new ModelRenderer(this, 0, 6);
		this.p4.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
		this.p4.setRotationPoint(-5.0F, 13.0F, -6.5F);
		this.p4.setTextureSize(64, 64);
		this.p4.mirror = true;
		this.setRotation(this.p4, 0.0F, 0.0F, 0.0F);
		this.p5 = new ModelRenderer(this, 0, 0);
		this.p5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.p5.setRotationPoint(-5.0F, 14.0F, -6.5F);
		this.p5.setTextureSize(64, 64);
		this.p5.mirror = true;
		this.setRotation(this.p5, 0.0F, 0.0F, 0.0F);
		this.p10 = new ModelRenderer(this, 0, 6);
		this.p10.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
		this.p10.setRotationPoint(-4.0F, 19.0F, -6.5F);
		this.p10.setTextureSize(64, 64);
		this.p10.mirror = true;
		this.setRotation(this.p10, 0.0F, 0.0F, 0.0F);
		this.p3 = new ModelRenderer(this, 0, 0);
		this.p3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.p3.setRotationPoint(4.0F, 11.0F, -6.5F);
		this.p3.setTextureSize(64, 64);
		this.p3.mirror = true;
		this.setRotation(this.p3, 0.0F, 0.0F, 0.0F);
		this.p2 = new ModelRenderer(this, 0, 6);
		this.p2.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
		this.p2.setRotationPoint(-5.0F, 11.0F, -6.5F);
		this.p2.setTextureSize(64, 64);
		this.p2.mirror = true;
		this.setRotation(this.p2, 0.0F, 0.0F, 0.0F);
		
		this.door = new ModelRenderer(this, 24, 8);
		this.door.addBox(0.0F, 0.0F, 0.0F, 14, 16, 1);
		this.door.setRotationPoint(-7.0F, 8.0F, 5.0F);
		this.door.setTextureSize(64, 64);
		this.door.mirror = true;
		this.setRotation(this.door, 0.0F, 0.0F, 0.0F);
		
		this.handle = new ModelRenderer(this, 24, 4);
		this.handle.addBox(11.0F, 15.0F, 1.0F, 3, 1, 1);
		this.handle.setRotationPoint(-7.0F, 8.0F, 5.0F);
		this.handle.setTextureSize(64, 64);
		this.handle.mirror = true;
		this.setRotation(this.handle, 0.0F, 0.0F, 0.0F);
		
		this.handle2 = new ModelRenderer(this, 24, 4);
		this.handle2.addBox(11.0F, 0.0F, 1.0F, 3, 1, 1);
		this.handle2.setRotationPoint(-7.0F, 8.0F, 5.0F);
		this.handle2.setTextureSize(64, 64);
		this.handle2.mirror = true;
		this.setRotation(this.handle2, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.fridgeMain.render(f5);
		this.p7.render(f5);
		this.p1.render(f5);
		this.p9.render(f5);
		this.p8.render(f5);
		this.p11.render(f5);
		this.p6.render(f5);
		this.p4.render(f5);
		this.p5.render(f5);
		this.p10.render(f5);
		this.p3.render(f5);
		this.p2.render(f5);
		this.door.render(f5);
		this.handle.render(f5);
	}
	
	public void setFridge () {
		this.isFridge = true;
	}

	public void setFreezer () {
		this.isFridge = false;
	}

	@Override
	public void renderModel(float f5) {
		this.fridgeMain.render(f5);
		this.fridgeMain.render(f5);
		this.p7.render(f5);
		this.p1.render(f5);
		this.p9.render(f5);
		this.p8.render(f5);
		this.p11.render(f5);
		this.p6.render(f5);
		this.p4.render(f5);
		this.p5.render(f5);
		this.p10.render(f5);
		this.p3.render(f5);
		this.p2.render(f5);
		this.door.render(f5);
		if (this.isFridge) {
			this.handle2.render(f5);
		} else {
			this.handle.render(f5);
		}
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
		float rotation = -(doorProgess * (float) Math.PI / 2.0F);
		this.door.rotateAngleY    = rotation;
		this.handle.rotateAngleY  = rotation;
		this.handle2.rotateAngleY = rotation;
	}
}
