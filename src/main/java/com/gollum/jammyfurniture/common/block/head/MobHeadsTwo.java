package com.gollum.jammyfurniture.common.block.head;

import static com.gollum.jammyfurniture.ModJammyFurniture.config;
import com.gollum.jammyfurniture.ModJammyFurniture;
import com.gollum.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsTwo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MobHeadsTwo extends JFMobHeads {

	public MobHeadsTwo(int id, String registerName) {
		super(id, registerName, TileEntityMobHeadsTwo.class);
	}
	
	/////////////////////////////////
	// Forme et collition du block //
	/////////////////////////////////
	
	@Override
	protected void getCollisionBoundingBox(int metadata, boolean isSelectBox) {
		switch (metadata) {
			case 0: this.setBlockBounds(0.25F, 0.25F, 0.425F, 0.75F, 0.75F, 1.0F ); break;
			case 1:  this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.575F, 0.75F, 0.75F); break;
			case 2:  this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.575F); break;
			case 3:  this.setBlockBounds(0.425F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			case 4:  this.setBlockBounds(0.3F, 0.25F, 0.625F, 0.7F, 0.625F, 1.0F); break;
			case 5:  this.setBlockBounds(0.0F, 0.25F, 0.3F, 0.375F, 0.625F, 0.7F); break;
			case 6:  this.setBlockBounds(0.3F, 0.25F, 0.0F, 0.7F, 0.625F, 0.375F); break;
			case 7:  this.setBlockBounds(0.625F, 0.25F, 0.3F, 1.0F, 0.625F, 0.7F); break;
			case 8:  this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F); break;
			case 9:  this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F); break;
			case 10: this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F); break;
			case 11: this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			case 12: this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F); break;
			case 13: this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F); break;
			case 14: this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F); break;
			case 15: this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); break;
			default: this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); break;
		}
	}
	
	///////////
	// Event //
	///////////
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		
		int metadata    = world.getBlockMetadata(x, y, z);
		int subBlock    = this.getEnabledMetadata(metadata);

		switch (subBlock) {
			
			case 0:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadPig, 1.0F, 1.0F, true);
				return true;
			case 4:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadSheep, 1.0F, 1.0F, true);
				return true;
			case 8:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadSkeleton, 1.0F, 1.0F, true);
				return true;
			case 12:
				world.playSound((double) x, (double) y, (double) z, config.soundHeadSpider, 1.0F, 1.0F, true);
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
		return ModJammyFurniture.mobHeadsTwoRenderID;
	}
}
