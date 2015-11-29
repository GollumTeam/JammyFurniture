package com.gollum.jammyfurniture.common.containers;

import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerCraftingSide extends ContainerWorkbench {
	
	private World worldObj;
	private BlockPos pos;
	
	public ContainerCraftingSide(IInventory inventoryPlayer, World world, BlockPos pos) {
		super ((InventoryPlayer)inventoryPlayer, world, pos);
		this.worldObj = world;
		this.pos = pos;
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		return this.worldObj.getBlockState(pos).getBlock() != ModBlocks.blockWoodBlocksOne ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
}
