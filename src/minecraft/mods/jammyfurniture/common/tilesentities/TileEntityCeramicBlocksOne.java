package mods.jammyfurniture.common.tilesentities;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCeramicBlocksOne extends GCLInventoryTileEntity {
	
	
	public TileEntityCeramicBlocksOne() {
		super (8);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	// TODO traduire
	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return "Cupboard";
	}
	
}
