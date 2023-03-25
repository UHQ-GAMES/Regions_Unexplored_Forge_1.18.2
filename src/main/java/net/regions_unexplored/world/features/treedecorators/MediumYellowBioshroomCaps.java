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
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class MediumYellowBioshroomCaps extends TrunkVineDecorator {
	public static final MediumYellowBioshroomCaps INSTANCE = new MediumYellowBioshroomCaps();
	public static com.mojang.serialization.Codec<MediumYellowBioshroomCaps> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("medium_yellow_bioshroom_caps");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
		int newpos1 = listBlockPos.size()-2;

		for(int i = 3; i< newpos1; i++){
			int doPlace = random.nextInt(4);
			int directions = random.nextInt(4);
			if(doPlace == 1){
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
		BlockPos px1s2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+2);
		BlockPos px1n1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);
		BlockPos px1n2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-2);

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
	}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
		return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
	}

	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
	}
}

