package com.gollum.jammyfurniture.common.block.wood;

import java.util.HashMap;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
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

public class WoodBlocksTwo extends JFBlock {
	
	public static enum EnumType implements IStringSerializable {
		
		CUPBOARD_SHELF("cupboard_shelf", 0),
		CUPBOARD      ("cupboard"      , 4),
		TELEVISION    ("television"    , 8),
		BASKET_RED    ("basket_red"    , 12),
		BASKET_BLUE   ("basket_blue"   , 13),
		BASKET_GREEN  ("basket_green"  , 14),
		BASKET_GREY   ("basket_grey"   , 15);
		
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
	
	public WoodBlocksTwo(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksTwo.class);
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
				state = state.withProperty(TYPE, EnumType.CUPBOARD_SHELF).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.CUPBOARD).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.TELEVISION).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 12:
				state = state.withProperty(TYPE, EnumType.BASKET_RED); break;
			case 13:
				state = state.withProperty(TYPE, EnumType.BASKET_BLUE); break;
			case 14:
				state = state.withProperty(TYPE, EnumType.BASKET_GREEN); break;
			case 15:
				state = state.withProperty(TYPE, EnumType.BASKET_GREY); break;
			default:
				state = state.withProperty(TYPE, EnumType.CUPBOARD_SHELF); break;
		}
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		EnumType type = state.getValue(TYPE);
		if (
			type == EnumType.CUPBOARD_SHELF ||
			type == EnumType.CUPBOARD ||
			type == EnumType.TELEVISION
		) {
			return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
		}
		return state.getValue(TYPE).getValue();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0 , "cupboard_shelf");
		list.put(4 , "cupboard");
		list.put(8 , "television");
		list.put(12, "basket_red");
		list.put(13, "basket_blue");
		list.put(14, "basket_green");
		list.put(15, "basket_grey");
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	// TODO
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);

		if (type == EnumType.CUPBOARD_SHELF || type == EnumType.CUPBOARD) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else 
		if (type == EnumType.TELEVISION) {
			this.setBlockBounds(0.2F, 0.0F, 0.0F, 0.8F, 0.75F, 1.0F);
			if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
				this.setBlockBounds(0.0F, 0.0F, 0.2F, 1.0F, 0.75F, 0.8F);
			}
		} else {
			this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.4F, 0.95F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if (state.getValue(TYPE) == EnumType.CUPBOARD_SHELF || state.getValue(TYPE) == EnumType.CUPBOARD) {
			player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_KITCHENCUPBOARD_ID, world, pos.getX(), pos.getY(), pos.getZ());
			return true;
		} else if (state.getValue(TYPE) == EnumType.TELEVISION) {
			world.addBlockEvent(pos, this, 2, 0);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int parameter) {
		
		if (eventID == 2) {
			TileEntity te = world.getTileEntity(pos);
			
			if (te != null && te instanceof TileEntityWoodBlocksTwo) {
				TileEntityWoodBlocksTwo teWoodBlocks = (TileEntityWoodBlocksTwo)te;
				
				teWoodBlocks.tvTurnOn ();
			}
			
			return true;
		}
		return super.onBlockEventReceived(world, pos, state, eventID, parameter);
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.woodBlocksTwoRenderID;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		EnumType type = world.getBlockState(pos).getValue(TYPE);
		
		if (type == EnumType.CUPBOARD_SHELF || type == EnumType.CUPBOARD || type == EnumType.TELEVISION) {
			return super.rotateBlock(world, pos, axis);
		}
		
		return false;
	}
	
}
