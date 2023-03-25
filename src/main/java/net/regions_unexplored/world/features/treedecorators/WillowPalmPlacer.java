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
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class WillowPalmPlacer extends TrunkVineDecorator {
	public static final WillowPalmPlacer INSTANCE = new WillowPalmPlacer();
	public static com.mojang.serialization.Codec<WillowPalmPlacer> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("willow_palm_placer");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
			BlockPos px1 = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
			BlockPos px2 = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ());
			BlockPos px3 = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ());
			BlockPos px4 = new BlockPos(newpos.getX()+3,newpos.getY(),newpos.getZ());
			BlockPos px5 = new BlockPos(newpos.getX()+2,newpos.getY()+2,newpos.getZ());
			
			BlockPos nx1 = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
			BlockPos nx2 = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ());
			BlockPos nx3 = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ());
			BlockPos nx4 = new BlockPos(newpos.getX()-3,newpos.getY(),newpos.getZ());
			BlockPos nx5 = new BlockPos(newpos.getX()-2,newpos.getY()+2,newpos.getZ());

			
			BlockPos pz1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
			BlockPos pz2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+2);
			BlockPos pz3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+3);
			BlockPos pz4 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+3);
			BlockPos pz5 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ()+2);
			
			BlockPos nz1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);
			BlockPos nz2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-2);
			BlockPos nz3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-3);
			BlockPos nz4 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-3);
			BlockPos nz5 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ()-2);

			
			BlockPos y1 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ());
			
			BlockPos fn1 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()+1);
			BlockPos fn2 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()+1);
			BlockPos fn3 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()-1);
			BlockPos fn4 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()-1);
			
			BlockPos fp1 = new BlockPos(newpos.getX()+1,newpos.getY()-1,newpos.getZ());
			BlockPos fp2 = new BlockPos(newpos.getX()-1,newpos.getY()-1,newpos.getZ());
			BlockPos fp3 = new BlockPos(newpos.getX(),newpos.getY()-1,newpos.getZ()+1);
			BlockPos fp4 = new BlockPos(newpos.getX(),newpos.getY()-1,newpos.getZ()-1);
			if (Feature.isAir(levelReader, y1)) {
			biConsumer.accept(y1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, fn1)) {
			biConsumer.accept(fn1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fn2)) {
			biConsumer.accept(fn2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fn3)) {
			biConsumer.accept(fn3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fn4)) {
			biConsumer.accept(fn4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, fp1)) {
			biConsumer.accept(fp1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fp2)) {
			biConsumer.accept(fp2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fp3)) {
			biConsumer.accept(fp3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, fp4)) {
			biConsumer.accept(fp4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, px1)) {
			biConsumer.accept(px1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px2)) {
			biConsumer.accept(px2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px3)) {
			biConsumer.accept(px3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px4)) {
			biConsumer.accept(px4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px5)) {
			biConsumer.accept(px5, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, nx1)) {
			biConsumer.accept(nx1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx2)) {
			biConsumer.accept(nx2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx3)) {
			biConsumer.accept(nx3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx4)) {
			biConsumer.accept(nx4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx5)) {
			biConsumer.accept(nx5, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pz1)) {
			biConsumer.accept(pz1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz2)) {
			biConsumer.accept(pz2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz3)) {
			biConsumer.accept(pz3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz4)) {
			biConsumer.accept(pz4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz5)) {
			biConsumer.accept(pz5, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, nz1)) {
			biConsumer.accept(nz1, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz2)) {
			biConsumer.accept(nz2, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz3)) {
			biConsumer.accept(nz3, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz4)) {
			biConsumer.accept(nz4, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz5)) {
			biConsumer.accept(nz5, RegionsUnexploredBlocks.WILLOW_LEAVES.get().defaultBlockState());
			}
		}
	}

