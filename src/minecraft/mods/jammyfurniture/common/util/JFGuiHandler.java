package mods.jammyfurniture.common.util;

import mods.jammyfurniture.client.gui.GuiDishwasher;
import mods.jammyfurniture.client.gui.GuiFriFre;
import mods.jammyfurniture.client.gui.GuiRubbishBin;
import mods.jammyfurniture.client.gui.GuiWashingMachine;
import mods.jammyfurniture.client.gui.jfm_GuiBathroomCupboard;
import mods.jammyfurniture.client.gui.jfm_GuiCooker;
import mods.jammyfurniture.common.containers.ContainerDishwasher;
import mods.jammyfurniture.common.containers.ContainerFriFre;
import mods.jammyfurniture.common.containers.ContainerRubbishBin;
import mods.jammyfurniture.common.containers.jfm_ContainerBathroomCupboard;
import mods.jammyfurniture.common.containers.jfm_ContainerCooker;
import mods.jammyfurniture.common.containers.jfm_ContainerWashingMachine;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class JFGuiHandler implements IGuiHandler {

	public static final int GUI_COOKER = 152;
	public static final int GUI_FRIDGE = 156;
	public static final int GUI_RUBBISHBIN = 158;
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		Container container = null;
		
		if (world.blockExists(x, y, z) && te != null) {
			
			switch (ID) {
				case 150:
					container = new jfm_ContainerBathroomCupboard(player.inventory, (IInventory)te);
					break;
					
	
				case GUI_COOKER:
					container = new jfm_ContainerCooker(player.inventory, (TileEntityIronBlocksOne)te);
					break;
	
				case 155:
					container = new jfm_ContainerWashingMachine(player.inventory, (TileEntityIronBlocksTwo)te);
					break;
					
				case GUI_FRIDGE:
					container = new ContainerFriFre(player.inventory, (IInventory)te);
					break;

				case GUI_RUBBISHBIN:
					container = new ContainerRubbishBin(player.inventory, (IInventory)te);
					break;
	
				case 159:
					container =  new ContainerDishwasher(player.inventory, (TileEntityIronBlocksTwo)te);
					break;
					
				default:
					break;
			}
		}
		
		return container;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity te = world.getBlockTileEntity(x, y, z);
		GuiContainer gui = null;

		try {
			if (world.blockExists(x, y, z) && te != null) {
				
				switch (ID) {
					case 150:
						gui = new jfm_GuiBathroomCupboard(player.inventory, (IInventory)te);
						break;
						
		
					case GUI_COOKER:
						gui = new jfm_GuiCooker(player.inventory, (TileEntityIronBlocksOne)te);
						break;
		
					case 155:
						gui = new GuiWashingMachine(player.inventory, (TileEntityIronBlocksTwo)te);
						break;
						
					case GUI_FRIDGE:
						gui = new GuiFriFre(player.inventory, (IInventory)te);
						break;
						
					case GUI_RUBBISHBIN:
						gui = new GuiRubbishBin(player.inventory, (IInventory)te);
						break;
		
					case 159:
						gui =  new GuiDishwasher(player.inventory, (TileEntityIronBlocksTwo)te);
						break;
						
					default:
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gui;
	}
	
}
