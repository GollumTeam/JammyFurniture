package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksTwo;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WoodBlocksTwoBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, BlockPos pos, IBlockState state) {
		return 
			state != null && state.getBlock() instanceof WoodBlocksTwo;
	}
	
	@Override
	public void applyOrientation(World world, BlockPos pos, IBlockState state, EnumFacing facing, EnumRotate rotate) {
		/* FIXME
		int subBlock = ((WoodBlocksTwo)block).getEnabledMetadata(metadata);
		
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
		
		world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
		return;
		*/
	}
	
}
