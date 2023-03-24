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

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class DeadStemDecorator extends TrunkVineDecorator {
	public static final DeadStemDecorator INSTANCE = new DeadStemDecorator();
	public static com.mojang.serialization.Codec<DeadStemDecorator> codec;
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
			int size = context.random().nextInt(5);
			int e = context.random().nextInt(4)+2;
			BlockPos newpos = context.logs().get(e);
			if(size==0){
				context.setBlock(newpos.west(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
			}
			else if(size==1){
				context.setBlock(newpos.east(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
			}
			else if(size==2){
				context.setBlock(newpos.north(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
			}
			else if(size==3){
				context.setBlock(newpos.south(), RegionsUnexploredBlocks.DEAD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
			}
		
	}
}