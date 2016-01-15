package com.gollum.jammyfurniture.common.item;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.FACING;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.TYPE;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.PART;

import com.gollum.core.tools.helper.items.HItemBlock;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumPart;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour.EnumType;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemWoodBlocksFour extends HItemBlock {
	
	public ItemWoodBlocksFour(Block block) {
		super(block);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

		IBlockState state = ModBlocks.blockWoodBlocksFour.getStateFromMeta(itemStack.getItemDamage());
		EnumType type = state.getValue(TYPE);
		

		if (
			side == EnumFacing.UP &&
			player.canPlayerEdit(pos.up(), side, itemStack) && 
			player.canPlayerEdit(pos.up().up(), side, itemStack) &&
			
			world.isAirBlock(pos.up()) && 
			world.isAirBlock(pos.up().up()) && 
			world.doesBlockHaveSolidTopSurface(world, pos)
		) {
			state = state
				.withProperty(PART, EnumPart.FOOT)
				.withProperty(FACING, ((WoodBlocksFour)ModBlocks.blockWoodBlocksFour).getOrientation(player))
			;
			
			if (placeBlockAt(itemStack, player, world, pos.up(), side, hitX, hitY, hitZ, state)) {
				
				state = state.withProperty(PART, EnumPart.HEAD);
				placeBlockAt(itemStack, player, world, pos.up().up(), side, hitX, hitY, hitZ, state);
				
			} else {
				return false;
			}
			
			--itemStack.stackSize;
			return true;
		}
		return false;
	}
}
