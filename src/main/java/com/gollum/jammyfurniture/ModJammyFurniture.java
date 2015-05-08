package com.gollum.jammyfurniture;

import net.minecraft.item.Item;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.i18n.I18n;
import com.gollum.core.common.log.Logger;
import com.gollum.core.common.mod.GollumMod;
import com.gollum.core.common.version.VersionChecker;
import com.gollum.core.tools.helper.items.HItem;
import com.gollum.core.tools.registry.InventoryRegistry;
import com.gollum.core.tools.registry.SoundRegistry;
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
import com.gollum.jammyfurniture.common.tilesentities.TileEntityBath;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;
import com.gollum.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import com.gollum.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import com.gollum.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import com.gollum.jammyfurniture.inits.ModRecipes;
import com.gollum.jammyfurniture.inits.ModBlocks;
import com.gollum.jammyfurniture.inits.ModCreativeTab;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(
	modid = ModJammyFurniture.MODID,
	name = ModJammyFurniture.MODNAME,
	version = ModJammyFurniture.VERSION,
	acceptedMinecraftVersions = ModJammyFurniture.MINECRAFT_VERSION,
	dependencies = ModJammyFurniture.DEPENDENCIES
)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModJammyFurniture extends GollumMod {

	public final static String MODID = "JammyFurniture";
	public final static String MODNAME = "Jammy Furniture";
	public final static String VERSION = "5.0.0 [Build Smeagol]";
	public final static String MINECRAFT_VERSION = "1.6.4";
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
	
	/////////////////////
	// Liste des items //
	/////////////////////
	public static Item itemLightBulb;
	public static Item itemMantlePieceUnf;
	public static Item itemCeramicPanelUnf;
	public static Item itemCeramicPanel;
	public static Item itemWMDrum;
	public static Item itemBlindPart;
	
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
		
		// Initialisation des blocks
//		this.initItems ();
		
		// Test la version du mod
		new VersionChecker();
	}

	/** 2 **/
	public void init(FMLInitializationEvent event) {
		
		// Execution du renderer en fonction du serveur ou du client
		proxy.registerRenderers();
		
		// Initialisation des sons
		this.initSounds ();
		
		// Initialisation les TileEntities
		this.initTileEntities ();
		
		EntityRegistry.registerModEntity(EntityMountableBlock.class, this.MODID+":EntityMountableBlock", 1, this, 400, 5, false);
		
		// Ajout des recettes
//		new ModRecipes().initRecipes();
		
	}
	
	/** 3 **/
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	/**
	 * Initialisation des sons
	 */
	public void initSounds () {
		
		SoundRegistry.register("clock-tick");
		SoundRegistry.register("clock-dong");
		SoundRegistry.register("machine");
		SoundRegistry.register("radio");
		SoundRegistry.register("toilet");
		SoundRegistry.register("trashopen");
		SoundRegistry.register("trashclosed");
		SoundRegistry.register("sink_water");
		
	}
	
	/**
	 * Initialisation des items
	 */
	public void initItems () {
		itemLightBulb       = new HItem(this.config.itemLightBulbID      ,"LightBulb"      ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		itemMantlePieceUnf  = new HItem(this.config.itemMantlePieceUnfID ,"MantlePieceUnf" ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		itemCeramicPanelUnf = new HItem(this.config.itemCeramicPanelUnfID,"CeramicPanelUnf").setCreativeTab(ModCreativeTab.tabJammyFurniture);
		itemCeramicPanel    = new HItem(this.config.itemCeramicPanelID   ,"CeramicPanel"   ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		itemWMDrum          = new HItem(this.config.itemWMDrumID         ,"WMDrum"         ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
		itemBlindPart       = new HItem(this.config.itemBlindPartID      ,"BlindPart"      ).setCreativeTab(ModCreativeTab.tabJammyFurniture);
	}
	
	/**
	 * // Nom des TileEntities
	 */
	private void initTileEntities () {
		
		GameRegistry.registerTileEntity(TileEntityWoodBlocksOne.class   , "TileEntityWoodBlocks");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksTwo.class   , "TileEntityWoodBlocksTwo");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksThree.class , "TileEntityWoodBlocksThree");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksFour.class  , "TileEntityWoodBlocksFour");
		GameRegistry.registerTileEntity(TileEntityBath.class            , "TileEntityBath");
		GameRegistry.registerTileEntity(TileEntityIronBlocksOne.class   , "TileEntityIronBlocksOne");
		GameRegistry.registerTileEntity(TileEntityIronBlocksTwo.class   , "TileEntityIronBlocksTwo");
		GameRegistry.registerTileEntity(TileEntityCeramicBlocksOne.class, "TileEntityCeramicBlocksOne");
		GameRegistry.registerTileEntity(TileEntityRoofingBlocksOne.class, "TileEntityRoofingBlocksOne");
		GameRegistry.registerTileEntity(TileEntityMobHeadsOne.class     , "TileEntityMobHeadsOne");
		GameRegistry.registerTileEntity(TileEntityMobHeadsTwo.class     , "TileEntityMobHeadsTwo");
		GameRegistry.registerTileEntity(TileEntityMobHeadsThree.class   , "TileEntityMobHeadsThree");
		GameRegistry.registerTileEntity(TileEntityMobHeadsFour.class    , "TileEntityMobHeadsFour");
		GameRegistry.registerTileEntity(TileEntityArmChair.class        , "TileEntityArmChair");
		GameRegistry.registerTileEntity(TileEntitySofaLeft.class        , "TileEntitySofaLeft");
		GameRegistry.registerTileEntity(TileEntitySofaRight.class       , "TileEntitySofaRight");
		GameRegistry.registerTileEntity(TileEntitySofaCenter.class      , "TileEntitySofaCenter");
		GameRegistry.registerTileEntity(TileEntitySofaCorner.class      , "TileEntitySofaCorner");
		GameRegistry.registerTileEntity(TileEntityMiscBlockOne.class    , "TileEntityMiscOne");
		GameRegistry.registerTileEntity(TileEntityLightsOn.class        , "TileEntityLightsOn");
		GameRegistry.registerTileEntity(TileEntityLightsOff.class       , "TileEntityLightsOff");
		
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
