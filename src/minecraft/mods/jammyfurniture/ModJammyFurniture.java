package mods.jammyfurniture;

import mods.gollum.core.common.creativetab.GollumCreativeTabs;
import mods.gollum.core.common.mod.GollumMod;
import mods.gollum.core.common.version.VersionChecker;
import mods.gollum.core.tools.helper.items.HItem;
import mods.gollum.core.tools.registry.InventoryRegistry;
import mods.gollum.core.tools.registry.SoundRegistry;
import mods.jammyfurniture.client.gui.GuiCooker;
import mods.jammyfurniture.client.gui.GuiCraftingSide;
import mods.jammyfurniture.client.gui.GuiDishwasher;
import mods.jammyfurniture.client.gui.GuiWashingMachine;
import mods.jammyfurniture.common.CommonProxyJammyFurniture;
import mods.jammyfurniture.common.block.BathBlock;
import mods.jammyfurniture.common.block.BlockLights;
import mods.jammyfurniture.common.block.BlockSofa;
import mods.jammyfurniture.common.block.ceramic.CeramicBlocksOne;
import mods.jammyfurniture.common.block.head.MobHeadsFour;
import mods.jammyfurniture.common.block.head.MobHeadsOne;
import mods.jammyfurniture.common.block.head.MobHeadsThree;
import mods.jammyfurniture.common.block.head.MobHeadsTwo;
import mods.jammyfurniture.common.block.iron.IronBlocksOne;
import mods.jammyfurniture.common.block.iron.IronBlocksTwo;
import mods.jammyfurniture.common.block.misc.MiscBlocksOne;
import mods.jammyfurniture.common.block.roofing.RoofingBlocksOne;
import mods.jammyfurniture.common.block.wood.WoodBlocksFour;
import mods.jammyfurniture.common.block.wood.WoodBlocksOne;
import mods.jammyfurniture.common.block.wood.WoodBlocksThree;
import mods.jammyfurniture.common.block.wood.WoodBlocksTwo;
import mods.jammyfurniture.common.config.ConfigJammyFuniture;
import mods.jammyfurniture.common.containers.ContainerCooker;
import mods.jammyfurniture.common.containers.ContainerCraftingSide;
import mods.jammyfurniture.common.containers.ContainerDishwasher;
import mods.jammyfurniture.common.containers.ContainerWashingMachine;
import mods.jammyfurniture.common.entities.EntityMountableBlock;
import mods.jammyfurniture.common.recipes.JFRecipes;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import mods.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;
import mods.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.sofa.TileEntitySofaRight;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksFour;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksOne;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.wood.TileEntityWoodBlocksTwo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

