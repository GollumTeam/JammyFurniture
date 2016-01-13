package com.gollum.jammyfurniture.common.block;

import java.util.List;

import com.gollum.core.common.blocks.ISimpleBlockRendered;
import com.gollum.core.tools.helper.blocks.HBlockContainer;
import com.gollum.core.tools.helper.items.HItemBlockMetadata;
import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class JFBlock extends HBlockContainer implements ISimpleBlockRendered {
	
	protected Class tileEntityClass;
	
	/**
	 * TODO
	 * @deprecated
	 */
	public JFBlock(String registerName, Material material, String textureKey, Class tileEntityClass, int[] listSubBlock) {
		this(registerName, material, tileEntityClass);
	}
	
	public JFBlock(String registerName, Material material, Class tileEntityClass) {
		super(registerName, material);
		this.tileEntityClass = tileEntityClass;
		this.setItemBlockClass(HItemBlockMetadata.class);
	}
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return (TileEntity) this.tileEntityClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	/* FIXME
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, BlockPos pos) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		this.getCollisionBoundingBox(metadata, false);
		
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	*/
	
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, BlockPos pos) {
		// FIXME
//		int metadata = blockAccess.getBlockMetadata(x, y, z);
//		this.getCollisionBoundingBox(metadata, true);
		
	}
	
	
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * @param entity
	 * @return
	 */
	public EnumFacing getOrientation(Entity entity) {
		return entity.getHorizontalFacing().getOpposite();
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}