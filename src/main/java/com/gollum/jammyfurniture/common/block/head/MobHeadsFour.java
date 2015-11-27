package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsFour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MobHeadsFour extends JFMobHeads {
	
	public MobHeadsFour(String registerName) {
		super(registerName, TileEntityMobHeadsFour.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0:
			case 4:
			case 8:
			case 12:
				this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F); break;
			case 1:
			case 5:
			case 9:
			case 13:
				this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F); break;
			case 2:
			case 6:
			case 10:
			case 14:
				this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F); break;
			case 3:
			case 7:
			case 11:
			case 15:
				this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			default:
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
		
	///////////
	// Event //
	///////////
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);

		switch (subBlock) {
			
			case 0:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadEnderman, 1.0F, 1.0F, true);
				return true;
			case 4:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadSlim, 1.0F, 1.0F, true);
				return true;
			case 8:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadBlaze, 1.0F, 1.0F, true);
				return true;
			case 12:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadZombiepig, 1.0F, 1.0F, true);
				return true;
			default:
		}
		return false;
	}
	
	///////////////////
	// Data du block //
	///////////////////
	
	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return ModJammyFurniture.mobHeadsFourRenderID;
	}
}
