package com.gollum.jammyfurniture.common.block.head;

import com.gollum.jammyfurniture.common.block.JFBlock;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public abstract class JFMobHeads extends JFBlock {

	public JFMobHeads(String registerName, Class tileEntityClass) {
		super(registerName, Material.cloth, "cloth", tileEntityClass, new int[]{ 0, 4, 8, 12 });
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
	
		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	*/
	
	////////////
	// Others //
	////////////
	
	/* FIXME
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
	*/

}