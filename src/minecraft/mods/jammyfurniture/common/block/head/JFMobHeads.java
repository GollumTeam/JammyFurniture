package mods.jammyfurniture.common.block.head;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.jammyfurniture.common.block.JFMetadataBlock;

public abstract class JFMobHeads extends JFMetadataBlock {

	public JFMobHeads(int id, String registerName, Class tileEntityClass) {
		super(id, registerName, Material.cloth, "cloth", tileEntityClass, new int[]{ 0, 4, 8, 12 });
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);
		int orientation = this.getOrientation(entityliving);
	
		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}

}