package com.gollum.jammyfurniture.common.block.wood;

import java.util.List;
import java.util.Random;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksThree extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		CHAIR       ("chair", 0),
		RADIO       ("radio", 4),
		BLINDS_HALF ("blinds_half", 8),
		BLINDS_CLOSE("blinds_close", 12);
		
		private final String name;
		private final int index;
		
		private EnumType(String name, int index) {
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
	
	public static class PropertyType extends PropertySubBlock<EnumType> {
		protected PropertyType(String name) {
			super(name, EnumType.class);
		}
		public static PropertyType create(String name) {
			return new PropertyType(name);
		}
		
		@Override
		public EnumType[] getSubBlocksList () {
			return new EnumType[]{
				EnumType.CHAIR,
				EnumType.RADIO,
			};
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyType TYPE = PropertyType.create("type");
	
	public WoodBlocksThree(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksThree.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.CHAIR)
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
	public void addCollisionBoxesToList(World world, BlockPos pos, IBlockState state, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {

		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);
		
		if (type == EnumType.CHAIR) {
			this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.5F, 0.85F);
			super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			if (facing == EnumFacing.NORTH) {
				this.setBlockBounds(0.15F, 0.0F, 0.75F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			} else if (facing == EnumFacing.EAST) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.25F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			} else if (facing == EnumFacing.SOUTH) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.25F);
				super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			} else if (facing == EnumFacing.WEST) {
				this.setBlockBounds(0.75F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
			}
			return;
		}
		
		super.addCollisionBoxesToList(world, pos, state, axisAlignedBB, list, entity);
	}
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		
		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);
		
		if (type == EnumType.CHAIR) {
			if (isSelectBox) this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F);
		} else 
		if (type == EnumType.RADIO) {
			this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 0.7F, 1.0F);
			if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
				this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 0.7F, 0.7F);
			}
		} else 
		if (type == EnumType.BLINDS_HALF) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			if (facing == EnumFacing.NORTH) if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.9F, 1.0F, 1.0F, 1.0F);
			if (facing == EnumFacing.EAST ) if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 0.1F, 1.0F, 1.0F);
			if (facing == EnumFacing.SOUTH) if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 1.0F, 1.0F, 0.1F);
			if (facing == EnumFacing.WEST ) if (isSelectBox) this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.9F, 0.85F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		ItemStack  itemStack = player.inventory.getCurrentItem();
		TileEntity te        = world.getTileEntity(pos);
		EnumType   type      = state.getValue(TYPE);
		EnumFacing facing    = state.getValue(FACING);
		
		if (type == EnumType.RADIO) {
			
			world.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), ModJammyFurniture.MODID.toLowerCase()+":radio", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			return true;
			
		} else 
		if (type == EnumType.BLINDS_HALF) {
			world.setBlockState(pos, state.withProperty(TYPE, EnumType.BLINDS_CLOSE), 2);
			return true;
		} else 
		if (type == EnumType.BLINDS_CLOSE) {
			state = ModBlocks.blockWoodBlocksOne.getDefaultState()
				.withProperty(WoodBlocksOne.TYPE, WoodBlocksOne.EnumType.BLINDS)
				.withProperty(WoodBlocksOne.FACING, facing)
			;
			world.setBlockState(pos, state, 2);
			return true;
		}
		
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
		return ClientProxyJammyFurniture.woodBlocksThreeRenderID;
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random random, int j) {
		EnumType type = state.getValue(TYPE);
		return (type == EnumType.BLINDS_HALF || type == EnumType.BLINDS_CLOSE) ? ModBlocks.blockWoodBlocksOne.getBlockItem() : ModBlocks.blockWoodBlocksThree.getBlockItem();
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		IBlockState state = world.getBlockState(pos);
		EnumType type = state.getValue(TYPE);
		return (type == EnumType.BLINDS_HALF || type == EnumType.BLINDS_CLOSE) ? new ItemStack (ModBlocks.blockWoodBlocksOne, 1, 9) : super.getPickBlock(target, world, pos, player);
	}
}
