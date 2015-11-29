package com.gollum.jammyfurniture.common.block;

import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import com.gollum.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;

import net.minecraft.block.material.Material;

public class BlockLights extends JFMetadataBlock {
	
	/* FIXME
	IIcon blockIconLight0;
	IIcon blockIconLight1;
	IIcon blockIconLight2;
	*/
	
	public BlockLights(String registerName, boolean active) {
		super(registerName, Material.glass, "wood", (active) ? TileEntityLightsOn.class : TileEntityLightsOff.class, new int[] { 0, 4, 8 });
		
		if (active) {
			this.setLightLevel(1.0F);
		}
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
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
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	/* FIXME
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 4) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	*/
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int metadata = world.getBlockMetadata(x, y, z);
		Block block  = world.getBlock(x, y, z);

		if (block == ModBlocks.blockLightsOn) {
			world.setBlock(x, y, z, ModBlocks.blockLightsOff, metadata, 3);
		} else {
			world.setBlock(x, y, z, ModBlocks.blockLightsOn, metadata, 3);
		}

		return true;
	}
	*/
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	/* FIXME
	@Override
	public int getRenderType() {
		return ModJammyFurniture.lightsRenderID;
	}
	*/
	
	//////////////////////////
	//Gestion des textures  //
	//////////////////////////

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	/* FIXME
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIconLight0 = this.helper.loadTexture (iconRegister, "sofa_red"  , true);
		this.blockIconLight1 = this.helper.loadTexture (iconRegister, "outlight"  , true);
		this.blockIconLight2 = this.helper.loadTexture (iconRegister, "tablelight", true);
	}
	*/

	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	/* FIXME
	@Override
	public IIcon getIcon(int side, int metadata) {
		int subBlock = this.getEnabledMetadata(metadata);
		switch (subBlock) {
			default:
			case 0:  return this.blockIconLight0;
			case 4:  return this.blockIconLight1;
			case 8:  return this.blockIconLight2;
		}
	}
	*/
	
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
