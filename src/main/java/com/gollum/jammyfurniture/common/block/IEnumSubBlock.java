package com.gollum.jammyfurniture.common.block;

import net.minecraft.util.IStringSerializable;

public interface IEnumSubBlock extends IStringSerializable {
	
	public boolean isFacingPlane ();
	
	public int getIndex ();
	
}
