package net.minecraft.jammy780.furniture.model.heads;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelWolfHead extends ModelBase
{
    ModelRenderer HeadMain;
    ModelRenderer EarRight;
    ModelRenderer EarLeft;
    ModelRenderer Nose;

    public jfm_ModelWolfHead()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.HeadMain = new ModelRenderer(this, 0, 0);
        this.HeadMain.addBox(0.0F, 0.0F, 0.0F, 6, 6, 4);
        this.HeadMain.setRotationPoint(-3.0F, 14.0F, 4.0F);
        this.HeadMain.setTextureSize(64, 32);
        this.HeadMain.mirror = true;
        this.setRotation(this.HeadMain, 0.0F, 0.0F, 0.0F);
        this.EarRight = new ModelRenderer(this, 22, 0);
        this.EarRight.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
        this.EarRight.setRotationPoint(1.0F, 12.0F, 6.0F);
        this.EarRight.setTextureSize(64, 32);
        this.EarRight.mirror = true;
        this.setRotation(this.EarRight, 0.0F, 0.0F, 0.0F);
        this.EarLeft = new ModelRenderer(this, 22, 5);
        this.EarLeft.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
        this.EarLeft.setRotationPoint(-3.0F, 12.0F, 6.0F);
        this.EarLeft.setTextureSize(64, 32);
        this.EarLeft.mirror = true;
        this.setRotation(this.EarLeft, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 11);
        this.Nose.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4);
        this.Nose.setRotationPoint(-1.5F, 17.0F, 1.0F);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.HeadMain.render(f5);
        this.EarRight.render(f5);
        this.EarLeft.render(f5);
        this.Nose.render(f5);
    }

    public void renderModel(float f5)
    {
        this.HeadMain.render(f5);
        this.EarRight.render(f5);
        this.EarLeft.render(f5);
        this.Nose.render(f5);
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
