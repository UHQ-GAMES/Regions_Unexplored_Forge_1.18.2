package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class DeadPineTreeGrower extends AbstractMegaTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
      
      if(random.nextInt(7)==0){
      if(random.nextInt(3)==0){return RuTreeFeatures.DEAD_SCOTTS_PINE_TREE_TALL;}
      else{return RuTreeFeatures.DEAD_PINE_TREE_TALL;}
      }
      else{
      if(random.nextInt(3)==0){return RuTreeFeatures.DEAD_SCOTTS_PINE_TREE;}
      else{return RuTreeFeatures.DEAD_PINE_TREE;}
      }
   }

   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
      return RuTreeFeatures.DEAD_GIANT_PINE_TREE;
   }
}