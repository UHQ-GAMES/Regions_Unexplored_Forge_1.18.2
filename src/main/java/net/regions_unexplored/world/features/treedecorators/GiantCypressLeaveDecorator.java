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
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class GiantCypressLeaveDecorator extends LeaveVineDecorator {
	public static final GiantCypressLeaveDecorator INSTANCE = new GiantCypressLeaveDecorator();
	public static com.mojang.serialization.Codec<LeaveVineDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	public GiantCypressLeaveDecorator() {
		super(1f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(Context context) {
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

	private static void addVine(BlockPos pos, Context context) {
		context.setBlock(pos, RegionsUnexploredBlocks.CYPRESS_LEAVES.get().defaultBlockState());
	}
}