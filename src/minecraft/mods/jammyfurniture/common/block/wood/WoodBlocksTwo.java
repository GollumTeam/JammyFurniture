package mods.jammyfurniture.common.block.wood;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WoodBlocksTwo extends JFMetadataBlock {
	
	public WoodBlocksTwo(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityWoodBlocksTwo.class, new int[] { 0, 4, 8, 12, 13, 14, 15 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	
	// TODO LES COLITIONS SON MAUVAISE
	@Override
	protected void getCollisionBoundingBox(int metadata) {
		switch (metadata) {
			case 8:  
			case 10: this.setBlockBounds(0.0F, 0.0F, 0.4F, 1.0F, 1.0F, 0.8F); break;
			case 9:  
			case 11: this.setBlockBounds(0.2F, 0.0F, 0.0F, 0.8F, 1.0F, 1.0F); break;
			case 12: 
			case 13: 
			case 14: 
			case 15: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			default: this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.4F, 0.95F);
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

		if (metadata == 0 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if (te != null && te instanceof TileEntityWoodBlocksTwo) {
			TileEntityWoodBlocksTwo teWoodBlocks = (TileEntityWoodBlocksTwo)te;
			switch (subBlock) {
				
				case 0: 
				case 4: 
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_KITCHENCUPBOARD_ID, world, x, y, z);
					return true;
					
				default: break;
			}
		}

		return false;
	}

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, int oldBlodkID, int oldMetadtaID) {
		
		this.helper.breakBlockInventory(world, x, y, z, oldBlodkID);
		
		super.breakBlock(world, x, y, z, oldBlodkID, oldMetadtaID);
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.woodBlocksTwoRenderID;
	}
}
