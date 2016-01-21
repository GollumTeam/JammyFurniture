package com.gollum.jammyfurniture.common.block;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.gollum.core.common.blocks.ISimpleBlockRendered;
import com.gollum.core.tools.helper.blocks.HBlockContainer;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class JFBlock extends HBlockContainer implements ISimpleBlockRendered {
	
	protected Class tileEntityClass;
	
	public JFBlock(String registerName, Material material, Class tileEntityClass) {
		super(registerName, material);
		this.tileEntityClass = tileEntityClass;
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
	
	@Override
	public AxisAlignedBB getSelectedBoundingBox(World world, BlockPos pos) {
		
		IBlockState state = world.getBlockState(pos);
		this.getCollisionBoundingBox(state, false);
		
		return super.getSelectedBoundingBox(world, pos);
	}
	
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess  world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		this.getCollisionBoundingBox(state, true);
	}
	
	
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
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