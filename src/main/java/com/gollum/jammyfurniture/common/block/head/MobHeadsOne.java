package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;

import com.gollum.jammyfurniture.common.block.head.JFMobHeads.EnumType;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MobHeadsOne extends JFMobHeads {
	
	public MobHeadsOne(String registerName) {
		super(registerName, TileEntityMobHeadsOne.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {

		EnumType type = (EnumType) state.getValue(TYPE);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);

		if (type == EnumType.HEAD_1) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.3F, 0.3F, 0.6F, 0.7F, 0.8F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.3F, 0.3F, 0.4F, 0.8F, 0.7F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.3F, 0.3F, 0.0F, 0.7F, 0.8F, 0.4F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.6F, 0.3F, 0.3F, 1.0F, 0.8F, 0.7F);
		} else 
		if (type == EnumType.HEAD_2) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.25F, 0.25F, 0.625F, 0.75F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.375F, 0.75F, 0.75F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.375F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.625F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else 
		if (type == EnumType.HEAD_3) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.2F, 0.05F, 0.1F, 0.8F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.05F, 0.2F, 0.9F, 0.75F, 0.8F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.2F, 0.05F, 0.0F, 0.8F, 0.75F, 0.9F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.1F, 0.05F, 0.2F, 1.0F, 0.75F, 0.8F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		EnumType   type      = (EnumType) state.getValue(TYPE);
		EnumFacing facing    = (EnumFacing) state.getValue(FACING);
		
		if (type == EnumType.HEAD_1) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadChicken, 1.0F, 1.0F, true);
			return true;
		} else 
		if (type == EnumType.HEAD_2) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadCow, 1.0F, 1.0F, true);
			return true;
		} else
		if (type == EnumType.HEAD_3) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadCreeper, 1.0F, 1.0F, true);
			return true;
		} else 
		if (type == EnumType.HEAD_4) {
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
		return ModJammyFurniture.mobHeadsOneRenderID;
	}
}
