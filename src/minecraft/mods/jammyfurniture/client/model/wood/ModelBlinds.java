package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlinds extends ModelBase implements JFIModel {
	
	public ModelRenderer shape4;
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape16;
	public ModelRenderer shape3;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape8;
	public ModelRenderer shape9;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape14;
	public ModelRenderer shape15;
	public ModelRenderer modelClosed;

	public ModelBlinds() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.shape4 = new ModelRenderer(this, 0, 3);
		this.shape4.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape4.setRotationPoint(-8.0F, 20.0F, 7.6F);
		this.shape4.setTextureSize(64, 32);
		this.shape4.mirror = true;
		this.setRotation(this.shape4, 2.879793F, 0.0F, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape1.setRotationPoint(-8.0F, 23.0F, 7.6F);
		this.shape1.setTextureSize(64, 32);
		this.shape1.mirror = true;
		this.setRotation(this.shape1, 2.879793F, 0.0F, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 1);
		this.shape2.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape2.setRotationPoint(-8.0F, 22.0F, 7.6F);
		this.shape2.setTextureSize(64, 32);
		this.shape2.mirror = true;
		this.setRotation(this.shape2, 2.879793F, 0.0F, 0.0F);
		this.shape16 = new ModelRenderer(this, 0, 15);
		this.shape16.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape16.setRotationPoint(-8.0F, 8.0F, 7.6F);
		this.shape16.setTextureSize(64, 32);
		this.shape16.mirror = true;
		this.setRotation(this.shape16, 2.879793F, 0.0F, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 2);
		this.shape3.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape3.setRotationPoint(-8.0F, 21.0F, 7.6F);
		this.shape3.setTextureSize(64, 32);
		this.shape3.mirror = true;
		this.setRotation(this.shape3, 2.879793F, 0.0F, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 4);
		this.shape5.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape5.setRotationPoint(-8.0F, 19.0F, 7.6F);
		this.shape5.setTextureSize(64, 32);
		this.shape5.mirror = true;
		this.setRotation(this.shape5, 2.879793F, 0.0F, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 5);
		this.shape6.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape6.setRotationPoint(-8.0F, 18.0F, 7.6F);
		this.shape6.setTextureSize(64, 32);
		this.shape6.mirror = true;
		this.setRotation(this.shape6, 2.879793F, 0.0F, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 6);
		this.shape7.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape7.setRotationPoint(-8.0F, 17.0F, 7.6F);
		this.shape7.setTextureSize(64, 32);
		this.shape7.mirror = true;
		this.setRotation(this.shape7, 2.879793F, 0.0F, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 7);
		this.shape8.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape8.setRotationPoint(-8.0F, 16.0F, 7.6F);
		this.shape8.setTextureSize(64, 32);
		this.shape8.mirror = true;
		this.setRotation(this.shape8, 2.879793F, 0.0F, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 8);
		this.shape9.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape9.setRotationPoint(-8.0F, 15.0F, 7.6F);
		this.shape9.setTextureSize(64, 32);
		this.shape9.mirror = true;
		this.setRotation(this.shape9, 2.879793F, 0.0F, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 9);
		this.shape10.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape10.setRotationPoint(-8.0F, 14.0F, 7.6F);
		this.shape10.setTextureSize(64, 32);
		this.shape10.mirror = true;
		this.setRotation(this.shape10, 2.879793F, 0.0F, 0.0F);
		this.shape11 = new ModelRenderer(this, 0, 10);
		this.shape11.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape11.setRotationPoint(-8.0F, 13.0F, 7.6F);
		this.shape11.setTextureSize(64, 32);
		this.shape11.mirror = true;
		this.setRotation(this.shape11, 2.879793F, 0.0F, 0.0F);
		this.shape12 = new ModelRenderer(this, 0, 11);
		this.shape12.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape12.setRotationPoint(-8.0F, 12.0F, 7.6F);
		this.shape12.setTextureSize(64, 32);
		this.shape12.mirror = true;
		this.setRotation(this.shape12, 2.879793F, 0.0F, 0.0F);
		this.shape13 = new ModelRenderer(this, 0, 12);
		this.shape13.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape13.setRotationPoint(-8.0F, 11.0F, 7.6F);
		this.shape13.setTextureSize(64, 32);
		this.shape13.mirror = true;
		this.setRotation(this.shape13, 2.879793F, 0.0F, 0.0F);
		this.shape14 = new ModelRenderer(this, 0, 13);
		this.shape14.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape14.setRotationPoint(-8.0F, 10.0F, 7.6F);
		this.shape14.setTextureSize(64, 32);
		this.shape14.mirror = true;
		this.setRotation(this.shape14, 2.879793F, 0.0F, 0.0F);
		this.shape15 = new ModelRenderer(this, 0, 14);
		this.shape15.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.shape15.setRotationPoint(-8.0F, 9.0F, 7.6F);
		this.shape15.setTextureSize(64, 32);
		this.shape15.mirror = true;
		this.setRotation(this.shape15, 2.879793F, 0.0F, 0.0F);
		this.modelClosed = new ModelRenderer(this, 0, 16);
		this.modelClosed.addBox(0.0F, -1.0F, 0.0F, 16, 2, 1);
		this.modelClosed.setRotationPoint(-8.0F, 9.0F, 7.0F);
		this.modelClosed.setTextureSize(64, 32);
		this.modelClosed.mirror = true;
		this.setRotation(this.modelClosed, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.shape4.render(f5);
		this.shape1.render(f5);
		this.shape2.render(f5);
		this.shape16.render(f5);
		this.shape3.render(f5);
		this.shape5.render(f5);
		this.shape6.render(f5);
		this.shape7.render(f5);
		this.shape8.render(f5);
		this.shape9.render(f5);
		this.shape10.render(f5);
		this.shape11.render(f5);
		this.shape12.render(f5);
		this.shape13.render(f5);
		this.shape14.render(f5);
		this.shape15.render(f5);
		this.modelClosed.render(f5);
	}

	public void renderModel(float f5) {
		this.shape4.render(f5);
		this.shape1.render(f5);
		this.shape2.render(f5);
		this.shape16.render(f5);
		this.shape3.render(f5);
		this.shape5.render(f5);
		this.shape6.render(f5);
		this.shape7.render(f5);
		this.shape8.render(f5);
		this.shape9.render(f5);
		this.shape10.render(f5);
		this.shape11.render(f5);
		this.shape12.render(f5);
		this.shape13.render(f5);
		this.shape14.render(f5);
		this.shape15.render(f5);
	}

	public void renderModelClosed(float f5) {
		this.modelClosed.render(f5);
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
