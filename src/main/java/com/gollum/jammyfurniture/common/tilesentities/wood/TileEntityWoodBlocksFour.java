package com.gollum.jammyfurniture.common.tilesentities.wood;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

public class TileEntityWoodBlocksFour extends GCLInventoryTileEntity {
	
	public TileEntityWoodBlocksFour() {
		super (20);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInvName() {
		return ModJammyFurniture.i18n.trans("Wardrobe");
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
		
		int metadata =  this.getBlockMetadata();
		
		if (metadata == 0 || metadata == 1 || metadata == 2 || metadata == 3) {
			return;
		}
		
		super.updateEntity();
	}
	
}
