package com.gollum.jammyfurniture.common.config;

import com.gollum.core.common.config.Config;
import com.gollum.core.common.config.ConfigProp;
import com.gollum.core.common.config.ConfigProp.Type;

public class ConfigJammyFuniture extends Config {
	
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadChicken   = "mob.chicken.say";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadCow       = "mob.cow.say";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadCreeper   = "random.fizz";
	
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadPig       = "mob.pig.say";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadSheep     = "mob.sheep.say";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadSkeleton  = "mob.skeleton.say";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadSpider    = "mob.spider.say";

	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadSteve     = "random.eat";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadWolf      = "mob.wolf.growl";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadZombie    = "mob.zombie.say";
	
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadEnderman  = "mob.endermen.idle";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadSlim      = "mob.slime.big";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadBlaze     = "mob.blaze.breathe";
	@ConfigProp(group="HeadSounds", type=Type.SOUND) public String soundHeadZombiepig = "mob.zombiepig.zpig";
	
}
