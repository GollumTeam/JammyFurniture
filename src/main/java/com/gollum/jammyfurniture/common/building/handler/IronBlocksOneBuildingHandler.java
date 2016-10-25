package com.gollum.jammyfurniture.common.building.handler;

import static com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.TYPE;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class IronBlocksOneBuildingHandler extends JFBlockHandler {
	
	@Override
	protected boolean mustApply (World world, BlockPos pos, Unity unity) {
		return unity.state.getBlock() instanceof IronBlocksOne;
	}

	@Override
	protected IBlockState applyBlockState(World world, BlockPos pos, IBlockState state, Unity unity, EnumRotate rotate) {
		return state;
	}
	
	@Override
	protected void applyExtra(
		World world,
		BlockPos pos,
		Unity unity,
		BlockPos initPos,
		EnumRotate rotate,
		int maxX, int maxZ
	) {

		EnumType   type   = (EnumType) unity.state.getValue(TYPE);
		EnumFacing facing = (EnumFacing) unity.state.getValue(FACING);
		
		if (type == EnumType.RUBBISH_BIN) {
			TileEntity te = world.getTileEntity(pos);
			if (te instanceof TileEntityIronBlocksOne) {
				((TileEntityIronBlocksOne) te).rubishBinOrientation = (short)this.rotateFacing(rotate, facing).getHorizontalIndex();
			}
		}
	}
	
}
