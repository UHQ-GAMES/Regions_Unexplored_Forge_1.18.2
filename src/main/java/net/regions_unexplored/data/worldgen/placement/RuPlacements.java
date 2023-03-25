package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.data.worldgen.features.RuFeatureRegistry;
import net.regions_unexplored.data.worldgen.features.RuFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.regions_unexplored.data.worldgen.structures.MeadowRock;

import java.util.List;


public class RuPlacements {
    public static final Holder<PlacedFeature> RU_CLAY = PlacementUtils.register("regions_unexplored:ru_clay", RuFeatures.RU_DISK_CLAY, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> RU_MUD = PlacementUtils.register("regions_unexplored:ru_mud", RuFeatures.RU_DISK_MUD, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> RU_GRAVEL = PlacementUtils.register("regions_unexplored:ru_gravel", RuFeatures.RU_DISK_GRAVEL, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> RU_SAND = PlacementUtils.register("regions_unexplored:ru_sand", RuFeatures.RU_DISK_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature> RU_MUD_BIG = PlacementUtils.register("regions_unexplored:ru_mud_big", RuFeatures.RU_DISK_MUD_BIG, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  MARSHES = PlacementUtils.register("regions_unexplored:marshes", RuFeatures.MARSH, CountPlacement.of(125), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  NOISE_PUMPKINS = PlacementUtils.register("regions_unexplored:noise_pumpkins", RuFeatures.PUMPKINS, List.of(CountPlacement.of(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  NOISE_MUD = PlacementUtils.register("regions_unexplored:noise_mud", RuFeatures.MARSH_MUD, List.of(CountPlacement.of(35), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(1), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, RuVegetationFeatures.MARSH, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  NOISE_ROCKS = PlacementUtils.register("regions_unexplored:noise_rocks", RuFeatures.STONES, List.of(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  NOISE_ROCKS_NETHER = PlacementUtils.register("regions_unexplored:noise_rocks_nether", RuFeatures.NETHER_STONES, List.of(CountOnEveryLayerPlacement.of(20), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  NOISE_BUSH = PlacementUtils.register("regions_unexplored:noise_bush", RuFeatures.BUSH, List.of(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  NOISE_AUTUMN_BUSH = PlacementUtils.register("regions_unexplored:noise_autumn_bush", RuFeatures.AUTUMN_BUSH, List.of(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  MUDDY_MARSHES = PlacementUtils.register("regions_unexplored:muddy_marshes", RuFeatures.MARSH_MUDDY, PlacementUtils.countExtra(0, 0.1F, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  LAKE_WATER = PlacementUtils.register("regions_unexplored:lake_water", RuFeatures.LAKE_WATER, RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  QUICKSAND = PlacementUtils.register("regions_unexplored:quicksand", RuFeatures.QUICKSAND, commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(130))));
    public static final Holder<PlacedFeature>  HANGING_PRISMARITE_CLUSTER = PlacementUtils.register("regions_unexplored:hanging_prismarite_cluster", RuFeatures.HANGING_PRISMARITE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  LAVA_FALL = PlacementUtils.register("regions_unexplored:lava_fall", RuFeatures.LAVA_FALL, List.of(CountOnEveryLayerPlacement.of(6), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  OVERWORLD_LAVA_DELTA = PlacementUtils.register("regions_unexplored:overworld_lava_delta", RuFeatures.OVERWORLD_LAVA_DELTA, CountPlacement.of(115), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  ASH_VENT = PlacementUtils.register("regions_unexplored:ash_vent", RuFeatures.ASH_VENT, List.of(CountOnEveryLayerPlacement.of(7), BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  ASH_VENT_SURFACE = PlacementUtils.register("regions_unexplored:ash_vent_surface", RuFeatures.ASH_VENT, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    public static final Holder<PlacedFeature>  BASALT_BLOB = PlacementUtils.register("regions_unexplored:basalt_blob", RuFeatures.BASALT_BLOB, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    //REDSTONE
    public static final Holder<PlacedFeature>  POINTED_REDSTONE = PlacementUtils.register("regions_unexplored:pointed_redstone", RuFeatures.POINTED_REDSTONE, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  LARGE_POINTED_REDSTONE = PlacementUtils.register("regions_unexplored:large_pointed_redstone", RuFeatures.LARGE_POINTED_REDSTONE, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  POINTED_REDSTONE_CLUSTER = PlacementUtils.register("regions_unexplored:pointed_redstone_cluster", RuFeatures.POINTED_REDSTONE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  POINTED_REDSTONE_NETHER = PlacementUtils.register("regions_unexplored:pointed_redstone_nether", RuFeatures.POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  LARGE_POINTED_REDSTONE_NETHER = PlacementUtils.register("regions_unexplored:large_pointed_redstone_nether", RuFeatures.LARGE_POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  POINTED_REDSTONE_CLUSTER_NETHER = PlacementUtils.register("regions_unexplored:pointed_redstone_cluster_nether", RuFeatures.POINTED_REDSTONE_CLUSTER_NETHER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature>  ORE_REDSTONE_LARGE = PlacementUtils.register("regions_unexplored:ore_redstone_large", RuFeatures.ORE_REDSTONE_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(112))));
    //OTHER
    public static final Holder<PlacedFeature>  MAGMA_PATCH = PlacementUtils.register("regions_unexplored:magma_patch", RuFeatures.MAGMA_DELTA, CountOnEveryLayerPlacement.of(40), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  MINERAL_VEGETATION = PlacementUtils.register("regions_unexplored:mineral_vegetation", RuFeatures.MINERAL_VEGETATION, CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  MINERAL_VEGETATION_DEEPSLATE = PlacementUtils.register("regions_unexplored:mineral_vegetation_deepslate", RuFeatures.MINERAL_VEGETATION_DEEPSLATE, CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  MINERAL_POOL = PlacementUtils.register("regions_unexplored:mineral_pool", RuFeatures.MINERAL_POOL, CountPlacement.of(70), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  TOP_DRIPSTONE = PlacementUtils.register("regions_unexplored:top_dripstone", RuFeatures.TOP_DRIPSTONE, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  MINERAL_VINES = PlacementUtils.register("regions_unexplored:mineral_vines", CaveFeatures.CAVE_VINE, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
    public static final Holder<PlacedFeature>  ROCK_PILLAR = PlacementUtils.register("regions_unexplored:rock_pillar", RuFeatures.ROCK_PILLAR, CountOnEveryLayerPlacement.of(1),  BiomeFilter.biome());

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
}
