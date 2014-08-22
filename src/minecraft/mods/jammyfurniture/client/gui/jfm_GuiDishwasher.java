package mods.jammyfurniture.client.gui;

import mods.jammyfurniture.common.containers.jfm_ContainerDishwasher;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class jfm_GuiDishwasher extends GuiContainer
{
    private jfm_TileEntityIronBlocksTwo dwInv;
    protected static final ResourceLocation texture = new ResourceLocation("jammyfurniture:" + jfm_ConfigDefault.GUI_PATH + "jammy_dishwasher.png");

    public jfm_GuiDishwasher(InventoryPlayer inventoryplayer, jfm_TileEntityIronBlocksTwo teDishwasher)
    {
        super(new jfm_ContainerDishwasher(inventoryplayer, teDishwasher));
        this.dwInv = teDishwasher;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Dishwasher", 8, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(texture);
        int j1 = (this.width - this.xSize) / 2;
        int k = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j1, k, 0, 0, this.xSize, this.ySize);
        int m1;

        if (this.dwInv.dwIsBurning())
        {
            m1 = this.dwInv.dwGetBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(j1 + 16, k + 48 - m1, 176, 12 - m1, 14, m1 + 2);
        }

        m1 = this.dwInv.dwGetProgressSlot1(24);
        int m2 = this.dwInv.dwGetProgressSlot2(24);
        int m3 = this.dwInv.dwGetProgressSlot3(24);
        int m4 = this.dwInv.dwGetProgressSlot4(24);
        this.drawTexturedModalRect(j1 + 65 - m1, k + 27, 201 - m1, 31, 25, 16);
        this.drawTexturedModalRect(j1 + 145, k + 27, 176, 14, 1 + m2, 16);
        this.drawTexturedModalRect(j1 + 65 - m3, k + 58, 201 - m3, 31, 25, 16);
        this.drawTexturedModalRect(j1 + 145, k + 58, 176, 14, m4 + 1, 16);
    }
}
