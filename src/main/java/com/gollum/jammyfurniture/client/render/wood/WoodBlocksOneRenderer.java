package com.gollum.jammyfurniture.client.render.wood;

import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.FACING;
import static com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.TYPE;

import java.util.Random;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelClockBase;
import com.gollum.jammyfurniture.client.model.wood.ModelClockMiddle;
import com.gollum.jammyfurniture.client.model.wood.ModelClockTop;
import com.gollum.jammyfurniture.client.model.wood.ModelKitchenSide;
import com.gollum.jammyfurniture.client.model.wood.ModelTable;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksOne.EnumType;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class WoodBlocksOneRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelClockBase   modelClockBase   = new ModelClockBase();
	private ModelClockMiddle modelClockMiddle = new ModelClockMiddle();
	private ModelClockTop    modelClockTop    = new ModelClockTop();
	private ModelBlinds      modelBlinds      = new ModelBlinds();
	private ModelKitchenSide modelKitchenSide = new ModelKitchenSide();
	private ModelTable       modelTable       = new ModelTable();
	private int numDial = 0;
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int newParam, int metadata) {
		
		float rotation = 0;
		IBlockState state = ModBlocks.blockWoodBlocksOne.getStateFromMeta(metadata);
		EnumFacing facing = state.getValue(FACING);
		EnumType type = state.getValue(TYPE);
		
		if (facing == EnumFacing.WEST ) { rotation = 90 ; } else
		if (facing == EnumFacing.SOUTH) { rotation = 180; } else
		if (facing == EnumFacing.EAST ) { rotation = 270; }
		
		if (this.isInventory) {
			rotation = 180;
		}
		
		if (type == EnumType.CLOCK_BASE   ) { this.renderModel(this.modelClockBase  , "clockbase"  , x, y, z, rotation); } else
		if (type == EnumType.CLOCK_MIDDLE ) { this.renderModel(this.modelClockMiddle, "clockmiddle", x, y, z, rotation); } else
		if (type == EnumType.CLOCK_TOP    ) {
			this.renderModelDial(x, y, z, rotation);
			this.renderModel(this.modelClockTop   , "clocktop"   , x, y, z, rotation); 
		} else	
		if (type == EnumType.BLINDS       ) { this.renderModel(this.modelBlinds     , "blinds"     , x, y, z, rotation); } else
		if (type == EnumType.CRAFTING_SIDE) { this.renderModel(this.modelKitchenSide, "craftside"  , x, y, z, rotation); } else
		if (type == EnumType.KITCHEN_SIDE ) { this.renderModel(this.modelKitchenSide, "kitchenside", x, y, z, rotation); } else
		if (type == EnumType.TABLE        ) { this.renderModel(this.modelTable      , "table"      , x, y, z, rotation); }
		
	}
	
	private void renderModelDial(double x, double y, double z, float rotation) {
		
		if (Minecraft.getMinecraft().theWorld != null) {
			
			if (Minecraft.getMinecraft().theWorld.provider.getDimensionId() >= 0) {
				long time = Minecraft.getMinecraft().theWorld.getWorldTime();
				double index = (double)time * 64.D / 24000.D;
				if (index < 0) {
					index = 64;
				}
				this.numDial = (int) Math.floor(index);
				this.numDial = (numDial+48) % 64;
			} else {
				
				int r = (new Random()).nextInt(3) - 1;
				if (r != 0) {
					this.numDial = (this.numDial + (r > 0 ? 1 : 63)) % 64;
				}
			}
			
		} else {
			this.numDial = 0;
		}
		
		this.beforeRender("clocktop-dial", x, y, z, rotation);
		this.modelClockTop.renderDial(this.numDial, 0.0625F);
		this.endRender();
	}
}
