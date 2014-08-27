package mods.jammyfurniture.common.block.iron;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.block.JFMetadataBlock;
import mods.jammyfurniture.common.tilesentities.TileEntityIronBlocksTwo;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JFIronBlocksTwo extends JFMetadataBlock {
	
	public JFIronBlocksTwo(int id, String registerName) {
		super(id, registerName, Material.iron, "iron", TileEntityIronBlocksTwo.class, new int[]{ 0, 4 });
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
		world.getBlockMetadata(x, y, z);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		blockAccess.getBlockMetadata(x, y, z);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(entityliving);

		if (metadata == 0 || metadata == 4) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int meta = world.getBlockMetadata(x, y, z);
		int orientation = this.getOrientation(player);
		TileEntityIronBlocksTwo teIronTwo;

		if (meta != 0 && meta != 1 && meta != 2 && meta != 3) {
			if (meta == 4 || meta == 5 || meta == 6 || meta == 7) {
				teIronTwo = (TileEntityIronBlocksTwo) world.getBlockTileEntity(x, y, z);

				if (teIronTwo != null) {
					player.openGui(ModJammyFurniture.instance, 155, world, x, y, z);
					return true;
				}
			}
		} else {
			teIronTwo = (TileEntityIronBlocksTwo) world.getBlockTileEntity(x, y, z);
			
			if (teIronTwo != null) {
				player.openGui(ModJammyFurniture.instance, 159, world, x, y, z);
				return true;
			}
		}
		
		return true;
	}
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	public void breakBlock(World world, int x, int y, int z, int oldBlodkID, int oldMetadata) {
		
		this.helper.breakBlockInventory(world, x, y, z, oldBlodkID);
		
		super.breakBlock(world, x, y, z, oldBlodkID, oldMetadata);
	}
	
	///////////////////
	// Data du block //
	///////////////////

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return ModJammyFurniture.ironBlocksTwoRenderID;
	}
}
