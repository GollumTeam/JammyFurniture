package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.jfm_ModelChimney;
import mods.jammyfurniture.client.model.jfm_ModelChristmasTree;
import mods.jammyfurniture.client.model.jfm_ModelMantlePiece;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityMiscOne;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_MiscOneRenderer extends TileEntitySpecialRenderer {
	private jfm_ModelChimney chimney = new jfm_ModelChimney();
	private jfm_ModelMantlePiece mantle_piece = new jfm_ModelMantlePiece();
	private jfm_ModelChristmasTree christmas_tree = new jfm_ModelChristmasTree();
	protected static final ResourceLocation textureChim = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_chimney.png");
	protected static final ResourceLocation textureMantle = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_mantlepiece.png");
	protected static final ResourceLocation textureTree = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_tree.png");

	public void renderAModel(jfm_TileEntityMiscOne tileentity1, double d, double d1, double d2, float f) {
		short h1_rot = 0;
		short h2_rot = 0;
		int i;

		if (tileentity1 == null) {
			i = jfm_TileEntityMiscOne.md;
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

			GL11.glRotatef((float) h1_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureChim);
			GL11.glPushMatrix();
			this.chimney.renderModel(0.0625F);
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

			GL11.glRotatef((float) h2_rot, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureMantle);
			GL11.glPushMatrix();
			this.mantle_piece.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 8:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureTree);
			GL11.glPushMatrix();
			this.christmas_tree.renderModel(0.0625F);
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
			this.bindTexture(textureChim);
			GL11.glPushMatrix();
			this.chimney.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((jfm_TileEntityMiscOne) null, d, d1, d2, f);
		} else {
			this.renderAModel((jfm_TileEntityMiscOne) tileentity, d, d1, d2, f);
		}
	}
}
