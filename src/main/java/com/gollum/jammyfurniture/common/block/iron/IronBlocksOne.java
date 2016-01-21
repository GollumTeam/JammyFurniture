package com.gollum.jammyfurniture.common.block.iron;

import java.util.Map;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronBlocksOne extends JFBlock {
	
	public static enum EnumType implements IStringSerializable {
		
		FRIDGE      ("fridge", 0),
		FREEZER     ("freezer", 4),
		COOKER      ("cooker", 8),
		RUBBISH_BIN ("rubbish_bin", 12),
		COFFEE_TABLE("coffee_table", 13);
		
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
	
	
	public IronBlocksOne(String registerName) {
		super(registerName, Material.iron, TileEntityIronBlocksOne.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.FRIDGE)
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
				state = state.withProperty(TYPE, EnumType.FRIDGE).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.FREEZER).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.COOKER).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 12:
				state = state.withProperty(TYPE, EnumType.RUBBISH_BIN); break;
			case 13:
				state = state.withProperty(TYPE, EnumType.COFFEE_TABLE); break;
			default:
		}
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		EnumType type = state.getValue(TYPE);
		if (
			type == EnumType.FRIDGE ||
			type == EnumType.FREEZER ||
			type == EnumType.COOKER
		) {
			return type.getValue() + state.getValue(FACING).getHorizontalIndex();
		}
		return type.getValue();
	}
	
	@Override
	public void getSubNames(Map<Integer, String> list) {
		list.put(0, "fridge");
		list.put(4, "freezer");
		list.put(8, "cooker");
		list.put(12, "rubbish_bin");
		list.put(13, "coffee_table");  
	}
	
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		
		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);
		
		if (type == EnumType.RUBBISH_BIN) {
			this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
			
		} else 
		if (type == EnumType.FRIDGE || type == EnumType.FREEZER) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.ironBlocksOneRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		EnumFacing orientation = this.getOrientation(player);
		
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
		
		if (state.getValue(TYPE) == EnumType.RUBBISH_BIN) {
			world.addBlockEvent(pos, this, 2, orientation.getHorizontalIndex());
		}
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int parameter) {
		if (eventID == 2) {
			TileEntity te = world.getTileEntity(pos);
			
			if (te != null && te instanceof TileEntityIronBlocksOne) {
				TileEntityIronBlocksOne teIronBlocks = (TileEntityIronBlocksOne)te;
				
				teIronBlocks.rubishBinOrientation = (short) parameter;
			}
			
			return true;
		}
		return super.onBlockEventReceived(world, pos, state, eventID, parameter);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumType type = state.getValue(TYPE);;
		TileEntity te   = world.getTileEntity(pos);
		
		if (te != null && te instanceof TileEntityIronBlocksOne) {
			TileEntityIronBlocksOne teIron = (TileEntityIronBlocksOne)te;
			
			if (type == EnumType.FRIDGE || type == EnumType.FREEZER) {
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_FRIDGE_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
			} else
			
			if (type == EnumType.COOKER) {
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_COOKER_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
			} else
				
			if (type == EnumType.RUBBISH_BIN) {
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_RUBBISHBIN_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
		}
		
		return false;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		EnumType type = world.getBlockState(pos).getValue(TYPE);
		
		if (type == EnumType.FRIDGE || type == EnumType.FREEZER || type == EnumType.COOKER) {
			return super.rotateBlock(world, pos, axis);
		} else
		if (type == EnumType.RUBBISH_BIN) {
			TileEntity te = world.getTileEntity(pos);
			if (te instanceof TileEntityIronBlocksOne) {
				int o = ((TileEntityIronBlocksOne) te).rubishBinOrientation;
				((TileEntityIronBlocksOne) te).rubishBinOrientation = (short) ((o + (axis == EnumFacing.DOWN ? 3 : 1)) % 4);
				world.markBlockForUpdate(pos);
			}
			return true;
		}
		
		return false;
	}
	
}
