package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class SilverBirchTreeGrower extends AbstractTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
      if (random.nextInt(6) == 0) {
         return RuTreeFeatures.SILVER_BIRCH_ASPEN;
      } else {
         return RuTreeFeatures.SILVER_BIRCH;
      }
   }
}
