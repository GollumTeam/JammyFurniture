package com.gollum.jammyfurniture.client.model.wood;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClockTop extends ModelBase implements JFIModel {
	ModelRenderer middleTop;
	ModelRenderer clockFace;
	ModelRenderer clockDial[];
	ModelRenderer top1;
	ModelRenderer top4;
	ModelRenderer top3;
	ModelRenderer top2;
	
	

	public ModelClockTop() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.middleTop = new ModelRenderer(this, 0, 53);
		this.middleTop.addBox(0.0F, 0.0F, 0.0F, 8, 3, 8);
		this.middleTop.setRotationPoint(-4.0F, 21.0F, -4.0F);
		this.middleTop.setTextureSize(64, 64);
		this.middleTop.mirror = true;
		this.setRotation(this.middleTop, 0.0F, 0.0F, 0.0F);
		
		this.clockDial = new ModelRenderer[64];
		
		this.clockFace = new ModelRenderer(this, 0, 34);
		this.clockFace.addBox(0.0F, 0.0F, 0.0F, 10, 9, 10);
		this.clockFace.setRotationPoint(-5.0F, 12.0F, -5.0F);
		this.clockFace.setTextureSize(64, 64);
		this.clockFace.mirror = true;
		this.setRotation(this.clockFace, 0.0F, 0.0F, 0.0F);
		
		this.top1 = new ModelRenderer(this, 0, 0);
		this.top1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
		this.top1.setRotationPoint(-3.0F, 8.0F, -3.0F);
		this.top1.setTextureSize(64, 64);
		this.top1.mirror = true;
		this.setRotation(this.top1, 0.0F, 0.0F, 0.0F);
		
		this.top4 = new ModelRenderer(this, 0, 21);
		this.top4.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12);
		this.top4.setRotationPoint(-6.0F, 11.0F, -6.0F);
		this.top4.setTextureSize(64, 64);
		this.top4.mirror = true;
		this.setRotation(this.top4, 0.0F, 0.0F, 0.0F);
		
		this.top3 = new ModelRenderer(this, 0, 10);
		this.top3.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.top3.setRotationPoint(-5.0F, 10.0F, -5.0F);
		this.top3.setTextureSize(64, 64);
		this.top3.mirror = true;
		this.setRotation(this.top3, 0.0F, 0.0F, 0.0F);
		
		this.top2 = new ModelRenderer(this, 31, 0);
		this.top2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8);
		this.top2.setRotationPoint(-4.0F, 9.0F, -4.0F);
		this.top2.setTextureSize(64, 64);
		this.top2.mirror = true;
		this.setRotation(this.top2, 0.0F, 0.0F, 0.0F);
	}
	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.middleTop.render(f5);
		this.clockFace.render(f5);
		this.top1.render(f5);
		this.top4.render(f5);
		this.top3.render(f5);
		this.top2.render(f5);
	}
	
	@Override
	public void renderModel(float f1) {		
		this.middleTop.render(f1);
		this.clockFace.render(f1);
		this.top1.render(f1);
		this.top4.render(f1);
		this.top3.render(f1);
		this.top2.render(f1);
	}
	
	public void renderDial (int numDial, float f1) {
		this.textureWidth = 8;
		this.textureHeight = 378;
		if (this.clockDial[numDial] == null) {
			this.clockDial[numDial] = new ModelRenderer(this, 0, 6*numDial);
			this.clockDial[numDial].addBox(1.0F, 1.0F, 0.0F, 8, 6, 0);
			this.clockDial[numDial].setRotationPoint(-5.0F, 12.0F, -5.0F);
			this.clockDial[numDial].mirror = true;
			this.setRotation(this.clockDial[numDial], 0.0F, 0.0F, 0.0F);
			
		}
		this.clockDial[numDial].render(f1);
		this.textureWidth = 64;
		this.textureHeight = 64;
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
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}
