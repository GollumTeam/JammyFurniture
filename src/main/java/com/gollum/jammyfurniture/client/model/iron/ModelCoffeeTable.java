package com.gollum.jammyfurniture.client.model.iron;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCoffeeTable extends ModelBase implements JFIModel {
	ModelRenderer TableLeg1;
	ModelRenderer TableLeg2;
	ModelRenderer TableLeg3;
	ModelRenderer TableLeg4;
	ModelRenderer TableTop;
	ModelRenderer TableSideRight;
	ModelRenderer TableSideLeft;
	ModelRenderer TableSideBack;
	ModelRenderer TableSideFront;

	public ModelCoffeeTable() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.TableLeg1 = new ModelRenderer(this, 1, 0);
		this.TableLeg1.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.TableLeg1.setRotationPoint(6.0F, 10.0F, 6.0F);
		this.TableLeg1.setTextureSize(64, 64);
		this.TableLeg1.mirror = true;
		this.setRotation(this.TableLeg1, 0.0F, 0.0F, 0.0F);
		this.TableLeg2 = new ModelRenderer(this, 11, 0);
		this.TableLeg2.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.TableLeg2.setRotationPoint(6.0F, 10.0F, -8.0F);
		this.TableLeg2.setTextureSize(64, 64);
		this.TableLeg2.mirror = true;
		this.setRotation(this.TableLeg2, 0.0F, 0.0F, 0.0F);
		this.TableLeg3 = new ModelRenderer(this, 21, 0);
		this.TableLeg3.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.TableLeg3.setRotationPoint(-8.0F, 10.0F, -8.0F);
		this.TableLeg3.setTextureSize(64, 64);
		this.TableLeg3.mirror = true;
		this.setRotation(this.TableLeg3, 0.0F, 0.0F, 0.0F);
		this.TableLeg4 = new ModelRenderer(this, 31, 0);
		this.TableLeg4.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.TableLeg4.setRotationPoint(-8.0F, 10.0F, 6.0F);
		this.TableLeg4.setTextureSize(64, 64);
		this.TableLeg4.mirror = true;
		this.setRotation(this.TableLeg4, 0.0F, 0.0F, 0.0F);
		this.TableTop = new ModelRenderer(this, 0, 17);
		this.TableTop.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12);
		this.TableTop.setRotationPoint(-6.0F, 8.0F, -6.0F);
		this.TableTop.setTextureSize(64, 64);
		this.TableTop.mirror = true;
		this.setRotation(this.TableTop, 0.0F, 0.0F, 0.0F);
		this.TableSideRight = new ModelRenderer(this, 0, 37);
		this.TableSideRight.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16);
		this.TableSideRight.setRotationPoint(6.0F, 8.0F, -8.0F);
		this.TableSideRight.setTextureSize(64, 64);
		this.TableSideRight.mirror = true;
		this.setRotation(this.TableSideRight, 0.0F, 0.0F, 0.0F);
		this.TableSideLeft = new ModelRenderer(this, 0, 37);
		this.TableSideLeft.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16);
		this.TableSideLeft.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.TableSideLeft.setTextureSize(64, 64);
		this.TableSideLeft.mirror = true;
		this.setRotation(this.TableSideLeft, 0.0F, 0.0F, 0.0F);
		this.TableSideBack = new ModelRenderer(this, 1, 32);
		this.TableSideBack.addBox(0.0F, 0.0F, 0.0F, 12, 2, 2);
		this.TableSideBack.setRotationPoint(-6.0F, 8.0F, 6.0F);
		this.TableSideBack.setTextureSize(64, 64);
		this.TableSideBack.mirror = true;
		this.setRotation(this.TableSideBack, 0.0F, 0.0F, 0.0F);
		this.TableSideFront = new ModelRenderer(this, 1, 32);
		this.TableSideFront.addBox(0.0F, 0.0F, 0.0F, 12, 2, 2);
		this.TableSideFront.setRotationPoint(-6.0F, 8.0F, -8.0F);
		this.TableSideFront.setTextureSize(64, 64);
		this.TableSideFront.mirror = true;
		this.setRotation(this.TableSideFront, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.TableLeg1.render(f5);
		this.TableLeg2.render(f5);
		this.TableLeg3.render(f5);
		this.TableLeg4.render(f5);
		this.TableTop.render(f5);
		this.TableSideRight.render(f5);
		this.TableSideLeft.render(f5);
		this.TableSideBack.render(f5);
		this.TableSideFront.render(f5);
	}

	public void renderModel(float f5) {
		this.TableLeg1.render(f5);
		this.TableLeg2.render(f5);
		this.TableLeg3.render(f5);
		this.TableLeg4.render(f5);
		this.TableTop.render(f5);
		this.TableSideRight.render(f5);
		this.TableSideLeft.render(f5);
		this.TableSideBack.render(f5);
		this.TableSideFront.render(f5);
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
