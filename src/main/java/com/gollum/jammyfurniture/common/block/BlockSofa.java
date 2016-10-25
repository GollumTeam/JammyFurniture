package com.gollum.jammyfurniture.common.block;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;

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

public class BlockSofa extends JFBlock {
	
	public static enum EnumColor implements IEnumSubBlock {
		
		RED   ("red"  , 0),
		BLUE  ("blue" , 4),
		GREEN ("green", 8),
		GREY  ("grey" , 12);
		
		private final String name;
		private final int index;
		
		private EnumColor(String name, int index) {
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
	
	public static class PropertyColor extends PropertySubBlock<EnumColor> {
		protected PropertyColor(String name) {
			super(name, EnumColor.class);
		}
		public static PropertyColor create(String name) {
			return new PropertyColor(name);
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyColor COLOR = PropertyColor.create("color");
	
	public BlockSofa(String registerName, Class tileEntityClass) {
		super(registerName, Material.wood, tileEntityClass);
		this.setDefaultState(this.getDefaultState()
				.withProperty(FACING, EnumFacing.NORTH)
				.withProperty(COLOR, EnumColor.RED)
			);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		if (isSelectBox) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.7F, 1.0F);
		}
	}
	
	////////////
	// States //
	////////////
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{
			FACING,
			COLOR,
		});
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumFacing facing    = (EnumFacing) state.getValue(FACING);
		
		if (world.isRemote) {
			return true;
		}
		
		player.rotationYaw = 0.0F;
		if (facing == facing.WEST) {
			player.rotationYaw = 90.0F;
		} else
		if (facing == EnumFacing.NORTH) {
			player.rotationYaw = 180.0F;
		} else
		if (facing == facing.EAST) {
			player.rotationYaw = -90.0F;
		}
		return EntityMountableBlock.onBlockActivated(world, pos, player, 0.5F, 0.4F, 0.5F);
		
	}
	
	////////////////////
	// Rendu du block //
	////////////////////
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ModJammyFurniture.sofaRenderID;
	}
	
}