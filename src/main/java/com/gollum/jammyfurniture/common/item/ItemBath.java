package com.gollum.jammyfurniture.common.item;

import static com.gollum.jammyfurniture.common.block.BathBlock.FACING;
import static com.gollum.jammyfurniture.common.block.BathBlock.PART;

import com.gollum.jammyfurniture.common.block.BathBlock.EnumPart;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBath extends ItemBlock {
	
	private Block block;
	
	public ItemBath(Block block) {
		super(block);
		this.block = block;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

		IBlockState state = ModBlocks.blockBathTub.getStateFromMeta(itemStack.getItemDamage());
		EnumFacing facing = player.getHorizontalFacing();
		BlockPos pos1 = pos.up();
		BlockPos pos2 = pos1.add(facing.getDirectionVec());
		
		if (
			side == EnumFacing.UP &&
			player.canPlayerEdit(pos1, side, itemStack) && 
			player.canPlayerEdit(pos2, side, itemStack) &&
			
			world.isAirBlock(pos1) && 
			world.isAirBlock(pos2) && 
			world.doesBlockHaveSolidTopSurface(world, pos)
		) {
			state = state
				.withProperty(FACING, facing)
			;
			
			if (placeBlockAt(itemStack, player, world, pos1, side, hitX, hitY, hitZ, state)) {
				
				state = state.withProperty(PART, EnumPart.RIGHT);
				placeBlockAt(itemStack, player, world, pos2, side, hitX, hitY, hitZ, state);
				
			} else {
				return false;
			}
			
			--itemStack.stackSize;
			return true;
		}
		return false;
	}
	
}
