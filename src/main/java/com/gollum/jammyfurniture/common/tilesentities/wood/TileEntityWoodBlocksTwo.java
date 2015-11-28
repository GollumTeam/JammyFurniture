package com.gollum.jammyfurniture.common.tilesentities.wood;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

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
	public String getInventoryName() {
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
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,this.zCoord, 0, nbttagcompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
}
