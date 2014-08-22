package mods.jammyfurniture.client.model.lights;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelLight extends ModelBase {
	ModelRenderer LightWire;
	ModelRenderer LightBulb;
	ModelRenderer TopBack;
	ModelRenderer TopRight;
	ModelRenderer TopLeft;
	ModelRenderer TopFront;
	ModelRenderer MidRight;
	ModelRenderer MidFront;
	ModelRenderer MidBack;
	ModelRenderer MidLeft;

	public jfm_ModelLight() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.LightWire = new ModelRenderer(this, 0, 0);
		this.LightWire.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
		this.LightWire.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.LightWire.setTextureSize(64, 32);
		this.LightWire.mirror = true;
		this.setRotation(this.LightWire, 0.0F, 0.0F, 0.0F);
		this.LightBulb = new ModelRenderer(this, 6, 0);
		this.LightBulb.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
		this.LightBulb.setRotationPoint(-1.0F, 13.0F, -1.0F);
		this.LightBulb.setTextureSize(64, 32);
		this.LightBulb.mirror = true;
		this.setRotation(this.LightBulb, 0.0F, 0.0F, 0.0F);
		this.TopBack = new ModelRenderer(this, 0, 22);
		this.TopBack.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
		this.TopBack.setRotationPoint(-2.0F, 11.0F, 2.0F);
		this.TopBack.setTextureSize(64, 32);
		this.TopBack.mirror = true;
		this.setRotation(this.TopBack, 0.0F, 0.0F, 0.0F);
		this.TopRight = new ModelRenderer(this, 0, 12);
		this.TopRight.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.TopRight.setRotationPoint(2.0F, 11.0F, -1.0F);
		this.TopRight.setTextureSize(64, 32);
		this.TopRight.mirror = true;
		this.setRotation(this.TopRight, 0.0F, 0.0F, 0.0F);
		this.TopLeft = new ModelRenderer(this, 0, 7);
		this.TopLeft.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.TopLeft.setRotationPoint(-2.0F, 11.0F, -1.0F);
		this.TopLeft.setTextureSize(64, 32);
		this.TopLeft.mirror = true;
		this.setRotation(this.TopLeft, 0.0F, 0.0F, 0.0F);
		this.TopFront = new ModelRenderer(this, 0, 19);
		this.TopFront.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
		this.TopFront.setRotationPoint(-2.0F, 11.0F, -2.0F);
		this.TopFront.setTextureSize(64, 32);
		this.TopFront.mirror = true;
		this.setRotation(this.TopFront, 0.0F, 0.0F, 0.0F);
		this.MidRight = new ModelRenderer(this, 10, 7);
		this.MidRight.addBox(0.0F, 0.0F, 0.0F, 1, 6, 5);
		this.MidRight.setRotationPoint(3.0F, 12.0F, -2.0F);
		this.MidRight.setTextureSize(64, 32);
		this.MidRight.mirror = true;
		this.setRotation(this.MidRight, 0.0F, 0.0F, 0.0F);
		this.MidFront = new ModelRenderer(this, 14, 19);
		this.MidFront.addBox(0.0F, 0.0F, 0.0F, 7, 6, 1);
		this.MidFront.setRotationPoint(-3.0F, 12.0F, -3.0F);
		this.MidFront.setTextureSize(64, 32);
		this.MidFront.mirror = true;
		this.setRotation(this.MidFront, 0.0F, 0.0F, 0.0F);
		this.MidBack = new ModelRenderer(this, 31, 19);
		this.MidBack.addBox(0.0F, 0.0F, 0.0F, 7, 6, 1);
		this.MidBack.setRotationPoint(-3.0F, 12.0F, 3.0F);
		this.MidBack.setTextureSize(64, 32);
		this.MidBack.mirror = true;
		this.setRotation(this.MidBack, 0.0F, 0.0F, 0.0F);
		this.MidLeft = new ModelRenderer(this, 23, 7);
		this.MidLeft.addBox(0.0F, 0.0F, 0.0F, 1, 6, 5);
		this.MidLeft.setRotationPoint(-3.0F, 12.0F, -2.0F);
		this.MidLeft.setTextureSize(64, 32);
		this.MidLeft.mirror = true;
		this.setRotation(this.MidLeft, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.LightWire.render(f5);
		this.LightBulb.render(f5);
		this.TopBack.render(f5);
		this.TopRight.render(f5);
		this.TopLeft.render(f5);
		this.TopFront.render(f5);
		this.MidRight.render(f5);
		this.MidFront.render(f5);
		this.MidBack.render(f5);
		this.MidLeft.render(f5);
	}

	public void renderModel(float f5) {
		this.LightWire.render(f5);
		this.LightBulb.render(f5);
		this.TopBack.render(f5);
		this.TopRight.render(f5);
		this.TopLeft.render(f5);
		this.TopFront.render(f5);
		this.MidRight.render(f5);
		this.MidFront.render(f5);
		this.MidBack.render(f5);
		this.MidLeft.render(f5);
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
