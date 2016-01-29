package com.gollum.jammyfurniture.common.config;

import com.gollum.core.common.config.Config;
import com.gollum.core.common.config.ConfigProp;
import com.gollum.core.common.config.ConfigProp.Type;

public class ConfigJammyFuniture extends Config {
	
	@ConfigProp public boolean tellTheTime = true;
	
	/////////////////
	// Head Sounds //
	/////////////////
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadChicken   = "mob.chicken.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadCow       = "mob.cow.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadCreeper   = "random.fizz";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadPig       = "mob.pig.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSheep     = "mob.sheep.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSkeleton  = "mob.skeleton.say";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSpider    = "mob.spider.say";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSteve     = "random.eat";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadWolf      = "mob.wolf.growl";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadZombie    = "mob.zombie.say";
	
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadEnderman  = "mob.endermen.idle";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadSlim      = "mob.slime.big";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadBlaze     = "mob.blaze.breathe";
	@ConfigProp(group="Head Sounds", type=Type.SOUND) public String soundHeadZombiepig = "mob.zombiepig.zpig";
	
}
