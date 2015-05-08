package mods.jammyfurniture.common.block;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.light.TileEntityLightsOff;
import mods.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLights extends JFMetadataBlock {
	
	Icon blockIconLight0;
	Icon blockIconLight1;
	Icon blockIconLight2;
	
	public BlockLights(int id, String registerName, boolean active) {
		super(id, registerName, Material.glass, "wood", (active) ? TileEntityLightsOn.class : TileEntityLightsOff.class, new int[] { 0, 4, 8 });
		
		if (active) {
			this.setLightValue(1.0F);
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
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack item) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 4) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int metadata = world.getBlockMetadata(x, y, z);
		int id       = world.getBlockId(x, y, z);

		if (id == ModJammyFurniture.blockLightsOn.blockID) {
			world.setBlock(x, y, z, ModJammyFurniture.blockLightsOff.blockID, metadata, 0);
		} else {
			world.setBlock(x, y, z, ModJammyFurniture.blockLightsOn.blockID, metadata, 0);
		}

		return true;
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.lightsRenderID;
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
		this.blockIconLight0 = this.helper.loadTexture (par1IconRegister, "sofa_red"  , true);
		this.blockIconLight1 = this.helper.loadTexture (par1IconRegister, "outlight", true);
		this.blockIconLight2 = this.helper.loadTexture (par1IconRegister, "tablelight" , true);
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
			case 0:  return this.blockIconLight0;
			case 4:  return this.blockIconLight1;
			case 8:  return this.blockIconLight2;
		}
	}
}
