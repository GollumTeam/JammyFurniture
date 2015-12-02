package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;

import com.gollum.jammyfurniture.client.ClientProxyJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MobHeadsThree extends JFMobHeads {
	
	public MobHeadsThree(String registerName) {
		super(registerName, TileEntityMobHeadsThree.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:  this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F); break;
			case 1:  this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F); break;
			case 2:  this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F); break;
			case 3:  this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			case 4:  this.setBlockBounds(0.3F, 0.25F, 0.55F, 0.7F, 0.75F, 1.0F); break;
			case 5:  this.setBlockBounds(0.0F, 0.25F, 0.3F, 0.45F, 0.75F, 0.7F); break;
			case 6:  this.setBlockBounds(0.3F, 0.25F, 0.0F, 0.7F, 0.75F, 0.45F); break;
			case 7:  this.setBlockBounds(0.55F, 0.25F, 0.3F, 1.0F, 0.75F, 0.7F); break;
			case 8:  this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F); break;
			case 9:  this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F); break;
			case 10: this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F); break;
			case 11: this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			case 12: this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F); break;
			case 13: this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F); break;
			case 14: this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F); break;
			case 15: this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
	
	////////////////////
	// Rendu du block //
	////////////////////

	@SideOnly(Side.CLIENT)
	@Override
	public int getGCLRenderType() {
		return ClientProxyJammyFurniture.mobHeadsThreeRenderID;
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	/* FIXME
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);

		switch (subBlock) {
			
			case 0:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadSteve, 1.0F, 1.0F, true);
				return true;
			case 4:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadWolf, 1.0F, 1.0F, true);
				return true;
			case 8:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadZombie, 1.0F, 1.0F, true);
				return true;
			default:
		}
		return false;
	}
	*/
	
}
