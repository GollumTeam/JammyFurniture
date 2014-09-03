package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.JFIModelDoor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCupboardTop extends ModelBase implements JFIModelDoor {
	
	ModelRenderer base3;
	ModelRenderer door1;
	ModelRenderer door2;
	ModelRenderer door4;
	ModelRenderer door3;
	ModelRenderer deco;

	public ModelCupboardTop() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.base3 = new ModelRenderer(this, 0, 0);
		this.base3.addBox(0.0F, 0.0F, 0.0F, 14, 15, 13);
		this.base3.setRotationPoint(-7.0F, 9.0F, -6.0F);
		this.base3.setTextureSize(128, 128);
		this.base3.mirror = true;
		this.setRotation(this.base3, 0.0F, 0.0F, 0.0F);
		this.deco = new ModelRenderer(this, 20, 34);
		this.deco.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1);
		this.deco.setRotationPoint(-7.0F, 9.0F, -7.0F);
		this.deco.setTextureSize(128, 128);
		this.deco.mirror = true;
		this.setRotation(this.deco, 0.0F, 0.0F, 0.0F);
		
		this.door1 = new ModelRenderer(this, 0, 52);
		this.door1.addBox(0.0F, 16.0F, -1.0F, 7, 4, 1);
		this.door1.setRotationPoint(-7.0F, 8.0F, -6.0F);
		this.door1.setTextureSize(128, 128);
		this.door1.mirror = true;
		this.setRotation(this.door1, 0.0F, 0.0F, 0.0F);
		
		this.door2 = new ModelRenderer(this, 19, 53);
		this.door2.addBox(-7.0F, 16.0F, -1.0F, 7, 4, 1);
		this.door2.setRotationPoint(7.0F, 8.0F, -6.0F);
		this.door2.setTextureSize(128, 128);
		this.door2.mirror = true;
		this.setRotation(this.door2, 0.0F, 0.0F, 0.0F);
		
		this.door3 = new ModelRenderer(this, 0, 32);
		this.door3.addBox(0.0F, 0.0F, -1.0F, 7, 14, 1);
		this.door3.setRotationPoint(-7.0F, 10.0F, -6.0F);
		this.door3.setTextureSize(128, 128);
		this.door3.mirror = true;
		this.setRotation(this.door3, 0.0F, 0.0F, 0.0F);
		
		this.door4 = new ModelRenderer(this, 19, 37);
		this.door4.addBox(-7.0F, 0.0F, -1.0F, 7, 14, 1);
		this.door4.setRotationPoint(7.0F, 10.0F, -6.0F);
		this.door4.setTextureSize(128, 128);
		this.door4.mirror = true;
		this.setRotation(this.door4, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.base3.render(f5);
		this.door1.render(f5);
		this.door2.render(f5);
		this.door4.render(f5);
		this.door3.render(f5);
		this.deco.render(f5);
	}

	public void renderModel(float f5) {
		this.base3.render(f5);
		this.door1.render(f5);
		this.door2.render(f5);
		this.door4.render(f5);
		this.door3.render(f5);
		this.deco.render(f5);
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
		float rotation = -(doorProgess * (float) Math.PI / 1.75F);
		this.door1.rotateAngleY = -rotation;
		this.door2.rotateAngleY = rotation;
		this.door3.rotateAngleY = -rotation;
		this.door4.rotateAngleY = rotation;
	}
}
