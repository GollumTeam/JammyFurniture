package mods.jammyfurniture.client.model.lights;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOutsideLamp extends ModelBase implements JFIModel {
	
	ModelRenderer lampHolder;
	ModelRenderer lampOut;
	ModelRenderer lampDecoBottom;
	ModelRenderer lampMain;
	ModelRenderer lampDecoMid;
	ModelRenderer lampDecoTop;
	ModelRenderer lampUp;

	public ModelOutsideLamp() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.lampHolder = new ModelRenderer(this, 13, 0);
		this.lampHolder.addBox(0.0F, 0.0F, 0.0F, 3, 5, 1);
		this.lampHolder.setRotationPoint(-1.0F, 17.0F, 7.0F);
		this.lampHolder.setTextureSize(64, 32);
		this.lampHolder.mirror = true;
		this.setRotation(this.lampHolder, 0.0F, 0.0F, 0.0F);
		this.lampOut = new ModelRenderer(this, 0, 0);
		this.lampOut.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5);
		this.lampOut.setRotationPoint(0.0F, 19.0F, 2.0F);
		this.lampOut.setTextureSize(64, 32);
		this.lampOut.mirror = true;
		this.setRotation(this.lampOut, 0.0F, 0.0F, 0.0F);
		this.lampDecoBottom = new ModelRenderer(this, 0, 7);
		this.lampDecoBottom.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
		this.lampDecoBottom.setRotationPoint(-1.0F, 17.0F, 1.0F);
		this.lampDecoBottom.setTextureSize(64, 32);
		this.lampDecoBottom.mirror = true;
		this.setRotation(this.lampDecoBottom, 0.0F, 0.0F, 0.0F);
		this.lampMain = new ModelRenderer(this, 0, 18);
		this.lampMain.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
		this.lampMain.setRotationPoint(-2.0F, 11.0F, 0.0F);
		this.lampMain.setTextureSize(64, 32);
		this.lampMain.mirror = true;
		this.setRotation(this.lampMain, 0.0F, 0.0F, 0.0F);
		this.lampDecoMid = new ModelRenderer(this, 5, 13);
		this.lampDecoMid.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
		this.lampDecoMid.setRotationPoint(-1.0F, 10.0F, 1.0F);
		this.lampDecoMid.setTextureSize(64, 32);
		this.lampDecoMid.mirror = true;
		this.setRotation(this.lampDecoMid, 0.0F, 0.0F, 0.0F);
		this.lampDecoTop = new ModelRenderer(this, 0, 15);
		this.lampDecoTop.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.lampDecoTop.setRotationPoint(0.0F, 9.0F, 2.0F);
		this.lampDecoTop.setTextureSize(64, 32);
		this.lampDecoTop.mirror = true;
		this.setRotation(this.lampDecoTop, 0.0F, 0.0F, 0.0F);
		this.lampUp = new ModelRenderer(this, 0, 12);
		this.lampUp.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.lampUp.setRotationPoint(0.0F, 18.0F, 2.0F);
		this.lampUp.setTextureSize(64, 32);
		this.lampUp.mirror = true;
		this.setRotation(this.lampUp, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.lampHolder.render(f5);
		this.lampOut.render(f5);
		this.lampDecoBottom.render(f5);
		this.lampMain.render(f5);
		this.lampDecoMid.render(f5);
		this.lampDecoTop.render(f5);
		this.lampUp.render(f5);
	}

	public void renderModel(float f5) {
		this.lampHolder.render(f5);
		this.lampOut.render(f5);
		this.lampDecoBottom.render(f5);
		this.lampMain.render(f5);
		this.lampDecoMid.render(f5);
		this.lampDecoTop.render(f5);
		this.lampUp.render(f5);
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
