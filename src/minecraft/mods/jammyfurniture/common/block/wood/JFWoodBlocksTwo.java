package mods.jammyfurniture.common.block.wood;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksTwo;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JFWoodBlocksTwo extends JFMetadataBlock {
	
	public JFWoodBlocksTwo(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityWoodBlocksTwo.class, new int[] { 0, 4, 8, 12, 13, 14, 15 });
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

		if (metadata != 8 && metadata != 10) {
			if (metadata != 9 && metadata != 11) {
				if (metadata == 12 || metadata == 13 || metadata == 14 || metadata == 15) {
					return null;
				}

				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.setBlockBounds(0.2F, 0.0F, 0.0F, 0.8F, 1.0F, 1.0F);
			}
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.4F, 1.0F, 1.0F, 0.8F);
		}

		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		int metadata = blockAccess.getBlockMetadata(x, y, z);

		if (metadata != 8 && metadata != 10) {
			if (metadata != 9 && metadata != 11) {
				if (metadata != 12 && metadata != 13 && metadata != 14 && metadata != 15) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.4F, 0.95F);
				}
			} else {
				this.setBlockBounds(0.2F, 0.0F, 0.0F, 0.8F, 1.0F, 1.0F);
			}
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.2F, 1.0F, 1.0F, 0.8F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int hitX, float hitY, float hitZ, float par9) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntityWoodBlocksTwo teWoodBlocksTwo;

		if (meta != 0 && meta != 1 && meta != 2 && meta != 3) {
			if (meta == 4 || meta == 5 || meta == 6 || meta == 7) {
				teWoodBlocksTwo = (TileEntityWoodBlocksTwo) world.getBlockTileEntity(x, y, z);

				if (teWoodBlocksTwo != null) {
					entityplayer.openGui(ModJammyFurniture.instance, 154, world, x, y, z);
					return true;
				}
			}
		} else {
			teWoodBlocksTwo = (TileEntityWoodBlocksTwo) world.getBlockTileEntity(x, y, z);

			if (teWoodBlocksTwo != null) {
				entityplayer.openGui(ModJammyFurniture.instance, 153, world, x, y, z);
				return true;
			}
		}

		return false;
	}

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, int oldBlodkID, int oldMetadtaID) {
		
		this.helper.breakBlockInventory(world, x, y, z, oldBlodkID);
		
		super.breakBlock(world, x, y, z, oldBlodkID, oldMetadtaID);
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksTwoRenderID;
	}
}
