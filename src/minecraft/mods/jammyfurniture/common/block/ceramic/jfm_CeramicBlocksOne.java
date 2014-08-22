package mods.jammyfurniture.common.block.ceramic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import mods.jammyfurniture.JammyFurnitureModCore;
import mods.jammyfurniture.common.tilesentities.jfm_TileEntityCeramicBlocksOne;
import mods.jammyfurniture.common.util.BlockMountable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jfm_CeramicBlocksOne extends BlockContainer
{
    public Random random = new Random();
    Icon ceramic;

    public jfm_CeramicBlocksOne(int id, int notsure, Class teClass)
    {
        super(id, Material.glass);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        return JammyFurnitureModCore.ceramicBlocksOne.blockID;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
    {
        int b = par1World.getBlockMetadata(par2, par3, i);

        if (b == 0)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.6F, 0.9F, 1.0F, 1.0F);
        }
        else if (b == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.4F, 1.0F, 0.9F);
        }
        else if (b == 2)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.4F);
        }
        else if (b == 3)
        {
            this.setBlockBounds(0.6F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
        }
        else if (b == 4)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.2F, 0.9F, 1.0F, 1.0F);
        }
        else if (b == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.8F, 1.0F, 0.9F);
        }
        else if (b == 6)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.8F);
        }
        else if (b == 7)
        {
            this.setBlockBounds(0.2F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
        }
        else if (b != 8 && b != 9 && b != 10 && b != 11)
        {
            if (b == 12)
            {
                this.setBlockBounds(0.15F, 0.0F, 0.05F, 0.85F, 1.0F, 1.0F);
            }
            else if (b == 13)
            {
                this.setBlockBounds(0.05F, 0.0F, 0.15F, 1.0F, 1.0F, 0.85F);
            }
            else if (b == 14)
            {
                this.setBlockBounds(0.15F, 0.0F, 0.0F, 0.85F, 1.0F, 0.95F);
            }
            else if (b == 15)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.15F, 0.95F, 1.0F, 0.85F);
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else
        {
            this.setBlockBounds(0.0F, 0.4F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, i);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int b = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if (b == 0)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.6F, 0.9F, 1.0F, 1.0F);
        }
        else if (b == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.4F, 1.0F, 0.9F);
        }
        else if (b == 2)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.4F);
        }
        else if (b == 3)
        {
            this.setBlockBounds(0.6F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
        }
        else if (b == 4)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.2F, 0.9F, 1.0F, 1.0F);
        }
        else if (b == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.1F, 0.8F, 1.0F, 0.9F);
        }
        else if (b == 6)
        {
            this.setBlockBounds(0.1F, 0.0F, 0.0F, 0.9F, 1.0F, 0.8F);
        }
        else if (b == 7)
        {
            this.setBlockBounds(0.2F, 0.0F, 0.1F, 1.0F, 1.0F, 0.9F);
        }
        else if (b != 8 && b != 9 && b != 10 && b != 11)
        {
            if (b == 12)
            {
                this.setBlockBounds(0.15F, 0.0F, 0.05F, 0.85F, 1.0F, 1.0F);
            }
            else if (b == 13)
            {
                this.setBlockBounds(0.05F, 0.0F, 0.15F, 1.0F, 1.0F, 0.85F);
            }
            else if (b == 14)
            {
                this.setBlockBounds(0.15F, 0.0F, 0.0F, 0.85F, 1.0F, 0.95F);
            }
            else if (b == 15)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.15F, 0.95F, 1.0F, 0.85F);
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else
        {
            this.setBlockBounds(0.0F, 0.4F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is)
    {
        int meta = world.getBlockMetadata(i, j, k);
        int l = (MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

        if (meta == 0 || meta == 4 || meta == 8 || meta == 12)
        {
            world.setBlockMetadataWithNotify(i, j, k, meta + l, 0);
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        int l = (MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;

        if (meta != 12 && meta != 13 && meta != 14 && meta != 15)
        {
            if (meta != 0 && meta != 1 && meta != 2 && meta != 3)
            {
                if (meta == 4 || meta == 5 || meta == 6 || meta == 7 || meta == 8 || meta == 9 || meta == 10 || meta == 11)
                {
                    if (par1World.isRemote)
                    {
                        return true;
                    }

                    ItemStack var17 = entityplayer.inventory.getCurrentItem();

                    if (var17 == null)
                    {
                        return true;
                    }

                    ItemStack var16;

                    if (var17.itemID == Item.bucketEmpty.itemID)
                    {
                        var16 = new ItemStack(Item.bucketWater, 1, 0);

                        if (!entityplayer.inventory.addItemStackToInventory(var16))
                        {
                            par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, var16));
                        }
                        else if (entityplayer instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)entityplayer).sendContainerToPlayer(entityplayer.inventoryContainer);
                        }

                        --var17.stackSize;

                        if (var17.stackSize <= 0)
                        {
                            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }

                    if (var17.itemID == Item.glassBottle.itemID)
                    {
                        var16 = new ItemStack(Item.potion, 1, 0);

                        if (!entityplayer.inventory.addItemStackToInventory(var16))
                        {
                            par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, var16));
                        }
                        else if (entityplayer instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)entityplayer).sendContainerToPlayer(entityplayer.inventoryContainer);
                        }

                        --var17.stackSize;

                        if (var17.stackSize <= 0)
                        {
                            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, (ItemStack)null);
                        }
                    }

                    return true;
                }
            }
            else
            {
                jfm_TileEntityCeramicBlocksOne var15 = (jfm_TileEntityCeramicBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

                if (var15 != null)
                {
                    entityplayer.openGui(JammyFurnitureModCore.instance, 150, par1World, par2, par3, par4);
                    return true;
                }
            }

            return true;
        }
        else
        {
            par1World.playSoundAtEntity(entityplayer, "jammyfurniture:toilet", 1.0F, 1.0F);

            if (par1World.isRemote)
            {
                return true;
            }
            else
            {
                l %= 4;

                if (l == 0)
                {
                    entityplayer.rotationYaw = 180.0F;
                }

                if (l == 1)
                {
                    entityplayer.rotationYaw = -90.0F;
                }

                if (l == 2)
                {
                    entityplayer.rotationYaw = 0.0F;
                }

                if (l == 3)
                {
                    entityplayer.rotationYaw = 90.0F;
                }

                float var10 = 0.0F;
                float var12 = 0.0F;
                float z = 0.0F;

                if (l == 0)
                {
                    var10 = 0.5F;
                    var12 = 0.4F;
                    z = 0.5F;
                }

                if (l == 1)
                {
                    var10 = 0.5F;
                    var12 = 0.4F;
                    z = 0.5F;
                }

                if (l == 2)
                {
                    var10 = 0.5F;
                    var12 = 0.4F;
                    z = 0.5F;
                }

                if (l == 3)
                {
                    var10 = 0.5F;
                    var12 = 0.4F;
                    z = 0.5F;
                }

                return BlockMountable.onBlockActivated(par1World, par2, par3, par4, entityplayer, var10, var12, z, 0, 0, 0, 0);
            }
        }
    }

    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        jfm_TileEntityCeramicBlocksOne te = (jfm_TileEntityCeramicBlocksOne)par1World.getBlockTileEntity(par2, par3, par4);

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
        return JammyFurnitureModCore.ceramicBlocksOneRenderID;
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

    public TileEntity getBlockEntity()
    {
        return new jfm_TileEntityCeramicBlocksOne();
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new jfm_TileEntityCeramicBlocksOne();
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

        if (par1 == 13 || par1 == 14 || par1 == 15)
        {
            par1 = 12;
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
        this.ceramic = par1IconRegister.registerIcon("jammyfurniture:jammy_ceramic");
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int metadata)
    {
        return this.ceramic;
    }
}
