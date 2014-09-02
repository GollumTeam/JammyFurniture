package mods.jammyfurniture.common.block.sofa;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.util.BlockMountable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArmChair extends JFMetadataBlock {
	
	private Icon blockIconRed;
	private Icon blockIconBlue;
	private Icon blockIconGreen;
	private Icon blockIconGrey;
	
	public BlockArmChair(int id, String registerName) {
		super(id, registerName, Material.wood, "wood", TileEntityArmChair.class, new int[] { 0, 4, 8, 12 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		
		switch (metadata) {
			default:
			case 0:  
			case 2:  
			case 4:  
			case 6:  this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
			case 1:  
			case 3:  
			case 5:  
			case 7:  this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
			case 8:  
			case 9:  
			case 10: 
			case 11: 
			case 13:
			case 14: 
			case 15: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			case 12: this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
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
		return ModJammyFurniture.armChairRenderID;
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
}
