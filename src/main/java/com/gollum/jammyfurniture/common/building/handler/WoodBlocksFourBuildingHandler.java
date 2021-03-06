package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;

import net.minecraft.world.World;

public class WoodBlocksFourBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, int x, int y, int z, Unity unity) {
		return unity.block instanceof WoodBlocksFour;
	}
	
	@Override
	protected int applyMetadata(World world, int x, int y, int z, int metadata, Unity unity, int rotate) {
		
		int orientation = this.rotateOrientation(rotate, unity.orientation);
		
		int subBlock = metadata - (metadata%4);
		
		if (
			subBlock == 0 ||
			subBlock == 4 ||
			subBlock == 8 ||
			subBlock == 12
		) {
			
			if (orientation == Unity.ORIENTATION_NONE)  { metadata = subBlock + 0; } else 
			if (orientation == Unity.ORIENTATION_UP)    { metadata = subBlock + 0; } else 
			if (orientation == Unity.ORIENTATION_DOWN)  { metadata = subBlock + 2; } else 
			if (orientation == Unity.ORIENTATION_LEFT)  { metadata = subBlock + 3; } else 
			if (orientation == Unity.ORIENTATION_RIGTH) { metadata = subBlock + 1; } else 
			{
				ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+unity.block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
			}
		}
		
		return metadata;
		
	}
	
}
