package com.gollum.jammyfurniture.common.building.handler;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CeramicBlocksOneBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, int x, int y, int z, Unity unity) {
		return unity.block instanceof CeramicBlocksOne;
	}
	
	@Override
	protected int applyMetadata(World world, int x, int y, int z, int metadata, Unity unity, int rotate) {
		
		int orientation = this.rotateOrientation(rotate, unity.orientation);
		
		int subBlock = ((CeramicBlocksOne)unity.block).getEnabledMetadata(metadata);
		
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

	@Override
	protected void applyExtra(
		World world,
		int x, int y, int z,
		Unity unity,
		int initX, int initY, int initZ,
		int rotate,
		int dx, int dz,
		int maxX, int maxZ
	) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = ((CeramicBlocksOne)unity.block).getEnabledMetadata(metadata);
		
		if (
			subBlock == 4 ||
			subBlock == 8
		) {
			TileEntity te  = world.getTileEntity (x, y, z);
			if (te instanceof TileEntityCeramicBlocksOne) {
				
				boolean open = false; try { open = Boolean.parseBoolean(unity.extra.get("open")); } catch (Exception e) {}
				
				if (((TileEntityCeramicBlocksOne) te).waterIsOn() != open) {
					((TileEntityCeramicBlocksOne) te).toggleWater();
				}
			}
		}
		
		
	}
}
