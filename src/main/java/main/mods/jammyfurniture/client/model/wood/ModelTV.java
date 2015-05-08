package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTV extends ModelBase implements JFIModel {
	
	ModelRenderer tvBase;
	ModelRenderer areialBig;
	ModelRenderer areialSmall;
	ModelRenderer button1;
	ModelRenderer button2;
	ModelRenderer button3;

	public ModelTV() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.tvBase = new ModelRenderer(this, 0, 0);
		this.tvBase.addBox(0.0F, 0.0F, 0.0F, 16, 12, 9);
		this.tvBase.setRotationPoint(-8.0F, 12.0F, -4.0F);
		this.tvBase.setTextureSize(64, 32);
		this.tvBase.mirror = true;
		this.setRotation(this.tvBase, 0.0F, 0.0F, 0.0F);
		this.areialBig = new ModelRenderer(this, 52, 0);
		this.areialBig.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1);
		this.areialBig.setRotationPoint(-2.0F, 4.0F, 0.0F);
		this.areialBig.setTextureSize(64, 32);
		this.areialBig.mirror = true;
		this.setRotation(this.areialBig, 0.0F, 0.0F, -0.2602503F);
		this.areialSmall = new ModelRenderer(this, 52, 0);
		this.areialSmall.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
		this.areialSmall.setRotationPoint(4.0F, 6.0F, 0.0F);
		this.areialSmall.setTextureSize(64, 32);
		this.areialSmall.mirror = true;
		this.setRotation(this.areialSmall, 0.0F, 0.0F, 0.4089647F);
		this.button1 = new ModelRenderer(this, 0, 23);
		this.button1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
		this.button1.setRotationPoint(5.0F, 21.0F, -5.0F);
		this.button1.setTextureSize(64, 32);
		this.button1.mirror = true;
		this.setRotation(this.button1, 0.0F, 0.0F, 0.0F);
		this.button2 = new ModelRenderer(this, 0, 23);
		this.button2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
		this.button2.setRotationPoint(5.0F, 18.0F, -5.0F);
		this.button2.setTextureSize(64, 32);
		this.button2.mirror = true;
		this.setRotation(this.button2, 0.0F, 0.0F, 0.0F);
		this.button3 = new ModelRenderer(this, 10, 23);
		this.button3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.button3.setRotationPoint(5.5F, 16.0F, -5.0F);
		this.button3.setTextureSize(64, 32);
		this.button3.mirror = true;
		this.setRotation(this.button3, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.tvBase.render(f5);
		this.areialBig.render(f5);
		this.areialSmall.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
		this.button3.render(f5);
	}

	public void renderModel(float f5) {
		this.tvBase.render(f5);
		this.areialBig.render(f5);
		this.areialSmall.render(f5);
		this.button1.render(f5);
		this.button2.render(f5);
		this.button3.render(f5);
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
