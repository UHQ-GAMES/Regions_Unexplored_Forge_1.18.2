package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.data.worldgen.placement.RuBiomePlacements;
import net.regions_unexplored.client.particle.RegionsUnexploredParticleTypes;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;
import net.regions_unexplored.data.worldgen.placement.RuPlacements;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

import javax.annotation.Nullable;

public class RuOverworldBiomes {

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
    
    @Nullable
    private static final Music NORMAL_MUSIC = null;
    
    //CAVE BIOMES
    public static Biome scorch() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(-6384241).waterColor(-10129331).waterFogColor(-10989767).skyColor(-9146774).foliageColorOverride(-8949914).grassColorOverride(-8621472)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.1F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, RuPlacements.OVERWORLD_LAVA_DELTA);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuPlacements.BASALT_BLOB);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuPlacements.ASH_VENT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SCORCH_TREES);
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, RuPlacements.LAVA_FALL);


        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.UNDERGROUND).temperature(2f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome lushDelta() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-13369345).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(-10118056).grassColorOverride(-9658528).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_YELLOW_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_PINK_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_DELTA_TREES);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.addSpringVegetation(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.UNDERGROUND).temperature(1.125f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome redstoneCaves() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12619852).waterFogColor(-14007447)
                .skyColor(7972607).foliageColorOverride(-16737793).grassColorOverride(-6625354).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.pointedRedstone(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.UNDERGROUND).temperature(0.8f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome prismachasm() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-14772238).waterFogColor(-15959346)
                .skyColor(-13068579).foliageColorOverride(-16737793).grassColorOverride(-6625354)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.FIREWORK, 0.002f)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRISMACHASM_SPROUT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRISMACHASM_CRYSTAL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRISMACHASM_HYSSOP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuPlacements.HANGING_PRISMARITE_CLUSTER);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.UNDERGROUND).temperature(0.925f)
                .downfall(0.9f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome bioshroomCaves() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .skyColor(7972607)
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .grassColorOverride(-11093361)
                .foliageColorOverride(-11093410)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.SPORE_BLOSSOM_AIR, 0.01F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES))
                .build();
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.AXOLOTLS, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 10, 4, 6));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_GIANT_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_GIANT_BLUE_BIOSHROOM);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_TALL_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_BLUE_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BIOSHROOM_CAVES_PINK_BIOSHROOM);


        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)

                .temperature(1.25f)
                .biomeCategory(Biome.BiomeCategory.UNDERGROUND)
                .downfall(0.9f)
                .specialEffects(effects)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
    public static Biome pineSlopes() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12619852).waterFogColor(-14007447)
                .skyColor(7972607).foliageColorOverride(-9075130).grassColorOverride(-8083622).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_SLOPES_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_SLOPES_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_SLOPES_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.MOUNTAIN).temperature(0.375f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome mountains() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12619852).waterFogColor(-14007447)
                .skyColor(7972607).foliageColorOverride(-9075130).grassColorOverride(-8083622).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MOUNTAINS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MOUNTAINS_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MOUNTAINS_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MOUNTAINS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_FOREST_FERNS);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.MOUNTAIN).temperature(0.28f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome highlandFields() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
                .skyColor(-1635927829).foliageColorOverride(-8275350).grassColorOverride(-9782677).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 4, 6));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.noiseBush(biomeBuilder);
        RuBiomeDefaultFeatures.noiseRocks(biomeBuilder);
        RuBiomeDefaultFeatures.addDaisies(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.65f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome lushHills() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-10566460).waterFogColor(-12229487)
                .skyColor(-1635927829).foliageColorOverride(-8010658).grassColorOverride(-7493535).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 4, 6));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_HILLS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUSH_HILLS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_OAK_SAPLING);


        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).temperature(0.775f)
                .downfall(0.55f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome muddyRiver() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-7159980).grassColorOverride(-6044317).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MUDDY_RIVER_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MUDDY_RIVER_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_OAK_SAPLING);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRiverCattail(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_MUD_BIG);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.RIVER).temperature(0.75f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome coldRiver() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5718172).grassColorOverride(-4733087).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_MAPLE_SAPLING);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRiverCattail(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.RIVER).temperature(0.4f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome grassyBeach() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8933043).grassColorOverride(-2697863).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GRASSY_BEACH_SANDY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GRASSY_BEACH_SANDY_TALL_GRASS);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.85f)
                .downfall(0.775f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome gravelBeach() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8673714).grassColorOverride(-7819420).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.6f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    //DONE_FOR_1_20
    public static Biome mapleForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(6462505).grassColorOverride(9550928)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_RED_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_BIG_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAPLE_FOREST_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_MAPLE_SAPLING_MIX);
        RuBiomeDefaultFeatures.mapleForestVegetation(biomeBuilder);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.6f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome fen() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-11629645).waterFogColor(-12884349)
                .skyColor(7972607).foliageColorOverride(8754506).grassColorOverride(10858333).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_DEAD_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_DEAD_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FEN_CATTAILS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_DEAD_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addMuddyDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addDuckweed(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.85f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome blackwoodForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5322337).waterColor(-13668958).waterFogColor(-12557181)
                .skyColor(-5322337).foliageColorOverride(-12430037).grassColorOverride(-12687577)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.005F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 5, 1, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_TALL_BLACKWOOD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_BLACKWOOD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_DARK_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_PINK_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BLACKWOOD_FOREST_BLUE_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_BLACKWOOD_DARK_OAK_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.825f)
                .downfall(0.765f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    //TODO:NEW FLOWERS
    public static Biome flowerField() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-10635453).grassColorOverride(-9189045).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_YELLOW_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_RED_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_PINK_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_PURPLE_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_BLUE_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_POPPY_PATCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_HYSSOP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_WARATAH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_TRILLIUM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_TSUBAKI);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_FIREWEED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_FELICIA_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_TASSEL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_POPPIES);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_BLUE_ORCHIDS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_ALLIUM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_RED_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_ORANGE_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_PINK_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_WHITE_TULIP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_OXEYE_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_CORNFLOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_LILLIES);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_SUNFLOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOWER_FIELD_BLUE_BIOSHROOM);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.975f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome grassland() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-7159980).grassColorOverride(-6044317).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GRASSLAND_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GRASSLAND_GRASS);


        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addGrasslandTallGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addRareBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.85f)
                .downfall(0.45f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome baobabSavanna() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6636971).grassColorOverride(-4670891).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_BIG_BAOBAB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_SMALL_BAOBAB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_ACACIA);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_STONE_BUD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAOBAB_SAVANNA_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_BAOBAB_SAPLING);


        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SAVANNA).temperature(2f)
                .downfall(0.35f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome shrubland() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8999081).grassColorOverride(-6637733).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_SPRUCE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_OAK_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_SPRUCE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_YELLOW_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SHRUBLAND_RED_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_SPRUCE_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addGrasslandTallGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addRareBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.575f)
                .downfall(0.4f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome icyHeights() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(-3411969)
                .foliageColorOverride(-9913745).grassColorOverride(-9059189).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ICY_HEIGHTS_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ICY_HEIGHTS_DEAD_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ICY_HEIGHTS_SNOWY_GRASS);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-1.0f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome oldGrowthRainforest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-13392941).waterFogColor(-11558718)
                .skyColor(7972607).foliageColorOverride(-11032271).grassColorOverride(-9718455).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_PALM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_BIG_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_BLUE_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OLD_GROWTH_RAINFOREST_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PALM_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(1f)
                .downfall(1.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome rainforest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-13392941).waterFogColor(-11558718)
                .skyColor(7972607).foliageColorOverride(-11032271).grassColorOverride(-9718455).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_PALM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_BIG_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_PINK_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.RAINFOREST_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PALM_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(1f)
                .downfall(0.95f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome tropics() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-13255466).waterFogColor(-11171160)
                .skyColor(-1635927829).foliageColorOverride(-11617740).grassColorOverride(-11225797).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 5, 1, 5));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_PALM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_BIG_JUNGLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_PINK_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_RED_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_FELICIA_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_SANDY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TROPICS_SANDY_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PALM_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(1.05f)
                .downfall(0.95f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    //DONE_FOR_1_20
    public static Biome pumpkinFields() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .skyColor(7972607)
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .foliageColorOverride(9877306)
                .grassColorOverride(11585358)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_RED_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_ORANGE_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_DEAD_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_SILVER_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_BIG_RED_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_BIG_ORANGE_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_FIELDS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_AUTUMNAL_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.noisePumpkins(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addRareBerryBushes(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .temperature(0.225f)
                .biomeCategory(Biome.BiomeCategory.PLAINS)
                .downfall(0.3f)
                .specialEffects(effects)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
    //DONE_FOR_1_20
    public static Biome autumnalMapleForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .skyColor(7972607)
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .foliageColorOverride(9877306)
                .grassColorOverride(12896058)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(NORMAL_MUSIC)
                .build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_RED_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_ORANGE_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_MAPLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_SILVER_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_BIG_RED_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_BIG_ORANGE_MAPLE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.AUTUMNAL_MAPLE_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_AUTUMNAL_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .temperature(0.225f)
                .biomeCategory(Biome.BiomeCategory.FOREST)
                .downfall(0.3f)
                .specialEffects(effects)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
    public static Biome mixedForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8999072).grassColorOverride(-8739993).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_WHITE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_SPRUCE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_DEAD_SPRUCE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_BIG_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.WILLOW_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_WILLOW_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addPinkFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.6f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome coldBorealForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-9922472).grassColorOverride(-9917084).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_GOLDEN_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_SMALL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_LARCH_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(0.0f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome borealForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12619852).waterFogColor(-14007447)
                .skyColor(7972607).foliageColorOverride(-8673714).grassColorOverride(-7819420).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_GOLDEN_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_SMALL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BOREAL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_LARCH_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.5f)
                .downfall(0.4f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome chalkCliffs() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8414642).grassColorOverride(-6044317).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHALK_CLIFFS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHALK_CLIFFS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_FLOWERING_SAPLING);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.775f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome lupinePlains() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6044317).grassColorOverride(-6044317).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_YELLOW_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_RED_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_BLUE_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_PURPLE_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_PINK_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.LUPINE_PLAINS_STONE_BUD);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(1.35f)
                .downfall(0.25f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome steppe() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5589135).grassColorOverride(-5067675).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.STEPPE_PLAINS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.STEPPE_PLAINS_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.STEPPE_PLAINS_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.STEPPE_PLAINS_DEAD_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.STEPPE_PLAINS_DESERT_SHRUB);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SAVANNA).temperature(1.5f)
                .downfall(0.25f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome aridMountains() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6773446).grassColorOverride(-4279222).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_STONE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_ACACIA_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_ACACIA);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ARID_MOUNTAINS_STONE_BUD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_ACACIA_SAPLING);


        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.MOUNTAIN).temperature(2f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome joshuaDesert() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8409523).grassColorOverride(-5213).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.JOSHUA_DESERT_LARGE_JOSHUA_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.JOSHUA_DESERT_MEDIUM_JOSHUA_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.JOSHUA_DESERT_DEAD_STEPPE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.JOSHUA_DESERT_DESERT_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.JOSHUA_DESERT_SANDY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_JOSHUA_SAPLING);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome prairie() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8933043).grassColorOverride(-2697863).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRAIRIE_BIG_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRAIRIE_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PRAIRIE_BARLEY);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addSeededGrass(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.75f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome barleyFields() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5256873).grassColorOverride(-5754).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BARLEY_FIELDS_BARLEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BARLEY_FIELDS_GRASS);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.85f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome goldenBorealForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-4214704).grassColorOverride(-6376609).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_GOLDEN_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_SMALL_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GOLDEN_BOREAL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_GOLDEN_LARCH_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.45f)
                .downfall(0.3f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    //DONE_TEMP
    public static Biome alphaGrove() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(12638463)
                .waterColor(-14919459)
                .waterFogColor(-12292142)
                .skyColor(7972607)
                .foliageColorOverride(-10749125)
                .grassColorOverride(-7876009)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ALPHA_GROVE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ALPHA_GROVE_ROSE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ALPHA_GROVE_DANDELION);

        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.0f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    //DONE_FOR_1_20
    public static Biome silverBirchForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .skyColor(7972607)
                .fogColor(12638463)
                .waterColor(4159204)
                .waterFogColor(329011)
                .foliageColorOverride(11585338)
                .grassColorOverride(11585338)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(NORMAL_MUSIC)
                .build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_ASPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_SILVER_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_BIRCH);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_SEEDED_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SILVER_BIRCH_FOREST_TASSEL);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_BIRCH_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .temperature(0.6f)
                .biomeCategory(Biome.BiomeCategory.FOREST)
                .downfall(0.6f)
                .specialEffects(effects)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
    public static Biome deciduousForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-7491753).grassColorOverride(-7491753).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DECIDUOUS_FOREST_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DECIDUOUS_FOREST_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DECIDUOUS_FOREST_BIG_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_OAK_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        RuBiomeDefaultFeatures.addSeededGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.75f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome orchard() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6108056).grassColorOverride(-5059481).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_APPLE_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_BIG_APPLE_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_BIG_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_TASSEL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ORCHARD_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_OAK_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.7f)
                .downfall(0.4f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome redwoodForest() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-9264584).grassColorOverride(-8537031).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.REDWOODS_GIANT_REDWOOD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.REDWOODS_REDWOOD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.REDWOODS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.REDWOODS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_REDWOOD_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(1f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome sparseRedwoods() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-9264584).grassColorOverride(-8537031).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SPARSE_REDWOODS_REDWOOD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SPARSE_REDWOODS_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SPARSE_REDWOODS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_REDWOOD_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.95f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome giantBayou() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5124939).waterColor(-12354486).waterFogColor(-10450614)
                .skyColor(-6110795).foliageColorOverride(-9333940).grassColorOverride(-8609196)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_BIG_CYPRESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_BIG_CYPRESS_MOSS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_OAK_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_BIG_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.GIANT_BAYOU_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_CYPRESS_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.addWaterLake(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_MUD_BIG);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addBayouCattail(biomeBuilder);
        RuBiomeDefaultFeatures.addSparseLily(biomeBuilder);
        RuBiomeDefaultFeatures.addMuddyMarsh(biomeBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(1f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome bayou() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-1350062718).waterColor(-12354486).waterFogColor(-10450614)
                .skyColor(-1350062718).foliageColorOverride(-9333940).grassColorOverride(-8609196)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_MOSSY_CYPRESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_CYPRESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_BIG_CYPRESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_BIG_MOSSY_CYPRESS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAYOU_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_WILLOW_CYPRESS_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuPlacements.RU_MUD_BIG);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
        RuBiomeDefaultFeatures.addSeagrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addBayouCattail(biomeBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.95f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome bambooForest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5124939).waterColor(4159204).waterFogColor(329011).skyColor(-6110795)
                .foliageColorOverride(-5636253).grassColorOverride(-4923788).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 80, 1, 2));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAMBOO_FOREST_GIANT_BAMBOO);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAMBOO_FOREST_TSUBAKI);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAMBOO_FOREST_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.BAMBOO_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_CHERRY_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        RuBiomeDefaultFeatures.addRuBamboo(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.875f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome poppyFields() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8414642).grassColorOverride(-6044317).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.POPPY_FIELDS_POPPY_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.POPPY_FIELDS_POPPY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.POPPY_FIELDS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_RED_MAPLE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.85f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome pineForest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-9075130).grassColorOverride(-8083622).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_FOREST_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_FOREST_TALL_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_FOREST_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.PINE_FOREST_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.addForestFernsOnDirt(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.6f)
                .downfall(0.4f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome cherryHills() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8929686).grassColorOverride(-9781654).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_BIG_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_RED_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_RED_BIG_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_PINK_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_PINK_BIG_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_WHITE_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_WHITE_BIG_CHERRY_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.CHERRY_HILLS_TSUBAKI);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_CHERRY_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addPinkFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.95f)
                .downfall(0.8f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome temperateGrove() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6705587).grassColorOverride(-7953067).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_MAPLE_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_BIRCH_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_OAK_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_LARCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_TASSEL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TEMPERATE_GROVE_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_FLOWERING_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.775f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome eucalyptusForest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(-9651647).grassColorOverride(-9651647).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_EUCALYPTUS_TREE_CANOPY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_EUCALYPTUS_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_SAPLING);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.EUCALYPTUS_FOREST_WARATAH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_EUCALYPTUS_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(1.15f)
                .downfall(0.85f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome mauveHills() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-11230855).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(-12810288).grassColorOverride(-9259116)
                .ambientParticle(new AmbientParticleSettings((SimpleParticleType) (RegionsUnexploredParticleTypes.MAUVE.get()), 0.005f)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_MAUVE_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_BIG_MAUVE_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_PURPLE_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_PINK_LUPINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MAUVE_HILLS_PINK_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_MAUVE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addPinkFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(1.1f)
                .downfall(0.85f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome toweringCliffs() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-7362208).grassColorOverride(-8482734).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 5, 1, 3));
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TOWERING_CLIFFS_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TOWERING_CLIFFS_DEAD_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TOWERING_CLIFFS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TOWERING_CLIFFS_HYSSOP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.TOWERING_CLIFFS_FERNS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_DEAD_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).temperature(0.335f)
                .downfall(0.65f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome fungalFen() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-435307641).waterFogColor(-435242116).skyColor(-427965270)
                .foliageColorOverride(-433341681).grassColorOverride(-430585537)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MOOSHROOM, 8, 4, 8));
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_BROWN_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_RED_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_ELEPHANT_EAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FUNGAL_FEN_BLUE_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_PINE_SAPLING);


        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSparseJungleMelons(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.975f)
                .downfall(0.9f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome outback() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-8016810).grassColorOverride(-4670891).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_SHRUB_DENSE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_DEAD_STEPPE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_DESERT_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.OUTBACK_STONE_BUD);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        RuBiomeDefaultFeatures.addOutbackExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2f)
                .downfall(0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome saguaroDesert() {

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-6836695).grassColorOverride(-4212907).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SAGUARO_DESERT_CACTUS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SAGUARO_DESERT_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SAGUARO_DESERT_SANDY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SAGUARO_DESERT_BARREL_CACTUS);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addQuicksand(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PATCH_CACTUS_OUTBACK);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.75f)
                .downfall(0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome frozenTundra() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5207984).grassColorOverride(-5215920).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 8, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_MAPLE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_SHRUB_SNOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_MAPLE_SHRUB_SNOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_SNOWY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_TUNDRA_GRASS);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.noiseAutumnBush(biomeBuilder);
        RuBiomeDefaultFeatures.noiseRocks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-1f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome dryBushland() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5060484).grassColorOverride(-3552115).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_ACACIA);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_JOSHUA_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_SHRUB_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_JOSHUA_SHRUB_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_SANDY_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_DESERT_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.DRY_BRUSHLAND_FIREWEED);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_ACACIA_SAPLING);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.SAVANNA).temperature(1.5f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome coldDeciduousForest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-5718172).grassColorOverride(-4733087).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 12, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.COLD_DECIDUOUS_FOREST_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.COLD_DECIDUOUS_FOREST_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.COLD_DECIDUOUS_FOREST_BIG_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.COLD_DECIDUOUS_FOREST_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_RED_MAPLE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(0.0f)
                .downfall(0.45f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome icyDesert() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(-3411969)
                .foliageColorOverride(-10247846).grassColorOverride(-10247846).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 8, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ICY_DESERT_STONE_BUD);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.ICY_DESERT_SNOWY_GRASS);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-2.0f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome spires() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(-3411969)
                .foliageColorOverride(-11097502).grassColorOverride(-11097488).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 8, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SPIRES_SNOWY_GRASS);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-2f)
                .downfall(0.95f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome smoulderingWoodland() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-6384241).waterColor(-10073800).waterFogColor(-11585236).skyColor(-5400196)
                .foliageColorOverride(-7901343).grassColorOverride(-6391454).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.05F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 100, 4, 4));
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();


        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuPlacements.ASH_VENT_SURFACE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_DEAD_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_DORCEL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_TRILLIUM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_DEAD_STEPPE_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.SMOULDERING_WOODLAND_DESERT_SHRUB);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_DEAD_SAPLING_MIX);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).temperature(2f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome frozenForest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(4159204).skyColor(-3411969)
                .foliageColorOverride(-9922472).grassColorOverride(-9917084).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_FOREST_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_FOREST_TALL_PINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FROZEN_FOREST_SNOWY_GRASS);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.noiseRocks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-0.5f)
                .downfall(0.6f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome meadow() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011).skyColor(7972607)
                .foliageColorOverride(-9001891).grassColorOverride(-7486095).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MEADOW_MAUVE_OAK_BEE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MEADOW_MAUVE_OAK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.MEADOW_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_MAUVE_SAPLING);

        globalOverworldGeneration(biomeBuilder);
        
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        RuBiomeDefaultFeatures.meadowFlowers(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addRuDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addPinkFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.825f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
    public static Biome floodedPlains() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12092489).waterFogColor(-13677218).skyColor(7972607)
                .foliageColorOverride(-8339092).grassColorOverride(-8536223).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(NORMAL_MUSIC).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5)));
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOODED_PLAINS_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuBiomePlacements.FLOODED_PLAINS_TALL_GRASS);

        globalOverworldGeneration(biomeBuilder);
        RuBiomeDefaultFeatures.mediumGrass(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        RuBiomeDefaultFeatures.addMuddyDisks(biomeBuilder);
        RuBiomeDefaultFeatures.addSparseDuckweed(biomeBuilder);
        RuBiomeDefaultFeatures.addRuFlowers(biomeBuilder);
        RuBiomeDefaultFeatures.addMarsh(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.85f)
                .downfall(0.7f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
}

