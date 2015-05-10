package com.gollum.jammyfurniture.common.tilesentities.wood;

import net.minecraft.block.Block;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.jammyfurniture.ModJammyFurniture;

public class TileEntityWoodBlocksOne extends GCLInventoryTileEntity {
	
	private long soundTimeClock = 0;
	private boolean soundDongClock = false;
	
	public TileEntityWoodBlocksOne() {
		super (6);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInventoryName() {
		return ModJammyFurniture.i18n.trans("Hidey Hole");
	}
	
	
	////////////
	// Update //
	////////////
	
	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	@Override
	public void updateEntity() {
		
		super.updateEntity();
		
		Block block = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
		int metadta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		
		if (block instanceof IBlockMetadataHelper) {
			
			int subBlock = ((IBlockMetadataHelper)block).getEnabledMetadata(metadta);
			
			if (subBlock == 5) { // Clock top
				
				double x = (double) this.xCoord + 0.5D;
				double y = (double) this.yCoord + 0.5D;
				double z = (double) this.zCoord + 0.5D;
				
				int time = (int)this.worldObj.getWorldTime();
				int hour = ((time / 1000)+6) % 24;
				int min = (time - (time/1000)*1000) * 60 / 1000;
				
				if (!soundDongClock && (hour == 0 || hour == 12) && min == 0) {
					soundDongClock = true;
					this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":clock-dong", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
				}
				if (min != 0) {
					soundDongClock = false;
				}
				
				if (System.currentTimeMillis() - this.soundTimeClock >= 2000) { // gestion du tic tac
					this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":clock-tick", 0.25F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
					this.soundTimeClock = System.currentTimeMillis();
					
				}
			}
		}
		
	}
}
