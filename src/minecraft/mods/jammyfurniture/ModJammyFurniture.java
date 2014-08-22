package mods.jammyfurniture;

import java.io.File;

import mods.gollum.core.creativetab.GollumCreativeTabs;
import mods.gollum.core.helper.items.HItem;
import mods.gollum.core.mod.GollumMod;
import mods.gollum.core.sound.SoundRegistry;
import mods.gollum.core.version.VersionChecker;
import mods.jammyfurniture.common.CommonProxyJammyFurniture;
import mods.jammyfurniture.common.block.JFBathBlock;
import mods.jammyfurniture.common.block.jfm_BlockLightsOn;
import mods.jammyfurniture.common.block.jfm_BlockMiscOne;
import mods.jammyfurniture.common.block.ceramic.jfm_CeramicBlocksOne;
import mods.jammyfurniture.common.block.head.jfm_MobHeadsFour;
import mods.jammyfurniture.common.block.head.jfm_MobHeadsOne;
import mods.jammyfurniture.common.block.head.jfm_MobHeadsThree;
import mods.jammyfurniture.common.block.head.jfm_MobHeadsTwo;
import mods.jammyfurniture.common.block.iron.JFIronBlocksOne;
import mods.jammyfurniture.common.block.iron.JFIronBlocksTwo;
import mods.jammyfurniture.common.block.roofing.jfm_RoofingBlocksOne;
import mods.jammyfurniture.common.block.sofa.jfm_BlockArmChair;
import mods.jammyfurniture.common.block.sofa.jfm_BlockSofaCenter;
import mods.jammyfurniture.common.block.sofa.jfm_BlockSofaCorner;
import mods.jammyfurniture.common.block.sofa.jfm_BlockSofaLeft;
import mods.jammyfurniture.common.block.sofa.jfm_BlockSofaRight;
import mods.jammyfurniture.common.block.wood.JFWoodBlocksOne;
import mods.jammyfurniture.common.block.wood.JFWoodBlocksThree;
import mods.jammyfurniture.common.block.wood.JFWoodBlocksTwo;
import mods.jammyfurniture.common.config.ConfigJammyFuniture;
import mods.jammyfurniture.common.item.JFItemArmChair;
import mods.jammyfurniture.common.item.JFItemBath;
import mods.jammyfurniture.common.item.JFItemCeramicBlocksOne;
import mods.jammyfurniture.common.item.JFItemIronBlocksOne;
import mods.jammyfurniture.common.item.JFItemIronBlocksTwo;
import mods.jammyfurniture.common.item.JFItemMobHeadsFour;
import mods.jammyfurniture.common.item.JFItemMobHeadsOne;
import mods.jammyfurniture.common.item.JFItemMobHeadsThree;
import mods.jammyfurniture.common.item.JFItemMobHeadsTwo;
import mods.jammyfurniture.common.item.JFItemRoofingBlocksOne;
import mods.jammyfurniture.common.item.JFItemWoodBlocksOne;
import mods.jammyfurniture.common.item.JFItemWoodBlocksThree;
import mods.jammyfurniture.common.item.JFItemWoodBlocksTwo;
import mods.jammyfurniture.common.item.jfm_ItemLightsOn;
import mods.jammyfurniture.common.item.jfm_ItemMiscOne;
import mods.jammyfurniture.common.item.jfm_ItemSofaCenter;
import mods.jammyfurniture.common.item.jfm_ItemSofaCorner;
import mods.jammyfurniture.common.item.jfm_ItemSofaLeft;
import mods.jammyfurniture.common.item.jfm_ItemSofaRight;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntityBath;
import mods.jammyfurniture.common.tilesentities.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksTwo;
import mods.jammyfurniture.common.tilesentities.TileEntityLightsOn;
import mods.jammyfurniture.common.tilesentities.TileEntityMiscOne;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsFour;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsOne;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsThree;
import mods.jammyfurniture.common.tilesentities.TileEntityMobHeadsTwo;
import mods.jammyfurniture.common.tilesentities.TileEntityRoofingBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaRight;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksOne;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksThree;
import mods.jammyfurniture.common.tilesentities.TileEntityWoodBlocksTwo;
import mods.jammyfurniture.common.util.EntityMountableBlock;
import mods.jammyfurniture.common.util.JFGuiHandler;
import mods.jammyfurniture.common.util.jfm_Config;
import mods.jammyfurniture.common.util.jfm_ConfigDefault;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	
	
	
	public static jfm_Config configOld;
	public static jfm_ConfigDefault configDefault;

	
	/////////////////////
	// Liste des blocs //
	/////////////////////
	public static Block blockWoodBlocksOne;
	public static Block blockWoodBlocksTwo;
	public static Block blockWoodBlocksThree;
	public static Block blockBathTub;
	public static Block blockIronBlocksOne;
	public static Block blockIronBlocksTwo;
	public static Block blockCeramicBlocksOne;
	public static Block blockRoofingBlocksOne;
	public static Block blockMobHeadsOne;
	public static Block blockMobHeadsTwo;
	public static Block blockMobHeadsThree;
	public static Block blcokMobHeadsFour;
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
	
	public static Item itemWoodBlocksOne;
	public static Item itemWoodBlocksTwo;
	public static Item itemWoodBlocksThree;
	public static Item itemBathTub;
	public static Item itemIronBlocksOne;
	public static Item itemIronBlocksTwo;
	public static Item itemCeramicBlocksOne;
	public static Item itemRoofingBlocksOne;
	public static Item itemMobHeadsOne;
	public static Item itemMobHeadsTwo;
	public static Item itemMobHeadsThree;
	public static Item itemMobHeadsFour;
	public static Item itemArmChair;
	public static Item itemSofaPartLeft;
	public static Item itemSofaPartRight;
	public static Item itemSofaPartCenter;
	public static Item itemSofaPartCorner;
	public static Item itemMiscBlocksOne;
	public static Item itemLightsOn;
	public static Item itemLightsOff;
	
	/////////////////
	// Renders IDs //
	/////////////////
	public static int woodBlocksOneRenderID;
	public static int woodBlocksTwoRenderID;
	public static int woodBlocksThreeRenderID;
	public static int bathTubRenderID;
	public static int ironBlocksOneRenderID;
	public static int ironBlocksTwoRenderID;
	public static int ceramicBlocksOneRenderID;
	public static int roofingBlocksOneRenderID;
	public static int mobHeadsOneRenderID;
	public static int mobHeadsTwoRenderID;
	public static int mobHeadsThreeRenderID;
	public static int mobHeadsFourRenderID;
	public static int armChairRenderID;
	public static int sofaPartLeftRenderID;
	public static int sofaPartRightRenderID;
	public static int sofaPartCenterRenderID;
	public static int sofaPartCornerRenderID;
	public static int miscBlocksOneRenderID;
	public static int lightsRenderID;
	
	/**
	 * 1
	 */
	@EventHandler
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		super.preInit (event);
		
		// Charge la configuration
		this.config = new ConfigJammyFuniture();
		
		// Test la version du mod
		new VersionChecker();
		
		// Initialisation des blocks
		this.initBlocks ();
		
		// Initialisation des blocks
		this.initItems ();
		
		
		// TODO va disparaitre
		
		configOld = new jfm_Config(new File("config", "JammyFurnitureMod.conf"));
		/*
		try {
			configOld.load();
			Property LIGHT_BULB_ID = configOld.getItem("light_bulb.id", "item", jfm_ConfigDefault.ITEM_LIGHT_BULB_ID);
			Property UNFMANTLE_ID = configOld.getItem("mantle_piece_unf.id", "item", jfm_ConfigDefault.ITEM_UNFMANTLE_ID);
			Property CERAMICUNF_ID = configOld.getItem("ceramic_panel_unf.id", "item", jfm_ConfigDefault.ITEM_CERAMIC_UNF_ID);
			Property CERAMIC_ID = configOld.getItem("ceramic_panel.id", "item", jfm_ConfigDefault.ITEM_CERAMIC_ID);
			Property WMDRUM_ID = configOld.getItem("wm_drum.id", "item", jfm_ConfigDefault.ITEM_WMDRUM_ID);
			Property BLIND_PART_ID = configOld.getItem("blind_part.id", "item", jfm_ConfigDefault.ITEM_BLIND_PART_ID);
			
			Property WOOD_ONE_ID = configOld.getBlock("wood_one.id", "block", jfm_ConfigDefault.WOOD_ONE_ID);
			Property WOOD_TWO_ID = configOld.getBlock("wood_two.id", "block", jfm_ConfigDefault.WOOD_TWO_ID);
			Property WOOD_THREE_ID = configOld.getBlock("wood_three.id", "block", jfm_ConfigDefault.WOOD_THREE_ID);
			Property BATH_BLOCK_ID = configOld.getBlock("bath.id", "block", jfm_ConfigDefault.BATH_ID);
			Property IRON_ONE_ID = configOld.getBlock("iron_one.id", "block", jfm_ConfigDefault.IRON_ONE_ID);
			Property IRON_TWO_ID = configOld.getBlock("iron_two.id", "block", jfm_ConfigDefault.IRON_TWO_ID);
			
			Property CERAMIC_ONE_ID = configOld.getBlock("ceramic_one.id", "block", jfm_ConfigDefault.CERAMIC_ONE_ID);
			Property ROOFING_ONE_ID = configOld.getBlock("roofing_one.id", "block", jfm_ConfigDefault.ROOFING_ONE_ID);
			Property MOB_HEADS_ONE = configOld.getBlock("mob_heads_one.id", "block", jfm_ConfigDefault.MOB_HEADS_ONE);
			Property MOB_HEADS_TWO = configOld.getBlock("mob_heads_two.id", "block", jfm_ConfigDefault.MOB_HEADS_TWO);
			Property MOB_HEADS_THREE = configOld.getBlock("mob_heads_three.id", "block", jfm_ConfigDefault.MOB_HEADS_THREE);
			Property MOB_HEADS_FOUR = configOld.getBlock("mob_heads_four.id", "block", jfm_ConfigDefault.MOB_HEADS_FOUR);
			Property ARM_CHAIR_ID = configOld.getBlock("arm_chair.id", "block", jfm_ConfigDefault.ARM_CHAIR_ID);
			
			Property SOFA_LEFT_ID = configOld.getBlock("sofa_left.id", "block", jfm_ConfigDefault.SOFA_LEFT_ID);
			Property SOFA_RIGHT_ID = configOld.getBlock("sofa_right.id", "block", jfm_ConfigDefault.SOFA_RIGHT_ID);
			Property SOFA_CENTER_ID = configOld.getBlock("sofa_center.id", "block", jfm_ConfigDefault.SOFA_CENTER_ID);
			Property SOFA_CORNER_ID = configOld.getBlock("sofa_corner.id", "block", jfm_ConfigDefault.SOFA_CORNER_ID);
			Property MISC_ONE_ID = configOld.getBlock("misc_one.id", "block", jfm_ConfigDefault.MISC_ONE_ID);
			Property LIGHTS_ON_ID = configOld.getBlock("lights_on.id", "block", jfm_ConfigDefault.LIGHTS_ON_ID);
			Property LIGHTS_OFF_ID = configOld.getBlock("lights_off.id", "block", jfm_ConfigDefault.LIGHTS_OFF_ID);
			
			blockCeramicBlocksOne = (new jfm_CeramicBlocksOne(Integer.parseInt(CERAMIC_ONE_ID.getString()), 0, TileEntityCeramicBlocksOne.class)).setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ceramicBlockOne").setCreativeTab(tabJammyFurniture);
			blockRoofingBlocksOne = (new jfm_RoofingBlocksOne(Integer.parseInt(ROOFING_ONE_ID.getString()), 0, TileEntityRoofingBlocksOne.class)).setHardness(1.2F).setUnlocalizedName("roofingBlocksOne").setCreativeTab(tabJammyFurniture);
			blockMobHeadsOne = (new jfm_MobHeadsOne(Integer.parseInt(MOB_HEADS_ONE.getString()), 0, TileEntityMobHeadsOne.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsOne").setCreativeTab(tabJammyFurniture);
			blockMobHeadsTwo = (new jfm_MobHeadsTwo(Integer.parseInt(MOB_HEADS_TWO.getString()), 0, TileEntityMobHeadsTwo.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsTwo").setCreativeTab(tabJammyFurniture);
			blockMobHeadsThree = (new jfm_MobHeadsThree(Integer.parseInt(MOB_HEADS_THREE.getString()), 0, TileEntityMobHeadsThree.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsThree").setCreativeTab(tabJammyFurniture);
			blcokMobHeadsFour = (new jfm_MobHeadsFour(Integer.parseInt(MOB_HEADS_FOUR.getString()), 0, TileEntityMobHeadsFour.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsFour").setCreativeTab(tabJammyFurniture);
			blockArmChair = (new jfm_BlockArmChair(Integer.parseInt(ARM_CHAIR_ID.getString()), 0, TileEntityArmChair.class)).setHardness(1.2F).setUnlocalizedName("armChair").setCreativeTab(tabJammyFurniture);
			
			blockSofaPartLeft = (new jfm_BlockSofaLeft(Integer.parseInt(SOFA_LEFT_ID.getString()), 0, TileEntitySofaLeft.class)).setHardness(1.2F).setUnlocalizedName("sofaLeft").setCreativeTab(tabJammyFurniture);
			blockSofaPartRight = (new jfm_BlockSofaRight(Integer.parseInt(SOFA_RIGHT_ID.getString()), 0, TileEntitySofaRight.class)).setHardness(1.2F).setUnlocalizedName("sofaRight").setCreativeTab(tabJammyFurniture);
			blockSofaPartCenter = (new jfm_BlockSofaCenter(Integer.parseInt(SOFA_CENTER_ID.getString()), 0, TileEntitySofaCenter.class)).setHardness(1.2F).setUnlocalizedName("sofaCenter").setCreativeTab(tabJammyFurniture);
			blockSofaPartCorner = (new jfm_BlockSofaCorner(Integer.parseInt(SOFA_CORNER_ID.getString()), 0, TileEntitySofaCorner.class)).setHardness(1.2F).setUnlocalizedName("sofaCorner").setCreativeTab(tabJammyFurniture);
			blockMiscBlocksOne = (new jfm_BlockMiscOne(Integer.parseInt(MISC_ONE_ID.getString()), 0, TileEntityMiscOne.class)).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("miscOne").setCreativeTab(tabJammyFurniture);
			blockLightsOn = (new jfm_BlockLightsOn(Integer.parseInt(LIGHTS_ON_ID.getString()), 0, TileEntityLightsOn.class, true)).setHardness(0.3F).setUnlocalizedName("lightsOn").setCreativeTab(tabJammyFurniture);
			blockLightsOff = (new jfm_BlockLightsOn(Integer.parseInt(LIGHTS_OFF_ID.getString()), 0, TileEntityLightsOn.class, false)).setHardness(0.3F).setUnlocalizedName("lightsOff");
			
			
			
			itemCeramicBlocksOne = (new JFItemCeramicBlocksOne(Integer.parseInt(CERAMIC_ONE_ID.getString()) - 256, blockCeramicBlocksOne)).setUnlocalizedName("itemCeramicBlocksOne").setCreativeTab(tabJammyFurniture);
			itemRoofingBlocksOne = (new JFItemRoofingBlocksOne(Integer.parseInt(ROOFING_ONE_ID.getString()) - 256, blockRoofingBlocksOne)).setUnlocalizedName("itemRoofingBlocksOne").setCreativeTab(tabJammyFurniture);
			itemMobHeadsOne = (new JFItemMobHeadsOne(Integer.parseInt(MOB_HEADS_ONE.getString()) - 256, blockMobHeadsOne)).setUnlocalizedName("itemMobHeadsOne").setCreativeTab(tabJammyFurniture);
			itemMobHeadsTwo = (new JFItemMobHeadsTwo(Integer.parseInt(MOB_HEADS_TWO.getString()) - 256, blockMobHeadsTwo)).setUnlocalizedName("itemMobHeadsTwo").setCreativeTab(tabJammyFurniture);
			itemMobHeadsThree = (new JFItemMobHeadsThree(Integer.parseInt(MOB_HEADS_THREE.getString()) - 256, blockMobHeadsThree)).setUnlocalizedName("itemMobHeadsThree").setCreativeTab(tabJammyFurniture);
			itemMobHeadsFour = (new JFItemMobHeadsFour(Integer.parseInt(MOB_HEADS_FOUR.getString()) - 256, blcokMobHeadsFour)).setUnlocalizedName("itemMobHeadsFour").setCreativeTab(tabJammyFurniture);
			itemArmChair = (new JFItemArmChair(Integer.parseInt(ARM_CHAIR_ID.getString()) - 256, blockArmChair)).setUnlocalizedName("itemArmChair").setCreativeTab(tabJammyFurniture);
			
			
			itemSofaPartLeft = (new jfm_ItemSofaLeft(Integer.parseInt(SOFA_LEFT_ID.getString()) - 256, blockSofaPartLeft)).setUnlocalizedName("itemSofaLeft").setCreativeTab(tabJammyFurniture);
			itemSofaPartRight = (new jfm_ItemSofaRight(Integer.parseInt(SOFA_RIGHT_ID.getString()) - 256, blockSofaPartRight)).setUnlocalizedName("itemSofaRight").setCreativeTab(tabJammyFurniture);
			itemSofaPartCenter = (new jfm_ItemSofaCenter(Integer.parseInt(SOFA_CENTER_ID.getString()) - 256, blockSofaPartCenter)).setUnlocalizedName("itemSofaCenter").setCreativeTab(tabJammyFurniture);
			itemSofaPartCorner = (new jfm_ItemSofaCorner(Integer.parseInt(SOFA_CORNER_ID.getString()) - 256, blockSofaPartCorner)).setUnlocalizedName("itemSofaCorner").setCreativeTab(tabJammyFurniture);
			itemMiscBlocksOne = (new jfm_ItemMiscOne(Integer.parseInt(MISC_ONE_ID.getString()) - 256, blockMiscBlocksOne)).setUnlocalizedName("itemMiscOne").setCreativeTab(tabJammyFurniture);
			itemLightsOn = (new jfm_ItemLightsOn(Integer.parseInt(LIGHTS_ON_ID.getString()) - 256, blockLightsOn)).setUnlocalizedName("itemLightsOn").setCreativeTab(tabJammyFurniture);
			itemLightsOn = (new jfm_ItemLightsOn(Integer.parseInt(LIGHTS_OFF_ID.getString()) - 256, blockLightsOff)).setUnlocalizedName("itemLightsOff");
			
			
		} finally {
			configOld.save();
		}
		*/
	}
	
	/**
	 * Initialisation des sons
	 */
	public void initSounds () {

		SoundRegistry.register("washingmachine");
		SoundRegistry.register("radio");
		SoundRegistry.register("toilet");
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		// Execution du renderer en fonction du serveur ou du client
		proxy.registerRenderers();
		
		// Initialisation des sons
		this.initSounds ();
		
		// Initialisation les TileEntities
		this.initTileEntities ();
		
		
		
		
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.JammyFurniture", "en_US", "Jammy Furniture Mod"); // TODO a virer
		
//		this.loadNames();
		
		EntityRegistry.registerModEntity(EntityMountableBlock.class, "EntityMountableBlock", 1, this, 400, 5, false);
		NetworkRegistry.instance().registerGuiHandler(instance, new JFGuiHandler());
		
		
//		jfm_Recipes.initRecipes();
	}
	
	/**
	 * Initialisation des blocks
	 */
	public void initBlocks () {
		
		blockWoodBlocksOne   = new JFWoodBlocksOne  (this.config.blockWoodBlocksOneID  , 0, TileEntityWoodBlocksOne.class)  .setHardness(2.0F).setResistance(1.0F).setUnlocalizedName("woodBlocks")     .setStepSound(Block.soundWoodFootstep).setCreativeTab(tabJammyFurniture);
		blockWoodBlocksTwo   = new JFWoodBlocksTwo  (this.config.blockWoodBlocksTwoID  , 0, TileEntityWoodBlocksTwo.class)  .setHardness(2.0F).setResistance(1.0F).setUnlocalizedName("woodBlocksTwo")  .setStepSound(Block.soundWoodFootstep).setCreativeTab(tabJammyFurniture);
		blockWoodBlocksThree = new JFWoodBlocksThree(this.config.blockWoodBlocksThreeID, 0, TileEntityWoodBlocksThree.class).setHardness(2.0F).setResistance(1.0F).setUnlocalizedName("woodBlocksThree").setStepSound(Block.soundWoodFootstep).setCreativeTab(tabJammyFurniture);
		blockBathTub         = new JFBathBlock      (this.config.blockBathTubID        , 0, TileEntityBath.class)           .setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("bathBlock")                                            .setCreativeTab(tabJammyFurniture);
		blockIronBlocksOne   = new JFIronBlocksOne  (this.config.blockIronBlocksOneID  , 0, TileEntityIronBlocksOne.class)  .setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ironBlockOne")                                         .setCreativeTab(tabJammyFurniture);
		blockIronBlocksTwo   = new JFIronBlocksTwo  (this.config.blockIronBlocksTwoID  , 0, TileEntityIronBlocksTwo.class)  .setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ironBlocksTwo")                                        .setCreativeTab(tabJammyFurniture);
		
	}

	/**
	 * Initialisation des items
	 */
	public void initItems () {
		itemLightBulb       = new HItem(this.config.itemLightBulbID      ,"ItemLightBulb"      ).setCreativeTab(tabJammyFurniture);
		itemMantlePieceUnf  = new HItem(this.config.itemMantlePieceUnfID ,"ItemMantlePieceUnf" ).setCreativeTab(tabJammyFurniture);
		itemCeramicPanelUnf = new HItem(this.config.itemCeramicPanelUnfID,"ItemCeramicPanelUnf").setCreativeTab(tabJammyFurniture);
		itemCeramicPanel    = new HItem(this.config.itemCeramicPanelID   ,"ItemCeramicPanel"   ).setCreativeTab(tabJammyFurniture);
		itemWMDrum          = new HItem(this.config.itemWMDrumID         ,"ItemWMDrum"         ).setCreativeTab(tabJammyFurniture);
		itemBlindPart       = new HItem(this.config.itemBlindPartID      ,"ItemBlindPart"      ).setCreativeTab(tabJammyFurniture);
		
		itemWoodBlocksOne   = new JFItemWoodBlocksOne  (blockWoodBlocksOne  ).setUnlocalizedName("itemClockBase")      .setCreativeTab(tabJammyFurniture);
		itemWoodBlocksTwo   = new JFItemWoodBlocksTwo  (blockWoodBlocksTwo  ).setUnlocalizedName("itemWoodBlocksTwo")  .setCreativeTab(tabJammyFurniture);
		itemWoodBlocksThree = new JFItemWoodBlocksThree(blockWoodBlocksThree).setUnlocalizedName("itemWoodBlocksThree").setCreativeTab(tabJammyFurniture);
		itemBathTub         = new JFItemBath           (blockBathTub        ).setUnlocalizedName("itemBath")           .setCreativeTab(tabJammyFurniture);
		itemIronBlocksOne   = new JFItemIronBlocksOne  (blockIronBlocksOne  ).setUnlocalizedName("itemIronBlocksOne")  .setCreativeTab(tabJammyFurniture);
		itemIronBlocksTwo   = new JFItemIronBlocksTwo  (blockIronBlocksTwo  ).setUnlocalizedName("itemIronBlocksTwo")  .setCreativeTab(tabJammyFurniture);

	}
	
	/**
	 * // Nom des TileEntities
	 */
	private void initTileEntities () {
		
		GameRegistry.registerTileEntity(TileEntityWoodBlocksOne.class   , "TileEntityWoodBlocks");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksTwo.class   , "TileEntityWoodBlocksTwo");
		GameRegistry.registerTileEntity(TileEntityWoodBlocksThree.class , "TileEntityWoodBlocksThree");
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
		GameRegistry.registerTileEntity(TileEntityMiscOne.class         , "TileEntityMiscOne");
		GameRegistry.registerTileEntity(TileEntityLightsOn.class        , "TileEntityLightsOn");
		
	}

	public void loadNames() {
		LanguageRegistry.addName(itemLightBulb, "Light Bulb");
		LanguageRegistry.addName(itemMantlePieceUnf, "Mantle Piece (Unf)");
		LanguageRegistry.addName(itemCeramicPanelUnf, "Ceramic Panel (Unf)");
		LanguageRegistry.addName(itemCeramicPanel, "Ceramic Panel");
		LanguageRegistry.addName(itemWMDrum, "Washing Machine Drum");
		LanguageRegistry.addName(itemBlindPart, "Blind Part");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 0), "Clock Base");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 1), "Clock Middle");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 5), "Clock Top");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 9), "Blinds");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 13), "Crafting Side");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 14), "Kitchen Side");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksOne, 1, 15), "Table");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 0), "Kitchen Cupboard");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 4), "Kitchen Cupboard (Shelf)");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 8), "Television");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 12), "Basket");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 13), "Basket");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 14), "Basket");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksTwo, 1, 15), "Basket");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksThree, 1, 0), "Chair");
		LanguageRegistry.addName(new ItemStack(blockWoodBlocksThree, 1, 4), "Radio");
		LanguageRegistry.addName(itemBathTub, "Bath");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksOne, 1, 0), "Fridge");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksOne, 1, 4), "Freezer");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksOne, 1, 8), "Cooker");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksOne, 1, 12), "Rubbish Bin");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksOne, 1, 13), "Coffee Table");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksTwo, 1, 0), "Dishwasher");
		LanguageRegistry.addName(new ItemStack(blockIronBlocksTwo, 1, 4), "Washing Machine");
		LanguageRegistry.addName(new ItemStack(blockCeramicBlocksOne, 1, 0), "Bathroom Cupboard");
		LanguageRegistry.addName(new ItemStack(blockCeramicBlocksOne, 1, 4), "Bathroom Sink");
		LanguageRegistry.addName(new ItemStack(blockCeramicBlocksOne, 1, 8), "Kitchen Sink");
		LanguageRegistry.addName(new ItemStack(blockCeramicBlocksOne, 1, 12), "Toilet");
		LanguageRegistry.addName(new ItemStack(blockRoofingBlocksOne, 1, 0), "Roofing");
		LanguageRegistry.addName(new ItemStack(blockRoofingBlocksOne, 1, 4), "Roofing");
		LanguageRegistry.addName(new ItemStack(blockRoofingBlocksOne, 1, 8), "Roofing");
		LanguageRegistry.addName(new ItemStack(blockRoofingBlocksOne, 1, 12), "Roofing");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsOne, 1, 0), "Chicken Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsOne, 1, 4), "Cow Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsOne, 1, 8), "Creeper Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsOne, 1, 12), "Enderdragon Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsTwo, 1, 0), "Pig Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsTwo, 1, 4), "Sheep Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsTwo, 1, 8), "Skeleton Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsTwo, 1, 12), "Spider Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsThree, 1, 0), "Steve Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsThree, 1, 4), "Wolf Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsThree, 1, 8), "Zombie Head");
		LanguageRegistry.addName(new ItemStack(blockMobHeadsThree, 1, 12), "Squid Head");
		LanguageRegistry.addName(new ItemStack(blcokMobHeadsFour, 1, 0), "Enderman Head");
		LanguageRegistry.addName(new ItemStack(blcokMobHeadsFour, 1, 4), "Slime Head");
		LanguageRegistry.addName(new ItemStack(blcokMobHeadsFour, 1, 8), "Blaze Head");
		LanguageRegistry.addName(new ItemStack(blcokMobHeadsFour, 1, 12), "Zombie Pig Head");
		LanguageRegistry.addName(new ItemStack(blockArmChair, 1, 0), "Arm Chair");
		LanguageRegistry.addName(new ItemStack(blockArmChair, 1, 4), "Arm Chair");
		LanguageRegistry.addName(new ItemStack(blockArmChair, 1, 8), "Arm Chair");
		LanguageRegistry.addName(new ItemStack(blockArmChair, 1, 12), "Arm Chair");
		LanguageRegistry.addName(new ItemStack(blockSofaPartLeft, 1, 0), "Sofa Part (Left)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartLeft, 1, 4), "Sofa Part (Left)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartLeft, 1, 8), "Sofa Part (Left)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartLeft, 1, 12), "Sofa Part (Left)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartRight, 1, 0), "Sofa Part (Right)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartRight, 1, 4), "Sofa Part (Right)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartRight, 1, 8), "Sofa Part (Right)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartRight, 1, 12), "Sofa Part (Right)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCenter, 1, 0), "Sofa Part (Center)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCenter, 1, 4), "Sofa Part (Center)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCenter, 1, 8), "Sofa Part (Center)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCenter, 1, 12), "Sofa Part (Center)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCorner, 1, 0), "Sofa Part (Corner)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCorner, 1, 4), "Sofa Part (Corner)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCorner, 1, 8), "Sofa Part (Corner)");
		LanguageRegistry.addName(new ItemStack(blockSofaPartCorner, 1, 12), "Sofa Part (Corner)");
		LanguageRegistry.addName(new ItemStack(blockMiscBlocksOne, 1, 0), "Chimney");
		LanguageRegistry.addName(new ItemStack(blockMiscBlocksOne, 1, 4), "Mantle Piece");
		LanguageRegistry.addName(new ItemStack(blockMiscBlocksOne, 1, 8), "Christmas Tree");
		LanguageRegistry.addName(new ItemStack(blockLightsOn, 1, 0), "Light");
		LanguageRegistry.addName(new ItemStack(blockLightsOn, 1, 4), "Outdoor Lamp");
		LanguageRegistry.addName(new ItemStack(blockLightsOn, 1, 8), "Table Lamp");
	}
}
