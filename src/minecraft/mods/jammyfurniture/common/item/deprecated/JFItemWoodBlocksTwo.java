package mods.jammyfurniture.common.item.deprecated;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/** @deprecated */
public class JFItemWoodBlocksTwo extends ItemBlock {
	public static Block theBlock;

//	public JFItemWoodBlocksTwo(Block block) {
//		super(block.blockID - 256);
//		this.setHasSubtypes(true);
//		theBlock = block;
//	}
	public JFItemWoodBlocksTwo(int id, Block block) {
		super(id);
		this.setHasSubtypes(true);
		theBlock = block;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an
	 * ItemStack so different stacks can have different names based on their
	 * damage or NBT.
	 */
	public String getUnlocalizedName(ItemStack itemStack) {
//		String name = "";
//
//		switch (itemStack.getItemDamage()) {
//		case 0:
//		case 1:
//		case 2:
//		case 3:
//			name = "KitchenCupboard";
//			break;
//
//		case 4:
//		case 5:
//		case 6:
//		case 7:
//			name = "KitchenCupboardShelf";
//			break;
//
//		case 8:
//		case 9:
//		case 10:
//		case 11:
//			name = "TV";
//			break;
//
//		case 12:
//		case 13:
//		case 14:
//		case 15:
//			name = "Basket";
//			break;
//
//		default:
//			name = "KitchenCupboard";
//		}

//		return this.getUnlocalizedName() + "." + name;
		return this.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	public int getMetadata(int par1) {
		return par1;
	}
}