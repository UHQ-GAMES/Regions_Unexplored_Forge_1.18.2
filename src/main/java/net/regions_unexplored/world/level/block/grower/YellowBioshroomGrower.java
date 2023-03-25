package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class YellowBioshroomGrower extends AbstractTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
        int chance = random.nextInt(10);
        if(chance<=4){
            return RuTreeFeatures.BIG_YELLOW_MUSHROOM;
        }
        if(chance==10){
            return RuTreeFeatures.SMALL_YELLOW_MUSHROOM;
        }
        else{
            return RuTreeFeatures.MEDIUM_YELLOW_MUSHROOM;
        }
   }
}
