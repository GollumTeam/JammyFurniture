package net.minecraft.jammy780.furniture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.jammy780.furniture.blocks.jfm_BathBlock;
import net.minecraft.jammy780.furniture.blocks.jfm_BlockLightsOn;
import net.minecraft.jammy780.furniture.blocks.jfm_BlockMiscOne;
import net.minecraft.jammy780.furniture.blocks.ceramic.jfm_CeramicBlocksOne;
import net.minecraft.jammy780.furniture.blocks.heads.jfm_MobHeadsFour;
import net.minecraft.jammy780.furniture.blocks.heads.jfm_MobHeadsOne;
import net.minecraft.jammy780.furniture.blocks.heads.jfm_MobHeadsThree;
import net.minecraft.jammy780.furniture.blocks.heads.jfm_MobHeadsTwo;
import net.minecraft.jammy780.furniture.blocks.iron.jfm_IronBlocksOne;
import net.minecraft.jammy780.furniture.blocks.iron.jfm_IronBlocksTwo;
import net.minecraft.jammy780.furniture.blocks.roofing.jfm_RoofingBlocksOne;
import net.minecraft.jammy780.furniture.blocks.sofa.jfm_BlockArmChair;
import net.minecraft.jammy780.furniture.blocks.sofa.jfm_BlockSofaCenter;
import net.minecraft.jammy780.furniture.blocks.sofa.jfm_BlockSofaCorner;
import net.minecraft.jammy780.furniture.blocks.sofa.jfm_BlockSofaLeft;
import net.minecraft.jammy780.furniture.blocks.sofa.jfm_BlockSofaRight;
import net.minecraft.jammy780.furniture.blocks.wood.jfm_WoodBlocksOne;
import net.minecraft.jammy780.furniture.blocks.wood.jfm_WoodBlocksThree;
import net.minecraft.jammy780.furniture.blocks.wood.jfm_WoodBlocksTwo;
import net.minecraft.jammy780.furniture.item.jfm_ItemArmChair;
import net.minecraft.jammy780.furniture.item.jfm_ItemBath;
import net.minecraft.jammy780.furniture.item.jfm_ItemCeramicBlocksOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemIronBlocksOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemIronBlocksTwo;
import net.minecraft.jammy780.furniture.item.jfm_ItemLightsOn;
import net.minecraft.jammy780.furniture.item.jfm_ItemMiscOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemMobHeadsFour;
import net.minecraft.jammy780.furniture.item.jfm_ItemMobHeadsOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemMobHeadsThree;
import net.minecraft.jammy780.furniture.item.jfm_ItemMobHeadsTwo;
import net.minecraft.jammy780.furniture.item.jfm_ItemRoofingBlocksOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemSofaCenter;
import net.minecraft.jammy780.furniture.item.jfm_ItemSofaCorner;
import net.minecraft.jammy780.furniture.item.jfm_ItemSofaLeft;
import net.minecraft.jammy780.furniture.item.jfm_ItemSofaRight;
import net.minecraft.jammy780.furniture.item.jfm_ItemWoodBlocksOne;
import net.minecraft.jammy780.furniture.item.jfm_ItemWoodBlocksThree;
import net.minecraft.jammy780.furniture.item.jfm_ItemWoodBlocksTwo;
import net.minecraft.jammy780.furniture.item.jfm_Items;
import net.minecraft.jammy780.furniture.recipes.jfm_Recipes;
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
import net.minecraft.jammy780.furniture.util.EntityMountableBlock;
import net.minecraft.jammy780.furniture.util.jfm_Config;
import net.minecraft.jammy780.furniture.util.jfm_ConfigDefault;
import net.minecraft.jammy780.furniture.util.jfm_GuiHandler;
import net.minecraftforge.common.Property;

