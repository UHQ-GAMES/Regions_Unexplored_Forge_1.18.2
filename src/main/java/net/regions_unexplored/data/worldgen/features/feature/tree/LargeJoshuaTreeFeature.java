package net.regions_unexplored.data.worldgen.features.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import java.util.Random;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.world.level.block.BranchBlock;
import net.regions_unexplored.world.level.block.JoshuaLeavesBlock;

import java.util.Random;

public class LargeJoshuaTreeFeature extends Feature<NoneFeatureConfiguration> {

    public LargeJoshuaTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int height = context.random().nextInt(5) + 8;
        int check = 0;

        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height) {
            if (check == height) {
                if (level.isOutsideBuildHeight(checkPos.above(6))) {
                    return false;
                }
            }
            if (level.getBlockState(checkPos).getMaterial().isReplaceable() ) {
                checkPos.move(Direction.UP);
                check = check + 1;
            } else {
                return false;
            }
        }

        BlockPos.MutableBlockPos placePos = pos.mutable();
        int checkHeight = 0;
        while (checkHeight <= height) {
            if (level.getBlockState(placePos).getMaterial().isReplaceable() ) {
                level.setBlock(placePos, RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
                if (checkHeight==height){
                    placeLeaves(level, placePos);
                    placeBranch(level, placePos.below().below().below().below().below());
                    placeBranch2(level, placePos.below().below().below().below().below().below());
                }
                placePos.move(Direction.UP);
                checkHeight = checkHeight + 1;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean placeLeaves(LevelAccessor level, BlockPos pos) {
        if(level.getBlockState(pos.north()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), RegionsUnexploredBlocks.JOSHUA_BEARD.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(level.getBlockState(pos.south()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), RegionsUnexploredBlocks.JOSHUA_BEARD.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(level.getBlockState(pos.east()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), RegionsUnexploredBlocks.JOSHUA_BEARD.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(level.getBlockState(pos.west()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), RegionsUnexploredBlocks.JOSHUA_BEARD.get().defaultBlockState().setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        if(level.getBlockState(pos.above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.above())){
            level.setBlock(pos.above(), RegionsUnexploredBlocks.JOSHUA_LEAVES.get().defaultBlockState().setValue(JoshuaLeavesBlock.NATURAL, true).setValue(JoshuaLeavesBlock.HALF, DoubleBlockHalf.LOWER), 2);
        }
        if(level.getBlockState(pos.above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(pos.above().above())){
            level.setBlock(pos.above().above(), RegionsUnexploredBlocks.JOSHUA_LEAVES.get().defaultBlockState().setValue(JoshuaLeavesBlock.NATURAL, true).setValue(JoshuaLeavesBlock.HALF, DoubleBlockHalf.UPPER), 2);
        }

        return true;
    }

    public boolean placeBranch(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int n = random.nextInt(2);
        BlockPos north = new BlockPos(pos.getX(), pos.getY()+n, pos.getZ());
        int s = random.nextInt(2);
        BlockPos south = new BlockPos(pos.getX(), pos.getY()+s, pos.getZ());
        int e = random.nextInt(2);
        BlockPos east = new BlockPos(pos.getX(), pos.getY()+e, pos.getZ());
        int w = random.nextInt(2);
        BlockPos west = new BlockPos(pos.getX(), pos.getY()+w, pos.getZ());

        if(level.getBlockState(north.north()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north())){
            level.setBlock(north.north(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
        }
        if(level.getBlockState(north.north().north().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().north().above())){
            level.setBlock(north.north().north().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().north().north().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().north().north().above().above())){
            level.setBlock(north.north().north().north().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().north().north().above().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().north().north().above().above().above())){
            level.setBlock(north.north().north().north().above().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, north.north().north().north().above().above().above());
        }

        if(level.getBlockState(south.south()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south())){
            level.setBlock(south.south(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
        }
        if(level.getBlockState(south.south().south().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().south().above())){
            level.setBlock(south.south().south().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().south().south().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().south().south().above().above())){
            level.setBlock(south.south().south().south().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().south().south().above().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().south().south().above().above().above())){
            level.setBlock(south.south().south().south().above().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, south.south().south().south().above().above().above());
        }

        if(level.getBlockState(east.east()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(east.east())){
            level.setBlock(east.east(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
        }
        if(level.getBlockState(east.east().east().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(east.east().east().above())){
            level.setBlock(east.east().east().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(east.east().east().east().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(east.east().east().east().above().above())){
            level.setBlock(east.east().east().east().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(east.east().east().east().above().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(east.east().east().east().above().above().above())){
            level.setBlock(east.east().east().east().above().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, east.east().east().east().above().above().above());
        }

        if(level.getBlockState(west.west()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(west.west())){
            level.setBlock(west.west(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
        }
        if(level.getBlockState(west.west().west().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(west.west().west().above())){
            level.setBlock(west.west().west().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(west.west().west().west().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(west.west().west().west().above().above())){
            level.setBlock(west.west().west().west().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(west.west().west().west().above().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(west.west().west().west().above().above().above())){
            level.setBlock(west.west().west().west().above().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, west.west().west().west().above().above().above());
        }

        return true;
    }

    public boolean placeBranch2(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int n = random.nextInt(3);
        BlockPos north = new BlockPos(pos.getX(), pos.getY()+n, pos.getZ());
        int s = random.nextInt(3);
        BlockPos south = new BlockPos(pos.getX(), pos.getY()+s, pos.getZ());
        int e = random.nextInt(3);
        BlockPos east = new BlockPos(pos.getX(), pos.getY()+e, pos.getZ());
        int w = random.nextInt(3);
        BlockPos west = new BlockPos(pos.getX(), pos.getY()+w, pos.getZ());

        if(level.getBlockState(north.north().west()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().west())){
            level.setBlock(north.north().west(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().west().north().west().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().west().north().west().above())){
            level.setBlock(north.north().west().north().west().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().west().north().west().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().west().north().west().above().above())){
            level.setBlock(north.north().west().north().west().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, north.north().west().north().west().above().above());
        }

        if(level.getBlockState(north.north().east()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().east())){
            level.setBlock(north.north().east(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().east().north().east().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().east().north().east().above())){
            level.setBlock(north.north().east().north().east().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(north.north().east().north().east().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(north.north().east().north().east().above().above())){
            level.setBlock(north.north().east().north().east().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, north.north().east().north().east().above().above());
        }

        if(level.getBlockState(south.south().west()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().west())){
            level.setBlock(south.south().west(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().west().south().west().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().west().south().west().above())){
            level.setBlock(south.south().west().south().west().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().west().south().west().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().west().south().west().above().above())){
            level.setBlock(south.south().west().south().west().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, south.south().west().south().west().above().above());
        }

        if(level.getBlockState(south.south().east()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().east())){
            level.setBlock(south.south().east(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().east().south().east().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().east().south().east().above())){
            level.setBlock(south.south().east().south().east().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(south.south().east().south().east().above().above()).getMaterial().isReplaceable() &&!level.isOutsideBuildHeight(south.south().east().south().east().above().above())){
            level.setBlock(south.south().east().south().east().above().above(), RegionsUnexploredBlocks.JOSHUA_LOG.get().defaultBlockState(), 2);
            placeLeaves(level, south.south().east().south().east().above().above());
        }


        return true;
    }
}