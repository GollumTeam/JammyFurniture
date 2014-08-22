package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.sofa.jfm_ModelSofaLeft;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaLeft;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_SofaLeftRenderer extends TileEntitySpecialRenderer {
	private jfm_ModelSofaLeft sofa_left = new jfm_ModelSofaLeft();
	protected static final ResourceLocation textureRed = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_sofaleft_red.png");
	protected static final ResourceLocation textureBlue = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_sofaleft_blue.png");
	protected static final ResourceLocation textureGreen = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_sofaleft_green.png");
	protected static final ResourceLocation textureGrey = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_sofaleft_grey.png");

	public void renderAModel(TileEntitySofaLeft tileentity1, double d, double d1, double d2, float f) {
		short ac1_rot = 0;
		short ac2_rot = 0;
		short ac3_rot = 0;
		short ac4_rot = 0;
		int i;

		if (tileentity1 == null) {
			i = TileEntitySofaLeft.md;
		} else {
			Block block = tileentity1.getBlockType();
			i = tileentity1.getBlockMetadata();

			if (i == 0) {
				i = tileentity1.getBlockMetadata();
			}

			if (i == 0) {
				ac1_rot = 0;
			}

			if (i == 1) {
				ac1_rot = 270;
			}

			if (i == 2) {
				ac1_rot = 180;
			}

			if (i == 3) {
				ac1_rot = 90;
			}

			if (i == 4) {
				ac2_rot = 0;
			}

			if (i == 5) {
				ac2_rot = 270;
			}

			if (i == 6) {
				ac2_rot = 180;
			}

			if (i == 7) {
				ac2_rot = 90;
			}

			if (i == 8) {
				ac3_rot = 0;
			}

			if (i == 9) {
				ac3_rot = 270;
			}

			if (i == 10) {
				ac3_rot = 180;
			}

			if (i == 11) {
				ac3_rot = 90;
			}

			if (i == 12) {
				ac4_rot = 0;
			}

			if (i == 13) {
				ac4_rot = 270;
			}

			if (i == 14) {
				ac4_rot = 180;
			}

			if (i == 15) {
				ac4_rot = 90;
			}
		}

		switch (i) {
		case 0:
		case 1:
		case 2:
		case 3:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef((float) ac1_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureRed);
			GL11.glPushMatrix();
			this.sofa_left.renderModel(0.0625F);
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
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef((float) ac2_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBlue);
			GL11.glPushMatrix();
			this.sofa_left.renderModel(0.0625F);
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

			GL11.glRotatef((float) ac3_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureGreen);
			GL11.glPushMatrix();
			this.sofa_left.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 12:
		case 13:
		case 14:
		case 15:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef((float) ac4_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureGrey);
			GL11.glPushMatrix();
			this.sofa_left.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		default:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef((float) ac1_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureRed);
			GL11.glPushMatrix();
			this.sofa_left.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((TileEntitySofaLeft) null, d, d1, d2, f);
		} else {
			this.renderAModel((TileEntitySofaLeft) tileentity, d, d1, d2, f);
		}
	}
}
