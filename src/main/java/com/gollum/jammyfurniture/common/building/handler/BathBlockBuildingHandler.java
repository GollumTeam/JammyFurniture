package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.BathBlock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BathBlockBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, int x, int y, int z, Block block) {
		return block instanceof BathBlock;
	}
	
	@Override
	public void applyOrientation(World world, int x, int y, int z, Block block, int metadata, int orientation, int rotate) {
		
		int subBlock = ((BathBlock)block).isBlockHead(metadata) ? 4 : 0;
		
		if (orientation == Unity.ORIENTATION_NONE)  { metadata = subBlock + 0; } else 
		if (orientation == Unity.ORIENTATION_UP)    { metadata = subBlock + 0; } else 
		if (orientation == Unity.ORIENTATION_DOWN)  { metadata = subBlock + 2; } else 
		if (orientation == Unity.ORIENTATION_LEFT)  { metadata = subBlock + 3; } else 
		if (orientation == Unity.ORIENTATION_RIGTH) { metadata = subBlock + 1; } else 
		{
			ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
		}
		
		world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
		return;
		
	}
	
}
