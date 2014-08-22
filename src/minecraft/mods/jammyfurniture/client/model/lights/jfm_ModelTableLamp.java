package mods.jammyfurniture.client.model.lights;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelTableLamp extends ModelBase
{
    ModelRenderer Base;
    ModelRenderer BaseProp;
    ModelRenderer ShadeSide1;
    ModelRenderer ShadeSide2;
    ModelRenderer ShadeSide3;
    ModelRenderer ShadeSide4;
    ModelRenderer Bulb;

    public jfm_ModelTableLamp()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Base = new ModelRenderer(this, 1, 9);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Base.setRotationPoint(-3.0F, 23.0F, -3.0F);
        this.Base.setTextureSize(64, 64);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
        this.BaseProp = new ModelRenderer(this, 1, 1);
        this.BaseProp.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
        this.BaseProp.setRotationPoint(-1.0F, 18.0F, -1.0F);
        this.BaseProp.setTextureSize(64, 64);
        this.BaseProp.mirror = true;
        this.setRotation(this.BaseProp, 0.0F, 0.0F, 0.0F);
        this.ShadeSide1 = new ModelRenderer(this, 26, 2);
        this.ShadeSide1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 6);
        this.ShadeSide1.setRotationPoint(-3.0F, 10.0F, -3.0F);
        this.ShadeSide1.setTextureSize(64, 64);
        this.ShadeSide1.mirror = true;
        this.setRotation(this.ShadeSide1, 0.0F, 0.0F, 0.0F);
        this.ShadeSide2 = new ModelRenderer(this, 2, 17);
        this.ShadeSide2.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
        this.ShadeSide2.setRotationPoint(-2.0F, 10.0F, 2.0F);
        this.ShadeSide2.setTextureSize(64, 64);
        this.ShadeSide2.mirror = true;
        this.setRotation(this.ShadeSide2, 0.0F, 0.0F, 0.0F);
        this.ShadeSide3 = new ModelRenderer(this, 13, 18);
        this.ShadeSide3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 6);
        this.ShadeSide3.setRotationPoint(2.0F, 10.0F, -3.0F);
        this.ShadeSide3.setTextureSize(64, 64);
        this.ShadeSide3.mirror = true;
        this.setRotation(this.ShadeSide3, 0.0F, 0.0F, 0.0F);
        this.ShadeSide4 = new ModelRenderer(this, 28, 19);
        this.ShadeSide4.addBox(0.0F, 0.0F, 0.0F, 4, 8, 1);
        this.ShadeSide4.setRotationPoint(-2.0F, 10.0F, -3.0F);
        this.ShadeSide4.setTextureSize(64, 64);
        this.ShadeSide4.mirror = true;
        this.setRotation(this.ShadeSide4, 0.0F, 0.0F, 0.0F);
        this.Bulb = new ModelRenderer(this, 10, 2);
        this.Bulb.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
        this.Bulb.setRotationPoint(-1.0F, 14.0F, -1.0F);
        this.Bulb.setTextureSize(64, 64);
        this.Bulb.mirror = true;
        this.setRotation(this.Bulb, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Base.render(f5);
        this.BaseProp.render(f5);
        this.ShadeSide1.render(f5);
        this.ShadeSide2.render(f5);
        this.ShadeSide3.render(f5);
        this.ShadeSide4.render(f5);
        this.Bulb.render(f5);
    }

    public void renderModel(float f5)
    {
        this.Base.render(f5);
        this.BaseProp.render(f5);
        this.ShadeSide1.render(f5);
        this.ShadeSide2.render(f5);
        this.ShadeSide3.render(f5);
        this.ShadeSide4.render(f5);
        this.Bulb.render(f5);
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
