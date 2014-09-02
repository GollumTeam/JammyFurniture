package mods.jammyfurniture.client.model.ceramic;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBathroomSink extends ModelBase implements JFIModel {
	ModelRenderer sinkHolder;
	ModelRenderer sinkBase;
	ModelRenderer sinkBack;
	ModelRenderer sinkSideRight;
	ModelRenderer sinkSideLeft;
	ModelRenderer sinkSideFront;
	ModelRenderer tapBase1;
	ModelRenderer tapEnd1;
	ModelRenderer tapBase2;
	ModelRenderer tapEnd2;
	ModelRenderer water1;
	ModelRenderer water2;

	public ModelBathroomSink() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.sinkHolder = new ModelRenderer(this, 1, 28);
		this.sinkHolder.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4);
		this.sinkHolder.setRotationPoint(0.0F, 14.0F, -2.0F);
		this.sinkHolder.setTextureSize(64, 32);
		this.sinkHolder.mirror = true;
		this.setRotation(this.sinkHolder, 0.0F, 0.0F, 0.0F);
		this.sinkBase = new ModelRenderer(this, 1, 14);
		this.sinkBase.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12);
		this.sinkBase.setRotationPoint(-4.0F, 13.0F, -6.0F);
		this.sinkBase.setTextureSize(64, 32);
		this.sinkBase.mirror = true;
		this.setRotation(this.sinkBase, 0.0F, 0.0F, 0.0F);
		this.sinkBack = new ModelRenderer(this, 18, 28);
		this.sinkBack.addBox(0.0F, 0.0F, 0.0F, 4, 3, 12);
		this.sinkBack.setRotationPoint(4.0F, 10.0F, -6.0F);
		this.sinkBack.setTextureSize(64, 32);
		this.sinkBack.mirror = true;
		this.setRotation(this.sinkBack, 0.0F, 0.0F, 0.0F);
		this.sinkSideRight = new ModelRenderer(this, 25, 7);
		this.sinkSideRight.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1);
		this.sinkSideRight.setRotationPoint(-4.0F, 11.0F, -6.0F);
		this.sinkSideRight.setTextureSize(64, 32);
		this.sinkSideRight.mirror = true;
		this.setRotation(this.sinkSideRight, 0.0F, 0.0F, 0.0F);
		this.sinkSideLeft = new ModelRenderer(this, 25, 2);
		this.sinkSideLeft.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1);
		this.sinkSideLeft.setRotationPoint(-4.0F, 11.0F, 5.0F);
		this.sinkSideLeft.setTextureSize(64, 32);
		this.sinkSideLeft.mirror = true;
		this.setRotation(this.sinkSideLeft, 0.0F, 0.0F, 0.0F);
		this.sinkSideFront = new ModelRenderer(this, 1, 1);
		this.sinkSideFront.addBox(0.0F, 0.0F, 0.0F, 1, 2, 10);
		this.sinkSideFront.setRotationPoint(-4.0F, 11.0F, -5.0F);
		this.sinkSideFront.setTextureSize(64, 32);
		this.sinkSideFront.mirror = true;
		this.setRotation(this.sinkSideFront, 0.0F, 0.0F, 0.0F);
		this.tapBase1 = new ModelRenderer(this, 1, 43);
		this.tapBase1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.tapBase1.setRotationPoint(4.0F, 8.0F, 2.0F);
		this.tapBase1.setTextureSize(64, 64);
		this.tapBase1.mirror = true;
		this.setRotation(this.tapBase1, 0.0F, 0.0F, 0.0F);
		this.tapEnd1 = new ModelRenderer(this, 1, 50);
		this.tapEnd1.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1);
		this.tapEnd1.setRotationPoint(3.0F, 8.0F, 2.0F);
		this.tapEnd1.setTextureSize(64, 64);
		this.tapEnd1.mirror = true;
		this.setRotation(this.tapEnd1, 0.0F, 0.0F, 0.0F);
		this.tapBase2 = new ModelRenderer(this, 6, 43);
		this.tapBase2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.tapBase2.setRotationPoint(4.0F, 8.0F, -3.0F);
		this.tapBase2.setTextureSize(64, 64);
		this.tapBase2.mirror = true;
		this.setRotation(this.tapBase2, 0.0F, 0.0F, 0.0F);
		this.tapEnd2 = new ModelRenderer(this, 1, 47);
		this.tapEnd2.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 1);
		this.tapEnd2.setRotationPoint(3.0F, 8.0F, -3.0F);
		this.tapEnd2.setTextureSize(64, 64);
		this.tapEnd2.mirror = true;
		this.setRotation(this.tapEnd2, 0.0F, 0.0F, 0.0F);
		
		
		this.water1 = new ModelRenderer(this, 12, 43);
		this.water1.addBox(-1.0F, 1.0F, 0.0F, 1, 4, 1);
		this.water1.setRotationPoint(3.0F, 8.0F, -3.0F);
		this.water1.setTextureSize(64, 64);
		this.water1.mirror = true;
		this.setRotation(this.water1, 0.0F, 0.0F, 0.0F);
		

		this.water2 = new ModelRenderer(this, 12, 43);
		this.water2.addBox(-1.0F, 1.0F, 5.0F, 1, 4, 1);
		this.water2.setRotationPoint(3.0F, 8.0F, -3.0F);
		this.water2.setTextureSize(64, 64);
		this.water2.mirror = true;
		this.setRotation(this.water2, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.sinkHolder.render(f5);
		this.sinkBase.render(f5);
		this.sinkBack.render(f5);
		this.sinkSideRight.render(f5);
		this.sinkSideLeft.render(f5);
		this.sinkSideFront.render(f5);
		this.tapBase1.render(f5);
		this.tapEnd1.render(f5);
		this.tapBase2.render(f5);
		this.tapEnd2.render(f5);
		this.water1.render(f5);
		this.water2.render(f5);
	}

	public void renderModel(float f5) {
		this.sinkHolder.render(f5);
		this.sinkBase.render(f5);
		this.sinkBack.render(f5);
		this.sinkSideRight.render(f5);
		this.sinkSideLeft.render(f5);
		this.sinkSideFront.render(f5);
		this.tapBase1.render(f5);
		this.tapEnd1.render(f5);
		this.tapBase2.render(f5);
		this.tapEnd2.render(f5);
		this.water1.render(f5);
		this.water2.render(f5);
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
