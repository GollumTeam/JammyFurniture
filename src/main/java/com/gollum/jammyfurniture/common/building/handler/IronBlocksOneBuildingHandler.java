package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class IronBlocksOneBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, int x, int y, int z, Block block) {
		return block instanceof IronBlocksOne;
	}
	
	@Override
	public void applyOrientation(World world, int x, int y, int z, Block block, int metadata, int orientation, int rotate) {
		
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
		
	}
	
}
