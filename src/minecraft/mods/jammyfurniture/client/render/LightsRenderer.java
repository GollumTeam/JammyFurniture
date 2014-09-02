package mods.jammyfurniture.client.render;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.lights.ModelLight;
import mods.jammyfurniture.client.model.lights.ModelOutsideLamp;
import mods.jammyfurniture.client.model.lights.ModelTableLamp;
import mods.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.light.TileEntityLightsOn;
import net.minecraft.tileentity.TileEntity;

public class LightsRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelLight       modeLight        = new ModelLight();
	private ModelOutsideLamp modelOutsideLamp = new ModelOutsideLamp();
	private ModelTableLamp   modelTableLamp   = new ModelTableLamp();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockLightsOn).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 7:
				rotation = 90; break;
			case 6:
				rotation = 180; break;
			case 5:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		String status = (tileEntity instanceof TileEntityLightsOn) ? "_on" : "_off";
		
		switch (subBlock) {
			case 0:  this.renderModel(this.modeLight       , "lightbulb" + status, x, y, z, rotation); break;
			case 4:  this.renderModel(this.modelOutsideLamp, "lamp"      + status, x, y, z, rotation); break;
			case 8:  this.renderModel(this.modelTableLamp  , "tablelamp" + status, x, y, z, rotation); break;
		}

	}
}
