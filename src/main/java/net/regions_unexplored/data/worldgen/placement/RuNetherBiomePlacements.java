package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.worldgen.features.RuFeatures;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;

import java.util.List;

public class RuNetherBiomePlacements {

        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_GRASS = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_grass", RuVegetationFeatures.PATCH_MYCOTOXIC_GRASS, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_DAISY = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_daisy", RuVegetationFeatures.PATCH_MYCOTOXIC_DAISY, List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_BIOSHROOM = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_bioshroom", RuVegetationFeatures.PATCH_YELLOW_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(6), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_TALL_BIOSHROOM = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_tall_bioshroom", RuVegetationFeatures.PATCH_TALL_YELLOW_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_SMALL_MUSHROOM = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_small_mushroom", RuTreeFeatures.SMALL_YELLOW_MUSHROOM, CountOnEveryLayerPlacement.of(2), PlacementUtils.filteredByBlockSurvival(Blocks.CRIMSON_ROOTS), BiomeFilter.biome());
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_MEDIUM_MUSHROOM = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_medium_mushroom", RuTreeFeatures.MEDIUM_YELLOW_MUSHROOM, CountOnEveryLayerPlacement.of(2), PlacementUtils.filteredByBlockSurvival(Blocks.CRIMSON_ROOTS), BiomeFilter.biome());
        public static final Holder<PlacedFeature> MYCOTOXIC_UNDERGROWTH_BIG_MUSHROOM = PlacementUtils.register("regions_unexplored:mycotoxic_undergrowth_big_mushroom", RuTreeFeatures.BIG_YELLOW_MUSHROOM, CountOnEveryLayerPlacement.of(3), PlacementUtils.filteredByBlockSurvival(Blocks.CRIMSON_ROOTS), BiomeFilter.biome());

        public static final Holder<PlacedFeature> GLISTERING_MEADOW_ROCK = PlacementUtils.register("regions_unexplored:glistering_meadow_rock", RuFeatures.NETHER_ROCK, CountOnEveryLayerPlacement.of(1), InSquarePlacement.spread(), BiomeFilter.biome());
        public static final Holder<PlacedFeature> GLISTERING_MEADOW_IVY = PlacementUtils.register("regions_unexplored:glistering_meadow_ivy", RuVegetationFeatures.PATCH_GLISTERING_IVY, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        public static final Holder<PlacedFeature> GLISTERING_MEADOW_GRASS = PlacementUtils.register("regions_unexplored:glistering_meadow_grass", RuVegetationFeatures.PATCH_GLISTERING_SPROUT, List.of(CountOnEveryLayerPlacement.of(40), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> GLISTERING_MEADOW_SPIRE = PlacementUtils.register("regions_unexplored:glistering_meadow_spire", RuVegetationFeatures.PATCH_GLISTER_SPIRE, List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> GLISTERING_MEADOW_BULB = PlacementUtils.register("regions_unexplored:glistering_meadow_bulb", RuVegetationFeatures.PATCH_GLISTER_BULB, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));

        public static final Holder<PlacedFeature> HANGING_EARLIGHT = PlacementUtils.register("regions_unexplored:hanging_earlight", RuVegetationFeatures.PATCH_HANGING_EARLIGHT, CountPlacement.of(225), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        public static final Holder<PlacedFeature> COBALT_ROOTS = PlacementUtils.register("regions_unexplored:cobalt_roots", RuVegetationFeatures.PATCH_COBALT_ROOTS, List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> BLACKSTONE_CLUSTER = PlacementUtils.register("regions_unexplored:blackstone_cluster", RuVegetationFeatures.PATCH_BLACKSTONE_CLUSTER, List.of(CountOnEveryLayerPlacement.of(4), PlacementUtils.filteredByBlockSurvival(RegionsUnexploredBlocks.STONE_BUD.get()), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> COBALT_EARLIGHT = PlacementUtils.register("regions_unexplored:cobalt_earlight", RuVegetationFeatures.PATCH_COBALT_EARLIGHT, List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> OBSIDIAN_SPIRE = PlacementUtils.register("regions_unexplored:obsidian_spire", RuFeatures.OBSIDIAN_SPIRE, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

        public static final Holder<PlacedFeature> NETHER_WILLOW = PlacementUtils.register("regions_unexplored:nether_willow", RuVegetationFeatures.NETHER_WILLOW, CountOnEveryLayerPlacement.of(155), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

        public static final Holder<PlacedFeature> SCULK_SPROUT = PlacementUtils.register("regions_unexplored:sculk_sprout", RuVegetationFeatures.PATCH_SCULK_SPROUT, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
        public static final Holder<PlacedFeature> SCULK_TENDRIL = PlacementUtils.register("regions_unexplored:sculk_tendril", RuVegetationFeatures.PATCH_SCULK_TENDRIL, List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
}
