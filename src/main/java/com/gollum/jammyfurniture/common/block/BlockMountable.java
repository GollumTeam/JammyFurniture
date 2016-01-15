package com.gollum.jammyfurniture.common.block;

import java.util.Iterator;
import java.util.List;

import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockMountable {
	
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

//					if (north != south) {
//						int netadata = world.getBlockMetadata(x, y, z);
//
//						if (netadata == east) {
//							mountingX = (double) (x + 1) - hitZ;
//							mountingZ = (double) z + hitX;
//						} else if (netadata == south) {
//							mountingX = (double) (x + 1) - hitX;
//							mountingZ = (double) (z + 1) - hitZ;
//						} else if (netadata == west) {
//							mountingX = (double) x + hitZ;
//							mountingZ = (double) (z + 1) - hitX;
//						}
//					}
					
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
}
