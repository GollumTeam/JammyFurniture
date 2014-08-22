package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.iron.jfm_ModelCoffeeTable;
import mods.jammyfurniture.client.model.iron.jfm_ModelCooker;
import mods.jammyfurniture.client.model.iron.jfm_ModelFridge;
import mods.jammyfurniture.client.model.iron.jfm_ModelRubbishBin;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksOne;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_IronBlocksRendererOne extends TileEntitySpecialRenderer {
	private jfm_ModelFridge fridge = new jfm_ModelFridge();
	private jfm_ModelCooker cooker = new jfm_ModelCooker();
	private jfm_ModelRubbishBin bin = new jfm_ModelRubbishBin();
	private jfm_ModelCoffeeTable ctable = new jfm_ModelCoffeeTable();
	protected static final ResourceLocation textureFridge = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_fridge.png");
	protected static final ResourceLocation textureFreezer = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_freezer.png");
	protected static final ResourceLocation textureCooker = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_cooker.png");
	protected static final ResourceLocation textureBin = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_rubbishbin.png");
	protected static final ResourceLocation textureTable = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_coffeetable.png");

	public void renderAModel(jfm_TileEntityIronBlocksOne tileentity1, double d, double d1, double d2, float f) {
		short fri_rot = 0;
		short fre_rot = 0;
		short c_rot = 0;
		float var12 = 0.0F;
		int i;

		if (tileentity1 == null) {
			i = jfm_TileEntityIronBlocksOne.md;
		} else {
			Block block = tileentity1.getBlockType();
			i = tileentity1.getBlockMetadata();

			if (i == 0) {
				i = tileentity1.getBlockMetadata();
			}

			if (i == 0) {
				fri_rot = 180;
			}

			if (i == 1) {
				fri_rot = 90;
			}

			if (i == 2) {
				fri_rot = 0;
			}

			if (i == 3) {
				fri_rot = 270;
			}

			if (i == 4) {
				fre_rot = 180;
			}

			if (i == 5) {
				fre_rot = 90;
			}

			if (i == 6) {
				fre_rot = 0;
			}

			if (i == 7) {
				fre_rot = 270;
			}

			if (i == 8) {
				c_rot = 0;
			}

			if (i == 9) {
				c_rot = 270;
			}

			if (i == 10) {
				c_rot = 180;
			}

			if (i == 11) {
				c_rot = 90;
			}

			var12 = tileentity1.prevLidAngle + (tileentity1.lidAngle - tileentity1.prevLidAngle) * f;
			var12 = 1.0F - var12;
			var12 = 1.0F - var12 * var12 * var12;
		}

		switch (i) {
		case 0:
		case 1:
		case 2:
		case 3:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 != null) {
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
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 != null) {
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
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 != null) {
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
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBin);
			GL11.glPushMatrix();
			this.bin.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 13:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureTable);
			GL11.glPushMatrix();
			this.ctable.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		default:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 != null) {
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

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((jfm_TileEntityIronBlocksOne) null, d, d1, d2, f);
		} else {
			this.renderAModel((jfm_TileEntityIronBlocksOne) tileentity, d, d1, d2, f);
		}
	}
}
