package com.gollum.jammyfurniture.inits;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import net.minecraft.item.Item;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.items.ItemBuilding;
import com.gollum.core.common.items.ItemInfos;
import com.gollum.core.common.items.ItemWrench;
import com.gollum.core.tools.helper.items.HItem;

public class ModItems {

	/////////////////////
	// Liste des items //
	/////////////////////
	public static Item itemLightBulb;
	public static Item itemMantlePieceUnf;
	public static Item itemCeramicPanelUnf;
	public static Item itemCeramicPanel;
	public static Item itemWMDrum;
	public static Item itemBlindPart;
	
	public static void init() {
		ModItems.itemLightBulb       = new HItem("LightBulb"      ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		ModItems.itemMantlePieceUnf  = new HItem("MantlePieceUnf" ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		ModItems.itemCeramicPanelUnf = new HItem("CeramicPanelUnf").setCreativeTab(ModCreativeTab.tabJammyFurniture);
		ModItems.itemCeramicPanel    = new HItem("CeramicPanel"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		ModItems.itemWMDrum          = new HItem("WMDrum"         ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		ModItems.itemBlindPart       = new HItem("BlindPart"      ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
	}
}
