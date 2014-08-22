package mods.jammyfurniture.client.model.iron;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class jfm_ModelCooker extends ModelBase
{
    ModelRenderer CookerBase;
    ModelRenderer CookerRing1;
    ModelRenderer CookerRing2;
    ModelRenderer CookerRing3;
    ModelRenderer CookerRing4;
    ModelRenderer CookerDoor;
    ModelRenderer CookerHandle;
    ModelRenderer CookerDoor2;
    ModelRenderer CookerHandle2;

    public jfm_ModelCooker()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.CookerBase = new ModelRenderer(this, 0, 31);
        this.CookerBase.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
        this.CookerBase.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.CookerBase.setTextureSize(128, 128);
        this.CookerBase.mirror = true;
        this.setRotation(this.CookerBase, 0.0F, 0.0F, 0.0F);
        this.CookerRing1 = new ModelRenderer(this, 0, 0);
        this.CookerRing1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
        this.CookerRing1.setRotationPoint(-6.0F, 7.0F, -6.0F);
        this.CookerRing1.setTextureSize(128, 128);
        this.CookerRing1.mirror = true;
        this.setRotation(this.CookerRing1, 0.0F, 0.0F, 0.0F);
        this.CookerRing2 = new ModelRenderer(this, 17, 0);
        this.CookerRing2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
        this.CookerRing2.setRotationPoint(-6.0F, 7.0F, 2.0F);
        this.CookerRing2.setTextureSize(128, 128);
        this.CookerRing2.mirror = true;
        this.setRotation(this.CookerRing2, 0.0F, 0.0F, 0.0F);
        this.CookerRing3 = new ModelRenderer(this, 0, 6);
        this.CookerRing3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
        this.CookerRing3.setRotationPoint(2.0F, 7.0F, 2.0F);
        this.CookerRing3.setTextureSize(128, 128);
        this.CookerRing3.mirror = true;
        this.setRotation(this.CookerRing3, 0.0F, 0.0F, 0.0F);
        this.CookerRing4 = new ModelRenderer(this, 17, 6);
        this.CookerRing4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
        this.CookerRing4.setRotationPoint(2.0F, 7.0F, -6.0F);
        this.CookerRing4.setTextureSize(128, 128);
        this.CookerRing4.mirror = true;
        this.setRotation(this.CookerRing4, 0.0F, 0.0F, 0.0F);
        this.CookerDoor = new ModelRenderer(this, 0, 12);
        this.CookerDoor.addBox(0.0F, 0.0F, 0.0F, 12, 5, 1);
        this.CookerDoor.setRotationPoint(-6.0F, 9.0F, -9.0F);
        this.CookerDoor.setTextureSize(128, 128);
        this.CookerDoor.mirror = true;
        this.setRotation(this.CookerDoor, 0.0F, 0.0F, 0.0F);
        this.CookerHandle = new ModelRenderer(this, 29, 12);
        this.CookerHandle.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.CookerHandle.setRotationPoint(4.0F, 10.0F, -10.0F);
        this.CookerHandle.setTextureSize(128, 128);
        this.CookerHandle.mirror = true;
        this.setRotation(this.CookerHandle, 0.0F, 0.0F, 0.0F);
        this.CookerDoor2 = new ModelRenderer(this, 0, 20);
        this.CookerDoor2.addBox(0.0F, 0.0F, 0.0F, 12, 8, 1);
        this.CookerDoor2.setRotationPoint(-6.0F, 15.0F, -9.0F);
        this.CookerDoor2.setTextureSize(128, 128);
        this.CookerDoor2.mirror = true;
        this.setRotation(this.CookerDoor2, 0.0F, 0.0F, 0.0F);
        this.CookerHandle2 = new ModelRenderer(this, 29, 20);
        this.CookerHandle2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
        this.CookerHandle2.setRotationPoint(4.0F, 16.0F, -10.0F);
        this.CookerHandle2.setTextureSize(128, 128);
        this.CookerHandle2.mirror = true;
        this.setRotation(this.CookerHandle2, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.CookerBase.render(f5);
        this.CookerRing1.render(f5);
        this.CookerRing2.render(f5);
        this.CookerRing3.render(f5);
        this.CookerRing4.render(f5);
        this.CookerDoor.render(f5);
        this.CookerHandle.render(f5);
        this.CookerDoor2.render(f5);
        this.CookerHandle2.render(f5);
    }

    public void renderModel(float f5)
    {
        this.CookerBase.render(f5);
        this.CookerRing1.render(f5);
        this.CookerRing2.render(f5);
        this.CookerRing3.render(f5);
        this.CookerRing4.render(f5);
        this.CookerDoor.render(f5);
        this.CookerHandle.render(f5);
        this.CookerDoor2.render(f5);
        this.CookerHandle2.render(f5);
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
