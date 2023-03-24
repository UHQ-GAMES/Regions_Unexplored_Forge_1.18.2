package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class PineTreeGrower extends AbstractMegaTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      
      if(random.nextInt(7)==0){
      if(random.nextInt(3)==0){return RuTreeFeatures.SCOTTS_PINE_TREE_TALL;}
      else{return RuTreeFeatures.PINE_TREE_TALL;}
      }
      else{
      if(random.nextInt(3)==0){return RuTreeFeatures.SCOTTS_PINE_TREE;}
      else{return RuTreeFeatures.PINE_TREE;}
      }
   }

   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_PINE_TREE;
   }
}

