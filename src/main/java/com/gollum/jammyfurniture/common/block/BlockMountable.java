package com.gollum.jammyfurniture.common.block;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;

public class BlockMountable/* extends Block*/ {
//	public BlockMountable(int x, Material material) {
//		super(x, material);
//	}
//
//	public BlockMountable(int x, int y, Material material) {
//		super(x, material);
//	}
//
//	/**
//	 * Called upon block activation (right click on the block.)
//	 */
//	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
//		return onBlockActivated(world, x, y, z, player, 0.5F, 1.0F, 0.5F, 0, 0, 0, 0);
//	}

	public static boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, float f) {
		return onBlockActivated(world, x, y, z, player, 0.5F, f, 0.5F, 0, 0, 0, 0);
	}

	public static boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, float hitX, float hitY, float hitZ, int north, int south, int east, int west) {
		if (!world.isRemote) {
			List listEMB = world.getEntitiesWithinAABB(EntityMountableBlock.class, AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D).expand(1.0D, 1.0D, 1.0D));
			Iterator i = listEMB.iterator();
			EntityMountableBlock mounting;
			
			do {
				if (!i.hasNext()) {
					double mountingX = (double) x + hitX;
					double mountingY = (double) y + hitY;
					double mountingZ = (double) z + hitZ;

					if (north != south) {
						int netadata = world.getBlockMetadata(x, y, z);

						if (netadata == east) {
							mountingX = (double) (x + 1) - hitZ;
							mountingZ = (double) z + hitX;
						} else if (netadata == south) {
							mountingX = (double) (x + 1) - hitX;
							mountingZ = (double) (z + 1) - hitZ;
						} else if (netadata == west) {
							mountingX = (double) x + hitZ;
							mountingZ = (double) (z + 1) - hitX;
						}
					}

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
}
