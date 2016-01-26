package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BlockDirectionalBuildingHandler;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.BathBlock;
import com.gollum.jammyfurniture.common.block.JFBlock;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksThree;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class JFBlockHandler extends BlockDirectionalBuildingHandler {
	
	@Override
	protected boolean mustApply (World world, BlockPos pos, Unity unity) {
		return 
			unity.state.getBlock() instanceof JFBlock
		;
	}
	
	@Override
	protected IBlockState applyBlockState(World world, BlockPos pos, IBlockState state, Unity unity, EnumRotate rotate) {
		Block block = state != null ? state.getBlock() : null;
		if (block instanceof IronBlocksOne) {
			if (state.getValue(IronBlocksOne.TYPE) == IronBlocksOne.EnumType.RUBBISH_BIN) {
				return state;
			}
		}
		return super.applyBlockState(world, pos, state, unity, rotate);
	}
	
}
