package mods.jammyfurniture.common.block.wood;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.util.BlockMountable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WoodBlocksThree extends JFMetadataBlock {
	public static int rotation;
	private Icon jfm_blockIcon;
	
	public WoodBlocksThree(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityWoodBlocksThree.class, new int[] { 0, 4 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	// TODO collision avec al chaise
	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		// int l = par1World.getBlockMetadata(par2, par3, par4);
		// float f = 0.25F;
		// float f1 = 0.375F;
		// float f2 = 0.625F;
		// float f3 = 0.25F;
		// float f4 = 0.75F;
		//
		// switch (getDirectionMeta(l))
		// {
		// case 0:
		// this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
		// super.addCollisionBoxesToList(par1World, par2, par3, par4,
		// par5AxisAlignedBB, par6List, par7Entity);
		//
		// }
	}
	
	
	// TODO LES COLITIONS SON MAUVAISE
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  
			case 1:  
			case 2:  
			case 3:   if (isSelectBox) this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F); else this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.5F, 0.85F); break;
			case 4:  
			case 6:  this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 0.7F, 0.7F); break;
			case 5:  
			case 7:  this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 0.7F, 1.0F); break;
			case 8:  this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); break;
			case 9:  this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); break;
			case 10: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); break;
			case 11: this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
			case 12: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.9F, 1.0F, 1.0F, 1.0F); break;
			case 13: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 0.1F, 1.0F, 1.0F); break;
			case 14: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 1.0F, 1.0F, 0.1F); break;
			case 15: if (isSelectBox) this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.9F, 0.85F, 0.0F, 1.0F, 1.0F, 1.0F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
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
		int subBlock = this.getEnabledMetadata(metadata);
		
		switch (metadata) {
			case 4:
			case 5:
			case 6:
			case 7:
				world.playSoundAtEntity(entityPlayer, ModJammyFurniture.MODID.toLowerCase()+":radio", 1.0F, 1.0F);
				return true;
			case 8:
			case 9:
			case 10:
			case 11: 
				world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksThree.blockID, metadata+4, 2);
				return true;
			case 12:
			case 13:
			case 14:
			case 15: 
				world.setBlock(x, y, z, ModJammyFurniture.blockWoodBlocksOne.blockID, metadata-3, 2);
				return true;
			default:
				break;
		}
		
		if (world.isRemote) {
			return true;
		}
		
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