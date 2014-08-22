package mods.jammyfurniture.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import mods.jammyfurniture.JammyFurnitureModCore;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityBath;
import mods.jammyfurniture.common.util.BlockMountable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jfm_BathBlock extends BlockContainer {
	public static final int[][] footBlockToHeadBlockMap = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	private Icon jfm_blockIcon;

	public jfm_BathBlock(int par1, int notsure, Class teClass) {
		super(par1, Material.iron);
		this.setBounds();
	}

	public static int getDirection(int par0) {
		return par0 & 3;
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		int l = par1World.getBlockMetadata(par2, par3, par4);

		if (par1World.isRemote) {
			return true;
		} else {
			l %= 4;

			if (l == 0) {
				par5EntityPlayer.rotationYaw = 180.0F;
			}

			if (l == 1) {
				par5EntityPlayer.rotationYaw = -90.0F;
			}

			if (l == 2) {
				par5EntityPlayer.rotationYaw = 0.0F;
			}

			if (l == 3) {
				par5EntityPlayer.rotationYaw = 90.0F;
			}

			float x = 0.0F;
			float y = 0.0F;
			float z = 0.0F;

			if (l == 0) {
				x = 0.5F;
				y = 0.4F;
				z = 0.5F;
			}

			if (l == 1) {
				x = 0.5F;
				y = 0.4F;
				z = 0.5F;
			}

			if (l == 2) {
				x = 0.5F;
				y = 0.4F;
				z = 0.5F;
			}

			if (l == 3) {
				x = 0.5F;
				y = 0.4F;
				z = 0.5F;
			}

			return BlockMountable.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, x, y, z, 0, 0, 0, 0);
		}
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return JammyFurnitureModCore.bathTubRenderID;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
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
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		this.setBounds();
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
		int var7 = getDirection(var6);

		if (isBlockHeadOfBed(var6)) {
			if (par1World.getBlockId(par2 - footBlockToHeadBlockMap[var7][0], par3, par4 - footBlockToHeadBlockMap[var7][1]) != this.blockID) {
				par1World.setBlock(par2, par3, par4, 0);
			}
		} else if (par1World.getBlockId(par2 + footBlockToHeadBlockMap[var7][0], par3, par4 + footBlockToHeadBlockMap[var7][1]) != this.blockID) {
			par1World.setBlock(par2, par3, par4, 0);

			if (!par1World.isRemote) {
				this.dropBlockAsItem(par1World, par2, par3, par4, var6, 0);
			}
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		return JammyFurnitureModCore.bathTub.blockID;
	}

	private void setBounds() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
	}

	public static boolean isBlockHeadOfBed(int par0) {
		return (par0 & 8) != 0;
	}

	public static ChunkCoordinates getNearestEmptyChunkCoordinates(World par0World, int par1, int par2, int par3, int par4) {
		int var5 = par0World.getBlockMetadata(par1, par2, par3);
		int var6 = getDirection(var5);

		for (int var7 = 0; var7 <= 1; ++var7) {
			int var8 = par1 - footBlockToHeadBlockMap[var6][0] * var7 - 1;
			int var9 = par3 - footBlockToHeadBlockMap[var6][1] * var7 - 1;
			int var10 = var8 + 2;
			int var11 = var9 + 2;

			for (int var12 = var8; var12 <= var10; ++var12) {
				for (int var13 = var9; var13 <= var11; ++var13) {
					if (par0World.doesBlockHaveSolidTopSurface(var12, par2 - 1, var13) && par0World.isAirBlock(var12, par2, var13) && par0World.isAirBlock(var12, par2 + 1, var13)) {
						if (par4 <= 0) {
							return new ChunkCoordinates(var12, par2, var13);
						}

						--par4;
					}
				}
			}
		}

		return null;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return JammyFurnitureModCore.bathTub.blockID;
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World var1) {
		return new jfm_TileEntityBath();
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.jfm_blockIcon = par1IconRegister.registerIcon("jammyfurniture:jammy_ceramic");
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	public Icon getIcon(int side, int metadata) {
		return this.jfm_blockIcon;
	}
}
