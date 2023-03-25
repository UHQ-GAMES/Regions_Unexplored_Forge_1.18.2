package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class PinkCherryTreeGrower extends AbstractTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
      if (random.nextInt(10) == 0) {
         return RuTreeFeatures.PINK_BIG_CHERRY_TREE;
      } else {
         return RuTreeFeatures.PINK_CHERRY_TREE;
      }
   }
}
