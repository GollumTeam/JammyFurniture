package com.gollum.jammyfurniture.common.block.iron;

import java.util.Map;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
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

public class IronBlocksTwo extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		DISHWASHER     ("dishwasher", 0),
		WASHING_MACHINE("washing_machine", 4);
		
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
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyType TYPE = PropertyType.create("type");
	
	
	public IronBlocksTwo(String registerName) {
		super(registerName, Material.iron, TileEntityIronBlocksTwo.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.DISHWASHER)
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
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.ironBlocksTwoRenderID;
	}
	
	///////////
	// Event //
	///////////

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumType type = state.getValue(TYPE);
		TileEntity te        = world.getTileEntity(pos);
		
		if (te != null && te instanceof TileEntityIronBlocksTwo) {
			TileEntityIronBlocksTwo teIron = (TileEntityIronBlocksTwo)te;
			
			if (type == EnumType.DISHWASHER) {
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_DISHWASHER_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
			} else
			
			if (type == EnumType.WASHING_MACHINE) {
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_WASHINGMACHINE_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
		}
		
		return false;
	}
	
}
