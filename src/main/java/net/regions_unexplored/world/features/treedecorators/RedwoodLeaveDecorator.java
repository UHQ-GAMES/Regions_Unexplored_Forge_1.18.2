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

import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class RedwoodLeaveDecorator extends LeaveVineDecorator {
	public static final RedwoodLeaveDecorator INSTANCE = new RedwoodLeaveDecorator();
	public static com.mojang.serialization.Codec<LeaveVineDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	public RedwoodLeaveDecorator() {
		super(1f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		context.leaves().forEach((blockpos) -> {
			

			if (context.random().nextInt(2) == 0) {
				BlockPos bp4 = blockpos.above();
				if (context.isAir(bp4)) {
					addVine(bp4, context);
				}
			}
			if (context.random().nextInt(2) == 0) {
				BlockPos bp5 = blockpos.below();
				if (context.isAir(bp5)) {
					addVine(bp5, context);
				}
			}
			
		});
	}

	private static void addVine(BlockPos pos, TreeDecorator.Context context) {
		context.setBlock(pos, RegionsUnexploredBlocks.REDWOOD_LEAVES.get().defaultBlockState());
	}
}