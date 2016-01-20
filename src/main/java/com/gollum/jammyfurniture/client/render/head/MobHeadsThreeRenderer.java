package com.gollum.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.heads.ModelHead;
import com.gollum.jammyfurniture.client.model.heads.ModelSquidHead;
import com.gollum.jammyfurniture.client.model.heads.ModelWolfHead;
import com.gollum.jammyfurniture.inits.ModBlocks;

public class MobHeadsThreeRenderer extends JFMobHeadsRenderer {
	
	private ModelWolfHead  modelWolfHead  = new ModelWolfHead();
	private ModelHead      modelHead      = new ModelHead();
	private ModelSquidHead modelSquidHead = new ModelSquidHead();
	
	public MobHeadsThreeRenderer() {

		List<JFIModel> models = new ArrayList();
		models.add (modelHead);
		models.add (modelWolfHead);
		models.add (modelHead);
		models.add (modelSquidHead);
		
		List<String> textures = new ArrayList();
		textures.add ("stevehead");
		textures.add ("wolfhead");
		textures.add ("zombiehead");
		textures.add ("squidhead");
		
		this.init (ModBlocks.blockMobHeadsThree, models, textures);
	}
	
}
