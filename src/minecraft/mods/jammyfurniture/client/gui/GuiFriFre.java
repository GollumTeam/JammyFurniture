package mods.jammyfurniture.client.gui;

import mods.gollum.core.client.gui.GCLGuiContainer;
import mods.jammyfurniture.common.containers.ContainerFriFre;
import mods.jammyfurniture.common.containers.ContainerRubbishBin;
import net.minecraft.inventory.IInventory;

public class GuiFriFre extends GCLGuiContainer {
	
	public GuiFriFre(IInventory inventoryPlayer, IInventory inventoryBlock) throws Exception {
		super(inventoryPlayer, inventoryBlock, ContainerFriFre.class);
	}
	
}
