package com.gollum.jammyfurniture.common.block;

import static com.gollum.jammyfurniture.ModJammyFurniture.log;

import java.util.HashMap;
import java.util.List;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.inits.ModBlocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
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

public class BlockLights extends JFBlock {
	
	public static enum EnumType implements IStringSerializable
	{
		LIGHT       ("light", 0),
		OUTDOOR_LAMP("outdoor_lamp", 4),
		TABLE_LAMP  ("table_lamp", 8);

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
	
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				state = state.withProperty(TYPE, EnumType.LIGHT); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.OUTDOOR_LAMP); break;
			default:
				state = state.withProperty(TYPE, EnumType.TABLE_LAMP); break;
		}
		return state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0, "light");
		list.put(4, "outdoor_lamp");
		list.put(8, "table_lamp");
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
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
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
