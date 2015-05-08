package mods.jammyfurniture.client.model.lights;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTableLamp extends ModelBase implements JFIModel {
	
	ModelRenderer base;
	ModelRenderer baseProp;
	ModelRenderer shadeSide1;
	ModelRenderer shadeSide2;
	ModelRenderer shadeSide3;
	ModelRenderer shadeSide4;
	ModelRenderer bulb;

	public ModelTableLamp() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.base = new ModelRenderer(this, 1, 9);
		this.base.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
		this.base.setRotationPoint(-3.0F, 23.0F, -3.0F);
		this.base.setTextureSize(64, 64);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		this.baseProp = new ModelRenderer(this, 1, 1);
		this.baseProp.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
		this.baseProp.setRotationPoint(-1.0F, 18.0F, -1.0F);
		this.baseProp.setTextureSize(64, 64);
		this.baseProp.mirror = true;
		this.setRotation(this.baseProp, 0.0F, 0.0F, 0.0F);
		this.shadeSide1 = new ModelRenderer(this, 26, 2);
		this.shadeSide1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 6);
		this.shadeSide1.setRotationPoint(-3.0F, 10.0F, -3.0F);
		this.shadeSide1.setTextureSize(64, 64);
		this.shadeSide1.mirror = true;
		this.setRotation(this.shadeSide1, 0.0F, 0.0F, 0.0F);
		this.shadeSide2 = new ModelRenderer(this, 2, 17);
		this.shadeSide2.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
		this.shadeSide2.setRotationPoint(-2.0F, 10.0F, 2.0F);
		this.shadeSide2.setTextureSize(64, 64);
		this.shadeSide2.mirror = true;
		this.setRotation(this.shadeSide2, 0.0F, 0.0F, 0.0F);
		this.shadeSide3 = new ModelRenderer(this, 13, 18);
		this.shadeSide3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 6);
		this.shadeSide3.setRotationPoint(2.0F, 10.0F, -3.0F);
		this.shadeSide3.setTextureSize(64, 64);
		this.shadeSide3.mirror = true;
		this.setRotation(this.shadeSide3, 0.0F, 0.0F, 0.0F);
		this.shadeSide4 = new ModelRenderer(this, 28, 19);
		this.shadeSide4.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
		this.shadeSide4.setRotationPoint(-2.0F, 10.0F, -3.0F);
		this.shadeSide4.setTextureSize(64, 64);
		this.shadeSide4.mirror = true;
		this.setRotation(this.shadeSide4, 0.0F, 0.0F, 0.0F);
		this.bulb = new ModelRenderer(this, 10, 2);
		this.bulb.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
		this.bulb.setRotationPoint(-1.0F, 14.0F, -1.0F);
		this.bulb.setTextureSize(64, 64);
		this.bulb.mirror = true;
		this.setRotation(this.bulb, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.base.render(f5);
		this.baseProp.render(f5);
		this.shadeSide1.render(f5);
		this.shadeSide2.render(f5);
		this.shadeSide3.render(f5);
		this.shadeSide4.render(f5);
		this.bulb.render(f5);
	}

	public void renderModel(float f5) {
		this.base.render(f5);
		this.baseProp.render(f5);
		this.shadeSide1.render(f5);
		this.shadeSide2.render(f5);
		this.shadeSide3.render(f5);
		this.shadeSide4.render(f5);
		this.bulb.render(f5);
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
