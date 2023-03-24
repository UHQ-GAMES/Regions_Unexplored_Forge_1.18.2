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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

public class BigYellowBioshroomCaps extends TrunkVineDecorator {
	public static final BigYellowBioshroomCaps INSTANCE = new BigYellowBioshroomCaps();
	public static com.mojang.serialization.Codec<BigYellowBioshroomCaps> codec;
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
		BlockPos newpos1 = context.logs().get(context.logs().size()-1);
		BlockPos[] shroomlight = {newpos1.north(), newpos1.south(), newpos1.east(), newpos1.west(), newpos1.south().west(), newpos1.south().east(), newpos1.north().west(), newpos1.north().east()};
		BlockPos newpos = context.logs().get(context.logs().size()-1);
		int newposl = context.logs().size()-2;

		for(int j = 0; j< shroomlight.length; j++){
			int doPlace = context.random().nextInt(4);
			if(doPlace==0){
				if (isReplaceable(context.level(), shroomlight[j])) {
					context.setBlock(shroomlight[j], Blocks.SHROOMLIGHT.defaultBlockState());
				}
			}
		}

		for(int i = 3; i< newposl; i++){
			int doPlace = context.random().nextInt(4);
			int directions = context.random().nextInt(4);
			if(doPlace == 0){
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
		BlockPos px1nw1 = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1ne1 = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1sw1 = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()-2);
		BlockPos px1se1 = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()-2);
		BlockPos px1s2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1n1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1n2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-2);

		BlockPos w3 = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ());
		BlockPos w3s = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ()+1);
		BlockPos w3ss = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ()+2);
		BlockPos w3n = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ()-1);
		BlockPos w3nn = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ()-2);

		BlockPos e3 = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ());
		BlockPos e3s = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ()+1);
		BlockPos e3ss = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ()+2);
		BlockPos e3n = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ()-1);
		BlockPos e3nn = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ()-2);

		BlockPos n3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-3);
		BlockPos n3e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()-3);
		BlockPos n3ee = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()-3);
		BlockPos n3w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()-3);
		BlockPos n3ww = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()-3);

		BlockPos s3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+3);
		BlockPos s3e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ()+3);
		BlockPos s3ee = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ()+3);
		BlockPos s3w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ()+3);
		BlockPos s3ww = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ()+3);

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
		if (isReplaceable(context.level(), px1nw1)) {
			context.setBlock(px1nw1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1ne1)) {
			context.setBlock(px1ne1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1se1)) {
			context.setBlock(px1se1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), px1sw1)) {
			context.setBlock(px1sw1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(context.level(), w3)) {
			context.setBlock(w3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), w3s)) {
			context.setBlock(w3s, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), w3ss)) {
			context.setBlock(w3ss, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), w3n)) {
			context.setBlock(w3n, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), w3nn)) {
			context.setBlock(w3nn, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(context.level(), e3)) {
			context.setBlock(e3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), e3s)) {
			context.setBlock(e3s, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), e3ss)) {
			context.setBlock(e3ss, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), e3n)) {
			context.setBlock(e3n, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), e3nn)) {
			context.setBlock(e3nn, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(context.level(), n3)) {
			context.setBlock(n3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), n3e)) {
			context.setBlock(n3e, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), n3ee)) {
			context.setBlock(n3ee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), n3w)) {
			context.setBlock(n3w, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), n3ww)) {
			context.setBlock(n3ww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(context.level(), s3)) {
			context.setBlock(s3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), s3e)) {
			context.setBlock(s3e, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), s3ee)) {
			context.setBlock(s3ee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), s3w)) {
			context.setBlock(s3w, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(context.level(), s3ww)) {
			context.setBlock(s3ww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
	}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
		return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
	}

	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
	}
}

