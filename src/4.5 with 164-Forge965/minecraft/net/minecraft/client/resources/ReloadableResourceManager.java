package net.minecraft.client.resources;

import java.util.List;

public interface ReloadableResourceManager extends ResourceManager
{
    void reloadResources(List var1);

    void registerReloadListener(ResourceManagerReloadListener var1);
}
