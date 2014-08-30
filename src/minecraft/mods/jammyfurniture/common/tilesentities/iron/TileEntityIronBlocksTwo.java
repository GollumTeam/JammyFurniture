package mods.jammyfurniture.common.tilesentities.iron;

import mods.gollum.core.common.tileentities.GCLInventoryTileEntity;
import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.crafting.CookerRecipes;
import mods.jammyfurniture.common.crafting.jfm_DishwasherRecipes;
import mods.jammyfurniture.common.crafting.jfm_WashingMachineRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityIronBlocksTwo extends GCLInventoryTileEntity {
	
	public static final int INDEX_SLOT_BURN = 1;
	public static final int INDEX_SLOT_0    = 0;
	public static final int INDEX_SLOT_2    = 3;
	public static final int INDEX_SLOT_1    = 2;
	public static final int INDEX_SLOT_3    = 4;
	
	public static final int CRAFTING_SPEED = 200;
	
	/////////////////////////////////
	// Temps actif dans la machine //
	/////////////////////////////////
	public int currentItemBurnTime = 0;
	public int cookerBurnTime = 0; // TODO
	public int slot0Time = 0;
	public int slot1Time = 0;
	public int slot2Time = 0;
	public int slot3Time = 0;
	
//	/////////////////////////////////////////
//	// A revoir pour gérer tous les amures //
//	/////////////////////////////////////////
//	public static int[] woodTools = new int[] { 270, 269, 271, 290, 268 };
//	public static int[] stoneTools = new int[] { 274, 273, 275, 291, 272 };
//	public static int[] steelTools = new int[] { 257, 256, 258, 292, 267 };
//	public static int[] goldTools = new int[] { 285, 284, 286, 294, 283 };
//	public static int[] diamondTools = new int[] { 278, 277, 279, 293, 276 };
//	public static int[] diamondArmour = new int[] { 310, 311, 312, 313 };
//	public static int[] chainArmour = new int[] { 302, 303, 304, 305 };
//	public static int[] goldenArmour = new int[] { 314, 315, 316, 317 };
//	public static int[] steelArmour = new int[] { 306, 307, 308, 309 };
//	public static int[] leatherArmour = new int[] { 298, 299, 300, 301 };
	
	
	
	public TileEntityIronBlocksTwo() {
		super (5);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	// TODO Traduire
	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {

		switch (this.getSubBlock()) {
			case 0:  return "Dishwasher";
			case 4:  return "Washing Machine";
			default: break;
		}
		
		return "ERROR";
	}
	
//	/**
//	 * Returns true if automation is allowed to insert the given stack (ignoring
//	 * stack size) into the given slot.
//	 */
//	@Override
//	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
//		return 
//			(slot == INDEX_SLOT_BURN && this.isItemFuel(itemStack)) ||
//			(slot == INDEX_SLOT_BEFORE0 && CookerRecipes.smelting().getSmeltingResult(itemStack) == null) ||
//			(slot == INDEX_SLOT_BEFORE1 && CookerRecipes.smelting().getSmeltingResult(itemStack) == null)
//		;
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
		
		int metadata = this.getBlockMetadata();
		boolean inventoryChange = false;
		
		
		if (!this.worldObj.isRemote) {
			
			if (this.isBurning ()) {
				--this.cookerBurnTime;
			}
			
			// Test si on doit alumer et recupérer un combustible
			if (this.cookerBurnTime == 0 && (this.canSmelt(0) || this.canSmelt(1) || this.canSmelt(2) || this.canSmelt(3))) {
				
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
			
			// Emplacement 0
			if (this.isBurning() && this.canSmelt(0)) {
				++this.slot0Time;
				
				if (this.slot0Time == CRAFTING_SPEED) {
					this.slot0Time = 0;
					this.smeltItem(0);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot0Time = 0;
			}
			
			// Emplacement 0
			if (this.isBurning() && this.canSmelt(0)) {
				++this.slot0Time;
				
				if (this.slot0Time == CRAFTING_SPEED) {
					this.slot0Time = 0;
					this.smeltItem(0);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot0Time = 0;
			}
			
			// Emplacement 1
			if (this.isBurning() && this.canSmelt(1)) {
				++this.slot1Time;
				
				if (this.slot1Time == CRAFTING_SPEED) {
					this.slot1Time = 0;
					this.smeltItem(1);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot1Time = 0;
			}
			
			// Emplacement 2
			if (this.isBurning() && this.canSmelt(2)) {
				++this.slot2Time;
				
				if (this.slot2Time == CRAFTING_SPEED) {
					this.slot2Time = 0;
					this.smeltItem(2);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot2Time = 0;
			}
			
			// Emplacement 3
			if (this.isBurning() && this.canSmelt(3)) {
				++this.slot3Time;

				if (this.slot3Time == CRAFTING_SPEED) {
					this.slot3Time = 0;
					this.smeltItem(3);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot3Time = 0;
			}
			
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
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		
		this.readItems(nbtTagCompound, "dwItems", true); // Compatibility
		this.readItems(nbtTagCompound, "wmItems", true); // Compatibility
		
		this.cookerBurnTime  = nbtTagCompound.getShort("BurnTime");
		this.slot0Time = nbtTagCompound.getShort("slot0Time");
		this.slot1Time = nbtTagCompound.getShort("slot1Time");
		this.slot2Time = nbtTagCompound.getShort("slot2Time");
		this.slot3Time = nbtTagCompound.getShort("slot3Time");
		
		this.currentItemBurnTime = getItemBurnTime(this.inventory[INDEX_SLOT_BURN]);
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setShort("BurnTime" , (short) this.cookerBurnTime);
		nbtTagCompound.setShort("slot0Time", (short) this.slot0Time);
		nbtTagCompound.setShort("slot1Time", (short) this.slot1Time);
		nbtTagCompound.setShort("slot2Time", (short) this.slot2Time);
		nbtTagCompound.setShort("slot3Time", (short) this.slot3Time);
		
	}
		
	/////////////
	// Furnace //
	/////////////
	
	
	public boolean isBurning() {
		return this.cookerBurnTime > 0;
	}
	
	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Renvoie le temps qu'un élément peux brulé. Tous les éléments de Furnace
	 */
	protected static int getItemBurnTime(ItemStack itemStack) {
		return TileEntityFurnace.getItemBurnTime(itemStack);
	}
	
	
	// TODO a revoir completement
	public int getSmeltTime () {
		
		short time = 1;
		int i;
//		
//		for (i = 0; i < diamondArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == diamondArmour[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < chainArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == chainArmour[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < goldenArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == goldenArmour[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < steelArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == steelArmour[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < leatherArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == leatherArmour[i]) {
//				time = 1500;
//			}
//		}

		return time;
	}
	
	/** 
	 * Test si le four peux cuire l'element déposé
	 * @param i 
	 */
	private boolean canSmelt(int i) {
		
		int subBlock = this.getSubBlock();
		int slot;
		switch (i) {
			default:
			case 0: slot = INDEX_SLOT_0;
			case 1: slot = INDEX_SLOT_1;
			case 2: slot = INDEX_SLOT_2;
			case 3: slot = INDEX_SLOT_3;
		}
		
		if (this.inventory[slot] == null) {
			return false;
		}
		
		// TODO ne pas faire comme ca
		ItemStack itemBurned;
		if (subBlock == 0) {
			itemBurned = jfm_WashingMachineRecipes.smelting().getSmeltingResult(this.inventory[slot]);
		} else {
			itemBurned = jfm_DishwasherRecipes.smelting().getSmeltingResult(this.inventory[slot]);	
		}
		
		return itemBurned != null;
	}
	
	public void smeltItem(int i) {
		
		int subBlock = this.getSubBlock();
		int slot;
		switch (i) {
			default:
			case 0: slot = INDEX_SLOT_0;
			case 1: slot = INDEX_SLOT_1;
			case 2: slot = INDEX_SLOT_2;
			case 3: slot = INDEX_SLOT_3;
		}
		
		if (this.canSmelt(i)) {
			
			if (this.inventory[slot].stackSize <= 0) {
				this.inventory[slot] = null;
			}
			
			this.inventory[slot].setItemDamage(0);
		}
	}
	
	
	////////////
	// Others //
	////////////
	
	private int getSubBlock() {
		int metadata =  this.getBlockMetadata();
		return((IBlockMetadataHelper)ModJammyFurniture.blockIronBlocksOne).getEnabledMetadata(metadata);
	}
	
	
//	/**
//	 * Returns the maximum stack size for a inventory slot. Seems to always be
//	 * 64, possibly will be extended. *Isn't this more of a set than a get?*
//	 */
//	public int getInventoryStackLimit() {
//		return 64;
//	}
//
//	/**
//	 * Do not make give this method the name canInteractWith because it clashes
//	 * with Container
//	 */
//	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
//		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
//	}
//
//	/**
//	 * Causes the TileEntity to reset all it's cached values for it's container
//	 * block, blockID, metaData and in the case of chests, the adjcacent chest
//	 * check
//	 */
//	public void updateContainingBlockInfo() {
//		super.updateContainingBlockInfo();
//	}
//
//	public void onTileEntityPowered(int par1, int par2) {
//		if (par1 == 1) {
//			this.numUsingPlayers = par2;
//		}
//	}

//	public int getProgressSlot1(int par1) {
//		return this.slot0Time * par1 / this.getSmeltTime1();
//	}
//
//	public int getProgressSlot2(int par1) {
//		return this.slot2Time * par1 / this.getSmeltTime2();
//	}
//
//	public int getProgressSlot3(int par1) {
//		return this.slot3Time * par1 / this.getSmeltTime3();
//	}
//
//	public int getProgressSlot4(int par1) {
//		return this.slot4Time * par1 / this.getSmeltTime4();
//	}
//
//	public int dwGetProgressSlot1(int par1) {
//		return this.dwSlot1Time * par1 / this.dwGetSmeltTime1();
//	}
//
//	public int dwGetProgressSlot2(int par1) {
//		return this.dwSlot2Time * par1 / this.dwGetSmeltTime2();
//	}
//
//	public int dwGetProgressSlot3(int par1) {
//		return this.dwSlot3Time * par1 / this.dwGetSmeltTime3();
//	}
//
//	public int dwGetProgressSlot4(int par1) {
//		return this.dwSlot4Time * par1 / this.dwGetSmeltTime4();
//	}
//
//	public int getBurnTimeRemainingScaled(int par1) {
//		if (this.currentItemBurnTime == 0) {
//			this.currentItemBurnTime = 200;
//		}
//
//		return this.burnTime * par1 / this.currentItemBurnTime;
//	}
//
//	public int dwGetBurnTimeRemainingScaled(int par1) {
//		if (this.dwItemBurnTime == 0) {
//			this.dwItemBurnTime = 200;
//		}
//
//		return this.dwBurnTime * par1 / this.dwItemBurnTime;
//	}
//	
//	public int dwGetSmeltTime1() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondTools.length; ++i) {
//			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == diamondTools[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < goldTools.length; ++i) {
//			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == goldTools[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < steelTools.length; ++i) {
//			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == steelTools[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < stoneTools.length; ++i) {
//			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == stoneTools[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < woodTools.length; ++i) {
//			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == woodTools[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
//
//	public int dwGetSmeltTime2() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondTools.length; ++i) {
//			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == diamondTools[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < goldTools.length; ++i) {
//			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == goldTools[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < steelTools.length; ++i) {
//			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == steelTools[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < stoneTools.length; ++i) {
//			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == stoneTools[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < woodTools.length; ++i) {
//			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == woodTools[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
//
//	public int dwGetSmeltTime3() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondTools.length; ++i) {
//			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == diamondTools[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < goldTools.length; ++i) {
//			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == goldTools[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < steelTools.length; ++i) {
//			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == steelTools[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < stoneTools.length; ++i) {
//			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == stoneTools[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < woodTools.length; ++i) {
//			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == woodTools[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}

//	public int dwGetSmeltTime4() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondTools.length; ++i) {
//			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == diamondTools[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < goldTools.length; ++i) {
//			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == goldTools[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < steelTools.length; ++i) {
//			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == steelTools[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < stoneTools.length; ++i) {
//			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == stoneTools[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < woodTools.length; ++i) {
//			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == woodTools[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}

//
//	public int getSmeltTime1() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondArmour.length; ++i) {
//			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == diamondArmour[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < chainArmour.length; ++i) {
//			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == chainArmour[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < goldenArmour.length; ++i) {
//			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == goldenArmour[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < steelArmour.length; ++i) {
//			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == steelArmour[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < leatherArmour.length; ++i) {
//			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == leatherArmour[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
//
//	public int getSmeltTime2() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondArmour.length; ++i) {
//			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == diamondArmour[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < chainArmour.length; ++i) {
//			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == chainArmour[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < goldenArmour.length; ++i) {
//			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == goldenArmour[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < steelArmour.length; ++i) {
//			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == steelArmour[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < leatherArmour.length; ++i) {
//			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == leatherArmour[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
//
//	public int getSmeltTime3() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondArmour.length; ++i) {
//			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == diamondArmour[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < chainArmour.length; ++i) {
//			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == chainArmour[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < goldenArmour.length; ++i) {
//			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == goldenArmour[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < steelArmour.length; ++i) {
//			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == steelArmour[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < leatherArmour.length; ++i) {
//			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == leatherArmour[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
//
//	public int getSmeltTime4() {
//		short time = 1;
//		int i;
//
//		for (i = 0; i < diamondArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == diamondArmour[i]) {
//				time = 7200;
//			}
//		}
//
//		for (i = 0; i < chainArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == chainArmour[i]) {
//				time = 6000;
//			}
//		}
//
//		for (i = 0; i < goldenArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == goldenArmour[i]) {
//				time = 4800;
//			}
//		}
//
//		for (i = 0; i < steelArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == steelArmour[i]) {
//				time = 4000;
//			}
//		}
//
//		for (i = 0; i < leatherArmour.length; ++i) {
//			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == leatherArmour[i]) {
//				time = 1500;
//			}
//		}
//
//		return time;
//	}
	
}
