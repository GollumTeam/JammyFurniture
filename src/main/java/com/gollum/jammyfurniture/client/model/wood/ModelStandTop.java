package com.gollum.jammyfurniture.client.model.wood;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStandTop extends ModelBase implements JFIModel {
	
	ModelRenderer pole;
	ModelRenderer deco1;
	ModelRenderer deco2;
	ModelRenderer spindelBottom4;
	ModelRenderer spindelBottom3;
	ModelRenderer spindelBottom1;
	ModelRenderer spindelBottom2;
	ModelRenderer spindelTop1;
	ModelRenderer spindelTop4;
	ModelRenderer spindelTop3;
	ModelRenderer spindelTop2;

	public ModelStandTop() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.pole = new ModelRenderer(this, 13, 0);
		this.pole.addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
		this.pole.setRotationPoint(-0.5F, 11.0F, -0.5F);
		this.pole.setTextureSize(64, 32);
		this.pole.mirror = true;
		this.setRotation(this.pole, 0.0F, 0.0F, 0.0F);
		this.deco1 = new ModelRenderer(this, 0, 13);
		this.deco1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.deco1.setRotationPoint(-1.0F, 9.5F, -1.0F);
		this.deco1.setTextureSize(64, 32);
		this.deco1.mirror = true;
		this.setRotation(this.deco1, 0.0F, 0.0F, 0.0F);
		this.deco2 = new ModelRenderer(this, 10, 15);
		this.deco2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.deco2.setRotationPoint(-0.5F, 9.0F, -0.5F);
		this.deco2.setTextureSize(64, 32);
		this.deco2.mirror = true;
		this.setRotation(this.deco2, 0.0F, 0.0F, 0.0F);
		this.spindelBottom4 = new ModelRenderer(this, 0, 8);
		this.spindelBottom4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
		this.spindelBottom4.setRotationPoint(0.0F, 18.0F, 0.5F);
		this.spindelBottom4.setTextureSize(64, 32);
		this.spindelBottom4.mirror = true;
		this.setRotation(this.spindelBottom4, 0.0F, -(float) Math.PI, -0.4363323F);
		this.spindelBottom3 = new ModelRenderer(this, 0, 0);
		this.spindelBottom3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
		this.spindelBottom3.setRotationPoint(-0.5F, 18.0F, 0.0F);
		this.spindelBottom3.setTextureSize(64, 32);
		this.spindelBottom3.mirror = true;
		this.setRotation(this.spindelBottom3, 0.4363323F, 0.0F, 0.0F);
		this.spindelBottom1 = new ModelRenderer(this, 0, 0);
		this.spindelBottom1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
		this.spindelBottom1.setRotationPoint(0.5F, 18.0F, 0.0F);
		this.spindelBottom1.setTextureSize(64, 32);
		this.spindelBottom1.mirror = true;
		this.setRotation(this.spindelBottom1, 0.4363323F, -(float) Math.PI, 0.0F);
		this.spindelBottom2 = new ModelRenderer(this, 0, 8);
		this.spindelBottom2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
		this.spindelBottom2.setRotationPoint(0.0F, 18.0F, -0.5F);
		this.spindelBottom2.setTextureSize(64, 32);
		this.spindelBottom2.mirror = true;
		this.setRotation(this.spindelBottom2, 0.0F, 0.0F, -0.4363323F);
		this.spindelTop1 = new ModelRenderer(this, 0, 0);
		this.spindelTop1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
		this.spindelTop1.setRotationPoint(0.5F, 14.0F, 0.0F);
		this.spindelTop1.setTextureSize(64, 32);
		this.spindelTop1.mirror = true;
		this.setRotation(this.spindelTop1, 0.4363323F, -(float) Math.PI, 0.0F);
		this.spindelTop4 = new ModelRenderer(this, 0, 8);
		this.spindelTop4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
		this.spindelTop4.setRotationPoint(0.0F, 14.0F, 0.5F);
		this.spindelTop4.setTextureSize(64, 32);
		this.spindelTop4.mirror = true;
		this.setRotation(this.spindelTop4, 0.0F, -(float) Math.PI, -0.4363323F);
		this.spindelTop3 = new ModelRenderer(this, 0, 0);
		this.spindelTop3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
		this.spindelTop3.setRotationPoint(-0.5F, 14.0F, 0.0F);
		this.spindelTop3.setTextureSize(64, 32);
		this.spindelTop3.mirror = true;
		this.setRotation(this.spindelTop3, 0.4363323F, 0.0F, 0.0F);
		this.spindelTop2 = new ModelRenderer(this, 0, 8);
		this.spindelTop2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
		this.spindelTop2.setRotationPoint(0.0F, 14.0F, -0.5F);
		this.spindelTop2.setTextureSize(64, 32);
		this.spindelTop2.mirror = true;
		this.setRotation(this.spindelTop2, 0.0F, 0.0F, -0.4363323F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.pole.render(f5);
		this.deco1.render(f5);
		this.deco2.render(f5);
		this.spindelBottom4.render(f5);
		this.spindelBottom3.render(f5);
		this.spindelBottom1.render(f5);
		this.spindelBottom2.render(f5);
		this.spindelTop1.render(f5);
		this.spindelTop4.render(f5);
		this.spindelTop3.render(f5);
		this.spindelTop2.render(f5);
	}

	public void renderModel(float f5) {
		this.pole.render(f5);
		this.deco1.render(f5);
		this.deco2.render(f5);
		this.spindelBottom4.render(f5);
		this.spindelBottom3.render(f5);
		this.spindelBottom1.render(f5);
		this.spindelBottom2.render(f5);
		this.spindelTop1.render(f5);
		this.spindelTop4.render(f5);
		this.spindelTop3.render(f5);
		this.spindelTop2.render(f5);
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