@Mod(modid = ModJammyFurniture.MODID, name = ModJammyFurniture.MODNAME, version = ModJammyFurniture.VERSION, acceptedMinecraftVersions = ModJammyFurniture.MINECRAFT_VERSION, dependencies = ModJammyFurniture.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModJammyFurniture extends GollumMod {

	public final static String MODID = "JammyFurniture";
	public final static String MODNAME = "Jammy Furniture";
	public final static String VERSION = "5.0.0 [Build Smeagol]";
	public final static String MINECRAFT_VERSION = "1.6.4";
	public final static String DEPENDENCIES = "required-after:GollumCoreLib";
	
	@Instance(ModJammyFurniture.MODID)
	public static ModJammyFurniture instance;
	
	@SidedProxy(clientSide = "mods.jammyfurniture.client.ClientProxyJammyFurniture", serverSide = "mods.jammyfurniture.common.CommonProxyJammyFurniture")
	public static CommonProxyJammyFurniture proxy;
	
	/**
	 * La configuration
	 */
	public static ConfigJammyFuniture config;
	
	/**
	 * Tab du mode creative
	 */
	public static GollumCreativeTabs tabJammyFurniture = new GollumCreativeTabs("JammyFurniture");; 
	
	
	/////////////////////
	// Liste des blocs //
	/////////////////////
	public static Block blockWoodBlocksOne;
	public static Block blockWoodBlocksTwo;
	public static Block blockWoodBlocksThree;
	public static Block blockWoodBlocksFour;
	public static Block blockBathTub;
	public static Block blockIronBlocksOne;
	public static Block blockIronBlocksTwo;
	public static Block blockCeramicBlocksOne;
	public static Block blockRoofingBlocksOne;
	public static Block blockMobHeadsOne;
	public static Block blockMobHeadsTwo;
	public static Block blockMobHeadsThree;
	public static Block blockMobHeadsFour;
	public static Block blockArmChair;
	public static Block blockSofaPartLeft;
	public static Block blockSofaPartRight;
	public static Block blockSofaPartCenter;
	public static Block blockSofaPartCorner;
	public static Block blockMiscBlocksOne;
	public static Block blockLightsOn;
	public static Block blockLightsOff;
	
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
		
		// Charge la configuration
		this.config = new ConfigJammyFuniture().loadConfig();
		
		// Test la version du mod
		new VersionChecker();
		
		// Initialisation des blocks
		this.initBlocks ();
		
		// Initialisation des blocks
		this.initItems ();
		
		this.tabJammyFurniture.setIcon(this.blockArmChair);
	}

	/** 2 **/
	public void init(FMLInitializationEvent event) {
		
		// Execution du renderer en fonction du serveur ou du client
		proxy.registerRenderers();
		
		// Initialisation des sons
		this.initSounds ();
		
		// Initialisation les TileEntities
		this.initTileEntities ();
		
		EntityRegistry.registerModEntity(EntityMountableBlock.class, "EntityMountableBlock", 1, this, 400, 5, false);
		
		// Ajout des recettes
		new JFRecipes().initRecipes();
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
	 * Initialisation des blocks
	 */
	public void initBlocks () {
		
		blockBathTub          = new BathBlock       (this.config.blockBathTubID         , "BathBlock"       ).setCreativeTab(this.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
		blockLightsOn         = new BlockLights     (this.config.blockLightsOnID        , "LightsOn" ,true  ).setCreativeTab(this.tabJammyFurniture).setHardness(0.3F);
		blockLightsOff        = new BlockLights     (this.config.blockLightsOffID       , "LightsOff",false )                                       .setHardness(0.3F);
		
		
		blockWoodBlocksOne    = new WoodBlocksOne   (this.config.blockWoodBlocksOneID   , "WoodBlocksOne"   ).setCreativeTab(this.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		blockWoodBlocksTwo    = new WoodBlocksTwo   (this.config.blockWoodBlocksTwoID   , "WoodBlocksTwo"   ).setCreativeTab(this.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		blockWoodBlocksThree  = new WoodBlocksThree (this.config.blockWoodBlocksThreeID , "WoodBlocksThree" ).setCreativeTab(this.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		blockWoodBlocksFour   = new WoodBlocksFour  (this.config.blockWoodBlocksFourID  , "WoodBlocksFour"  ).setCreativeTab(this.tabJammyFurniture).setHardness(2.0F).setResistance(1.0F);
		
		blockIronBlocksOne    = new IronBlocksOne   (this.config.blockIronBlocksOneID   , "IronBlocksOne"   ).setCreativeTab(this.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
		blockIronBlocksTwo    = new IronBlocksTwo   (this.config.blockIronBlocksTwoID   , "IronBlocksTwo"   ).setCreativeTab(this.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep);
		
		blockCeramicBlocksOne = new CeramicBlocksOne(this.config.blockCeramicBlocksOneID, "CeramicBlocksOne").setCreativeTab(this.tabJammyFurniture).setHardness(3.0F).setResistance(1.0F);
		
		blockRoofingBlocksOne = new RoofingBlocksOne(this.config.blockRoofingBlocksOneID, "RoofingBlocksOne").setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		
		blockMiscBlocksOne    = new MiscBlocksOne   (this.config.blockMiscBlocksOneID   , "MiscBlocksOne"   ).setCreativeTab(this.tabJammyFurniture).setHardness(2.0F).setResistance(10.0F);
		
		blockMobHeadsOne      = new MobHeadsOne     (this.config.blockMobHeadsOneID     , "MobHeadsOne"     ).setCreativeTab(this.tabJammyFurniture).setHardness(0.8F);
		blockMobHeadsTwo      = new MobHeadsTwo     (this.config.blockMobHeadsTwoID     , "MobHeadsTwo"     ).setCreativeTab(this.tabJammyFurniture).setHardness(0.8F);
		blockMobHeadsThree    = new MobHeadsThree   (this.config.blockMobHeadsThreeID   , "MobHeadsThree"   ).setCreativeTab(this.tabJammyFurniture).setHardness(0.8F);
		blockMobHeadsFour     = new MobHeadsFour    (this.config.blockMobHeadsFourID    , "MobHeadsFour"    ).setCreativeTab(this.tabJammyFurniture).setHardness(0.8F);
		
		blockArmChair         = new BlockSofa(this.config.blockArmChairID      , "ArmChair"  , TileEntityArmChair.class  ).setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		blockSofaPartLeft     = new BlockSofa(this.config.blockSofaPartLeftID  , "SofaLeft"  , TileEntitySofaLeft.class  ).setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		blockSofaPartRight    = new BlockSofa(this.config.blockSofaPartRightID , "SofaRight" , TileEntitySofaRight.class ).setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		blockSofaPartCenter   = new BlockSofa(this.config.blockSofaPartCenterID, "SofaCenter", TileEntitySofaCenter.class).setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		blockSofaPartCorner   = new BlockSofa(this.config.blockSofaPartCornerID, "SofaCorner", TileEntitySofaCorner.class).setCreativeTab(this.tabJammyFurniture).setHardness(1.2F);
		
	}
	
	/**
	 * Initialisation des items
	 */
	public void initItems () {
		itemLightBulb       = new HItem(this.config.itemLightBulbID      ,"LightBulb"      ).setCreativeTab(this.tabJammyFurniture);
		itemMantlePieceUnf  = new HItem(this.config.itemMantlePieceUnfID ,"MantlePieceUnf" ).setCreativeTab(this.tabJammyFurniture);
		itemCeramicPanelUnf = new HItem(this.config.itemCeramicPanelUnfID,"CeramicPanelUnf").setCreativeTab(this.tabJammyFurniture);
		itemCeramicPanel    = new HItem(this.config.itemCeramicPanelID   ,"CeramicPanel"   ).setCreativeTab(this.tabJammyFurniture);
		itemWMDrum          = new HItem(this.config.itemWMDrumID         ,"WMDrum"         ).setCreativeTab(this.tabJammyFurniture);
		itemBlindPart       = new HItem(this.config.itemBlindPartID      ,"BlindPart"      ).setCreativeTab(this.tabJammyFurniture);
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
