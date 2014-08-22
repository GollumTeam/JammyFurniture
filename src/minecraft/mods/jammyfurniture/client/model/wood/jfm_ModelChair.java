package mods.jammyfurniture.client.model.wood;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelChair extends ModelBase {
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer ChairBottom;
	ModelRenderer ChairBack;

	public jfm_ModelChair() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Leg1 = new ModelRenderer(this, 0, 0);
		this.Leg1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Leg1.setRotationPoint(-5.0F, 18.0F, 4.0F);
		this.Leg1.setTextureSize(64, 32);
		this.Leg1.mirror = true;
		this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
		this.Leg2 = new ModelRenderer(this, 5, 0);
		this.Leg2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Leg2.setRotationPoint(-5.0F, 18.0F, -5.0F);
		this.Leg2.setTextureSize(64, 32);
		this.Leg2.mirror = true;
		this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
		this.Leg3 = new ModelRenderer(this, 10, 0);
		this.Leg3.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Leg3.setRotationPoint(4.0F, 18.0F, 4.0F);
		this.Leg3.setTextureSize(64, 32);
		this.Leg3.mirror = true;
		this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
		this.Leg4 = new ModelRenderer(this, 15, 0);
		this.Leg4.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Leg4.setRotationPoint(4.0F, 18.0F, -5.0F);
		this.Leg4.setTextureSize(64, 32);
		this.Leg4.mirror = true;
		this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
		this.ChairBottom = new ModelRenderer(this, 0, 8);
		this.ChairBottom.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.ChairBottom.setRotationPoint(-5.0F, 17.0F, -5.0F);
		this.ChairBottom.setTextureSize(64, 32);
		this.ChairBottom.mirror = true;
		this.setRotation(this.ChairBottom, 0.0F, 0.0F, 0.0F);
		this.ChairBack = new ModelRenderer(this, 0, 20);
		this.ChairBack.addBox(0.0F, 0.0F, 0.0F, 10, 9, 1);
		this.ChairBack.setRotationPoint(-5.0F, 8.0F, 4.0F);
		this.ChairBack.setTextureSize(64, 32);
		this.ChairBack.mirror = true;
		this.setRotation(this.ChairBack, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Leg1.render(f5);
		this.Leg2.render(f5);
		this.Leg3.render(f5);
		this.Leg4.render(f5);
		this.ChairBottom.render(f5);
		this.ChairBack.render(f5);
	}

	public void renderModel(float f1) {
		this.Leg1.render(f1);
		this.Leg2.render(f1);
		this.Leg3.render(f1);
		this.Leg4.render(f1);
		this.ChairBottom.render(f1);
		this.ChairBack.render(f1);
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
