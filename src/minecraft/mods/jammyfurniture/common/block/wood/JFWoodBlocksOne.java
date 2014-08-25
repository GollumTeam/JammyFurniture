package mods.jammyfurniture.common.block.wood;

import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFAMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksOne;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JFWoodBlocksOne extends JFAMetadataBlock {
	
	public JFWoodBlocksOne(int id, String registerName) {
		super(id, registerName, Material.wood, TileEntityWoodBlocksOne.class, new int[] { 0, 1, 5, 9, 13, 14, 15 });
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
		
		if (metadata != 0 && metadata != 2) {
			if (metadata == 1) {
				this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
			} else if (metadata == 9) {
				this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
			} else if (metadata == 10) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
			} else if (metadata == 11) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
			} else if (metadata == 12) {
				this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else if (metadata != 13 && metadata != 14 && metadata != 15) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		} else {
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		}

		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		
		int metadata = blockAccess.getBlockMetadata(x, y, z);

		if (metadata == 0) {
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		} else if (metadata != 1 && metadata != 2 && metadata != 3 && metadata != 4) {
			if (metadata != 5 && metadata != 6 && metadata != 7 && metadata != 8) {
				if (metadata == 9) {
					this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
				} else if (metadata == 10) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
				} else if (metadata == 11) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
				} else if (metadata == 12) {
					this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else if (metadata != 13 && metadata != 14) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
			}
		} else {
			this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
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

		if (metadata == 1 || metadata == 5 || metadata == 9) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float entityX, float entityY, float entityZ) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityplayer);
		
		
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		TileEntityWoodBlocksOne teWoodBlocks;

		if (metadata != 1 && metadata != 2 && metadata != 3 && metadata != 4) {
			if (metadata == 5 || metadata == 6 || metadata == 7 || metadata == 8) {
				if (world.isRemote) {
					return true;
				}

				float teWoodBlocks1 = world.getCelestialAngle(1.0F) * 100.0F;
				int time = Math.round(teWoodBlocks1);
				
				// TODO I18N
				
				String message = "";
				
				if (time == 0) {
					message = "midday.";
				}

				if (time >= 90 && time <= 10) {
					message = "nearly midday.";
				}

				if (time >= 11 && time <= 21) {
					message = "nearly sundown.";
				}

				if (time == 22) {
					message = "sundown.";
				}

				if (time >= 41 && time <= 49) {
					message = "coming up to midnight.";
				}

				if (time == 50) {
					message = "midnight, I wouldn\'t go outside if I were you!";
				}

				if (time >= 55 && time <= 69) {
					message = "nearly morning.";
				}

				if (time >= 70 && time <= 89) {
					message = "morning.";
				}

				if (message != "") {
					entityplayer.addChatMessage("The Time is currently: " + time);
					entityplayer.addChatMessage("It\'s " + message);
				} else {
					entityplayer.addChatMessage("The Time is currently: " + time);
				}

				if (itemstack != null && itemstack.itemID == Item.book.itemID) {
					entityplayer.addChatMessage("---- Information ----");
					entityplayer
							.addChatMessage("There are 100 hours from midday to midnight.");
					entityplayer
							.addChatMessage("The time resets to 0 at midday.");
					entityplayer
							.addChatMessage("When the time is 50, it is midnight.");
					entityplayer.addChatMessage("---- End Information ----");
				}

				return true;
			}

			if (metadata == 9) {
				world.setBlock(x, y, z,
						ModJammyFurniture.blockWoodBlocksThree.blockID, 8, 2);
				return true;
			}

			if (metadata == 10) {
				world.setBlock(x, y, z,
						ModJammyFurniture.blockWoodBlocksThree.blockID, 9, 2);
				return true;
			}

			if (metadata == 11) {
				world.setBlock(x, y, z,
						ModJammyFurniture.blockWoodBlocksThree.blockID, 10, 2);
				return true;
			}

			if (metadata == 12) {
				world.setBlock(x, y, z,
						ModJammyFurniture.blockWoodBlocksThree.blockID, 11, 2);
				return true;
			}

			if (metadata == 13) {
				teWoodBlocks = (TileEntityWoodBlocksOne) world
						.getBlockTileEntity(x, y, z);

				if (teWoodBlocks != null) {
					entityplayer.openGui(ModJammyFurniture.instance, 160,
							world, x, y, z);
					return true;
				}
			}
		} else {
			if (itemstack != null && itemstack.getItemDamage() == 5
					|| itemstack != null && itemstack.getItemDamage() == 6
					|| itemstack != null && itemstack.getItemDamage() == 7
					|| itemstack != null && itemstack.getItemDamage() == 8) {
				return false;
			}

			teWoodBlocks = (TileEntityWoodBlocksOne) world.getBlockTileEntity(
					x, y, z);

			if (teWoodBlocks != null) {
				entityplayer.openGui(ModJammyFurniture.instance, 151,
						world, x, y, z);
				return true;
			}
		}

		return true;
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World World, int x, int y, int z, int par5) {
		super.onNeighborBlockChange(World, x, y, z, par5);
		
		TileEntityWoodBlocksOne titleEntity = (TileEntityWoodBlocksOne) World.getBlockTileEntity(x, y, z);

		if (titleEntity != null) {
			titleEntity.updateContainingBlockInfo();
		}
	}

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		TileEntityWoodBlocksOne te = (TileEntityWoodBlocksOne) world.getBlockTileEntity(x, y, z);

		if (te != null) {
			for (int i = 0; i < te.getSizeInventory(); ++i) {
				ItemStack itemstack = te.getStackInSlot(i);

				if (itemstack != null) {
					float f  = this.random.nextFloat() * 0.8F + 0.1F;
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

			world.func_96440_m(x, y, z, par5);
		}

		super.breakBlock(world, x, y, z, par5, par6);
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksOneRenderID;
	}

}
