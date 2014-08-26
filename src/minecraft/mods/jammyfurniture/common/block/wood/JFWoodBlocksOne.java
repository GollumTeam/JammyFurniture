package mods.jammyfurniture.common.block.wood;

import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFAMetadataBlock;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float hitX, float hitY, float hitZ) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(player);
		int subBlock    = this.getEnabledMetadata(metadata);
		
		ItemStack itemstack = player.inventory.getCurrentItem();
		TileEntityWoodBlocksOne teWoodBlocks;
		
		switch (subBlock) {
			
			case 1: // Horloge milieux
				
				// Exclu les les block horloge TODO
//				if (
//					itemstack != null && itemstack. == this.) {
//					return false;
//				}
		
				teWoodBlocks = (TileEntityWoodBlocksOne) world.getBlockTileEntity(x, y, z);
		
				if (teWoodBlocks != null) {
					player.openGui(ModJammyFurniture.instance, 151, world, x, y, z);
					return true;
				}
				break;
				
			case 5:
				
				// Clock top
				if (world.isRemote) {
					return true;
				}
				
//				float teWoodBlocks1 = world.getCelestialAngle(1.0F) * 100.0F;
//				int time = Math.round(teWoodBlocks1);
				
				int time = (int) world.getWorldTime();
				int hour = ((time / 1000)+6) % 24;
				int min = (time - (time/1000)*1000) * 60 / 1000;
				boolean am = hour < 13 && hour >= 1;
				int hour12 = hour % 12;
				hour12 = (am && hour12 == 0) ? 12 : hour12;
				
				// TODO I18N
				
				boolean hour12Format = !ModJammyFurniture.i18n.trans("clock.format").equals("24");
				
				player.addChatMessage(ModJammyFurniture.i18n.trans("clock.displayTime", (hour12Format) ? hour12 : hour, min, ModJammyFurniture.i18n.trans("clock.format."+((am)? "am" : "pm"))));
				
				String message = "";
				
				if (hour == 12) { // old 0
					message = ModJammyFurniture.i18n.trans("clock.midday");
				}

//				if (time >= 90 && time <= 10) {
//					message = "nearly midday.";
//				}
//
//				if (time >= 11 && time <= 21) {
//					message = "nearly sundown.";
//				}

				if (hour == 22) {
					message = ModJammyFurniture.i18n.trans("clock.sundown");
				}

//				if (time >= 41 && time <= 49) {
//					message = "coming up to midnight.";
//				}

				if (hour == 0) { // old 50
					message = ModJammyFurniture.i18n.trans("clock.midnight");
				}

//				if (time >= 55 && time <= 69) {
//					message = "nearly morning.";
//				}
//
//				if (time >= 70 && time <= 89) {
//					message = ModJammyFurniture.i18n.trans("jammyfurniture.clock.morning");
//				}

//				if (message != "") {
//					player.addChatMessage("It\'s " + message);
//				}

				if (itemstack != null && itemstack.itemID == Item.book.itemID) {
					player.addChatMessage(EnumChatFormatting.YELLOW + "---------------------------");
					player.addChatMessage("There are 100 hours from midday to midnight.");
					player.addChatMessage("The time resets to 0 at midday.");
					player.addChatMessage("When the time is 50, it is midnight.");
					player.addChatMessage(EnumChatFormatting.YELLOW + "---------------------------");
				}
				
				//TODO Faire un dong
				
				return true;
				
			case 9: // Le store en position initial
				world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, metadata-1, 2); // Les autres stores sont dans le block wood 3
				return true;
				
				
			case 13:
					teWoodBlocks = (TileEntityWoodBlocksOne) world.getBlockTileEntity(x, y, z);

					if (teWoodBlocks != null) {
						player.openGui(ModJammyFurniture.instance, 160, world, x, y, z);
						return true;
					}
					break;
					
			default:
				break;
		}
		
		return false;
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
