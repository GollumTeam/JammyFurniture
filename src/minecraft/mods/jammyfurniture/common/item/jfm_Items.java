package mods.jammyfurniture.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class jfm_Items extends Item {
	public jfm_Items(int par1) {
		super(par1);
	}

	public void registerIcons(IconRegister register) {
		this.itemIcon = register.registerIcon("jammyfurniture:" + this.getUnlocalizedName());
	}
}
