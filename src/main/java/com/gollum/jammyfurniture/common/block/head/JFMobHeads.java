package com.gollum.jammyfurniture.common.block.head;

import java.util.Map;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public abstract class JFMobHeads extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		HEAD_1 ("head1", 0),
		HEAD_2 ("head2", 4),
		HEAD_3 ("head3", 8),
		HEAD_4 ("head4", 12);
		
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
	
	public JFMobHeads(String registerName, Class tileEntityClass) {
		super(registerName, Material.cloth, tileEntityClass);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.HEAD_1)
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
	
}