package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;

import com.gollum.jammyfurniture.common.block.head.JFMobHeads.EnumType;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MobHeadsThree extends JFMobHeads {
	
	public MobHeadsThree(String registerName) {
		super(registerName, TileEntityMobHeadsThree.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(IBlockState state, boolean isSelectBox) {
		
		EnumType type = (EnumType) state.getValue(TYPE);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);

		if (type == EnumType.HEAD_1) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else 
		if (type == EnumType.HEAD_2) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.3F, 0.25F, 0.55F, 0.7F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.3F, 0.45F, 0.75F, 0.7F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.3F, 0.25F, 0.0F, 0.7F, 0.75F, 0.45F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.55F, 0.25F, 0.3F, 1.0F, 0.75F, 0.7F);
		} else 
		if (type == EnumType.HEAD_3) {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		} else {
			if (facing == EnumFacing.NORTH) this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
			if (facing == EnumFacing.EAST ) this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
			if (facing == EnumFacing.SOUTH) this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
			if (facing == EnumFacing.WEST ) this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
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
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadSteve, 1.0F, 1.0F, true);
			return true;
		} else 
		if (type == EnumType.HEAD_2) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadWolf, 1.0F, 1.0F, true);
			return true;
		} else
		if (type == EnumType.HEAD_3) {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), config.soundHeadZombie, 1.0F, 1.0F, true);
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
		return ModJammyFurniture.mobHeadsThreeRenderID;
	}
	
}
