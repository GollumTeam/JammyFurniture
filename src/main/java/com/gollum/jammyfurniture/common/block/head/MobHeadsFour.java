package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;

import com.gollum.jammyfurniture.common.block.head.JFMobHeads.EnumType;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MobHeadsFour extends JFMobHeads {
	
	public MobHeadsFour(String registerName) {
		super(registerName, TileEntityMobHeadsFour.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumFacing facing = state.getValue(FACING);
		
		if (facing == EnumFacing.NORTH) this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
		if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
		if (facing == EnumFacing.WEST ) this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumType   type      = state.getValue(TYPE);
		EnumFacing facing    = state.getValue(FACING);
		
		if (type == EnumType.HEAD_1) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadEnderman, 1.0F, 1.0F, true);
			return true;
		} else 
		if (type == EnumType.HEAD_2) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadSlim, 1.0F, 1.0F, true);
			return true;
		} else
		if (type == EnumType.HEAD_3) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadBlaze, 1.0F, 1.0F, true);
			return true;
		} else 
		if (type == EnumType.HEAD_4) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadZombiepig, 1.0F, 1.0F, true);
			return true;
		}
		return false;
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ModJammyFurniture.mobHeadsFourRenderID;
	}
	
}
