package mods.jammyfurniture.common.tilesentities.ceramic;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.jammyfurniture.ModJammyFurniture;

public class TileEntityCeramicBlocksOne extends GCLInventoryTileEntity {

	private boolean waterOn = false;
	private long waterSoundTime = 0;
	
	public TileEntityCeramicBlocksOne() {
		super (8);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return ModJammyFurniture.i18n.trans("Cupboard");
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
		super.updateEntity ();
		
		if (!this.worldObj.isRemote) {
			if (this.waterIsOn()) {
				if ((System.currentTimeMillis() - this.waterSoundTime) > 2950) { 
					ModJammyFurniture.log.debug ("Play sound water");
					this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, ModJammyFurniture.MODID.toLowerCase()+":sink_water", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
					this.waterSoundTime = System.currentTimeMillis();
				}
			} else {
				this.waterSoundTime = 0;
			}
		}
	}
	
	////////////
	// Others //
	////////////
	
	public void toggleWater () {
		this.waterOn = !this.waterOn;
	}
	
	public boolean waterIsOn() {
		return this.waterOn;
	}
}
