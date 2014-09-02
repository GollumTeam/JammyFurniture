package mods.jammyfurniture.common.block;

import java.util.Iterator;
import java.util.List;

import mods.jammyfurniture.common.entities.EntityMountableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMountable extends Block {
	public BlockMountable(int x, Material material) {
		super(x, material);
	}

	public BlockMountable(int x, int y, Material material) {
		super(x, material);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 1.0F, 0.5F, 0, 0, 0, 0);
	}

	public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float y) {
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, y, 0.5F, 0, 0, 0, 0);
	}

	public static boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, float hitX, float hitY, float hitZ, int north, int south, int east, int west) {
		if (!world.isRemote) {
			List listEMB = world.getEntitiesWithinAABB(EntityMountableBlock.class, AxisAlignedBB.getBoundingBox((double) x, (double) y, (double) z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D).expand(1.0D, 1.0D, 1.0D));
			Iterator i = listEMB.iterator();
			EntityMountableBlock mounting;
			
			do {
				if (!i.hasNext()) {
					float mountingX = (float) x + hitX;
					float mountingY = (float) y + hitY;
					float mountingZ = (float) z + hitZ;

					if (north != south) {
						int netadata = world.getBlockMetadata(x, y, z);

						if (netadata == east) {
							mountingX = (float) (x + 1) - hitZ;
							mountingZ = (float) z + hitX;
						} else if (netadata == south) {
							mountingX = (float) (x + 1) - hitX;
							mountingZ = (float) (z + 1) - hitZ;
						} else if (netadata == west) {
							mountingX = (float) x + hitZ;
							mountingZ = (float) (z + 1) - hitX;
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
