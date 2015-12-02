package com.gollum.jammyfurniture.common.block.wood;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlockMetadata;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodBlocksTwo extends JFBlockMetadata {
	
	public WoodBlocksTwo(String registerName) {
		super(registerName, Material.wood, "wood", TileEntityWoodBlocksTwo.class, new int[] { 0, 4, 8, 12, 13, 14, 15 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 8:  
			case 10: this.setBlockBounds(0.0F, 0.0F, 0.2F, 1.0F, 0.75F, 0.8F); break;
			case 9:  
			case 11: this.setBlockBounds(0.2F, 0.0F, 0.0F, 0.8F, 0.75F, 1.0F); break;
			case 12: 
			case 13: 
			case 14: 
			case 15: this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.4F, 0.95F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
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
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	*/
	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null && te instanceof TileEntityWoodBlocksTwo) {
			TileEntityWoodBlocksTwo teWoodBlocks = (TileEntityWoodBlocksTwo)te;
			switch (subBlock) {
				
				case 0: 
				case 4: 
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_KITCHENCUPBOARD_ID, world, x, y, z);
					return true;
				case 8:
					
					world.addBlockEvent(x, y, z, this, 2, 0);
					return true;
					
				default: break;
			}
		}

		return false;
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
			
			if (te != null && te instanceof TileEntityWoodBlocksTwo) {
				TileEntityWoodBlocksTwo teWoodBlocks = (TileEntityWoodBlocksTwo)te;
				
				teWoodBlocks.tvTurnOn ();
			}
			
			return true;
		}
		return super.onBlockEventReceived(world, x, y, z, eventID, parameter);
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
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadtaID) {
		
		this.breakBlockInventory(world, x, y, z, oldBlock);
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadtaID);
	}
	*/
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.woodBlocksTwoRenderID;
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
		
		return false;
	}
	*/
	
}
