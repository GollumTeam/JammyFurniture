package com.gollum.jammyfurniture.common.tilesentities.ceramic;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

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
	@Override
	public String getCommandSenderName() {
		return ModJammyFurniture.i18n.trans("Cupboard");
	}
	
	////////////
	// Update //
	////////////
	
	@Override
	public void update() {
		super.update();
		
		if (!this.worldObj.isRemote) {
			if (this.waterIsOn()) {
				if ((System.currentTimeMillis() - this.waterSoundTime) > 2950) { 
					ModJammyFurniture.log.debug ("Play sound water");
					this.worldObj.playSoundEffect(this.pos.getX(), this.pos.getY(), this.pos.getZ(), ModJammyFurniture.MODID.toLowerCase()+":sink_water", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
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
	
	////////////////
	// Save datas //
	////////////////

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		
		this.waterOn = nbtTagCompound.getBoolean("waterOn");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setBoolean("waterOn",  this.waterOn);
	}
	
	/////////////
	// Network //
	/////////////
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.pos, 0, nbttagcompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}
	
}
