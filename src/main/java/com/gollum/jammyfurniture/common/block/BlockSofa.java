package com.gollum.jammyfurniture.common.block;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSofa extends JFMetadataBlock {
	
	private Icon blockIconRed;
	private Icon blockIconBlue;
	private Icon blockIconGreen;
	private Icon blockIconGrey;
	
	public BlockSofa(int id, String registerName, Class tileEntityClass) {
		super(id, registerName, Material.wood, "wood", tileEntityClass, new int[] { 0, 4, 8, 12 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		if (isSelectBox) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.7F, 1.0F);
		}
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4 || metadata == 8 || metadata == 12) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitX, float hitY, float hitZ, float par9) {
		
		int metadata = world.getBlockMetadata(x, y, z);

		if (world.isRemote) {
			return true;
		}
		metadata %= 4;
		
		if (metadata == 0) {
			player.rotationYaw = 180.0F;
		}
		
		if (metadata == 1) {
			player.rotationYaw = -90.0F;
		}
		
		if (metadata == 2) {
			player.rotationYaw = 0.0F;
		}
		
		if (metadata == 3) {
			player.rotationYaw = 90.0F;
		}
		
		return BlockMountable.onBlockActivated (world, x, y, z, player, 0.5F, 0.4F, 0.5F, 0, 0, 0, 0);
		
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ClientProxyJammyFurniture.sofaRenderID;
	}
	
	//////////////////////////
	//Gestion des textures  //
	//////////////////////////
	
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIconRed   = this.helper.loadTexture (par1IconRegister, "sofa_red"  , true);
		this.blockIconGreen = this.helper.loadTexture (par1IconRegister, "sofa_green", true);
		this.blockIconGrey  = this.helper.loadTexture (par1IconRegister, "sofa_grey" , true);
		this.blockIconBlue  = this.helper.loadTexture (par1IconRegister, "sofa_blue" , true);
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	@Override
	public Icon getIcon(int side, int metadata) {
		int subBlock = this.getEnabledMetadata(metadata);
		switch (subBlock) {
			default:
			case 0:  return this.blockIconRed;
			case 4:  return this.blockIconBlue;
			case 8:  return this.blockIconGreen;
			case 12: return this.blockIconGrey;
		}
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
	
}