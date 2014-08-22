package mods.jammyfurniture.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelMantlePiece extends ModelBase
{
    ModelRenderer Top;
    ModelRenderer Left;
    ModelRenderer Right;
    ModelRenderer DecoTop;

    public jfm_ModelMantlePiece()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Top = new ModelRenderer(this, 1, 8);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 24, 4, 4);
        this.Top.setRotationPoint(-12.0F, 4.0F, 4.0F);
        this.Top.setTextureSize(64, 64);
        this.Top.mirror = true;
        this.setRotation(this.Top, 0.0F, 0.0F, 0.0F);
        this.Left = new ModelRenderer(this, 1, 17);
        this.Left.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4);
        this.Left.setRotationPoint(-12.0F, 8.0F, 4.0F);
        this.Left.setTextureSize(64, 64);
        this.Left.mirror = true;
        this.setRotation(this.Left, 0.0F, 0.0F, 0.0F);
        this.Right = new ModelRenderer(this, 18, 17);
        this.Right.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4);
        this.Right.setRotationPoint(8.0F, 8.0F, 4.0F);
        this.Right.setTextureSize(64, 64);
        this.Right.mirror = true;
        this.setRotation(this.Right, 0.0F, 0.0F, 0.0F);
        this.DecoTop = new ModelRenderer(this, 1, 1);
        this.DecoTop.addBox(0.0F, 0.0F, 0.0F, 26, 1, 5);
        this.DecoTop.setRotationPoint(-13.0F, 3.0F, 3.0F);
        this.DecoTop.setTextureSize(64, 64);
        this.DecoTop.mirror = true;
        this.setRotation(this.DecoTop, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Top.render(f5);
        this.Left.render(f5);
        this.Right.render(f5);
        this.DecoTop.render(f5);
    }

    public void renderModel(float f5)
    {
        this.Top.render(f5);
        this.Left.render(f5);
        this.Right.render(f5);
        this.DecoTop.render(f5);
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
