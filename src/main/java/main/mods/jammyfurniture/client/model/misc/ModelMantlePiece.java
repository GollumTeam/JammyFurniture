package mods.jammyfurniture.client.model.misc;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMantlePiece extends ModelBase implements JFIModel {
	
	ModelRenderer top;
	ModelRenderer left;
	ModelRenderer right;
	ModelRenderer decoTop;

	public ModelMantlePiece() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.top = new ModelRenderer(this, 1, 8);
		this.top.addBox(0.0F, 0.0F, 0.0F, 24, 4, 4);
		this.top.setRotationPoint(-12.0F, 4.0F, 4.0F);
		this.top.setTextureSize(64, 64);
		this.top.mirror = true;
		this.setRotation(this.top, 0.0F, 0.0F, 0.0F);
		this.left = new ModelRenderer(this, 1, 17);
		this.left.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4);
		this.left.setRotationPoint(-12.0F, 8.0F, 4.0F);
		this.left.setTextureSize(64, 64);
		this.left.mirror = true;
		this.setRotation(this.left, 0.0F, 0.0F, 0.0F);
		this.right = new ModelRenderer(this, 18, 17);
		this.right.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4);
		this.right.setRotationPoint(8.0F, 8.0F, 4.0F);
		this.right.setTextureSize(64, 64);
		this.right.mirror = true;
		this.setRotation(this.right, 0.0F, 0.0F, 0.0F);
		this.decoTop = new ModelRenderer(this, 1, 1);
		this.decoTop.addBox(0.0F, 0.0F, 0.0F, 26, 1, 5);
		this.decoTop.setRotationPoint(-13.0F, 3.0F, 3.0F);
		this.decoTop.setTextureSize(64, 64);
		this.decoTop.mirror = true;
		this.setRotation(this.decoTop, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.top.render(f5);
		this.left.render(f5);
		this.right.render(f5);
		this.decoTop.render(f5);
	}

	public void renderModel(float f5) {
		this.top.render(f5);
		this.left.render(f5);
		this.right.render(f5);
		this.decoTop.render(f5);
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
