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
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class DeadPineBranchDecorator extends TrunkVineDecorator {
	public static final DeadPineBranchDecorator INSTANCE = new DeadPineBranchDecorator();
	public static com.mojang.serialization.Codec<DeadPineBranchDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("dead_pine_branch_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		for(int i = 3; i < listBlockPos.size(); i++){
			int random1 = random.nextInt(9);
			int random2 = random.nextInt(9);
			int random3 = random.nextInt(9);
			int random4 = random.nextInt(9);
		if (random1 == 0) {
			BlockPos bp1 = listBlockPos.get(i).west();
			if (Feature.isAir(levelReader, bp1)) {
				biConsumer.accept(bp1, RegionsUnexploredBlocks.PINE_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST));
			}
		} else if (random2 == 0) {
			BlockPos bp2 = listBlockPos.get(i).east();
			if (Feature.isAir(levelReader, bp2)) {
				biConsumer.accept(bp2, RegionsUnexploredBlocks.PINE_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST));
			}
		} else if (random3 == 0) {
			BlockPos bp3 = listBlockPos.get(i).north();
			if (Feature.isAir(levelReader, bp3)) {
				biConsumer.accept(bp3, RegionsUnexploredBlocks.PINE_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH));
			}
		} else if (random4 == 0) {
			BlockPos bp4 = listBlockPos.get(i).south();
			if (Feature.isAir(levelReader, bp4)) {
				biConsumer.accept(bp4, RegionsUnexploredBlocks.PINE_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH));
			}
		}
	}
	}
}