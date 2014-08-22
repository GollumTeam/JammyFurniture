package mods.jammyfurniture.client.render;

import mods.jammyfurniture.client.model.iron.jfm_ModelDishwasher;
import mods.jammyfurniture.client.model.iron.jfm_ModelWashingMachine;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_IronBlocksRendererTwo extends TileEntitySpecialRenderer
{
    private jfm_ModelDishwasher dishwasher = new jfm_ModelDishwasher();
    private jfm_ModelWashingMachine washing_machine = new jfm_ModelWashingMachine();
    protected static final ResourceLocation textureDish = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_dishwasher.png");
    protected static final ResourceLocation textureWasher = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.TEXTURE_PATH + "jammy_washingmachine.png");

    public void renderAModel(jfm_TileEntityIronBlocksTwo tileentity1, double d, double d1, double d2, float f)
    {
        short dis_rot = 0;
        short wm_rot = 0;
        float var12 = 0.0F;
        int i;

        if (tileentity1 == null)
        {
            i = jfm_TileEntityIronBlocksTwo.md;
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
                dis_rot = 0;
            }

            if (i == 1)
            {
                dis_rot = 270;
            }

            if (i == 2)
            {
                dis_rot = 180;
            }

            if (i == 3)
            {
                dis_rot = 90;
            }

            if (i == 4)
            {
                wm_rot = 0;
            }

            if (i == 5)
            {
                wm_rot = 270;
            }

            if (i == 6)
            {
                wm_rot = 180;
            }

            if (i == 7)
            {
                wm_rot = 90;
            }

            var12 = tileentity1.prevLidAngle + (tileentity1.lidAngle - tileentity1.prevLidAngle) * f;
            var12 = 1.0F - var12;
            var12 = 1.0F - var12 * var12 * var12;
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
                    GL11.glRotatef((float)dis_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureDish);
                GL11.glPushMatrix();
                this.dishwasher.DishwasherDoor.rotateAngleX = var12 * (float)Math.PI / 3.0F;
                this.dishwasher.renderModel(0.0625F);
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
                    GL11.glRotatef((float)wm_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureWasher);
                GL11.glPushMatrix();
                this.washing_machine.renderModel(0.0625F);
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
                    GL11.glRotatef((float)dis_rot, 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                this.bindTexture(textureDish);
                GL11.glPushMatrix();
                this.dishwasher.DishwasherDoor.rotateAngleX = var12 * (float)Math.PI / 3.0F;
                this.dishwasher.renderModel(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
        }
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
    {
        if (tileentity.worldObj == null)
        {
            this.renderAModel((jfm_TileEntityIronBlocksTwo)null, d, d1, d2, f);
        }
        else
        {
            this.renderAModel((jfm_TileEntityIronBlocksTwo)tileentity, d, d1, d2, f);
        }
    }
}
