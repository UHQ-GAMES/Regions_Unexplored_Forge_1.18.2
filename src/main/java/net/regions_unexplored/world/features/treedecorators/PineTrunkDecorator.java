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
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.BlockPos;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class PineTrunkDecorator extends TrunkVineDecorator {
	public static final PineTrunkDecorator INSTANCE = new PineTrunkDecorator();
	public static com.mojang.serialization.Codec<PineTrunkDecorator> codec;
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
			int size = context.random().nextInt(3)+2;
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);
			if(Feature.isGrassOrDirt(context.level(), newpos)){continue;}
			else{
			if(i<size){
				context.setBlock(newpos, RegionsUnexploredBlocks.STRIPPED_PINE_LOG.get().defaultBlockState());
			}
			else if(i==size){
				context.setBlock(newpos, RegionsUnexploredBlocks.PINE_LOG_TRANSITION.get().defaultBlockState());
			}
		} 
		}
		}
	}

