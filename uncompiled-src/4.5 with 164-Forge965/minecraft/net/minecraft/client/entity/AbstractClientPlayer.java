package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public abstract class AbstractClientPlayer extends EntityPlayer
{
    public static final ResourceLocation locationStevePng = new ResourceLocation("textures/entity/steve.png");
    private ThreadDownloadImageData downloadImageSkin;
    private ThreadDownloadImageData downloadImageCape;
    private ResourceLocation locationSkin;
    private ResourceLocation locationCape;

    public AbstractClientPlayer(World par1World, String par2Str)
    {
        super(par1World, par2Str);
        this.setupCustomSkin();
    }

    protected void setupCustomSkin()
    {
        System.out.println("Setting up custom skins");

        if (this.username != null && !this.username.isEmpty())
        {
            this.locationSkin = getLocationSkin(this.username);
            this.locationCape = getLocationCape(this.username);
            this.downloadImageSkin = getDownloadImageSkin(this.locationSkin, this.username);
            this.downloadImageCape = getDownloadImageCape(this.locationCape, this.username);
        }
    }

    public ThreadDownloadImageData getTextureSkin()
    {
        return this.downloadImageSkin;
    }

    public ThreadDownloadImageData getTextureCape()
    {
        return this.downloadImageCape;
    }

    public ResourceLocation getLocationSkin()
    {
        return this.locationSkin;
    }

    public ResourceLocation getLocationCape()
    {
        return this.locationCape;
    }

    public static ThreadDownloadImageData getDownloadImageSkin(ResourceLocation par0ResourceLocation, String par1Str)
    {
        return getDownloadImage(par0ResourceLocation, getSkinUrl(par1Str), locationStevePng, new ImageBufferDownload());
    }

    public static ThreadDownloadImageData getDownloadImageCape(ResourceLocation par0ResourceLocation, String par1Str)
    {
        return getDownloadImage(par0ResourceLocation, getCapeUrl(par1Str), (ResourceLocation)null, (IImageBuffer)null);
    }

    private static ThreadDownloadImageData getDownloadImage(ResourceLocation par0ResourceLocation, String par1Str, ResourceLocation par2ResourceLocation, IImageBuffer par3IImageBuffer)
    {
        TextureManager var4 = Minecraft.getMinecraft().getTextureManager();
        Object var5 = var4.getTexture(par0ResourceLocation);

        if (var5 == null)
        {
            var5 = new ThreadDownloadImageData(par1Str, par2ResourceLocation, par3IImageBuffer);
            var4.loadTexture(par0ResourceLocation, (TextureObject)var5);
        }

        return (ThreadDownloadImageData)var5;
    }

    public static String getSkinUrl(String par0Str)
    {
        return String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", new Object[] {StringUtils.stripControlCodes(par0Str)});
    }

    public static String getCapeUrl(String par0Str)
    {
        return String.format("http://skins.minecraft.net/MinecraftCloaks/%s.png", new Object[] {StringUtils.stripControlCodes(par0Str)});
    }

    public static ResourceLocation getLocationSkin(String par0Str)
    {
        return new ResourceLocation("skins/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ResourceLocation getLocationCape(String par0Str)
    {
        return new ResourceLocation("cloaks/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ResourceLocation getLocationSkull(String par0Str)
    {
        return new ResourceLocation("skull/" + StringUtils.stripControlCodes(par0Str));
    }
}
