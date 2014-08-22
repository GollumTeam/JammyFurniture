package mods.jammyfurniture.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class JFItemArmChair extends ItemBlock {
	public static Block theBlock;

	public JFItemArmChair(int par1, Block block) {
		super(par1);
		this.setHasSubtypes(true);
		theBlock = block;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an
	 * ItemStack so different stacks can have different names based on their
	 * damage or NBT.
	 */
	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";

		switch (itemstack.getItemDamage()) {
		case 0:
		case 1:
		case 2:
		case 3:
			name = "ArmChairRed";
			break;

		case 4:
		case 5:
		case 6:
		case 7:
			name = "ArmChairBlue";
			break;

		case 8:
		case 9:
		case 10:
		case 11:
			name = "ArmChairGreen";
			break;

		case 12:
		case 13:
		case 14:
		case 15:
			name = "ArmChairGrey";
			break;

		default:
			name = "ArmChairRed";
		}

		return this.getUnlocalizedName() + "." + name;
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	public int getMetadata(int par1) {
		return par1;
	}
}
