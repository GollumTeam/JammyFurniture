package com.gollum.jammyfurniture.common.block.wood;

import com.gollum.core.tools.helper.BlockHelper.PropertySubBlock;
import com.gollum.core.tools.helper.states.IEnumSubBlock;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlock;
import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksOne extends JFBlock {
	
	public static enum EnumType implements IEnumSubBlock {
		
		CLOCK_BASE    ("clock_base"   , 0 , false),
		CLOCK_MIDDLE  ("clock_middle" , 1 , true),
		CLOCK_TOP     ("clock_top"    , 5 , true),
		BLINDS        ("blinds"       , 9 , true),
		CRAFTING_SIDE ("crafting_side", 13, false),
		KITCHEN_SIDE  ("kitchen_side" , 14, false),
		TABLE         ("table"        , 15, false);
		
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
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumType type = (EnumType) state.getValue(TYPE);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);

		if (type == EnumType.CLOCK_BASE) {
			this.setBlockBounds(0.13F, 0.0F, 0.13F, 0.87F, 1.0F, 0.87F);
		} else 
		if (type == EnumType.CLOCK_MIDDLE) {
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
		} else 
		if (type == EnumType.CLOCK_TOP) {
			this.setBlockBounds(0.13F, 0.0F, 0.13F, 0.87F, 1.0F, 0.87F);
		} else 
		if (type == EnumType.BLINDS) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else 
		if (type == EnumType.CRAFTING_SIDE) {
			this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else 
		if (type == EnumType.KITCHEN_SIDE) {
			this.setBlockBounds(0.0F, 0.875F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else 
		if (type == EnumType.TABLE) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ModJammyFurniture.woodBlocksOneRenderID;
	}
	
	///////////
	// Event //
	///////////
	
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

		ItemStack  itemStack = player.inventory.getCurrentItem();
		TileEntity te        = world.getTileEntity(pos);
		EnumType   type      = (EnumType) state.getValue(TYPE);
		EnumFacing facing    = (EnumFacing) state.getValue(FACING);
		
		switch(type) {
			case CLOCK_MIDDLE: // Horloge milieux
				
				// Exclus les les block horloge sauf sur la port
				if (
					this.isClock(itemStack) && !(state.getValue(FACING)  == side)
				) {
					return false;
				}
				
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CLOCK_ID, world, pos.getX(), pos.getY(), pos.getZ());
					return true;
				}
				break;
				
			case CLOCK_TOP: // Horloge du haut
				
				// Clock top
				if (world.isRemote && !config.tellTheTime) {
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
				
			case BLINDS: // Le store en position initial
				
				state = ModBlocks.blockWoodBlocksThree.getDefaultState()
					.withProperty(WoodBlocksThree.TYPE, WoodBlocksThree.EnumType.BLINDS_HALF)
					.withProperty(WoodBlocksThree.FACING, facing)
				;
				world.setBlockState(pos, state, 2);
				return true;
				
			case CRAFTING_SIDE: // table de craft
				
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CRAFTSIDE_ID, world, pos.getX(), pos.getY(), pos.getZ());
					return true;
				}
			default:
				break;
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
		EnumType type = (EnumType) state.getValue(TYPE);
		
		return 
			state !=  null &&
			this == state.getBlock() && (
				type == EnumType.CLOCK_BASE ||
				type == EnumType.CLOCK_MIDDLE ||
				type == EnumType.CLOCK_TOP
			)
		;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		EnumType type = (EnumType) world.getBlockState(pos).getValue(TYPE);
		
		if (type == EnumType.CLOCK_MIDDLE || type == EnumType.CLOCK_TOP || type == EnumType.BLINDS) {
			return super.rotateBlock(world, pos, axis);
		}
		
		return false;
	}

}
