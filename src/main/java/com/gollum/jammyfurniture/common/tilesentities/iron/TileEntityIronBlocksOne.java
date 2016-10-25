package com.gollum.jammyfurniture.common.tilesentities.iron;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;

import static com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.TYPE;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksOne.EnumType;
import com.gollum.jammyfurniture.common.crafting.CookerRecipes;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class TileEntityIronBlocksOne extends GCLInventoryTileEntity {
	
	public static final int INV_SIZE_FRIDGE     = 9;
	public static final int INV_SIZE_COOKER     = 5;
	public static final int INV_SIZE_RUBBISHBIN = 27;
	
	public static final int INDEX_SLOT_BURN    = 1;
	public static final int INDEX_SLOT_BEFORE0 = 0;
	public static final int INDEX_SLOT_BEFORE1 = 3;
	public static final int INDEX_SLOT_AFTER0  = 2;
	public static final int INDEX_SLOT_AFTER1  = 4;
	
	public static final int COOKING_SPEED0  = 200;
	public static final int COOKING_SPEED1  = 150;
	
	public int currentItemBurnTime = 0;
	public int cookerBurnTime = 0;
	public int cookerCookTime0 = 0;
	public int cookerCookTime1 = 0;
	
	// Date du dernier effacement de la corbeille
	long lastClearance = System.currentTimeMillis();
	// Orientation de la poubelle
	public short rubishBinOrientation = 0;
	
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
		
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getBlock() instanceof IronBlocksOne) {
				EnumType type = (EnumType) state.getValue(TYPE);
				if (type == EnumType.FRIDGE || type == EnumType.FREEZER) {
					return this.INV_SIZE_FRIDGE;
				} else if (type == EnumType.COOKER) {
					return this.INV_SIZE_COOKER;
				} else if (type == EnumType.RUBBISH_BIN) {
					return this.INV_SIZE_RUBBISHBIN;
				}
			}
		}
		return super.getSizeInventory();
	}
	
	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return 
			(slot == INDEX_SLOT_BURN && this.isItemFuel(itemStack)) ||
			(slot == INDEX_SLOT_BEFORE0 && CookerRecipes.smelting().getSmeltingResult(itemStack) == null) ||
			(slot == INDEX_SLOT_BEFORE1 && CookerRecipes.smelting().getSmeltingResult(itemStack) == null)
		;
	}
	
	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getName() {
		
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getBlock() instanceof IronBlocksOne) {
				EnumType type = (EnumType) state.getValue(TYPE);
				if (type == EnumType.FRIDGE) {
					return ModJammyFurniture.i18n.trans("Fridge");
				} else 
				if (type == EnumType.FREEZER) {
					return ModJammyFurniture.i18n.trans("Freezer");
				} else
				if (type == EnumType.COOKER) {
					return ModJammyFurniture.i18n.trans("Cooker");
				} else
				if (type == EnumType.RUBBISH_BIN) {
					return ModJammyFurniture.i18n.trans("Rubbish Bin");
				}
			}
		}
		return "ERROR";
	}
	
	protected void playSoundClosedInventory() {
		String oldSound = this.soundClosedInventory;
		float oldVolume = this.volumeSoundOpenClosedInventory;
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getValue(TYPE) == EnumType.RUBBISH_BIN) {
				this.soundClosedInventory = ModJammyFurniture.MODID.toLowerCase()+":trashclosed";
				this.volumeSoundOpenClosedInventory = 1.5F;
			}
		}
		
		super.playSoundClosedInventory();
		
		this.soundClosedInventory = oldSound;
		this.volumeSoundOpenClosedInventory = oldVolume;
	}
	
	protected void playSoundOpenInventory() {
		String oldSound = this.soundOpenInventory;
		float oldVolume = this.volumeSoundOpenClosedInventory;
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getValue(TYPE) == EnumType.RUBBISH_BIN) {
				this.soundOpenInventory = ModJammyFurniture.MODID.toLowerCase()+":trashopen";
				this.volumeSoundOpenClosedInventory = 1.5F;
			}
		}
		
		super.playSoundOpenInventory();
		
		this.soundOpenInventory = oldSound;
		this.volumeSoundOpenClosedInventory = oldVolume;
	}
	
	////////////
	// Update //
	////////////
	
	public void update() {
		
		super.update();
		
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getBlock() instanceof IronBlocksOne) {
				EnumType type = (EnumType) state.getValue(TYPE);
				
				if (type == EnumType.RUBBISH_BIN) {
					
					if (System.currentTimeMillis() - this.lastClearance >= 60000L) {
						this.clear();
						this.lastClearance = System.currentTimeMillis();
					}
					
					return;
				}
				
				if (type == EnumType.COOKER) {
					
					boolean inventoryChange = false;
					
					if (this.isBurning ()) {
						--this.cookerBurnTime;
					}
		
					if (!this.worldObj.isRemote) {
						
						// Test si on doit alumer et recupérer un combustible
						if (this.cookerBurnTime == 0 && (this.canSmelt(0) || this.canSmelt(1))) {
							this.currentItemBurnTime = this.cookerBurnTime = this.getItemBurnTime(this.inventory[INDEX_SLOT_BURN]);
							
							if (this.cookerBurnTime > 0) {
								inventoryChange = true;
								
								// On peux brulé l'élément donc on enleve 
								if (this.inventory[INDEX_SLOT_BURN] != null) {
									
									--this.inventory[INDEX_SLOT_BURN].stackSize;
									if (this.inventory[INDEX_SLOT_BURN].stackSize == 0) {
										this.inventory[INDEX_SLOT_BURN] = this.inventory[INDEX_SLOT_BURN].getItem().getContainerItem(this.inventory[INDEX_SLOT_BURN]);
									}
								}
							}
						}
						
						// Emplacement 0
						if (this.isBurning() && this.canSmelt(0)) {
							++this.cookerCookTime0;
		
							if (this.cookerCookTime0 == COOKING_SPEED0) {
								this.cookerCookTime0 = 0;
								this.smeltItem(0);
								inventoryChange = true;
							}
						} else {
							// Ca ne brule plus donc l'élement courant ne cuit plus
							this.cookerCookTime0 = 0;
						}
		
						// Emplacement 1
						if (this.isBurning() && this.canSmelt(1)) {
							++this.cookerCookTime1;
							
							if (this.cookerCookTime1 >= COOKING_SPEED1) {
								this.cookerCookTime1 = 0;
								this.smeltItem(1);
								inventoryChange = true;
							}
						} else {
							// Ca ne brule plus donc l'élement courant ne cuit plus
							this.cookerCookTime1 = 0;
						}
					}
		
					if (inventoryChange) {
						this.markDirty();
					}
				}
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
		
		this.readItems(nbtTagCompound, "FriFreItems", true); // Compatibility
		this.readItems(nbtTagCompound, "CookerItems", true); // Compatibility
		this.readItems(nbtTagCompound, "BinItems"   , true); // Compatibility
		
		this.cookerBurnTime  = nbtTagCompound.getShort("BurnTime");
		this.cookerCookTime0 = nbtTagCompound.getShort("CookTime");
		this.cookerCookTime1 = nbtTagCompound.getShort("CookTime2");
		
		this.rubishBinOrientation = nbtTagCompound.getShort("rubishBinOrientation");
		
		this.currentItemBurnTime = getItemBurnTime(this.inventory[INDEX_SLOT_BURN]);
		
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setShort("BurnTime" , (short) this.cookerBurnTime);
		nbtTagCompound.setShort("CookTime" , (short) this.cookerCookTime0);
		nbtTagCompound.setShort("CookTime2", (short) this.cookerCookTime1);
		
		nbtTagCompound.setShort("rubishBinOrientation", this.rubishBinOrientation);
	}
	
	/////////////
	// Network //
	/////////////
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.pos, 0, nbttagcompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
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
//	
	/** 
	 * Test si le four peux cuire l'element déposé
	 * @param i 
	 */
	private boolean canSmelt(int i) {
		
		int before = (i == 0) ? INDEX_SLOT_BEFORE0 : INDEX_SLOT_BEFORE1;
		int after  = (i == 0) ? INDEX_SLOT_AFTER0  : INDEX_SLOT_AFTER1;
		
		if (this.inventory[before] == null) {
			return false;
		}
		
		ItemStack itemCooked = CookerRecipes.smelting().getSmeltingResult(this.inventory[before]);
		
		if (itemCooked == null) {
			return false;
		}
		if (this.inventory[after] == null) {
			return true;
		}
		if (!this.inventory[after].isItemEqual(itemCooked)) {
			return false;
		}
		
		int total = inventory[after].stackSize + itemCooked.stackSize;
		
		return (total <= getInventoryStackLimit() && total <= itemCooked.getMaxStackSize());
	}
	
	public void smeltItem(int i) {
		
		int before = (i == 0) ? INDEX_SLOT_BEFORE0 : INDEX_SLOT_BEFORE1;
		int after  = (i == 0) ? INDEX_SLOT_AFTER0  : INDEX_SLOT_AFTER1;
		
		if (this.canSmelt(i)) {
			ItemStack itemStack = CookerRecipes.smelting().getSmeltingResult(this.inventory[before]);

			// Insert l'élément cuit dans le slot 2
			if (this.inventory[after] == null) {
				this.inventory[after] = itemStack.copy();
			} else if (this.inventory[after].isItemEqual(itemStack)) {
				inventory[after].stackSize += itemStack.stackSize;
			}

			--this.inventory[before].stackSize;

			if (this.inventory[before].stackSize <= 0) {
				this.inventory[before] = null;
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
	
	public int getCookProgressScaled0(int par1) {
		return this.cookerCookTime0 * par1 / COOKING_SPEED0;
	}
	
	public int getCookProgressScaled1(int par1) {
		return this.cookerCookTime1 * par1 / COOKING_SPEED1;
	}
		
}
