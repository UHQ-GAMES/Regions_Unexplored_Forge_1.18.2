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
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class GiantCypressLeaveDecorator extends LeaveVineDecorator {
	public static final GiantCypressLeaveDecorator INSTANCE = new GiantCypressLeaveDecorator();
	public static com.mojang.serialization.Codec<GiantCypressLeaveDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("giant_cypress_leave_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		listBlockPos2.forEach((blockpos) -> {
			

			if (random.nextInt(2) == 0) {
				BlockPos bp4 = blockpos.above();
				if (Feature.isAir(levelReader, bp4)) {
					addVine(levelReader, bp4, biConsumer);
				}
			}
			if (random.nextInt(2) == 0) {
				BlockPos bp5 = blockpos.below();
				if (Feature.isAir(levelReader, bp5)) {
					addVine(levelReader, bp5, biConsumer);
				}
			}
			
		});
	}

	private static void addVine(LevelSimulatedReader levelReader, BlockPos blockPos, BiConsumer<BlockPos, BlockState> biConsumer) {
		biConsumer.accept(blockPos, RegionsUnexploredBlocks.CYPRESS_LEAVES.get().defaultBlockState());
	}
}