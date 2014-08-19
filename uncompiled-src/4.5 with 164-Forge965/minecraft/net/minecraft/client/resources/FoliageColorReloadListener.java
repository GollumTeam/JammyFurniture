package net.minecraft.client.resources;

import java.io.IOException;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ColorizerFoliage;

public class FoliageColorReloadListener implements ResourceManagerReloadListener
{
    private static final ResourceLocation field_130079_a = new ResourceLocation("textures/colormap/foliage.png");

    public void onResourceManagerReload(ResourceManager par1ResourceManager)
    {
        try
        {
            ColorizerFoliage.setFoliageBiomeColorizer(TextureUtil.readImageData(par1ResourceManager, field_130079_a));
        }
        catch (IOException var3)
        {
            ;
        }
    }
}
