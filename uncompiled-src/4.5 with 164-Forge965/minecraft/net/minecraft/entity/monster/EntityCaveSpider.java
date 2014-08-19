package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityCaveSpider extends EntitySpider
{
    public EntityCaveSpider(World par1World)
    {
        super(par1World);
        this.setSize(0.7F, 0.5F);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(12.0D);
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
        {
            if (par1Entity instanceof EntityLivingBase)
            {
                byte var2 = 0;

                if (this.worldObj.difficultySetting > 1)
                {
                    if (this.worldObj.difficultySetting == 2)
                    {
                        var2 = 7;
                    }
                    else if (this.worldObj.difficultySetting == 3)
                    {
                        var2 = 15;
                    }
                }

                if (var2 > 0)
                {
                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        return par1EntityLivingData;
    }
}
