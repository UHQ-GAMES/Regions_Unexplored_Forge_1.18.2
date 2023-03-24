package net.regions_unexplored.data.worldgen.features.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.regions_unexplored.data.worldgen.features.RuFeatures;

public class NetherBlockBlobFeature extends Feature<BlockStateConfiguration> {
    public NetherBlockBlobFeature(Codec<BlockStateConfiguration> p_65248_) {
        super(p_65248_);
    }

    public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        BlockStateConfiguration stateConfiguration;
        for(stateConfiguration = context.config(); pos.getY() > level.getMinBuildHeight() + 3; pos = pos.below()) {
            if (!level.isEmptyBlock(pos.below())) {
                BlockState blockstate = level.getBlockState(pos.below());
                if (RuFeatures.isNetherStone(blockstate) || RuFeatures.isNylium(blockstate)) {
                    break;
                }
            }
        }

        if (pos.getY() <= level.getMinBuildHeight() + 3) {
            return false;
        } else {
            for(int l = 0; l < 3; ++l) {
                int i = random.nextInt(2);
                int j = random.nextInt(2);
                int k = random.nextInt(2);
                float f = (float)(i + j + k) * 0.333F + 0.5F;

                for(BlockPos pos1 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                    if (pos1.distSqr(pos) <= (double)(f * f)) {
                        level.setBlock(pos1, stateConfiguration.state, 4);
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }
}