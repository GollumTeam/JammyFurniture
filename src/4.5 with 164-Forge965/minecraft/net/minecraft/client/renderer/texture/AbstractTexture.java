package net.minecraft.client.renderer.texture;

public abstract class AbstractTexture implements TextureObject
{
    protected int glTextureId = -1;

    public int getGlTextureId()
    {
        if (this.glTextureId == -1)
        {
            this.glTextureId = TextureUtil.glGenTextures();
        }

        return this.glTextureId;
    }
}
