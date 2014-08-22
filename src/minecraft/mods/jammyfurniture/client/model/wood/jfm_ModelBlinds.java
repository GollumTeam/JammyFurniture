package mods.jammyfurniture.client.model.wood;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelBlinds extends ModelBase {
	public ModelRenderer Shape4;
	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape16;
	public ModelRenderer Shape3;
	public ModelRenderer Shape5;
	public ModelRenderer Shape6;
	public ModelRenderer Shape7;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape10;
	public ModelRenderer Shape11;
	public ModelRenderer Shape12;
	public ModelRenderer Shape13;
	public ModelRenderer Shape14;
	public ModelRenderer Shape15;
	public ModelRenderer ModelClosed;

	public jfm_ModelBlinds() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Shape4 = new ModelRenderer(this, 0, 3);
		this.Shape4.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape4.setRotationPoint(-8.0F, 20.0F, 7.6F);
		this.Shape4.setTextureSize(64, 32);
		this.Shape4.mirror = true;
		this.setRotation(this.Shape4, 2.879793F, 0.0F, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 0);
		this.Shape1.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape1.setRotationPoint(-8.0F, 23.0F, 7.6F);
		this.Shape1.setTextureSize(64, 32);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 2.879793F, 0.0F, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 1);
		this.Shape2.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape2.setRotationPoint(-8.0F, 22.0F, 7.6F);
		this.Shape2.setTextureSize(64, 32);
		this.Shape2.mirror = true;
		this.setRotation(this.Shape2, 2.879793F, 0.0F, 0.0F);
		this.Shape16 = new ModelRenderer(this, 0, 15);
		this.Shape16.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape16.setRotationPoint(-8.0F, 8.0F, 7.6F);
		this.Shape16.setTextureSize(64, 32);
		this.Shape16.mirror = true;
		this.setRotation(this.Shape16, 2.879793F, 0.0F, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 2);
		this.Shape3.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape3.setRotationPoint(-8.0F, 21.0F, 7.6F);
		this.Shape3.setTextureSize(64, 32);
		this.Shape3.mirror = true;
		this.setRotation(this.Shape3, 2.879793F, 0.0F, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 4);
		this.Shape5.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape5.setRotationPoint(-8.0F, 19.0F, 7.6F);
		this.Shape5.setTextureSize(64, 32);
		this.Shape5.mirror = true;
		this.setRotation(this.Shape5, 2.879793F, 0.0F, 0.0F);
		this.Shape6 = new ModelRenderer(this, 0, 5);
		this.Shape6.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape6.setRotationPoint(-8.0F, 18.0F, 7.6F);
		this.Shape6.setTextureSize(64, 32);
		this.Shape6.mirror = true;
		this.setRotation(this.Shape6, 2.879793F, 0.0F, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 6);
		this.Shape7.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape7.setRotationPoint(-8.0F, 17.0F, 7.6F);
		this.Shape7.setTextureSize(64, 32);
		this.Shape7.mirror = true;
		this.setRotation(this.Shape7, 2.879793F, 0.0F, 0.0F);
		this.Shape8 = new ModelRenderer(this, 0, 7);
		this.Shape8.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape8.setRotationPoint(-8.0F, 16.0F, 7.6F);
		this.Shape8.setTextureSize(64, 32);
		this.Shape8.mirror = true;
		this.setRotation(this.Shape8, 2.879793F, 0.0F, 0.0F);
		this.Shape9 = new ModelRenderer(this, 0, 8);
		this.Shape9.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape9.setRotationPoint(-8.0F, 15.0F, 7.6F);
		this.Shape9.setTextureSize(64, 32);
		this.Shape9.mirror = true;
		this.setRotation(this.Shape9, 2.879793F, 0.0F, 0.0F);
		this.Shape10 = new ModelRenderer(this, 0, 9);
		this.Shape10.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape10.setRotationPoint(-8.0F, 14.0F, 7.6F);
		this.Shape10.setTextureSize(64, 32);
		this.Shape10.mirror = true;
		this.setRotation(this.Shape10, 2.879793F, 0.0F, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 10);
		this.Shape11.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape11.setRotationPoint(-8.0F, 13.0F, 7.6F);
		this.Shape11.setTextureSize(64, 32);
		this.Shape11.mirror = true;
		this.setRotation(this.Shape11, 2.879793F, 0.0F, 0.0F);
		this.Shape12 = new ModelRenderer(this, 0, 11);
		this.Shape12.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape12.setRotationPoint(-8.0F, 12.0F, 7.6F);
		this.Shape12.setTextureSize(64, 32);
		this.Shape12.mirror = true;
		this.setRotation(this.Shape12, 2.879793F, 0.0F, 0.0F);
		this.Shape13 = new ModelRenderer(this, 0, 12);
		this.Shape13.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape13.setRotationPoint(-8.0F, 11.0F, 7.6F);
		this.Shape13.setTextureSize(64, 32);
		this.Shape13.mirror = true;
		this.setRotation(this.Shape13, 2.879793F, 0.0F, 0.0F);
		this.Shape14 = new ModelRenderer(this, 0, 13);
		this.Shape14.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape14.setRotationPoint(-8.0F, 10.0F, 7.6F);
		this.Shape14.setTextureSize(64, 32);
		this.Shape14.mirror = true;
		this.setRotation(this.Shape14, 2.879793F, 0.0F, 0.0F);
		this.Shape15 = new ModelRenderer(this, 0, 14);
		this.Shape15.addBox(0.0F, -1.0F, 0.0F, 16, 1, 0);
		this.Shape15.setRotationPoint(-8.0F, 9.0F, 7.6F);
		this.Shape15.setTextureSize(64, 32);
		this.Shape15.mirror = true;
		this.setRotation(this.Shape15, 2.879793F, 0.0F, 0.0F);
		this.ModelClosed = new ModelRenderer(this, 0, 16);
		this.ModelClosed.addBox(0.0F, -1.0F, 0.0F, 16, 2, 1);
		this.ModelClosed.setRotationPoint(-8.0F, 9.0F, 7.0F);
		this.ModelClosed.setTextureSize(64, 32);
		this.ModelClosed.mirror = true;
		this.setRotation(this.ModelClosed, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Shape4.render(f5);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape16.render(f5);
		this.Shape3.render(f5);
		this.Shape5.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
		this.Shape8.render(f5);
		this.Shape9.render(f5);
		this.Shape10.render(f5);
		this.Shape11.render(f5);
		this.Shape12.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape15.render(f5);
		this.ModelClosed.render(f5);
	}

	public void renderModel(float f5) {
		this.Shape4.render(f5);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape16.render(f5);
		this.Shape3.render(f5);
		this.Shape5.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
		this.Shape8.render(f5);
		this.Shape9.render(f5);
		this.Shape10.render(f5);
		this.Shape11.render(f5);
		this.Shape12.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape15.render(f5);
	}

	public void renderModelClosed(float f5) {
		this.ModelClosed.render(f5);
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
