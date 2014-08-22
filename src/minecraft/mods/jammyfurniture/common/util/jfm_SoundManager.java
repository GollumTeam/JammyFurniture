package mods.jammyfurniture.common.util;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class jfm_SoundManager
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            event.manager.soundPoolSounds.addSound("jammyfurniture:" + jfm_ConfigDefault.SOUND_PATH + "washingmachine.wav");
            event.manager.soundPoolSounds.addSound("jammyfurniture:" + jfm_ConfigDefault.SOUND_PATH + "radio.wav");
            event.manager.soundPoolSounds.addSound("jammyfurniture:" + jfm_ConfigDefault.SOUND_PATH + "toilet.wav");
        }
        catch (Exception var3)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}
