package mods.jammyfurniture.client.model.wood;

import mods.jammyfurniture.client.model.JFIModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTable extends ModelBase implements JFIModel {
	ModelRenderer tableLeg1;
	ModelRenderer tableLeg2;
	ModelRenderer tableLeg3;
	ModelRenderer tableLeg4;
	ModelRenderer tableTop;

	public ModelTable() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.tableLeg1 = new ModelRenderer(this, 1, 0);
		this.tableLeg1.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.tableLeg1.setRotationPoint(6.0F, 10.0F, 6.0F);
		this.tableLeg1.setTextureSize(64, 64);
		this.tableLeg1.mirror = true;
		this.setRotation(this.tableLeg1, 0.0F, 0.0F, 0.0F);
		this.tableLeg2 = new ModelRenderer(this, 11, 0);
		this.tableLeg2.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.tableLeg2.setRotationPoint(6.0F, 10.0F, -8.0F);
		this.tableLeg2.setTextureSize(64, 64);
		this.tableLeg2.mirror = true;
		this.setRotation(this.tableLeg2, 0.0F, 0.0F, 0.0F);
		this.tableLeg3 = new ModelRenderer(this, 21, 0);
		this.tableLeg3.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.tableLeg3.setRotationPoint(-8.0F, 10.0F, -8.0F);
		this.tableLeg3.setTextureSize(64, 64);
		this.tableLeg3.mirror = true;
		this.setRotation(this.tableLeg3, 0.0F, 0.0F, 0.0F);
		this.tableLeg4 = new ModelRenderer(this, 31, 0);
		this.tableLeg4.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2);
		this.tableLeg4.setRotationPoint(-8.0F, 10.0F, 6.0F);
		this.tableLeg4.setTextureSize(64, 64);
		this.tableLeg4.mirror = true;
		this.setRotation(this.tableLeg4, 0.0F, 0.0F, 0.0F);
		this.tableTop = new ModelRenderer(this, 0, 17);
		this.tableTop.addBox(0.0F, 0.0F, 0.0F, 16, 2, 16);
		this.tableTop.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.tableTop.setTextureSize(64, 64);
		this.tableTop.mirror = true;
		this.setRotation(this.tableTop, 0.0F, 0.0F, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.tableLeg1.render(f5);
		this.tableLeg2.render(f5);
		this.tableLeg3.render(f5);
		this.tableLeg4.render(f5);
		this.tableTop.render(f5);
	}

	public void renderModel(float f5) {
		this.tableLeg1.render(f5);
		this.tableLeg2.render(f5);
		this.tableLeg3.render(f5);
		this.tableLeg4.render(f5);
		this.tableTop.render(f5);
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
