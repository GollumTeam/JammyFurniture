package com.gollum.jammyfurniture.inits;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import net.minecraft.item.Item;

import com.gollum.core.ModGollumCoreLib;
import com.gollum.core.common.items.ItemBuilding;
import com.gollum.core.common.items.ItemInfos;
import com.gollum.core.common.items.ItemWrench;
import com.gollum.core.tools.helper.items.HItem;
import com.gollum.core.tools.registry.SoundRegistry;

public class ModSounds {

	public static void init() {
		
		SoundRegistry.register("clock-tick");
		SoundRegistry.register("clock-dong");
		SoundRegistry.register("machine");
		SoundRegistry.register("radio");
		SoundRegistry.register("toilet");
		SoundRegistry.register("trashopen");
		SoundRegistry.register("trashclosed");
		SoundRegistry.register("sink_water");
	}
}
