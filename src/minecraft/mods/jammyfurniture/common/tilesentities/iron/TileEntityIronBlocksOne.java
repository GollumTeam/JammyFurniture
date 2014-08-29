package mods.jammyfurniture.common.tilesentities.iron;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.gollum.core.tools.helper.IBlockHelper;
import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.crafting.CookerRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityIronBlocksOne extends GCLInventoryTileEntity {
	

	private static final int INV_SIZE_FRIDGE     = 9;
	private static final int INV_SIZE_COOKER     = 5;
	private static final int INV_SIZE_RUBBISHBIN = 27;
	
	private static final int INDEX_SLOT_BURN    = 1;
	private static final int INDEX_SLOT_BEFORE1 = 0;
	private static final int INDEX_SLOT_BEFORE2 = 3;
	private static final int INDEX_SLOT_AFTER1  = 2;
	private static final int INDEX_SLOT_AFTER4  = 2;

	private static final int COOKING_SPEED1  = 200;
	private static final int COOKING_SPEED2  = 200;
	
//	private int ticksSinceSync;
//	
//	
	public int currentItemBurnTime = 0;
	public int cookerBurnTime = 0;
	public int cookerCookTime = 0;
	public int cookerCookTime2 = 0;
	
	// Date du dernier effacement de la corbeille
	long lastClearance = System.currentTimeMillis();
	// Orientation de la poubelle
	public short rubishBinOrientation = 0;
	
//	public static boolean debug = false;

	public TileEntityIronBlocksOne() {
		super (Math.max(INV_SIZE_FRIDGE, Math.max(INV_SIZE_COOKER, INV_SIZE_RUBBISHBIN)));
	}
	
	///////////////
	// Inventory //
	///////////////
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord)) {
			switch (this.getSubBlock()) {
				case 0:
				case 4:  return this.INV_SIZE_FRIDGE;
				case 8:  return this.INV_SIZE_COOKER;
				case 12: return this.INV_SIZE_RUBBISHBIN;
				default: break;
			}
		}
		return super.getSizeInventory();
	}
	
	
	// TODO a tradurie
	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInvName() {
		
		switch (this.getSubBlock()) {
			case 0:  return "Fridge";
			case 4:  return "Freezer";
			case 8:  return "Cooker";
			case 12: return "Rubbish Bin";
			default: break;
		}
		
		return "ERROR";
	}
	
	protected void playSoundClosedInventory() {
		String oldSound = this.soundClosedInventory;
		float oldVolume = this.volumeSoundOpenClosedInventory;
		if (this.getSubBlock() == 12) {
			this.soundClosedInventory = ModJammyFurniture.MODID.toLowerCase()+":trashclosed";
		}
		
		super.playSoundClosedInventory();
		
		this.soundClosedInventory = oldSound;
		this.volumeSoundOpenClosedInventory = oldVolume;
	}
	
	protected void playSoundOpenInventory() {
		String oldSound = this.soundOpenInventory;
		float oldVolume = this.volumeSoundOpenClosedInventory;
		if (this.getSubBlock() == 12) {
			this.soundOpenInventory = ModJammyFurniture.MODID.toLowerCase()+":trashopen";
			this.volumeSoundOpenClosedInventory = 1.0F;
		}
		
		super.playSoundOpenInventory();
		
		this.soundOpenInventory = oldSound;
		this.volumeSoundOpenClosedInventory = oldVolume;
	}
	
	////////////
	// Update //
	////////////
	
	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	public void updateEntity() {
		
		super.updateEntity();
		
		int metadata = this.getBlockMetadata();
		int subBlock = this.getSubBlock();
		
		if (subBlock == 12) { // La poubelle
			
			if (System.currentTimeMillis() - this.lastClearance >= 60000L) {
				this.removeAllItems();
				this.lastClearance = System.currentTimeMillis();
			}
			
			return;
		}
		
		boolean debug = false;
		
		if (debug) {
			System.out.println("World Obj = " + this.worldObj);
			System.out.println("X: " + this.xCoord);
			System.out.println("Y: " + this.yCoord);
			System.out.println("Z: " + this.zCoord);
			System.out.println("Meta: " + this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
			System.out.println("Biurn");
		}

		if (subBlock == 8) { // Le cooker
			
			boolean inventoryChange = false;
			
			if (this.isBurning ()) {
				--this.cookerBurnTime;
			}

			if (!this.worldObj.isRemote) {
				
				if (this.cookerBurnTime == 0 && this.canSmelt()) {
					this.currentItemBurnTime = this.cookerBurnTime = this.getItemBurnTime(this.inventory[INDEX_SLOT_BURN]);
					
					if (this.cookerBurnTime > 0) {
						inventoryChange = true;
						
						// On peux brulé l'élément donc on enleve 
						if (this.inventory[INDEX_SLOT_BURN] != null) {
							
							--this.inventory[INDEX_SLOT_BURN].stackSize;
							if (this.inventory[INDEX_SLOT_BURN].stackSize == 0) {
								this.inventory[INDEX_SLOT_BURN] = this.inventory[INDEX_SLOT_BURN].getItem().getContainerItemStack(this.inventory[INDEX_SLOT_BURN]);
							}
						}
					}
				}
//
//				if (this.cookerBurnTime == 0 && this.canSmelt2()) {
//					this.currentItemBurnTime = this.cookerBurnTime = getItemBurnTime(this.cookerItemStacks[1]);
//
//					if (this.cookerBurnTime > 0) {
//						var10 = true;
//
//						if (this.cookerItemStacks[1] != null) {
//							--this.cookerItemStacks[1].stackSize;
//
//							if (this.cookerItemStacks[1].stackSize == 0) {
//								this.cookerItemStacks[1] = this.cookerItemStacks[1].getItem().getContainerItemStack(this.cookerItemStacks[1]);
//							}
//						}
//					}
//				}
//
				if (this.isBurning() && this.canSmelt()) {
					++this.cookerCookTime;

					if (this.cookerCookTime == COOKING_SPEED1) {
						this.cookerCookTime = 0;
						this.smeltItem();
						inventoryChange = true;
					}
				} else {
					// Ca ne brule plus donc l'élement courant ne cuit plus
					this.cookerCookTime = 0;
				}
//
//				if (this.isBurning() && this.canSmelt2()) {
//					++this.cookerCookTime2;
//
//					if (this.cookerCookTime2 == 200) {
//						this.cookerCookTime2 = 0;
//						this.smeltItem2();
//						var10 = true;
//					}
//				} else {
//					this.cookerCookTime2 = 0;
//				}
			}
//
			if (inventoryChange) {
				this.onInventoryChanged();
			}
		}
	}
	
	////////////////
	// Save datas //
	////////////////
	
	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		
		this.readItems(nbtTagCompound, "FriFreItems", true); // Compatibility
		this.readItems(nbtTagCompound, "CookerItems", true); // Compatibility
		this.readItems(nbtTagCompound, "BinItems"   , true); // Compatibility
		
		this.cookerBurnTime = nbtTagCompound.getShort("BurnTime");
		this.cookerCookTime = nbtTagCompound.getShort("CookTime");
		this.cookerCookTime2 = nbtTagCompound.getShort("CookTime2");
		
		if (nbtTagCompound.hasKey("rubishBinOrientation")) {
			this.rubishBinOrientation = nbtTagCompound.getShort("rubishBinOrientation");
		}
		
		this.currentItemBurnTime = getItemBurnTime(this.inventory[INDEX_SLOT_BURN]); // TODO
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setShort("BurnTime", (short) this.cookerBurnTime);
		nbtTagCompound.setShort("CookTime", (short) this.cookerCookTime);
		nbtTagCompound.setShort("CookTime2", (short) this.cookerCookTime2);
		
		nbtTagCompound.setShort("rubishBinOrientation", this.rubishBinOrientation);
	}
	
	////////////
	// Others //
	////////////
	
	/**
	 * Vide tous les Item de l'inventaire
	 */
	public void removeAllItems () {
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			this.setInventorySlotContents(i, (ItemStack) null);
		}
	}
	
	/** 
	 * Test si le four peux cuire l'element déposé
	 */
	private boolean canSmelt() {
		if (this.inventory[INDEX_SLOT_BEFORE1] == null) {
			return false;
		}
		
		ItemStack itemCooked = CookerRecipes.smelting().getSmeltingResult(this.inventory[INDEX_SLOT_BEFORE1].getItem().itemID);
		
		if (itemCooked == null) {
			return false;
		}
		if (this.inventory[INDEX_SLOT_AFTER1] == null) {
			return true;
		}
		if (!this.inventory[INDEX_SLOT_AFTER1].isItemEqual(itemCooked)) {
			return false;
		}
		
		int total = inventory[INDEX_SLOT_AFTER1].stackSize + itemCooked.stackSize;
		
		return (total <= getInventoryStackLimit() && total <= itemCooked.getMaxStackSize());
	}
	
	/**
	 * Renvoie le temps qu'un élément peux brulé. Tous les éléments de Furnace
	 */
	private static int getItemBurnTime(ItemStack itemStack) {
		return TileEntityFurnace.getItemBurnTime(itemStack);
	}

	public boolean isBurning() {
		return this.cookerBurnTime > 0;
	}
	
	public void smeltItem() {
		
		if (this.canSmelt()) {
			ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[INDEX_SLOT_BEFORE1]);
			
			// Insert l'élément cuit dans le slot 2
			if (this.inventory[INDEX_SLOT_AFTER1] == null) {
				this.inventory[INDEX_SLOT_AFTER1] = itemStack.copy();
			} else if (this.inventory[INDEX_SLOT_AFTER1].isItemEqual(itemStack)) {
				inventory[INDEX_SLOT_AFTER1].stackSize += itemStack.stackSize;
			}

			--this.inventory[INDEX_SLOT_BEFORE1].stackSize;

			if (this.inventory[INDEX_SLOT_BEFORE1].stackSize <= 0) {
				this.inventory[INDEX_SLOT_BEFORE1] = null;
			}
		}
	}
	
	//////////////////////
	// Data for display //
	//////////////////////
	
	public int getBurnTimeRemainingScaled(int maxSize) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}
		
		return this.cookerBurnTime * maxSize / this.currentItemBurnTime;
	}
	
	public int getCookProgressScaled(int par1) {
		return this.cookerCookTime * par1 / 200;
	}
	
