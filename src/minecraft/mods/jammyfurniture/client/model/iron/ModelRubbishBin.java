package mods.jammyfurniture.client.model.iron;

import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.JFIModelDoor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRubbishBin extends ModelBase implements JFIModelDoor {
	ModelRenderer binLid;
	ModelRenderer binBase;
	ModelRenderer handleP1;
	ModelRenderer handleP2;
	ModelRenderer handleP3;

	public ModelRubbishBin() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.binLid = new ModelRenderer(this, 0, 28);
		this.binLid.addBox(-1.0F, -2.0F, 0.0F, 14, 2, 14);
		this.binLid.setRotationPoint(-6.0F, 10.0F, -7.0F);
		this.binLid.setTextureSize(64, 64);
		this.binLid.mirror = true;
		this.setRotation(this.binLid, 0.0F, 0.0F, 0.0F);
		
		this.binBase = new ModelRenderer(this, 0, 0);
		this.binBase.addBox(0.0F, 0.0F, 0.0F, 12, 14, 12);
		this.binBase.setRotationPoint(-6.0F, 10.0F, -6.0F);
		this.binBase.setTextureSize(64, 64);
		this.binBase.mirror = true;
		
		this.handleP1 = new ModelRenderer(this, 0, 46);
		this.handleP1.addBox(6.0F, -3.0F, 10.0F, 1, 1, 1);
		this.handleP1.setRotationPoint(-6.0F, 10.0F, -8.0F);
		this.handleP1.setTextureSize(64, 64);
		this.handleP1.mirror = true;
		this.setRotation(this.handleP1, 0.0F, 0.0F, 0.0F);

		this.handleP2 = new ModelRenderer(this, 6, 46);
		this.handleP2.addBox(6.0F, -4.0F, 4.0F, 1, 1, 6);
		this.handleP2.setRotationPoint(-6.0F, 10.0F, -7.0F);
		this.handleP2.setTextureSize(64, 64);
		this.handleP2.mirror = true;
		this.setRotation(this.handleP2, 0.0F, 0.0F, 0.0F);
		
		this.handleP3 = new ModelRenderer(this, 0, 46);
		this.handleP3.addBox(6.0F, -3.0F, 4.0F, 1, 1, 1);
		this.handleP3.setRotationPoint(-6.0F, 10.0F, -7.0F);
		this.handleP3.setTextureSize(64, 64);
		this.handleP3.mirror = true;
		this.setRotation(this.handleP3, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.binLid.render(f5);
		this.binBase.render(f5);
		this.handleP1.render(f5);
		this.handleP2.render(f5);
		this.handleP3.render(f5);
	}

	public void renderModel(float f5) {
		this.binLid.render(f5);
		this.binBase.render(f5);
		this.handleP1.render(f5);
		this.handleP2.render(f5);
		this.handleP3.render(f5);
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
		float rotation = -(doorProgess * (float) Math.PI / 2.0F);
		this.binLid.rotateAngleZ = rotation;
		this.handleP1.rotateAngleZ = rotation;
		this.handleP2.rotateAngleZ = rotation;
		this.handleP3.rotateAngleZ = rotation;
	}
}
