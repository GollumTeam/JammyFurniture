package net.minecraft.jammy780.furniture.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMountableBlock extends Entity
{
    protected int orgBlockPosX;
    protected int orgBlockPosY;
    protected int orgBlockPosZ;
    protected int orgBlockID;

    public EntityMountableBlock(World world)
    {
        super(world);
        this.noClip = true;
        this.preventEntitySpawning = true;
        this.width = 0.0F;
        this.height = 0.0F;
    }

    public EntityMountableBlock(World world, double d, double d1, double d2)
    {
        super(world);
        this.noClip = true;
        this.preventEntitySpawning = true;
        this.width = 0.0F;
        this.height = 0.0F;
        this.setPosition(d, d1, d2);
    }

    public EntityMountableBlock(World world, EntityPlayer entityplayer, int i, int j, int k, float mountingX, float mountingY, float mountingZ)
    {
        super(world);
        this.noClip = true;
        this.preventEntitySpawning = true;
        this.width = 0.0F;
        this.height = 0.0F;
        this.orgBlockPosX = i;
        this.orgBlockPosY = j;
        this.orgBlockPosZ = k;
        this.orgBlockID = world.getBlockId(i, j, k);
        this.setPosition((double)mountingX, (double)mountingY, (double)mountingZ);
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityplayer)
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                entityplayer.mountEntity(this);
            }

            return true;
        }
    }

    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
        this.worldObj.theProfiler.startSection("entityBaseTick");

        if (this.riddenByEntity != null && !this.riddenByEntity.isDead)
        {
            if (this.worldObj.getBlockId(this.orgBlockPosX, this.orgBlockPosY, this.orgBlockPosZ) != this.orgBlockID)
            {
                this.interact((EntityPlayer)this.riddenByEntity);
            }
        }
        else
        {
            this.setDead();
        }

        ++this.ticksExisted;
        this.worldObj.theProfiler.endSection();
    }

    public void entityInit() {}

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {}
}
