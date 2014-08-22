package net.minecraft.jammy780.furniture.model.heads;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelChickenHead extends ModelBase
{
    ModelRenderer head;
    ModelRenderer bill;
    ModelRenderer chin;

    public jfm_ModelChickenHead()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(0.0F, 0.0F, 0.0F, 4, 6, 3);
        this.head.setRotationPoint(-2.0F, 12.0F, 5.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.bill = new ModelRenderer(this, 16, 0);
        this.bill.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        this.bill.setRotationPoint(-2.0F, 14.0F, 3.0F);
        this.bill.setTextureSize(64, 32);
        this.bill.mirror = true;
        this.setRotation(this.bill, 0.0F, 0.0F, 0.0F);
        this.chin = new ModelRenderer(this, 17, 5);
        this.chin.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.chin.setRotationPoint(-1.0F, 16.0F, 3.0F);
        this.chin.setTextureSize(64, 32);
        this.chin.mirror = true;
        this.setRotation(this.chin, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.bill.render(f5);
        this.chin.render(f5);
    }

    public void renderModel(float f5)
    {
        this.head.render(f5);
        this.bill.render(f5);
        this.chin.render(f5);
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
