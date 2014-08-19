package net.minecraft.jammy780.furniture.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.jammy780.furniture.model.lights.jfm_ModelLight;
import net.minecraft.jammy780.furniture.model.lights.jfm_ModelOutsideLamp;
import net.minecraft.jammy780.furniture.model.lights.jfm_ModelTableLamp;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityLightsOn;
import net.minecraft.jammy780.furniture.util.jfm_ConfigDefault;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class jfm_LightsRenderer extends TileEntitySpecialRenderer
{
    private jfm_ModelLight light = new jfm_ModelLight();
    private jfm_ModelOutsideLamp outside_lamp = new jfm_ModelOutsideLamp();
    private jfm_ModelTableLamp table_lamp = new jfm_ModelTableLamp();
    protected static final ResourceLocation textureLight = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_lightbulb.png");
    protected static final ResourceLocation textureLamp = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_lamp.png");
    protected static final ResourceLocation textureTable = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_tablelamp.png");

    public void renderAModel(jfm_TileEntityLightsOn tileentity1, double d, double d1, double d2, float f)
    {
        short ol_rot = 0;
        int i;

        if (tileentity1 == null)
        {
            i = jfm_TileEntityLightsOn.md;
        }
        else
        {
            Block block = tileentity1.getBlockType();
            i = tileentity1.getBlockMetadata();

            if (i == 0)
            {
                i = tileentity1.getBlockMetadata();
            }

            if (i == 4)
            {
                ol_rot = 0;
            }

            if (i == 5)
            {
                ol_rot = 270;
            }

            if (i == 6)
            {
                ol_rot = 180;
            }

            if (i == 7)
            {
                ol_rot = 90;
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

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureLight);
                GL11.glPushMatrix();
                this.light.renderModel(0.0625F);
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

                GL11.glRotatef((float)ol_rot, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureLamp);
                GL11.glPushMatrix();
                this.outside_lamp.renderModel(0.0625F);
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

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureTable);
                GL11.glPushMatrix();
                this.table_lamp.renderModel(0.0625F);
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

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureLight);
                GL11.glPushMatrix();
                this.light.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
        }
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
    {
        if (tileentity.worldObj == null)
        {
            this.renderAModel((jfm_TileEntityLightsOn)null, d, d1, d2, f);
        }
        else
        {
            this.renderAModel((jfm_TileEntityLightsOn)tileentity, d, d1, d2, f);
        }
    }
}
