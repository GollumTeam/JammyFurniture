package com.gollum.jammyfurniture.common.block.wood;

import java.util.HashMap;

import javax.swing.Icon;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo.EnumType;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo.PropertyType;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksThree extends JFBlock {
	
	public static enum EnumType implements IStringSerializable {
		
		CHAIR("chair", 0),
		RADIO("radio", 4);
		
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
	
	public WoodBlocksThree(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksThree.class);
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
				state = state.withProperty(TYPE, EnumType.CHAIR).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.RADIO).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			default:
				state = state.withProperty(TYPE, EnumType.CHAIR); break;
		}
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		EnumType type = state.getValue(TYPE);
		if (
			type == EnumType.CHAIR ||
			type == EnumType.RADIO
		) {
			return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
		}
		return state.getValue(TYPE).getValue();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0 , "chair");
		list.put(8 , "radio");
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	/* FIXME
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);

		if (subBlock == 0) {
			this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.5F, 0.85F);
			super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			if (metadata == 0) {
				this.setBlockBounds(0.15F, 0.0F, 0.75F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 1) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.25F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 2) {
				this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.25F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			} else if (metadata == 3) {
				this.setBlockBounds(0.75F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F);
				super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
			}
			return;
		}
		
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
	}
	*/
	
//	@Override
//	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
//		switch (metadata) {
//			case 0:  
//			case 1:  
//			case 2:  
//			case 3:  if (isSelectBox) this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 1.0F, 0.85F); break;
//			case 4:  
//			case 6:  this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 0.7F, 0.7F); break;
//			case 5:  
//			case 7:  this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 0.7F, 1.0F); break;
//			case 8:  this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); break;
//			case 9:  this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); break;
//			case 10: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); break;
//			case 11: this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
//			case 12: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.9F, 1.0F, 1.0F, 1.0F); break;
//			case 13: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 0.1F, 1.0F, 1.0F); break;
//			case 14: if (isSelectBox) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); else this.setBlockBounds(0.0F, 0.85F, 0.0F, 1.0F, 1.0F, 0.1F); break;
//			case 15: if (isSelectBox) this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); else this.setBlockBounds(0.9F, 0.85F, 0.0F, 1.0F, 1.0F, 1.0F); break;
//			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
//		}
//	}
	
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
	/* FIXME
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		switch (metadata) {
			case 4:
			case 5:
			case 6:
			case 7:
				world.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":radio", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				return true;
			case 8:
			case 9:
			case 10:
			case 11: 
				world.setBlock(x, y, z, ModBlocks.blockWoodBlocksThree, metadata+4, 2);
				return true;
			case 12:
			case 13:
			case 14:
			case 15: 
				world.setBlock(x, y, z, ModBlocks.blockWoodBlocksOne, metadata-3, 2);
				return true;
			default:
				break;
		}
		
		if (world.isRemote) {
			return true;
		}
		
		metadata %= 4;

		if (metadata == 0) {
			player.rotationYaw = 180.0F;
		}

		if (metadata == 1) {
			player.rotationYaw = -90.0F;
		}

		if (metadata == 2) {
			player.rotationYaw = 0.0F;
		}
		
		if (metadata == 3) {
			player.rotationYaw = 90.0F;
		}
		
		return BlockMountable.onBlockActivated(world, x, y, z, player, 0.5F, 0.4F, 0.5F, 0, 0, 0, 0);
		
	}
	*/
	
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
	/* FIXME
	@Override
	public Item getItemDropped(int metadata, Random random, int j) {
		return metadata >= 8 ? ModBlocks.blockWoodBlocksOne.getBlockItem() : ModBlocks.blockWoodBlocksThree.getBlockItem();
	}
	*/
	
	// TODO
//	@Override
//	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
//		IBlockState state = world.getBlockState(pos);
//		EnumType type = state.getValue(TYPE);
//		return (type == EnumType.CHAIR) ? new ItemStack (ModBlocks.blockWoodBlocksOne, 1, 9) : super.getPickBlock(target, world, x, y, z);
//	}
}
