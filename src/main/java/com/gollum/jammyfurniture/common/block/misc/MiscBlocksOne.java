package com.gollum.jammyfurniture.common.block.misc;

import java.util.Random;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MiscBlocksOne extends JFMetadataBlock {
	
	Icon blockIconChimney;
	Icon blockIconMantle;
	Icon blockIconChristmasTree;

	public MiscBlocksOne(int id, String registerName) {
		super(id, registerName, Material.rock, "mantle", TileEntityMiscBlockOne.class, new int[] { 0, 4, 8 });
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

		if (metadata == 1 || metadata == 4 || metadata == 8) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	public void randomDisplayTick(World world, int blockX, int blockY, int blockZ, Random random) {
		int metadata = world.getBlockMetadata(blockX, blockY, blockZ);
		int subBlock = this.getEnabledMetadata(metadata);

		if (subBlock == 0) { // La cheminé
			float x = (float) blockX + 0.5F + random.nextFloat() * 0.6F - 0.3F;
			float y = (float) blockY + 1.0F + random.nextFloat() * 0.6F;
			float z = (float) blockZ + 0.5F + random.nextFloat() * 0.6F - 0.3F;
			world.spawnParticle("smoke", (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) x, (double) y, (double) (z), 0.0D, 0.0D, 0.0D);
		}
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	public int getRenderType() {
		return ClientProxyJammyFurniture.miscBlocksOneRenderID;
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
		
		this.blockIconChimney       = this.helper.loadTexture (par1IconRegister, "chimney"      , true);
		this.blockIconMantle        = this.helper.loadTexture (par1IconRegister, "mantle"       , true);
		this.blockIconChristmasTree = this.helper.loadTexture (par1IconRegister, "christmastree", true);
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
			case 0:  return this.blockIconChimney;
			case 4:  return this.blockIconMantle;
			case 8:  return this.blockIconChristmasTree;
		}
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 4 || subBlock == 8) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
	
}
