package mods.jammyfurniture.client.model.roofing;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofing extends ModelBase implements JFIModel {
	ModelRenderer roofTop;
	ModelRenderer roofMiddle1;
	ModelRenderer roofMiddle2;
	ModelRenderer roofBottom;

	public ModelRoofing() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.roofTop = new ModelRenderer(this, 0, 0);
		this.roofTop.addBox(0.0F, 0.0F, 0.0F, 16, 16, 4);
		this.roofTop.setRotationPoint(-8.0F, 8.0F, 4.0F);
		this.roofTop.setTextureSize(128, 64);
		this.roofTop.mirror = true;
		this.setRotation(this.roofTop, 0.0F, 0.0F, 0.0F);
		this.roofMiddle1 = new ModelRenderer(this, 44, 0);
		this.roofMiddle1.addBox(0.0F, 0.0F, 0.0F, 16, 12, 4);
		this.roofMiddle1.setRotationPoint(-8.0F, 12.0F, 0.0F);
		this.roofMiddle1.setTextureSize(128, 64);
		this.roofMiddle1.mirror = true;
		this.setRotation(this.roofMiddle1, 0.0F, 0.0F, 0.0F);
		this.roofMiddle2 = new ModelRenderer(this, 0, 24);
		this.roofMiddle2.addBox(0.0F, 0.0F, 0.0F, 16, 8, 4);
		this.roofMiddle2.setRotationPoint(-8.0F, 16.0F, -4.0F);
		this.roofMiddle2.setTextureSize(128, 64);
		this.roofMiddle2.mirror = true;
		this.setRotation(this.roofMiddle2, 0.0F, 0.0F, 0.0F);
		this.roofBottom = new ModelRenderer(this, 44, 23);
		this.roofBottom.addBox(0.0F, 0.0F, 0.0F, 16, 4, 4);
		this.roofBottom.setRotationPoint(-8.0F, 20.0F, -8.0F);
		this.roofBottom.setTextureSize(128, 64);
		this.roofBottom.mirror = true;
		this.setRotation(this.roofBottom, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.roofTop.render(f5);
		this.roofMiddle1.render(f5);
		this.roofMiddle2.render(f5);
		this.roofBottom.render(f5);
	}

	public void renderModel(float f5) {
		this.roofTop.render(f5);
		this.roofMiddle1.render(f5);
		this.roofMiddle2.render(f5);
		this.roofBottom.render(f5);
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
