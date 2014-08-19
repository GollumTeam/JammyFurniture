package net.minecraft.jammy780.furniture.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.jammy780.furniture.model.roofing.jfm_ModelRoofing;
import net.minecraft.jammy780.furniture.model.roofing.jfm_ModelRoofingBlock;
import net.minecraft.jammy780.furniture.model.roofing.jfm_ModelRoofingCorner;
import net.minecraft.jammy780.furniture.model.roofing.jfm_ModelRoofingInverted;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityRoofingBlocksOne;
import net.minecraft.jammy780.furniture.util.jfm_ConfigDefault;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class jfm_RoofingBlocksRendererOne extends TileEntitySpecialRenderer
{
    private jfm_ModelRoofing roofing = new jfm_ModelRoofing();
    private jfm_ModelRoofingCorner roofing_corner = new jfm_ModelRoofingCorner();
    private jfm_ModelRoofingInverted roofing_inverted = new jfm_ModelRoofingInverted();
    private jfm_ModelRoofingBlock roofing_block = new jfm_ModelRoofingBlock();
    protected static final ResourceLocation textureRoofing = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_roofing.png");

    public void renderAModel(jfm_TileEntityRoofingBlocksOne tileentity1, double d, double d1, double d2, float f)
    {
        short rof_rot = 0;
        short rofc_rot = 0;
        short roin_rot = 0;
        int i;

        if (tileentity1 == null)
        {
            i = jfm_TileEntityRoofingBlocksOne.md;
        }
        else
        {
            Block block = tileentity1.getBlockType();
            i = tileentity1.getBlockMetadata();

            if (i == 0)
            {
                i = tileentity1.getBlockMetadata();
            }

            if (i == 0)
            {
                rof_rot = 0;
            }

            if (i == 1)
            {
                rof_rot = 270;
            }

            if (i == 2)
            {
                rof_rot = 180;
            }

            if (i == 3)
            {
                rof_rot = 90;
            }

            if (i == 4)
            {
                rofc_rot = 0;
            }

            if (i == 5)
            {
                rofc_rot = 270;
            }

            if (i == 6)
            {
                rofc_rot = 180;
            }

            if (i == 7)
            {
                rofc_rot = 90;
            }

            if (i == 8)
            {
                roin_rot = 0;
            }

            if (i == 9)
            {
                roin_rot = 270;
            }

            if (i == 10)
            {
                roin_rot = 180;
            }

            if (i == 11)
            {
                roin_rot = 90;
            }
        }

        switch (i)
        {
            case 0:
            case 1:
            case 2:
            case 3:
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);

                if (tileentity1 == null)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (tileentity1 != null)
                {
                    GL11.glRotatef((float)rof_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureRoofing);
                GL11.glPushMatrix();
                this.roofing.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            case 4:
            case 5:
            case 6:
            case 7:
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);

                if (tileentity1 == null)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (tileentity1 != null)
                {
                    GL11.glRotatef((float)rofc_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureRoofing);
                GL11.glPushMatrix();
                this.roofing_corner.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            case 8:
            case 9:
            case 10:
            case 11:
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);

                if (tileentity1 == null)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (tileentity1 != null)
                {
                    GL11.glRotatef((float)roin_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureRoofing);
                GL11.glPushMatrix();
                this.roofing_inverted.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            case 12:
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureRoofing);
                GL11.glPushMatrix();
                this.roofing_block.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                break;

            default:
                GL11.glPushMatrix();
                GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);

                if (tileentity1 == null)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (tileentity1 != null)
                {
                    GL11.glRotatef((float)rof_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureRoofing);
                GL11.glPushMatrix();
                this.roofing.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
        }
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
    {
        if (tileentity.worldObj == null)
        {
            this.renderAModel((jfm_TileEntityRoofingBlocksOne)null, d, d1, d2, f);
        }
        else
        {
            this.renderAModel((jfm_TileEntityRoofingBlocksOne)tileentity, d, d1, d2, f);
        }
    }
}
