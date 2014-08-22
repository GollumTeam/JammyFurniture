package mods.jammyfurniture.client.model.wood;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelCupboardTop extends ModelBase {
	ModelRenderer Base3;
	ModelRenderer Door4;
	ModelRenderer Door3;
	ModelRenderer Deco;

	public jfm_ModelCupboardTop() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Base3 = new ModelRenderer(this, 0, 0);
		this.Base3.addBox(0.0F, 0.0F, 0.0F, 14, 15, 13);
		this.Base3.setRotationPoint(-7.0F, 9.0F, -6.0F);
		this.Base3.setTextureSize(128, 128);
		this.Base3.mirror = true;
		this.setRotation(this.Base3, 0.0F, 0.0F, 0.0F);
		this.Door4 = new ModelRenderer(this, 19, 37);
		this.Door4.addBox(-7.0F, 0.0F, -1.0F, 7, 14, 1);
		this.Door4.setRotationPoint(7.0F, 10.0F, -6.0F);
		this.Door4.setTextureSize(128, 128);
		this.Door4.mirror = true;
		this.setRotation(this.Door4, 0.0F, 0.0F, 0.0F);
		this.Door3 = new ModelRenderer(this, 0, 32);
		this.Door3.addBox(0.0F, 0.0F, -1.0F, 7, 14, 1);
		this.Door3.setRotationPoint(-7.0F, 10.0F, -6.0F);
		this.Door3.setTextureSize(128, 128);
		this.Door3.mirror = true;
		this.setRotation(this.Door3, 0.0F, 0.0F, 0.0F);
		this.Deco = new ModelRenderer(this, 20, 34);
		this.Deco.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.Deco.setRotationPoint(-7.0F, 9.0F, -7.0F);
		this.Deco.setTextureSize(128, 128);
		this.Deco.mirror = true;
		this.setRotation(this.Deco, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Base3.render(f5);
		this.Door4.render(f5);
		this.Door3.render(f5);
		this.Deco.render(f5);
	}

	public void renderModel(float f5) {
		this.Base3.render(f5);
		this.Door4.render(f5);
		this.Door3.render(f5);
		this.Deco.render(f5);
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
