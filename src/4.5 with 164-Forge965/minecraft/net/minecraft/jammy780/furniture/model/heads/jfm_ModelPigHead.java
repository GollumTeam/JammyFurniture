package net.minecraft.jammy780.furniture.model.heads;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelPigHead extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public jfm_ModelPigHead()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1 = new ModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.Shape1.setRotationPoint(-4.0F, 12.0F, 0.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 0, 17);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 3, 1);
        this.Shape2.setRotationPoint(-2.0F, 16.0F, -1.0F);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
    }

    public void renderModel(float f5)
    {
        this.Shape1.render(f5);
        this.Shape2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }
}
