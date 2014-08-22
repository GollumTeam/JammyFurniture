package mods.jammyfurniture.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelChimney extends ModelBase {
	ModelRenderer ChimneyBase;
	ModelRenderer ChimneyMid;
	ModelRenderer ChimneyMid3;
	ModelRenderer ChimneyMid2;
	ModelRenderer ChimneyTop1;
	ModelRenderer ChimneyTop2;
	ModelRenderer ChimneyTop3;
	ModelRenderer ChimneyTop4;

	public jfm_ModelChimney() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.ChimneyBase = new ModelRenderer(this, 0, 0);
		this.ChimneyBase.addBox(0.0F, 0.0F, 0.0F, 16, 11, 16);
		this.ChimneyBase.setRotationPoint(-8.0F, 13.0F, -8.0F);
		this.ChimneyBase.setTextureSize(128, 128);
		this.ChimneyBase.mirror = true;
		this.setRotation(this.ChimneyBase, 0.0F, 0.0F, 0.0F);
		this.ChimneyMid = new ModelRenderer(this, 0, 30);
		this.ChimneyMid.addBox(0.0F, 0.0F, 0.0F, 18, 3, 18);
		this.ChimneyMid.setRotationPoint(-9.0F, 10.0F, -9.0F);
		this.ChimneyMid.setTextureSize(128, 128);
		this.ChimneyMid.mirror = true;
		this.setRotation(this.ChimneyMid, 0.0F, 0.0F, 0.0F);
		this.ChimneyMid3 = new ModelRenderer(this, 0, 74);
		this.ChimneyMid3.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14);
		this.ChimneyMid3.setRotationPoint(-7.0F, 8.0F, -7.0F);
		this.ChimneyMid3.setTextureSize(128, 128);
		this.ChimneyMid3.mirror = true;
		this.setRotation(this.ChimneyMid3, 0.0F, 0.0F, 0.0F);
		this.ChimneyMid2 = new ModelRenderer(this, 0, 54);
		this.ChimneyMid2.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
		this.ChimneyMid2.setRotationPoint(-8.0F, 9.0F, -8.0F);
		this.ChimneyMid2.setTextureSize(128, 128);
		this.ChimneyMid2.mirror = true;
		this.setRotation(this.ChimneyMid2, 0.0F, 0.0F, 0.0F);
		this.ChimneyTop1 = new ModelRenderer(this, 67, 0);
		this.ChimneyTop1.addBox(0.0F, 0.0F, 0.0F, 4, 7, 1);
		this.ChimneyTop1.setRotationPoint(-2.5F, 1.0F, 1.5F);
		this.ChimneyTop1.setTextureSize(128, 128);
		this.ChimneyTop1.mirror = true;
		this.setRotation(this.ChimneyTop1, 0.0F, 0.0F, 0.0F);
		this.ChimneyTop2 = new ModelRenderer(this, 67, 0);
		this.ChimneyTop2.addBox(0.0F, 0.0F, 0.0F, 4, 7, 1);
		this.ChimneyTop2.setRotationPoint(-2.5F, 1.0F, -2.5F);
		this.ChimneyTop2.setTextureSize(128, 128);
		this.ChimneyTop2.mirror = true;
		this.setRotation(this.ChimneyTop2, 0.0F, 0.0F, 0.0F);
		this.ChimneyTop3 = new ModelRenderer(this, 67, 10);
		this.ChimneyTop3.addBox(0.0F, 0.0F, 0.0F, 1, 7, 3);
		this.ChimneyTop3.setRotationPoint(-2.5F, 1.0F, -1.5F);
		this.ChimneyTop3.setTextureSize(128, 128);
		this.ChimneyTop3.mirror = true;
		this.setRotation(this.ChimneyTop3, 0.0F, 0.0F, 0.0F);
		this.ChimneyTop4 = new ModelRenderer(this, 80, 0);
		this.ChimneyTop4.addBox(0.0F, 0.0F, 0.0F, 1, 7, 5);
		this.ChimneyTop4.setRotationPoint(1.5F, 1.0F, -2.5F);
		this.ChimneyTop4.setTextureSize(128, 128);
		this.ChimneyTop4.mirror = true;
		this.setRotation(this.ChimneyTop4, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.ChimneyBase.render(f5);
		this.ChimneyMid.render(f5);
		this.ChimneyMid3.render(f5);
		this.ChimneyMid2.render(f5);
		this.ChimneyTop1.render(f5);
		this.ChimneyTop2.render(f5);
		this.ChimneyTop3.render(f5);
		this.ChimneyTop4.render(f5);
	}

	public void renderModel(float f5) {
		this.ChimneyBase.render(f5);
		this.ChimneyMid.render(f5);
		this.ChimneyMid3.render(f5);
		this.ChimneyMid2.render(f5);
		this.ChimneyTop1.render(f5);
		this.ChimneyTop2.render(f5);
		this.ChimneyTop3.render(f5);
		this.ChimneyTop4.render(f5);
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
