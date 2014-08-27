package mods.jammyfurniture.common.block.wood;

import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.util.BlockMountable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JFWoodBlocksThree extends JFMetadataBlock {
	public static int rotation;
	private Icon jfm_blockIcon;
	
	public JFWoodBlocksThree(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityWoodBlocksThree.class, new int[] { 0, 4 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);

		if (metadata != 0 && metadata != 1 && metadata != 2 && metadata != 3) {
			if (metadata != 4 && metadata != 6) {
				if (metadata != 5 && metadata != 7) {
					if (metadata == 8) {
						this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 9) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
					} else if (metadata == 10) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
					} else if (metadata == 11) {
						this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 12) {
						this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 13) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
					} else if (metadata == 14) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
					} else if (metadata == 15) {
						this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					} else {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					}
				} else {
					this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F);
			}

			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
		} else {
			return null;
		}
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		int metadata = blockAccess.getBlockMetadata(x, y, z);

		if (metadata != 0 && metadata != 1 && metadata != 2 && metadata != 3) {
			if (metadata != 4 && metadata != 6) {
				if (metadata != 5 && metadata != 7) {
					if (metadata == 8) {
						this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 9) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
					} else if (metadata == 10) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
					} else if (metadata == 11) {
						this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 12) {
						this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
					} else if (metadata == 13) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
					} else if (metadata == 14) {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
					} else if (metadata == 15) {
						this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					} else {
						this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					}
				} else {
					this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 1.0F, 0.7F);
			}
		} else {
			this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int hitX, float hitY, float hitZ, float par9) {
		int metadata = world.getBlockMetadata(x, y, z);

		if (metadata != 0 && metadata != 1 && metadata != 2 && metadata != 3) {
			if (metadata != 4 && metadata != 5 && metadata != 6 && metadata != 7) {
				if (metadata == 8) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, 12, 2);
					return true;
				} else if (metadata == 9) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, 13, 2);
					return true;
				} else if (metadata == 10) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, 14, 2);
					return true;
				} else if (metadata == 11) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, 15, 2);
					return true;
				} else if (metadata == 12) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksOne.blockID, 9, 2);
					return true;
				} else if (metadata == 13) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksOne.blockID, 10, 2);
					return true;
				} else if (metadata == 14) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksOne.blockID, 11, 2);
					return true;
				} else if (metadata == 15) {
					world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksOne.blockID, 12, 2);
					return true;
				} else {
					return false;
				}
			} else {
				world.playSoundAtEntity(entityPlayer, "jammyfurniture:radio", 1.0F, 1.0F);
				return true;
			}
		} else if (world.isRemote) {
			return true;
		} else {
			metadata %= 4;

			if (metadata == 0) {
				entityPlayer.rotationYaw = 180.0F;
			}

			if (metadata == 1) {
				entityPlayer.rotationYaw = -90.0F;
			}

			if (metadata == 2) {
				entityPlayer.rotationYaw = 0.0F;
			}
			
			if (metadata == 3) {
				entityPlayer.rotationYaw = 90.0F;
			}

			float newX = 0.0F;
			float newY = 0.0F;
			float newZ = 0.0F;

			if (metadata == 0) {
				newX = 0.5F;
				newY = 0.4F;
				newZ = 0.5F;
			}

			if (metadata == 1) {
				newX = 0.5F;
				newY = 0.4F;
				newZ = 0.5F;
			}

			if (metadata == 2) {
				newX = 0.5F;
				newY = 0.4F;
				newZ = 0.5F;
			}

			if (metadata == 3) {
				newX = 0.5F;
				newY = 0.4F;
				newZ = 0.5F;
			}

			return BlockMountable.onBlockActivated(world, x, y, z, entityPlayer, newX, newY, newZ, 0, 0, 0, 0);
		}
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int metadata, Random random, int j) {
		return metadata >= 8 ? ModJammyFurniture.blockWoodBlocksOne.blockID : ModJammyFurniture.blockWoodBlocksThree.blockID;
	}
	
	/**
	 * Called when a user uses the creative pick block button on this block
	 * 
	 * @param target The full target the player is looking at
	 * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
	 */
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		return (metadata >= 8) ? new ItemStack (ModJammyFurniture.blockWoodBlocksOne.blockID, 1, 9) : super.getPickBlock(target, world, x, y, z);
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksThreeRenderID;
	}
}
