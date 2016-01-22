package com.gollum.jammyfurniture.common.block.wood;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.gollum.core.tools.helper.BlockHelper.PropertyIndex;
import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumIndexed;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.item.ItemWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksFour extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		WARDROBE("wardrobe", 0),
		COAT_STAND("coat_stand", 8);
		
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
	
	public static enum EnumPart implements IEnumIndexed {
		
		FOOT("foot", 0),
		HEAD("head", 4);
		
		private final String name;
		private final int index;
		
		private EnumPart(String name, int value) {
			this.name = name;
			this.index = value;
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
	}
	
	public static class PropertyType extends PropertySubBlock<EnumType> {
		protected PropertyType(String name) {
			super(name, EnumType.class);
		}
		public static PropertyType create(String name) {
			return new PropertyType(name);
		}
	}
	
	public static class PropertyPart extends PropertyIndex<EnumPart> {
		protected PropertyPart(String name) {
			super(name, EnumPart.class);
		}
		public static PropertyPart create(String name) {
			return new PropertyPart(name);
		}
		
		@Override
		public EnumPart getEnumFromMeta(int meta) {
			return super.getEnumFromMeta(meta % 8);
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyPart PART = PropertyPart.create("part");
	public static final PropertyType TYPE = PropertyType.create("type");
	
	public WoodBlocksFour(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksFour.class);
		this.setItemBlockClass(ItemWoodBlocksFour.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.WARDROBE)
			.withProperty(PART, EnumPart.FOOT)
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
			PART,
		});
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		if (state.getValue(TYPE) == EnumType.WARDROBE) {
			this.setBlockBounds(0.06F, 0.0F, 0.06F, 0.94F, 0.95F, 0.94F);
		} else {
			if (isSelectBox) {
				this.setBlockBounds(0.47F, 0.0F, 0.47F, 0.53F, 1.0F, 0.53F);
			}else {
				this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
			}
		}
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		
		BlockPos pos2 = pos.up();
		if (state.getValue(PART) == EnumPart.HEAD) {
			pos2 = pos.down();
		}
		
		if (world.getBlockState(pos2).getBlock() == this) {
			world.destroyBlock(pos2, true);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if (state.getValue(TYPE) == EnumType.WARDROBE && state.getValue(PART) == EnumPart.HEAD) {
			player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_WARDROBE_ID, world, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		
		return false;
		
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
		return (state.getValue(PART) == EnumPart.HEAD) ? super.getItemDropped(state, random, fortune): null;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		IBlockState state = world.getBlockState(pos);
		BlockPos pos2 = pos.up();
		if (state.getValue(PART) == EnumPart.HEAD) {
			pos2 = pos.down();
		}
		return super.rotateBlock(world, pos, axis) && super.rotateBlock(world, pos2, axis);
	}
}
