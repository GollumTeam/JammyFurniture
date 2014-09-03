package mods.jammyfurniture.common.entities;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.IBlockUnmountEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMountableBlock extends Entity {
	public int orgBlockPosX;
	public int orgBlockPosY;
	public int orgBlockPosZ;
	public int orgBlockID;
	public EntityPlayer player;
	
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
					((IBlockUnmountEvent)block).onBlockPlacedBy(this.worldObj, this.orgBlockPosX, this.orgBlockPosY, this.orgBlockPosZ, this, this.player);
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
