package mods.jammyfurniture.client.model.sofa;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelSofaRight extends ModelBase
{
    ModelRenderer ChairBase;
    ModelRenderer ChairBack;
    ModelRenderer ChairSideL;
    ModelRenderer ChairSideTopL;
    ModelRenderer Foot4;
    ModelRenderer Foot3;
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Cushion;

    public jfm_ModelSofaRight()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.ChairBase = new ModelRenderer(this, 0, 33);
        this.ChairBase.addBox(0.0F, 0.0F, 0.0F, 16, 3, 16);
        this.ChairBase.setRotationPoint(-8.0F, 19.0F, -8.0F);
        this.ChairBase.setTextureSize(128, 64);
        this.ChairBase.mirror = true;
        this.setRotation(this.ChairBase, 0.0F, 0.0F, 0.0F);
        this.ChairBack = new ModelRenderer(this, 0, 13);
        this.ChairBack.addBox(0.0F, 0.0F, 0.0F, 16, 14, 2);
        this.ChairBack.setRotationPoint(-8.0F, 5.0F, 6.0F);
        this.ChairBack.setTextureSize(128, 64);
        this.ChairBack.mirror = true;
        this.setRotation(this.ChairBack, 0.0F, 0.0F, 0.0F);
        this.ChairSideL = new ModelRenderer(this, 38, 9);
        this.ChairSideL.addBox(0.0F, 0.0F, 0.0F, 2, 6, 14);
        this.ChairSideL.setRotationPoint(6.0F, 13.0F, -8.0F);
        this.ChairSideL.setTextureSize(128, 64);
        this.ChairSideL.mirror = true;
        this.setRotation(this.ChairSideL, 0.0F, 0.0F, 0.0F);
        this.ChairSideTopL = new ModelRenderer(this, 75, 12);
        this.ChairSideTopL.addBox(0.0F, 0.0F, 0.0F, 3, 3, 14);
        this.ChairSideTopL.setRotationPoint(6.0F, 11.0F, -8.0F);
        this.ChairSideTopL.setTextureSize(128, 64);
        this.ChairSideTopL.mirror = true;
        this.setRotation(this.ChairSideTopL, 0.0F, 0.0F, 0.0F);
        this.Foot4 = new ModelRenderer(this, 0, 54);
        this.Foot4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Foot4.setRotationPoint(6.0F, 22.0F, 6.0F);
        this.Foot4.setTextureSize(128, 64);
        this.Foot4.mirror = true;
        this.setRotation(this.Foot4, 0.0F, 0.0F, 0.0F);
        this.Foot3 = new ModelRenderer(this, 0, 54);
        this.Foot3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Foot3.setRotationPoint(-8.0F, 22.0F, 6.0F);
        this.Foot3.setTextureSize(128, 64);
        this.Foot3.mirror = true;
        this.setRotation(this.Foot3, 0.0F, 0.0F, 0.0F);
        this.Foot1 = new ModelRenderer(this, 0, 54);
        this.Foot1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Foot1.setRotationPoint(-8.0F, 22.0F, -8.0F);
        this.Foot1.setTextureSize(128, 64);
        this.Foot1.mirror = true;
        this.setRotation(this.Foot1, 0.0F, 0.0F, 0.0F);
        this.Foot2 = new ModelRenderer(this, 0, 54);
        this.Foot2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Foot2.setRotationPoint(6.0F, 22.0F, -8.0F);
        this.Foot2.setTextureSize(128, 64);
        this.Foot2.mirror = true;
        this.setRotation(this.Foot2, 0.0F, 0.0F, 0.0F);
        this.Cushion = new ModelRenderer(this, 67, 35);
        this.Cushion.addBox(0.0F, 0.0F, 0.0F, 14, 3, 14);
        this.Cushion.setRotationPoint(-8.0F, 16.0F, -7.5F);
        this.Cushion.setTextureSize(128, 64);
        this.Cushion.mirror = true;
        this.setRotation(this.Cushion, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.ChairBase.render(f5);
        this.ChairBack.render(f5);
        this.ChairSideL.render(f5);
        this.ChairSideTopL.render(f5);
        this.Foot4.render(f5);
        this.Foot3.render(f5);
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Cushion.render(f5);
    }

    public void renderModel(float f5)
    {
        this.ChairBase.render(f5);
        this.ChairBack.render(f5);
        this.ChairSideL.render(f5);
        this.ChairSideTopL.render(f5);
        this.Foot4.render(f5);
        this.Foot3.render(f5);
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Cushion.render(f5);
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
