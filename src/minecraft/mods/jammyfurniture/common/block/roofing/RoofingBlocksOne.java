package mods.jammyfurniture.common.block.roofing;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityRoofingBlocksOne;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RoofingBlocksOne extends JFMetadataBlock {
	
	public RoofingBlocksOne(int id, String registerName) {
		super(id, registerName, Material.rock, "roof", TileEntityRoofingBlocksOne.class, new int[]{ 0, 4, 8, 12 });
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
		int meta = world.getBlockMetadata(i, j, k);
		int l = (MathHelper.floor_double((double) (entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

		if (meta == 0 || meta == 4 || meta == 8) {
			world.setBlockMetadataWithNotify(i, j, k, meta + l, 0);
		}
	}

	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		int var8 = par1World.getBlockMetadata(par2, par3, par4);
		int var9 = var8 & 3;
		float var10 = 0.0F;
		float var11 = 0.5F;
		float var12 = 0.5F;
		float var13 = 1.0F;

		if ((var8 & 4) != 0) {
			var10 = 0.5F;
			var11 = 1.0F;
			var12 = 0.0F;
			var13 = 0.5F;
		}

		this.setBlockBounds(0.0F, var10, 0.0F, 1.0F, var11, 1.0F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

		if (var9 == 0) {
			this.setBlockBounds(0.0F, var12, 0.5F, 1.0F, var13, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		} else if (var9 == 1) {
			this.setBlockBounds(0.0F, var12, 0.0F, 0.5F, var13, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		} else if (var9 == 2) {
			this.setBlockBounds(0.0F, var12, 0.0F, 1.0F, var13, 0.5F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		} else if (var9 == 3) {
			this.setBlockBounds(0.5F, var12, 0.0F, 1.0F, var13, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		par1World.getBlockMetadata(par2, par3, par4);
		int l = (MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
		return false;
	}

}
