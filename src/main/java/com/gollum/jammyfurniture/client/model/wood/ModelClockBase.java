package com.gollum.jammyfurniture.client.model.wood;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClockBase extends ModelBase implements JFIModel {
	ModelRenderer base;
	ModelRenderer baseTop;
	ModelRenderer middle;

	public ModelClockBase() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.base = new ModelRenderer(this, 3, 2);
		this.base.addBox(0.0F, 0.0F, 0.0F, 12, 10, 12);
		this.base.setRotationPoint(-6.0F, 14.0F, -6.0F);
		this.base.setTextureSize(64, 32);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		this.baseTop = new ModelRenderer(this, 3, 28);
		this.baseTop.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.baseTop.setRotationPoint(-5.0F, 13.0F, -5.0F);
		this.baseTop.setTextureSize(64, 32);
		this.baseTop.mirror = true;
		this.setRotation(this.baseTop, 0.0F, 0.0F, 0.0F);
		this.middle = new ModelRenderer(this, 7, 41);
		this.middle.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8);
		this.middle.setRotationPoint(-4.0F, 8.0F, -4.0F);
		this.middle.setTextureSize(64, 64);
		this.middle.mirror = true;
		this.setRotation(this.middle, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.base.render(f5);
		this.baseTop.render(f5);
		this.middle.render(f5);
	}

	public void renderModel(float f1) {
		this.base.render(f1);
		this.baseTop.render(f1);
		this.middle.render(f1);
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
