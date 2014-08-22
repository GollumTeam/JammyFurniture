package net.minecraft.client.main;

import net.minecraft.client.Minecraft;

public final class MainShutdownHook extends Thread
{
    public void run()
    {
        Minecraft.stopIntegratedServer();
    }
}
