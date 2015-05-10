package com.gollum.jammyfurniture.common.block.wood;

import java.util.List;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.BlockMountable;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class WoodBlocksThree extends JFMetadataBlock {
	public static int rotation;
	private Icon jfm_blockIcon;
	
	public WoodBlocksThree(String registerName) {
		super(registerName, Material.wood, "wood", TileEntityWoodBlocksThree.class, new int[] { 0, 4 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);

		if (subBlock == 0) {
			this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.5F, 0.85F);
			super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			if (metadata == 0) {
				this.setBlockBounds(0.15F, 0.0F, 0.75F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 1) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.25F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 2) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.25F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 3) {
				this.setBlockBounds(0.75F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			return;
		}
		
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
	}
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  
			case 1:  
			case 2:  
			case 3:  if (isSelectBox) this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F); break;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		switch (metadata) {
			case 4:
			case 5:
			case 6:
			case 7:
				world.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":radio", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				return true;
			case 8:
			case 9:
			case 10:
			case 11: 
				world.setBlock(x, y, z, ModBlocks.blockWoodBlocksThree, metadata+4, 2);
				return true;
			case 12:
			case 13:
			case 14:
			case 15: 
				world.setBlock(x, y, z, ModBlocks.blockWoodBlocksOne, metadata-3, 2);
				return true;
			default:
				break;
		}
		
		if (world.isRemote) {
			return true;
		}
		
		metadata %= 4;

		if (metadata == 0) {
			player.rotationYaw = 180.0F;
		}

		if (metadata == 1) {
			player.rotationYaw = -90.0F;
		}

		if (metadata == 2) {
			player.rotationYaw = 0.0F;
		}
		
		if (metadata == 3) {
			player.rotationYaw = 90.0F;
		}
		
		return BlockMountable.onBlockActivated(world, x, y, z, player, 0.5F, 0.4F, 0.5F, 0, 0, 0, 0);
		
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int metadata, Random random, int j) {
		return metadata >= 8 ? ModBlocks.blockWoodBlocksOne.getBlockItem() : ModBlocks.blockWoodBlocksThree.getBlockItem();
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
		return (metadata >= 8) ? new ItemStack (ModBlocks.blockWoodBlocksOne, 1, 9) : super.getPickBlock(target, world, x, y, z);
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksThreeRenderID;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
}
