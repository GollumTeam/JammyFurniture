package mods.jammyfurniture.client.render.iron;

import mods.jammyfurniture.client.model.iron.jfm_ModelCoffeeTable;
import mods.jammyfurniture.client.model.iron.jfm_ModelCooker;
import mods.jammyfurniture.client.model.iron.jfm_ModelFridge;
import mods.jammyfurniture.client.model.iron.jfm_ModelRubbishBin;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class IronBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private jfm_ModelFridge fridge = new jfm_ModelFridge();
	private jfm_ModelCooker cooker = new jfm_ModelCooker();
	private jfm_ModelRubbishBin bin = new jfm_ModelRubbishBin();
	private jfm_ModelCoffeeTable ctable = new jfm_ModelCoffeeTable();
	
	protected static final ResourceLocation textureFridge = new ResourceLocation("jammyfurniture:textures/models/jammy_fridge.png");
	protected static final ResourceLocation textureFreezer = new ResourceLocation("jammyfurniture:textures/models/jammy_freezer.png");
	protected static final ResourceLocation textureCooker = new ResourceLocation("jammyfurniture:textures/models/jammy_cooker.png");
	protected static final ResourceLocation textureBin = new ResourceLocation("jammyfurniture:textures/models/jammy_rubbishbin.png");
	protected static final ResourceLocation textureTable = new ResourceLocation("jammyfurniture:textures/models/jammy_coffeetable.png");

	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		TileEntityIronBlocksOne tileentityIron = (TileEntityIronBlocksOne)tileEntity;
		
		short fri_rot = 0;
		short fre_rot = 0;
		short c_rot = 0;
		float var12 = 0.0F;

			if (metadata == 0) {
				fri_rot = 180;
			}

			if (metadata == 1) {
				fri_rot = 90;
			}

			if (metadata == 2) {
				fri_rot = 0;
			}

			if (metadata == 3) {
				fri_rot = 270;
			}

			if (metadata == 4) {
				fre_rot = 180;
			}

			if (metadata == 5) {
				fre_rot = 90;
			}

			if (metadata == 6) {
				fre_rot = 0;
			}

			if (metadata == 7) {
				fre_rot = 270;
			}

			if (metadata == 8) {
				c_rot = 0;
			}

			if (metadata == 9) {
				c_rot = 270;
			}

			if (metadata == 10) {
				c_rot = 180;
			}

			if (metadata == 11) {
				c_rot = 90;
			}

			var12 = tileentityIron.prevLidAngle + (tileentityIron.lidAngle - tileentityIron.prevLidAngle) * f;
			var12 = 1.0F - var12;
			var12 = 1.0F - var12 * var12 * var12;
		

		switch (metadata) {
		case 0:
		case 1:
		case 2:
		case 3:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

			if (tileEntity == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileEntity != null) {
				GL11.glRotatef((float) fri_rot, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureFridge);
			GL11.glPushMatrix();
			this.fridge.Door.rotateAngleY = -(var12 * (float) Math.PI / 2.0F);
			this.fridge.renderModelFridge(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 4:
		case 5:
		case 6:
		case 7:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

			if (tileEntity == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileEntity != null) {
				GL11.glRotatef((float) fre_rot, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureFreezer);
			GL11.glPushMatrix();
			this.fridge.Door.rotateAngleY = -(var12 * (float) Math.PI / 2.0F);
			this.fridge.renderModelFreezer(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 8:
		case 9:
		case 10:
		case 11:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

			if (tileEntity == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileEntity != null) {
				GL11.glRotatef((float) c_rot, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureCooker);
			GL11.glPushMatrix();
			this.cooker.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 12:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBin);
			GL11.glPushMatrix();
			this.bin.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 13:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureTable);
			GL11.glPushMatrix();
			this.ctable.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		default:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

			if (tileEntity == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileEntity != null) {
				GL11.glRotatef((float) fri_rot, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureFridge);
			GL11.glPushMatrix();
			this.fridge.renderModelFridge(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}
}
