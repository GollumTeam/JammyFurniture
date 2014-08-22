package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.heads.jfm_ModelHead;
import mods.jammyfurniture.client.model.heads.jfm_ModelSquidHead;
import mods.jammyfurniture.client.model.heads.jfm_ModelWolfHead;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMobHeadsThree;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_MobHeadsThreeRenderer extends TileEntitySpecialRenderer {
	private jfm_ModelWolfHead wolf_head = new jfm_ModelWolfHead();
	private jfm_ModelHead model_head = new jfm_ModelHead();
	private jfm_ModelSquidHead squid_head = new jfm_ModelSquidHead();
	protected static final ResourceLocation textureSte = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_stevehead.png");
	protected static final ResourceLocation textureWol = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_wolfhead.png");
	protected static final ResourceLocation textureZom = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_zombiehead.png");
	protected static final ResourceLocation textureSqu = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_squidhead.png");

	public void renderAModel(jfm_TileEntityMobHeadsThree tileentity1, double d, double d1, double d2, float f) {
		short h1_rot = 0;
		short h2_rot = 0;
		short h3_rot = 0;
		short h4_rot = 0;
		int i;

		if (tileentity1 == null) {
			i = jfm_TileEntityMobHeadsThree.md;
		} else {
			Block block = tileentity1.getBlockType();
			i = tileentity1.getBlockMetadata();

			if (i == 0) {
				i = tileentity1.getBlockMetadata();
			}

			if (i == 0) {
				h1_rot = 0;
			}

			if (i == 1) {
				h1_rot = 270;
			}

			if (i == 2) {
				h1_rot = 180;
			}

			if (i == 3) {
				h1_rot = 90;
			}

			if (i == 4) {
				h2_rot = 0;
			}

			if (i == 5) {
				h2_rot = 270;
			}

			if (i == 6) {
				h2_rot = 180;
			}

			if (i == 7) {
				h2_rot = 90;
			}

			if (i == 8) {
				h3_rot = 0;
			}

			if (i == 9) {
				h3_rot = 270;
			}

			if (i == 10) {
				h3_rot = 180;
			}

			if (i == 11) {
				h3_rot = 90;
			}

			if (i == 12) {
				h4_rot = 0;
			}

			if (i == 13) {
				h4_rot = 270;
			}

			if (i == 14) {
				h4_rot = 180;
			}

			if (i == 15) {
				h4_rot = 90;
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
				GL11.glScalef(1.5F, 1.5F, 1.5F);
			}

			GL11.glRotatef((float) h1_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureSte);
			GL11.glPushMatrix();
			this.model_head.renderModel(0.0625F);
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
				GL11.glScalef(1.5F, 1.5F, 1.5F);
			}

			GL11.glRotatef((float) h2_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureWol);
			GL11.glPushMatrix();
			this.wolf_head.renderModel(0.0625F);
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
				GL11.glScalef(1.5F, 1.5F, 1.5F);
			}

			GL11.glRotatef((float) h3_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureZom);
			GL11.glPushMatrix();
			this.model_head.renderModel(0.0625F);
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

			GL11.glRotatef((float) h4_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureSqu);
			GL11.glPushMatrix();
			this.squid_head.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		default:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(1.5F, 1.5F, 1.5F);
			}

			GL11.glRotatef((float) h1_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureSte);
			GL11.glPushMatrix();
			this.model_head.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((jfm_TileEntityMobHeadsThree) null, d, d1, d2, f);
		} else {
			this.renderAModel((jfm_TileEntityMobHeadsThree) tileentity, d, d1, d2, f);
		}
	}
}
