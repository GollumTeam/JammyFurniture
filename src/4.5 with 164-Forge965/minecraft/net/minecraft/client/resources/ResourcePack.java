package net.minecraft.client.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public interface ResourcePack
{
    InputStream getInputStream(ResourceLocation var1) throws IOException;

    boolean resourceExists(ResourceLocation var1);

    Set getResourceDomains();

    MetadataSection getPackMetadata(MetadataSerializer var1, String var2) throws IOException;

    BufferedImage getPackImage() throws IOException;

    String getPackName();
}
