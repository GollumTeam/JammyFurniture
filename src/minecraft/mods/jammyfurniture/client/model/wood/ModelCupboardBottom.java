package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCupboardBottom extends ModelBase implements JFIModel {
	
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer base;
	ModelRenderer base2;

	public ModelCupboardBottom() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.leg1 = new ModelRenderer(this, 0, 105);
		this.leg1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.leg1.setRotationPoint(-7.0F, 16.0F, -7.0F);
		this.leg1.setTextureSize(128, 128);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 105);
		this.leg2.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.leg2.setRotationPoint(6.0F, 16.0F, -7.0F);
		this.leg2.setTextureSize(128, 128);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 0, 105);
		this.leg3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.leg3.setRotationPoint(6.0F, 16.0F, 6.0F);
		this.leg3.setTextureSize(128, 128);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 0, 105);
		this.leg4.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.leg4.setRotationPoint(-7.0F, 16.0F, 6.0F);
		this.leg4.setTextureSize(128, 128);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
		this.base = new ModelRenderer(this, 0, 84);
		this.base.addBox(0.0F, 0.0F, 0.0F, 14, 4, 14);
		this.base.setRotationPoint(-7.0F, 12.0F, -7.0F);
		this.base.setTextureSize(128, 128);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		this.base2 = new ModelRenderer(this, 0, 60);
		this.base2.addBox(0.0F, 0.0F, 0.0F, 14, 4, 13);
		this.base2.setRotationPoint(-7.0F, 8.0F, -6.0F);
		this.base2.setTextureSize(128, 128);
		this.base2.mirror = true;
		this.setRotation(this.base2, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.base.render(f5);
		this.base2.render(f5);
	}

	public void renderModel(float f5) {
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.base.render(f5);
		this.base2.render(f5);
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
