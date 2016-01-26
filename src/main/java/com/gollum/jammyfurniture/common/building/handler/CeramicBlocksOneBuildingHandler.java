package com.gollum.jammyfurniture.common.building.handler;

import static com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.TYPE;

import com.gollum.core.common.building.Building.EnumRotate;
import com.gollum.core.common.building.Building.Unity;
import com.gollum.core.common.building.handler.BuildingBlockHandler;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne;
import com.gollum.jammyfurniture.common.block.ceramic.CeramicBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CeramicBlocksOneBuildingHandler extends BuildingBlockHandler {

	@Override
	protected boolean mustApply (World world, BlockPos pos, Unity unity) {
		return unity.state.getBlock() instanceof CeramicBlocksOne;
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
		EnumType type = unity.state.getValue(TYPE);
		
		if (
			type == EnumType.BATHROOM_SINK ||
			type == EnumType.KITCHEN
		) {
			TileEntity te  = world.getTileEntity (pos);
			if (te instanceof TileEntityCeramicBlocksOne) {
				
				boolean open = false; try { open = Boolean.parseBoolean(unity.extra.get("open")); } catch (Exception e) {}
				
				if (((TileEntityCeramicBlocksOne) te).waterIsOn() != open) {
					((TileEntityCeramicBlocksOne) te).toggleWater();
				}
			}
		}
	}
}
