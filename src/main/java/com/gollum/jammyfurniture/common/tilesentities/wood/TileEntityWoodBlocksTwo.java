package com.gollum.jammyfurniture.common.tilesentities.wood;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

public class TileEntityWoodBlocksTwo extends GCLInventoryTileEntity {
	
	private long tvOn = 0;
	
	public TileEntityWoodBlocksTwo() {
		super(9);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the name of the inventory.
	 */
	@Override
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
	@Override
	public void updateEntity() {
		super.updateEntity ();
		if (this.tvIsOn () && (System.currentTimeMillis() - this.tvOn) > 6500) { // 6 seconde
			this.tvOn = 0;
		}
	}
	
	////////////
	// Others //
	////////////
	
	public void tvTurnOn () {
		this.tvOn = System.currentTimeMillis();
		if (!this.worldObj.isRemote) {
			this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, ModJammyFurniture.MODID.toLowerCase()+":radio", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
	
	public boolean tvIsOn () {
		return this.tvOn > 0;
	}
	
	////////////////
	// Save datas //
	////////////////

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		
		this.tvOn = nbtTagCompound.getLong("tvOn");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setLong("tvOn",  this.tvOn);
	}
	
	/////////////
	// Network //
	/////////////
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new Packet132TileEntityData(this.xCoord, this.yCoord,this.zCoord, 0, nbttagcompound);
	}
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		this.readFromNBT(pkt.data);
	}
}
