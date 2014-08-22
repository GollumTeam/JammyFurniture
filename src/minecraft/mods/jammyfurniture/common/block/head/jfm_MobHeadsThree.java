package mods.jammyfurniture.common.block.head;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.JammyFurnitureModCore;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsThree;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jfm_MobHeadsThree extends BlockContainer {
	private Icon jfm_blockIcon;

	public jfm_MobHeadsThree(int id, int notsure, Class teClass) {
		super(id, Material.cloth);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int i, Random random, int j) {
		return JammyFurnitureModCore.mobHeadsThree.blockID;
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
		int meta = world.getBlockMetadata(i, j, k);
		int l = (MathHelper.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

		if (meta == 0 || meta == 4 || meta == 8 || meta == 12) {
			world.setBlockMetadataWithNotify(i, j, k, meta + l, 0);
		}
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i) {
		int b = par1World.getBlockMetadata(par2, par3, i);

		if (b == 0) {
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
		} else if (b == 1) {
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		} else if (b == 2) {
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
		} else if (b == 3) {
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else if (b == 4) {
			this.setBlockBounds(0.3F, 0.25F, 0.55F, 0.7F, 0.75F, 1.0F);
		} else if (b == 5) {
			this.setBlockBounds(0.0F, 0.25F, 0.3F, 0.45F, 0.75F, 0.7F);
		} else if (b == 6) {
			this.setBlockBounds(0.3F, 0.25F, 0.0F, 0.7F, 0.75F, 0.45F);
		} else if (b == 7) {
			this.setBlockBounds(0.55F, 0.25F, 0.3F, 1.0F, 0.75F, 0.7F);
		} else if (b == 8) {
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
		} else if (b == 9) {
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		} else if (b == 10) {
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
		} else if (b == 11) {
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else if (b == 12) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 13) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 14) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 15) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
		} else if (b == 1) {
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		} else if (b == 2) {
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
		} else if (b == 3) {
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else if (b == 4) {
			this.setBlockBounds(0.3F, 0.25F, 0.55F, 0.7F, 0.75F, 1.0F);
		} else if (b == 5) {
			this.setBlockBounds(0.0F, 0.25F, 0.3F, 0.45F, 0.75F, 0.7F);
		} else if (b == 6) {
			this.setBlockBounds(0.3F, 0.25F, 0.0F, 0.7F, 0.75F, 0.45F);
		} else if (b == 7) {
			this.setBlockBounds(0.55F, 0.25F, 0.3F, 1.0F, 0.75F, 0.7F);
		} else if (b == 8) {
			this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
		} else if (b == 9) {
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		} else if (b == 10) {
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
		} else if (b == 11) {
			this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else if (b == 12) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 13) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 14) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else if (b == 15) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		int l = (MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

		if (meta != 0 && meta != 1 && meta != 2 && meta != 3) {
			if (meta != 4 && meta != 5 && meta != 6 && meta != 7) {
				if (meta != 8 && meta != 9 && meta != 10 && meta != 11) {
					return false;
				} else {
					par1World.playSound((double) par2, (double) par3, (double) par4, "mob.zombie.say", 1.0F, 1.0F, true);
					return true;
				}
			} else {
				par1World.playSound((double) par2, (double) par3, (double) par4, "mob.wolf.growl", 1.0F, 1.0F, true);
				return true;
			}
		} else {
			par1World.playSound((double) par2, (double) par3, (double) par4, "random.eat", 1.0F, 1.0F, true);
			return true;
		}
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
		return JammyFurnitureModCore.mobHeadsThreeRenderID;
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

	public TileEntity getBlockEntity() {
		return new jfm_TileEntityMobHeadsThree();
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World var1) {
		return new jfm_TileEntityMobHeadsThree();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	public void getSubBlocks(int id, CreativeTabs ctabs, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 4));
		list.add(new ItemStack(id, 1, 8));
		list.add(new ItemStack(id, 1, 12));
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int par1) {
		if (par1 == 1 || par1 == 2 || par1 == 3) {
			par1 = 0;
		}

		if (par1 == 5 || par1 == 6 || par1 == 7) {
			par1 = 4;
		}

		if (par1 == 9 || par1 == 10 || par1 == 11) {
			par1 = 8;
		}

		if (par1 == 13 || par1 == 14 || par1 == 15) {
			par1 = 12;
		}

		return par1;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.jfm_blockIcon = par1IconRegister.registerIcon("jammyfurniture:jammy_cloth");
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	public Icon getIcon(int side, int metadata) {
		return this.jfm_blockIcon;
	}
}
