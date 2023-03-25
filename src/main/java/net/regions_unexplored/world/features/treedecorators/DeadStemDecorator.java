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

import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class DeadStemDecorator extends TrunkVineDecorator {
	public static final DeadStemDecorator INSTANCE = new DeadStemDecorator();
	public static com.mojang.serialization.Codec<DeadStemDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("dead_stem_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			int size = random.nextInt(5);
			int e = random.nextInt(4)+2;
			BlockPos newpos = listBlockPos.get(e);
			if(size==0){
				biConsumer.accept(newpos.west(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
			}
			else if(size==1){
				biConsumer.accept(newpos.east(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
			}
			else if(size==2){
				biConsumer.accept(newpos.north(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
			}
			else if(size==3){
				biConsumer.accept(newpos.south(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
			}
		
	}
}