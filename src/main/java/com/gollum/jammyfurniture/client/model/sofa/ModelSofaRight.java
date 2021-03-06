package com.gollum.jammyfurniture.client.model.sofa;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSofaRight extends ModelBase implements JFIModel {
	
	ModelRenderer chairBase;
	ModelRenderer chairBack;
	ModelRenderer chairSideL;
	ModelRenderer chairSideTopL;
	ModelRenderer foot4;
	ModelRenderer foot3;
	ModelRenderer foot1;
	ModelRenderer foot2;
	ModelRenderer cushion;

	public ModelSofaRight() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.chairBase = new ModelRenderer(this, 0, 33);
		this.chairBase.addBox(0.0F, 0.0F, 0.0F, 16, 3, 16);
		this.chairBase.setRotationPoint(-8.0F, 19.0F, -8.0F);
		this.chairBase.setTextureSize(128, 64);
		this.chairBase.mirror = true;
		this.setRotation(this.chairBase, 0.0F, 0.0F, 0.0F);
		this.chairBack = new ModelRenderer(this, 0, 13);
		this.chairBack.addBox(0.0F, 0.0F, 0.0F, 16, 14, 2);
		this.chairBack.setRotationPoint(-8.0F, 5.0F, 6.0F);
		this.chairBack.setTextureSize(128, 64);
		this.chairBack.mirror = true;
		this.setRotation(this.chairBack, 0.0F, 0.0F, 0.0F);
		this.chairSideL = new ModelRenderer(this, 38, 9);
		this.chairSideL.addBox(0.0F, 0.0F, 0.0F, 2, 6, 14);
		this.chairSideL.setRotationPoint(6.0F, 13.0F, -8.0F);
		this.chairSideL.setTextureSize(128, 64);
		this.chairSideL.mirror = true;
		this.setRotation(this.chairSideL, 0.0F, 0.0F, 0.0F);
		this.chairSideTopL = new ModelRenderer(this, 75, 12);
		this.chairSideTopL.addBox(0.0F, 0.0F, 0.0F, 3, 3, 14);
		this.chairSideTopL.setRotationPoint(6.0F, 11.0F, -8.0F);
		this.chairSideTopL.setTextureSize(128, 64);
		this.chairSideTopL.mirror = true;
		this.setRotation(this.chairSideTopL, 0.0F, 0.0F, 0.0F);
		this.foot4 = new ModelRenderer(this, 0, 54);
		this.foot4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.foot4.setRotationPoint(6.0F, 22.0F, 6.0F);
		this.foot4.setTextureSize(128, 64);
		this.foot4.mirror = true;
		this.setRotation(this.foot4, 0.0F, 0.0F, 0.0F);
		this.foot3 = new ModelRenderer(this, 0, 54);
		this.foot3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.foot3.setRotationPoint(-8.0F, 22.0F, 6.0F);
		this.foot3.setTextureSize(128, 64);
		this.foot3.mirror = true;
		this.setRotation(this.foot3, 0.0F, 0.0F, 0.0F);
		this.foot1 = new ModelRenderer(this, 0, 54);
		this.foot1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.foot1.setRotationPoint(-8.0F, 22.0F, -8.0F);
		this.foot1.setTextureSize(128, 64);
		this.foot1.mirror = true;
		this.setRotation(this.foot1, 0.0F, 0.0F, 0.0F);
		this.foot2 = new ModelRenderer(this, 0, 54);
		this.foot2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.foot2.setRotationPoint(6.0F, 22.0F, -8.0F);
		this.foot2.setTextureSize(128, 64);
		this.foot2.mirror = true;
		this.setRotation(this.foot2, 0.0F, 0.0F, 0.0F);
		this.cushion = new ModelRenderer(this, 67, 35);
		this.cushion.addBox(0.0F, 0.0F, 0.0F, 14, 3, 14);
		this.cushion.setRotationPoint(-8.0F, 16.0F, -7.5F);
		this.cushion.setTextureSize(128, 64);
		this.cushion.mirror = true;
		this.setRotation(this.cushion, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.chairBase.render(f5);
		this.chairBack.render(f5);
		this.chairSideL.render(f5);
		this.chairSideTopL.render(f5);
		this.foot4.render(f5);
		this.foot3.render(f5);
		this.foot1.render(f5);
		this.foot2.render(f5);
		this.cushion.render(f5);
	}

	public void renderModel(float f5) {
		this.chairBase.render(f5);
		this.chairBack.render(f5);
		this.chairSideL.render(f5);
		this.chairSideTopL.render(f5);
		this.foot4.render(f5);
		this.foot3.render(f5);
		this.foot1.render(f5);
		this.foot2.render(f5);
		this.cushion.render(f5);
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
