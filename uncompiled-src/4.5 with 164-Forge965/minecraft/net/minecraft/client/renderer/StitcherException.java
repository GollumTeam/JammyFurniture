package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.StitchHolder;

public class StitcherException extends RuntimeException
{
    private final StitchHolder field_98149_a;

    public StitcherException(StitchHolder par1StitchHolder, String par2Str)
    {
        super(par2Str);
        this.field_98149_a = par1StitchHolder;
    }
}
