package com.gollum.jammyfurniture.common.block.misc;

import java.util.Random;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.JFMetadataBlock;
import com.gollum.jammyfurniture.common.tilesentities.misc.TileEntityMiscBlockOne;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		int metadata = world.getBlockMetadata(i, j, k);
		int subBlock = this.getEnabledMetadata(metadata);

		if (subBlock == 0) { // La cheminé
			float f = (float) i + 0.5F;
			float f1 = (float) j + 1.0F + random.nextFloat() * 6.0F / 10.0F;
			float f2 = (float) k + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;
			world.spawnParticle("smoke", (double) f, (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) f, (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) f, (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", (double) f, (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		}
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	public int getRenderType() {
		return ModJammyFurniture.miscBlocksOneRenderID;
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
}
