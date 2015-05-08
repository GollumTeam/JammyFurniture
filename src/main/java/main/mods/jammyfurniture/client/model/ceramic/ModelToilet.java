package mods.jammyfurniture.client.model.ceramic;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelToilet extends ModelBase implements JFIModel {
	ModelRenderer bowlBase2;
	ModelRenderer base;
	ModelRenderer bowlBase1;
	ModelRenderer sideLeft;
	ModelRenderer sideRight;
	ModelRenderer backBase;
	ModelRenderer sideFront;
	ModelRenderer handle;

	public ModelToilet() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.bowlBase2 = new ModelRenderer(this, 1, 34);
		this.bowlBase2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 10);
		this.bowlBase2.setRotationPoint(-4.0F, 17.0F, -7.0F);
		this.bowlBase2.setTextureSize(64, 64);
		this.bowlBase2.mirror = true;
		this.setRotation(this.bowlBase2, 0.0F, 0.0F, 0.0F);
		this.base = new ModelRenderer(this, 30, 47);
		this.base.addBox(0.0F, 0.0F, 0.0F, 4, 6, 10);
		this.base.setRotationPoint(-2.0F, 18.0F, -3.0F);
		this.base.setTextureSize(64, 64);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		this.bowlBase1 = new ModelRenderer(this, 1, 10);
		this.bowlBase1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 8);
		this.bowlBase1.setRotationPoint(-3.0F, 18.0F, -5.0F);
		this.bowlBase1.setTextureSize(64, 64);
		this.bowlBase1.mirror = true;
		this.setRotation(this.bowlBase1, 0.0F, 0.0F, 0.0F);
		this.sideLeft = new ModelRenderer(this, 1, 20);
		this.sideLeft.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
		this.sideLeft.setRotationPoint(-4.0F, 15.0F, -7.0F);
		this.sideLeft.setTextureSize(64, 64);
		this.sideLeft.mirror = true;
		this.setRotation(this.sideLeft, 0.0F, 0.0F, 0.0F);
		this.sideRight = new ModelRenderer(this, 24, 20);
		this.sideRight.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
		this.sideRight.setRotationPoint(3.0F, 15.0F, -7.0F);
		this.sideRight.setTextureSize(64, 64);
		this.sideRight.mirror = true;
		this.setRotation(this.sideRight, 0.0F, 0.0F, 0.0F);
		this.backBase = new ModelRenderer(this, 1, 49);
		this.backBase.addBox(0.0F, 0.0F, 0.0F, 10, 10, 4);
		this.backBase.setRotationPoint(-5.0F, 8.0F, 3.0F);
		this.backBase.setTextureSize(64, 64);
		this.backBase.mirror = true;
		this.setRotation(this.backBase, 0.0F, 0.0F, 0.0F);
		this.sideFront = new ModelRenderer(this, 1, 6);
		this.sideFront.addBox(0.0F, 0.0F, 0.0F, 6, 2, 1);
		this.sideFront.setRotationPoint(-3.0F, 15.0F, -7.0F);
		this.sideFront.setTextureSize(64, 64);
		this.sideFront.mirror = true;
		this.setRotation(this.sideFront, 0.0F, 0.0F, 0.0F);
		this.handle = new ModelRenderer(this, 1, 3);
		this.handle.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.handle.setRotationPoint(3.0F, 9.0F, 2.0F);
		this.handle.setTextureSize(64, 64);
		this.handle.mirror = true;
		this.setRotation(this.handle, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.bowlBase2.render(f5);
		this.base.render(f5);
		this.bowlBase1.render(f5);
		this.sideLeft.render(f5);
		this.sideRight.render(f5);
		this.backBase.render(f5);
		this.sideFront.render(f5);
		this.handle.render(f5);
	}

	public void renderModel(float f5) {
		this.bowlBase2.render(f5);
		this.base.render(f5);
		this.bowlBase1.render(f5);
		this.sideLeft.render(f5);
		this.sideRight.render(f5);
		this.backBase.render(f5);
		this.sideFront.render(f5);
		this.handle.render(f5);
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
