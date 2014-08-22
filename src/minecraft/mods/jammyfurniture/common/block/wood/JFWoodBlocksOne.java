package mods.jammyfurniture.common.block.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksOne;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JFWoodBlocksOne extends BlockContainer {
	private Class teClass;
	public Random random;
	private Icon jfm_blockIcon;

	public JFWoodBlocksOne(int id, int notsure, Class c) {
		super(id, Material.wood);
		this.teClass = c;
		this.random = new Random();
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int i, Random random, int j) {
		return ModJammyFurniture.blockWoodBlocksOne.blockID;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i) {
		int b = par1World.getBlockMetadata(par2, par3, i);

		if (b != 0 && b != 2) {
			if (b == 1) {
				this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
			} else if (b == 9) {
				this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
			} else if (b == 10) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
			} else if (b == 11) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
			} else if (b == 12) {
				this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else if (b != 13 && b != 14 && b != 15) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		} else {
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		}

		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, i);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		int b = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

		if (b == 0) {
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
		} else if (b != 1 && b != 2 && b != 3 && b != 4) {
			if (b != 5 && b != 6 && b != 7 && b != 8) {
				if (b == 9) {
					this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
				} else if (b == 10) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
				} else if (b == 11) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
				} else if (b == 12) {
					this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else if (b != 13 && b != 14) {
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

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
		int meta = world.getBlockMetadata(i, j, k);
		int l = (MathHelper.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

		if (meta == 1 || meta == 5 || meta == 9) {
			world.setBlockMetadataWithNotify(i, j, k, meta + l, 1);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		int l = (MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		TileEntityWoodBlocksOne teWoodBlocks;

		if (meta != 1 && meta != 2 && meta != 3 && meta != 4) {
			if (meta == 5 || meta == 6 || meta == 7 || meta == 8) {
				if (par1World.isRemote) {
					return true;
				}

				float teWoodBlocks1 = par1World.getCelestialAngle(1.0F) * 100.0F;
				int time = Math.round(teWoodBlocks1);
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
					entityplayer.addChatMessage("There are 100 hours from midday to midnight.");
					entityplayer.addChatMessage("The time resets to 0 at midday.");
					entityplayer.addChatMessage("When the time is 50, it is midnight.");
					entityplayer.addChatMessage("---- End Information ----");
				}

				return true;
			}

			if (meta == 9) {
				par1World.setBlock(par2, par3, par4, ModJammyFurniture.blockWoodBlocksThree.blockID, 8, 2);
				return true;
			}

			if (meta == 10) {
				par1World.setBlock(par2, par3, par4, ModJammyFurniture.blockWoodBlocksThree.blockID, 9, 2);
				return true;
			}

			if (meta == 11) {
				par1World.setBlock(par2, par3, par4, ModJammyFurniture.blockWoodBlocksThree.blockID, 10, 2);
				return true;
			}

			if (meta == 12) {
				par1World.setBlock(par2, par3, par4, ModJammyFurniture.blockWoodBlocksThree.blockID, 11, 2);
				return true;
			}

			if (meta == 13) {
				teWoodBlocks = (TileEntityWoodBlocksOne) par1World.getBlockTileEntity(par2, par3, par4);

				if (teWoodBlocks != null) {
					entityplayer.openGui(ModJammyFurniture.instance, 160, par1World, par2, par3, par4);
					return true;
				}
			}
		} else {
			if (itemstack != null && itemstack.getItemDamage() == 5 || itemstack != null && itemstack.getItemDamage() == 6 || itemstack != null && itemstack.getItemDamage() == 7 || itemstack != null && itemstack.getItemDamage() == 8) {
				return false;
			}

			teWoodBlocks = (TileEntityWoodBlocksOne) par1World.getBlockTileEntity(par2, par3, par4);

			if (teWoodBlocks != null) {
				entityplayer.openGui(ModJammyFurniture.instance, 151, par1World, par2, par3, par4);
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
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityWoodBlocksOne te = (TileEntityWoodBlocksOne) par1World.getBlockTileEntity(par2, par3, par4);

		if (te != null) {
			te.updateContainingBlockInfo();
		}
	}

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		TileEntityWoodBlocksOne te = (TileEntityWoodBlocksOne) par1World.getBlockTileEntity(par2, par3, par4);

		if (te != null) {
			for (int j1 = 0; j1 < te.getSizeInventory(); ++j1) {
				ItemStack itemstack = te.getStackInSlot(j1);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World.spawnEntityInWorld(entityitem)) {
						int k1 = this.random.nextInt(21) + 10;

						if (k1 > itemstack.stackSize) {
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
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

			par1World.func_96440_m(par2, par3, par4, par5);
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksOneRenderID;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World world) {
		try {
			return (TileEntity) this.teClass.newInstance();
		} catch (Exception var3) {
			throw new RuntimeException(var3);
		}
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	public void getSubBlocks(int id, CreativeTabs ctabs, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 5));
		list.add(new ItemStack(id, 1, 9));
		list.add(new ItemStack(id, 1, 13));
		list.add(new ItemStack(id, 1, 14));
		list.add(new ItemStack(id, 1, 15));
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int par1) {
		if (par1 == 2 || par1 == 3 || par1 == 4) {
			par1 = 1;
		}

		if (par1 == 10 || par1 == 11 || par1 == 12) {
			par1 = 9;
		}

		return par1;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.jfm_blockIcon = par1IconRegister.registerIcon("jammyfurniture:jammy_wood");
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	public Icon getIcon(int side, int metadata) {
		return this.jfm_blockIcon;
	}
}
