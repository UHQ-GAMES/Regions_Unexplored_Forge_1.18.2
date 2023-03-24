package net.regions_unexplored.data.worldgen.features.feature.bioshroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;
import net.regions_unexplored.world.level.block.HangingPrismariteBlock;
import net.regions_unexplored.world.level.block.state.properties.HangingPrismariteShape;

import java.util.Random;

public class PinkBioshroomFeature extends Feature<NoneFeatureConfiguration> {

    public PinkBioshroomFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int height = context.random().nextInt(5) + 4;
        int check = 0;

        if (!level.getBlockState(pos.below()).is(RegionsUnexploredTags.BIOSHROOM_GROW_BLOCK)) {
            return false;
        }

        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height) {
            if (check == height) {
                if (level.isOutsideBuildHeight(checkPos.above(6))) {
                    return false;
                }
            }
            if (level.getBlockState(checkPos).getMaterial().isReplaceable()) {
                checkPos.move(Direction.UP);
                check = check + 1;
            } else {
                return false;
            }
        }

        BlockPos.MutableBlockPos placePos = pos.mutable();
        int checkHeight = 0;
        while (checkHeight <= height) {
            if (level.getBlockState(placePos).getMaterial().isReplaceable()) {
                level.setBlock(placePos, Blocks.MUSHROOM_STEM.defaultBlockState(), 2);
                if (checkHeight==height){
                    placeHead(level, placePos);
                }
                placePos.move(Direction.UP);
                checkHeight = checkHeight + 1;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean placeHead(LevelAccessor level, BlockPos pos) {

        if(level.getBlockState(pos.north()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), Blocks.SHROOMLIGHT.defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.north().east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().east())){
            level.setBlock(pos.north().east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.north().east().below()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().east().below())){
            level.setBlock(pos.north().east().below(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.north().west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().west())){
            level.setBlock(pos.north().west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.north().west().below()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().west().below())){
            level.setBlock(pos.north().west().below(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.south()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), Blocks.SHROOMLIGHT.defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.south().east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().east())){
            level.setBlock(pos.south().east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.south().east().below()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().east().below())){
            level.setBlock(pos.south().east().below(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.south().west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().west())){
            level.setBlock(pos.south().west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.south().west().below()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().west().below())){
            level.setBlock(pos.south().west().below(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), Blocks.SHROOMLIGHT.defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), Blocks.SHROOMLIGHT.defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.north().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().above())){
            level.setBlock(pos.north().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.south().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().above())){
            level.setBlock(pos.south().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.east().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().above())){
            level.setBlock(pos.east().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.west().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().above())){
            level.setBlock(pos.west().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.above())){
            level.setBlock(pos.above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        if(level.getBlockState(pos.north().above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().above().above())){
            level.setBlock(pos.north().above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.south().above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().above().above())){
            level.setBlock(pos.south().above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.east().above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().above().above())){
            level.setBlock(pos.east().above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.west().above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().above().above())){
            level.setBlock(pos.west().above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.above().above())){
            level.setBlock(pos.above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.above().above().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.above().above().above())){
            level.setBlock(pos.above().above().above(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
        }

        return true;
    }
}