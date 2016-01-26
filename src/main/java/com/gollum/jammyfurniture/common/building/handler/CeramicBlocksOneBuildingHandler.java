package com.gollum.jammyfurniture.common.building.handler;

import java.util.HashMap;
import java.util.Random;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CeramicBlocksOneBuildingHandler extends JFBlockHandler {
	
	@Override
	protected boolean mustApply (World world, BlockPos pos, IBlockState state) {
		return 
			state != null && state.getBlock() instanceof CeramicBlocksOne;
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
		/* FIXME
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = ((CeramicBlocksOne)block).getEnabledMetadata(metadata);
		
		if (
			subBlock == 4 ||
			subBlock == 8
		) {
			TileEntity te  = world.getTileEntity (x, y, z);
			if (te instanceof TileEntityCeramicBlocksOne) {
				
				boolean open = false; try { open = Boolean.parseBoolean(extra.get("open")); } catch (Exception e) {}
				
				if (((TileEntityCeramicBlocksOne) te).waterIsOn() != open) {
					((TileEntityCeramicBlocksOne) te).toggleWater();
				}
			}
		}
		*/
		
	}
}
