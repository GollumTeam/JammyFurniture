package mods.jammyfurniture.common.item.deprecated;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/** @deprecated */
public class JFItemIronBlocksTwo extends ItemBlock {
	public static Block theBlock;

	public JFItemIronBlocksTwo(Block block) {
		super(block.blockID - 256);
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
			name = "Dishwasher";
			break;

		case 4:
		case 5:
		case 6:
		case 7:
			name = "WashingMachine";
			break;

		default:
			name = "Dishwasher";
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
