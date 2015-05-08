package com.gollum.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import com.gollum.jammyfurniture.client.model.JFIModel;
import com.gollum.jammyfurniture.client.model.heads.ModelHead;

public class MobHeadsFourRenderer extends JFMobHeadsRenderer {
	
	private ModelHead modelHead = new ModelHead();
	
	public MobHeadsFourRenderer() {

		List<JFIModel> models = new ArrayList();
		models.add (modelHead);
		models.add (modelHead);
		models.add (modelHead);
		models.add (modelHead);
		
		List<String> textures = new ArrayList();
		textures.add ("endermanhead");
		textures.add ("slimehead");
		textures.add ("blazehead");
		textures.add ("pigmanhead");
		
		this.init (models, textures);
	}
}
