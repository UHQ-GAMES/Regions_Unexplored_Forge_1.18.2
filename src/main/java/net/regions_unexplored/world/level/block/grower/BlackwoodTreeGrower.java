package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class BlackwoodTreeGrower extends AbstractMegaTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
        if(random.nextInt(7)==0){return RuTreeFeatures.BIG_BLACKWOOD_TREE;}
        else{return RuTreeFeatures.BLACKWOOD_TREE;}
    }

    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
        return RuTreeFeatures.GIANT_BLACKWOOD_TREE;
    }
}