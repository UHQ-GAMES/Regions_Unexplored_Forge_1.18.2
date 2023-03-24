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
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;

public class DeadBranchDecorator extends TrunkVineDecorator {
	public static final DeadBranchDecorator INSTANCE = new DeadBranchDecorator();
	public static com.mojang.serialization.Codec<DeadBranchDecorator> codec;
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
		for(int i = 3; i < context.logs().size(); i++){
			int random1 = context.random().nextInt(5);
			int random2 = context.random().nextInt(5);
			int random3 = context.random().nextInt(5);
			int random4 = context.random().nextInt(5);
		if (random1 == 0) {
			BlockPos bp1 = context.logs().get(i).west();
			if (context.isAir(bp1)) {
				context.setBlock(bp1, RegionsUnexploredBlocks.DEAD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST));
			}
		} else if (random2 == 0) {
			BlockPos bp2 = context.logs().get(i).east();
			if (context.isAir(bp2)) {
				context.setBlock(bp2, RegionsUnexploredBlocks.DEAD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST));
			}
		} else if (random3 == 0) {
			BlockPos bp3 = context.logs().get(i).north();
			if (context.isAir(bp3)) {
				context.setBlock(bp3, RegionsUnexploredBlocks.DEAD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH));
			}
		} else if (random4 == 0) {
			BlockPos bp4 = context.logs().get(i).south();
			if (context.isAir(bp4)) {
				context.setBlock(bp4, RegionsUnexploredBlocks.DEAD_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH));
			}
		}
	}
	}
}