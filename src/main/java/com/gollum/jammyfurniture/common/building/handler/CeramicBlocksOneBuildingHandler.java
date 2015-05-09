package com.gollum.jammyfurniture.common.building.handler;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.world.World;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.building.Builder;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;

public class CeramicBlocksOneBuildingHandler extends BuildingBlockHandler {
	
	@Override
	protected boolean mustApply (World world, int x, int y, int z, Block block) {
		return block instanceof CeramicBlocksOne;
	}
	
	@Override
	public void applyOrientation(World world, int x, int y, int z, Block block, int metadata, int orientation, int rotate) {
		
		int subBlock = ((CeramicBlocksOne)block).getEnabledMetadata(metadata);
		
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
				ModGollumCoreLib.log.severe("Bad orientation : "+orientation+" name:"+block.getUnlocalizedName()+" pos:"+x+","+y+","+z);
			}
		}
		
		world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
		return;
		
	}

	protected void applyExtra(
		Block block,
		World world,
		Random random, 
		int x, int y, int z, 
		HashMap<String, String> extra,
		int initX, int initY, int initZ, 
		int rotate,
		int dx, int dz,
		int maxX, int maxZ
	) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = ((CeramicBlocksOne)block).getEnabledMetadata(metadata);
		
		if (
			subBlock == 4 ||
			subBlock == 8
		) {
			TileEntity te  = world.getBlockTileEntity (x, y, z);
			if (te instanceof TileEntityCeramicBlocksOne) {
				
				boolean open = false; try { open = Boolean.parseBoolean(extra.get("open")); } catch (Exception e) {}
				
				if (((TileEntityCeramicBlocksOne) te).waterIsOn() != open) {
					((TileEntityCeramicBlocksOne) te).toggleWater();
				}
			}
		}
		
		
	}
}
