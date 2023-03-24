package net.regions_unexplored.util.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.config.RegionsUnexploredCommonConfigs;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

public class CheckBiomeConfig {

    public static boolean isBiomeEnabled(ResourceKey<Biome> biome){
        if(biome== RuBiomes.ALPHA_GROVE){
            return RegionsUnexploredCommonConfigs.TOGGLE_ALPHA_GROVE.get();
        }
        if(biome== RuBiomes.ARID_MOUNTAINS){
            return RegionsUnexploredCommonConfigs.TOGGLE_ARID_MOUNTAINS.get();
        }
        if(biome== RuBiomes.AUTUMNAL_MAPLE_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_AUTUMNAL_MAPLE_FOREST.get();
        }
        if(biome== RuBiomes.BAMBOO_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_BAMBOO_FOREST.get();
        }
        if(biome== RuBiomes.BAOBAB_SAVANNA){
            return RegionsUnexploredCommonConfigs.TOGGLE_BAOBAB_SAVANNA.get();
        }
        if(biome== RuBiomes.BARLEY_FIELDS){
            return RegionsUnexploredCommonConfigs.TOGGLE_BARLEY_FIELDS.get();
        }
        if(biome== RuBiomes.BAYOU){
            return RegionsUnexploredCommonConfigs.TOGGLE_BAYOU.get();
        }
        if(biome== RuBiomes.BIOSHROOM_CAVES){
            return RegionsUnexploredCommonConfigs.TOGGLE_BIOSHROOM_CAVES.get();
        }
        if(biome== RuBiomes.BLACKSTONE_BASIN){
            return RegionsUnexploredCommonConfigs.TOGGLE_BLACKSTONE_BASIN.get();
        }
        if(biome== RuBiomes.BLACKWOOD_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_BLACKWOOD_FOREST.get();
        }
        if(biome== RuBiomes.BOREAL_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_BOREAL_FOREST.get();
        }
        if(biome== RuBiomes.CHALK_CLIFFS){
            return RegionsUnexploredCommonConfigs.TOGGLE_CHALK_CLIFFS.get();
        }
        if(biome== RuBiomes.CHERRY_HILLS){
            return RegionsUnexploredCommonConfigs.TOGGLE_CHERRY_HILLS.get();
        }
        if(biome== RuBiomes.COLD_BOREAL_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_COLD_BOREAL_FOREST.get();
        }
        if(biome== RuBiomes.COLD_DECIDUOUS_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_COLD_DECIDUOUS_FOREST.get();
        }
        if(biome== RuBiomes.COLD_RIVER){
            return RegionsUnexploredCommonConfigs.TOGGLE_COLD_RIVER.get();
        }
        if(biome== RuBiomes.CORRUPTED_HOLT){
            return RegionsUnexploredCommonConfigs.TOGGLE_CORRUPTED_HOLT.get();
        }
        if(biome== RuBiomes.DECIDUOUS_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_DECIDUOUS_FOREST.get();
        }
        if(biome== RuBiomes.DRY_BUSHLAND){
            return RegionsUnexploredCommonConfigs.TOGGLE_DRY_BUSHLAND.get();
        }
        if(biome== RuBiomes.EUCALYPTUS_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_EUCALYPTUS_FOREST.get();
        }
        if(biome== RuBiomes.FEN){
            return RegionsUnexploredCommonConfigs.TOGGLE_FEN.get();
        }
        if(biome== RuBiomes.FLOODED_PLAINS){
            return RegionsUnexploredCommonConfigs.TOGGLE_FLOODED_PLAINS.get();
        }
        if(biome== RuBiomes.FLOWER_FIELD){
            return RegionsUnexploredCommonConfigs.TOGGLE_FLOWER_FIELD.get();
        }
        if(biome== RuBiomes.FROZEN_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_FROZEN_FOREST.get();
        }
        if(biome== RuBiomes.FROZEN_TUNDRA){
            return RegionsUnexploredCommonConfigs.TOGGLE_FROZEN_TUNDRA.get();
        }
        if(biome== RuBiomes.FUNGAL_FEN){
            return RegionsUnexploredCommonConfigs.TOGGLE_FUNGAL_FEN.get();
        }
        if(biome== RuBiomes.GIANT_BAYOU){
            return RegionsUnexploredCommonConfigs.TOGGLE_GIANT_BAYOU.get();
        }
        if(biome== RuBiomes.GLISTERING_MEADOW){
            return RegionsUnexploredCommonConfigs.TOGGLE_GLISTERING_MEADOW.get();
        }
        if(biome== RuBiomes.GOLDEN_BOREAL_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_GOLDEN_BOREAL_FOREST.get();
        }
        if(biome== RuBiomes.GRASSLAND){
            return RegionsUnexploredCommonConfigs.TOGGLE_GRASSLAND.get();
        }
        if(biome== RuBiomes.GRASSY_BEACH){
            return RegionsUnexploredCommonConfigs.TOGGLE_GRASSY_BEACH.get();
        }
        if(biome== RuBiomes.GRAVEL_BEACH){
            return RegionsUnexploredCommonConfigs.TOGGLE_GRAVEL_BEACH.get();
        }
        if(biome== RuBiomes.HIGHLAND_FIELDS){
            return RegionsUnexploredCommonConfigs.TOGGLE_HIGHLAND_FIELDS.get();
        }
        if(biome== RuBiomes.ICY_DESERT){
            return RegionsUnexploredCommonConfigs.TOGGLE_ICY_DESERT.get();
        }
        if(biome== RuBiomes.ICY_HEIGHTS){
            return RegionsUnexploredCommonConfigs.TOGGLE_ICY_HEIGHTS.get();
        }
        if(biome== RuBiomes.JOSHUA_DESERT){
            return RegionsUnexploredCommonConfigs.TOGGLE_JOSHUA_DESERT.get();
        }
        if(biome== RuBiomes.LUPINE_PLAINS){
            return RegionsUnexploredCommonConfigs.TOGGLE_LUPINE_PLAINS.get();
        }
        if(biome== RuBiomes.LUSH_DELTA){
            return RegionsUnexploredCommonConfigs.TOGGLE_LUSH_DELTA.get();
        }
        if(biome== RuBiomes.LUSH_HILLS){
            return RegionsUnexploredCommonConfigs.TOGGLE_LUSH_HILLS.get();
        }
        if(biome== RuBiomes.MAPLE_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_MAPLE_FOREST.get();
        }
        if(biome== RuBiomes.MAUVE_HILLS){
            return RegionsUnexploredCommonConfigs.TOGGLE_MAUVE_HILLS.get();
        }
        if(biome== RuBiomes.MEADOW){
            return RegionsUnexploredCommonConfigs.TOGGLE_MEADOW.get();
        }
        if(biome== RuBiomes.MOUNTAINS){
            return RegionsUnexploredCommonConfigs.TOGGLE_MOUNTAINS.get();
        }
        if(biome== RuBiomes.MUDDY_RIVER){
            return RegionsUnexploredCommonConfigs.TOGGLE_MUDDY_RIVER.get();
        }
        if(biome== RuBiomes.MYCOTOXIC_UNDERGROWTH){
            return RegionsUnexploredCommonConfigs.TOGGLE_MYCOTOXIC_UNDERGROWTH.get();
        }
        if(biome== RuBiomes.OLD_GROWTH_RAINFOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_OLD_GROWTH_RAINFOREST.get();
        }
        if(biome== RuBiomes.ORCHARD){
            return RegionsUnexploredCommonConfigs.TOGGLE_ORCHARD.get();
        }
        if(biome== RuBiomes.OUTBACK){
            return RegionsUnexploredCommonConfigs.TOGGLE_OUTBACK.get();
        }
        if(biome== RuBiomes.PINE_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_PINE_FOREST.get();
        }
        if(biome== RuBiomes.PINE_SLOPES){
            return RegionsUnexploredCommonConfigs.TOGGLE_PINE_SLOPES.get();
        }
        if(biome== RuBiomes.POPPY_FIELDS){
            return RegionsUnexploredCommonConfigs.TOGGLE_POPPY_FIELDS.get();
        }
        if(biome== RuBiomes.PRAIRIE){
            return RegionsUnexploredCommonConfigs.TOGGLE_PRAIRIE.get();
        }
        if(biome== RuBiomes.PRISMACHASM){
            return RegionsUnexploredCommonConfigs.TOGGLE_PRISMACHASM.get();
        }
        if(biome== RuBiomes.PUMPKIN_FIELDS){
            return RegionsUnexploredCommonConfigs.TOGGLE_PUMPKIN_FIELDS.get();
        }
        if(biome== RuBiomes.RAINFOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_RAINFOREST.get();
        }
        if(biome== RuBiomes.REDSTONE_CAVES){
            return RegionsUnexploredCommonConfigs.TOGGLE_REDSTONE_CAVES.get();
        }
        if(biome== RuBiomes.REDSTONE_HELL){
            return RegionsUnexploredCommonConfigs.TOGGLE_REDSTONE_HELL.get();
        }
        if(biome== RuBiomes.REDWOODS){
            return RegionsUnexploredCommonConfigs.TOGGLE_REDWOODS.get();
        }
        if(biome== RuBiomes.SAGUARO_DESERT){
            return RegionsUnexploredCommonConfigs.TOGGLE_SAGUARO_DESERT.get();
        }
        if(biome== RuBiomes.SCORCHING_CAVES){
            return RegionsUnexploredCommonConfigs.TOGGLE_SCORCHING_CAVES.get();
        }
        if(biome== RuBiomes.SHRUBLAND){
            return RegionsUnexploredCommonConfigs.TOGGLE_SHRUBLAND.get();
        }
        if(biome== RuBiomes.SILVER_BIRCH_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_SILVER_BIRCH_FOREST.get();
        }
        if(biome== RuBiomes.SMOULDERING_WOODLAND){
            return RegionsUnexploredCommonConfigs.TOGGLE_SMOULDERING_WOODLAND.get();
        }
        if(biome== RuBiomes.SPARSE_REDWOODS){
            return RegionsUnexploredCommonConfigs.TOGGLE_SPARSE_REDWOODS.get();
        }
        if(biome== RuBiomes.SPIRES){
            return RegionsUnexploredCommonConfigs.TOGGLE_SPIRES.get();
        }
        if(biome== RuBiomes.STEPPE){
            return RegionsUnexploredCommonConfigs.TOGGLE_STEPPE.get();
        }
        if(biome== RuBiomes.TEMPERATE_GROVE){
            return RegionsUnexploredCommonConfigs.TOGGLE_TEMPERATE_GROVE.get();
        }
        if(biome== RuBiomes.TOWERING_CLIFFS){
            return RegionsUnexploredCommonConfigs.TOGGLE_TOWERING_CLIFFS.get();
        }
        if(biome== RuBiomes.TROPICS){
            return RegionsUnexploredCommonConfigs.TOGGLE_TROPICS.get();
        }
        if(biome== RuBiomes.WILLOW_FOREST){
            return RegionsUnexploredCommonConfigs.TOGGLE_WILLOW_FOREST.get();
        }
        return true;
    }
}
