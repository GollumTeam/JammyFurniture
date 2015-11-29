package com.gollum.jammyfurniture.common.block;

import static com.gollum.core.tools.helper.blocks.HBlockMetadata.METADATA;

import java.util.ArrayList;
import java.util.List;

import com.gollum.core.tools.helper.blocks.HBlockContainerMetadata;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class JFBlockMetadata extends HBlockContainerMetadata {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	protected Class tileEntityClass;
	protected String textureKey;
	
	public JFBlockMetadata(String registerName, Material material, String textureKey, Class tileEntityClass, int[] listSubBlock) {
		super(registerName, material, listSubBlock);
		this.setDefaultState(this.getDefaultState().withProperty(FACING, EnumFacing.NORTH));
		this.tileEntityClass = tileEntityClass;
		this.textureKey = textureKey;
	}
	
	@Override
	protected List<IProperty> getStateProperties() {
		List<IProperty> prop = super.getStateProperties();
		prop.add(FACING);
		return prop;
	}
	
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		try {
			return (TileEntity) this.tileEntityClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/////////////
	// Texture //
	/////////////
	
	/* FIXME
	@Override
	public String getTextureKey() {
		return this.textureKey;
	}
	*/
	
	/* FIXME
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int metadata : this.listSubEnabled()) {
			this.getGollumHelperMetadata().blockIcons.put(metadata, this.getGollumHelperMetadata().loadTexture(iconRegister));
		}
	}
	*/
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	/* FIXME
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		
		int metadata = world.getBlockMetadata(x, y, z);
		this.getCollisionBoundingBox(metadata, false);
		
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	*/
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	/* FIXME
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		
		int metadata = blockAccess.getBlockMetadata(x, y, z);
		this.getCollisionBoundingBox(metadata, true);
		
	}
	*/
	
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
	/* FIXME	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	*/

}