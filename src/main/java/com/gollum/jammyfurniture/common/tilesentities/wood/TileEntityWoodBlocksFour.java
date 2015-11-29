package com.gollum.jammyfurniture.common.tilesentities.wood;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWoodBlocksFour extends GCLInventoryTileEntity {

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommandSenderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGuiID() {
		// TODO Auto-generated method stub
		return null;
	}
//	FIXME
	public TileEntityWoodBlocksFour() {
		super (20);
	}
//	
//	///////////////
//	// Inventory //
//	///////////////
//	
//	/**
//	 * Returns the name of the inventory.
//	 */
//	@Override
//	public String getInventoryName() {
//		return ModJammyFurniture.i18n.trans("Wardrobe");
//	}
//	
//	
//	////////////
//	// Update //
//	////////////
//	
//	/**
//	 * Allows the entity to update its state. Overridden in most subclasses,
//	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
//	 * inside its implementation.
//	 */
//	@Override
//	public void updateEntity() {
//		
//		int metadata =  this.getBlockMetadata();
//		
//		if (metadata == 0 || metadata == 1 || metadata == 2 || metadata == 3) {
//			return;
//		}
//		
//		super.updateEntity();
//	}
//	
}
