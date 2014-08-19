package net.minecraft.client.renderer.texture;

import java.io.IOException;
import net.minecraft.client.resources.ResourceManager;

public interface TextureObject
{
    void loadTexture(ResourceManager var1) throws IOException;

    int getGlTextureId();
}
