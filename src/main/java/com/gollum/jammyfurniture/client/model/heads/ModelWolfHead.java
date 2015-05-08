package com.gollum.jammyfurniture.client.model.heads;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWolfHead extends ModelBase implements JFIModel {
	ModelRenderer headMain;
	ModelRenderer earRight;
	ModelRenderer earLeft;
	ModelRenderer nose;

	public ModelWolfHead() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.headMain = new ModelRenderer(this, 0, 0);
		this.headMain.addBox(0.0F, 0.0F, 0.0F, 6, 6, 4);
		this.headMain.setRotationPoint(-3.0F, 14.0F, 4.0F);
		this.headMain.setTextureSize(64, 32);
		this.headMain.mirror = true;
		this.setRotation(this.headMain, 0.0F, 0.0F, 0.0F);
		this.earRight = new ModelRenderer(this, 22, 0);
		this.earRight.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
		this.earRight.setRotationPoint(1.0F, 12.0F, 6.0F);
		this.earRight.setTextureSize(64, 32);
		this.earRight.mirror = true;
		this.setRotation(this.earRight, 0.0F, 0.0F, 0.0F);
		this.earLeft = new ModelRenderer(this, 22, 5);
		this.earLeft.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
		this.earLeft.setRotationPoint(-3.0F, 12.0F, 6.0F);
		this.earLeft.setTextureSize(64, 32);
		this.earLeft.mirror = true;
		this.setRotation(this.earLeft, 0.0F, 0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 0, 11);
		this.nose.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
		this.nose.setRotationPoint(-1.5F, 17.0F, 1.0F);
		this.nose.setTextureSize(64, 32);
		this.nose.mirror = true;
		this.setRotation(this.nose, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.headMain.render(f5);
		this.earRight.render(f5);
		this.earLeft.render(f5);
		this.nose.render(f5);
	}

	public void renderModel(float f5) {
		this.headMain.render(f5);
		this.earRight.render(f5);
		this.earLeft.render(f5);
		this.nose.render(f5);
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
}
