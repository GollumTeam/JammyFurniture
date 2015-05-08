package com.gollum.jammyfurniture.client.model.wood;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKitchenCupboard extends ModelBase implements JFIModel {
	
	ModelRenderer main;
	ModelRenderer handle;

	public ModelKitchenCupboard() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.main = new ModelRenderer(this, 0, 0);
		this.main.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
		this.main.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.main.setTextureSize(64, 32);
		this.main.mirror = true;
		this.setRotation(this.main, 0.0F, 0.0F, 0.0F);
		this.handle = new ModelRenderer(this, 0, 0);
		this.handle.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.handle.setRotationPoint(-6.0F, 15.0F, -9.0F);
		this.handle.setTextureSize(64, 32);
		this.handle.mirror = true;
		this.setRotation(this.handle, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.main.render(f5);
		this.handle.render(f5);
	}

	public void renderModel(float f5) {
		this.main.render(f5);
		this.handle.render(f5);
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
