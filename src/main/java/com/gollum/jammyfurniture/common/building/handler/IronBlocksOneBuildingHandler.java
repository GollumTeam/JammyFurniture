package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class IronBlocksOneBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, BlockPos pos, IBlockState state) {
		return 
			state != null && state.getBlock() instanceof IronBlocksOne;
	}
	
	@Override
	public void applyOrientation(World world, BlockPos pos, IBlockState state, EnumFacing facing, EnumRotate rotate) {
		/* FIXME
		int subBlock = ((IronBlocksOne)block).getEnabledMetadata(metadata);
		
		if (
			subBlock == 0 ||
			subBlock == 4 ||
			subBlock == 8
		) {
			
			if (orientation == Unity.ORIENTATION_NONE)  { metadata = subBlock + 0; } else 
			if (orientation == Unity.ORIENTATION_UP)    { metadata = subBlock + 0; } else 
			if (orientation == Unity.ORIENTATION_DOWN)  { metadata = subBlock + 2; } else 
			if (orientation == Unity.ORIENTATION_LEFT)  { metadata = subBlock + 3; } else 
			if (orientation == Unity.ORIENTATION_RIGTH) { metadata = subBlock + 1; } else 
			{
				ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
			}
		}
		if (subBlock == 12) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TileEntityIronBlocksOne) {
				
				if (orientation == Unity.ORIENTATION_NONE)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 0; } else 
				if (orientation == Unity.ORIENTATION_UP)    { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 0; } else 
				if (orientation == Unity.ORIENTATION_DOWN)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 2; } else 
				if (orientation == Unity.ORIENTATION_LEFT)  { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 3; } else 
				if (orientation == Unity.ORIENTATION_RIGTH) { ((TileEntityIronBlocksOne) te).rubishBinOrientation = 1; } else 
				{
					ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
				}
			}
		}
		
		world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
		return;
		*/
	}
	
}
