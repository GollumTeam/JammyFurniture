package com.gollum.jammyfurniture.client.render.wood;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.gollum.core.tools.helper.IBlockMetadataHelper;
import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelClockBase;
import com.gollum.jammyfurniture.client.model.wood.ModelClockMiddle;
import com.gollum.jammyfurniture.client.model.wood.ModelClockTop;
import com.gollum.jammyfurniture.client.model.wood.ModelKitchenSide;
import com.gollum.jammyfurniture.client.model.wood.ModelTable;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class WoodBlocksOneRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelClockBase   modelClockBase   = new ModelClockBase();
	private ModelClockMiddle modelClockMiddle = new ModelClockMiddle();
	private ModelClockTop    modelClockTop    = new ModelClockTop();
	private ModelBlinds      modelBlinds      = new ModelBlinds();
	private ModelKitchenSide modelKitchenSide = new ModelKitchenSide();
	private ModelTable       modelTable       = new ModelTable();
	private int numDial = 0;
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModBlocks.blockWoodBlocksOne).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 4:
			case 8:
			case 12:
				rotation = 90; break;
			case 3:
			case 7:
			case 11:
				rotation = 180; break;
			case 2:
			case 6:
			case 10:
				rotation = 270; break;
		}
		
		if (this.isInventory) {
			rotation = 180;
		}

		switch (subBlock) {
			default:
			case 0:  this.renderModel(this.modelClockBase  , "clockbase"  , x, y, z, rotation); break;
			case 1:  this.renderModel(this.modelClockMiddle, "clockmiddle", x, y, z, rotation); break;
			case 5:  
				this.renderModelDial(x, y, z, rotation);
				this.renderModel(this.modelClockTop   , "clocktop"   , x, y, z, rotation); 
				break;
			case 9:  this.renderModel(this.modelBlinds     , "blinds"     , x, y, z, rotation); break;
			case 13: this.renderModel(this.modelKitchenSide, "craftside"  , x, y, z, rotation); break;
			case 14: this.renderModel(this.modelKitchenSide, "kitchenside", x, y, z, rotation); break;
			case 15: this.renderModel(this.modelTable      , "table"      , x, y, z, rotation); break;
		}
	}
	
	private void renderModelDial(double x, double y, double z, float rotation) {
		
		if (Minecraft.getMinecraft().theWorld != null) {
			
			if (Minecraft.getMinecraft().theWorld.provider.dimensionId >= 0) {
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
