package com.gollum.jammyfurniture.common.block.ceramic;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.block.IBlockUnmountEvent;
import com.gollum.jammyfurniture.common.block.JFBlockMetadata;
import com.gollum.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CeramicBlocksOne extends JFBlockMetadata implements IBlockUnmountEvent {
	
	public CeramicBlocksOne(String registerName) {
		super(registerName, Material.glass, "ceramic", TileEntityCeramicBlocksOne.class, new int[]{ 0, 4, 8, 12 });
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  this.setBlockBounds(0.1F, 0.0F, 0.6F, 0.9F, 1.0F, 1.0F); break;
			case 1:  this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.4F, 1.0F, 0.9F); break;
			case 2:  this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.4F); break;
			case 3:  this.setBlockBounds(0.6F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F); break;
			case 4:  this.setBlockBounds(0.1F, 0.0F, 0.2F, 0.9F, 1.0F, 1.0F); break;
			case 5:  this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.8F, 1.0F, 0.9F); break;
			case 6:  this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.8F); break;
			case 7:  this.setBlockBounds(0.2F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F); break;
			case 8:  
			case 9:  
			case 10: 
			case 11: this.setBlockBounds(0.0F , 0.4F, 0.0F , 1.0F , 1.0F, 1.0F ); break;
			case 12: this.setBlockBounds(0.15F, 0.0F, 0.05F, 0.85F, 1.0F, 1.0F ); break;
			case 13: this.setBlockBounds(0.05F, 0.0F, 0.15F, 1.0F , 1.0F, 0.85F); break;
			case 14: this.setBlockBounds(0.15F, 0.0F, 0.0F , 0.85F, 1.0F, 0.95F); break;
			case 15: this.setBlockBounds(0.0F , 0.0F, 0.15F, 0.95F, 1.0F, 0.85F); break;
			default: this.setBlockBounds(0.0F , 0.0F, 0.0F , 1.0F , 1.0F, 1.0F ); break;
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.ceramicBlocksOneRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called when the block is placed in the world.
	 */
	/* FIXME
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);
		int orientation = this.getOrientation(entityliving);

		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, metadata + orientation, 2);
		}
	}
	*/
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	/* FIXME
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) {
		
		this.helper.breakBlockInventory(world, x, y, z, oldBlock);
		
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
	}
	*/

	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);
		int orientation = this.getOrientation(player);
		TileEntity te   = world.getTileEntity(x, y, z);
		
		
		if (te != null && te instanceof TileEntityCeramicBlocksOne) {
			TileEntityCeramicBlocksOne teCeramic = (TileEntityCeramicBlocksOne)te;
			
			switch (subBlock) {
				
				case 0: // Armoire a salle de bain
					
					player.openGui(ModJammyFurniture.instance, ModJammyFurniture.GUI_BARHROOMCUPBOARD_ID, world, x, y, z);
					return true;
					
				case 4: // Lavabo mural
				case 8: // Lavabo 
					
					if (world.isRemote) {
						return true;
					}
					
					if (teCeramic.waterIsOn ()) {
						
						ItemStack itemStack = player.inventory.getCurrentItem();
						ItemStack newItemStack = CeramicBlocksOneRecipes.smelting().getSmeltingResult(itemStack);
						
						if (newItemStack != null) {
							
							--itemStack.stackSize;
							
							if (itemStack.stackSize <= 0) {
								player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
							}
							
							if (player.inventory.addItemStackToInventory(newItemStack.copy())) {
								if (player instanceof EntityPlayerMP) {
									((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
								}
							} else {
								ModJammyFurniture.log.debug("Spawn new entity");
								world.spawnEntityInWorld(new EntityItem(world, (double) x + 0.5D, (double) y + 1.5D, (double) z + 0.5D, newItemStack));
							}
							
							
							return true;
						}
					}
					
					world.addBlockEvent(x, y, z, this, 2, 0);
					
					return true;
					
				case 12: // Les toilettes
					
					if (world.isRemote) {
						return true;
					}
					
					if (orientation == 0) {
						player.rotationYaw = 180.0F;
					}
					
					if (orientation == 1) {
						player.rotationYaw = -90.0F;
					}
					
					if (orientation == 2) {
						player.rotationYaw = 0.0F;
					}
					
					if (orientation == 3) {
						player.rotationYaw = 90.0F;
					}
					
					return BlockMountable.onBlockActivated(world, x, y, z, player, 0.5F, 0.4F, 0.5F, 0, 0, 0, 0);
				default:
					break;
			}
		}
		
		
		return false;
	}
	*/
	
	/**
	* Called when the block receives a BlockEvent - see World.addBlockEvent. By default, passes it on to the tile
	* entity at this location. Args: world, x, y, z, blockID, EventID, event parameter
	*/
	/* FIXME
	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventID, int parameter) {
		if (eventID == 2) {
			TileEntity te = world.getTileEntity(x, y, z);
	
			if (te != null && te instanceof TileEntityCeramicBlocksOne) {
				TileEntityCeramicBlocksOne teCeramicBlocks = (TileEntityCeramicBlocksOne)te;
				
				teCeramicBlocks.toggleWater();
			}
			return true;
		}
		return super.onBlockEventReceived(world, x, y, z, eventID, parameter);
	}
	*/
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, Entity entity, EntityPlayer player) {
		world.playSoundAtEntity(player, ModJammyFurniture.MODID.toLowerCase()+":toilet", 1.0F, 1.0F);
	}
	
	////////////
	// Others //
	////////////
	
	/* FIXME
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
		
		int rotate   = axis == ForgeDirection.DOWN ? 3 : 1;
		int metadata = world.getBlockMetadata(x, y, z);
		int subBlock = this.getEnabledMetadata(metadata);
		
		if (subBlock == 0 || subBlock == 4 || subBlock == 8 || subBlock == 12) {
			world.setBlockMetadataWithNotify(x, y, z, ((metadata - subBlock + rotate) % 4) + subBlock, 2);
			return true;
		}
		
		return false;
	}
	*/
	
}
