package com.gollum.jammyfurniture.common.block.ceramic;

import java.util.HashMap;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.IBlockUnmountEvent;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.EnumType;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree.PropertyType;
import com.gollum.jammyfurniture.common.crafting.CeramicBlocksOneRecipes;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CeramicBlocksOne extends JFBlock implements IBlockUnmountEvent {
	
	public static enum EnumType implements IStringSerializable {
		
		BATHROOM_CUPBOARD("bathroom_cupboard", 0),
		BATHROOM_SINK    ("bathroom_sink", 4),
		KITCHEN          ("kitchen", 8),
		TOILET           ("toilet", 12);
		
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
	
	public CeramicBlocksOne(String registerName) {
		super(registerName, Material.glass, TileEntityCeramicBlocksOne.class);
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.BATHROOM_CUPBOARD)
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
				state = state.withProperty(TYPE, EnumType.BATHROOM_CUPBOARD); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.BATHROOM_SINK); break;
			case 8:
			case 9:
			case 10:
			case 11:
				state = state.withProperty(TYPE, EnumType.KITCHEN); break;
			case 12:
			case 13:
			case 14:
			case 15:
				state = state.withProperty(TYPE, EnumType.TOILET); break;
			default:
				state = state.withProperty(TYPE, EnumType.BATHROOM_CUPBOARD); break;
		}
		return state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(TYPE).getValue() + state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public void getSubNames(HashMap<Integer, String> list) {
		list.put(0 , "bathroom_cupboard");
		list.put(4 , "bathroom_sink");
		list.put(8 , "kitchen");
		list.put(12, "toilet");
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumType type = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);

		if (type == EnumType.BATHROOM_CUPBOARD) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.1F, 0.0F, 0.6F, 0.9F, 1.0F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.4F, 1.0F, 0.9F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.4F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.6F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
		} else 
		if (type == EnumType.BATHROOM_SINK) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.1F, 0.0F, 0.2F, 0.9F, 1.0F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.8F, 1.0F, 0.9F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.8F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.2F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
		} else 
		if (type == EnumType.KITCHEN) {
			this.setBlockBounds(0.0F , 0.4F, 0.0F , 1.0F , 1.0F, 1.0F );
		} else {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.15F, 0.0F, 0.05F, 0.85F, 1.0F, 1.0F );
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.05F, 0.0F, 0.15F, 1.0F , 1.0F, 0.85F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.15F, 0.0F, 0.0F , 0.85F, 1.0F, 0.95F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.0F , 0.0F, 0.15F, 0.95F, 1.0F, 0.85F);
		}
	}
	
	///////////
	// Event //
	///////////

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, this.getOrientation(player)), 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

		EnumType   type   = state.getValue(TYPE);
		EnumFacing facing = state.getValue(FACING);
		TileEntity te     = world.getTileEntity(pos);
		
		
		if (te != null && te instanceof TileEntityCeramicBlocksOne) {
			TileEntityCeramicBlocksOne teCeramic = (TileEntityCeramicBlocksOne)te;
			
			if (type == EnumType.BATHROOM_CUPBOARD) {
				
				player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_BARHROOMCUPBOARD_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
				
			} else 
			if (type == EnumType.BATHROOM_SINK || type == EnumType.KITCHEN) {
				

				if (world.isRemote) {
					return true;
				}
				
				if (teCeramic.waterIsOn ()) {
					
					ItemStack itemStack = player.inventory.getCurrentItem();
					ItemStack newItemStack = CeramicBlocksOneRecipes.smelting().getSmeltingResult(itemStack);
					
					if (newItemStack != null) {
						
						--itemStack.stackSize;
						
						if (itemStack.stackSize <= 0) {
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
						}
						
						if (player.inventory.addItemStackToInventory(newItemStack.copy())) {
							if (player instanceof EntityPlayerMP) {
								((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
							}
						} else {
							ModJammyFurniture.log.debug("Spawn new entity");
							world.spawnEntityInWorld(new EntityItem(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, newItemStack));
						}
						
						return true;
					}
				}
				
				world.addBlockEvent(pos, this, 2, 0);
				return true;
				
			} else 
			if (type == EnumType.TOILET) {
				
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
		}
		
		return false;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int parameter) {
		if (eventID == 2) {
			TileEntity te = world.getTileEntity(pos);
	
			if (te != null && te instanceof TileEntityCeramicBlocksOne) {
				TileEntityCeramicBlocksOne teCeramicBlocks = (TileEntityCeramicBlocksOne)te;
				
				teCeramicBlocks.toggleWater();
			}
			return true;
		}
		return super.onBlockEventReceived(world, pos, state, eventID, parameter);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, Entity entity, EntityPlayer player) {
		world.playSoundAtEntity(player, ModJammyFurniture.MODID.toLowerCase()+":toilet", 1.0F, 1.0F);
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.ceramicBlocksOneRenderID;
	}
	
}
