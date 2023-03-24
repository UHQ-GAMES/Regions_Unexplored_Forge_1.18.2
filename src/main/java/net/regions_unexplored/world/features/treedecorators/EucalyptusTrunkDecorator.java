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
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class EucalyptusTrunkDecorator extends TrunkVineDecorator {
	public static final EucalyptusTrunkDecorator INSTANCE = new EucalyptusTrunkDecorator();
	public static com.mojang.serialization.Codec<EucalyptusTrunkDecorator> codec;
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
			int size = 3;
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);

			BlockPos bp = newpos.west();
			if(i>5){
				if(context.random().nextInt(6)==0){
					if (context.isAir(bp)) {
						context.setBlock(bp, RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get().defaultBlockState());
					}
				}
			}
			
			BlockPos bp1 = newpos.east();
			if(i>5){
				if(context.random().nextInt(6)==0){
					if (context.isAir(bp1)) {
						context.setBlock(bp1, RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get().defaultBlockState());
					}	
				}
			}
			
			BlockPos bp2 = newpos.north();
			if(i>5){
				if(context.random().nextInt(6)==0){
					if (context.isAir(bp2)) {
						context.setBlock(bp2, RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get().defaultBlockState());
					}
				}
			}
			
			BlockPos bp3 = newpos.south();
			if(i>5){
				if(context.random().nextInt(6)==0){
					if (context.isAir(bp3)) {
						context.setBlock(bp3, RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get().defaultBlockState());
					}
				}
			}
			
			}
		}
	}

