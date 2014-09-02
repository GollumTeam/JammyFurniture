package mods.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.heads.ModelHead;
import mods.jammyfurniture.client.model.heads.ModelSquidHead;
import mods.jammyfurniture.client.model.heads.ModelWolfHead;
import net.minecraft.util.ResourceLocation;

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
		
		this.init (models, textures);
	}
	
}
