package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class GoldenLarchTreeGrower extends AbstractMegaTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if(random.nextInt(7)==0){return RuTreeFeatures.BIG_GOLDEN_LARCH_TREE;}
      else{return RuTreeFeatures.GOLDEN_LARCH_TREE;}
   }

   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_GOLDEN_LARCH_TREE;
   }
}

