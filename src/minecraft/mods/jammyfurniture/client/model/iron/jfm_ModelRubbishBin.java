package mods.jammyfurniture.client.model.iron;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelRubbishBin extends ModelBase
{
    ModelRenderer BinLid;
    ModelRenderer BinBase;
    ModelRenderer HandleP1;
    ModelRenderer HandleP2;
    ModelRenderer HandleP3;

    public jfm_ModelRubbishBin()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.BinLid = new ModelRenderer(this, 0, 28);
        this.BinLid.addBox(0.0F, 0.0F, 0.0F, 14, 2, 14);
        this.BinLid.setRotationPoint(-7.0F, 8.0F, -7.0F);
        this.BinLid.setTextureSize(64, 64);
        this.BinLid.mirror = true;
        this.setRotation(this.BinLid, 0.0F, 0.0F, 0.0F);
        this.BinBase = new ModelRenderer(this, 0, 0);
        this.BinBase.addBox(0.0F, 0.0F, 0.0F, 12, 14, 12);
        this.BinBase.setRotationPoint(-6.0F, 10.0F, -6.0F);
        this.BinBase.setTextureSize(64, 64);
        this.BinBase.mirror = true;
        this.setRotation(this.BinBase, 0.0F, 0.0F, 0.0F);
        this.HandleP1 = new ModelRenderer(this, 0, 46);
        this.HandleP1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.HandleP1.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.HandleP1.setTextureSize(64, 64);
        this.HandleP1.mirror = true;
        this.setRotation(this.HandleP1, 0.0F, 0.0F, 0.0F);
        this.HandleP2 = new ModelRenderer(this, 6, 46);
        this.HandleP2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
        this.HandleP2.setRotationPoint(0.0F, 6.0F, -3.0F);
        this.HandleP2.setTextureSize(64, 64);
        this.HandleP2.mirror = true;
        this.setRotation(this.HandleP2, 0.0F, 0.0F, 0.0F);
        this.HandleP3 = new ModelRenderer(this, 0, 46);
        this.HandleP3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.HandleP3.setRotationPoint(0.0F, 7.0F, -3.0F);
        this.HandleP3.setTextureSize(64, 64);
        this.HandleP3.mirror = true;
        this.setRotation(this.HandleP3, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BinLid.render(f5);
        this.BinBase.render(f5);
        this.HandleP1.render(f5);
        this.HandleP2.render(f5);
        this.HandleP3.render(f5);
    }

    public void renderModel(float f5)
    {
        this.BinLid.render(f5);
        this.BinBase.render(f5);
        this.HandleP1.render(f5);
        this.HandleP2.render(f5);
        this.HandleP3.render(f5);
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
