package mods.jammyfurniture.common.tilesentities.wood;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityWoodBlocksOne extends GCLInventoryTileEntity {
	
	private int soundHitClock = 0;
	
	public TileEntityWoodBlocksOne() {
		super (6);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return "Hidey Hole";
	}
	
	////////////
	// Update //
	////////////
	
	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	public void updateEntity() {
		
		super.updateEntity();
		
		int id      = this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord);
		int metadta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		
		if (id != 0) {
			Block block = Block.blocksList[id];
			if (block instanceof IBlockMetadataHelper) {
				
				int subBlock = ((IBlockMetadataHelper)block).getEnabledMetadata(metadta);
				
				if (subBlock == 5) { // Clock top
					
					if (this.soundHitClock == 42) {
						
						double x = (double) this.xCoord + 0.5D;
						double y = (double) this.yCoord + 0.5D;
						double z = (double) this.zCoord + 0.5D;
						
						this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":clock-tick", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
						this.soundHitClock = 0;
						
					} else {
						this.soundHitClock++;
					}
				}
			}
		}
		
	}
}
