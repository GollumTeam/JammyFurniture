package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStandBase extends ModelBase implements JFIModel {
	
	ModelRenderer pole;
	ModelRenderer leg1;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer leg2;

	public ModelStandBase() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.pole = new ModelRenderer(this, 0, 11);
		this.pole.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
		this.pole.setRotationPoint(-0.5F, 8.0F, -0.5F);
		this.pole.setTextureSize(64, 32);
		this.pole.mirror = true;
		this.setRotation(this.pole, 0.0F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
		this.leg1.setRotationPoint(0.5F, 17.0F, -0.5F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, -0.9599311F, (float) Math.PI, 0.0F);
		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
		this.leg3.setRotationPoint(-0.5F, 17.0F, 0.5F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, -0.9599311F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 6, 13);
		this.leg4.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
		this.leg4.setRotationPoint(-0.5F, 17.0F, 0.5F);
		this.leg4.setTextureSize(64, 32);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0.0F, (float) Math.PI, -0.9599311F);
		this.leg2 = new ModelRenderer(this, 6, 13);
		this.leg2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
		this.leg2.setRotationPoint(0.5F, 17.0F, -0.5F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.9599311F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.pole.render(f5);
		this.leg1.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.leg2.render(f5);
	}

	public void renderModel(float f5) {
		this.pole.render(f5);
		this.leg1.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.leg2.render(f5);
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
