package mods.jammyfurniture.common.tilesentities.wood;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.jammyfurniture.ModJammyFurniture;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityWoodBlocksTwo extends GCLInventoryTileEntity {
	
	private int tvOn = 0;
	
	public TileEntityWoodBlocksTwo() {
		super(9);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	// TODO Trad 
	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return "Cupboard";
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
		if (this.tvIsOn ()) {
			this.tvOn--;
		}
	}
	
	////////////
	// Others //
	////////////
	
	public void tvTurnOn () {
		this.tvOn = 133;
		if (!this.worldObj.isRemote) {
			this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, ModJammyFurniture.MODID.toLowerCase()+":radio", 0.8F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
	
	public boolean tvIsOn () {
		return this.tvOn > 0;
	}
}
