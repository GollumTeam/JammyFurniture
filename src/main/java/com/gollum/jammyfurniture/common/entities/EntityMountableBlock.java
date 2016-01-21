package com.gollum.jammyfurniture.common.entities;

import java.util.Iterator;
import java.util.List;

import com.gollum.jammyfurniture.common.block.IBlockUnmountEvent;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMountableBlock extends Entity {
	
	public int orgBlockPosX;
	public int orgBlockPosY;
	public int orgBlockPosZ;
	public int orgBlockID;
	public EntityPlayer player;
	
	public static boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			List listEMB = world.getEntitiesWithinAABB(EntityMountableBlock.class, AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D).expand(1.0D, 1.0D, 1.0D));
			Iterator i = listEMB.iterator();
			EntityMountableBlock mounting;
			
			do {
				if (!i.hasNext()) {
					double mountingX = (double) x + hitX;
					double mountingY = (double) y + hitY;
					double mountingZ = (double) z + hitZ;
					
					EntityMountableBlock entity = new EntityMountableBlock(world, player, x, y, z, mountingX, mountingY, mountingZ);
					world.spawnEntityInWorld(entity);
					entity.interact(player);
					return true;
				}
	
				mounting = (EntityMountableBlock) i.next();
			} while (mounting.orgBlockPosX != x || mounting.orgBlockPosY != y || mounting.orgBlockPosZ != z);
			
			mounting.interact(player);
			return true;
		} else {
			return true;
		}
	}
	
	public EntityMountableBlock(World world) {
		super(world);
		this.noClip = true;
		this.preventEntitySpawning = true;
		this.width = 0.0F;
		this.height = 0.0F;
	}

	public EntityMountableBlock(World world, double x, double y, double z) {
		super(world);
		this.noClip = true;
		this.preventEntitySpawning = true;
		this.width = 0.0F;
		this.height = 0.0F;
		this.setPosition(x, y, z);
	}
	
	public EntityMountableBlock(World world, EntityPlayer player, int x, int y, int z, double mountingX, double mountingY, double mountingZ) {
		super(world);
		this.player = player;
		this.noClip = true;
		this.preventEntitySpawning = true;
		this.width = 0.0F;
		this.height = 0.0F;
		this.orgBlockPosX = x;
		this.orgBlockPosY = y;
		this.orgBlockPosZ = z;
		this.orgBlockID = world.getBlockId(x, y, z);
		this.setPosition(mountingX, mountingY, mountingZ);
	}

	public boolean interact(EntityPlayer entityplayer) {
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityplayer) {
			return true;
		} else {
			if (!this.worldObj.isRemote) {
				entityplayer.mountEntity(this);
			}

			return true;
		}
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	public void onEntityUpdate() {
		this.worldObj.theProfiler.startSection("entityBaseTick");
		
		if (this.riddenByEntity != null && !this.riddenByEntity.isDead) {
			if (this.worldObj.getBlockId(this.orgBlockPosX, this.orgBlockPosY, this.orgBlockPosZ) != this.orgBlockID) {
				this.interact((EntityPlayer) this.riddenByEntity);
			}
		} else {
			this.setDead();
			int id = this.worldObj.getBlockId(this.orgBlockPosX, this.orgBlockPosY, this.orgBlockPosZ);
			
			if (id != 0) {
				Block block = Block.blocksList[id];
				if (block instanceof IBlockUnmountEvent) {
					((IBlockUnmountEvent)block).onBlockUnmounted(this.worldObj, this.orgBlockPosX, this.orgBlockPosY, this.orgBlockPosZ, this, this.player);
				}
			}
		}
		
		++this.ticksExisted;
		this.worldObj.theProfiler.endSection();
	}

	public void entityInit() {
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		this.orgBlockPosX = nbttagcompound.getInteger("x");
		this.orgBlockPosX = nbttagcompound.getInteger("y");
		this.orgBlockPosX = nbttagcompound.getInteger("z");
		orgBlock = Block.getBlockById(nbttagcompound.getInteger("block"));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setInteger("x", this.orgBlockPosX);
		nbttagcompound.setInteger("y", this.orgBlockPosY);
		nbttagcompound.setInteger("z", this.orgBlockPosZ);
		nbttagcompound.setInteger("block", Block.getIdFromBlock(this.orgBlock));
	}

	
}
