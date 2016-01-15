package com.gollum.jammyfurniture.common.tilesentities.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.PART;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.TYPE;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumPart;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumType;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

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
	public String getCommandSenderName() {
		return ModJammyFurniture.i18n.trans("Wardrobe");
	}
	
	
	////////////
	// Update //
	////////////
	
	@Override
	public void update() {
		
		IBlockState state =  this.worldObj.getBlockState(this.pos);
		if (state.getValue(TYPE) == EnumType.WARDROBE && state.getValue(PART) == EnumPart.FOOT) {
			return;
		}
		super.update();
	}
	
}
