package mods.jammyfurniture.common.tilesentities;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.crafting.jfm_DishwasherRecipes;
import mods.jammyfurniture.common.crafting.jfm_WashingMachineRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIronBlocksTwo extends TileEntity implements IInventory {
	
	public static int md = 0;
	
	public float lidAngle;
	
	public float prevLidAngle;
	
	public int numUsingPlayers;
	
	private int ticksSinceSync;
	
	//////////////
	// ???????? //
	//////////////

	public int currentItemBurnTime;
	/**  @deprecated */
	public int dwItemBurnTime;
	
	//////////////////////////////
	// Liste des items du block //
	//////////////////////////////
	/**  @deprecated */
	public ItemStack[] itemStacks;
	public ItemStack[] dwItemStacks;
	
	/////////////////////////////////////////
	// A revoir pour gérer tous les amures //
	/////////////////////////////////////////
	
	public static int[] woodTools = new int[] { 270, 269, 271, 290, 268 };
	public static int[] stoneTools = new int[] { 274, 273, 275, 291, 272 };
	public static int[] steelTools = new int[] { 257, 256, 258, 292, 267 };
	public static int[] goldTools = new int[] { 285, 284, 286, 294, 283 };
	public static int[] diamondTools = new int[] { 278, 277, 279, 293, 276 };
	public static int[] diamondArmour = new int[] { 310, 311, 312, 313 };
	public static int[] chainArmour = new int[] { 302, 303, 304, 305 };
	public static int[] goldenArmour = new int[] { 314, 315, 316, 317 };
	public static int[] steelArmour = new int[] { 306, 307, 308, 309 };
	public static int[] leatherArmour = new int[] { 298, 299, 300, 301 };

	/////////////////////////////////
	// Temps actif dans la machine //
	/////////////////////////////////

	

	public int slot1Time;
	public int slot2Time;
	public int slot3Time;
	public int slot4Time;
	public int burnTime;

	/**  @deprecated */
	public int dwSlot1Time;
	/**  @deprecated */
	public int dwSlot2Time;
	/**  @deprecated */
	public int dwSlot3Time;
	/**  @deprecated */
	public int dwSlot4Time;
	/**  @deprecated */
	public int dwBurnTime;
	
	public TileEntityIronBlocksTwo() {
		this.itemStacks = new ItemStack[5];
		this.burnTime = 0;
		this.currentItemBurnTime = 0;
		
		this.slot1Time = 0;
		this.slot2Time = 0;
		this.slot3Time = 0;
		this.slot4Time = 0;
		
		this.dwItemStacks = new ItemStack[5];
		this.dwBurnTime = 0;
		this.dwItemBurnTime = 0;
		this.dwSlot1Time = 0;
		this.dwSlot2Time = 0;
		this.dwSlot3Time = 0;
		this.dwSlot4Time = 0;
	}

	public TileEntityIronBlocksTwo(int meta) {
		md = meta;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		
		if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord)) {
			
			int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
			return metadata <= 3 ? this.dwItemStacks.length : (metadata != 4 && metadata != 5 && metadata != 6 && metadata != 7 ? 0 : this.itemStacks.length);
			
		} else {
			return 0;
		}
	}

	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1) {
		if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord)) {
			switch (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)) {
			case 0:
			case 1:
			case 2:
			case 3:
				return this.dwItemStacks[par1];

			case 4:
			case 5:
			case 6:
			case 7:
				return this.itemStacks[par1];

			default:
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2) {
		ItemStack itemstack1;

		if (this.dwItemStacks[par1] != null) {
			if (this.dwItemStacks[par1].stackSize <= par2) {
				itemstack1 = this.dwItemStacks[par1];
				this.dwItemStacks[par1] = null;
				this.onInventoryChanged();
				return itemstack1;
			} else {
				itemstack1 = this.dwItemStacks[par1].splitStack(par2);

				if (this.dwItemStacks[par1].stackSize == 0) {
					this.dwItemStacks[par1] = null;
				}

				this.onInventoryChanged();
				return itemstack1;
			}
		} else if (this.itemStacks[par1] != null) {
			if (this.itemStacks[par1].stackSize <= par2) {
				itemstack1 = this.itemStacks[par1];
				this.itemStacks[par1] = null;
				this.onInventoryChanged();
				return itemstack1;
			} else {
				itemstack1 = this.itemStacks[par1].splitStack(par2);

				if (this.itemStacks[par1].stackSize == 0) {
					this.itemStacks[par1] = null;
				}

				this.onInventoryChanged();
				return itemstack1;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1) {
		ItemStack itemstack;

		if (this.dwItemStacks[par1] != null) {
			itemstack = this.dwItemStacks[par1];
			this.dwItemStacks[par1] = null;
			return itemstack;
		} else if (this.itemStacks[par1] != null) {
			itemstack = this.itemStacks[par1];
			this.itemStacks[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);

		if (meta <= 3) {
			this.dwItemStacks[par1] = par2ItemStack;
		} else if (meta == 4 || meta == 5 || meta == 6 || meta == 7) {
			this.itemStacks[par1] = par2ItemStack;
		}

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}

		this.onInventoryChanged();
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		switch (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)) {
		case 0:
		case 1:
		case 2:
		case 3:
			return "Dishwasher";

		case 4:
		case 5:
		case 6:
		case 7:
			return "Washing Machine";

		default:
			return "ERROR";
		}
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("dwItems");
		NBTTagList nbttaglist2 = par1NBTTagCompound.getTagList("wmItems");
		this.dwItemStacks = new ItemStack[5];
		this.itemStacks = new ItemStack[5];
		int i;
		NBTTagCompound nbttagcompound2;

		for (i = 0; i < nbttaglist.tagCount(); ++i) {
			nbttagcompound2 = (NBTTagCompound) nbttaglist.tagAt(i);
			int byte0 = nbttagcompound2.getByte("Slot") & 255;

			if (byte0 >= 0 && byte0 < this.dwItemStacks.length) {
				this.dwItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound2);
			}
		}

		this.dwBurnTime = par1NBTTagCompound.getShort("dwBurnTime");
		this.dwSlot1Time = par1NBTTagCompound.getShort("dwSlot1Time");
		this.dwSlot2Time = par1NBTTagCompound.getShort("dwSlot2Time");
		this.dwSlot3Time = par1NBTTagCompound.getShort("dwSlot3Time");
		this.dwSlot4Time = par1NBTTagCompound.getShort("dwSlot4Time");
		this.dwItemBurnTime = getItemBurnTime(this.dwItemStacks[1]);

		for (i = 0; i < nbttaglist2.tagCount(); ++i) {
			nbttagcompound2 = (NBTTagCompound) nbttaglist2.tagAt(i);
			byte var7 = nbttagcompound2.getByte("Slot");

			if (var7 >= 0 && var7 < this.itemStacks.length) {
				this.itemStacks[var7] = ItemStack.loadItemStackFromNBT(nbttagcompound2);
			}
		}

		this.burnTime = par1NBTTagCompound.getShort("wmBurnTime");
		this.slot1Time = par1NBTTagCompound.getShort("wmSlot1Time");
		this.slot2Time = par1NBTTagCompound.getShort("wmSlot2Time");
		this.slot3Time = par1NBTTagCompound.getShort("wmSlot3Time");
		this.slot4Time = par1NBTTagCompound.getShort("wmSlot4Time");
		this.currentItemBurnTime = getItemBurnTime(this.itemStacks[1]);
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();
		int meta = 1;

		if (this.worldObj != null && this.worldObj.blockExists(this.xCoord, this.yCoord, this.zCoord)) {
			meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		}

		int i;
		NBTTagCompound nbttagcompound;

		if (meta <= 3) {
			par1NBTTagCompound.setShort("dwBurnTime", (short) this.dwBurnTime);
			par1NBTTagCompound.setShort("dwSlot1Time", (short) this.dwSlot1Time);
			par1NBTTagCompound.setShort("dwSlot2Time", (short) this.dwSlot2Time);
			par1NBTTagCompound.setShort("dwSlot3Time", (short) this.dwSlot3Time);
			par1NBTTagCompound.setShort("dwSlot4Time", (short) this.dwSlot4Time);

			for (i = 0; i < this.dwItemStacks.length; ++i) {
				if (this.dwItemStacks[i] != null) {
					nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.dwItemStacks[i].writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			par1NBTTagCompound.setTag("dwItems", nbttaglist);
		} else if (meta == 4 || meta == 5 || meta == 6 || meta == 7) {
			par1NBTTagCompound.setShort("wmBurnTime", (short) this.burnTime);
			par1NBTTagCompound.setShort("wmSlot1Time", (short) this.slot1Time);
			par1NBTTagCompound.setShort("wmSlot2Time", (short) this.slot2Time);
			par1NBTTagCompound.setShort("wmSlot3Time", (short) this.slot3Time);
			par1NBTTagCompound.setShort("wmSlot4Time", (short) this.slot4Time);

			for (i = 0; i < this.itemStacks.length; ++i) {
				if (this.itemStacks[i] != null) {
					nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					this.itemStacks[i].writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			par1NBTTagCompound.setTag("wmItems", nbttaglist);
		}
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be
	 * 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	/**
	 * Causes the TileEntity to reset all it's cached values for it's container
	 * block, blockID, metaData and in the case of chests, the adjcacent chest
	 * check
	 */
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	public void onTileEntityPowered(int par1, int par2) {
		if (par1 == 1) {
			this.numUsingPlayers = par2;
		}
	}

	public int getProgressSlot1(int par1) {
		return this.slot1Time * par1 / this.getSmeltTime1();
	}

	public int getProgressSlot2(int par1) {
		return this.slot2Time * par1 / this.getSmeltTime2();
	}

	public int getProgressSlot3(int par1) {
		return this.slot3Time * par1 / this.getSmeltTime3();
	}

	public int getProgressSlot4(int par1) {
		return this.slot4Time * par1 / this.getSmeltTime4();
	}

	public int dwGetProgressSlot1(int par1) {
		return this.dwSlot1Time * par1 / this.dwGetSmeltTime1();
	}

	public int dwGetProgressSlot2(int par1) {
		return this.dwSlot2Time * par1 / this.dwGetSmeltTime2();
	}

	public int dwGetProgressSlot3(int par1) {
		return this.dwSlot3Time * par1 / this.dwGetSmeltTime3();
	}

	public int dwGetProgressSlot4(int par1) {
		return this.dwSlot4Time * par1 / this.dwGetSmeltTime4();
	}

	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return this.burnTime * par1 / this.currentItemBurnTime;
	}

	public int dwGetBurnTimeRemainingScaled(int par1) {
		if (this.dwItemBurnTime == 0) {
			this.dwItemBurnTime = 200;
		}

		return this.dwBurnTime * par1 / this.dwItemBurnTime;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public boolean dwIsBurning() {
		return this.dwBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	public void updateEntity() {
		
		int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		
		if (metadata <= 3) {
			
			if (++this.ticksSinceSync % 20 * 4 == 0) {
				;
			}

			this.prevLidAngle = this.lidAngle;
			float flag = 0.1F;
			double flag1;

			if (this.numUsingPlayers > 0 && this.lidAngle == 0.0F) {
				double flag2 = (double) this.xCoord + 0.5D;
				flag1 = (double) this.zCoord + 0.5D;
				this.worldObj.playSoundEffect(flag2, (double) this.yCoord + 0.5D, flag1, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (this.numUsingPlayers == 0 && this.lidAngle > 0.0F || this.numUsingPlayers > 0 && this.lidAngle < 1.0F) {
				float var11 = this.lidAngle;

				if (this.numUsingPlayers > 0) {
					this.lidAngle += flag;
				} else {
					this.lidAngle -= flag;
				}

				if (this.lidAngle > 1.0F) {
					this.lidAngle = 1.0F;
				}

				float flag3 = 0.5F;

				if (this.lidAngle < flag3 && var11 >= flag3) {
					flag1 = (double) this.xCoord + 0.5D;
					double playing1 = (double) this.zCoord + 0.5D;
					this.worldObj.playSoundEffect(flag1, (double) this.yCoord + 0.5D, playing1, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
				}

				if (this.lidAngle < 0.0F) {
					this.lidAngle = 0.0F;
				}
			}

			boolean var12 = this.dwBurnTime > 0;
			boolean var13 = false;

			if (this.dwBurnTime > 0) {
				--this.dwBurnTime;
			}

			if (!this.worldObj.isRemote) {
				if (this.dwBurnTime == 0 && (this.dwCanSmeltSlot1() || this.dwCanSmeltSlot2() || this.dwCanSmeltSlot3() || this.dwCanSmeltSlot4())) {
					this.dwItemBurnTime = this.dwBurnTime = getItemBurnTime(this.dwItemStacks[1]);

					if (this.dwBurnTime > 0) {
						var13 = true;

						if (this.dwItemStacks[1] != null) {
							--this.dwItemStacks[1].stackSize;

							if (this.dwItemStacks[1].stackSize == 0) {
								this.dwItemStacks[1] = this.dwItemStacks[1].getItem().getContainerItemStack(this.dwItemStacks[1]);
							}
						}
					}
				}

				boolean var14 = false;
				
//				ModJammyFurniture.log.debug("his.dwIsBurning()="+this.dwIsBurning()+" !var14="+!var14);
				
				if (this.dwIsBurning() && !var14) {
					var14 = true;
					
					if (var14) {
						this.worldObj.playSoundEffect((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, "jammyfurniture:washingmachine", 0.2F, 1.0F);
					}
				} else if (!this.dwIsBurning()) {
					var14 = false;
				}

				if (this.dwCanSmeltSlot1() && this.dwIsBurning()) {
					++this.dwSlot1Time;

					if (this.dwSlot1Time == this.dwGetSmeltTime1()) {
						this.dwSlot1Time = 0;
						this.dwFixArmourSlot1();
						var13 = true;
					}
				} else {
					this.dwSlot1Time = 0;
				}

				if (this.dwCanSmeltSlot2() && this.dwIsBurning()) {
					++this.dwSlot2Time;

					if (this.dwSlot2Time == this.dwGetSmeltTime2()) {
						this.dwSlot2Time = 0;
						this.dwFixArmourSlot2();
						var13 = true;
					}
				} else {
					this.dwSlot2Time = 0;
				}

				if (this.dwCanSmeltSlot3() && this.dwIsBurning()) {
					++this.dwSlot3Time;

					if (this.dwSlot3Time == this.dwGetSmeltTime3()) {
						this.dwSlot3Time = 0;
						this.dwFixArmourSlot3();
						var13 = true;
					}
				} else {
					this.dwSlot3Time = 0;
				}

				if (this.dwCanSmeltSlot4() && this.dwIsBurning()) {
					++this.dwSlot4Time;

					if (this.dwSlot4Time == this.dwGetSmeltTime4()) {
						this.dwSlot4Time = 0;
						this.dwFixArmourSlot4();
						var13 = true;
					}
				} else {
					this.dwSlot4Time = 0;
				}
			}

			if (var13) {
				this.onInventoryChanged();
			}
		}
		
		if (metadata == 4 || metadata == 5 || metadata == 6 || metadata == 7) {
			
			boolean var9 = this.burnTime > 0;
			boolean var10 = false;
			
			if (this.burnTime > 0) {
				--this.burnTime;
			}

			if (!this.worldObj.isRemote) {
				if (this.burnTime == 0 && (this.canSmeltSlot1() || this.canSmeltSlot2() || this.canSmeltSlot3() || this.canSmeltSlot4())) {
					this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.itemStacks[1]);

					if (this.burnTime > 0) {
						var10 = true;

						if (this.itemStacks[1] != null) {
							--this.itemStacks[1].stackSize;

							if (this.itemStacks[1].stackSize == 0) {
								this.itemStacks[1] = this.itemStacks[1].getItem().getContainerItemStack(this.itemStacks[1]);
							}
						}
					}
				}

				boolean playing = false;

				if (this.isBurning() && !playing) {
					playing = true;

					if (playing) {
						this.worldObj.playSoundEffect((double) this.xCoord, (double) this.yCoord, (double) this.zCoord, "jfm.washingmachine", 1.0F, 0.2F);
					}
				} else if (!this.isBurning()) {
					playing = false;
				}

				if (this.canSmeltSlot1() && this.isBurning()) {
					++this.slot1Time;

					if (this.slot1Time == this.getSmeltTime1()) {
						this.slot1Time = 0;
						this.fixArmourSlot1();
						var10 = true;
					}
				} else {
					this.slot1Time = 0;
				}

				if (this.canSmeltSlot2() && this.isBurning()) {
					++this.slot2Time;

					if (this.slot2Time == this.getSmeltTime2()) {
						this.slot2Time = 0;
						this.fixArmourSlot2();
						var10 = true;
					}
				} else {
					this.slot2Time = 0;
				}

				if (this.canSmeltSlot3() && this.isBurning()) {
					++this.slot3Time;

					if (this.slot3Time == this.getSmeltTime3()) {
						this.slot3Time = 0;
						this.fixArmourSlot3();
						var10 = true;
					}
				} else {
					this.slot3Time = 0;
				}

				if (this.canSmeltSlot4() && this.isBurning()) {
					++this.slot4Time;

					if (this.slot4Time == this.getSmeltTime4()) {
						this.slot4Time = 0;
						this.fixArmourSlot4();
						var10 = true;
					}
				} else {
					this.slot4Time = 0;
				}
			}

			if (var10) {
				this.onInventoryChanged();
			}
		}
	}

	public int dwGetSmeltTime1() {
		short time = 1;
		int i;

		for (i = 0; i < diamondTools.length; ++i) {
			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == diamondTools[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < goldTools.length; ++i) {
			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == goldTools[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < steelTools.length; ++i) {
			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == steelTools[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < stoneTools.length; ++i) {
			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == stoneTools[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < woodTools.length; ++i) {
			if (this.dwItemStacks[0] != null && this.dwItemStacks[0].itemID == woodTools[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int dwGetSmeltTime2() {
		short time = 1;
		int i;

		for (i = 0; i < diamondTools.length; ++i) {
			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == diamondTools[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < goldTools.length; ++i) {
			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == goldTools[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < steelTools.length; ++i) {
			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == steelTools[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < stoneTools.length; ++i) {
			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == stoneTools[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < woodTools.length; ++i) {
			if (this.dwItemStacks[2] != null && this.dwItemStacks[2].itemID == woodTools[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int dwGetSmeltTime3() {
		short time = 1;
		int i;

		for (i = 0; i < diamondTools.length; ++i) {
			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == diamondTools[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < goldTools.length; ++i) {
			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == goldTools[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < steelTools.length; ++i) {
			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == steelTools[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < stoneTools.length; ++i) {
			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == stoneTools[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < woodTools.length; ++i) {
			if (this.dwItemStacks[3] != null && this.dwItemStacks[3].itemID == woodTools[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int dwGetSmeltTime4() {
		short time = 1;
		int i;

		for (i = 0; i < diamondTools.length; ++i) {
			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == diamondTools[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < goldTools.length; ++i) {
			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == goldTools[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < steelTools.length; ++i) {
			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == steelTools[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < stoneTools.length; ++i) {
			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == stoneTools[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < woodTools.length; ++i) {
			if (this.dwItemStacks[4] != null && this.dwItemStacks[4].itemID == woodTools[i]) {
				time = 1500;
			}
		}

		return time;
	}

	private boolean dwCanSmeltSlot1() {
		if (this.dwItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_DishwasherRecipes.smelting().getSmeltingResult(this.dwItemStacks[0].getItem().itemID);
			return this.dwItemStacks[0].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean dwCanSmeltSlot2() {
		if (this.dwItemStacks[2] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_DishwasherRecipes.smelting().getSmeltingResult(this.dwItemStacks[2].getItem().itemID);
			return this.dwItemStacks[2].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean dwCanSmeltSlot3() {
		if (this.dwItemStacks[3] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_DishwasherRecipes.smelting().getSmeltingResult(this.dwItemStacks[3].getItem().itemID);
			return this.dwItemStacks[3].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean dwCanSmeltSlot4() {
		if (this.dwItemStacks[4] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_DishwasherRecipes.smelting().getSmeltingResult(this.dwItemStacks[4].getItem().itemID);
			return this.dwItemStacks[4].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	public void dwFixArmourSlot1() {
		if (this.dwCanSmeltSlot1()) {
			if (this.dwItemStacks[0].stackSize <= 0) {
				this.dwItemStacks[0] = null;
			}

			if (this.dwItemStacks[0].getItemDamageForDisplay() != 0) {
				this.dwItemStacks[0].setItemDamage(0);
			}
		}
	}

	public void dwFixArmourSlot2() {
		if (this.dwCanSmeltSlot2()) {
			if (this.dwItemStacks[2].stackSize <= 0) {
				this.dwItemStacks[2] = null;
			}

			if (this.dwItemStacks[2].getItemDamageForDisplay() != 0) {
				this.dwItemStacks[2].setItemDamage(0);
			}
		}
	}

	public void dwFixArmourSlot3() {
		if (this.dwCanSmeltSlot3()) {
			if (this.dwItemStacks[3].stackSize <= 0) {
				this.dwItemStacks[3] = null;
			}

			if (this.dwItemStacks[3].getItemDamageForDisplay() != 0) {
				this.dwItemStacks[3].setItemDamage(0);
			}
		}
	}

	public void dwFixArmourSlot4() {
		if (this.dwCanSmeltSlot4()) {
			if (this.dwItemStacks[4].stackSize <= 0) {
				this.dwItemStacks[4] = null;
			}

			if (this.dwItemStacks[4].getItemDamageForDisplay() != 0) {
				this.dwItemStacks[4].setItemDamage(0);
			}
		}
	}

	public int getSmeltTime1() {
		short time = 1;
		int i;

		for (i = 0; i < diamondArmour.length; ++i) {
			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == diamondArmour[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < chainArmour.length; ++i) {
			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == chainArmour[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < goldenArmour.length; ++i) {
			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == goldenArmour[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < steelArmour.length; ++i) {
			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == steelArmour[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < leatherArmour.length; ++i) {
			if (this.itemStacks[0] != null && this.itemStacks[0].itemID == leatherArmour[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int getSmeltTime2() {
		short time = 1;
		int i;

		for (i = 0; i < diamondArmour.length; ++i) {
			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == diamondArmour[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < chainArmour.length; ++i) {
			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == chainArmour[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < goldenArmour.length; ++i) {
			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == goldenArmour[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < steelArmour.length; ++i) {
			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == steelArmour[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < leatherArmour.length; ++i) {
			if (this.itemStacks[2] != null && this.itemStacks[2].itemID == leatherArmour[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int getSmeltTime3() {
		short time = 1;
		int i;

		for (i = 0; i < diamondArmour.length; ++i) {
			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == diamondArmour[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < chainArmour.length; ++i) {
			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == chainArmour[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < goldenArmour.length; ++i) {
			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == goldenArmour[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < steelArmour.length; ++i) {
			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == steelArmour[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < leatherArmour.length; ++i) {
			if (this.itemStacks[3] != null && this.itemStacks[3].itemID == leatherArmour[i]) {
				time = 1500;
			}
		}

		return time;
	}

	public int getSmeltTime4() {
		short time = 1;
		int i;

		for (i = 0; i < diamondArmour.length; ++i) {
			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == diamondArmour[i]) {
				time = 7200;
			}
		}

		for (i = 0; i < chainArmour.length; ++i) {
			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == chainArmour[i]) {
				time = 6000;
			}
		}

		for (i = 0; i < goldenArmour.length; ++i) {
			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == goldenArmour[i]) {
				time = 4800;
			}
		}

		for (i = 0; i < steelArmour.length; ++i) {
			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == steelArmour[i]) {
				time = 4000;
			}
		}

		for (i = 0; i < leatherArmour.length; ++i) {
			if (this.itemStacks[4] != null && this.itemStacks[4].itemID == leatherArmour[i]) {
				time = 1500;
			}
		}

		return time;
	}

	private boolean canSmeltSlot1() {
		if (this.itemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_WashingMachineRecipes.smelting().getSmeltingResult(this.itemStacks[0].getItem().itemID);
			return this.itemStacks[0].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean canSmeltSlot2() {
		if (this.itemStacks[2] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_WashingMachineRecipes.smelting().getSmeltingResult(this.itemStacks[2].getItem().itemID);
			return this.itemStacks[2].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean canSmeltSlot3() {
		if (this.itemStacks[3] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_WashingMachineRecipes.smelting().getSmeltingResult(this.itemStacks[3].getItem().itemID);
			return this.itemStacks[3].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	private boolean canSmeltSlot4() {
		if (this.itemStacks[4] == null) {
			return false;
		} else {
			ItemStack itemstack = jfm_WashingMachineRecipes.smelting().getSmeltingResult(this.itemStacks[4].getItem().itemID);
			return this.itemStacks[4].getItemDamageForDisplay() == 0 ? false : itemstack != null;
		}
	}

	public void fixArmourSlot1() {
		if (this.canSmeltSlot1()) {
			if (this.itemStacks[0].stackSize <= 0) {
				this.itemStacks[0] = null;
			}

			if (this.itemStacks[0].getItemDamageForDisplay() != 0) {
				this.itemStacks[0].setItemDamage(0);
			}
		}
	}

	public void fixArmourSlot2() {
		if (this.canSmeltSlot2()) {
			if (this.itemStacks[2].stackSize <= 0) {
				this.itemStacks[2] = null;
			}

			if (this.itemStacks[2].getItemDamageForDisplay() != 0) {
				this.itemStacks[2].setItemDamage(0);
			}
		}
	}

	public void fixArmourSlot3() {
		if (this.canSmeltSlot3()) {
			if (this.itemStacks[3].stackSize <= 0) {
				this.itemStacks[3] = null;
			}

			if (this.itemStacks[3].getItemDamageForDisplay() != 0) {
				this.itemStacks[3].setItemDamage(0);
			}
		}
	}

	public void fixArmourSlot4() {
		if (this.canSmeltSlot4()) {
			if (this.itemStacks[4].stackSize <= 0) {
				this.itemStacks[4] = null;
			}

			if (this.itemStacks[4].getItemDamageForDisplay() != 0) {
				this.itemStacks[4].setItemDamage(0);
			}
		}
	}

	private static int getItemBurnTime(ItemStack par1ItemStack) {
		if (par1ItemStack == null) {
			return 0;
		} else {
			int i = par1ItemStack.getItem().itemID;
			return i < 256 && Block.blocksList[i].blockMaterial == Material.wood ? 300 : (i == Item.stick.itemID ? 100 : (i == Item.coal.itemID ? 1600 : (i == Item.bucketLava.itemID ? 20000 : (i == Block.sapling.blockID ? 100 : (i == Item.blazeRod.itemID ? 2400 : ModLoader.addAllFuel(
					par1ItemStack.itemID, par1ItemStack.getItemDamage()))))));
		}
	}

	public void openChest() {
		++this.numUsingPlayers;
	}

	public void closeChest() {
		--this.numUsingPlayers;
	}

	/**
	 * invalidates a tile entity
	 */
	public void invalidate() {
		this.updateContainingBlockInfo();
		super.invalidate();
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized
	 * name, and translated into the player's language. Otherwise it will be
	 * used directly.
	 */
	public boolean isInvNameLocalized() {
		return true;
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
