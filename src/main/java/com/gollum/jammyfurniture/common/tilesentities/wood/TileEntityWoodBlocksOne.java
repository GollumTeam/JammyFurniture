package com.gollum.jammyfurniture.common.tilesentities.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.TYPE;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.core.tools.helper.IBlockHelper;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.EnumType;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWoodBlocksOne extends GCLInventoryTileEntity {

	private long soundTimeClock = 0;
	private boolean soundDongClock = false;
	
	public TileEntityWoodBlocksOne() {
		super (6);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	@Override
	public String getName() {
		return ModJammyFurniture.i18n.trans("Hidey Hole");
	}
	
	////////////
	// Update //
	////////////
	
	@Override
	public void update() {
		
		super.update();
		
		IBlockState state = this.worldObj.getBlockState(this.pos);
		Block block = state.getBlock();
		
		if (block instanceof WoodBlocksOne) {
			
			if (EnumType.CLOCK_TOP == state.getValue(TYPE)) { // Clock top
				
				double x = (double) this.pos.getX() + 0.5D;
				double y = (double) this.pos.getY() + 0.5D;
				double z = (double) this.pos.getZ() + 0.5D;
				
				int time = (int)this.worldObj.getWorldTime();
				int hour = ((time / 1000)+6) % 24;
				int min = (time - (time/1000)*1000) * 60 / 1000;
				
				if (!soundDongClock && (hour == 0 || hour == 12) && min == 0) {
					soundDongClock = true;
					this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":clock-dong", 0.15F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
				}
				if (min != 0) {
					soundDongClock = false;
				}
				
				if (System.currentTimeMillis() - this.soundTimeClock >= 2000) { // gestion du tic tac
					this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":clock-tick", 0.25F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
					this.soundTimeClock = System.currentTimeMillis();
					
				}
			}
		}
		
	}
}
