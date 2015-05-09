package com.gollum.jammyfurniture.client.render.wood;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gollum.jammyfurniture.client.model.wood.ModelBlinds;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardBottom;
import com.gollum.jammyfurniture.client.model.wood.ModelCupboardTop;
import com.gollum.jammyfurniture.client.model.wood.ModelStandBase;
import com.gollum.jammyfurniture.client.model.wood.ModelStandTop;
import com.gollum.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import com.gollum.jammyfurniture.common.block.wood.WoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class WoodBlocksFourRenderer extends JFTileEntitySpecialRenderer {

	private ModelCupboardTop    modelCupboardTop    = new ModelCupboardTop();
	private ModelCupboardBottom modelCupboardBottom = new ModelCupboardBottom();
	private ModelStandTop       modelStandTop       = new ModelStandTop();
	private ModelStandBase      modelStandBase      = new ModelStandBase();
	private ModelBlinds blinds = new ModelBlinds();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {

		TileEntityWoodBlocksFour tileEntityWood = (TileEntityWoodBlocksFour)tileEntity;
		int subBlock = ((WoodBlocksFour)ModBlocks.blockWoodBlocksFour).getEnabledMetadata(metadata);
		
		float rotation = 0;
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 9:
			case 13:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
			case 14:
				rotation = 180; break;
			case 1:
			case 5:
			case 11:
			case 15:
				rotation = 270; break;
		}
		
		if (invRender) {
			this.renderInInventory(subBlock, x, y, z);
			return;
		}
		
		float doorProgess = tileEntityWood.getPreviousDoorOpenProgress() + (tileEntityWood.getDoorOpenProgress() - tileEntityWood.getPreviousDoorOpenProgress()) * f;
		
		switch (metadata) {
			default:
			case 0:
			case 1:
			case 2:
			case 3:
				this.renderModel(this.modelCupboardBottom, "cupboard", x, y, z, rotation);
				break;
			case 4:
			case 5:
			case 6:
			case 7:
				this.renderModel(this.modelCupboardTop, "cupboard", x, y, z, rotation, doorProgess);
				break;
			case 8:
			case 9:
			case 10:
			case 11:
				this.renderModel(new ModelStandBase(), "coatstandbase", x, y, z, rotation);
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, rotation);
				break;
		}
	}
	

	private void renderInInventory(int subBlock, double x, double y, double z) {
		switch (subBlock) {
			default:
			case 0:
				ResourceLocation texture = this.getTexture("cupboard");
				GL11.glPushMatrix();
				GL11.glTranslatef((float) x + 0.5F, (float) y + 2.0F, (float) z + 0.5F);
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
				this.bindTexture(texture);
				GL11.glPushMatrix();
				this.modelCupboardTop.renderModel(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glTranslatef((float) x + 0.5F, (float) y + 1.0F, (float) z + 0.5F);
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
				this.bindTexture(texture);
				GL11.glPushMatrix();
				this.modelCupboardBottom.renderModel(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				break;
			case 8:
				this.renderModel(this.modelStandTop, "coatstandtop", x, y, z, 180.0F);
				break;
		}
	}
	
}