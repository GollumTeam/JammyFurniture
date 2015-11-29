package com.gollum.jammyfurniture.common.tilesentities.ceramic;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCeramicBlocksOne extends GCLInventoryTileEntity {
//	TODO
	private boolean waterOn = false;
	private long waterSoundTime = 0;
	
	public TileEntityCeramicBlocksOne() {
		super (8);
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
//		return ModJammyFurniture.i18n.trans("Cupboard");
//	}
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
//		super.updateEntity ();
//		
//		if (!this.worldObj.isRemote) {
//			if (this.waterIsOn()) {
//				if ((System.currentTimeMillis() - this.waterSoundTime) > 2950) { 
//					ModJammyFurniture.log.debug ("Play sound water");
//					this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, ModJammyFurniture.MODID.toLowerCase()+":sink_water", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
//					this.waterSoundTime = System.currentTimeMillis();
//				}
//			} else {
//				this.waterSoundTime = 0;
//			}
//		}
//	}
//	
//	////////////
//	// Others //
//	////////////
	
	public void toggleWater () {
		this.waterOn = !this.waterOn;
	}
	
	public boolean waterIsOn() {
		return this.waterOn;
	}
//	
//	////////////////
//	// Save datas //
//	////////////////
//
//	@Override
//	public void readFromNBT(NBTTagCompound nbtTagCompound) {
//		super.readFromNBT(nbtTagCompound);
//		
//		this.waterOn = nbtTagCompound.getBoolean("waterOn");
//	}
//	
//	@Override
//	public void writeToNBT(NBTTagCompound nbtTagCompound) {
//		super.writeToNBT(nbtTagCompound);
//		
//		nbtTagCompound.setBoolean("waterOn",  this.waterOn);
//	}
//	
//	/////////////
//	// Network //
//	/////////////
//	
//	@Override
//	public Packet getDescriptionPacket() {
//		NBTTagCompound nbttagcompound = new NBTTagCompound();
//		this.writeToNBT(nbttagcompound);
//		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,this.zCoord, 0, nbttagcompound);
//	}
//	
//	@Override
//	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
//		this.readFromNBT(pkt.func_148857_g());
//	}
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
}
