package com.gollum.jammyfurniture.common.block.roofing;

import java.util.List;
import java.util.Map;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RoofingBlocksOne extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		ROOFING1 ("roofing1", 0),
		ROOFING2 ("roofing2", 4),
		ROOFING3 ("roofing3", 8),
		ROOFING4 ("roofing4", 12);
		
		private final String name;
		private final int index;
		
		private EnumType(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
		@Override
		public int getIndex() {
			return this.index;
		}
		
		@Override
		public boolean isFacingPlane() {
			return true;
		}
	}
	
	public static class PropertyType extends PropertySubBlock<EnumType> {
		protected PropertyType(String name) {
			super(name, EnumType.class, Lists.newArrayList(EnumType.values()));
		}
		public static PropertyType create(String name) {
			return new PropertyType(name);
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyType TYPE = PropertyType.create("type");
	
	public RoofingBlocksOne(String registerName) {
		super(registerName, Material.rock, TileEntityRoofingBlocksOne.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.ROOFING1)
		);
	}
	
	////////////
	// States //
	////////////
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{
			FACING,
			TYPE,
		});
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	public void addCollisionBoxesToList(World world, BlockPos pos, IBlockState state, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {

		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);
		
		if (type == EnumType.ROOFING1 || type == EnumType.ROOFING2 | type == EnumType.ROOFING3) {
			
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			
			if (type == EnumType.ROOFING1) {
				if (facing == EnumFacing.NORTH) {
					this.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.EAST) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.SOUTH) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.WEST) {
					this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				}
			} else
			if (type == EnumType.ROOFING2) {
				if (facing == EnumFacing.NORTH) {
					this.setBlockBounds(0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.EAST) {
					this.setBlockBounds(0.0F, 0.5F, 0.5F, 0.5F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.SOUTH) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 0.5F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.WEST) {
					this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				}
			} else
			if (type == EnumType.ROOFING3) {
				if (facing == EnumFacing.NORTH) {
					this.setBlockBounds(0.0F, 0.5F, 0.3F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
					this.setBlockBounds(0.5F, 0.3F, 0.0F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.EAST) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
					this.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.SOUTH) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				} else if (facing == EnumFacing.WEST) {
					this.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
					super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
				}
			}
			
			return;
		}
		
		
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
		return;
	}
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		if (isSelectBox) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.roofingBlocksOneRenderID;
	}
	
}
