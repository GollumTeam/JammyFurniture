package com.gollum.jammyfurniture.common.block.wood;

import java.util.Random;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.item.ItemWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class WoodBlocksFour extends JFMetadataBlock {
	
	public WoodBlocksFour(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityWoodBlocksFour.class, new int[] { 0, 8 });
		
		this.setItemBlockClass(ItemWoodBlocksFour.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		int subBlock = this.getEnabledMetadata(metadata);
		switch (subBlock) {
			case 0:  this.setBlockBounds(0.06F, 0.0F, 0.06F, 0.94F, 0.95F, 0.94F); break;
			case 8:  
				if (isSelectBox) {
					this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F); 
				}else {
					this.setBlockBounds(0.47F, 0.0F, 0.47F, 0.53F, 1.0F, 0.53F);
				}
				break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
	
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
	 */
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
		
		int y2 = y+1;
		if (this.isBlockHead(metadata)) {
			y2 = y-1;
		}
		
		if (world.getBlockId(x, y2, z) == this.blockID) {
			world.destroyBlock(x, y2, z, true);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if (te != null && te instanceof TileEntityWoodBlocksFour) {
			
			TileEntityWoodBlocksFour teWoodBlocks = (TileEntityWoodBlocksFour)te;
			
			switch (metadata) {
				case 4:
				case 5:
				case 6:
				case 7:
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_WARDROBE_ID, world, x, y, z);
					return true;
					
				default:
					break;
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
		
		this.breakBlockInventory(world, x, y, z, oldBlodkID);
		
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
		return ClientProxyJammyFurniture.woodBlocksFourRenderID;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int metadata, Random random, int j) {
		return this.isBlockHead(metadata) ? super.idDropped(metadata, random, j): 0;
	}

	public static boolean isBlockHead(int metadata) {
		return 
			(metadata == 4  || metadata == 5  || metadata == 6  || metadata == 7) ||
			(metadata == 12 || metadata == 13 || metadata == 14 || metadata == 15);
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		if (this.isBlockHead(metadata)) {
			subBlock += 4;
		}
		
		world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
		
		y += this.isBlockHead(metadata) ? -1 : 1;
		metadata = world.getBlockMetadata(x, y, z);
		subBlock = this.getEnabledMetadata(metadata);
		if (this.isBlockHead(metadata)) {
			subBlock += 4;
		}
		world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
		
		return true;
	}
}
