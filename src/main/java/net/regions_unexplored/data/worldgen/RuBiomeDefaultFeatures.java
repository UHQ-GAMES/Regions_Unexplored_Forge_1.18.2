package net.regions_unexplored.data.worldgen;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.regions_unexplored.data.worldgen.placement.RuBiomePlacements;
import net.regions_unexplored.data.worldgen.placement.RuPlacements;
import net.regions_unexplored.data.worldgen.structures.MeadowRock;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;
import net.regions_unexplored.data.worldgen.structures.Spires;

public class RuBiomeDefaultFeatures {
    public static void mediumGrass(BiomeGenerationSettings.Builder p_126752_) {
        p_126752_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_MEDIUM_GRASS);
    }

    public static void mapleForestVegetation(BiomeGenerationSettings.Builder builder){
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_STONE_BUD);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_TRILLIUM);
    }

    public static void addOutbackExtraVegetation(BiomeGenerationSettings.Builder p_126752_) {
        p_126752_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        p_126752_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        p_126752_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_CACTUS_OUTBACK);
    }

    public static void addMuddyMarsh(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MUDDY_MARSHES);
    }

    public static void addSparseLily(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RuVegetationPlacements.PATCH_LILY_SPARSE);
    }

    public static void addWaterLake(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.LAKES, RuPlacements.LAKE_WATER);
    }

    public static void addRuFlowers(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.RU_DEFAULT_FLOWERS);
    }

    public static void pointedRedstone(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.ORE_REDSTONE_LARGE);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.POINTED_REDSTONE);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.LARGE_POINTED_REDSTONE);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.POINTED_REDSTONE_CLUSTER);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_REDSTONE_BUD);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_REDSTONE_BULB);
    }

    public static void netherPointedRedstone(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.POINTED_REDSTONE_NETHER);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.LARGE_POINTED_REDSTONE_NETHER);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.POINTED_REDSTONE_CLUSTER_NETHER);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_REDSTONE_BUD);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_REDSTONE_BULB);
    }

    public static void addSpringVegetation(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MINERAL_VEGETATION);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MINERAL_VEGETATION_DEEPSLATE);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MINERAL_POOL);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.TOP_DRIPSTONE);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MINERAL_VINES);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.OVERGROWN_VINES);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_AZALEA);
    }

    public static void addPinkFlowers(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.RU_PINK_FLOWERS);
    }

    public static void addMeadowRocks(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MeadowRock.PLACED_FEATURE);
    }

    public static void addSpires(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Spires.PLACED_FEATURE);
    }

    public static void addRuDisks(BiomeGenerationSettings.Builder p_126823_) {
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_SAND);
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_CLAY);
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_MUD);
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_GRAVEL);
    }

    public static void addMuddyDisks(BiomeGenerationSettings.Builder p_126823_) {
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_MUD_BIG);
        p_126823_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_CLAY);
    }

    public static void addMarsh(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.MARSHES);
    }

    public static void addQuicksand(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.QUICKSAND);
    }

    public static void addRiverCattail(BiomeGenerationSettings.Builder p_194721_) {
            p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CATTAIL_RIVER);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.WATER_CATTAIL);
    }

    public static void addGrasslandTallGrass(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GRASSLAND_STEPPE_GRASS);
    }

    public static void addBayouCattail(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CATTAIL_BAYOU);
    }

    public static void addSeededGrass(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_SEEDED_GRASSES);
    }

    public static void addForestFernsOnDirt(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_TALL_FOREST_FERNS);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_FOREST_FERNS);
    }

    public static void meadowFlowers(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.HYSSOP_MEADOW);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.DAISY_MEADOW);
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.FIREWEED_MEADOW);
    }

    public static void noiseRocks(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.NOISE_ROCKS);
    }

    public static void noiseBush(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.NOISE_BUSH);
    }

    public static void noiseAutumnBush(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.NOISE_AUTUMN_BUSH);
    }

    public static void noisePumpkins(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.NOISE_PUMPKINS);
    }

    public static void addDaisies(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_DAISIES);
    }

    public static void addDuckweed(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RuVegetationPlacements.PATCH_DUCKWEED);
    }

    public static void addSparseDuckweed(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RuVegetationPlacements.PATCH_DUCKWEED_SPARSE);
    }

    public static void addSeagrass(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RuVegetationPlacements.SEAGRASS);
    }

    public static void addRuBamboo(BiomeGenerationSettings.Builder p_194721_) {
        p_194721_.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RuVegetationPlacements.RU_BAMBOO);
    }
}
