package com.gollum.jammyfurniture.common.block.head;

import java.util.HashMap;

import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.EnumType;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.PropertyType;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class JFMobHeads extends JFBlock {
	
	public static enum EnumType implements IStringSerializable {
		
		HEAD_1 ("head1", 0),
		HEAD_2 ("head2", 4),
		HEAD_3 ("head3", 8),
		HEAD_4 ("head4", 12);
		
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
	
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				state = state.withProperty(TYPE, EnumType.HEAD_1); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.HEAD_2); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.HEAD_3); break;
			case 12:
			case 13:
			case 14:
			case 15:
				state = state.withProperty(TYPE, EnumType.HEAD_4); break;
			default:
				state = state.withProperty(TYPE, EnumType.HEAD_1); break;
		}
		state = state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0,  "head1");
		list.put(4,  "head2");
		list.put(8,  "head3");
		list.put(12, "head4");
	}
	
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
}