package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;
import net.regions_unexplored.data.worldgen.features.feature.redstonefeatures.LargePointedRedstoneConfiguration;
import net.regions_unexplored.data.worldgen.features.feature.redstonefeatures.PointedRedstoneClusterConfiguration;
import net.regions_unexplored.data.worldgen.features.feature.redstonefeatures.PointedRedstoneConfiguration;
import net.regions_unexplored.world.level.block.AshBlock;

import java.util.List;


public class RuFeatures {
    public static final RuleTest sandTest = new TagMatchTest(RegionsUnexploredTags.SANDS);
    public static final RuleTest baseStoneTest = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
    public static final RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final PlacementModifier STONE_RANGE = HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256));
    public static final PlacementModifier DEEPSLATE_RANGE = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0));
    public static final PlacementModifier RANGE_BOTTOM_120 = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(120));
    public static final List<OreConfiguration.TargetBlockState> ORE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(stoneOreTest, Blocks.REDSTONE_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreTest, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> STONE_GRASS_TARGET_LIST = List.of(OreConfiguration.target(stoneOreTest, RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> LAKE_WATER = FeatureUtils.register("regions_unexplored:lake_water", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(Blocks.MUD.defaultBlockState())));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MARSH_MUDDY = FeatureUtils.register("regions_unexplored:marsh_muddy", Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.MUD), PlacementUtils.inlinePlaced(CaveFeatures.POINTED_DRIPSTONE), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> RU_DISK_CLAY = FeatureUtils.register("regions_unexplored:ru_disk_clay", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate.matchesBlocks(List.of(RegionsUnexploredBlocks.FOREST_MUD.get(), RegionsUnexploredBlocks.FOREST_DIRT.get(), RegionsUnexploredBlocks.PLAINS_DIRT.get(), Blocks.DIRT, Blocks.CLAY)), UniformInt.of(2, 3), 1));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> RU_DISK_MUD = FeatureUtils.register("regions_unexplored:ru_disk_mud", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MUD), BlockPredicate.matchesBlocks(List.of(RegionsUnexploredBlocks.FOREST_MUD.get(), Blocks.MUD, RegionsUnexploredBlocks.FOREST_DIRT.get(), RegionsUnexploredBlocks.PLAINS_DIRT.get(), Blocks.DIRT, Blocks.CLAY)), UniformInt.of(2, 3), 1));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> RU_DISK_GRAVEL = FeatureUtils.register("regions_unexplored:ru_disk_gravel", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(RegionsUnexploredBlocks.FOREST_MUD.get(), RegionsUnexploredBlocks.FOREST_DIRT.get(), RegionsUnexploredBlocks.PLAINS_DIRT.get(), RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(), RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(), Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(2, 5), 2));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> RU_DISK_SAND = FeatureUtils.register("regions_unexplored:ru_disk_sand", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.SAND), BlockPredicate.matchesBlocks(List.of(RegionsUnexploredBlocks.FOREST_MUD.get(), RegionsUnexploredBlocks.FOREST_DIRT.get(), RegionsUnexploredBlocks.PLAINS_DIRT.get(), RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(), RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(), Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(2, 6), 2));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> RU_DISK_MUD_BIG = FeatureUtils.register("regions_unexplored:ru_disk_mud_big", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MUD), BlockPredicate.matchesBlocks(List.of(RegionsUnexploredBlocks.FOREST_MUD.get(), Blocks.MUD, RegionsUnexploredBlocks.FOREST_DIRT.get(), RegionsUnexploredBlocks.PLAINS_DIRT.get(), RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(), RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(), Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND)), UniformInt.of(2, 6), 2));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> SPIRES = FeatureUtils.register("regions_unexplored:spires", RuFeatureRegistry.SPIRE_FEATURE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> NETHER_ROCK = FeatureUtils.register("regions_unexplored:nether_rock", RuFeatureRegistry.NETHER_MEADOW_ROCK.get(), new BlockStateConfiguration(RegionsUnexploredBlocks.MARROWSTONE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> MEADOW_ROCKS = FeatureUtils.register("regions_unexplored:meadow_rocks", RuFeatureRegistry.MEADOW_ROCKS_FEATURE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MARSH = FeatureUtils.register("regions_unexplored:marsh", Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.MOSS_BLOCK), PlacementUtils.inlinePlaced(CaveFeatures.DRIPLEAF), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ASH_VENT_PATCH = FeatureUtils.register("regions_unexplored:ash_vent_patch", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RegionsUnexploredBlocks.ASH_VENT.get().defaultBlockState(), 3).add(Blocks.AIR.defaultBlockState(), 50))), List.of(Blocks.BASALT), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MARSH_MUD = FeatureUtils.register("regions_unexplored:marsh_mud", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState(), 1).add(Blocks.AIR.defaultBlockState(), 73))), List.of(Blocks.DIRT, RegionsUnexploredBlocks.FOREST_MUD.get()), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PUMPKINS = FeatureUtils.register("regions_unexplored:pumpkins", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 4).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.NORTH), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.SOUTH), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.EAST), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.WEST), 1).add(RegionsUnexploredBlocks.RED_MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 1).add(RegionsUnexploredBlocks.ORANGE_MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 1).add(Blocks.AIR.defaultBlockState(), 73))), List.of(Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> STONES = FeatureUtils.register("regions_unexplored:stones", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get().defaultBlockState(), 1).add(RegionsUnexploredBlocks.MOSSY_STONE.get().defaultBlockState(), 1).add(Blocks.STONE.defaultBlockState(), 1).add(Blocks.COBBLESTONE.defaultBlockState(), 1).add(Blocks.AIR.defaultBlockState(), 75))), List.of(Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NETHER_STONES = FeatureUtils.register("regions_unexplored:nether_stones", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.NETHERRACK.defaultBlockState(), 1).add(Blocks.BLACKSTONE.defaultBlockState(), 1).add(Blocks.SMOOTH_BASALT.defaultBlockState(), 1).add(Blocks.AIR.defaultBlockState(), 100))), List.of(Blocks.NETHERRACK, RegionsUnexploredBlocks.GLISTERING_NYLIUM.get()), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BUSH = FeatureUtils.register("regions_unexplored:bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RegionsUnexploredBlocks.MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2).add(Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2).add(Blocks.AIR.defaultBlockState(), 75))), List.of(Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AUTUMN_BUSH = FeatureUtils.register("regions_unexplored:autumn_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RegionsUnexploredBlocks.RED_MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 1).add(RegionsUnexploredBlocks.ORANGE_MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 1).add(Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2).add(Blocks.AIR.defaultBlockState(), 75))), List.of(Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK), 125));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> QUICKSAND = FeatureUtils.register("regions_unexplored:quicksand", Feature.ORE, new OreConfiguration(sandTest, RegionsUnexploredBlocks.QUICKSAND.get().defaultBlockState(), 32));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> HANGING_PRISMARITE_CLUSTER = FeatureUtils.register("regions_unexplored:hanging_prismarite_cluster", RuFeatureRegistry.HANGING_PRISMARITE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LAVA_FALL = FeatureUtils.register("regions_unexplored:lava_fall", RuFeatureRegistry.LAVA_FALL.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> OVERWORLD_LAVA_DELTA = FeatureUtils.register("regions_unexplored:overworld_lava_delta", RuFeatureRegistry.OVERWORLD_LAVA_DELTA.get(), new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(RegionsUnexploredBlocks.VOLCANIC_ASH.get().defaultBlockState().setValue(AshBlock.HAS_GRAVITY, false)), PlacementUtils.inlinePlaced(CaveFeatures.POINTED_DRIPSTONE), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> ASH_VENT = FeatureUtils.register("regions_unexplored:ash_vent", RuFeatureRegistry.ASH_VENT.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> BASALT_BLOB = FeatureUtils.register("regions_unexplored:basalt_blob", RuFeatureRegistry.BASALT_BLOB.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> POINTED_REDSTONE = FeatureUtils.register("regions_unexplored:pointed_redstone", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(RuFeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))), PlacementUtils.inlinePlaced(RuFeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LARGE_POINTED_REDSTONE = FeatureUtils.register("regions_unexplored:large_pointed_redstone", RuFeatureRegistry.LARGE_POINTED_REDSTONE.get(), new LargePointedRedstoneConfiguration(30, UniformInt.of(1, 6), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> POINTED_REDSTONE_CLUSTER = FeatureUtils.register("regions_unexplored:pointed_redstone_cluster", RuFeatureRegistry.POINTED_REDSTONE_CLUSTER.get(), new PointedRedstoneClusterConfiguration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.1F, 0.3F, 0.1F, 0.9F), 0.1F, 3, 8));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> POINTED_REDSTONE_NETHER = FeatureUtils.register("regions_unexplored:pointed_redstone_nether", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(RuFeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))), PlacementUtils.inlinePlaced(RuFeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LARGE_POINTED_REDSTONE_NETHER = FeatureUtils.register("regions_unexplored:large_pointed_redstone_nether", RuFeatureRegistry.LARGE_POINTED_REDSTONE.get(), new LargePointedRedstoneConfiguration(30, UniformInt.of(1, 6), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> POINTED_REDSTONE_CLUSTER_NETHER = FeatureUtils.register("regions_unexplored:pointed_redstone_cluster_nether", RuFeatureRegistry.POINTED_REDSTONE_CLUSTER.get(), new PointedRedstoneClusterConfiguration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.0F, 0.0F, 0.0F, 0.0F), 0.1F, 3, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_REDSTONE_LARGE = FeatureUtils.register("regions_unexplored:ore_redstone_large", Feature.ORE, new OreConfiguration(ORE_REDSTONE_TARGET_LIST, 20));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MINERAL_VEGETATION = FeatureUtils.register("regions_unexplored:mineral_vegetation", Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.STONE_ORE_REPLACEABLES, BlockStateProvider.simple(RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get()), PlacementUtils.inlinePlaced(RuVegetationFeatures.UNDERGROUND_GRASS), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MINERAL_VEGETATION_DEEPSLATE = FeatureUtils.register("regions_unexplored:mineral_vegetation_deepslate", Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.DEEPSLATE_ORE_REPLACEABLES, BlockStateProvider.simple(RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get()), PlacementUtils.inlinePlaced(RuVegetationFeatures.UNDERGROUND_GRASS), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MINERAL_POOL = FeatureUtils.register("regions_unexplored:mineral_pool", Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.CALCITE), PlacementUtils.inlinePlaced(CaveFeatures.POINTED_DRIPSTONE), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> TOP_DRIPSTONE = FeatureUtils.register("regions_unexplored:top_dripstone", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(Feature.POINTED_DRIPSTONE, new PointedDripstoneConfiguration(0.8F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))), PlacementUtils.inlinePlaced(Feature.POINTED_DRIPSTONE, new PointedDripstoneConfiguration(0.8F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
    public static final Holder<ConfiguredFeature<DeltaFeatureConfiguration, ?>> MAGMA_DELTA = FeatureUtils.register("regions_unexplored:magma_delta", Feature.DELTA_FEATURE, new DeltaFeatureConfiguration(Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.OBSIDIAN.defaultBlockState(), UniformInt.of(7, 8), UniformInt.of(0, 2)));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> OBSIDIAN_SPIRE = FeatureUtils.register("regions_unexplored:obsidian_spire", RuFeatureRegistry.OBSIDIAN_SPIRE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> ROCK_PILLAR = FeatureUtils.register("regions_unexplored:rock_pillar", RuFeatureRegistry.ROCK_PILLAR.get(), FeatureConfiguration.NONE);

    public static boolean isNetherStone(BlockState p_159748_) {
        return p_159748_.is(BlockTags.BASE_STONE_NETHER);
    }

    public static boolean isNylium(BlockState p_159748_) {
        return p_159748_.is(BlockTags.NYLIUM);
    }
}