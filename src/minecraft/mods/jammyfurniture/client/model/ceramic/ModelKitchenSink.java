package mods.jammyfurniture.client.model.ceramic;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKitchenSink extends ModelBase implements JFIModel {
	ModelRenderer sinkBack;
	ModelRenderer sinkFront;
	ModelRenderer sinkRight;
	ModelRenderer sinkLeft;
	ModelRenderer sinkBaseFront;
	ModelRenderer sinkBaseLeft;
	ModelRenderer sinkBaseRight;
	ModelRenderer sinkBase;
	ModelRenderer tapBase1;
	ModelRenderer tapOut1;
	ModelRenderer tapBase2;
	ModelRenderer tapOut2;
	ModelRenderer pipeDown;
	ModelRenderer pipeAcross;

	public ModelKitchenSink() {
		this.textureWidth = 128;
		this.textureHeight = 32;
		this.sinkBack = new ModelRenderer(this, 1, 21);
		this.sinkBack.addBox(0.0F, 0.0F, 0.0F, 16, 6, 4);
		this.sinkBack.setRotationPoint(-8.0F, 8.0F, 4.0F);
		this.sinkBack.setTextureSize(128, 32);
		this.sinkBack.mirror = true;
		this.setRotation(this.sinkBack, 0.0F, 0.0F, 0.0F);
		this.sinkFront = new ModelRenderer(this, 1, 16);
		this.sinkFront.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2);
		this.sinkFront.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.sinkFront.setTextureSize(128, 32);
		this.sinkFront.mirror = true;
		this.setRotation(this.sinkFront, 0.0F, 0.0F, 0.0F);
		this.sinkRight = new ModelRenderer(this, 43, 19);
		this.sinkRight.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10);
		this.sinkRight.setRotationPoint(6.0F, 8.0F, -6.0F);
		this.sinkRight.setTextureSize(128, 32);
		this.sinkRight.mirror = true;
		this.setRotation(this.sinkRight, 0.0F, 0.0F, 0.0F);
		this.sinkLeft = new ModelRenderer(this, 69, 19);
		this.sinkLeft.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10);
		this.sinkLeft.setRotationPoint(-8.0F, 8.0F, -6.0F);
		this.sinkLeft.setTextureSize(128, 32);
		this.sinkLeft.mirror = true;
		this.setRotation(this.sinkLeft, 0.0F, 0.0F, 0.0F);
		this.sinkBaseFront = new ModelRenderer(this, 46, 1);
		this.sinkBaseFront.addBox(0.0F, 0.0F, 0.0F, 14, 3, 1);
		this.sinkBaseFront.setRotationPoint(-7.0F, 10.0F, -7.0F);
		this.sinkBaseFront.setTextureSize(128, 32);
		this.sinkBaseFront.mirror = true;
		this.setRotation(this.sinkBaseFront, 0.0F, 0.0F, 0.0F);
		this.sinkBaseLeft = new ModelRenderer(this, 96, 2);
		this.sinkBaseLeft.addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
		this.sinkBaseLeft.setRotationPoint(-7.0F, 10.0F, -6.0F);
		this.sinkBaseLeft.setTextureSize(128, 32);
		this.sinkBaseLeft.mirror = true;
		this.setRotation(this.sinkBaseLeft, 0.0F, 0.0F, 0.0F);
		this.sinkBaseRight = new ModelRenderer(this, 1, 1);
		this.sinkBaseRight.addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
		this.sinkBaseRight.setRotationPoint(6.0F, 10.0F, -6.0F);
		this.sinkBaseRight.setTextureSize(128, 32);
		this.sinkBaseRight.mirror = true;
		this.setRotation(this.sinkBaseRight, 0.0F, 0.0F, 0.0F);
		this.sinkBase = new ModelRenderer(this, 43, 6);
		this.sinkBase.addBox(0.0F, 0.0F, 0.0F, 14, 1, 11);
		this.sinkBase.setRotationPoint(-7.0F, 13.0F, -7.0F);
		this.sinkBase.setTextureSize(128, 32);
		this.sinkBase.mirror = true;
		this.setRotation(this.sinkBase, 0.0F, 0.0F, 0.0F);
		this.tapBase1 = new ModelRenderer(this, 25, 1);
		this.tapBase1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.tapBase1.setRotationPoint(-4.0F, 4.0F, 5.0F);
		this.tapBase1.setTextureSize(128, 32);
		this.tapBase1.mirror = true;
		this.setRotation(this.tapBase1, 0.0F, 0.0F, 0.0F);
		this.tapOut1 = new ModelRenderer(this, 31, 1);
		this.tapOut1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.tapOut1.setRotationPoint(-4.0F, 5.0F, 2.0F);
		this.tapOut1.setTextureSize(128, 32);
		this.tapOut1.mirror = true;
		this.setRotation(this.tapOut1, 0.0F, 0.0F, 0.0F);
		this.tapBase2 = new ModelRenderer(this, 26, 8);
		this.tapBase2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.tapBase2.setRotationPoint(3.0F, 4.0F, 5.0F);
		this.tapBase2.setTextureSize(128, 32);
		this.tapBase2.mirror = true;
		this.setRotation(this.tapBase2, 0.0F, 0.0F, 0.0F);
		this.tapOut2 = new ModelRenderer(this, 32, 9);
		this.tapOut2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
		this.tapOut2.setRotationPoint(3.0F, 5.0F, 2.0F);
		this.tapOut2.setTextureSize(128, 32);
		this.tapOut2.mirror = true;
		this.setRotation(this.tapOut2, 0.0F, 0.0F, 0.0F);
		this.pipeDown = new ModelRenderer(this, 96, 18);
		this.pipeDown.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.pipeDown.setRotationPoint(0.0F, 14.0F, 2.0F);
		this.pipeDown.setTextureSize(128, 32);
		this.pipeDown.mirror = true;
		this.setRotation(this.pipeDown, 0.0F, 0.0F, 0.0F);
		this.pipeAcross = new ModelRenderer(this, 96, 23);
		this.pipeAcross.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
		this.pipeAcross.setRotationPoint(0.0F, 17.0F, 2.0F);
		this.pipeAcross.setTextureSize(128, 32);
		this.pipeAcross.mirror = true;
		this.setRotation(this.pipeAcross, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.sinkBack.render(f5);
		this.sinkFront.render(f5);
		this.sinkRight.render(f5);
		this.sinkLeft.render(f5);
		this.sinkBaseFront.render(f5);
		this.sinkBaseLeft.render(f5);
		this.sinkBaseRight.render(f5);
		this.sinkBase.render(f5);
		this.tapBase1.render(f5);
		this.tapOut1.render(f5);
		this.tapBase2.render(f5);
		this.tapOut2.render(f5);
		this.pipeDown.render(f5);
		this.pipeAcross.render(f5);
	}

	public void renderModel(float f5) {
		this.sinkBack.render(f5);
		this.sinkFront.render(f5);
		this.sinkRight.render(f5);
		this.sinkLeft.render(f5);
		this.sinkBaseFront.render(f5);
		this.sinkBaseLeft.render(f5);
		this.sinkBaseRight.render(f5);
		this.sinkBase.render(f5);
		this.tapBase1.render(f5);
		this.tapOut1.render(f5);
		this.tapBase2.render(f5);
		this.tapOut2.render(f5);
		this.pipeDown.render(f5);
		this.pipeAcross.render(f5);
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
