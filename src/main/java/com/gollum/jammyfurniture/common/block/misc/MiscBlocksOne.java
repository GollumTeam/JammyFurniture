package com.gollum.jammyfurniture.common.block.misc;

import java.util.Map;
import java.util.Random;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
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
	
	public static enum EnumType implements IEnumSubBlock {
		
		CHIMNEY       ("chimney", 0, false),
		MANTLE_PIECE  ("mantle_piece", 4, true),
		CHRISTMAS_TREE("christmas_tree", 8, true);
		
		private final String name;
		private final int index;
		private boolean facingPlane;
		
		private EnumType(String name, int index, boolean facingPlane) {
			this.name = name;
			this.index = index;
			this.facingPlane = facingPlane;
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
			return this.facingPlane;
		}
	}
	
	public static class PropertyType extends PropertySubBlock<EnumType> {
		protected PropertyType(String name) {
			super(name, EnumType.class);
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
	
	///////////
	// Event //
	///////////
	
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
