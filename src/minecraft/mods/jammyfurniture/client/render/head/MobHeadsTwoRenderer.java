package mods.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.heads.ModelHead;
import mods.jammyfurniture.client.model.heads.ModelPigHead;
import mods.jammyfurniture.client.model.heads.ModelSheepHead;
import net.minecraft.util.ResourceLocation;

public class MobHeadsTwoRenderer extends JFMobHeadsRenderer {
	
	private ModelPigHead   modelPigHead   = new ModelPigHead();
	private ModelSheepHead modelSheepHead = new ModelSheepHead();
	private ModelHead      modelHead      = new ModelHead();
	
	public MobHeadsTwoRenderer() {

		List<JFIModel> models = new ArrayList();
		models.add (modelPigHead);
		models.add (modelSheepHead);
		models.add (modelHead);
		models.add (modelHead);
		
		List<String> textures = new ArrayList();
		textures.add ("pighead");
		textures.add ("sheephead");
		textures.add ("skeletonhead");
		textures.add ("spiderhead");
		
		this.init (models, textures);
	}
}
