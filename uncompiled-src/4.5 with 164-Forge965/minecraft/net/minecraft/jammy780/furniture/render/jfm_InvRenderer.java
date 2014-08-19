package net.minecraft.jammy780.furniture.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.jammy780.furniture.JammyFurnitureModCore;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityArmChair;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityBath;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityCeramicBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityLightsOn;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMiscOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsFour;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsThree;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityMobHeadsTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityRoofingBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaCenter;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaCorner;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaLeft;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntitySofaRight;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocks;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocksThree;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocksTwo;
import net.minecraft.world.IBlockAccess;

public class jfm_InvRenderer implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        if (block == JammyFurnitureModCore.woodBlocksOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocks(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.woodBlocksTwo)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.woodBlocksThree)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityWoodBlocksThree(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.bathTub)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityBath(), 0.0D, 0.0D, -0.5D, 0.0F);
        }

        if (block == JammyFurnitureModCore.ironBlocksOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityIronBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.ironBlocksTwo)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityIronBlocksTwo(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.ceramicBlocksOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityCeramicBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.roofingBlocksOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityRoofingBlocksOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.mobHeadsOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsOne(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
        }

        if (block == JammyFurnitureModCore.mobHeadsTwo)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsTwo(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
        }

        if (block == JammyFurnitureModCore.mobHeadsThree)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsThree(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
        }

        if (block == JammyFurnitureModCore.mobHeadsFour)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMobHeadsFour(metadata), 0.0D, 0.4D, 0.2D, 0.0F);
        }

        if (block == JammyFurnitureModCore.armChair)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityArmChair(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.sofaPartLeft)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaLeft(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.sofaPartRight)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaRight(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.sofaPartCenter)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaCenter(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.sofaPartCorner)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntitySofaCorner(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.miscBlocksOne)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityMiscOne(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }

        if (block == JammyFurnitureModCore.lightsOn)
        {
            TileEntityRenderer.instance.renderTileEntityAt(new jfm_TileEntityLightsOn(metadata), 0.0D, -0.1D, 0.0D, 0.0F);
        }
    }

    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return false;
    }

    public boolean shouldRender3DInInventory()
    {
        return true;
    }

    public int getRenderId()
    {
        return 0;
    }
}
