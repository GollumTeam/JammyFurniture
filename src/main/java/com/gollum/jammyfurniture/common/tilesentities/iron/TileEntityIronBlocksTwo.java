package com.gollum.jammyfurniture.common.tilesentities.iron;

import static com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo.TYPE;

import com.gollum.core.common.tileentities.GCLInventoryTileEntity;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo;
import com.gollum.jammyfurniture.common.block.iron.IronBlocksTwo.EnumType;
import com.gollum.jammyfurniture.common.crafting.DishwasherRecipes;
import com.gollum.jammyfurniture.common.crafting.WashingMachineRecipes;
import com.gollum.jammyfurniture.inits.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityIronBlocksTwo extends GCLInventoryTileEntity {
	
	public static final int INDEX_SLOT_BURN = 1;
	public static final int INDEX_SLOT_0    = 0;
	public static final int INDEX_SLOT_1    = 2;
	public static final int INDEX_SLOT_2    = 3;
	public static final int INDEX_SLOT_3    = 4;
	
	/////////////////////////////////
	// Temps actif dans la machine //
	/////////////////////////////////
	public int currentItemBurnTime = 0;
	public int burnTime = 0;
	public int slot0Time = 0;
	public int slot1Time = 0;
	public int slot2Time = 0;
	public int slot3Time = 0;
	
	private long soundTimeMachine = 0;
	
	public TileEntityIronBlocksTwo() {
		super (5);
	}
	
	///////////////
	// Inventory //
	///////////////
	
	@Override
	public String getCommandSenderName() {
		
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getBlock() instanceof IronBlocksTwo) {
				EnumType type = state.getValue(TYPE);
				if (type == EnumType.DISHWASHER) {
					return ModJammyFurniture.i18n.trans("Dishwasher");
				} else
				if (type == EnumType.WASHING_MACHINE) {
					return ModJammyFurniture.i18n.trans("Washing Machine");
				}
			}
		}
		
		return "ERROR";
	}
	
	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		IBlockState state = this.worldObj.getBlockState(this.pos);
		EnumType type = state.getValue(TYPE);
		return 
			(slot == INDEX_SLOT_BURN && this.isItemFuel(itemStack)) ||
			(
				slot != INDEX_SLOT_BURN && (
					(type == EnumType.DISHWASHER      && DishwasherRecipes    .smelting().getSmeltingResult(itemStack) == null) ||
					(type == EnumType.WASHING_MACHINE && WashingMachineRecipes.smelting().getSmeltingResult(itemStack) == null)
				)
			)
		;
	}
	
	////////////
	// Update //
	////////////
	
	@Override
	public void update() {
		
		super.update();
		
		int metadata = this.getBlockMetadata();
		boolean inventoryChange = false;
		
		
		if (!this.worldObj.isRemote) {
			
			if (this.isBurning ()) {
				--this.burnTime;
				
				double x = (double) this.pos.getX() + 0.5D;
				double y = (double) this.pos.getY() + 0.5D;
				double z = (double) this.pos.getZ() + 0.5D;
				
				if (System.currentTimeMillis() - this.soundTimeMachine >= 13000 && this.canSmelt()) {
					this.worldObj.playSoundEffect(x, y, z, ModJammyFurniture.MODID.toLowerCase()+":machine", 0.6F, this.worldObj.rand.nextFloat() * 0.1F + 0.8F);
					this.soundTimeMachine = System.currentTimeMillis();
					
				}
			}
			
			
			
			// Test si on doit alumer et recupérer un combustible
			if (!isBurning () && this.canSmelt()) {
				
				this.currentItemBurnTime = this.burnTime = this.getItemBurnTime(this.inventory[INDEX_SLOT_BURN]);
				
				if (this.burnTime > 0) {
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
				++this.slot0Time;
				
				if (this.slot0Time >= this.getSmeltTime (0)) {
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
				
				if (this.slot1Time >= this.getSmeltTime (1)) {
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
				
				if (this.slot2Time >= this.getSmeltTime (2)) {
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

				if (this.slot3Time >= this.getSmeltTime (3)) {
					this.slot3Time = 0;
					this.smeltItem(3);
					inventoryChange = true;
				}
			} else {
				// Ca ne brule plus donc l'élement courant ne cuit plus
				this.slot3Time = 0;
			}
			
			if (inventoryChange) {
				this.markDirty();
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
		
		this.burnTime  = nbtTagCompound.getShort("burnTime");
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
		
		nbtTagCompound.setShort("burnTime" , (short) this.burnTime);
		nbtTagCompound.setShort("slot0Time", (short) this.slot0Time);
		nbtTagCompound.setShort("slot1Time", (short) this.slot1Time);
		nbtTagCompound.setShort("slot2Time", (short) this.slot2Time);
		nbtTagCompound.setShort("slot3Time", (short) this.slot3Time);
		
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
		return this.burnTime > 0;
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
	
	public int getSmeltTime (int i) {
		
		int slot;
		switch (i) {
			default:
			case 0: slot = INDEX_SLOT_0; break;
			case 1: slot = INDEX_SLOT_1; break;
			case 2: slot = INDEX_SLOT_2; break;
			case 3: slot = INDEX_SLOT_3; break;
		}

		int time = WashingMachineRecipes.smelting().getSmeltingTime(this.inventory[slot]);
		
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getValue(TYPE) == EnumType.DISHWASHER) {
				time = DishwasherRecipes.smelting().getSmeltingTime(this.inventory[slot]);	
			}
		}
		
		return time;
	}
	
	/** 
	 * Test si le four peux cuire l'element déposé
	 * @param i 
	 */
	public boolean canSmelt(int i) {
		
		int slot;
		switch (i) {
			default:
			case 0: slot = INDEX_SLOT_0; break;
			case 1: slot = INDEX_SLOT_1; break;
			case 2: slot = INDEX_SLOT_2; break;
			case 3: slot = INDEX_SLOT_3; break;
		}
		
		if (this.inventory[slot] == null) {
			return false;
		}
		
		ItemStack itemBurned = WashingMachineRecipes.smelting().getSmeltingResult(this.inventory[slot]);
		if (this.worldObj != null) {
			IBlockState state = this.worldObj.getBlockState(this.pos);
			if (state != null && state.getValue(TYPE) == EnumType.DISHWASHER) {
				itemBurned = DishwasherRecipes.smelting().getSmeltingResult(this.inventory[slot]);
			}
		}
		
		return itemBurned != null;
	}
	
	public boolean canSmelt() {
		return 
			this.canSmelt(0) ||
			this.canSmelt(1) ||
			this.canSmelt(2) ||
			this.canSmelt(3)
		;
	}
	
	public void smeltItem(int i) {
		int slot;
		switch (i) {
			default:
			case 0: slot = INDEX_SLOT_0; break;
			case 1: slot = INDEX_SLOT_1; break;
			case 2: slot = INDEX_SLOT_2; break;
			case 3: slot = INDEX_SLOT_3; break;
		}

		if (this.canSmelt(i)) {
			
			if (this.inventory[slot].stackSize <= 0) {
				this.inventory[slot] = null;
			}
			
			this.inventory[slot].setItemDamage(0);
		}
	}

	//////////////////////
	// Data for display //
	//////////////////////
	
	public int getBurnTimeRemainingScaled(int maxSize) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}
		
		return this.burnTime * maxSize / this.currentItemBurnTime;
	}
	
	public int getProgressSlot0(int par1) {
		int time = this.getSmeltTime (0);
		return (time == 0) ? 0 : this.slot0Time * par1 / time;
	}
	
	public int getProgressSlot1(int par1) {
		int time = this.getSmeltTime (1);
		return (time == 0) ? 0 : this.slot1Time * par1 / time;
	}
	
	public int getProgressSlot2(int par1) {
		int time = this.getSmeltTime (2);
		return (time == 0) ? 0 : this.slot2Time * par1 / time;
	}
	
	public int getProgressSlot3(int par1) {
		int time = this.getSmeltTime (3);
		return (time == 0) ? 0 : this.slot3Time * par1 / time;
	}
	
}
