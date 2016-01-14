package com.gollum.jammyfurniture.common.item;

import com.gollum.core.tools.helper.items.HItemBlock;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemWoodBlocksFour extends HItemBlock {
	
	public ItemWoodBlocksFour(Block block) {
		super(block);
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		/* FIXME
		int orientation = ((WoodBlocksFour)ModBlocks.blockWoodBlocksFour).getOrientation(player);
		
		if (side != 1) {
			return false;
		} else {
			++y;
			if (
				player.canPlayerEdit(x, y    , z, side, itemStack) && 
				player.canPlayerEdit(x, y + 1, z, side, itemStack)
			) {
				
				if (
					world.isAirBlock(x, y    , z) && 
					world.isAirBlock(x, y + 1, z) && 
					world.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				) {
					
					if (placeBlockAt(itemStack, player, world, x, y, z, side, hitX, hitY, hitZ, itemStack.getItemDamage()+orientation)) {
						
						placeBlockAt(itemStack, player, world, x, y + 1, z, side, hitX, hitY, hitZ, itemStack.getItemDamage()+orientation + 4);
						
					} else {
						return false;
					}
					
					--itemStack.stackSize;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		*/ return false;
	}
}
