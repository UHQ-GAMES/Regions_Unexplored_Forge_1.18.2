package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BirchStemDecorator extends TrunkVineDecorator {
	public static final BirchStemDecorator INSTANCE = new BirchStemDecorator();
	public static com.mojang.serialization.Codec<BirchStemDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("birch_stem_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			int size = random.nextInt(6);
			BlockPos newpos = listBlockPos.get(6);
			if(listBlockPos.size()>9){
			if(size==0){
				if(random.nextInt(2)==0) {
					biConsumer.accept(newpos.west(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
				}
				else {
					biConsumer.accept(newpos.west(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST));
				}
			}
			else if(size==1){
				if(random.nextInt(2)==0) {
					biConsumer.accept(newpos.east(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
				}
				else {
					biConsumer.accept(newpos.east(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST));
				}
			}
			else if(size==2){
				if(random.nextInt(2)==0) {
					biConsumer.accept(newpos.north(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
				}
				else {
					biConsumer.accept(newpos.north(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH));
				}
			}
			else if(size==3){
				if(random.nextInt(2)==0) {
					biConsumer.accept(newpos.south(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
				}
				else {
					biConsumer.accept(newpos.south(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH));
				}
			}
		}
	}
}

