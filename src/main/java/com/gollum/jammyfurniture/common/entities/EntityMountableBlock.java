package com.gollum.jammyfurniture.common.entities;

import java.util.Iterator;
import java.util.List;

import com.gollum.jammyfurniture.common.block.IBlockUnmountEvent;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EntityMountableBlock extends Entity {
	public BlockPos orgBlockPos;
	public Block orgBlock;
	public EntityPlayer player;
	
	public static boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			List listEMB = world.getEntitiesWithinAABB(EntityMountableBlock.class, AxisAlignedBB.fromBounds ((double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), (double) pos.getZ() + 1.0D, (double) pos.getY() + 1.0D, (double) pos.getZ() + 1.0D).expand(1.0D, 1.0D, 1.0D));
			Iterator i = listEMB.iterator();
			EntityMountableBlock mounting;
			
			do {
				if (!i.hasNext()) {
					double mountingX = (double) pos.getX() + hitX;
					double mountingY = (double) pos.getY() + hitY;
					double mountingZ = (double) pos.getZ() + hitZ;
					
					EntityMountableBlock entity = new EntityMountableBlock(world, player, pos, mountingX, mountingY, mountingZ);
					world.spawnEntityInWorld(entity);
					entity.interact(player);
					return true;
				}

				mounting = (EntityMountableBlock) i.next();
			} while (mounting.orgBlockPos.equals(pos));
			
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
		
		if (this.orgBlockPos != null) {
			
			if (this.riddenByEntity != null && !this.riddenByEntity.isDead) {
				IBlockState state =  this.worldObj.getBlockState(this.orgBlockPos);
				if (state!= null && state.getBlock() != this.orgBlock) {
					this.interact((EntityPlayer) this.riddenByEntity);
				}
			} else {
				this.setDead();
				Block block = this.worldObj.getBlockState(this.orgBlockPos).getBlock();
				
				if (block != null) {
					if (block instanceof IBlockUnmountEvent) {
						((IBlockUnmountEvent)block).onBlockUnmounted(this.worldObj, this.orgBlockPos.getX(), this.orgBlockPos.getY(), this.orgBlockPos.getZ(), this, this.player);
					}
				}
			}
		}
		
		++this.ticksExisted;
		this.worldObj.theProfiler.endSection();
	}

	public void entityInit() {
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		this.orgBlockPos = new BlockPos(
			nbttagcompound.getInteger("x"),
			nbttagcompound.getInteger("y"),
			nbttagcompound.getInteger("z")
		);
		orgBlock = Block.getBlockById(nbttagcompound.getInteger("block"));
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setInteger("x", this.orgBlockPos.getX());
		nbttagcompound.setInteger("y", this.orgBlockPos.getY());
		nbttagcompound.setInteger("z", this.orgBlockPos.getZ());
		nbttagcompound.setInteger("block", Block.getIdFromBlock(this.orgBlock));
	}
}
