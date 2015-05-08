package mods.jammyfurniture.common.block.head;

import mods.jammyfurniture.ModJammyFurniture;
import mods.jammyfurniture.common.tilesentities.head.TileEntityMobHeadsThree;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MobHeadsThree extends JFMobHeads {
	
	public MobHeadsThree(int id, String registerName) {
		super(id, registerName, TileEntityMobHeadsThree.class);
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
				world.playSound((double) x, (double) y, (double) z, "random.eat", 1.0F, 1.0F, true);
				return true;
			case 4:
				world.playSound((double) x, (double) y, (double) z, "mob.wolf.growl", 1.0F, 1.0F, true);
				return true;
			case 8:
				world.playSound((double) x, (double) y, (double) z, "mob.zombie.say", 1.0F, 1.0F, true);
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
		return ModJammyFurniture.mobHeadsThreeRenderID;
	}
	
}
