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
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BigYellowBioshroomCaps extends TrunkVineDecorator {
	public static final BigYellowBioshroomCaps INSTANCE = new BigYellowBioshroomCaps();
	public static com.mojang.serialization.Codec<BigYellowBioshroomCaps> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("big_yellow_bioshroom_caps");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		BlockPos newpos1 = listBlockPos.get(listBlockPos.size()-1);
		BlockPos[] shroomlight = {newpos1.north(), newpos1.south(), newpos1.east(), newpos1.west(), newpos1.south().west(), newpos1.south().east(), newpos1.north().west(), newpos1.north().east()};
		BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
		int newposl = listBlockPos.size()-2;

		for(int j = 0; j< shroomlight.length; j++){
			int doPlace = random.nextInt(4);
			if(doPlace==0){
				if (isReplaceable(levelReader, shroomlight[j])) {
					biConsumer.accept(shroomlight[j], Blocks.SHROOMLIGHT.defaultBlockState());
				}
			}
		}

		for(int i = 3; i< newposl; i++){
			int doPlace = random.nextInt(4);
			int directions = random.nextInt(4);
			if(doPlace == 0){
				//NORTHWEST
				if(directions==0){
					BlockPos do1 = listBlockPos.get(i).north();
					BlockPos do2 = listBlockPos.get(i).west();
					BlockPos do3 = do1.west();
					if (isReplaceable(levelReader, do1)) {
						biConsumer.accept(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do2)) {
						biConsumer.accept(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do3)) {
						biConsumer.accept(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
				}
				//SOUTHWEST
				if(directions==1){
					BlockPos do1 = listBlockPos.get(i).south();
					BlockPos do2 = listBlockPos.get(i).west();
					BlockPos do3 = do1.west();
					if (isReplaceable(levelReader, do1)) {
						biConsumer.accept(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do2)) {
						biConsumer.accept(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do3)) {
						biConsumer.accept(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}

				}
				//NORTHEAST
				if(directions==2){
					BlockPos do1 = listBlockPos.get(i).north();
					BlockPos do2 = listBlockPos.get(i).east();
					BlockPos do3 = do1.east();
					if (isReplaceable(levelReader, do1)) {
						biConsumer.accept(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do2)) {
						biConsumer.accept(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do3)) {
						biConsumer.accept(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}

				}
				//SOUTHEAST
				if(directions==3){
					BlockPos do1 = listBlockPos.get(i).south();
					BlockPos do2 = listBlockPos.get(i).east();
					BlockPos do3 = do1.east();
					if (isReplaceable(levelReader, do1)) {
						biConsumer.accept(do1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do2)) {
						biConsumer.accept(do2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
					}
					if (isReplaceable(levelReader, do3)) {
						biConsumer.accept(do3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
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

		if (isReplaceable(levelReader, px1)) {
			biConsumer.accept(px1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1e1)) {
			biConsumer.accept(px1e1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1e2)) {
			biConsumer.accept(px1e2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1w1)) {
			biConsumer.accept(px1w1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1w2)) {
			biConsumer.accept(px1w2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1s1)) {
			biConsumer.accept(px1s1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1s2)) {
			biConsumer.accept(px1s2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1n1)) {
			biConsumer.accept(px1n1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1n2)) {
			biConsumer.accept(px1n2, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1se)) {
			biConsumer.accept(px1se, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1see)) {
			biConsumer.accept(px1see, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1sew)) {
			biConsumer.accept(px1sew, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1sw)) {
			biConsumer.accept(px1sw, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1sww)) {
			biConsumer.accept(px1sww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1swe)) {
			biConsumer.accept(px1swe, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1ne)) {
			biConsumer.accept(px1ne, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1nee)) {
			biConsumer.accept(px1nee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1new)) {
			biConsumer.accept(px1new, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1nw)) {
			biConsumer.accept(px1nw, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1nww)) {
			biConsumer.accept(px1nww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1nwe)) {
			biConsumer.accept(px1nwe, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1nw1)) {
			biConsumer.accept(px1nw1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1ne1)) {
			biConsumer.accept(px1ne1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1se1)) {
			biConsumer.accept(px1se1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, px1sw1)) {
			biConsumer.accept(px1sw1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(levelReader, w3)) {
			biConsumer.accept(w3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, w3s)) {
			biConsumer.accept(w3s, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, w3ss)) {
			biConsumer.accept(w3ss, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, w3n)) {
			biConsumer.accept(w3n, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, w3nn)) {
			biConsumer.accept(w3nn, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(levelReader, e3)) {
			biConsumer.accept(e3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, e3s)) {
			biConsumer.accept(e3s, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, e3ss)) {
			biConsumer.accept(e3ss, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, e3n)) {
			biConsumer.accept(e3n, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, e3nn)) {
			biConsumer.accept(e3nn, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(levelReader, n3)) {
			biConsumer.accept(n3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, n3e)) {
			biConsumer.accept(n3e, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, n3ee)) {
			biConsumer.accept(n3ee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, n3w)) {
			biConsumer.accept(n3w, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, n3ww)) {
			biConsumer.accept(n3ww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}

		if (isReplaceable(levelReader, s3)) {
			biConsumer.accept(s3, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, s3e)) {
			biConsumer.accept(s3e, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, s3ee)) {
			biConsumer.accept(s3ee, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, s3w)) {
			biConsumer.accept(s3w, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
		if (isReplaceable(levelReader, s3ww)) {
			biConsumer.accept(s3ww, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
		}
	}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
		return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
	}

	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
	}
}

