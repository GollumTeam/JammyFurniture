package com.gollum.jammyfurniture.common.block.wood;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksTwo extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		CUPBOARD_SHELF("cupboard_shelf", 0, true),
		CUPBOARD      ("cupboard"      , 4, true),
		TELEVISION    ("television"    , 8, true),
		BASKET_RED    ("basket_red"    , 12, false),
		BASKET_BLUE   ("basket_blue"   , 13, false),
		BASKET_GREEN  ("basket_green"  , 14, false),
		BASKET_GREY   ("basket_grey"   , 15, false);
		
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
	
	public WoodBlocksTwo(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksTwo.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.CUPBOARD_SHELF)
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
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
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
