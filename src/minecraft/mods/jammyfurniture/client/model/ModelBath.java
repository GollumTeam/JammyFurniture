package mods.jammyfurniture.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBath extends ModelBase {
	ModelRenderer topSide6;
	ModelRenderer topSide7;
	ModelRenderer topSide2;
	ModelRenderer topSide1;
	ModelRenderer topSide4;
	ModelRenderer topSide5;
	ModelRenderer topSide3;
	ModelRenderer bottomSide1;
	ModelRenderer bottomSide2;
	ModelRenderer bottomSide3;
	ModelRenderer bottomBase;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer tap2p2;
	ModelRenderer tap2p1;
	ModelRenderer tap1p1;
	ModelRenderer tap1p2;
	ModelRenderer waterbig;
	ModelRenderer watersmall;

	public ModelBath() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.topSide6 = new ModelRenderer(this, 0, 39);
		this.topSide6.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
		this.topSide6.setRotationPoint(-5.5F, 10.0F, 5.0F);
		this.topSide6.setTextureSize(128, 128);
		this.topSide6.mirror = true;
		this.setRotation(this.topSide6, 0.0F, 0.0F, 0.0F);
		this.topSide7 = new ModelRenderer(this, 35, 0);
		this.topSide7.addBox(0.0F, 0.0F, 0.0F, 13, 10, 1);
		this.topSide7.setRotationPoint(-5.0F, 11.0F, 5.0F);
		this.topSide7.setTextureSize(128, 128);
		this.topSide7.mirror = true;
		this.setRotation(this.topSide7, 0.0F, 0.0F, 0.0F);
		this.topSide2 = new ModelRenderer(this, 0, 39);
		this.topSide2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
		this.topSide2.setRotationPoint(-5.5F, 10.0F, -6.0F);
		this.topSide2.setTextureSize(128, 128);
		this.topSide2.mirror = true;
		this.setRotation(this.topSide2, 0.0F, 0.0F, 0.0F);
		this.topSide1 = new ModelRenderer(this, 35, 0);
		this.topSide1.addBox(0.0F, 0.0F, 0.0F, 13, 10, 1);
		this.topSide1.setRotationPoint(-5.0F, 11.0F, -6.0F);
		this.topSide1.setTextureSize(128, 128);
		this.topSide1.mirror = true;
		this.setRotation(this.topSide1, 0.0F, 0.0F, 0.0F);
		this.topSide4 = new ModelRenderer(this, 10, 41);
		this.topSide4.addBox(0.0F, 0.0F, 0.0F, 1, 13, 8);
		this.topSide4.setRotationPoint(-7.0F, 8.0F, -4.0F);
		this.topSide4.setTextureSize(128, 128);
		this.topSide4.mirror = true;
		this.setRotation(this.topSide4, 0.0F, 0.0F, 0.0F);
		this.topSide5 = new ModelRenderer(this, 22, 6);
		this.topSide5.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2);
		this.topSide5.setRotationPoint(-6.0F, 9.0F, 3.0F);
		this.topSide5.setTextureSize(128, 128);
		this.topSide5.mirror = true;
		this.setRotation(this.topSide5, 0.0F, 0.0F, 0.0F);
		this.topSide3 = new ModelRenderer(this, 22, 6);
		this.topSide3.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2);
		this.topSide3.setRotationPoint(-6.0F, 9.0F, -5.0F);
		this.topSide3.setTextureSize(128, 128);
		this.topSide3.mirror = true;
		this.setRotation(this.topSide3, 0.0F, 0.0F, 0.0F);
		this.bottomSide1 = new ModelRenderer(this, 0, 13);
		this.bottomSide1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
		this.bottomSide1.setRotationPoint(-6.0F, 21.0F, -4.0F);
		this.bottomSide1.setTextureSize(128, 128);
		this.bottomSide1.mirror = true;
		this.setRotation(this.bottomSide1, 0.0F, 0.0F, 0.0F);
		this.bottomSide2 = new ModelRenderer(this, 19, 22);
		this.bottomSide2.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.bottomSide2.setRotationPoint(-5.0F, 21.0F, -5.0F);
		this.bottomSide2.setTextureSize(128, 128);
		this.bottomSide2.mirror = true;
		this.setRotation(this.bottomSide2, 0.0F, 0.0F, 0.0F);
		this.bottomSide3 = new ModelRenderer(this, 19, 22);
		this.bottomSide3.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.bottomSide3.setRotationPoint(-5.0F, 21.0F, 4.0F);
		this.bottomSide3.setTextureSize(128, 128);
		this.bottomSide3.mirror = true;
		this.setRotation(this.bottomSide3, 0.0F, 0.0F, 0.0F);
		this.bottomBase = new ModelRenderer(this, 0, 27);
		this.bottomBase.addBox(0.0F, 0.0F, 0.0F, 13, 1, 8);
		this.bottomBase.setRotationPoint(-5.0F, 22.0F, -4.0F);
		this.bottomBase.setTextureSize(128, 128);
		this.bottomBase.mirror = true;
		this.setRotation(this.bottomBase, 0.0F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.leg1.setRotationPoint(-2.0F, 21.5F, 4.0F);
		this.leg1.setTextureSize(128, 128);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.5204921F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.leg2.setRotationPoint(-2.0F, 21.0F, -5.0F);
		this.leg2.setTextureSize(128, 128);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, -0.5205006F, 0.0F, 0.0F);
		this.tap2p2 = new ModelRenderer(this, 6, 6);
		this.tap2p2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.tap2p2.setRotationPoint(8.5F, 8.0F, 3.0F);
		this.tap2p2.setTextureSize(128, 128);
		this.tap2p2.mirror = true;
		this.setRotation(this.tap2p2, 0.0F, 0.0F, 0.0F);
		this.tap2p1 = new ModelRenderer(this, 0, 6);
		this.tap2p1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.tap2p1.setRotationPoint(8.5F, 7.0F, 5.0F);
		this.tap2p1.setTextureSize(128, 128);
		this.tap2p1.mirror = true;
		this.setRotation(this.tap2p1, 0.0F, 0.0F, 0.0F);
		this.tap1p1 = new ModelRenderer(this, 0, 6);
		this.tap1p1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.tap1p1.setRotationPoint(6.5F, 7.0F, 5.0F);
		this.tap1p1.setTextureSize(128, 128);
		this.tap1p1.mirror = true;
		this.setRotation(this.tap1p1, 0.0F, 0.0F, 0.0F);
		this.tap1p2 = new ModelRenderer(this, 6, 6);
		this.tap1p2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.tap1p2.setRotationPoint(6.5F, 8.0F, 3.0F);
		this.tap1p2.setTextureSize(128, 128);
		this.tap1p2.mirror = true;
		this.setRotation(this.tap1p2, 0.0F, 0.0F, 0.0F);
		this.waterbig = new ModelRenderer(this, 31, 48);
		this.waterbig.addBox(0.0F, 0.0F, 0.0F, 13, 1, 10);
		this.waterbig.setRotationPoint(-5.0F, 18.0F, -5.0F);
		this.waterbig.setTextureSize(128, 128);
		this.waterbig.mirror = true;
		this.setRotation(this.waterbig, 0.0F, 0.0F, 0.0F);
		this.watersmall = new ModelRenderer(this, 42, 50);
		this.watersmall.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
		this.watersmall.setRotationPoint(-6.0F, 18.0F, -3.0F);
		this.watersmall.setTextureSize(128, 128);
		this.watersmall.mirror = true;
		this.setRotation(this.watersmall, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.topSide6.render(f5);
		this.topSide7.render(f5);
		this.topSide2.render(f5);
		this.topSide1.render(f5);
		this.topSide4.render(f5);
		this.topSide5.render(f5);
		this.topSide3.render(f5);
		this.bottomSide1.render(f5);
		this.bottomSide2.render(f5);
		this.bottomSide3.render(f5);
		this.bottomBase.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.tap2p2.render(f5);
		this.tap2p1.render(f5);
		this.tap1p1.render(f5);
		this.tap1p2.render(f5);
		this.waterbig.render(f5);
		this.watersmall.render(f5);
	}

	public void renderModelLeft(float f5) {
		this.topSide6.render(f5);
		this.topSide7.render(f5);
		this.topSide2.render(f5);
		this.topSide1.render(f5);
		this.topSide4.render(f5);
		this.topSide5.render(f5);
		this.topSide3.render(f5);
		this.bottomSide1.render(f5);
		this.bottomSide2.render(f5);
		this.bottomSide3.render(f5);
		this.bottomBase.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.tap2p2.render(f5);
		this.tap2p1.render(f5);
		this.tap1p1.render(f5);
		this.tap1p2.render(f5);
		this.waterbig.render(f5);
		this.watersmall.render(f5);
	}

	public void renderModelRight(float f5) {
		this.topSide6.render(f5);
		this.topSide7.render(f5);
		this.topSide2.render(f5);
		this.topSide1.render(f5);
		this.topSide4.render(f5);
		this.topSide5.render(f5);
		this.topSide3.render(f5);
		this.bottomSide1.render(f5);
		this.bottomSide2.render(f5);
		this.bottomSide3.render(f5);
		this.bottomBase.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.waterbig.render(f5);
		this.watersmall.render(f5);
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
