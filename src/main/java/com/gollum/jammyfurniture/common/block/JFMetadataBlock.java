package com.gollum.jammyfurniture.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.gollum.core.tools.helper.blocks.HBlockContainerMetadata;

public abstract class JFMetadataBlock extends HBlockContainerMetadata {

	protected Class tileEntityClass;
	protected String textureKey;
	
	public JFMetadataBlock(int id, String registerName, Material material, String textureKey, Class tileEntityClass, int[] listSubBlock) {
		super(id, registerName, material, listSubBlock);
		this.tileEntityClass = tileEntityClass;
		this.textureKey = textureKey;
	}
	
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world) {
		try {
			return (TileEntity) this.tileEntityClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/////////////
	// Texture //
	/////////////
	
	@Override
	public String getTextureKey() {
		return this.textureKey;
	}
	
	/**
	 * Enregistre les textures
	 * Depuis la 1.5 on est obligé de charger les texture fichier par fichier
	 */
	@Override
	public void registerIcons(IconRegister iconRegister) {
		for (int metadata : this.listSubEnabled()) {
			this.getGollumHelperMetadata().blockIcons.put(metadata, this.getGollumHelperMetadata().loadTexture(iconRegister));
		}
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		this.getCollisionBoundingBox(metadata, false);
		
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		
		int metadata = blockAccess.getBlockMetadata(x, y, z);
		this.getCollisionBoundingBox(metadata, true);
		
	}
	
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}


	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * Renvoi l'orientation du block par rapport à lentity
	 * Pour le palcement
	 * @param entity
	 * @return
	 */
	public int getOrientation(Entity entity) {
		return (MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

}