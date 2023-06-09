package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;

public class SculkwoodGrower extends AbstractTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
      if(random.nextInt(7)==0){return RuVegetationFeatures.GIANT_SCULK_WILLOW;}
      else{return RuVegetationFeatures.SCULK_WILLOW;}
   }
}

