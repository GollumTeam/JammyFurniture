package mods.jammyfurniture.client.render.head;

import java.util.ArrayList;
import java.util.List;

import mods.jammyfurniture.client.model.JFIModel;
import mods.jammyfurniture.client.model.heads.ModelChickenHead;
import mods.jammyfurniture.client.model.heads.ModelCowHead;
import mods.jammyfurniture.client.model.heads.ModelEnderDragonHead;
import mods.jammyfurniture.client.model.heads.ModelHead;

public class MobHeadsOneRenderer extends JFMobHeadsRenderer {
	private ModelChickenHead     modelChickenHead     = new ModelChickenHead();
	private ModelCowHead         modelCowHead         = new ModelCowHead();
	private ModelHead            modelHead            = new ModelHead();
	private ModelEnderDragonHead modelEnderdragonHead = new ModelEnderDragonHead();
	
	public MobHeadsOneRenderer() {

		List<JFIModel> models = new ArrayList();
		models.add (modelChickenHead);
		models.add (modelCowHead);
		models.add (modelHead);
		models.add (modelEnderdragonHead);
		
		List<String> textures = new ArrayList();
		textures.add ("chickenhead");
		textures.add ("cowhead");
		textures.add ("creeperhead");
		textures.add ("enderdragonhead");
		
		this.init (models, textures);
	}
}
