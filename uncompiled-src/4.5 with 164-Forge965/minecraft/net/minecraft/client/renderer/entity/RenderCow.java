package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCow extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation("textures/entity/cow/cow.png");

    public RenderCow(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getCowTextures(EntityCow par1EntityCow)
    {
        return cowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getCowTextures((EntityCow)par1Entity);
    }
}
