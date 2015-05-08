package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBasket extends ModelBase implements JFIModel {
	
	ModelRenderer sideFront;
	ModelRenderer sideRight;
	ModelRenderer sideLeft;
	ModelRenderer base;
	ModelRenderer sideBack;

	public ModelBasket() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.sideFront = new ModelRenderer(this, 11, 38);
		this.sideFront.addBox(0.0F, 0.0F, 0.0F, 14, 6, 1);
		this.sideFront.setRotationPoint(-7.0F, 18.0F, -7.0F);
		this.sideFront.setTextureSize(64, 64);
		this.sideFront.mirror = true;
		this.setRotation(this.sideFront, 0.0F, 0.0F, 0.0F);
		this.sideRight = new ModelRenderer(this, 0, 0);
		this.sideRight.addBox(0.0F, 0.0F, 0.0F, 1, 6, 12);
		this.sideRight.setRotationPoint(6.0F, 18.0F, -6.0F);
		this.sideRight.setTextureSize(64, 64);
		this.sideRight.mirror = true;
		this.setRotation(this.sideRight, 0.0F, 0.0F, 0.0F);
		this.sideLeft = new ModelRenderer(this, 0, 0);
		this.sideLeft.addBox(0.0F, 0.0F, 0.0F, 1, 6, 12);
		this.sideLeft.setRotationPoint(-7.0F, 18.0F, -6.0F);
		this.sideLeft.setTextureSize(64, 64);
		this.sideLeft.mirror = true;
		this.setRotation(this.sideLeft, 0.0F, 0.0F, 0.0F);
		this.base = new ModelRenderer(this, 0, 48);
		this.base.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12);
		this.base.setRotationPoint(-6.0F, 22.0F, -6.0F);
		this.base.setTextureSize(64, 64);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		this.sideBack = new ModelRenderer(this, 11, 38);
		this.sideBack.addBox(0.0F, 0.0F, 0.0F, 14, 6, 1);
		this.sideBack.setRotationPoint(-7.0F, 18.0F, 6.0F);
		this.sideBack.setTextureSize(64, 64);
		this.sideBack.mirror = true;
		this.setRotation(this.sideBack, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.sideFront.render(f5);
		this.sideRight.render(f5);
		this.sideLeft.render(f5);
		this.base.render(f5);
		this.sideBack.render(f5);
	}

	public void renderModel(float f5) {
		this.sideFront.render(f5);
		this.sideRight.render(f5);
		this.sideLeft.render(f5);
		this.base.render(f5);
		this.sideBack.render(f5);
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
