package com.gollum.jammyfurniture.client.model.misc;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChimney extends ModelBase implements JFIModel {
	
	ModelRenderer chimneyBase;
	ModelRenderer chimneyMid;
	ModelRenderer chimneyMid3;
	ModelRenderer chimneyMid2;
	ModelRenderer chimneyTop1;
	ModelRenderer chimneyTop2;
	ModelRenderer chimneyTop3;
	ModelRenderer chimneyTop4;

	public ModelChimney() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.chimneyBase = new ModelRenderer(this, 0, 0);
		this.chimneyBase.addBox(0.0F, 0.0F, 0.0F, 16, 11, 16);
		this.chimneyBase.setRotationPoint(-8.0F, 13.0F, -8.0F);
		this.chimneyBase.setTextureSize(128, 128);
		this.chimneyBase.mirror = true;
		this.setRotation(this.chimneyBase, 0.0F, 0.0F, 0.0F);
		this.chimneyMid = new ModelRenderer(this, 0, 30);
		this.chimneyMid.addBox(0.0F, 0.0F, 0.0F, 18, 3, 18);
		this.chimneyMid.setRotationPoint(-9.0F, 10.0F, -9.0F);
		this.chimneyMid.setTextureSize(128, 128);
		this.chimneyMid.mirror = true;
		this.setRotation(this.chimneyMid, 0.0F, 0.0F, 0.0F);
		this.chimneyMid3 = new ModelRenderer(this, 0, 74);
		this.chimneyMid3.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14);
		this.chimneyMid3.setRotationPoint(-7.0F, 8.0F, -7.0F);
		this.chimneyMid3.setTextureSize(128, 128);
		this.chimneyMid3.mirror = true;
		this.setRotation(this.chimneyMid3, 0.0F, 0.0F, 0.0F);
		this.chimneyMid2 = new ModelRenderer(this, 0, 54);
		this.chimneyMid2.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
		this.chimneyMid2.setRotationPoint(-8.0F, 9.0F, -8.0F);
		this.chimneyMid2.setTextureSize(128, 128);
		this.chimneyMid2.mirror = true;
		this.setRotation(this.chimneyMid2, 0.0F, 0.0F, 0.0F);
		this.chimneyTop1 = new ModelRenderer(this, 67, 0);
		this.chimneyTop1.addBox(0.0F, 0.0F, 0.0F, 4, 7, 1);
		this.chimneyTop1.setRotationPoint(-2.5F, 1.0F, 1.5F);
		this.chimneyTop1.setTextureSize(128, 128);
		this.chimneyTop1.mirror = true;
		this.setRotation(this.chimneyTop1, 0.0F, 0.0F, 0.0F);
		this.chimneyTop2 = new ModelRenderer(this, 67, 0);
		this.chimneyTop2.addBox(0.0F, 0.0F, 0.0F, 4, 7, 1);
		this.chimneyTop2.setRotationPoint(-2.5F, 1.0F, -2.5F);
		this.chimneyTop2.setTextureSize(128, 128);
		this.chimneyTop2.mirror = true;
		this.setRotation(this.chimneyTop2, 0.0F, 0.0F, 0.0F);
		this.chimneyTop3 = new ModelRenderer(this, 67, 10);
		this.chimneyTop3.addBox(0.0F, 0.0F, 0.0F, 1, 7, 3);
		this.chimneyTop3.setRotationPoint(-2.5F, 1.0F, -1.5F);
		this.chimneyTop3.setTextureSize(128, 128);
		this.chimneyTop3.mirror = true;
		this.setRotation(this.chimneyTop3, 0.0F, 0.0F, 0.0F);
		this.chimneyTop4 = new ModelRenderer(this, 80, 0);
		this.chimneyTop4.addBox(0.0F, 0.0F, 0.0F, 1, 7, 5);
		this.chimneyTop4.setRotationPoint(1.5F, 1.0F, -2.5F);
		this.chimneyTop4.setTextureSize(128, 128);
		this.chimneyTop4.mirror = true;
		this.setRotation(this.chimneyTop4, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.chimneyBase.render(f5);
		this.chimneyMid.render(f5);
		this.chimneyMid3.render(f5);
		this.chimneyMid2.render(f5);
		this.chimneyTop1.render(f5);
		this.chimneyTop2.render(f5);
		this.chimneyTop3.render(f5);
		this.chimneyTop4.render(f5);
	}

	public void renderModel(float f5) {
		this.chimneyBase.render(f5);
		this.chimneyMid.render(f5);
		this.chimneyMid3.render(f5);
		this.chimneyMid2.render(f5);
		this.chimneyTop1.render(f5);
		this.chimneyTop2.render(f5);
		this.chimneyTop3.render(f5);
		this.chimneyTop4.render(f5);
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
