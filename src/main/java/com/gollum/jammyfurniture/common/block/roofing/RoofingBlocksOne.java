package com.gollum.jammyfurniture.common.block.roofing;

import java.util.List;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class RoofingBlocksOne extends JFMetadataBlock {
	
	public RoofingBlocksOne(String registerName) {
		super(registerName, Material.rock, "roof", TileEntityRoofingBlocksOne.class, new int[]{ 0, 4, 8, 12 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8) {
			
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);

			if (metadata == 0) {
				this.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 1) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 2) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 3) {
				this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 4) {
				this.setBlockBounds(0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 5) {
				this.setBlockBounds(0.0F, 0.5F, 0.5F, 0.5F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 6) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 7) {
				this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 8) {
				this.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
				this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 9) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
				this.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 10) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			if (metadata == 11) {
				this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			return;
		}
		
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
		return;
	}
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		if (isSelectBox) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
		int subBlock    = this.getEnabledMetadata(metadata);
		int orientation = this.getOrientation(entityliving);

		if (subBlock == 0 || subBlock == 4 || subBlock == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ClientProxyJammyFurniture.roofingBlocksOneRenderID;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}

}
