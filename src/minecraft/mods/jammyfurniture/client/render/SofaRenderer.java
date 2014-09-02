package mods.jammyfurniture.client.render;

import mods.gollum.core.tools.helper.IBlockMetadataHelper;
import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.sofa.ModelArmChair;
import mods.jammyfurniture.client.model.sofa.ModelSofaCenter;
import mods.jammyfurniture.client.model.sofa.ModelSofaCorner;
import mods.jammyfurniture.client.model.sofa.ModelSofaLeft;
import mods.jammyfurniture.client.model.sofa.ModelSofaRight;
import mods.jammyfurniture.common.tilesentities.TileEntityArmChair;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCenter;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaCorner;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaLeft;
import mods.jammyfurniture.common.tilesentities.TileEntitySofaRight;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SofaRenderer extends JFTileEntitySpecialRenderer {
	
	private ModelArmChair   modelArmChair   = new ModelArmChair ();
	private ModelSofaCenter modelSofaCenter = new ModelSofaCenter();
	private ModelSofaCorner modelSofaCorner = new ModelSofaCorner();
	private ModelSofaRight  modelSofaRight  = new ModelSofaRight();
	private ModelSofaLeft   modelSofaLeft   = new ModelSofaLeft();
	
	protected void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int metadata, boolean invRender) {
		
		float rotation = 0;
		int subBlock = ((IBlockMetadataHelper)ModJammyFurniture.blockArmChair).getEnabledMetadata(metadata);
		
		switch (metadata) {
			default:
				rotation = 0; break;
			case 3:
			case 7:
			case 11:
			case 15:
				rotation = 90; break;
			case 2:
			case 6:
			case 10:
			case 14:
				rotation = 180; break;
			case 1:
			case 5:
			case 9:
			case 13:
				rotation = 270; break;
		}
		
		if (invRender) {
			rotation = 180;
		}
		
		String texture;
		switch (metadata) {
			default:
			case 0:  
			case 1:  
			case 2:  
			case 3:  texture = this.getPrefrixeTexture (tileentity)+"_red"; break;
			case 4:  
			case 5:  
			case 6:  
			case 7:  texture = this.getPrefrixeTexture (tileentity)+"_blue"; break;
			case 8:  
			case 9:  
			case 10: 
			case 11: texture = this.getPrefrixeTexture (tileentity)+"_green"; break;
			case 12:  
			case 13:  
			case 14:  
			case 15: texture = this.getPrefrixeTexture (tileentity)+"_grey"; break;
		}
		
		this.renderModel(this.getModel(tileentity), texture, x, y, z, rotation);
	}

	private String getPrefrixeTexture(TileEntity tileentity) {
		if (tileentity instanceof TileEntitySofaCenter) {
			return "sofacenter";
		}
		if (tileentity instanceof TileEntitySofaCorner) {
			return "sofacorner";
		}
		if (tileentity instanceof TileEntitySofaLeft) {
			return "sofaleft";
		}
		if (tileentity instanceof TileEntitySofaRight) {
			return "sofaright";
		}
		return "armchair";
	}


	private JFIModel getModel(TileEntity tileentity) {
		if (tileentity instanceof TileEntitySofaCenter) {
			return this.modelSofaCenter;
		}
		if (tileentity instanceof TileEntitySofaCorner) {
			return this.modelSofaCorner;
		}
		if (tileentity instanceof TileEntitySofaLeft) {
			return this.modelSofaLeft;
		}
		if (tileentity instanceof TileEntitySofaRight) {
			return this.modelSofaRight;
		}
		return this.modelArmChair;
	}
	
	
	
}
