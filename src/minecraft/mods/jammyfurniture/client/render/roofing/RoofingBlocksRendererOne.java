package mods.jammyfurniture.client.render.roofing;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.roofing.ModelRoofing;
import mods.jammyfurniture.client.model.roofing.ModelRoofingBlock;
import mods.jammyfurniture.client.model.roofing.ModelRoofingCorner;
import mods.jammyfurniture.client.model.roofing.ModelRoofingInverted;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import mods.jammyfurniture.common.tilesentities.roofing.TileEntityRoofingBlocksOne;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RoofingBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	private ModelRoofing         modelRoofing         = new ModelRoofing();
	private ModelRoofingCorner   modelRoofingCorner   = new ModelRoofingCorner();
	private ModelRoofingInverted modelRoofingInverted = new ModelRoofingInverted();
	private ModelRoofingBlock    modelRoofingBlock    = new ModelRoofingBlock();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {

		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockRoofingBlocksOne).getEnabledMetadata(metadata);
		
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		switch (subBlock) {
		default:
			case 0:  this.renderModel(this.modelRoofing        , "roofing", x, y, z, rotation); break;
			case 4:  this.renderModel(this.modelRoofingCorner  , "roofing", x, y, z, rotation); break;
			case 8:  this.renderModel(this.modelRoofingInverted, "roofing", x, y, z, rotation); break;
			case 12: this.renderModel(this.modelRoofingBlock   , "roofing", x, y, z, rotation); break;
		}
	}
}
