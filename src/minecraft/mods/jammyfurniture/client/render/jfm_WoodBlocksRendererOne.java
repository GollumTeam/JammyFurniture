package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.wood.jfm_ModelBlinds;
import mods.jammyfurniture.client.model.wood.jfm_ModelClockBase;
import mods.jammyfurniture.client.model.wood.jfm_ModelClockMiddle;
import mods.jammyfurniture.client.model.wood.jfm_ModelClockTop;
import mods.jammyfurniture.client.model.wood.jfm_ModelKitchenSide;
import mods.jammyfurniture.client.model.wood.jfm_ModelTable;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_WoodBlocksRendererOne extends TileEntitySpecialRenderer {
	private jfm_ModelClockBase clock_base = new jfm_ModelClockBase();
	private jfm_ModelClockMiddle clock_mid = new jfm_ModelClockMiddle();
	private jfm_ModelClockTop clock_top = new jfm_ModelClockTop();
	private jfm_ModelBlinds blinds = new jfm_ModelBlinds();
	private jfm_ModelKitchenSide kitchen_side = new jfm_ModelKitchenSide();
	private jfm_ModelTable table = new jfm_ModelTable();
	protected static final ResourceLocation textureBase = new ResourceLocation("jammyfurniture:textures/models/jammy_clockbase.png");
	protected static final ResourceLocation textureMid = new ResourceLocation("jammyfurniture:textures/models/jammy_clockmiddle.png");
	protected static final ResourceLocation textureTop = new ResourceLocation("jammyfurniture:textures/models/jammy_clocktop.png");
	protected static final ResourceLocation textureBlinds = new ResourceLocation("jammyfurniture:textures/models/jammy_blinds.png");
	protected static final ResourceLocation textureCSide = new ResourceLocation("jammyfurniture:textures/models/jammy_craftside.png");
	protected static final ResourceLocation textureKSide = new ResourceLocation("jammyfurniture:textures/models/jammy_kitchenside.png");
	protected static final ResourceLocation textureTable = new ResourceLocation("jammyfurniture:textures/models/jammy_table.png");

	public void renderAModel(TileEntityWoodBlocksOne tileentity1, double d, double d1, double d2, float f) {
		short cm_rot = 0;
		short ct_rot = 0;
		short bl_rot = 0;
		int i = 0;
		
		if (tileentity1 == null) {
			i = jfm_InvRenderer.getCurrentMetadata();
		} else {
			Block block = tileentity1.getBlockType();
			i = tileentity1.getBlockMetadata();

			if (i == 0) {
				i = tileentity1.getBlockMetadata();
			}

			if (i == 1) {
				cm_rot = 0;
			}

			if (i == 4) {
				cm_rot = 90;
			}

			if (i == 3) {
				cm_rot = 180;
			}

			if (i == 2) {
				cm_rot = 270;
			}

			if (i == 5) {
				ct_rot = 0;
			}

			if (i == 8) {
				ct_rot = 90;
			}

			if (i == 7) {
				ct_rot = 180;
			}

			if (i == 6) {
				ct_rot = 270;
			}

			if (i == 9) {
				bl_rot = 0;
			}

			if (i == 12) {
				bl_rot = 90;
			}

			if (i == 11) {
				bl_rot = 180;
			}

			if (i == 10) {
				bl_rot = 270;
			}
		}

		switch (i) {
		case 0:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBase);
			GL11.glPushMatrix();
			this.clock_base.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 1:
		case 2:
		case 3:
		case 4:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 != null) {
				GL11.glRotatef((float) cm_rot, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureMid);
			GL11.glPushMatrix();
			this.clock_mid.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 5:
		case 6:
		case 7:
		case 8:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 != null) {
				GL11.glRotatef((float) ct_rot, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureTop);
			GL11.glPushMatrix();
			this.clock_top.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 9:
		case 10:
		case 11:
		case 12:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			if (tileentity1 != null) {
				GL11.glRotatef((float) bl_rot, 0.0F, 1.0F, 0.0F);
			}

			if (tileentity1 == null) {
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			}

			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBlinds);
			GL11.glPushMatrix();
			this.blinds.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 13:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureCSide);
			GL11.glPushMatrix();
			this.kitchen_side.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 14:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureKSide);
			GL11.glPushMatrix();
			this.kitchen_side.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		case 15:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureTable);
			GL11.glPushMatrix();
			this.table.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			break;

		default:
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(textureBase);
			GL11.glPushMatrix();
			this.clock_base.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}
	}

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		if (tileentity.worldObj == null) {
			this.renderAModel((TileEntityWoodBlocksOne) null, d, d1, d2, f);
		} else {
			this.renderAModel((TileEntityWoodBlocksOne) tileentity, d, d1, d2, f);
		}
	}
}
