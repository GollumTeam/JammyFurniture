package com.gollum.jammyfurniture.client.model.heads;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderDragonHead extends ModelBase implements JFIModel {
	ModelRenderer jawTop;
	ModelRenderer headMain;
	ModelRenderer ear2;
	ModelRenderer nostril2;
	ModelRenderer jawBottom;
	ModelRenderer nostril1;
	ModelRenderer ear1;

	public ModelEnderDragonHead() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.jawTop = new ModelRenderer(this, 0, 18);
		this.jawTop.addBox(0.0F, 0.0F, 0.0F, 6, 3, 8);
		this.jawTop.setRotationPoint(-3.0F, 17.0F, -6.0F);
		this.jawTop.setTextureSize(64, 32);
		this.jawTop.mirror = true;
		this.setRotation(this.jawTop, 0.0F, 0.0F, 0.0F);
		this.headMain = new ModelRenderer(this, 0, 0);
		this.headMain.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
		this.headMain.setRotationPoint(-4.0F, 14.0F, 0.0F);
		this.headMain.setTextureSize(64, 32);
		this.headMain.mirror = true;
		this.setRotation(this.headMain, 0.0F, 0.0F, 0.0F);
		this.ear2 = new ModelRenderer(this, 35, 0);
		this.ear2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
		this.ear2.setRotationPoint(2.0F, 12.0F, 4.0F);
		this.ear2.setTextureSize(64, 32);
		this.ear2.mirror = true;
		this.setRotation(this.ear2, 0.0F, 0.0F, 0.0F);
		this.nostril2 = new ModelRenderer(this, 35, 7);
		this.nostril2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.nostril2.setRotationPoint(1.0F, 16.0F, -5.0F);
		this.nostril2.setTextureSize(64, 32);
		this.nostril2.mirror = true;
		this.setRotation(this.nostril2, 0.0F, 0.0F, 0.0F);
		this.jawBottom = new ModelRenderer(this, 30, 18);
		this.jawBottom.addBox(0.0F, 0.0F, 0.0F, 6, 2, 8);
		this.jawBottom.setRotationPoint(-3.0F, 21.0F, -6.0F);
		this.jawBottom.setTextureSize(64, 32);
		this.jawBottom.mirror = true;
		this.setRotation(this.jawBottom, 0.1487144F, 0.0F, 0.0F);
		this.nostril1 = new ModelRenderer(this, 35, 7);
		this.nostril1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.nostril1.setRotationPoint(-2.0F, 16.0F, -5.0F);
		this.nostril1.setTextureSize(64, 32);
		this.nostril1.mirror = true;
		this.setRotation(this.nostril1, 0.0F, 0.0F, 0.0F);
		this.ear1 = new ModelRenderer(this, 35, 0);
		this.ear1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
		this.ear1.setRotationPoint(-3.0F, 12.0F, 4.0F);
		this.ear1.setTextureSize(64, 32);
		this.ear1.mirror = true;
		this.setRotation(this.ear1, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.jawTop.render(f5);
		this.headMain.render(f5);
		this.ear2.render(f5);
		this.nostril2.render(f5);
		this.jawBottom.render(f5);
		this.nostril1.render(f5);
		this.ear1.render(f5);
	}

	public void renderModel(float f5) {
		this.jawTop.render(f5);
		this.headMain.render(f5);
		this.ear2.render(f5);
		this.nostril2.render(f5);
		this.jawBottom.render(f5);
		this.nostril1.render(f5);
		this.ear1.render(f5);
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
