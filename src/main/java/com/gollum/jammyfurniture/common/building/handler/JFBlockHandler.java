package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.common.building.Building.EnumRotate;
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
	protected boolean mustApply (World world, BlockPos pos, IBlockState state) {
		return 
			state != null && state.getBlock() instanceof JFBlock;
	}
	
	@Override
	public IBlockState applyBlockState(World world, BlockPos pos, IBlockState state, EnumRotate rotate) {
		Block block = state != null ? state.getBlock() : null;
		if (block instanceof IronBlocksOne) {
//			if (state.getValue(IronBlocksOne.TYPE) == IronBlocksOne.EnumType.RUBBISH_BIN) {
//				TileEntity te = world.getTileEntity(pos);
//				((TileEntityIronBlocksOne) te).rubishBinOrientation = state.getValue(IronBlocksOne.TYPE).
//				if (te instanceof TileEntityIronBlocksOne) {
//					
//					if (orientation == Unity.ORIENTATION_NONE)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 0; } else 
//					if (orientation == Unity.ORIENTATION_UP)    { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 0; } else 
//					if (orientation == Unity.ORIENTATION_DOWN)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 2; } else 
//					if (orientation == Unity.ORIENTATION_LEFT)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 3; } else 
//					if (orientation == Unity.ORIENTATION_RIGTH) { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 1; } else 
//					{
//						ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
//					}
//				}
//			}
		} else {
			state = super.applyBlockState(world, pos, state, rotate);
		}
		return state;
	}
	
}
