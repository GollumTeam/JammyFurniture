package mods.jammyfurniture.common.tilesentities.iron;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.gollum.core.tools.helper.IBlockHelper;
import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.recipes.jfm_CookerRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;

public class TileEntityIronBlocksOne extends GCLInventoryTileEntity {
	

	private static final int INV_SIZE_FRIDGE     = 9;
	private static final int INV_SIZE_COOKER     = 5;
	private static final int INV_SIZE_RUBBISHBIN = 27;
	
//	private int ticksSinceSync;
//	
//	
	public int currentItemBurnTime = 0;
	public int cookerBurnTime = 0;
	public int cookerCookTime = 0;
	public int cookerCookTime2 = 0;
	
	// Ouverture des porte	
//	long lastClearance = System.currentTimeMillis();
	
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
	
//	public static boolean isItemFuel(ItemStack par0ItemStack) {
//		return getItemBurnTime(par0ItemStack) > 0;
//	}
	
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
		
//		if (debug) {
//			System.out.println("World Obj = " + this.worldObj);
//			System.out.println("X: " + this.xCoord);
//			System.out.println("Y: " + this.yCoord);
//			System.out.println("Z: " + this.zCoord);
//			System.out.println("Meta: " + this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
//			System.out.println("Bin - Time Left " + (int) Math.floor((double) ((300000L - (System.currentTimeMillis() - this.lastClearance)) / 1000L)) / 60 + ":" + (300000L - (System.currentTimeMillis() - this.lastClearance)) / 1000L % 60L);
//		}

//		int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
//
//
//		if (meta != 8 && meta != 9 && meta != 10 && meta != 11) {
//			if (meta == 12 && System.currentTimeMillis() - this.lastClearance >= 300000L) {
//				this.removeItems(this);
//				this.lastClearance = System.currentTimeMillis();
//			}
//		} else {
//			boolean var9 = this.cookerBurnTime > 0;
//			boolean var10 = false;
//
//			if (this.cookerBurnTime > 0) {
//				--this.cookerBurnTime;
//			}
//
//			if (!this.worldObj.isRemote) {
//				if (this.cookerBurnTime == 0 && this.canSmelt()) {
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
//				if (this.isBurning() && this.canSmelt()) {
//					++this.cookerCookTime;
//
//					if (this.cookerCookTime == 200) {
//						this.cookerCookTime = 0;
//						this.smeltItem();
//						var10 = true;
//					}
//				} else {
//					this.cookerCookTime = 0;
//				}
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
//			}
//
//			if (var10) {
//				this.onInventoryChanged();
//			}
//		}
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
		
//		this.cookerBurnTime = nbtTagCompound.getShort("BurnTime");
//		this.cookerCookTime = nbtTagCompound.getShort("CookTime");
//		this.cookerCookTime2 = nbtTagCompound.getShort("CookTime2");
		
//		this.currentItemBurnTime = getItemBurnTime(this.inventory[1]); // TODO
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		if (this.getSubBlock() == 8) {
//			nbtTagCompound.setShort("BurnTime", (short) this.cookerBurnTime);
//			nbtTagCompound.setShort("CookTime", (short) this.cookerCookTime);
//			nbtTagCompound.setShort("CookTime2", (short) this.cookerCookTime2);
		}
	}
	
	////////////
	// Others //
	////////////
	
//	public void onTileEntityPowered(int par1, int par2) {
//		if (par1 == 1) {
//			this.numUsingPlayers = par2;
//		}
//	}
//
//	public int getCookProgressScaled(int par1) {
//		return this.cookerCookTime * par1 / 200;
//	}
//
//	public int getCookProgressScaled2(int par1) {
//		return this.cookerCookTime2 * par1 / 200;
//	}
//
//	public int getBurnTimeRemainingScaled(int par1) {
//		if (this.currentItemBurnTime == 0) {
//			this.currentItemBurnTime = 200;
//		}
//
//		return this.cookerBurnTime * par1 / this.currentItemBurnTime;
//	}
//
//	public boolean isBurning() {
//		return this.cookerBurnTime > 0;
//	}
//
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
//	private boolean canSmelt() {
////		if (this.cookerItemStacks[0] == null) {
//			return false;
////		} else {
////			ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[0].getItem().itemID);
////			return itemstack == null ? false : (this.cookerItemStacks[2] == null ? true : (!this.cookerItemStacks[2].isItemEqual(itemstack) ? false : (this.cookerItemStacks[2].stackSize < this.getInventoryStackLimit()
////					&& this.cookerItemStacks[2].stackSize < this.cookerItemStacks[2].getMaxStackSize() ? true : this.cookerItemStacks[2].stackSize < itemstack.getMaxStackSize())));
////		}
//	}
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
//	public void smeltItem() {
////		if (this.canSmelt()) {
////			ItemStack itemstack = jfm_CookerRecipes.smelting().getSmeltingResult(this.cookerItemStacks[0].getItem().itemID);
////
////			if (this.cookerItemStacks[2] == null) {
////				this.cookerItemStacks[2] = itemstack.copy();
////			} else if (this.cookerItemStacks[2].itemID == itemstack.itemID) {
////				this.cookerItemStacks[2].stackSize += itemstack.stackSize;
////			}
////
////			--this.cookerItemStacks[0].stackSize;
////
////			if (this.cookerItemStacks[0].stackSize <= 0) {
////				this.cookerItemStacks[0] = null;
////			}
////		}
//	}
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
//
//	private static int getItemBurnTime(ItemStack par1ItemStack) {
////		if (par1ItemStack == null) {
//			return 0;
////		} else {
////			int i = par1ItemStack.getItem().itemID;
////			return i < 256 && Block.blocksList[i].blockMaterial == Material.wood ? 300 : (i == Item.stick.itemID ? 100 : (i == Item.coal.itemID ? 1600 : (i == Item.bucketLava.itemID ? 20000 : (i == Block.sapling.blockID ? 100 : (i == Item.blazeRod.itemID ? 2400 : ModLoader.addAllFuel(
////					par1ItemStack.itemID, par1ItemStack.getItemDamage()))))));
////		}
//	}
	
	private int getSubBlock() {
		int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		return((IBlockMetadataHelper)ModJammyFurniture.blockIronBlocksOne).getEnabledMetadata(metadata);
	}
	
}
