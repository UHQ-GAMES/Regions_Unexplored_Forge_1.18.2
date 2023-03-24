package net.regions_unexplored.data.worldgen.features.treefeature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

import java.util.Random;

public class NetherWillowFeature extends Feature<NoneFeatureConfiguration> {

    public NetherWillowFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int height = context.random().nextInt(3)+8;

        if(level.getBlockState(pos.below()).getBlock()!= Blocks.GRASS_BLOCK){
            return false;
        }

        if (level.isEmptyBlock(pos) && !level.isEmptyBlock(pos.below())) {
            BlockPos.MutableBlockPos placePos = pos.mutable();

            for(int i = 0; i<=height; i++){
                if (level.isOutsideBuildHeight(placePos)) {
                    return true;
                }
                if(i==0){
                    level.setBlock(placePos.below(), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(i==1){
                    placeRoots(level, placePos);
                }
                if(i==height-3){
                    placeBranches(level, placePos);
                }
                if(isReplaceable(level, placePos)){
                    level.setBlock(placePos, Blocks.OAK_LOG.defaultBlockState(), 2);
                }
                if(i==height){
                    placeLeavesNoVine(level, placePos);
                }
                placePos.move(Direction.UP);
            }

            return true;
        } else {
            return false;
        }
    }

    private void placeBranches(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
            if(isReplaceable(level, pos.north())){
                level.setBlock(pos.north(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north())){
                level.setBlock(pos.north().above().north(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north().north())){
                level.setBlock(pos.north().above().north().north(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north().north().north())){
                level.setBlock(pos.north().above().north().north().north(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
                placeLeaves(level, pos.north().above().north().north().north());
            }
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
            if(isReplaceable(level, pos.south())){
                level.setBlock(pos.south(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south())){
                level.setBlock(pos.south().above().south(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south().south())){
                level.setBlock(pos.south().above().south().south(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south().south().south())){
                level.setBlock(pos.south().above().south().south().south(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
                placeLeaves(level, pos.south().above().south().south().south());
            }
        }
        //EAST
        if(isReplaceable(level, pos.east())){
            if(isReplaceable(level, pos.east())){
                level.setBlock(pos.east(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east())){
                level.setBlock(pos.east().above().east(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east().east())){
                level.setBlock(pos.east().above().east().east(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east().east().east())){
                level.setBlock(pos.east().above().east().east().east(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
                placeLeaves(level, pos.east().above().east().east().east());
            }
        }
        //WEST
        if(isReplaceable(level, pos.west())){
            if(isReplaceable(level, pos.west())){
                level.setBlock(pos.west(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west())){
                level.setBlock(pos.west().above().west(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west().west())){
                level.setBlock(pos.west().above().west().west(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west().west().west())){
                level.setBlock(pos.west().above().west().west().west(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
                placeLeaves(level, pos.west().above().west().west().west());
            }
        }
    }

    private void placeRoots(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
            if(isReplaceable(level, pos.north())){
                level.setBlock(pos.north(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().below().north())){
                level.setBlock(pos.north().below().north(), Blocks.OAK_LOG.defaultBlockState(), 2);
                if(isReplaceable(level, pos.north().below().north().below())){
                    level.setBlock(pos.north().below().north().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                    if(isReplaceable(level, pos.north().below().north().below().below())){
                        level.setBlock(pos.north().below().north().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        if(isReplaceable(level, pos.north().below().north().below().below().below())){
                            level.setBlock(pos.north().below().north().below().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
            if(isReplaceable(level, pos.south())){
                level.setBlock(pos.south(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().below().south())){
                level.setBlock(pos.south().below().south(), Blocks.OAK_LOG.defaultBlockState(), 2);
                if(isReplaceable(level, pos.south().below().south().below())){
                    level.setBlock(pos.south().below().south().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                    if(isReplaceable(level, pos.south().below().south().below().below())){
                        level.setBlock(pos.south().below().south().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        if(isReplaceable(level, pos.south().below().south().below().below().below())){
                            level.setBlock(pos.south().below().south().below().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        //EAST
        if(isReplaceable(level, pos.east())){
            if(isReplaceable(level, pos.east())){
                level.setBlock(pos.east(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().below().east())){
                level.setBlock(pos.east().below().east(), Blocks.OAK_LOG.defaultBlockState(), 2);
                if(isReplaceable(level, pos.east().below().east().below())){
                    level.setBlock(pos.east().below().east().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                    if(isReplaceable(level, pos.east().below().east().below().below())){
                        level.setBlock(pos.east().below().east().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        if(isReplaceable(level, pos.east().below().east().below().below().below())){
                            level.setBlock(pos.east().below().east().below().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        //WEST
        if(isReplaceable(level, pos.west())){
            if(isReplaceable(level, pos.west())){
                level.setBlock(pos.west(), Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().below().west())){
                level.setBlock(pos.west().below().west(), Blocks.OAK_LOG.defaultBlockState(), 2);
                if(isReplaceable(level, pos.west().below().west().below())){
                    level.setBlock(pos.west().below().west().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                    if(isReplaceable(level, pos.west().below().west().below().below())){
                        level.setBlock(pos.west().below().west().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        if(isReplaceable(level, pos.west().below().west().below().below().below())){
                            level.setBlock(pos.west().below().west().below().below().below(), Blocks.OAK_LOG.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
    }

    private void placeLeaves(LevelAccessor level, BlockPos pos) {
        if (isReplaceable(level, pos)) {
            level.setBlock(pos, Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //TOP
        if (isReplaceable(level, pos.above())) {
            level.setBlock(pos.above(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().north())) {
            level.setBlock(pos.above().north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().north().east())) {
            level.setBlock(pos.above().north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().north().west())) {
            level.setBlock(pos.above().north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().south())) {
            level.setBlock(pos.above().south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().south().east())) {
            level.setBlock(pos.above().south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().south().west())) {
            level.setBlock(pos.above().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().east())) {
            level.setBlock(pos.above().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.above().west())) {
            level.setBlock(pos.above().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //NORTH
        if (isReplaceable(level, pos.north())) {
            level.setBlock(pos.north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.north().north())) {
            level.setBlock(pos.north().north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.north().north());
        }
        //NORTH-WEST
        if (isReplaceable(level, pos.north().west())) {
            level.setBlock(pos.north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.north().north().west())) {
            level.setBlock(pos.north().north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.north().north().west());
        }
        if (isReplaceable(level, pos.north().west().west())) {
            level.setBlock(pos.north().west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.north().west().west());
        }
        //WEST
        if (isReplaceable(level, pos.west())) {
            level.setBlock(pos.west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.west().west())) {
            level.setBlock(pos.west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.west().west());
        }
        //SOUTH-WEST
        if (isReplaceable(level, pos.south().west())) {
            level.setBlock(pos.south().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.south().south().west())) {
            level.setBlock(pos.south().south().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.south().south().west());
        }
        if (isReplaceable(level, pos.south().west().west())) {
            level.setBlock(pos.south().west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.south().west().west());
        }
        //SOUTH
        if (isReplaceable(level, pos.south())) {
            level.setBlock(pos.south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.south().south())) {
            level.setBlock(pos.south().south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.south().south());
        }
        //SOUTH-EAST
        if (isReplaceable(level, pos.south().east())) {
            level.setBlock(pos.south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.south().south().east())) {
            level.setBlock(pos.south().south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.south().south().east());
        }
        if (isReplaceable(level, pos.south().east().east())) {
            level.setBlock(pos.south().east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.south().east().east());
        }
        //EAST
        if (isReplaceable(level, pos.east())) {
            level.setBlock(pos.east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.east().east())) {
            level.setBlock(pos.east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.east().east());
        }
        //NORTH-EAST
        if (isReplaceable(level, pos.north().east())) {
            level.setBlock(pos.north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, pos.north().north().east())) {
            level.setBlock(pos.north().north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.north().north().east());
        }
        if (isReplaceable(level, pos.north().east().east())) {
            level.setBlock(pos.north().east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
            addVine(level,pos.north().east().east());
        }
    }

    private void placeLeavesNoVine(LevelAccessor level, BlockPos blockPos) {
        if (isReplaceable(level, blockPos)) {
            level.setBlock(blockPos, Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //TOP
        if (isReplaceable(level, blockPos.above())) {
            level.setBlock(blockPos.above(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().north())) {
            level.setBlock(blockPos.above().north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().north().east())) {
            level.setBlock(blockPos.above().north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().north().west())) {
            level.setBlock(blockPos.above().north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().south())) {
            level.setBlock(blockPos.above().south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().south().east())) {
            level.setBlock(blockPos.above().south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().south().west())) {
            level.setBlock(blockPos.above().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().east())) {
            level.setBlock(blockPos.above().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.above().west())) {
            level.setBlock(blockPos.above().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //NORTH
        if (isReplaceable(level, blockPos.north())) {
            level.setBlock(blockPos.north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.north().north())) {
            level.setBlock(blockPos.north().north(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //NORTH-WEST
        if (isReplaceable(level, blockPos.north().west())) {
            level.setBlock(blockPos.north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.north().north().west())) {
            level.setBlock(blockPos.north().north().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.north().west().west())) {
            level.setBlock(blockPos.north().west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //WEST
        if (isReplaceable(level, blockPos.west())) {
            level.setBlock(blockPos.west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.west().west())) {
            level.setBlock(blockPos.west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //SOUTH-WEST
        if (isReplaceable(level, blockPos.south().west())) {
            level.setBlock(blockPos.south().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.south().south().west())) {
            level.setBlock(blockPos.south().south().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.south().west().west())) {
            level.setBlock(blockPos.south().west().west(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //SOUTH
        if (isReplaceable(level, blockPos.south())) {
            level.setBlock(blockPos.south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.south().south())) {
            level.setBlock(blockPos.south().south(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //SOUTH-EAST
        if (isReplaceable(level, blockPos.south().east())) {
            level.setBlock(blockPos.south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.south().south().east())) {
            level.setBlock(blockPos.south().south().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.south().east().east())) {
            level.setBlock(blockPos.south().east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //EAST
        if (isReplaceable(level, blockPos.east())) {
            level.setBlock(blockPos.east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.east().east())) {
            level.setBlock(blockPos.east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        //NORTH-EAST
        if (isReplaceable(level, blockPos.north().east())) {
            level.setBlock(blockPos.north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.north().north().east())) {
            level.setBlock(blockPos.north().north().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if (isReplaceable(level, blockPos.north().east().east())) {
            level.setBlock(blockPos.north().east().east(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
    }

    private void addVine(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(3);
        BlockPos place = pos.below();
        for(int i = 0; i<=size; i++){
            if(isAir(level, place)){
                if(i==size){
                    level.setBlock(place, RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState(), 2);
                }
                else {
                    level.setBlock(place, RegionsUnexploredBlocks.SPANISH_MOSS_PLANT.get().defaultBlockState(), 2);
                }
                place = place.below();
            }
            else{
                if(i!=0){
                    level.setBlock(place.above(), RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState(), 2);
                }
                break;
            }
        }
    }

    public static boolean isAirBlock(BlockState state) {
        return state.is(Blocks.AIR)||state.is(Blocks.CAVE_AIR)||state.is(Blocks.VOID_AIR);
    }

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, NetherWillowFeature::isAirBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, NetherWillowFeature::isReplaceableBlock);
    }
}