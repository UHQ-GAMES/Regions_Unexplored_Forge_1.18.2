package net.regions_unexplored.data.worldgen.features.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class ObsidianSpireFeature extends Feature<NoneFeatureConfiguration> {

    public ObsidianSpireFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        if(level.getBlockState(pos.below()).getBlock()!= RegionsUnexploredBlocks.COBALT_NYLIUM.get()){
            return false;
        }
        if (level.isEmptyBlock(pos) && !level.isEmptyBlock(pos.below())) {
            BlockPos.MutableBlockPos placePos = pos.mutable();

            while(level.isEmptyBlock(placePos)) {
                if (level.isOutsideBuildHeight(placePos)) {
                    return true;
                }
                int north = context.random().nextInt(4);
                int south = context.random().nextInt(4);
                int east = context.random().nextInt(4);
                int west = context.random().nextInt(4);
                level.setBlock(placePos, Blocks.OBSIDIAN.defaultBlockState(), 2);
                if(north==0){
                    level.setBlock(placePos.north(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int north2 = context.random().nextInt(3);
                    if(north2==0){
                        level.setBlock(placePos.north().north(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    }
                }
                if(south==0){
                    level.setBlock(placePos.south(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int south2 = context.random().nextInt(3);
                    if(south2==0){
                        level.setBlock(placePos.south().south(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    }
                }
                if(east==0){
                    level.setBlock(placePos.east(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int east2 = context.random().nextInt(3);
                    if(east2==0){
                        level.setBlock(placePos.east().east(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    }
                }
                if(west==0){
                    level.setBlock(placePos.west(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int west2 = context.random().nextInt(3);
                    if(west2==0){
                        level.setBlock(placePos.west().west(), RegionsUnexploredBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    }
                }
                placePos.move(Direction.UP);
            }

            return true;
        } else {
            return false;
        }
    }
}