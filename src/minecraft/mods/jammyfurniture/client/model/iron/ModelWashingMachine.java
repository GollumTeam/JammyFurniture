package mods.jammyfurniture.client.model.iron;

import mods.jammyfurniture.client.model.JFIModelDoor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWashingMachine extends ModelBase implements JFIModelDoor {
	ModelRenderer base;
	ModelRenderer doorMain;
	ModelRenderer doorBottom;
	ModelRenderer doorTop;
	ModelRenderer doorLeft;
	ModelRenderer doorRight;
	ModelRenderer button3;
	ModelRenderer button1;
	ModelRenderer button2;

	public ModelWashingMachine() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.base = new ModelRenderer(this, 0, 25);
		this.base.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
		this.base.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.base.setTextureSize(64, 64);
		this.base.mirror = true;
		this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
		
		this.doorMain = new ModelRenderer(this, 1, 12);
		this.doorMain.addBox(1.0F, -1.0F, -1.0F, 8, 8, 1);
		this.doorMain.setRotationPoint(-5.0F, 14.0F, -8.0F);
		this.doorMain.setTextureSize(64, 64);
		this.doorMain.mirror = true;
		this.setRotation(this.doorMain, 0.0F, 0.0F, 0.0F);
		
		this.doorBottom = new ModelRenderer(this, 1, 9);
		this.doorBottom.addBox(2.0F, 7.0F, -1.0F, 6, 1, 1);
		this.doorBottom.setRotationPoint(-5.0F, 14.0F, -8.0F);
		this.doorBottom.setTextureSize(64, 64);
		this.doorBottom.mirror = true;
		this.setRotation(this.doorBottom, 0.0F, 0.0F, 0.0F);
		
		this.doorTop = new ModelRenderer(this, 20, 12);
		this.doorTop.addBox(2.0F, -2.0F, -1.0F, 6, 1, 1);
		this.doorTop.setRotationPoint(-5.0F, 14.0F, -8.0F);
		this.doorTop.setTextureSize(64, 64);
		this.doorTop.mirror = true;
		this.setRotation(this.doorTop, 0.0F, 0.0F, 0.0F);
		
		this.doorLeft = new ModelRenderer(this, 11, 0);
		this.doorLeft.addBox(0.0F, 0.0F, -1.0F, 1, 6, 1);
		this.doorLeft.setRotationPoint(-5.0F, 14.0F, -8.0F);
		this.doorLeft.setTextureSize(64, 64);
		this.doorLeft.mirror = true;
		this.setRotation(this.doorLeft, 0.0F, 0.0F, 0.0F);
		
		this.doorRight = new ModelRenderer(this, 6, 0);
		this.doorRight.addBox(9.0F, 0.0F, -1.0F, 1, 6, 1);
		this.doorRight.setRotationPoint(-5.0F, 14.0F, -8.0F);
		this.doorRight.setTextureSize(64, 64);
		this.doorRight.mirror = true;
		this.setRotation(this.doorRight, 0.0F, 0.0F, 0.0F);
		
		this.button3 = new ModelRenderer(this, 1, 6);
		this.button3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button3.setRotationPoint(4.0F, 9.0F, -9.0F);
		this.button3.setTextureSize(64, 64);
		this.button3.mirror = true;
		this.setRotation(this.button3, 0.0F, 0.0F, 0.0F);
		this.button1 = new ModelRenderer(this, 1, 0);
		this.button1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button1.setRotationPoint(-6.0F, 9.0F, -9.0F);
		this.button1.setTextureSize(64, 64);
		this.button1.mirror = true;
		this.setRotation(this.button1, 0.0F, 0.0F, 0.0F);
		this.button2 = new ModelRenderer(this, 1, 3);
		this.button2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button2.setRotationPoint(-4.0F, 9.0F, -9.0F);
		this.button2.setTextureSize(64, 64);
		this.button2.mirror = true;
		this.setRotation(this.button2, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.base.render(f5);
		this.doorMain.render(f5);
		this.doorBottom.render(f5);
		this.doorTop.render(f5);
		this.doorLeft.render(f5);
		this.doorRight.render(f5);
		this.button3.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
	}

	public void renderModel(float f5) {
		this.base.render(f5);
		this.doorMain.render(f5);
		this.doorBottom.render(f5);
		this.doorTop.render(f5);
		this.doorLeft.render(f5);
		this.doorRight.render(f5);
		this.button3.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
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

	@Override
	public void setDoorProgess(float doorProgess) {
		
//		doorProgess = 0.7F;
		
		this.doorMain  .rotateAngleY = doorProgess * (float) Math.PI / 1.5F;
		this.doorTop   .rotateAngleY = doorProgess * (float) Math.PI / 1.5F;
		this.doorLeft  .rotateAngleY = doorProgess * (float) Math.PI / 1.5F;
		this.doorRight .rotateAngleY = doorProgess * (float) Math.PI / 1.5F;
		this.doorBottom.rotateAngleY = doorProgess * (float) Math.PI / 1.5F;
	}
}
