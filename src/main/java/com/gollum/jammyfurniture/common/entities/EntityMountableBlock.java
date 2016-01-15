package com.gollum.jammyfurniture.common.entities;

import com.gollum.jammyfurniture.common.block.IBlockUnmountEvent;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityMountableBlock extends Entity {
	public BlockPos orgBlockPos;
	public Block orgBlock;
	public EntityPlayer player;
	
	public EntityMountableBlock(World world) {
		super(world);
		this.noClip = true;
		this.preventEntitySpawning = true;
		this.width = 0.0F;
		this.height = 0.0F;
	}
	
	public EntityMountableBlock(World world, EntityPlayer player, BlockPos pos, double mountingX, double mountingY, double mountingZ) {
		super(world);
		this.player = player;
		this.noClip = true;
		this.preventEntitySpawning = true;
		this.width = 0.0F;
		this.height = 0.0F;
		this.orgBlockPos = pos;
		this.orgBlock = world.getBlockState(pos).getBlock();
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
			if (this.worldObj.getBlockState(this.orgBlockPos).getBlock() != this.orgBlock) {
				this.interact((EntityPlayer) this.riddenByEntity);
			}
		} else {
			this.setDead();
			Block block = this.worldObj.getBlockState(this.orgBlockPos).getBlock();
			
			if (block != null) {
				if (block instanceof IBlockUnmountEvent) {
					((IBlockUnmountEvent)block).onBlockPlacedBy(this.worldObj, this.orgBlockPos.getX(), this.orgBlockPos.getY(), this.orgBlockPos.getZ(), this, this.player);
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
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
	}
}
