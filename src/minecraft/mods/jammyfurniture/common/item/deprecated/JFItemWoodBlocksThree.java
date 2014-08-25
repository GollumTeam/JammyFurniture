package mods.jammyfurniture.common.item.deprecated;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/** @deprecated */
public class JFItemWoodBlocksThree extends ItemBlock {
	public static Block theBlock;

	public JFItemWoodBlocksThree(Block block) {
		super(block.blockID - 256);
		this.setHasSubtypes(true);
		theBlock = block;
	}

	public JFItemWoodBlocksThree(int id, Block block) {
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
		String name = "";

		switch (itemStack.getItemDamage()) {
		case 0:
		case 1:
		case 2:
		case 3:
			name = "Chair";
			break;

		case 4:
		case 5:
		case 6:
		case 7:
			name = "Radio";
			break;

		default:
			name = "Basket";
		}

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
