package mods.jammyfurniture.client.model.iron;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelFridge extends ModelBase
{
    ModelRenderer FridgeMain;
    ModelRenderer P7;
    ModelRenderer P1;
    ModelRenderer P9;
    ModelRenderer P8;
    ModelRenderer P11;
    ModelRenderer P6;
    ModelRenderer P4;
    ModelRenderer P5;
    ModelRenderer P10;
    ModelRenderer P3;
    ModelRenderer P2;
    public ModelRenderer Door;
    public ModelRenderer Handle;
    public ModelRenderer Handle2;

    public jfm_ModelFridge()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.FridgeMain = new ModelRenderer(this, 0, 28);
        this.FridgeMain.addBox(0.0F, 0.0F, 0.0F, 14, 16, 11);
        this.FridgeMain.setRotationPoint(-7.0F, 8.0F, -6.0F);
        this.FridgeMain.setTextureSize(64, 64);
        this.FridgeMain.mirror = true;
        this.setRotation(this.FridgeMain, 0.0F, 0.0F, 0.0F);
        this.P7 = new ModelRenderer(this, 0, 0);
        this.P7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.P7.setRotationPoint(4.0F, 16.0F, -6.5F);
        this.P7.setTextureSize(64, 64);
        this.P7.mirror = true;
        this.setRotation(this.P7, 0.0F, 0.0F, 0.0F);
        this.P1 = new ModelRenderer(this, 0, 0);
        this.P1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.P1.setRotationPoint(-5.0F, 10.0F, -6.5F);
        this.P1.setTextureSize(64, 64);
        this.P1.mirror = true;
        this.setRotation(this.P1, 0.0F, 0.0F, 0.0F);
        this.P9 = new ModelRenderer(this, 0, 0);
        this.P9.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.P9.setRotationPoint(-5.0F, 18.0F, -6.5F);
        this.P9.setTextureSize(64, 64);
        this.P9.mirror = true;
        this.setRotation(this.P9, 0.0F, 0.0F, 0.0F);
        this.P8 = new ModelRenderer(this, 0, 6);
        this.P8.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.P8.setRotationPoint(-5.0F, 17.0F, -6.5F);
        this.P8.setTextureSize(64, 64);
        this.P8.mirror = true;
        this.setRotation(this.P8, 0.0F, 0.0F, 0.0F);
        this.P11 = new ModelRenderer(this, 0, 0);
        this.P11.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.P11.setRotationPoint(4.0F, 19.0F, -6.5F);
        this.P11.setTextureSize(64, 64);
        this.P11.mirror = true;
        this.setRotation(this.P11, 0.0F, 0.0F, 0.0F);
        this.P6 = new ModelRenderer(this, 0, 6);
        this.P6.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.P6.setRotationPoint(-4.0F, 15.0F, -6.5F);
        this.P6.setTextureSize(64, 64);
        this.P6.mirror = true;
        this.setRotation(this.P6, 0.0F, 0.0F, 0.0F);
        this.P4 = new ModelRenderer(this, 0, 6);
        this.P4.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.P4.setRotationPoint(-5.0F, 13.0F, -6.5F);
        this.P4.setTextureSize(64, 64);
        this.P4.mirror = true;
        this.setRotation(this.P4, 0.0F, 0.0F, 0.0F);
        this.P5 = new ModelRenderer(this, 0, 0);
        this.P5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.P5.setRotationPoint(-5.0F, 14.0F, -6.5F);
        this.P5.setTextureSize(64, 64);
        this.P5.mirror = true;
        this.setRotation(this.P5, 0.0F, 0.0F, 0.0F);
        this.P10 = new ModelRenderer(this, 0, 6);
        this.P10.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
        this.P10.setRotationPoint(-4.0F, 19.0F, -6.5F);
        this.P10.setTextureSize(64, 64);
        this.P10.mirror = true;
        this.setRotation(this.P10, 0.0F, 0.0F, 0.0F);
        this.P3 = new ModelRenderer(this, 0, 0);
        this.P3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.P3.setRotationPoint(4.0F, 11.0F, -6.5F);
        this.P3.setTextureSize(64, 64);
        this.P3.mirror = true;
        this.setRotation(this.P3, 0.0F, 0.0F, 0.0F);
        this.P2 = new ModelRenderer(this, 0, 6);
        this.P2.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1);
        this.P2.setRotationPoint(-5.0F, 11.0F, -6.5F);
        this.P2.setTextureSize(64, 64);
        this.P2.mirror = true;
        this.setRotation(this.P2, 0.0F, 0.0F, 0.0F);
        this.Door = new ModelRenderer(this, 24, 8);
        this.Door.addBox(0.0F, 0.0F, 0.0F, 14, 16, 1);
        this.Door.setRotationPoint(-7.0F, 8.0F, 5.0F);
        this.Door.setTextureSize(64, 64);
        this.Door.mirror = true;
        this.setRotation(this.Door, 0.0F, 0.0F, 0.0F);
        this.Handle = new ModelRenderer(this, 24, 4);
        this.Handle.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
        this.Handle.setRotationPoint(3.9F, 22.9F, 5.5F);
        this.Handle.setTextureSize(64, 64);
        this.Handle.mirror = true;
        this.setRotation(this.Handle, 0.0F, 0.0F, 0.0F);
        this.Handle2 = new ModelRenderer(this, 24, 4);
        this.Handle2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
        this.Handle2.setRotationPoint(3.9F, 8.1F, 5.5F);
        this.Handle2.setTextureSize(64, 64);
        this.Handle.mirror = true;
        this.setRotation(this.Handle2, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.FridgeMain.render(f5);
        this.P7.render(f5);
        this.P1.render(f5);
        this.P9.render(f5);
        this.P8.render(f5);
        this.P11.render(f5);
        this.P6.render(f5);
        this.P4.render(f5);
        this.P5.render(f5);
        this.P10.render(f5);
        this.P3.render(f5);
        this.P2.render(f5);
        this.Door.render(f5);
        this.Handle.render(f5);
    }

    public void renderModelFridge(float f5)
    {
        this.FridgeMain.render(f5);
        this.P7.render(f5);
        this.P1.render(f5);
        this.P9.render(f5);
        this.P8.render(f5);
        this.P11.render(f5);
        this.P6.render(f5);
        this.P4.render(f5);
        this.P5.render(f5);
        this.P10.render(f5);
        this.P3.render(f5);
        this.P2.render(f5);
        this.Door.render(f5);
        this.Handle.render(f5);
    }

    public void renderModelFreezer(float f5)
    {
        this.FridgeMain.render(f5);
        this.P7.render(f5);
        this.P1.render(f5);
        this.P9.render(f5);
        this.P8.render(f5);
        this.P11.render(f5);
        this.P6.render(f5);
        this.P4.render(f5);
        this.P5.render(f5);
        this.P10.render(f5);
        this.P3.render(f5);
        this.P2.render(f5);
        this.Door.render(f5);
        this.Handle2.render(f5);
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
