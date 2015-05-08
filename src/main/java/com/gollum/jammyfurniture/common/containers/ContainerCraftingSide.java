package com.gollum.jammyfurniture.common.containers;

import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class ContainerCraftingSide extends ContainerWorkbench {
	
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerCraftingSide(IInventory inventoryPlayer, World world, int x, int y, int z) {
		super ((InventoryPlayer)inventoryPlayer, world, x, y, z);
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
	}

	public boolean canInteractWith(EntityPlayer player) {
		return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != ModBlocks.blockWoodBlocksOne.blockID ? false : player.getDistanceSq((double) this.posX + 0.5D, (double) this.posY + 0.5D, (double) this.posZ + 0.5D) <= 64.0D;
	}
}
