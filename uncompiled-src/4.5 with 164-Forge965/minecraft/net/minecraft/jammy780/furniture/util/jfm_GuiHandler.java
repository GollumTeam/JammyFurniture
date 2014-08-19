package net.minecraft.jammy780.furniture.util;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiBathroomCupboard;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiClockMiddle;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiCooker;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiCrafingSide;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiDishwasher;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiFriFre;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiKitchenCupboard;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiRubbishBin;
import net.minecraft.client.jammy780.furniture.gui.jfm_GuiWashingMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerBathroomCupboard;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerClockMiddle;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerCooker;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerDishwasher;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerFriFre;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerKitchenCupboard;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerRubbishBin;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerWashingMachine;
import net.minecraft.jammy780.furniture.gui.containers.jfm_ContainerWorkbench;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityCeramicBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksOne;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksTwo;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocks;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityWoodBlocksTwo;
import net.minecraft.world.World;

public class jfm_GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }
        else
        {
            switch (ID)
            {
                case 150:
                    jfm_TileEntityCeramicBlocksOne bc = (jfm_TileEntityCeramicBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerBathroomCupboard(player.inventory, bc);

                case 151:
                    jfm_TileEntityWoodBlocks wbone = (jfm_TileEntityWoodBlocks)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerClockMiddle(player.inventory, wbone);

                case 152:
                    jfm_TileEntityIronBlocksOne cooker = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerCooker(player.inventory, cooker);

                case 153:
                    jfm_TileEntityWoodBlocksTwo kc = (jfm_TileEntityWoodBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerKitchenCupboard(player.inventory, kc);

                case 154:
                    jfm_TileEntityWoodBlocksTwo kcnt = (jfm_TileEntityWoodBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerKitchenCupboard(player.inventory, kcnt);

                case 155:
                    jfm_TileEntityIronBlocksTwo wm = (jfm_TileEntityIronBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerWashingMachine(player.inventory, wm);

                case 156:
                    jfm_TileEntityIronBlocksOne fri = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerFriFre(player.inventory, fri);

                case 157:
                    jfm_TileEntityIronBlocksOne fre = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerFriFre(player.inventory, fre);

                case 158:
                    jfm_TileEntityIronBlocksOne bin = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerRubbishBin(player.inventory, bin);

                case 159:
                    jfm_TileEntityIronBlocksTwo dw = (jfm_TileEntityIronBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_ContainerDishwasher(player.inventory, dw);

                case 160:
                    return new jfm_ContainerWorkbench(player.inventory, world, x, y, z);

                default:
                    return null;
            }
        }
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }
        else
        {
            switch (ID)
            {
                case 150:
                    jfm_TileEntityCeramicBlocksOne bc = (jfm_TileEntityCeramicBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiBathroomCupboard(player.inventory, bc);

                case 151:
                    jfm_TileEntityWoodBlocks wbone = (jfm_TileEntityWoodBlocks)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiClockMiddle(player.inventory, wbone);

                case 152:
                    jfm_TileEntityIronBlocksOne cooker = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiCooker(player.inventory, cooker);

                case 153:
                    jfm_TileEntityWoodBlocksTwo kc = (jfm_TileEntityWoodBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiKitchenCupboard(player.inventory, kc);

                case 154:
                    jfm_TileEntityWoodBlocksTwo kcnt = (jfm_TileEntityWoodBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiKitchenCupboard(player.inventory, kcnt);

                case 155:
                    jfm_TileEntityIronBlocksTwo wm = (jfm_TileEntityIronBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiWashingMachine(player.inventory, wm);

                case 156:
                    jfm_TileEntityIronBlocksOne fri = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiFriFre(player.inventory, fri);

                case 157:
                    jfm_TileEntityIronBlocksOne fre = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiFriFre(player.inventory, fre);

                case 158:
                    jfm_TileEntityIronBlocksOne bin = (jfm_TileEntityIronBlocksOne)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiRubbishBin(player.inventory, bin, x, y, z);

                case 159:
                    jfm_TileEntityIronBlocksTwo dw = (jfm_TileEntityIronBlocksTwo)world.getBlockTileEntity(x, y, z);
                    return new jfm_GuiDishwasher(player.inventory, dw);

                case 160:
                    return new jfm_GuiCrafingSide(player.inventory, world, x, y, z);

                default:
                    return null;
            }
        }
    }
}
