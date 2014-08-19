package net.minecraft.client.resources;

import java.io.InputStream;
import net.minecraft.client.resources.data.MetadataSection;

public interface Resource
{
    InputStream getInputStream();

    boolean hasMetadata();

    MetadataSection getMetadata(String var1);
}
