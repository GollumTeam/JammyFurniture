package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.jfm_ModelBath;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityBath;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_BathRenderer extends TileEntitySpecialRenderer {
	private jfm_ModelBath bath = new jfm_ModelBath();
	protected static final ResourceLocation texture = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_bath.png");

	public void renderAModel(jfm_TileEntityBath tileentity1, double d, double d1, double d2, float f) {
		short rot_1 = 0;
		short rot_2 = 0;
		int i;

		if (tileentity1 == null) {
			i = 0;
		} else {
			Block block = tileentity1.getBlockType();
			i = tileentity1.getBlockMetadata();

			if (i == 0) {
				i = tileentity1.getBlockMetadata();
			}

			if (i == 0) {
				rot_1 = 90;
			}

			if (i == 1) {
				rot_1 = 0;
			}

			if (i == 2) {
				rot_1 = 270;
			}

			if (i == 3) {
				rot_1 = 180;
			}

			if (i == 8) {
				rot_2 = 270;
			}

			if (i == 9) {
				rot_2 = 180;
			}

			if (i == 10) {
				rot_2 = 90;
			}

			if (i == 11) {
				rot_2 = 0;
			}
		}

		if (tileentity1 == null) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			this.bath.renderModelLeft(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 1.5F);
			GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			this.bath.renderModelRight(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		} else {
			switch (i) {
			case 0:
			case 1:
			case 2:
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
				GL11.glRotatef((float) rot_1, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
				this.bindTexture(texture);
				GL11.glPushMatrix();
				this.bath.renderModelLeft(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				break;

			case 4:
			case 5:
			case 6:
			case 7:
			default:
				GL11.glPushMatrix();
				GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
				GL11.glRotatef((float) rot_1, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
				this.bindTexture(texture);
				GL11.glPushMatrix();
				this.bath.renderModelLeft(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				break;

			case 8:
			case 9:
			case 10:
			case 11:
				GL11.glPushMatrix();
				GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
				GL11.glRotatef((float) rot_2, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
				this.bindTexture(texture);
				GL11.glPushMatrix();
				this.bath.renderModelRight(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((jfm_TileEntityBath) null, d, d1, d2, f);
		} else {
			this.renderAModel((jfm_TileEntityBath) tileentity, d, d1, d2, f);
		}
	}
}
