package com.gollum.jammyfurniture.common.block;

import java.util.HashMap;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSofa extends JFBlock {
	
	public static enum EnumColor implements IStringSerializable {
		
		RED   ("red"  , 0),
		BLUE  ("blue" , 4),
		GREEN ("green", 8),
		GREY  ("grey" , 12);
		
		private final String name;
		private final int value;
		
		private EnumColor(String name, int value) {
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
	
	public static class PropertyColor extends PropertyEnum<EnumColor> {
		protected PropertyColor(String name) {
			super(name, EnumColor.class, Lists.newArrayList(EnumColor.values()));
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
	
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				state = state.withProperty(COLOR, EnumColor.RED); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(COLOR, EnumColor.BLUE); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(COLOR, EnumColor.GREEN); break;
			case 12:
			case 13:
			case 14:
			case 15:
				state = state.withProperty(COLOR, EnumColor.GREY); break;
			default:
				state = state.withProperty(COLOR, EnumColor.RED); break;
		}
		return state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return  state.getValue(COLOR).getValue() + state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0, "red");
		list.put(4, "blue");
		list.put(8, "green");
		list.put(12, "grey");
	}
	
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumFacing facing    = state.getValue(FACING);
		
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
		return ClientProxyJammyFurniture.sofaRenderID;
	}
	
}