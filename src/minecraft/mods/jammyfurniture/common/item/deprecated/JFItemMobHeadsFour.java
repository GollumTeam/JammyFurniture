package mods.jammyfurniture.common.item.deprecated;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class JFItemMobHeadsFour extends ItemBlock {
	public static Block theBlock;

	public JFItemMobHeadsFour(int par1, Block block) {
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
			name = "EndermanHead";
			break;

		case 4:
		case 5:
		case 6:
		case 7:
			name = "SlimeHead";
			break;

		case 8:
		case 9:
		case 10:
		case 11:
			name = "BlazeHead";
			break;

		case 12:
		case 13:
		case 14:
		case 15:
			name = "PigmanHead";
			break;

		default:
			name = "EndermanHead";
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