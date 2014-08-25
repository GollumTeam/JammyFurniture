package mods.jammyfurniture.common.block.iron;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFAMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.util.JFGuiHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JFIronBlocksOne extends JFAMetadataBlock {
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public JFIronBlocksOne(int id, String registerName) {
		super(id, registerName, Material.iron, TileEntityIronBlocksOne.class, new int[]{ 0, 4, 8, 12, 13 });
		this.tileEntityClass = TileEntityIronBlocksOne.class;
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
		
		if (metadata != 0 && metadata != 2 && metadata != 4 && metadata != 6) {
			if (metadata != 1 && metadata != 3 && metadata != 5 && metadata != 7) {
				if (metadata == 12) {
					this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
			}
		} else {
			this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
		}

		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		int metadata = blockAccess.getBlockMetadata(x, y, z);
		
		if (metadata != 0 && metadata != 2 && metadata != 4 && metadata != 6) {
			if (metadata != 1 && metadata != 3 && metadata != 5 && metadata != 7) {
				if (metadata == 12) {
					this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
			}
		} else {
			this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
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
		
		if (metadata == 0 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(player);
		int subBlock    = this.getEnabledMetadata(metadata);
		TileEntity te   = world.getBlockTileEntity(x, y, z);
		
		if (te != null && te instanceof TileEntityIronBlocksOne) {
			TileEntityIronBlocksOne teIron = (TileEntityIronBlocksOne)te;
			
			switch (subBlock) {
				
				case 0: // Le frigo
				case 4: // Le freezer
					player.openGui(ModJammyFurniture.instance, JFGuiHandler.GUI_FRIDGE, world, x, y, z);
					return true;
					
				case 8: // Le four a gateau
					
					player.openGui(ModJammyFurniture.instance, JFGuiHandler.GUI_COOKER, world, x, y, z);
					return true;
					
				case 12: // La poubelle
					
					player.openGui(ModJammyFurniture.instance, JFGuiHandler.GUI_RUBBISHBIN, world, x, y, z);
					return true;
					
				default:
					break;
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
	public void breakBlock(World world, int x, int y, int z, int oldId, int oldMetadata) {
		TileEntityIronBlocksOne te = (TileEntityIronBlocksOne) world.getBlockTileEntity(x, y, z);

		if (te != null) {
			for (int j1 = 0; j1 < te.getSizeInventory(); ++j1) {
				ItemStack itemstack = te.getStackInSlot(j1);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
						int k1 = this.random.nextInt(21) + 10;

						if (k1 > itemstack.stackSize) {
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

			world.func_96440_m(x, y, z, oldId);
		}

		super.breakBlock(world, x, y, z, oldId, oldMetadata);
	}
	
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.ironBlocksOneRenderID;
	}
	
	
}
