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
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class RedwoodTrunkDecorator extends TrunkVineDecorator {
	public static final RedwoodTrunkDecorator INSTANCE = new RedwoodTrunkDecorator();
	public static com.mojang.serialization.Codec<RedwoodTrunkDecorator> codec;
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
			int i1 = context.random().nextInt(5)+5;
			int i2 = context.random().nextInt(5)+5;
			int i3 = context.random().nextInt(5)+5;
			int i4 = context.random().nextInt(5)+5;
			BlockPos newpos = context.logs().get(2);
			
			BlockPos p1 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
			BlockPos p2 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()+1);
			BlockPos p3 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
			BlockPos p4 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ());
			
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos posnorthwest = context.logs().get(i);
			//northwest
			BlockPos bpnw = posnorthwest.west();
			if(i>0 && i<=i1){
					context.setBlock(bpnw, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					context.setBlock(bpnw.above(), RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					if (!context.isAir(bpnw)) {
						if(i==0){
							context.setBlock(bpnw, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
							}
					context.setBlock(bpnw.below(), Blocks.DIRT.defaultBlockState());
					}
			}

			BlockPos bpnw1 = posnorthwest.east();
			
			if(i>0 && i<=i2){
					context.setBlock(bpnw1, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					context.setBlock(bpnw1.above(), RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					if (!context.isAir(bpnw1)) {
						if(i==0){
							context.setBlock(bpnw1, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
							}
					context.setBlock(bpnw1.below(), Blocks.DIRT.defaultBlockState());
					}
			}
			
			BlockPos bpnw2 = posnorthwest.north();
			if(i>0 && i<=i3){
					context.setBlock(bpnw2, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					context.setBlock(bpnw2.above(), RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					if (!context.isAir(bpnw2)) {
						if(i==0){
							context.setBlock(bpnw2, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
							}
					context.setBlock(bpnw2.below(), Blocks.DIRT.defaultBlockState());
					}
			}
			
			BlockPos bpnw3 = posnorthwest.south();
			if(i>0 && i<=i4){
					context.setBlock(bpnw3, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					context.setBlock(bpnw3.above(), RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
					if (!context.isAir(bpnw3)) {
						if(i==0){
							context.setBlock(bpnw3, RegionsUnexploredBlocks.REDWOOD_LOG.get().defaultBlockState());
							}
					context.setBlock(bpnw3.below(), Blocks.DIRT.defaultBlockState());
					}
			}
		}
	}
}

