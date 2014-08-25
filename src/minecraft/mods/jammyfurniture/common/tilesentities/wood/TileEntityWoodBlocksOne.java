package mods.jammyfurniture.common.tilesentities.wood;

import mods.gollum.core.tileentities.GCLInventoryTileEntity;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityWoodBlocksOne extends GCLInventoryTileEntity {
	public static int md;
	
//	public int numUsingPlayers;
	private int cachedChestType = -1;

	public TileEntityWoodBlocksOne() {
		super (6);
	}

	public TileEntityWoodBlocksOne(int metadata) {
		super (6);
		md = metadata;
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


//	public void onTileEntityPowered(int par1, int par2) {
//		if (par1 == 1) {
//			this.numUsingPlayers = par2;
//		}
//	}
	
//	/**
//	 * Called when a client event is received with the event number and
//	 * argument, see World.sendClientEvent
//	 */
//	public boolean receiveClientEvent(int par1, int par2) {
//		if (par1 == 1) {
//			this.numUsingPlayers = par2;
//			return true;
//		} else {
//			return super.receiveClientEvent(par1, par2);
//		}
//	}
	

//	public int getChestType() {
//		if (this.cachedChestType == -1) {
//			if (this.worldObj == null || !(this.getBlockType() instanceof BlockChest)) {
//				return 0;
//			}
//
//			this.cachedChestType = ((BlockChest) this.getBlockType()).chestType;
//		}
//
//		return this.cachedChestType;
//	}
}
