package mods.jammyfurniture.client.model.ceramic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelToilet extends ModelBase {
	ModelRenderer BowlBase2;
	ModelRenderer Base;
	ModelRenderer BowlBase1;
	ModelRenderer SideLeft;
	ModelRenderer SideRight;
	ModelRenderer BackBase;
	ModelRenderer SideFront;
	ModelRenderer Handle;

	public jfm_ModelToilet() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.BowlBase2 = new ModelRenderer(this, 1, 34);
		this.BowlBase2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 10);
		this.BowlBase2.setRotationPoint(-4.0F, 17.0F, -7.0F);
		this.BowlBase2.setTextureSize(64, 64);
		this.BowlBase2.mirror = true;
		this.setRotation(this.BowlBase2, 0.0F, 0.0F, 0.0F);
		this.Base = new ModelRenderer(this, 30, 47);
		this.Base.addBox(0.0F, 0.0F, 0.0F, 4, 6, 10);
		this.Base.setRotationPoint(-2.0F, 18.0F, -3.0F);
		this.Base.setTextureSize(64, 64);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
		this.BowlBase1 = new ModelRenderer(this, 1, 10);
		this.BowlBase1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 8);
		this.BowlBase1.setRotationPoint(-3.0F, 18.0F, -5.0F);
		this.BowlBase1.setTextureSize(64, 64);
		this.BowlBase1.mirror = true;
		this.setRotation(this.BowlBase1, 0.0F, 0.0F, 0.0F);
		this.SideLeft = new ModelRenderer(this, 1, 20);
		this.SideLeft.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
		this.SideLeft.setRotationPoint(-4.0F, 15.0F, -7.0F);
		this.SideLeft.setTextureSize(64, 64);
		this.SideLeft.mirror = true;
		this.setRotation(this.SideLeft, 0.0F, 0.0F, 0.0F);
		this.SideRight = new ModelRenderer(this, 24, 20);
		this.SideRight.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
		this.SideRight.setRotationPoint(3.0F, 15.0F, -7.0F);
		this.SideRight.setTextureSize(64, 64);
		this.SideRight.mirror = true;
		this.setRotation(this.SideRight, 0.0F, 0.0F, 0.0F);
		this.BackBase = new ModelRenderer(this, 1, 49);
		this.BackBase.addBox(0.0F, 0.0F, 0.0F, 10, 10, 4);
		this.BackBase.setRotationPoint(-5.0F, 8.0F, 3.0F);
		this.BackBase.setTextureSize(64, 64);
		this.BackBase.mirror = true;
		this.setRotation(this.BackBase, 0.0F, 0.0F, 0.0F);
		this.SideFront = new ModelRenderer(this, 1, 6);
		this.SideFront.addBox(0.0F, 0.0F, 0.0F, 6, 2, 1);
		this.SideFront.setRotationPoint(-3.0F, 15.0F, -7.0F);
		this.SideFront.setTextureSize(64, 64);
		this.SideFront.mirror = true;
		this.setRotation(this.SideFront, 0.0F, 0.0F, 0.0F);
		this.Handle = new ModelRenderer(this, 1, 3);
		this.Handle.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.Handle.setRotationPoint(3.0F, 9.0F, 2.0F);
		this.Handle.setTextureSize(64, 64);
		this.Handle.mirror = true;
		this.setRotation(this.Handle, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BowlBase2.render(f5);
		this.Base.render(f5);
		this.BowlBase1.render(f5);
		this.SideLeft.render(f5);
		this.SideRight.render(f5);
		this.BackBase.render(f5);
		this.SideFront.render(f5);
		this.Handle.render(f5);
	}

	public void renderModel(float f5) {
		this.BowlBase2.render(f5);
		this.Base.render(f5);
		this.BowlBase1.render(f5);
		this.SideLeft.render(f5);
		this.SideRight.render(f5);
		this.BackBase.render(f5);
		this.SideFront.render(f5);
		this.Handle.render(f5);
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
