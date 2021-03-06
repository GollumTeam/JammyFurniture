package com.gollum.jammyfurniture.common.block;

import java.util.Random;

import com.gollum.core.tools.helper.blocks.HBlockContainer;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.entities.EntityMountableBlock;
import com.gollum.jammyfurniture.common.item.ItemBath;
import com.gollum.jammyfurniture.common.tilesentities.TileEntityBath;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BathBlock extends HBlockContainer {
	
	public static final int[][] footBlockToHeadBlockMap = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	
	public BathBlock(String registerName) {
		super(registerName, Material.iron);
		
		this.setItemBlockClass(ItemBath.class);
	}
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityBath();
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
	}
	
	/////////////
	// Texture //
	/////////////

	@Override
	public String getTextureKey () {
		return "ceramic";
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
	 */
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
		int direction = getDirection(metadata);
		
		
		int x2 = x + footBlockToHeadBlockMap[direction][0];
		int z2 = z + footBlockToHeadBlockMap[direction][1];
		
		boolean isHead = this.isBlockHead(metadata);
		
		if (isHead) {
			x2 = x - footBlockToHeadBlockMap[direction][0];
			z2 = z - footBlockToHeadBlockMap[direction][1];
		}
		
		if (world.getBlock(x2, y, z2) == this) {
			world.func_147480_a(x2, y, z2, true);
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
		} else {
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
			
			return EntityMountableBlock.onBlockActivated(world, x, y, z, player, 0.5F, 0.4F, 0.5F);
		}
	}
	
	
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int metadata, Random random, int j) {
		return this.isBlockHead(metadata) ? super.getItemDropped(metadata, random, j): null;
	}
	
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return ModJammyFurniture.bathTubRenderID;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
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

	public static boolean isBlockHead(int metadata) {
		return (metadata & 7) != metadata;
	}

	public static int getDirection(int metadata) {
		return metadata & 3;
	}
	
	////////////
	// Others //
	////////////

	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		
		world.setBlockMetadataWithNotify(x, y, z, ((metadata + rotate) % 4), 2);
		return true;
	}
}
