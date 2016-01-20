package com.gollum.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.heads.ModelHead;
import com.gollum.jammyfurniture.client.model.heads.ModelPigHead;
import com.gollum.jammyfurniture.client.model.heads.ModelSheepHead;
import com.gollum.jammyfurniture.inits.ModBlocks;

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
		
		this.init (ModBlocks.blockMobHeadsTwo, models, textures);
	}
}
