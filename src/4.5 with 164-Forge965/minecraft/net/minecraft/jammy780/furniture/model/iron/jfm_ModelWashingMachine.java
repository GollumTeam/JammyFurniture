package net.minecraft.jammy780.furniture.model.iron;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelWashingMachine extends ModelBase
{
    ModelRenderer Base;
    ModelRenderer DoorMain;
    ModelRenderer DoorBottom;
    ModelRenderer DoorTop;
    ModelRenderer DoorLeft;
    ModelRenderer DoorRight;
    ModelRenderer Button3;
    ModelRenderer Button1;
    ModelRenderer Button2;

    public jfm_ModelWashingMachine()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Base = new ModelRenderer(this, 0, 25);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
        this.Base.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.Base.setTextureSize(64, 64);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
        this.DoorMain = new ModelRenderer(this, 1, 12);
        this.DoorMain.addBox(0.0F, 0.0F, 0.0F, 8, 8, 1);
        this.DoorMain.setRotationPoint(-4.0F, 13.0F, -9.0F);
        this.DoorMain.setTextureSize(64, 64);
        this.DoorMain.mirror = true;
        this.setRotation(this.DoorMain, 0.0F, 0.0F, 0.0F);
        this.DoorBottom = new ModelRenderer(this, 1, 9);
        this.DoorBottom.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
        this.DoorBottom.setRotationPoint(-3.0F, 21.0F, -9.0F);
        this.DoorBottom.setTextureSize(64, 64);
        this.DoorBottom.mirror = true;
        this.setRotation(this.DoorBottom, 0.0F, 0.0F, 0.0F);
        this.DoorTop = new ModelRenderer(this, 20, 12);
        this.DoorTop.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
        this.DoorTop.setRotationPoint(-3.0F, 12.0F, -9.0F);
        this.DoorTop.setTextureSize(64, 64);
        this.DoorTop.mirror = true;
        this.setRotation(this.DoorTop, 0.0F, 0.0F, 0.0F);
        this.DoorLeft = new ModelRenderer(this, 11, 0);
        this.DoorLeft.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
        this.DoorLeft.setRotationPoint(-5.0F, 14.0F, -9.0F);
        this.DoorLeft.setTextureSize(64, 64);
        this.DoorLeft.mirror = true;
        this.setRotation(this.DoorLeft, 0.0F, 0.0F, 0.0F);
        this.DoorRight = new ModelRenderer(this, 6, 0);
        this.DoorRight.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
        this.DoorRight.setRotationPoint(4.0F, 14.0F, -9.0F);
        this.DoorRight.setTextureSize(64, 64);
        this.DoorRight.mirror = true;
        this.setRotation(this.DoorRight, 0.0F, 0.0F, 0.0F);
        this.Button3 = new ModelRenderer(this, 1, 6);
        this.Button3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Button3.setRotationPoint(4.0F, 9.0F, -9.0F);
        this.Button3.setTextureSize(64, 64);
        this.Button3.mirror = true;
        this.setRotation(this.Button3, 0.0F, 0.0F, 0.0F);
        this.Button1 = new ModelRenderer(this, 1, 0);
        this.Button1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Button1.setRotationPoint(-6.0F, 9.0F, -9.0F);
        this.Button1.setTextureSize(64, 64);
        this.Button1.mirror = true;
        this.setRotation(this.Button1, 0.0F, 0.0F, 0.0F);
        this.Button2 = new ModelRenderer(this, 1, 3);
        this.Button2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Button2.setRotationPoint(-4.0F, 9.0F, -9.0F);
        this.Button2.setTextureSize(64, 64);
        this.Button2.mirror = true;
        this.setRotation(this.Button2, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Base.render(f5);
        this.DoorMain.render(f5);
        this.DoorBottom.render(f5);
        this.DoorTop.render(f5);
        this.DoorLeft.render(f5);
        this.DoorRight.render(f5);
        this.Button3.render(f5);
        this.Button1.render(f5);
        this.Button2.render(f5);
    }

    public void renderModel(float f5)
    {
        this.Base.render(f5);
        this.DoorMain.render(f5);
        this.DoorBottom.render(f5);
        this.DoorTop.render(f5);
        this.DoorLeft.render(f5);
        this.DoorRight.render(f5);
        this.Button3.render(f5);
        this.Button1.render(f5);
        this.Button2.render(f5);
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
