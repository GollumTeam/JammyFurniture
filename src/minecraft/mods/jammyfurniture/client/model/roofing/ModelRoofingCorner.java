package mods.jammyfurniture.client.model.roofing;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofingCorner extends ModelBase implements JFIModel {
	ModelRenderer roofBottom;
	ModelRenderer roofBottom2;
	ModelRenderer shape1;
	ModelRenderer shape5;
	ModelRenderer shape2;
	ModelRenderer shape3;
	ModelRenderer shape4;

	public ModelRoofingCorner() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.roofBottom = new ModelRenderer(this, 0, 2);
		this.roofBottom.addBox(0.0F, 0.0F, 0.0F, 4, 4, 12);
		this.roofBottom.setRotationPoint(4.0F, 20.0F, -4.0F);
		this.roofBottom.setTextureSize(128, 64);
		this.roofBottom.mirror = true;
		this.setRotation(this.roofBottom, 0.0F, 0.0F, 0.0F);
		this.roofBottom2 = new ModelRenderer(this, 44, 23);
		this.roofBottom2.addBox(0.0F, 0.0F, 0.0F, 16, 4, 4);
		this.roofBottom2.setRotationPoint(-8.0F, 20.0F, -8.0F);
		this.roofBottom2.setTextureSize(128, 64);
		this.roofBottom2.mirror = true;
		this.setRotation(this.roofBottom2, 0.0F, 0.0F, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 4);
		this.shape1.setRotationPoint(-8.0F, 16.0F, -4.0F);
		this.shape1.setTextureSize(128, 64);
		this.shape1.mirror = true;
		this.setRotation(this.shape1, 0.0F, 0.0F, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 0);
		this.shape5.addBox(0.0F, 0.0F, 0.0F, 4, 8, 12);
		this.shape5.setRotationPoint(0.0F, 16.0F, -4.0F);
		this.shape5.setTextureSize(128, 64);
		this.shape5.mirror = true;
		this.setRotation(this.shape5, 0.0F, 0.0F, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 0);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 4, 12, 8);
		this.shape2.setRotationPoint(-4.0F, 12.0F, 0.0F);
		this.shape2.setTextureSize(128, 64);
		this.shape2.mirror = true;
		this.setRotation(this.shape2, 0.0F, 0.0F, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 0);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4);
		this.shape3.setRotationPoint(-8.0F, 12.0F, 0.0F);
		this.shape3.setTextureSize(128, 64);
		this.shape3.mirror = true;
		this.setRotation(this.shape3, 0.0F, 0.0F, 0.0F);
		this.shape4 = new ModelRenderer(this, 0, 0);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4);
		this.shape4.setRotationPoint(-8.0F, 8.0F, 4.0F);
		this.shape4.setTextureSize(128, 64);
		this.shape4.mirror = true;
		this.setRotation(this.shape4, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.roofBottom.render(f5);
		this.roofBottom2.render(f5);
		this.shape1.render(f5);
		this.shape5.render(f5);
		this.shape2.render(f5);
		this.shape3.render(f5);
		this.shape4.render(f5);
	}

	public void renderModel(float f5) {
		this.roofBottom.render(f5);
		this.roofBottom2.render(f5);
		this.shape1.render(f5);
		this.shape5.render(f5);
		this.shape2.render(f5);
		this.shape3.render(f5);
		this.shape4.render(f5);
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
