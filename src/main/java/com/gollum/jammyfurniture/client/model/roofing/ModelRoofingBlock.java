package com.gollum.jammyfurniture.client.model.roofing;

import com.gollum.jammyfurniture.client.model.JFIModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofingBlock extends ModelBase implements JFIModel {
	ModelRenderer roofingBlock;

	public ModelRoofingBlock() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.roofingBlock = new ModelRenderer(this, 0, 0);
		this.roofingBlock.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
		this.roofingBlock.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.roofingBlock.setTextureSize(128, 64);
		this.roofingBlock.mirror = true;
		this.setRotation(this.roofingBlock, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.roofingBlock.render(f5);
	}

	public void renderModel(float f5) {
		this.roofingBlock.render(f5);
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
