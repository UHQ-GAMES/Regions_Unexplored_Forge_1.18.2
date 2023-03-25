package net.regions_unexplored.world.level.block.grower;

import net.minecraft.core.Holder;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;

public class BlueBioshroomGrower extends AbstractTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bool) {
         return RuTreeFeatures.GIANT_BLUE_BIOSHROOM;
   }
}
