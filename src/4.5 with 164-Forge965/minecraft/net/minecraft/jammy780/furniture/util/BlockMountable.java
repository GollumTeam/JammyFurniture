package net.minecraft.jammy780.furniture.util;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMountable extends Block
{
    public BlockMountable(int x, Material material)
    {
        super(x, material);
    }

    public BlockMountable(int x, int y, Material material)
    {
        super(x, material);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 1.0F, 0.5F, 0, 0, 0, 0);
    }

    public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float y)
    {
        return onBlockActivated(world, i, j, k, entityplayer, 0.5F, y, 0.5F, 0, 0, 0, 0);
    }

    public static boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, float x, float y, float z, int north, int south, int east, int west)
    {
        if (!world.isRemote)
        {
            List listEMB = world.getEntitiesWithinAABB(EntityMountableBlock.class, AxisAlignedBB.getBoundingBox((double)i, (double)j, (double)k, (double)i + 1.0D, (double)j + 1.0D, (double)k + 1.0D).expand(1.0D, 1.0D, 1.0D));
            Iterator mountingX = listEMB.iterator();
            EntityMountableBlock mountingY;

            do
            {
                if (!mountingX.hasNext())
                {
                    float mountingX1 = (float)i + x;
                    float mountingY1 = (float)j + y;
                    float mountingZ = (float)k + z;

                    if (north != south)
                    {
                        int nemb = world.getBlockMetadata(i, j, k);

                        if (nemb == east)
                        {
                            mountingX1 = (float)(i + 1) - z;
                            mountingZ = (float)k + x;
                        }
                        else if (nemb == south)
                        {
                            mountingX1 = (float)(i + 1) - x;
                            mountingZ = (float)(k + 1) - z;
                        }
                        else if (nemb == west)
                        {
                            mountingX1 = (float)i + z;
                            mountingZ = (float)(k + 1) - x;
                        }
                    }

                    EntityMountableBlock nemb1 = new EntityMountableBlock(world, entityplayer, i, j, k, mountingX1, mountingY1, mountingZ);
                    world.spawnEntityInWorld(nemb1);
                    nemb1.interact(entityplayer);
                    return true;
                }

                mountingY = (EntityMountableBlock)mountingX.next();
            }
            while (mountingY.orgBlockPosX != i || mountingY.orgBlockPosY != j || mountingY.orgBlockPosZ != k);

            mountingY.interact(entityplayer);
            return true;
        }
        else
        {
            return true;
        }
    }
}
