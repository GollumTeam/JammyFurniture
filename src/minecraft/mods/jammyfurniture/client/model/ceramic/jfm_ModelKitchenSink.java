package mods.jammyfurniture.client.model.ceramic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelKitchenSink extends ModelBase
{
    ModelRenderer SinkBack;
    ModelRenderer SinkFront;
    ModelRenderer SinkRight;
    ModelRenderer SinkLeft;
    ModelRenderer SinkBaseFront;
    ModelRenderer SinkBaseLeft;
    ModelRenderer SinkBaseRight;
    ModelRenderer SinkBase;
    ModelRenderer TapBase1;
    ModelRenderer TapOut1;
    ModelRenderer TapBase2;
    ModelRenderer TapOut2;
    ModelRenderer PipeDown;
    ModelRenderer PipeAcross;

    public jfm_ModelKitchenSink()
    {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.SinkBack = new ModelRenderer(this, 1, 21);
        this.SinkBack.addBox(0.0F, 0.0F, 0.0F, 16, 6, 4);
        this.SinkBack.setRotationPoint(-8.0F, 8.0F, 4.0F);
        this.SinkBack.setTextureSize(128, 32);
        this.SinkBack.mirror = true;
        this.setRotation(this.SinkBack, 0.0F, 0.0F, 0.0F);
        this.SinkFront = new ModelRenderer(this, 1, 16);
        this.SinkFront.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2);
        this.SinkFront.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.SinkFront.setTextureSize(128, 32);
        this.SinkFront.mirror = true;
        this.setRotation(this.SinkFront, 0.0F, 0.0F, 0.0F);
        this.SinkRight = new ModelRenderer(this, 43, 19);
        this.SinkRight.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10);
        this.SinkRight.setRotationPoint(6.0F, 8.0F, -6.0F);
        this.SinkRight.setTextureSize(128, 32);
        this.SinkRight.mirror = true;
        this.setRotation(this.SinkRight, 0.0F, 0.0F, 0.0F);
        this.SinkLeft = new ModelRenderer(this, 69, 19);
        this.SinkLeft.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10);
        this.SinkLeft.setRotationPoint(-8.0F, 8.0F, -6.0F);
        this.SinkLeft.setTextureSize(128, 32);
        this.SinkLeft.mirror = true;
        this.setRotation(this.SinkLeft, 0.0F, 0.0F, 0.0F);
        this.SinkBaseFront = new ModelRenderer(this, 46, 1);
        this.SinkBaseFront.addBox(0.0F, 0.0F, 0.0F, 14, 3, 1);
        this.SinkBaseFront.setRotationPoint(-7.0F, 10.0F, -7.0F);
        this.SinkBaseFront.setTextureSize(128, 32);
        this.SinkBaseFront.mirror = true;
        this.setRotation(this.SinkBaseFront, 0.0F, 0.0F, 0.0F);
        this.SinkBaseLeft = new ModelRenderer(this, 96, 2);
        this.SinkBaseLeft.addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
        this.SinkBaseLeft.setRotationPoint(-7.0F, 10.0F, -6.0F);
        this.SinkBaseLeft.setTextureSize(128, 32);
        this.SinkBaseLeft.mirror = true;
        this.setRotation(this.SinkBaseLeft, 0.0F, 0.0F, 0.0F);
        this.SinkBaseRight = new ModelRenderer(this, 1, 1);
        this.SinkBaseRight.addBox(0.0F, 0.0F, 0.0F, 1, 3, 10);
        this.SinkBaseRight.setRotationPoint(6.0F, 10.0F, -6.0F);
        this.SinkBaseRight.setTextureSize(128, 32);
        this.SinkBaseRight.mirror = true;
        this.setRotation(this.SinkBaseRight, 0.0F, 0.0F, 0.0F);
        this.SinkBase = new ModelRenderer(this, 43, 6);
        this.SinkBase.addBox(0.0F, 0.0F, 0.0F, 14, 1, 11);
        this.SinkBase.setRotationPoint(-7.0F, 13.0F, -7.0F);
        this.SinkBase.setTextureSize(128, 32);
        this.SinkBase.mirror = true;
        this.setRotation(this.SinkBase, 0.0F, 0.0F, 0.0F);
        this.TapBase1 = new ModelRenderer(this, 25, 1);
        this.TapBase1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
        this.TapBase1.setRotationPoint(-4.0F, 4.0F, 5.0F);
        this.TapBase1.setTextureSize(128, 32);
        this.TapBase1.mirror = true;
        this.setRotation(this.TapBase1, 0.0F, 0.0F, 0.0F);
        this.TapOut1 = new ModelRenderer(this, 31, 1);
        this.TapOut1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
        this.TapOut1.setRotationPoint(-4.0F, 5.0F, 2.0F);
        this.TapOut1.setTextureSize(128, 32);
        this.TapOut1.mirror = true;
        this.setRotation(this.TapOut1, 0.0F, 0.0F, 0.0F);
        this.TapBase2 = new ModelRenderer(this, 26, 8);
        this.TapBase2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
        this.TapBase2.setRotationPoint(3.0F, 4.0F, 5.0F);
        this.TapBase2.setTextureSize(128, 32);
        this.TapBase2.mirror = true;
        this.setRotation(this.TapBase2, 0.0F, 0.0F, 0.0F);
        this.TapOut2 = new ModelRenderer(this, 32, 9);
        this.TapOut2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
        this.TapOut2.setRotationPoint(3.0F, 5.0F, 2.0F);
        this.TapOut2.setTextureSize(128, 32);
        this.TapOut2.mirror = true;
        this.setRotation(this.TapOut2, 0.0F, 0.0F, 0.0F);
        this.PipeDown = new ModelRenderer(this, 96, 18);
        this.PipeDown.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.PipeDown.setRotationPoint(0.0F, 14.0F, 2.0F);
        this.PipeDown.setTextureSize(128, 32);
        this.PipeDown.mirror = true;
        this.setRotation(this.PipeDown, 0.0F, 0.0F, 0.0F);
        this.PipeAcross = new ModelRenderer(this, 96, 23);
        this.PipeAcross.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
        this.PipeAcross.setRotationPoint(0.0F, 17.0F, 2.0F);
        this.PipeAcross.setTextureSize(128, 32);
        this.PipeAcross.mirror = true;
        this.setRotation(this.PipeAcross, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.SinkBack.render(f5);
        this.SinkFront.render(f5);
        this.SinkRight.render(f5);
        this.SinkLeft.render(f5);
        this.SinkBaseFront.render(f5);
        this.SinkBaseLeft.render(f5);
        this.SinkBaseRight.render(f5);
        this.SinkBase.render(f5);
        this.TapBase1.render(f5);
        this.TapOut1.render(f5);
        this.TapBase2.render(f5);
        this.TapOut2.render(f5);
        this.PipeDown.render(f5);
        this.PipeAcross.render(f5);
    }

    public void renderModel(float f5)
    {
        this.SinkBack.render(f5);
        this.SinkFront.render(f5);
        this.SinkRight.render(f5);
        this.SinkLeft.render(f5);
        this.SinkBaseFront.render(f5);
        this.SinkBaseLeft.render(f5);
        this.SinkBaseRight.render(f5);
        this.SinkBase.render(f5);
        this.TapBase1.render(f5);
        this.TapOut1.render(f5);
        this.TapBase2.render(f5);
        this.TapOut2.render(f5);
        this.PipeDown.render(f5);
        this.PipeAcross.render(f5);
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
