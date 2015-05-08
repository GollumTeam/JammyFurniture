package com.gollum.jammyfurniture.common.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBath extends ItemBlock {
	
	private Block block;
	
	public ItemBath(int id, Block block) {
		super(id);
		this.block = block;
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	 @Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		if (side != 1) {
			return false;
		} else {
			++y;
			int orientation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			byte pos2X = 0;
			byte pos2Z = 0;

			if (orientation == 0) {
				pos2Z = 1;
			}

			if (orientation == 1) {
				pos2X = -1;
			}

			if (orientation == 2) {
				pos2Z = -1;
			}

			if (orientation == 3) {
				pos2X = 1;
			}

			if (
				player.canPlayerEdit(x        , y, z        , side, itemStack) && 
				player.canPlayerEdit(x + pos2X, y, z + pos2Z, side, itemStack)
			) {
				
				if (
					world.isAirBlock(x        , y, z) && 
					world.isAirBlock(x + pos2X, y, z + pos2Z) && 
					world.doesBlockHaveSolidTopSurface(x        , y - 1, z) && 
					world.doesBlockHaveSolidTopSurface(x + pos2X, y - 1, z + pos2Z)
				) {
					
					if (placeBlockAt(itemStack, player, world, x, y, z, side, hitX, hitY, hitZ, orientation & 0x7)) {
						
						placeBlockAt(itemStack, player, world, x + pos2X, y, z + pos2Z, side, hitX, hitY, hitZ, orientation | 0x8);
						
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
	}
}
