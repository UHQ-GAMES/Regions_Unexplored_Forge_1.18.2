/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.regionsunexplored as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

public class MediumYellowBioshroomCaps extends TrunkVineDecorator {
	public static final MediumYellowBioshroomCaps INSTANCE = new MediumYellowBioshroomCaps();
	public static com.mojang.serialization.Codec<MediumYellowBioshroomCaps> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(Context context) {
		BlockPos newpos = context.logs().get(context.logs().size()-1);
		int newpos1 = context.logs().size()-2;

		for(int i = 3; i< newpos1; i++){
			int doPlace = context.random().nextInt(4);
			int directions = context.random().nextInt(4);
			if(doPlace == 1){
				//NORTHWEST
				if(directions==0){
					BlockPos do1 = context.logs().get(i).north();
					BlockPos do2 = context.logs().get(i).west();
					BlockPos do3 = do1.west();
					if (isReplaceable(context.level(), do1)) {
						context.setBlock(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do2)) {
						context.setBlock(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do3)) {
						context.setBlock(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
				}
				//SOUTHWEST
				if(directions==1){
					BlockPos do1 = context.logs().get(i).south();
					BlockPos do2 = context.logs().get(i).west();
					BlockPos do3 = do1.west();
					if (isReplaceable(context.level(), do1)) {
						context.setBlock(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do2)) {
						context.setBlock(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do3)) {
						context.setBlock(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}

				}
				//NORTHEAST
				if(directions==2){
					BlockPos do1 = context.logs().get(i).north();
					BlockPos do2 = context.logs().get(i).east();
					BlockPos do3 = do1.east();
					if (isReplaceable(context.level(), do1)) {
						context.setBlock(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do2)) {
						context.setBlock(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do3)) {
						context.setBlock(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}

				}
				//SOUTHEAST
				if(directions==3){
					BlockPos do1 = context.logs().get(i).south();
					BlockPos do2 = context.logs().get(i).east();
					BlockPos do3 = do1.east();
					if (isReplaceable(context.level(), do1)) {
						context.setBlock(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do2)) {
						context.setBlock(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(context.level(), do3)) {
						context.setBlock(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}

				}
			}
		}
		BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
		BlockPos px1e1 = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
		BlockPos px1e2 = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ());
		BlockPos px1w1 = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
		BlockPos px1w2 = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ());
		BlockPos px1s1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
		BlockPos px1se = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()+1);
		BlockPos px1see = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()+1);
		BlockPos px1sew = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1sw = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1sww = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1swe = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()-2);
		BlockPos px1ne = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1nee = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1new = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()-2);
		BlockPos px1nw = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()+1);
		BlockPos px1nww = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()+1);
		BlockPos px1nwe = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1s2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1n1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1n2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-2);

		if (isReplaceable(context.level(), px1)) {
			context.setBlock(px1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1e1)) {
			context.setBlock(px1e1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1e2)) {
			context.setBlock(px1e2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1w1)) {
			context.setBlock(px1w1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1w2)) {
			context.setBlock(px1w2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1s1)) {
			context.setBlock(px1s1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1s2)) {
			context.setBlock(px1s2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1n1)) {
			context.setBlock(px1n1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1n2)) {
			context.setBlock(px1n2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1se)) {
			context.setBlock(px1se, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1see)) {
			context.setBlock(px1see, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1sew)) {
			context.setBlock(px1sew, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1sw)) {
			context.setBlock(px1sw, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1sww)) {
			context.setBlock(px1sww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1swe)) {
			context.setBlock(px1swe, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1ne)) {
			context.setBlock(px1ne, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1nee)) {
			context.setBlock(px1nee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1new)) {
			context.setBlock(px1new, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1nw)) {
			context.setBlock(px1nw, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1nww)) {
			context.setBlock(px1nww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1nwe)) {
			context.setBlock(px1nwe, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
	}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
		return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
	}

	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
	}
}

