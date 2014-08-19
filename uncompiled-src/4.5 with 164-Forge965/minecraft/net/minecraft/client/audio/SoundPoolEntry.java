package net.minecraft.client.audio;

import java.net.URL;

public class SoundPoolEntry
{
    private final String soundName;
    private final URL soundUrl;

    public SoundPoolEntry(String par1Str, URL par2URL)
    {
        this.soundName = par1Str;
        this.soundUrl = par2URL;
    }

    public String getSoundName()
    {
        return this.soundName;
    }

    public URL getSoundUrl()
    {
        return this.soundUrl;
    }
}
