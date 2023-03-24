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
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;

public class RedwoodBranchDecorator extends TrunkVineDecorator {
	public static final RedwoodBranchDecorator INSTANCE = new RedwoodBranchDecorator();
	public static com.mojang.serialization.Codec<RedwoodBranchDecorator> codec;
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
		for(int i = 6; i < context.logs().size(); i++){
			int random1 = context.random().nextInt(7);
			int random2 = context.random().nextInt(7);
			int random3 = context.random().nextInt(7);
			int random4 = context.random().nextInt(7);
		if (random1 == 0) {
			BlockPos bp1 = context.logs().get(i).west();
			if (context.isAir(bp1)) {
				context.setBlock(bp1, RegionsUnexploredBlocks.REDWOOD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST));
				if (context.isAir(bp1.west())) {
					context.setBlock(bp1.west(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp1.north())) {
					context.setBlock(bp1.north(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp1.south())) {
					context.setBlock(bp1.south(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp1.above())) {
					context.setBlock(bp1.above(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
			}
		} else if (random2 == 0) {
			BlockPos bp2 = context.logs().get(i).east();
			if (context.isAir(bp2)) {
				context.setBlock(bp2, RegionsUnexploredBlocks.REDWOOD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST));
				if (context.isAir(bp2.east())) {
					context.setBlock(bp2.east(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp2.north())) {
					context.setBlock(bp2.north(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp2.south())) {
					context.setBlock(bp2.south(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp2.above())) {
					context.setBlock(bp2.above(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
			}
		} else if (random3 == 0) {
			BlockPos bp3 = context.logs().get(i).north();
			if (context.isAir(bp3)) {
				context.setBlock(bp3, RegionsUnexploredBlocks.REDWOOD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH));
				if (context.isAir(bp3.north())) {
					context.setBlock(bp3.north(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp3.east())) {
					context.setBlock(bp3.east(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp3.west())) {
					context.setBlock(bp3.west(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
				if (context.isAir(bp3.above())) {
					context.setBlock(bp3.above(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
				}
			}
		} else if (random4 == 0) {
			BlockPos bp4 = context.logs().get(i).south();
			if (context.isAir(bp4)) {
				context.setBlock(bp4, RegionsUnexploredBlocks.REDWOOD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH));
			}
			if (context.isAir(bp4.south())) {
				context.setBlock(bp4.south(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(bp4.east())) {
				context.setBlock(bp4.east(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(bp4.west())) {
				context.setBlock(bp4.west(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(bp4.above())) {
				context.setBlock(bp4.above(), RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
			}
		}
	}
	}
}