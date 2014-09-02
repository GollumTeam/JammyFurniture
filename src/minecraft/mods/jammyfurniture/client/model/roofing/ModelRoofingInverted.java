package mods.jammyfurniture.client.model.roofing;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofingInverted extends ModelBase implements JFIModel {
	ModelRenderer roofP5;
	ModelRenderer roofP1;
	ModelRenderer roofP3;
	ModelRenderer roofP2;
	ModelRenderer roofP4;
	ModelRenderer roofP7;
	ModelRenderer roofP6;

	public ModelRoofingInverted() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.roofP5 = new ModelRenderer(this, 0, 0);
		this.roofP5.addBox(0.0F, 0.0F, 0.0F, 8, 4, 8);
		this.roofP5.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.roofP5.setTextureSize(64, 32);
		this.roofP5.mirror = true;
		this.setRotation(this.roofP5, 0.0F, 0.0F, 0.0F);
		this.roofP1 = new ModelRenderer(this, 0, 0);
		this.roofP1.addBox(0.0F, 0.0F, 0.0F, 16, 4, 16);
		this.roofP1.setRotationPoint(-8.0F, 20.0F, -8.0F);
		this.roofP1.setTextureSize(64, 32);
		this.roofP1.mirror = true;
		this.setRotation(this.roofP1, 0.0F, 0.0F, 0.0F);
		this.roofP3 = new ModelRenderer(this, 0, 0);
		this.roofP3.addBox(0.0F, 0.0F, 0.0F, 4, 4, 12);
		this.roofP3.setRotationPoint(4.0F, 16.0F, -4.0F);
		this.roofP3.setTextureSize(64, 32);
		this.roofP3.mirror = true;
		this.setRotation(this.roofP3, 0.0F, 0.0F, 0.0F);
		this.roofP2 = new ModelRenderer(this, 0, 0);
		this.roofP2.addBox(0.0F, 0.0F, 0.0F, 12, 4, 16);
		this.roofP2.setRotationPoint(-8.0F, 16.0F, -8.0F);
		this.roofP2.setTextureSize(64, 32);
		this.roofP2.mirror = true;
		this.setRotation(this.roofP2, 0.0F, 0.0F, 0.0F);
		this.roofP4 = new ModelRenderer(this, 0, 0);
		this.roofP4.addBox(0.0F, 0.0F, 0.0F, 8, 4, 16);
		this.roofP4.setRotationPoint(-8.0F, 12.0F, -8.0F);
		this.roofP4.setTextureSize(64, 32);
		this.roofP4.mirror = true;
		this.setRotation(this.roofP4, 0.0F, 0.0F, 0.0F);
		this.roofP7 = new ModelRenderer(this, 0, 0);
		this.roofP7.addBox(0.0F, 0.0F, 0.0F, 12, 4, 4);
		this.roofP7.setRotationPoint(-4.0F, 8.0F, 4.0F);
		this.roofP7.setTextureSize(64, 32);
		this.roofP7.mirror = true;
		this.setRotation(this.roofP7, 0.0F, 0.0F, 0.0F);
		this.roofP6 = new ModelRenderer(this, 0, 0);
		this.roofP6.addBox(0.0F, 0.0F, 0.0F, 4, 4, 16);
		this.roofP6.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.roofP6.setTextureSize(64, 32);
		this.roofP6.mirror = true;
		this.setRotation(this.roofP6, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.roofP5.render(f5);
		this.roofP1.render(f5);
		this.roofP3.render(f5);
		this.roofP2.render(f5);
		this.roofP4.render(f5);
		this.roofP7.render(f5);
		this.roofP6.render(f5);
	}

	public void renderModel(float f5) {
		this.roofP5.render(f5);
		this.roofP1.render(f5);
		this.roofP3.render(f5);
		this.roofP2.render(f5);
		this.roofP4.render(f5);
		this.roofP7.render(f5);
		this.roofP6.render(f5);
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
