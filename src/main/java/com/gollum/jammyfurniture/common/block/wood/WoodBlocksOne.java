package com.gollum.jammyfurniture.common.block.wood;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class WoodBlocksOne extends JFMetadataBlock {
	
	public WoodBlocksOne(String registerName) {
		super(registerName, Material.wood, "wood", TileEntityWoodBlocksOne.class, new int[] { 0, 1, 5, 9, 13, 14, 15 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
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
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 1 || metadata == 5 || metadata == 9) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World World, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(World, x, y, z, block);
		
		TileEntityWoodBlocksOne titleEntity = (TileEntityWoodBlocksOne) World.getTileEntity(x, y, z);

		if (titleEntity != null) {
			titleEntity.updateContainingBlockInfo();
		}
	}
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadtaID) {
		
		this.breakBlockInventory(world, x, y, z, oldBlock);
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadtaID);
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		ItemStack itemStack = player.inventory.getCurrentItem();
		TileEntity te = world.getTileEntity(x, y, z);
		
		switch (subBlock) {
			
			case 1: // Horloge milieux
				
				// Exclus les les block horloge sauf sur la port
				if (
					this.isClock(itemStack) && !(
						(metadata == 1 && side == 2) ||
						(metadata == 3 && side == 3) ||
						(metadata == 4 && side == 4) ||
						(metadata == 2 && side == 5)
					)
				
				) {
					return false;
				}
				
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CLOCK_ID, world, x, y, z);
					return true;
				}
				break;
				
			case 5:
				
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
				
			case 9: // Le store en position initial
				world.setBlock(x, y, z, ModBlocks.blockWoodBlocksThree, metadata-1, 2); // Les autres stores sont dans le block wood 3
				return true;
				
				
			case 13:
				
				if (te != null && te instanceof TileEntityWoodBlocksOne) {
					TileEntityWoodBlocksOne teWoodBlocks = (TileEntityWoodBlocksOne)te;
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_CRAFTSIDE_ID, world, x, y, z);
					return true;
				}
				break;
					
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
		
		Item item    = itemStack.getItem();
		int subBlock = this.getEnabledMetadata(itemStack.getItemDamage());
		
		return 
			itemStack !=  null &&
			item == this.getBlockItem() && (
				subBlock == 0 ||
				subBlock == 1 ||
				subBlock == 5
			)
		;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksOneRenderID;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 1 || subBlock == 5 || subBlock == 9) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}

}