@Mod(
    modid = "jammyfurniture",
    name = "Jammy Furniture Mod",
    version = "4.5"
)
@NetworkMod(
    clientSideRequired = true,
    serverSideRequired = false
)
public class JammyFurnitureModCore
{
    @Instance("jammyfurniture")
    public static JammyFurnitureModCore instance;
    @SidedProxy(
        clientSide = "net.minecraft.client.jammy780.furniture.jfm_ClientProxy",
        serverSide = "net.minecraft.jammy780.furniture.jfm_CommonProxy"
    )
    public static jfm_CommonProxy proxy;
    public static jfm_Config config;
    public static jfm_ConfigDefault defaultConfig;
    public static CreativeTabs jfmCustomTab = new jfm_CreativeTabs("jfmCustomTab");
    public static Block woodBlocksOne;
    public static Block woodBlocksTwo;
    public static Block woodBlocksThree;
    public static Block bathTub;
    public static Block ironBlocksOne;
    public static Block ironBlocksTwo;
    public static Block ceramicBlocksOne;
    public static Block roofingBlocksOne;
    public static Block mobHeadsOne;
    public static Block mobHeadsTwo;
    public static Block mobHeadsThree;
    public static Block mobHeadsFour;
    public static Block armChair;
    public static Block sofaPartLeft;
    public static Block sofaPartRight;
    public static Block sofaPartCenter;
    public static Block sofaPartCorner;
    public static Block miscBlocksOne;
    public static Block lightsOn;
    public static Block lightsOff;
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

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInitLoading();
    }

    @EventHandler
    public void loadConfig(FMLPreInitializationEvent evt)
    {
        config = new jfm_Config(new File(evt.getModConfigurationDirectory(), "JammyFurnitureMod.conf"));

        try
        {
            config.load();
            Property LIGHT_BULB_ID = config.getItem("light_bulb.id", "item", jfm_ConfigDefault.ITEM_LIGHT_BULB_ID);
            itemLightBulb = (new jfm_Items(Integer.parseInt(LIGHT_BULB_ID.getString()))).setUnlocalizedName("itemLightBulb").setCreativeTab(jfmCustomTab);
            Property UNFMANTLE_ID = config.getItem("mantle_piece_unf.id", "item", jfm_ConfigDefault.ITEM_UNFMANTLE_ID);
            itemMantlePieceUnf = (new jfm_Items(Integer.parseInt(UNFMANTLE_ID.getString()))).setUnlocalizedName("mantlePieceUnf").setCreativeTab(jfmCustomTab);
            Property CERAMICUNF_ID = config.getItem("ceramic_panel_unf.id", "item", jfm_ConfigDefault.ITEM_CERAMIC_UNF_ID);
            itemCeramicPanelUnf = (new jfm_Items(Integer.parseInt(CERAMICUNF_ID.getString()))).setUnlocalizedName("ceramicPanelUnf").setCreativeTab(jfmCustomTab);
            Property CERAMIC_ID = config.getItem("ceramic_panel.id", "item", jfm_ConfigDefault.ITEM_CERAMIC_ID);
            itemCeramicPanel = (new jfm_Items(Integer.parseInt(CERAMIC_ID.getString()))).setUnlocalizedName("itemCeramicPanel").setCreativeTab(jfmCustomTab);
            Property WMDRUM_ID = config.getItem("wm_drum.id", "item", jfm_ConfigDefault.ITEM_WMDRUM_ID);
            itemWMDrum = (new jfm_Items(Integer.parseInt(WMDRUM_ID.getString()))).setUnlocalizedName("itemWMDrum").setCreativeTab(jfmCustomTab);
            Property BLIND_PART_ID = config.getItem("blind_part.id", "item", jfm_ConfigDefault.ITEM_BLIND_PART_ID);
            itemBlindPart = (new jfm_Items(Integer.parseInt(BLIND_PART_ID.getString()))).setUnlocalizedName("itemBlindPart").setCreativeTab(jfmCustomTab);
            
            
            
            Property WOOD_ONE_ID = config.getBlock("wood_one.id", "block", jfm_ConfigDefault.WOOD_ONE_ID);
            woodBlocksOne = (new jfm_WoodBlocksOne(Integer.parseInt(WOOD_ONE_ID.getString()), 0, jfm_TileEntityWoodBlocks.class)).setHardness(2.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodBlocks").setCreativeTab(jfmCustomTab);
            itemWoodBlocksOne = (new jfm_ItemWoodBlocksOne(Integer.parseInt(WOOD_ONE_ID.getString()) - 256, woodBlocksOne)).setUnlocalizedName("itemClockBase").setCreativeTab(jfmCustomTab);
            
            Property WOOD_TWO_ID = config.getBlock("wood_two.id", "block", jfm_ConfigDefault.WOOD_TWO_ID);
            woodBlocksTwo = (new jfm_WoodBlocksTwo(Integer.parseInt(WOOD_TWO_ID.getString()), 0, jfm_TileEntityWoodBlocksTwo.class)).setHardness(2.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodBlocksTwo").setCreativeTab(jfmCustomTab);
            itemWoodBlocksTwo = (new jfm_ItemWoodBlocksTwo(Integer.parseInt(WOOD_TWO_ID.getString()) - 256, woodBlocksTwo)).setUnlocalizedName("itemWoodBlocksTwo").setCreativeTab(jfmCustomTab);
            
            Property WOOD_THREE_ID = config.getBlock("wood_three.id", "block", jfm_ConfigDefault.WOOD_THREE_ID);
            woodBlocksThree = (new jfm_WoodBlocksThree(Integer.parseInt(WOOD_THREE_ID.getString()), 0, jfm_TileEntityWoodBlocksThree.class)).setHardness(2.0F).setResistance(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodBlocksThree").setCreativeTab(jfmCustomTab);
            itemWoodBlocksThree = (new jfm_ItemWoodBlocksThree(Integer.parseInt(WOOD_THREE_ID.getString()) - 256, woodBlocksThree)).setUnlocalizedName("itemWoodBlocksThree").setCreativeTab(jfmCustomTab);
            
            Property BATH_BLOCK_ID = config.getBlock("bath.id", "block", jfm_ConfigDefault.BATH_ID);
            bathTub = (new jfm_BathBlock(Integer.parseInt(BATH_BLOCK_ID.getString()), 0, jfm_TileEntityBath.class)).setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("bathBlock").setCreativeTab(jfmCustomTab);
            itemBathTub = (new jfm_ItemBath(Integer.parseInt(BATH_BLOCK_ID.getString()) - 256, bathTub)).setUnlocalizedName("itemBath").setCreativeTab(jfmCustomTab);
            
            
            Property IRON_ONE_ID = config.getBlock("iron_one.id", "block", jfm_ConfigDefault.IRON_ONE_ID);
            ironBlocksOne = (new jfm_IronBlocksOne(Integer.parseInt(IRON_ONE_ID.getString()), 0, jfm_TileEntityIronBlocksOne.class)).setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ironBlockOne").setCreativeTab(jfmCustomTab);
            itemIronBlocksOne = (new jfm_ItemIronBlocksOne(Integer.parseInt(IRON_ONE_ID.getString()) - 256, ironBlocksOne)).setUnlocalizedName("itemIronBlocksOne").setCreativeTab(jfmCustomTab);
            
            Property IRON_TWO_ID = config.getBlock("iron_two.id", "block", jfm_ConfigDefault.IRON_TWO_ID);
            ironBlocksTwo = (new jfm_IronBlocksTwo(Integer.parseInt(IRON_TWO_ID.getString()), 0, jfm_TileEntityIronBlocksTwo.class)).setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ironBlocksTwo").setCreativeTab(jfmCustomTab);
            itemIronBlocksTwo = (new jfm_ItemIronBlocksTwo(Integer.parseInt(IRON_TWO_ID.getString()) - 256, ironBlocksTwo)).setUnlocalizedName("itemIronBlocksTwo").setCreativeTab(jfmCustomTab);
            
            
            Property CERAMIC_ONE_ID = config.getBlock("ceramic_one.id", "block", jfm_ConfigDefault.CERAMIC_ONE_ID);
            ceramicBlocksOne = (new jfm_CeramicBlocksOne(Integer.parseInt(CERAMIC_ONE_ID.getString()), 0, jfm_TileEntityCeramicBlocksOne.class)).setHardness(3.0F).setResistance(1.0F).setUnlocalizedName("ceramicBlockOne").setCreativeTab(jfmCustomTab);
            itemCeramicBlocksOne = (new jfm_ItemCeramicBlocksOne(Integer.parseInt(CERAMIC_ONE_ID.getString()) - 256, ceramicBlocksOne)).setUnlocalizedName("itemCeramicBlocksOne").setCreativeTab(jfmCustomTab);
            Property ROOFING_ONE_ID = config.getBlock("roofing_one.id", "block", jfm_ConfigDefault.ROOFING_ONE_ID);
            roofingBlocksOne = (new jfm_RoofingBlocksOne(Integer.parseInt(ROOFING_ONE_ID.getString()), 0, jfm_TileEntityRoofingBlocksOne.class)).setHardness(1.2F).setUnlocalizedName("roofingBlocksOne").setCreativeTab(jfmCustomTab);
            itemRoofingBlocksOne = (new jfm_ItemRoofingBlocksOne(Integer.parseInt(ROOFING_ONE_ID.getString()) - 256, roofingBlocksOne)).setUnlocalizedName("itemRoofingBlocksOne").setCreativeTab(jfmCustomTab);
            Property MOB_HEADS_ONE = config.getBlock("mob_heads_one.id", "block", jfm_ConfigDefault.MOB_HEADS_ONE);
            mobHeadsOne = (new jfm_MobHeadsOne(Integer.parseInt(MOB_HEADS_ONE.getString()), 0, jfm_TileEntityMobHeadsOne.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsOne").setCreativeTab(jfmCustomTab);
            itemMobHeadsOne = (new jfm_ItemMobHeadsOne(Integer.parseInt(MOB_HEADS_ONE.getString()) - 256, mobHeadsOne)).setUnlocalizedName("itemMobHeadsOne").setCreativeTab(jfmCustomTab);
            Property MOB_HEADS_TWO = config.getBlock("mob_heads_two.id", "block", jfm_ConfigDefault.MOB_HEADS_TWO);
            mobHeadsTwo = (new jfm_MobHeadsTwo(Integer.parseInt(MOB_HEADS_TWO.getString()), 0, jfm_TileEntityMobHeadsTwo.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsTwo").setCreativeTab(jfmCustomTab);
            itemMobHeadsTwo = (new jfm_ItemMobHeadsTwo(Integer.parseInt(MOB_HEADS_TWO.getString()) - 256, mobHeadsTwo)).setUnlocalizedName("itemMobHeadsTwo").setCreativeTab(jfmCustomTab);
            Property MOB_HEADS_THREE = config.getBlock("mob_heads_three.id", "block", jfm_ConfigDefault.MOB_HEADS_THREE);
            mobHeadsThree = (new jfm_MobHeadsThree(Integer.parseInt(MOB_HEADS_THREE.getString()), 0, jfm_TileEntityMobHeadsThree.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsThree").setCreativeTab(jfmCustomTab);
            itemMobHeadsThree = (new jfm_ItemMobHeadsThree(Integer.parseInt(MOB_HEADS_THREE.getString()) - 256, mobHeadsThree)).setUnlocalizedName("itemMobHeadsThree").setCreativeTab(jfmCustomTab);
            Property MOB_HEADS_FOUR = config.getBlock("mob_heads_four.id", "block", jfm_ConfigDefault.MOB_HEADS_FOUR);
            mobHeadsFour = (new jfm_MobHeadsFour(Integer.parseInt(MOB_HEADS_FOUR.getString()), 0, jfm_TileEntityMobHeadsFour.class)).setHardness(0.8F).setUnlocalizedName("MobHeadsFour").setCreativeTab(jfmCustomTab);
            itemMobHeadsFour = (new jfm_ItemMobHeadsFour(Integer.parseInt(MOB_HEADS_FOUR.getString()) - 256, mobHeadsFour)).setUnlocalizedName("itemMobHeadsFour").setCreativeTab(jfmCustomTab);
            Property ARM_CHAIR_ID = config.getBlock("arm_chair.id", "block", jfm_ConfigDefault.ARM_CHAIR_ID);
            armChair = (new jfm_BlockArmChair(Integer.parseInt(ARM_CHAIR_ID.getString()), 0, jfm_TileEntityArmChair.class)).setHardness(1.2F).setUnlocalizedName("armChair").setCreativeTab(jfmCustomTab);
            itemArmChair = (new jfm_ItemArmChair(Integer.parseInt(ARM_CHAIR_ID.getString()) - 256, armChair)).setUnlocalizedName("itemArmChair").setCreativeTab(jfmCustomTab);
            Property SOFA_LEFT_ID = config.getBlock("sofa_left.id", "block", jfm_ConfigDefault.SOFA_LEFT_ID);
            sofaPartLeft = (new jfm_BlockSofaLeft(Integer.parseInt(SOFA_LEFT_ID.getString()), 0, jfm_TileEntitySofaLeft.class)).setHardness(1.2F).setUnlocalizedName("sofaLeft").setCreativeTab(jfmCustomTab);
            itemSofaPartLeft = (new jfm_ItemSofaLeft(Integer.parseInt(SOFA_LEFT_ID.getString()) - 256, sofaPartLeft)).setUnlocalizedName("itemSofaLeft").setCreativeTab(jfmCustomTab);
            Property SOFA_RIGHT_ID = config.getBlock("sofa_right.id", "block", jfm_ConfigDefault.SOFA_RIGHT_ID);
            sofaPartRight = (new jfm_BlockSofaRight(Integer.parseInt(SOFA_RIGHT_ID.getString()), 0, jfm_TileEntitySofaRight.class)).setHardness(1.2F).setUnlocalizedName("sofaRight").setCreativeTab(jfmCustomTab);
            itemSofaPartRight = (new jfm_ItemSofaRight(Integer.parseInt(SOFA_RIGHT_ID.getString()) - 256, sofaPartRight)).setUnlocalizedName("itemSofaRight").setCreativeTab(jfmCustomTab);
            Property SOFA_CENTER_ID = config.getBlock("sofa_center.id", "block", jfm_ConfigDefault.SOFA_CENTER_ID);
            sofaPartCenter = (new jfm_BlockSofaCenter(Integer.parseInt(SOFA_CENTER_ID.getString()), 0, jfm_TileEntitySofaCenter.class)).setHardness(1.2F).setUnlocalizedName("sofaCenter").setCreativeTab(jfmCustomTab);
            itemSofaPartCenter = (new jfm_ItemSofaCenter(Integer.parseInt(SOFA_CENTER_ID.getString()) - 256, sofaPartCenter)).setUnlocalizedName("itemSofaCenter").setCreativeTab(jfmCustomTab);
            Property SOFA_CORNER_ID = config.getBlock("sofa_corner.id", "block", jfm_ConfigDefault.SOFA_CORNER_ID);
            sofaPartCorner = (new jfm_BlockSofaCorner(Integer.parseInt(SOFA_CORNER_ID.getString()), 0, jfm_TileEntitySofaCorner.class)).setHardness(1.2F).setUnlocalizedName("sofaCorner").setCreativeTab(jfmCustomTab);
            itemSofaPartCorner = (new jfm_ItemSofaCorner(Integer.parseInt(SOFA_CORNER_ID.getString()) - 256, sofaPartCorner)).setUnlocalizedName("itemSofaCorner").setCreativeTab(jfmCustomTab);
            Property MISC_ONE_ID = config.getBlock("misc_one.id", "block", jfm_ConfigDefault.MISC_ONE_ID);
            miscBlocksOne = (new jfm_BlockMiscOne(Integer.parseInt(MISC_ONE_ID.getString()), 0, jfm_TileEntityMiscOne.class)).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("miscOne").setCreativeTab(jfmCustomTab);
            itemMiscBlocksOne = (new jfm_ItemMiscOne(Integer.parseInt(MISC_ONE_ID.getString()) - 256, miscBlocksOne)).setUnlocalizedName("itemMiscOne").setCreativeTab(jfmCustomTab);
            Property LIGHTS_ON_ID = config.getBlock("lights_on.id", "block", jfm_ConfigDefault.LIGHTS_ON_ID);
            lightsOn = (new jfm_BlockLightsOn(Integer.parseInt(LIGHTS_ON_ID.getString()), 0, jfm_TileEntityLightsOn.class, true)).setHardness(0.3F).setUnlocalizedName("lightsOn").setCreativeTab(jfmCustomTab);
            itemLightsOn = (new jfm_ItemLightsOn(Integer.parseInt(LIGHTS_ON_ID.getString()) - 256, lightsOn)).setUnlocalizedName("itemLightsOn").setCreativeTab(jfmCustomTab);
            Property LIGHTS_OFF_ID = config.getBlock("lights_off.id", "block", jfm_ConfigDefault.LIGHTS_OFF_ID);
            lightsOff = (new jfm_BlockLightsOn(Integer.parseInt(LIGHTS_OFF_ID.getString()), 0, jfm_TileEntityLightsOn.class, false)).setHardness(0.3F).setUnlocalizedName("lightsOff");
            itemLightsOn = (new jfm_ItemLightsOn(Integer.parseInt(LIGHTS_OFF_ID.getString()) - 256, lightsOff)).setUnlocalizedName("itemLightsOff");
        }
        finally
        {
            config.save();
        }
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        LanguageRegistry.instance().addStringLocalization("itemGroup.jfmCustomTab", "en_US", "Jammy Furniture Mod");
        proxy.registerTileEntities();
        proxy.initRendering();
        this.loadNames();
        EntityRegistry.registerModEntity(EntityMountableBlock.class, "EntityMountableBlock", 1, this, 400, 5, false);
        NetworkRegistry.instance().registerGuiHandler(instance, new jfm_GuiHandler());
        jfm_Recipes.initRecipes();
    }

    public void loadNames()
    {
        LanguageRegistry.addName(itemLightBulb, "Light Bulb");
        LanguageRegistry.addName(itemMantlePieceUnf, "Mantle Piece (Unf)");
        LanguageRegistry.addName(itemCeramicPanelUnf, "Ceramic Panel (Unf)");
        LanguageRegistry.addName(itemCeramicPanel, "Ceramic Panel");
        LanguageRegistry.addName(itemWMDrum, "Washing Machine Drum");
        LanguageRegistry.addName(itemBlindPart, "Blind Part");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 0), "Clock Base");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 1), "Clock Middle");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 5), "Clock Top");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 9), "Blinds");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 13), "Crafting Side");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 14), "Kitchen Side");
        LanguageRegistry.addName(new ItemStack(woodBlocksOne, 1, 15), "Table");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 0), "Kitchen Cupboard");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 4), "Kitchen Cupboard (Shelf)");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 8), "Television");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 12), "Basket");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 13), "Basket");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 14), "Basket");
        LanguageRegistry.addName(new ItemStack(woodBlocksTwo, 1, 15), "Basket");
        LanguageRegistry.addName(new ItemStack(woodBlocksThree, 1, 0), "Chair");
        LanguageRegistry.addName(new ItemStack(woodBlocksThree, 1, 4), "Radio");
        LanguageRegistry.addName(itemBathTub, "Bath");
        LanguageRegistry.addName(new ItemStack(ironBlocksOne, 1, 0), "Fridge");
        LanguageRegistry.addName(new ItemStack(ironBlocksOne, 1, 4), "Freezer");
        LanguageRegistry.addName(new ItemStack(ironBlocksOne, 1, 8), "Cooker");
        LanguageRegistry.addName(new ItemStack(ironBlocksOne, 1, 12), "Rubbish Bin");
        LanguageRegistry.addName(new ItemStack(ironBlocksOne, 1, 13), "Coffee Table");
        LanguageRegistry.addName(new ItemStack(ironBlocksTwo, 1, 0), "Dishwasher");
        LanguageRegistry.addName(new ItemStack(ironBlocksTwo, 1, 4), "Washing Machine");
        LanguageRegistry.addName(new ItemStack(ceramicBlocksOne, 1, 0), "Bathroom Cupboard");
        LanguageRegistry.addName(new ItemStack(ceramicBlocksOne, 1, 4), "Bathroom Sink");
        LanguageRegistry.addName(new ItemStack(ceramicBlocksOne, 1, 8), "Kitchen Sink");
        LanguageRegistry.addName(new ItemStack(ceramicBlocksOne, 1, 12), "Toilet");
        LanguageRegistry.addName(new ItemStack(roofingBlocksOne, 1, 0), "Roofing");
        LanguageRegistry.addName(new ItemStack(roofingBlocksOne, 1, 4), "Roofing");
        LanguageRegistry.addName(new ItemStack(roofingBlocksOne, 1, 8), "Roofing");
        LanguageRegistry.addName(new ItemStack(roofingBlocksOne, 1, 12), "Roofing");
        LanguageRegistry.addName(new ItemStack(mobHeadsOne, 1, 0), "Chicken Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsOne, 1, 4), "Cow Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsOne, 1, 8), "Creeper Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsOne, 1, 12), "Enderdragon Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsTwo, 1, 0), "Pig Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsTwo, 1, 4), "Sheep Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsTwo, 1, 8), "Skeleton Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsTwo, 1, 12), "Spider Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsThree, 1, 0), "Steve Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsThree, 1, 4), "Wolf Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsThree, 1, 8), "Zombie Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsThree, 1, 12), "Squid Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsFour, 1, 0), "Enderman Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsFour, 1, 4), "Slime Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsFour, 1, 8), "Blaze Head");
        LanguageRegistry.addName(new ItemStack(mobHeadsFour, 1, 12), "Zombie Pig Head");
        LanguageRegistry.addName(new ItemStack(armChair, 1, 0), "Arm Chair");
        LanguageRegistry.addName(new ItemStack(armChair, 1, 4), "Arm Chair");
        LanguageRegistry.addName(new ItemStack(armChair, 1, 8), "Arm Chair");
        LanguageRegistry.addName(new ItemStack(armChair, 1, 12), "Arm Chair");
        LanguageRegistry.addName(new ItemStack(sofaPartLeft, 1, 0), "Sofa Part (Left)");
        LanguageRegistry.addName(new ItemStack(sofaPartLeft, 1, 4), "Sofa Part (Left)");
        LanguageRegistry.addName(new ItemStack(sofaPartLeft, 1, 8), "Sofa Part (Left)");
        LanguageRegistry.addName(new ItemStack(sofaPartLeft, 1, 12), "Sofa Part (Left)");
        LanguageRegistry.addName(new ItemStack(sofaPartRight, 1, 0), "Sofa Part (Right)");
        LanguageRegistry.addName(new ItemStack(sofaPartRight, 1, 4), "Sofa Part (Right)");
        LanguageRegistry.addName(new ItemStack(sofaPartRight, 1, 8), "Sofa Part (Right)");
        LanguageRegistry.addName(new ItemStack(sofaPartRight, 1, 12), "Sofa Part (Right)");
        LanguageRegistry.addName(new ItemStack(sofaPartCenter, 1, 0), "Sofa Part (Center)");
        LanguageRegistry.addName(new ItemStack(sofaPartCenter, 1, 4), "Sofa Part (Center)");
        LanguageRegistry.addName(new ItemStack(sofaPartCenter, 1, 8), "Sofa Part (Center)");
        LanguageRegistry.addName(new ItemStack(sofaPartCenter, 1, 12), "Sofa Part (Center)");
        LanguageRegistry.addName(new ItemStack(sofaPartCorner, 1, 0), "Sofa Part (Corner)");
        LanguageRegistry.addName(new ItemStack(sofaPartCorner, 1, 4), "Sofa Part (Corner)");
        LanguageRegistry.addName(new ItemStack(sofaPartCorner, 1, 8), "Sofa Part (Corner)");
        LanguageRegistry.addName(new ItemStack(sofaPartCorner, 1, 12), "Sofa Part (Corner)");
        LanguageRegistry.addName(new ItemStack(miscBlocksOne, 1, 0), "Chimney");
        LanguageRegistry.addName(new ItemStack(miscBlocksOne, 1, 4), "Mantle Piece");
        LanguageRegistry.addName(new ItemStack(miscBlocksOne, 1, 8), "Christmas Tree");
        LanguageRegistry.addName(new ItemStack(lightsOn, 1, 0), "Light");
        LanguageRegistry.addName(new ItemStack(lightsOn, 1, 4), "Outdoor Lamp");
        LanguageRegistry.addName(new ItemStack(lightsOn, 1, 8), "Table Lamp");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
