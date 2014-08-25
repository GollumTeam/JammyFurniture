package mods.jammyfurniture.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.gollum.core.tools.helper.blocks.HBlockContainerMetadata;
import mods.jammyfurniture.ModJammyFurniture;

public abstract class JFAMetadataBlock extends HBlockContainerMetadata {

	protected Class tileEntityClass;
	protected Random random;
	
	public JFAMetadataBlock(int id, String registerName, Material material, Class tileEntityClass, int[] listSubBlock) {
		super(id, registerName, material, listSubBlock);
		this.tileEntityClass = tileEntityClass;
		this.random = new Random();		
	}
	
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
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
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
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
	protected int getOrientation(Entity entity) {
		return (MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

}