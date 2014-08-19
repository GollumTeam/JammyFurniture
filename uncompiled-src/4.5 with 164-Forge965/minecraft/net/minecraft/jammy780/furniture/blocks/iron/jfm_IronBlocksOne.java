package net.minecraft.jammy780.furniture.blocks.iron;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.jammy780.furniture.JammyFurnitureModCore;
import net.minecraft.jammy780.furniture.tiles.jfm_TileEntityIronBlocksOne;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jfm_IronBlocksOne extends BlockContainer
{
    private Class teClass;
    public Random random;
    private Icon jfm_blockIcon;

    public jfm_IronBlocksOne(int id, int notsure, Class c)
    {
        super(id, Material.iron);
        this.teClass = c;
        this.random = new Random();
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        return JammyFurnitureModCore.ironBlocksOne.blockID;
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is)
    {
        int meta = world.getBlockMetadata(i, j, k);
        int l = (MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

        if (meta == 0 || meta == 4 || meta == 8)
        {
            world.setBlockMetadataWithNotify(i, j, k, meta + l, 0);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
    {
        int b = par1World.getBlockMetadata(par2, par3, i);

        if (b != 0 && b != 2 && b != 4 && b != 6)
        {
            if (b != 1 && b != 3 && b != 5 && b != 7)
            {
                if (b == 12)
                {
                    this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
            }
        }
        else
        {
            this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
        }

        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, i);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int b = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if (b != 0 && b != 2 && b != 4 && b != 6)
        {
            if (b != 1 && b != 3 && b != 5 && b != 7)
            {
                if (b == 12)
                {
                    this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.1F, 0.0F, 0.05F, 0.9F, 1.0F, 0.95F);
            }
        }
        else
        {
            this.setBlockBounds(0.05F, 0.0F, 0.1F, 0.95F, 1.0F, 0.9F);
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        int l = (MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
        jfm_TileEntityIronBlocksOne teIronOne;

        if (meta != 0 && meta != 1 && meta != 2 && meta != 3)
        {
            if (meta != 4 && meta != 5 && meta != 6 && meta != 7)
            {
                if (meta != 8 && meta != 9 && meta != 10 && meta != 11)
                {
                    if (meta == 12)
                    {
                        teIronOne = (jfm_TileEntityIronBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

                        if (teIronOne != null)
                        {
                            entityplayer.openGui(JammyFurnitureModCore.instance, 158, par1World, par2, par3, par4);
                            return true;
                        }
                    }
                }
                else
                {
                    teIronOne = (jfm_TileEntityIronBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

                    if (teIronOne != null)
                    {
                        entityplayer.openGui(JammyFurnitureModCore.instance, 152, par1World, par2, par3, par4);
                        return true;
                    }
                }
            }
            else
            {
                teIronOne = (jfm_TileEntityIronBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

                if (teIronOne != null)
                {
                    entityplayer.openGui(JammyFurnitureModCore.instance, 157, par1World, par2, par3, par4);
                    return true;
                }
            }
        }
        else
        {
            teIronOne = (jfm_TileEntityIronBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

            if (teIronOne != null)
            {
                entityplayer.openGui(JammyFurnitureModCore.instance, 156, par1World, par2, par3, par4);
                return true;
            }
        }

        return false;
    }

    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        jfm_TileEntityIronBlocksOne te = (jfm_TileEntityIronBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

        if (te != null)
        {
            for (int j1 = 0; j1 < te.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = te.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World.spawnEntityInWorld(entityitem))
                    {
                        int k1 = this.random.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            par1World.func_96440_m(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return JammyFurnitureModCore.ironBlocksOneRenderID;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        jfm_TileEntityIronBlocksOne tileentity = new jfm_TileEntityIronBlocksOne();
        return tileentity;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int id, CreativeTabs ctabs, List list)
    {
        list.add(new ItemStack(id, 1, 0));
        list.add(new ItemStack(id, 1, 4));
        list.add(new ItemStack(id, 1, 8));
        list.add(new ItemStack(id, 1, 12));
        list.add(new ItemStack(id, 1, 13));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        if (par1 == 1 || par1 == 2 || par1 == 3)
        {
            par1 = 0;
        }

        if (par1 == 5 || par1 == 6 || par1 == 7)
        {
            par1 = 4;
        }

        if (par1 == 9 || par1 == 10 || par1 == 11)
        {
            par1 = 8;
        }

        return par1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.jfm_blockIcon = par1IconRegister.registerIcon("jammyfurniture:jammy_iron");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int metadata)
    {
        return this.jfm_blockIcon;
    }
}
