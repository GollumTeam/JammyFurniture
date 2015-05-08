package com.gollum.jammyfurniture.common.block;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IBlockUnmountEvent {
	
	public void onBlockPlacedBy(World world, int x, int y, int z, Entity entity, EntityPlayer player);
	
}
