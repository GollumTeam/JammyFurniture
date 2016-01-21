package com.gollum.jammyfurniture.common.block;

import java.util.Random;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.gollum.jammyfurniture.common.item.ItemBath;
import com.gollum.jammyfurniture.common.item.ItemWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.TileEntityBath;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BathBlock extends JFBlock {
	
	public static enum EnumPart implements IStringSerializable {
		
		LEFT("left", 0),
		RIGHT("right", 4);
		
		private final String name;
		private final int value;
		
		private EnumPart(String name, int value) {
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
	
	public static class PropertyPart extends PropertyEnum<EnumPart> {
		protected PropertyPart(String name) {
			super(name, EnumPart.class, Lists.newArrayList(EnumPart.values()));
		}
		public static PropertyPart create(String name) {
			return new PropertyPart(name);
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyPart PART = PropertyPart.create("part");
	
	public BathBlock(String registerName) {
		super(registerName, Material.iron, TileEntityBath.class);
		this.setItemBlockClass(ItemWoodBlocksFour.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(PART, EnumPart.LEFT)
		);
		this.setItemBlockClass(ItemBath.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
	}
	
	////////////
	// States //
	////////////
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{
			FACING,
			PART,
		});
	}
	
	public IBlockState getStateFromMeta(int meta) {
		
		IBlockState state = this.getDefaultState();
		state = state
			.withProperty(PART, EnumPart.RIGHT)
			.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4])
		;
		if (meta < EnumPart.RIGHT.getValue()) {
			state = state.withProperty(PART, EnumPart.LEFT);
		}
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(PART).getValue()+ state.getValue(FACING).getHorizontalIndex();
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		
		EnumFacing facing = state.getValue(FACING);
		EnumPart part = state.getValue(PART);
		BlockPos pos2 = pos.add(part == EnumPart.LEFT ? facing.getDirectionVec() : facing.getOpposite().getDirectionVec());
		
		IBlockState state2 = world.getBlockState(pos2);
		if (state2 != null && state2.getBlock() == this) {
			world.destroyBlock(pos2, true);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumFacing facing = state.getValue(FACING);
		EnumPart part = state.getValue(PART);
		facing = part == EnumPart.LEFT ? facing : facing.getOpposite();
		
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
		return ClientProxyJammyFurniture.woodBlocksFourRenderID;
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return (state.getValue(PART) == EnumPart.LEFT) ? super.getItemDropped(state, random, fortune): null;
	}
}
