package com.gollum.jammyfurniture.common.block;

import static com.gollum.jammyfurniture.ModJammyFurniture.log;

import java.util.List;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import com.gollum.jammyfurniture.inits.ModBlocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLights extends JFBlock {
	
	public static enum EnumType implements IStringSerializable
	{
		LIGHT       ("light", 0),
		OUTDOOR_LAMP("outdoor_lamp", 1),
		TABLE_LAMP  ("table_lamp", 2);

		private final String name;
		private final int value;
		
		private EnumType(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public String toString() {
			return this.name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	public static class PropertyType extends PropertyEnum<EnumType> {
		protected PropertyType(String name) {
			super(name, EnumType.class, Lists.newArrayList(EnumType.values()));
		}
		public static PropertyType create(String name) {
			return new PropertyType(name);
		}
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyType TYPE = PropertyType.create("type");
	
	
	public BlockLights(String registerName, boolean active) {
		super(registerName, Material.glass, "wood", (active) ? TileEntityLightsOn.class : TileEntityLightsOff.class, new int[] { 0, 4, 8 });
		this.setDefaultState(this.getDefaultState()
			.withProperty(FACING, EnumFacing.NORTH)
			.withProperty(TYPE, EnumType.LIGHT)
		);
		if (active) {
			this.setLightLevel(1.0F);
		}
	}
	
	////////////
	// States //
	////////////
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{
			FACING,
			TYPE,
		});
	}
	
	// TODO peut etre a supprimer
//	/**
//	 * Enregistrement du rendu du bloc. Appelé a la fin de l'Init
//	 */
//	@SideOnly(Side.CLIENT)
//	@Override
//	public void registerRender () {
//		helper.registerRender(0);
//		helper.registerRender(4);
//		helper.registerRender(8);
//		
//		ModelBakery.addVariantName(
//			this.getBlockItem(), 
//			ModJammyFurniture.MODID+":light", 
//			ModJammyFurniture.MODID+":outdoor_lamp", 
//			ModJammyFurniture.MODID+":table_lamp"
//		);
//		helper.registerRender(0, "light");
//		helper.registerRender(4, "outdoor_lamp");
//		helper.registerRender(8, "table_lamp");
//	}
	
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		switch (meta) {
			case 0:
			case 1:
			case 2:
			case 3:
				state = state.withProperty(TYPE, EnumType.LIGHT); break;
			case 4:
			case 5:
			case 6:
			case 7:
				state = state.withProperty(TYPE, EnumType.OUTDOOR_LAMP); break;
			default:
				state = state.withProperty(TYPE, EnumType.TABLE_LAMP); break;
		}
		return state.withProperty(FACING, EnumFacing.HORIZONTALS[meta % 4]);
	}
	
	public int getMetaFromState(IBlockState state) {
		if (state == null) {
			return 0;
		}
		return state.getValue(TYPE).getValue() * 4 + state.getValue(FACING).getHorizontalIndex();
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs ctabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 4));
		list.add(new ItemStack(item, 1, 8));
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	// TODO a revoir
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  
			case 1:
			case 2:  
			case 3:  this.setBlockBounds(0.25F, 0.385F, 0.315F, 0.685F, 1.0F, 0.75F); break;
			case 4:  this.setBlockBounds(0.315F, 0.125F, 0.5F, 0.625F, 0.925F, 1.0F); break;
			case 5:  this.setBlockBounds(0.0F, 0.125F, 0.315F, 0.5F, 0.925F, 0.625F); break;
			case 6:  this.setBlockBounds(0.375F, 0.125F, 0.0F, 0.685F, 0.925F, 0.5F); break;
			case 7:  this.setBlockBounds(0.5F, 0.125F, 0.375F, 1.0F, 0.925F, 0.685F); break;
			case 8:  
			case 9:  
			case 10: 
			case 11: this.setBlockBounds(0.315F, 0.0F, 0.315F, 0.685F, 0.875F, 0.685F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.lightsRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		state = this.getStateFromMeta(stack.getItemDamage());
		world.setBlockState(pos, state.withProperty(FACING, player.getHorizontalFacing().getOpposite()), 2);
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		EnumType type = state.getValue(TYPE);
		EnumFacing orientaion = state.getValue(FACING);
		Block block  = state.getBlock();
		IBlockState newState = null;
		if (block == ModBlocks.blockLightsOn) {
			newState = ModBlocks.blockLightsOff.getDefaultState();
		} else {
			newState = ModBlocks.blockLightsOn.getDefaultState();
		}
		newState = newState.withProperty(TYPE, type);
		newState = newState.withProperty(FACING, orientaion);
		world.setBlockState(pos, newState, 3);

		return true;
	}
	
	////////////
	// Others //
	////////////
	/* FIXME
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 4) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		return true;
	}
	*/
}
