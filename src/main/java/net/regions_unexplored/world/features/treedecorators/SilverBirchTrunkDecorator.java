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

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class SilverBirchTrunkDecorator extends TrunkVineDecorator {
	public static final SilverBirchTrunkDecorator INSTANCE = new SilverBirchTrunkDecorator();
	public static com.mojang.serialization.Codec<SilverBirchTrunkDecorator> codec;
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
	public void place(TreeDecorator.Context context) {
		for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);
			if(i==0){
				if(context.level().isStateAtPosition(newpos, SilverBirchTrunkDecorator::isGrass)){
					context.setBlock(newpos.above(), RegionsUnexploredBlocks.SILVER_BIRCH_LOG_BASE.get().defaultBlockState());
				}
				else{
					context.setBlock(newpos, RegionsUnexploredBlocks.SILVER_BIRCH_LOG_BASE.get().defaultBlockState());
				}
			}
		}
	}
	public static boolean isGrass(BlockState state) {
		return state.is(Blocks.GRASS_BLOCK)
				||state.is(Blocks.MYCELIUM)
				||state.is(Blocks.DIRT)
				||state.is(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get())
				||state.is(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get())
				||state.is(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get())
				||state.is(RegionsUnexploredBlocks.FOREST_DIRT.get())
				||state.is(RegionsUnexploredBlocks.PLAINS_DIRT.get());
	}
}

