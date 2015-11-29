package com.gollum.jammyfurniture.common.block.iron;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlockMetadata;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;

import net.minecraft.block.material.Material;

public class IronBlocksOne extends JFBlockMetadata {
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public IronBlocksOne(String registerName) {
		super(registerName, Material.iron, "iron", TileEntityIronBlocksOne.class, new int[]{ 0, 4, 8, 12, 13 });
		this.tileEntityClass = TileEntityIronBlocksOne.class;
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  
			case 2:  
			case 4:  
			case 6:  this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F); break;
			case 1:  
			case 3:  
			case 5:  
			case 7:  this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F); break;
			case 12: this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	/* FIXME
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);
		int orientation = this.getOrientation(entityliving);
		
		if (metadata == 0 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
		if (subBlock == 12) {
			world.addBlockEvent(x, y, z, this, 2, orientation);
		}
	}
	*/
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	/* FIXME
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) {
		
		this.breakBlockInventory(world, x, y, z, oldBlock);
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
	}
	*/
	
	/**
	* Called when the block receives a BlockEvent - see World.addBlockEvent. By default, passes it on to the tile
	* entity at this location. Args: world, x, y, z, blockID, EventID, event parameter
	*/
	/* FIXME
	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventID, int parameter) {
		if (eventID == 2) {
			TileEntity te = world.getTileEntity(x, y, z);
	
			if (te != null && te instanceof TileEntityIronBlocksOne) {
				TileEntityIronBlocksOne teIronBlocks = (TileEntityIronBlocksOne)te;
				
				teIronBlocks.rubishBinOrientation = (short) parameter;
			}
			
			return true;
		}
		return super.onBlockEventReceived(world, x, y, z, eventID, parameter);
	}
	*/
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(player);
		int subBlock    = this.getEnabledMetadata(metadata);
		TileEntity te   = world.getTileEntity(x, y, z);
		
		if (te != null && te instanceof TileEntityIronBlocksOne) {
			TileEntityIronBlocksOne teIron = (TileEntityIronBlocksOne)te;
			
			switch (subBlock) {
				
				case 0: // Le frigo
				case 4: // Le freezer
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_FRIDGE_ID, world, x, y, z);
					return true;
					
				case 8: // Le four a gateau
					
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_COOKER_ID, world, x, y, z);
					return true;
					
				case 12: // La poubelle
					
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_RUBBISHBIN_ID, world, x, y, z);
					return true;
					
				default:
					break;
			}
			
		}
		
		return false;
	}
	*/
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.ironBlocksOneRenderID;
	}
	
	////////////
	// Others //
	////////////

	/* FIXME
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		if (subBlock == 12) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TileEntityIronBlocksOne) {
				int o = ((TileEntityIronBlocksOne) te).rubishBinOrientation;
				((TileEntityIronBlocksOne) te).rubishBinOrientation = (short) ((o + rotate) % 4);
				world.func_147479_m(x, y, z);
			}
			return true;
		}
		
		return false;
	}
	*/
}