//	public int getCookProgressScaled2(int par1) {
//		return this.cookerCookTime2 * par1 / 200;
//	}
	
	
	
//	public static boolean isItemFuel(ItemStack par0ItemStack) {
//		return getItemBurnTime(par0ItemStack) > 0;
//	}
//	
//	public void onTileEntityPowered(int par1, int par2) {
//		if (par1 == 1) {
//			this.numUsingPlayers = par2;
//		}
//	}
	
//	public void removeItems(TileEntityIronBlocksOne te) {
////		if (te != null && te.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 12) {
////			for (int i = 0; i < te.getSizeInventory(); ++i) {
////				ItemStack itemstack = te.getStackInSlot(i);
////
////				if (itemstack != null) {
////					te.setInventorySlotContents(i, (ItemStack) null);
////				}
////			}
////		}
//	}
//
	
//
//	private boolean canSmelt2() {
////		if (this.cookerItemStacks[3] == null) {
//			return false;
////		} else {
////			ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[3].getItem().itemID);
////			return itemstack == null ? false : (this.cookerItemStacks[4] == null ? true : (!this.cookerItemStacks[4].isItemEqual(itemstack) ? false : (this.cookerItemStacks[4].stackSize < this.getInventoryStackLimit()
////					&& this.cookerItemStacks[4].stackSize < this.cookerItemStacks[4].getMaxStackSize() ? true : this.cookerItemStacks[4].stackSize < itemstack.getMaxStackSize())));
////		}
//	}
//
	
//
//	public void smeltItem2() {
////		if (this.canSmelt2()) {
////			ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[3].getItem().itemID);
////
////			if (this.cookerItemStacks[4] == null) {
////				this.cookerItemStacks[4] = itemstack.copy();
////			} else if (this.cookerItemStacks[4].itemID == itemstack.itemID) {
////				this.cookerItemStacks[4].stackSize += itemstack.stackSize;
////			}
////
////			--this.cookerItemStacks[3].stackSize;
////
////			if (this.cookerItemStacks[3].stackSize <= 0) {
////				this.cookerItemStacks[3] = null;
////			}
////		}
//	}
	
	private int getSubBlock() {
		int metadata =  this.getBlockMetadata();
		return((IBlockMetadataHelper)ModJammyFurniture.blockIronBlocksOne).getEnabledMetadata(metadata);
	}
	
}
