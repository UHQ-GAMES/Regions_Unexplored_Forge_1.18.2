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
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

public class SpanishMossDecorator extends LeaveVineDecorator {
	public static final SpanishMossDecorator INSTANCE = new SpanishMossDecorator();
	public static com.mojang.serialization.Codec<LeaveVineDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	public SpanishMossDecorator() {
		super(1f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(Context context) {
		context.leaves().forEach((blockpos) -> {
			if (context.random().nextInt(4) == 0) {
				BlockPos bp = blockpos.below();
				if (context.isAir(bp)) {
					addVine(bp, context);
				}
			}
			
		});
	}

	private static void addVine(BlockPos pos, Context context) {
		int size = context.random().nextInt(4);
		BlockPos place = pos;
		for(int i = 0; i<=size; i++){
			if(context.isAir(place)){
				if(i==size){
					context.setBlock(place, RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState());
				}
				else {
					context.setBlock(place, RegionsUnexploredBlocks.SPANISH_MOSS_PLANT.get().defaultBlockState());
				}
				place = place.below();
			}
			else{
				if(i!=0){
					context.setBlock(place.above(), RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState());
				}
				break;
			}
		}
	}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
		return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
	}

	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SpanishMossDecorator::isReplaceablePlant);
	}
}