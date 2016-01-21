package com.gollum.jammyfurniture.common.block;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLights extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		LIGHT       ("light", 0, false),
		OUTDOOR_LAMP("outdoor_lamp", 4, true),
		TABLE_LAMP  ("table_lamp", 8, false);
		
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
	
	
	public BlockLights(String registerName, boolean active) {
		super(registerName, Material.glass, (active) ? TileEntityLightsOn.class : TileEntityLightsOff.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.LIGHT)
		);
		if (active) {
			this.setLightLevel(1.0F);
		}
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
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);

		if (type == EnumType.LIGHT) {
			this.setBlockBounds(0.25F, 0.385F, 0.315F, 0.685F, 1.0F, 0.75F);
		} else 
		if (type == EnumType.OUTDOOR_LAMP) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.315F, 0.125F, 0.5F, 0.625F, 0.925F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.125F, 0.315F, 0.5F, 0.925F, 0.625F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.375F, 0.125F, 0.0F, 0.685F, 0.925F, 0.5F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.5F, 0.125F, 0.375F, 1.0F, 0.925F, 0.685F);
		} else 
		if (type == EnumType.TABLE_LAMP) {
			this.setBlockBounds(0.315F, 0.0F, 0.315F, 0.685F, 0.875F, 0.685F);
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.lightsRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		EnumType type = state.getValue(TYPE);
		EnumFacing orientaion = state.getValue(FACING);
		Block block  = state.getBlock();
		IBlockState newState = null;
		if (block == ModBlocks.blockLightsOn) {
			newState = ModBlocks.blockLightsOff.getDefaultState();
		} else {
			newState = ModBlocks.blockLightsOn.getDefaultState();
		}
		newState = newState.withProperty(TYPE, type);
		newState = newState.withProperty(FACING, orientaion);
		world.setBlockState(pos, newState, 3);

		return true;
	}
}
