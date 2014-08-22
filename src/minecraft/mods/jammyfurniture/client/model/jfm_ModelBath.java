package mods.jammyfurniture.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelBath extends ModelBase {
	ModelRenderer TopSide6;
	ModelRenderer TopSide7;
	ModelRenderer TopSide2;
	ModelRenderer TopSide1;
	ModelRenderer TopSide4;
	ModelRenderer TopSide5;
	ModelRenderer TopSide3;
	ModelRenderer BottomSide1;
	ModelRenderer BottomSide2;
	ModelRenderer BottomSide3;
	ModelRenderer BottomBase;
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer tap2p2;
	ModelRenderer tap2p1;
	ModelRenderer tap1p1;
	ModelRenderer Tap1p2;
	ModelRenderer waterbig;
	ModelRenderer watersmall;

	public jfm_ModelBath() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.TopSide6 = new ModelRenderer(this, 0, 39);
		this.TopSide6.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
		this.TopSide6.setRotationPoint(-5.5F, 10.0F, 5.0F);
		this.TopSide6.setTextureSize(128, 128);
		this.TopSide6.mirror = true;
		this.setRotation(this.TopSide6, 0.0F, 0.0F, 0.0F);
		this.TopSide7 = new ModelRenderer(this, 35, 0);
		this.TopSide7.addBox(0.0F, 0.0F, 0.0F, 13, 10, 1);
		this.TopSide7.setRotationPoint(-5.0F, 11.0F, 5.0F);
		this.TopSide7.setTextureSize(128, 128);
		this.TopSide7.mirror = true;
		this.setRotation(this.TopSide7, 0.0F, 0.0F, 0.0F);
		this.TopSide2 = new ModelRenderer(this, 0, 39);
		this.TopSide2.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1);
		this.TopSide2.setRotationPoint(-5.5F, 10.0F, -6.0F);
		this.TopSide2.setTextureSize(128, 128);
		this.TopSide2.mirror = true;
		this.setRotation(this.TopSide2, 0.0F, 0.0F, 0.0F);
		this.TopSide1 = new ModelRenderer(this, 35, 0);
		this.TopSide1.addBox(0.0F, 0.0F, 0.0F, 13, 10, 1);
		this.TopSide1.setRotationPoint(-5.0F, 11.0F, -6.0F);
		this.TopSide1.setTextureSize(128, 128);
		this.TopSide1.mirror = true;
		this.setRotation(this.TopSide1, 0.0F, 0.0F, 0.0F);
		this.TopSide4 = new ModelRenderer(this, 10, 41);
		this.TopSide4.addBox(0.0F, 0.0F, 0.0F, 1, 13, 8);
		this.TopSide4.setRotationPoint(-7.0F, 8.0F, -4.0F);
		this.TopSide4.setTextureSize(128, 128);
		this.TopSide4.mirror = true;
		this.setRotation(this.TopSide4, 0.0F, 0.0F, 0.0F);
		this.TopSide5 = new ModelRenderer(this, 22, 6);
		this.TopSide5.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2);
		this.TopSide5.setRotationPoint(-6.0F, 9.0F, 3.0F);
		this.TopSide5.setTextureSize(128, 128);
		this.TopSide5.mirror = true;
		this.setRotation(this.TopSide5, 0.0F, 0.0F, 0.0F);
		this.TopSide3 = new ModelRenderer(this, 22, 6);
		this.TopSide3.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2);
		this.TopSide3.setRotationPoint(-6.0F, 9.0F, -5.0F);
		this.TopSide3.setTextureSize(128, 128);
		this.TopSide3.mirror = true;
		this.setRotation(this.TopSide3, 0.0F, 0.0F, 0.0F);
		this.BottomSide1 = new ModelRenderer(this, 0, 13);
		this.BottomSide1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 8);
		this.BottomSide1.setRotationPoint(-6.0F, 21.0F, -4.0F);
		this.BottomSide1.setTextureSize(128, 128);
		this.BottomSide1.mirror = true;
		this.setRotation(this.BottomSide1, 0.0F, 0.0F, 0.0F);
		this.BottomSide2 = new ModelRenderer(this, 19, 22);
		this.BottomSide2.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.BottomSide2.setRotationPoint(-5.0F, 21.0F, -5.0F);
		this.BottomSide2.setTextureSize(128, 128);
		this.BottomSide2.mirror = true;
		this.setRotation(this.BottomSide2, 0.0F, 0.0F, 0.0F);
		this.BottomSide3 = new ModelRenderer(this, 19, 22);
		this.BottomSide3.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.BottomSide3.setRotationPoint(-5.0F, 21.0F, 4.0F);
		this.BottomSide3.setTextureSize(128, 128);
		this.BottomSide3.mirror = true;
		this.setRotation(this.BottomSide3, 0.0F, 0.0F, 0.0F);
		this.BottomBase = new ModelRenderer(this, 0, 27);
		this.BottomBase.addBox(0.0F, 0.0F, 0.0F, 13, 1, 8);
		this.BottomBase.setRotationPoint(-5.0F, 22.0F, -4.0F);
		this.BottomBase.setTextureSize(128, 128);
		this.BottomBase.mirror = true;
		this.setRotation(this.BottomBase, 0.0F, 0.0F, 0.0F);
		this.Leg1 = new ModelRenderer(this, 0, 0);
		this.Leg1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.Leg1.setRotationPoint(-2.0F, 21.5F, 4.0F);
		this.Leg1.setTextureSize(128, 128);
		this.Leg1.mirror = true;
		this.setRotation(this.Leg1, 0.5204921F, 0.0F, 0.0F);
		this.Leg2 = new ModelRenderer(this, 0, 0);
		this.Leg2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.Leg2.setRotationPoint(-2.0F, 21.0F, -5.0F);
		this.Leg2.setTextureSize(128, 128);
		this.Leg2.mirror = true;
		this.setRotation(this.Leg2, -0.5205006F, 0.0F, 0.0F);
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
		this.Tap1p2 = new ModelRenderer(this, 6, 6);
		this.Tap1p2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.Tap1p2.setRotationPoint(6.5F, 8.0F, 3.0F);
		this.Tap1p2.setTextureSize(128, 128);
		this.Tap1p2.mirror = true;
		this.setRotation(this.Tap1p2, 0.0F, 0.0F, 0.0F);
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
		this.TopSide6.render(f5);
		this.TopSide7.render(f5);
		this.TopSide2.render(f5);
		this.TopSide1.render(f5);
		this.TopSide4.render(f5);
		this.TopSide5.render(f5);
		this.TopSide3.render(f5);
		this.BottomSide1.render(f5);
		this.BottomSide2.render(f5);
		this.BottomSide3.render(f5);
		this.BottomBase.render(f5);
		this.Leg1.render(f5);
		this.Leg2.render(f5);
		this.tap2p2.render(f5);
		this.tap2p1.render(f5);
		this.tap1p1.render(f5);
		this.Tap1p2.render(f5);
		this.waterbig.render(f5);
		this.watersmall.render(f5);
	}

	public void renderModelLeft(float f5) {
		this.TopSide6.render(f5);
		this.TopSide7.render(f5);
		this.TopSide2.render(f5);
		this.TopSide1.render(f5);
		this.TopSide4.render(f5);
		this.TopSide5.render(f5);
		this.TopSide3.render(f5);
		this.BottomSide1.render(f5);
		this.BottomSide2.render(f5);
		this.BottomSide3.render(f5);
		this.BottomBase.render(f5);
		this.Leg1.render(f5);
		this.Leg2.render(f5);
		this.tap2p2.render(f5);
		this.tap2p1.render(f5);
		this.tap1p1.render(f5);
		this.Tap1p2.render(f5);
		this.waterbig.render(f5);
		this.watersmall.render(f5);
	}

	public void renderModelRight(float f5) {
		this.TopSide6.render(f5);
		this.TopSide7.render(f5);
		this.TopSide2.render(f5);
		this.TopSide1.render(f5);
		this.TopSide4.render(f5);
		this.TopSide5.render(f5);
		this.TopSide3.render(f5);
		this.BottomSide1.render(f5);
		this.BottomSide2.render(f5);
		this.BottomSide3.render(f5);
		this.BottomBase.render(f5);
		this.Leg1.render(f5);
		this.Leg2.render(f5);
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
