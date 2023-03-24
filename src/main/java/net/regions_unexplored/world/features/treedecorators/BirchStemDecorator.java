package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;

public class BirchStemDecorator extends TrunkVineDecorator {
	public static final BirchStemDecorator INSTANCE = new BirchStemDecorator();
	public static com.mojang.serialization.Codec<BirchStemDecorator> codec;
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
			int size = context.random().nextInt(6);
			BlockPos newpos = context.logs().get(6);
			if(context.logs().size()>9){
			if(size==0){
				if(context.random().nextInt(2)==0) {
					context.setBlock(newpos.west(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
				}
				else {
					context.setBlock(newpos.west(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST));
				}
			}
			else if(size==1){
				if(context.random().nextInt(2)==0) {
					context.setBlock(newpos.east(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
				}
				else {
					context.setBlock(newpos.east(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST));
				}
			}
			else if(size==2){
				if(context.random().nextInt(2)==0) {
					context.setBlock(newpos.north(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
				}
				else {
					context.setBlock(newpos.north(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH));
				}
			}
			else if(size==3){
				if(context.random().nextInt(2)==0) {
					context.setBlock(newpos.south(), Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
				}
				else {
					context.setBlock(newpos.south(), RegionsUnexploredBlocks.BIRCH_BRANCH.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH));
				}
			}
		}
	}
}

