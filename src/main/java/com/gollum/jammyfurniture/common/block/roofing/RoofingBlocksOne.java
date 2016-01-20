package com.gollum.jammyfurniture.common.block.roofing;

import java.util.HashMap;
import java.util.List;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.PropertyType;
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
	
	public static enum EnumType implements IStringSerializable {
		
		ROOFING1 ("roofing1", 0),
		ROOFING2 ("roofing2", 4),
		ROOFING3 ("roofing3", 8),
		ROOFING4 ("roofing4", 12);
		
		private final String name;
		private final int value;
		
		private EnumType(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public String toString() {
			return this.name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	public static class PropertyType extends PropertyEnum<EnumType> {
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
	
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				state = state.withProperty(TYPE, EnumType.ROOFING1); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.ROOFING2); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.ROOFING3); break;
			case 12:
			case 13:
			case 14:
			case 15:
				state = state.withProperty(TYPE, EnumType.ROOFING4); break;
			default:
				state = state.withProperty(TYPE, EnumType.ROOFING1); break;
		}
		return state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0 , "roofing1");
		list.put(4 , "roofing2");
		list.put(8 , "roofing3");
		list.put(12, "roofing4");
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
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
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
