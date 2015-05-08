package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChair extends ModelBase implements JFIModel {
	
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer chairBottom;
	ModelRenderer chairBack;

	public ModelChair() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.leg1.setRotationPoint(-5.0F, 18.0F, 4.0F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 5, 0);
		this.leg2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.leg2.setRotationPoint(-5.0F, 18.0F, -5.0F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 10, 0);
		this.leg3.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.leg3.setRotationPoint(4.0F, 18.0F, 4.0F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 15, 0);
		this.leg4.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.leg4.setRotationPoint(4.0F, 18.0F, -5.0F);
		this.leg4.setTextureSize(64, 32);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
		this.chairBottom = new ModelRenderer(this, 0, 8);
		this.chairBottom.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
		this.chairBottom.setRotationPoint(-5.0F, 17.0F, -5.0F);
		this.chairBottom.setTextureSize(64, 32);
		this.chairBottom.mirror = true;
		this.setRotation(this.chairBottom, 0.0F, 0.0F, 0.0F);
		this.chairBack = new ModelRenderer(this, 0, 20);
		this.chairBack.addBox(0.0F, 0.0F, 0.0F, 10, 9, 1);
		this.chairBack.setRotationPoint(-5.0F, 8.0F, 4.0F);
		this.chairBack.setTextureSize(64, 32);
		this.chairBack.mirror = true;
		this.setRotation(this.chairBack, 0.0F, 0.0F, 0.0F);
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
		this.chairBottom.render(f5);
		this.chairBack.render(f5);
	}

	public void renderModel(float f1) {
		this.leg1.render(f1);
		this.leg2.render(f1);
		this.leg3.render(f1);
		this.leg4.render(f1);
		this.chairBottom.render(f1);
		this.chairBack.render(f1);
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
