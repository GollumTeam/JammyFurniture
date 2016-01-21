package com.gollum.jammyfurniture.common.block.misc;

import java.util.Map;
import java.util.Random;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class MiscBlocksOne extends JFBlock {
	
	public static enum EnumType implements IStringSerializable {
		
		CHIMNEY       ("chimney", 0),
		MANTLE_PIECE  ("mantle_piece", 4),
		CHRISTMAS_TREE("christmas_tree", 8);
		
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
	
	public MiscBlocksOne(String registerName) {
		super(registerName, Material.rock, TileEntityMiscBlockOne.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.CHIMNEY)
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
				state = state.withProperty(TYPE, EnumType.CHIMNEY); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.MANTLE_PIECE); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.CHRISTMAS_TREE); break;
			default:
				state = state.withProperty(TYPE, EnumType.CHIMNEY); break;
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
	public void getSubNames(Map<Integer, String> list) {
		list.put(0 , "chimney");
		list.put(4 , "mantle_piece");
		list.put(8 , "christmas_tree");
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random) {
		
		if (state.getValue(TYPE) == EnumType.CHIMNEY) {
			float x = (float) pos.getX() + 0.5F + random.nextFloat() * 0.6F - 0.3F;
			float y = (float) pos.getY() + 1.0F + random.nextFloat() * 0.6F;
			float z = (float) pos.getZ() + 0.5F + random.nextFloat() * 0.6F - 0.3F;
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////
	
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.miscBlocksOneRenderID;
	}
	
}
