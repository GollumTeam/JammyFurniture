package mods.jammyfurniture.client.render.wood;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.wood.ModelBlinds;
import mods.jammyfurniture.client.model.wood.ModelClockBase;
import mods.jammyfurniture.client.model.wood.ModelClockMiddle;
import mods.jammyfurniture.client.model.wood.ModelClockTop;
import mods.jammyfurniture.client.model.wood.ModelKitchenSide;
import mods.jammyfurniture.client.model.wood.ModelTable;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class WoodBlocksOneRenderer extends JFTileEntitySpecialRenderer {

	private final static ModelClockBase   modelClockBase   = new ModelClockBase();
	private final static ModelClockMiddle modelClockMiddle = new ModelClockMiddle();
	private final static ModelClockTop    modelClockTop    = new ModelClockTop();
	private final static ModelBlinds      modelBlinds      = new ModelBlinds();
	private final static ModelKitchenSide modelKitchenSide = new ModelKitchenSide();
	private final static ModelTable       modelTable       = new ModelTable();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockWoodBlocksOne).getEnabledMetadata(metadata);
		
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
		
		if (invRender) {
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
		int numDial = 0;
		
		if (Minecraft.getMinecraft().theWorld != null) {
			long time = Minecraft.getMinecraft().theWorld.getWorldTime();
			double index = (double)time * 64.D / 24000.D;
			if (index < 0) {
				index = 64;
			}
			numDial = (int) Math.floor(index);
			numDial = (numDial+48) % 64;
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef((float) rotation, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(this.getTexture("clocktop-dial"));
		GL11.glPushMatrix();
		this.modelClockTop.renderDial(numDial, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
