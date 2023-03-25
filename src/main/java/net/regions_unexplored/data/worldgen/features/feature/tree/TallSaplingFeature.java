package net.regions_unexplored.data.worldgen.features.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.data.worldgen.features.feature.tree.config.TallSaplingConfiguration;
import net.regions_unexplored.world.level.block.grass.DoubleTallSaplingBlock;

public class TallSaplingFeature extends Feature<TallSaplingConfiguration> {

    public TallSaplingFeature(Codec<TallSaplingConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<TallSaplingConfiguration> context) {
        TallSaplingConfiguration saplingConfiguration = context.config();
        BlockPos pos = context.origin();
        Random Random = context.random();
        WorldGenLevel level = context.level();

        if(!level.isOutsideBuildHeight(pos.above())&&level.getBlockState(pos).getMaterial().isReplaceable()&&level.getBlockState(pos.above()).getMaterial().isReplaceable()) {
            level.setBlock(pos, saplingConfiguration.saplingProvider.getState(Random, pos).setValue(DoubleTallSaplingBlock.HALF, DoubleBlockHalf.LOWER), 2);
            level.setBlock(pos.above(), saplingConfiguration.saplingProvider.getState(Random, pos).setValue(DoubleTallSaplingBlock.HALF, DoubleBlockHalf.UPPER), 2);
            return true;
        }
        else{
            return false;
        }
    }
}