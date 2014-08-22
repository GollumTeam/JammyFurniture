package mods.jammyfurniture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class jfm_CreativeTabs extends CreativeTabs
{
    public jfm_CreativeTabs(String label)
    {
        super(label);
    }

    public ItemStack getIconItemStack()
    {
        return new ItemStack(JammyFurnitureModCore.itemArmChair);
    }
}
