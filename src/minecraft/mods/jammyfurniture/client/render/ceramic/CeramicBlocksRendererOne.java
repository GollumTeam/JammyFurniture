package mods.jammyfurniture.client.render.ceramic;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.ceramic.ModelBathroomCupboard;
import mods.jammyfurniture.client.model.ceramic.ModelBathroomSink;
import mods.jammyfurniture.client.model.ceramic.ModelKitchenSink;
import mods.jammyfurniture.client.model.ceramic.ModelToilet;
import mods.jammyfurniture.client.render.JFTileEntitySpecialRenderer;
import mods.jammyfurniture.common.tilesentities.ceramic.TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.tilesentities.iron.TileEntityIronBlocksOne;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class CeramicBlocksRendererOne extends JFTileEntitySpecialRenderer {
	
	
	private ModelBathroomCupboard modelBathroomCupboard = new ModelBathroomCupboard();
	private ModelBathroomSink     modelBathroomSink     = new ModelBathroomSink();
	private ModelKitchenSink      modelKitchenSink      = new ModelKitchenSink();
	private ModelToilet           modelToilet           = new ModelToilet();
	
	protected void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		TileEntityCeramicBlocksOne tileentityCeramic = (TileEntityCeramicBlocksOne)tileEntity;
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockIronBlocksOne).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 4:
			case 11:
			case 15:
				rotation = 90; break;
			case 2:
			case 7:
			case 10:
			case 14:
				rotation = 180; break;
			case 1:
			case 6:
			case 9:
			case 13:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		float doorProgess = tileentityCeramic.getPreviousDoorOpenProgress() + (tileentityCeramic.getDoorOpenProgress() - tileentityCeramic.getPreviousDoorOpenProgress()) * f;
		
		switch (subBlock) {
			default:
			case 0:  this.renderModel(this.modelBathroomCupboard, "bathroomcupboard", x, y, z, rotation, doorProgess); break;
//			case 4:  this.renderModel(this.modelBathroomSink    , "sink"            , x, y, z, (invRender) ? 270 : rotation); break;
			case 4:  this.renderModel(new ModelBathroomSink()    , "sink"            , x, y, z, (invRender) ? 270 : rotation); break;
			case 8:  this.renderModel(this.modelKitchenSink     , "kitchensink"     , x, y, z, rotation); break;
			case 12: this.renderModel(this.modelToilet          , "toilet"          , x, y, z, rotation); break;
		}
		
	}
}
