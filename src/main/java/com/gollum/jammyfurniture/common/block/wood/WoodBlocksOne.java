package com.gollum.jammyfurniture.common.block.wood;

import java.util.List;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.BlockLights.EnumType;
import com.gollum.jammyfurniture.common.block.BlockLights.PropertyType;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import com.gollum.jammyfurniture.inits.ModBlocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksOne extends JFBlock {
	
	public static enum EnumType implements IStringSerializable
	{
		CLOCK_BASE    ("clock_base", 0),
		CLOCK_MIDDLE  ("clock_middle", 1),
		CLOCK_TOP     ("clock_top", 5),
		BLINDS        ("blinds", 9),
		CRAFTING_SIDE ("crafting_side", 13),
		KITCHEN_SIDE  ("kitchen_side", 14),
		TABLE         ("table", 15);
		
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
	
	
	public WoodBlocksOne(String registerName) {
		super(registerName, Material.wood, TileEntityWoodBlocksOne.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.CLOCK_BASE)
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
				state = state.withProperty(TYPE, EnumType.CLOCK_BASE); break;
			case 1:
			case 2:
			case 3:
			case 4:
				state = state.withProperty(TYPE, EnumType.CLOCK_MIDDLE).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 5:
			case 6:
			case 7:
			case 8:
				state = state.withProperty(TYPE, EnumType.CLOCK_TOP).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 9:
			case 10:
			case 11:
			case 12:
				state = state.withProperty(TYPE, EnumType.BLINDS).withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]); break;
			case 13:
				state = state.withProperty(TYPE, EnumType.CRAFTING_SIDE); break;
			case 14:
				state = state.withProperty(TYPE, EnumType.KITCHEN_SIDE); break;
			case 15:
				state = state.withProperty(TYPE, EnumType.TABLE); break;
			default:
				state = state.withProperty(TYPE, EnumType.CLOCK_BASE); break;
		}
		return state;
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		EnumType type = state.getValue(TYPE);
		if (
			type == EnumType.CLOCK_MIDDLE ||
			type == EnumType.CLOCK_TOP ||
			type == EnumType.BLINDS
		) {
			return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
		}
		return state.getValue(TYPE).getValue();
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs ctabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 5));
		list.add(new ItemStack(item, 1, 9));
		list.add(new ItemStack(item, 1, 13));
		list.add(new ItemStack(item, 1, 14));
		list.add(new ItemStack(item, 1, 15));
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	// TODO fix this
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  this.setBlockBounds(0.13F, 0.0F, 0.13F, 0.87F, 1.0F, 0.87F); break;
			case 1:
			case 2:  
			case 3:  
			case 4:  this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F); break;
			case 5:
			case 6:
			case 7:
			case 8:  this.setBlockBounds(0.13F, 0.0F, 0.13F, 0.87F, 1.0F, 0.87F); break;
			case 9:  this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F); break; 
			case 10: this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F); break; 
			case 11: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F); break; 
			case 12: this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break; 
			case 13:
			case 14: this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.woodBlocksOneRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	@Override
	public void onNeighborBlockChange(World World, BlockPos pos, IBlockState state, Block block) {
		super.onNeighborBlockChange(World, pos, state, block);
		TileEntityWoodBlocksOne titleEntity = (TileEntityWoodBlocksOne) World.getTileEntity(pos);
		if (titleEntity != null) {
			titleEntity.updateContainingBlockInfo();
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		ItemStack itemStack = player.inventory.getCurrentItem();
		TileEntity te = world.getTileEntity(pos);
		
		if (state.getValue(TYPE) == EnumType.CLOCK_MIDDLE) { // Horloge milieux
				
				// Exclus les les block horloge sauf sur la port
				if (
					this.isClock(itemStack) && !(state.getValue(FACING)  == side) // TODO a tester a fond
				) {
					return false;
				}
				
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CLOCK_ID, world, pos.getX(), pos.getY(), pos.getZ());
					return true;
				}
		} else
		if (state.getValue(TYPE) == EnumType.CLOCK_TOP) { // Horloge du haut
			// Clock top
			if (world.isRemote) {
				return true;
			}
			
			int time = (int) world.getWorldTime() % 24000;
			int hour = ((time / 1000)+6) % 24;
			int min = (time - (time/1000)*1000) * 60 / 1000;
			boolean am = hour < 13 && hour >= 1;
			int hour12 = hour % 12;
			hour12 = (am && hour12 == 0) ? 12 : hour12;
			
			int paddingH = ModJammyFurniture.i18n.transInt("clock.paddingH");
			int paddingM = ModJammyFurniture.i18n.transInt("clock.paddingM");
			boolean hour12Format = !ModJammyFurniture.i18n.trans("clock.format").equals("24");
			
			
			String strH = String.format("%0"+paddingH+"d", (hour12Format) ? hour12 : hour);
			String strM = String.format("%0"+paddingM+"d", min);
			
			ModJammyFurniture.log.debug ("%0"+paddingM+"d", strM);
			
			player.addChatMessage(new ChatComponentText(ModJammyFurniture.i18n.trans("clock.displayTime", strH, strM, ModJammyFurniture.i18n.trans("clock.format."+((am)? "am" : "pm")))));
			
			String message = null;
			
			ModJammyFurniture.log.debug ("time = "+time+" H = "+hour);
			
			if (time >= 12000 && time <= 24000) { message = ModJammyFurniture.i18n.trans("clock.night");     }
			if (hour >= 6  && hour <= 12)       { message = ModJammyFurniture.i18n.trans("clock.morning");   }
			if (hour >= 12 && hour < 18)        { message = ModJammyFurniture.i18n.trans("clock.afternoon"); }
			if (time >= 23000 || time <= 300)   { message = ModJammyFurniture.i18n.trans("clock.dawn");      }
			if (time >= 11700 && time <= 13300) { message = ModJammyFurniture.i18n.trans("clock.dusk");      }
			if (hour == 12)                     { message = ModJammyFurniture.i18n.trans("clock.midday");    }
			if (hour == 0)                      { message = ModJammyFurniture.i18n.trans("clock.midnight");  }
			
			
			if (message != null) {
				player.addChatMessage(new ChatComponentText(message));
			}
			
			return true;
		} else 
		if (state.getValue(TYPE) == EnumType.BLINDS) { // Le store en position initial
			
			// TODO existe pas encore
//			world.setBlockState(pos, ModBlocks.blockWoodBlocksThree.getDefaultState()
//				.withProperty(ModBlocks.blockWoodBlocksThree.TYPE, ModBlocks.blockWoodBlocksThree.EnumType.BLINDS_OPEN),
//				.withProperty(ModBlocks.blockWoodBlocksThree.FACING, state.getValue(FACING)),
//			2); // Les autres stores sont dans le block wood 3
		} else
		if (state.getValue(TYPE) == EnumType.CRAFTING_SIDE) { // table de craft
			
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CRAFTSIDE_ID, world, pos.getX(), pos.getY(), pos.getZ());
					return true;
				}
		}
		
		return false;
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	private boolean isClock (ItemStack itemStack) {
		
		if (itemStack == null) {
			return false;
		}
		IBlockState state = this.getStateFromMeta(itemStack.getItemDamage());
		
		return 
			state !=  null &&
			this == state.getBlock() && (
				state.getValue(TYPE) == EnumType.CLOCK_BASE ||
				state.getValue(TYPE) == EnumType.CLOCK_MIDDLE ||
				state.getValue(TYPE) == EnumType.CLOCK_TOP
			)
		;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		EnumType type = world.getBlockState(pos).getValue(TYPE);
		
		if (type == EnumType.CLOCK_MIDDLE || type == EnumType.CLOCK_TOP || type == EnumType.BLINDS) {
			return super.rotateBlock(world, pos, axis);
		}
		
		return false;
	}

}
