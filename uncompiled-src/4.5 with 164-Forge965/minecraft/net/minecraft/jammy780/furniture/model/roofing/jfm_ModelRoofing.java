package net.minecraft.jammy780.furniture.model.roofing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelRoofing extends ModelBase
{
    ModelRenderer RoofTop;
    ModelRenderer RoofMiddle1;
    ModelRenderer RoofMiddle2;
    ModelRenderer RoofBottom;

    public jfm_ModelRoofing()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.RoofTop = new ModelRenderer(this, 0, 0);
        this.RoofTop.addBox(0.0F, 0.0F, 0.0F, 16, 16, 4);
        this.RoofTop.setRotationPoint(-8.0F, 8.0F, 4.0F);
        this.RoofTop.setTextureSize(128, 64);
        this.RoofTop.mirror = true;
        this.setRotation(this.RoofTop, 0.0F, 0.0F, 0.0F);
        this.RoofMiddle1 = new ModelRenderer(this, 44, 0);
        this.RoofMiddle1.addBox(0.0F, 0.0F, 0.0F, 16, 12, 4);
        this.RoofMiddle1.setRotationPoint(-8.0F, 12.0F, 0.0F);
        this.RoofMiddle1.setTextureSize(128, 64);
        this.RoofMiddle1.mirror = true;
        this.setRotation(this.RoofMiddle1, 0.0F, 0.0F, 0.0F);
        this.RoofMiddle2 = new ModelRenderer(this, 0, 24);
        this.RoofMiddle2.addBox(0.0F, 0.0F, 0.0F, 16, 8, 4);
        this.RoofMiddle2.setRotationPoint(-8.0F, 16.0F, -4.0F);
        this.RoofMiddle2.setTextureSize(128, 64);
        this.RoofMiddle2.mirror = true;
        this.setRotation(this.RoofMiddle2, 0.0F, 0.0F, 0.0F);
        this.RoofBottom = new ModelRenderer(this, 44, 23);
        this.RoofBottom.addBox(0.0F, 0.0F, 0.0F, 16, 4, 4);
        this.RoofBottom.setRotationPoint(-8.0F, 20.0F, -8.0F);
        this.RoofBottom.setTextureSize(128, 64);
        this.RoofBottom.mirror = true;
        this.setRotation(this.RoofBottom, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.RoofTop.render(f5);
        this.RoofMiddle1.render(f5);
        this.RoofMiddle2.render(f5);
        this.RoofBottom.render(f5);
    }

    public void renderModel(float f5)
    {
        this.RoofTop.render(f5);
        this.RoofMiddle1.render(f5);
        this.RoofMiddle2.render(f5);
        this.RoofBottom.render(f5);
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
