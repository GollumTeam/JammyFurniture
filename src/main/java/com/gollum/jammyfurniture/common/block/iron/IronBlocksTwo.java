package com.gollum.jammyfurniture.common.block.iron;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFBlockMetadata;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;

import net.minecraft.block.material.Material;

public class IronBlocksTwo extends JFBlockMetadata {
	
	public IronBlocksTwo(String registerName) {
		super(registerName, Material.iron, "iron", TileEntityIronBlocksTwo.class, new int[]{ 0, 4 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////

	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	*/
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(player);
		int subBlock    = this.getEnabledMetadata(metadata);
		TileEntity te   = world.getTileEntity(x, y, z);
		
		if (te != null && te instanceof TileEntityIronBlocksTwo) {
			TileEntityIronBlocksTwo teIron = (TileEntityIronBlocksTwo)te;
			switch (subBlock) {
			
				case 0: // Le Dishwasher
					
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_DISHWASHER_ID, world, x, y, z);
					return true;
					
				case 4: // Le WashingMachine

					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_WASHINGMACHINE_ID, world, x, y, z);
					return true;
				
			}
		}
		return false;
	}
	*/
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	/* FIXME
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) {
		
		this.breakBlockInventory(world, x, y, z, oldBlock);
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
	}
	*/
	
	///////////////////
	// Data du block //
	///////////////////

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return ModJammyFurniture.ironBlocksTwoRenderID;
	}
	
	////////////
	// Others //
	////////////
	
	/* FIXME
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
	*/
}
