package com.gollum.jammyfurniture;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.i18n.I18n;
import com.gollum.core.common.log.Logger;
import com.gollum.core.common.mod.GollumMod;
import com.gollum.core.common.version.VersionChecker;
import com.gollum.core.tools.registry.InventoryRegistry;
import com.gollum.jammyfurniture.client.gui.GuiCooker;
import com.gollum.jammyfurniture.client.gui.GuiCraftingSide;
import com.gollum.jammyfurniture.client.gui.GuiDishwasher;
import com.gollum.jammyfurniture.client.gui.GuiWashingMachine;
import com.gollum.jammyfurniture.common.CommonProxyJammyFurniture;
import com.gollum.jammyfurniture.common.config.ConfigJammyFuniture;
import com.gollum.jammyfurniture.common.containers.ContainerCooker;
import com.gollum.jammyfurniture.common.containers.ContainerCraftingSide;
import com.gollum.jammyfurniture.common.containers.ContainerDishwasher;
import com.gollum.jammyfurniture.common.containers.ContainerWashingMachine;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.gollum.jammyfurniture.inits.ModBlocks;
import com.gollum.jammyfurniture.inits.ModCreativeTab;
import com.gollum.jammyfurniture.inits.ModItems;
import com.gollum.jammyfurniture.inits.ModRecipes;
import com.gollum.jammyfurniture.inits.ModRecipesCompatibility;
import com.gollum.jammyfurniture.inits.ModTileEntities;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(
	modid = ModJammyFurniture.MODID,
	name = ModJammyFurniture.MODNAME,
	version = ModJammyFurniture.VERSION,
	acceptedMinecraftVersions = ModJammyFurniture.MINECRAFT_VERSION,
	dependencies = ModJammyFurniture.DEPENDENCIES
)
public class ModJammyFurniture extends GollumMod {

	public final static String MODID = "JammyFurniture";
	public final static String MODNAME = "Jammy Furniture";
	public final static String VERSION = "5.0.1DEV [Build Smeagol]";
	public final static String MINECRAFT_VERSION = "1.7.10";
	public final static String DEPENDENCIES = "required-after:"+ModGollumCoreLib.MODID;
	
	@Instance(ModJammyFurniture.MODID)
	public static ModJammyFurniture instance;
	
	@SidedProxy(clientSide = "com.gollum.jammyfurniture.client.ClientProxyJammyFurniture", serverSide = "com.gollum.jammyfurniture.common.CommonProxyJammyFurniture")
	public static CommonProxyJammyFurniture proxy;
	
	/**
	 * Gestion des logs
	 */
	public static Logger log;
	
	/**
	 * Gestion de l'i18n
	 */
	public static I18n i18n;
	
	/**
	 * La configuration
	 */
	public static ConfigJammyFuniture config;
	
	/////////////////
	// Renders IDs //
	/////////////////
	
	public static int woodBlocksOneRenderID;
	public static int woodBlocksTwoRenderID;
	public static int woodBlocksThreeRenderID;
	public static int woodBlocksFourRenderID;
	public static int bathTubRenderID;
	public static int ironBlocksOneRenderID;
	public static int ironBlocksTwoRenderID;
	public static int ceramicBlocksOneRenderID;
	public static int roofingBlocksOneRenderID;
	public static int mobHeadsOneRenderID;
	public static int mobHeadsTwoRenderID;
	public static int mobHeadsThreeRenderID;
	public static int mobHeadsFourRenderID;
	public static int sofaRenderID;
	public static int miscBlocksOneRenderID;
	public static int lightsRenderID;
	
	/////////////
	// GUI IDs //
	/////////////
	
	public static final int GUI_BARHROOMCUPBOARD_ID = 0;
	public static final int GUI_CLOCK_ID            = 1;
	public static final int GUI_COOKER_ID           = 2;
	public static final int GUI_KITCHENCUPBOARD_ID  = 3;
	public static final int GUI_WASHINGMACHINE_ID   = 4;
	public static final int GUI_FRIDGE_ID           = 5;
	public static final int GUI_RUBBISHBIN_ID       = 6;
	public static final int GUI_DISHWASHER_ID       = 7;
	public static final int GUI_CRAFTSIDE_ID        = 8;
	public static final int GUI_WARDROBE_ID         = 9;
	
	@EventHandler public void handler(FMLPreInitializationEvent event)  { super.handler (event); }
	@EventHandler public void handler(FMLInitializationEvent event)     { super.handler (event); }
	@EventHandler public void handler(FMLPostInitializationEvent event) { super.handler (event); }
	
	/** 1 */
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		// Initialisation des blocks
		ModBlocks.init ();
		
		// Initialisation des items
		ModItems.init ();
		
		// Test la version du mod
		new VersionChecker();
	}

	/** 2 **/
	public void init(FMLInitializationEvent event) {
		
		// Execution du renderer en fonction du serveur ou du client
		proxy.registerRenderers();
		
		// Initialisation les TileEntities
		ModTileEntities.init ();
		
		EntityRegistry.registerModEntity(EntityMountableBlock.class, this.MODID+":EntityMountableBlock", 1, this, 400, 5, false);
		
		// Ajout des recettes
		ModRecipes.init ();
		
		// Set de l'icon du tab creative
		ModCreativeTab.init();
		
	}
	
	/** 3 **/
	public void postInit(FMLPostInitializationEvent event) {
		// Ajout de la compatibilitéavec les autres mods
		ModRecipesCompatibility.init ();
	}
	
	/**
	 * Initialisation des GUI coté serveur et client
	 */
	@Override
	public void initGuiCommon () {
		InventoryRegistry.registerInventory (GUI_CLOCK_ID           , 3);
		InventoryRegistry.registerInventory (GUI_KITCHENCUPBOARD_ID , 3);
		InventoryRegistry.registerInventory (GUI_FRIDGE_ID          , 3);
		InventoryRegistry.registerInventory (GUI_RUBBISHBIN_ID      , 9);
		InventoryRegistry.registerInventory (GUI_BARHROOMCUPBOARD_ID, 4);
		InventoryRegistry.registerInventory (GUI_WARDROBE_ID        , 4);
		InventoryRegistry.registerContainer (GUI_CRAFTSIDE_ID       , ContainerCraftingSide.class);
		InventoryRegistry.registerContainer (GUI_COOKER_ID          , ContainerCooker.class);
		InventoryRegistry.registerContainer (GUI_WASHINGMACHINE_ID  , ContainerWashingMachine.class);
		InventoryRegistry.registerContainer (GUI_DISHWASHER_ID      , ContainerDishwasher.class);
	}
	
	/**
	 * Initialisation des GUI
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void initGuiClient () {
		InventoryRegistry.registerGui (GUI_CRAFTSIDE_ID     , GuiCraftingSide.class);
		InventoryRegistry.registerGui (GUI_COOKER_ID        , GuiCooker.class);
		InventoryRegistry.registerGui (GUI_WASHINGMACHINE_ID, GuiWashingMachine.class);
		InventoryRegistry.registerGui (GUI_DISHWASHER_ID    , GuiDishwasher.class);
	}
}
