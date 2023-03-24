package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;
import net.regions_unexplored.data.worldgen.placement.RuNetherBiomePlacements;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;
import net.regions_unexplored.client.particle.RegionsUnexploredParticleTypes;
import static net.regions_unexplored.data.worldgen.biome.RuOverworldBiomes.calculateSkyColor;

public class RuNetherBiomes {
    
    public static Biome mycotoxicUndergrowth() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(10717988).waterColor(10717988).waterFogColor(10717988)
                .skyColor(calculateSkyColor(2.0f)).foliageColorOverride(10717988).grassColorOverride(10717988).ambientParticle(new AmbientParticleSettings((SimpleParticleType) (RegionsUnexploredParticleTypes.MYCOTOXIC_SPORE.get()), 0.01f))
                .ambientLoopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST)).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 5, 3, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_TALL_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_SMALL_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_MEDIUM_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.MYCOTOXIC_UNDERGROWTH_BIG_MUSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE).temperature(2.0F).downfall(0.0F).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome redstoneHell() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(8853780).waterColor(10623252).waterFogColor(8853780)
                .skyColor(calculateSkyColor(2.0f)).foliageColorOverride(10623252).grassColorOverride(10623252).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.025F))
                .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES)).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        RuBiomeDefaultFeatures.netherPointedRedstone(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(2.0f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome glisteringMeadow() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(10362720).waterColor(12058781).waterFogColor(12058781)
                .skyColor(calculateSkyColor(2.0f)).foliageColorOverride(12058781).grassColorOverride(12058781).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.02F))
                .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST)).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 5, 1, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 40, 1, 2))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 5, 1, 3));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.GLISTERING_MEADOW_ROCK);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.GLISTERING_MEADOW_BULB);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.GLISTERING_MEADOW_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.GLISTERING_MEADOW_SPIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.GLISTERING_MEADOW_IVY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(2.0f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome corruptedHolt() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(338482).waterColor(37525).waterFogColor(338482)
                .skyColor(calculateSkyColor(2.0f)).foliageColorOverride(217444).grassColorOverride(217444).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.03F))
                .ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST)).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder());

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);

        BiomeDefaultFeatures.addSculk(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuVegetationPlacements.SCULK_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuVegetationPlacements.GIANT_SCULK_WILLOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.SCULK_SPROUT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.SCULK_TENDRIL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.BLACKSTONE_BLOBS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(2.0f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome blackstoneBasin() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(2094).waterColor(667776).waterFogColor(667776)
                .skyColor(calculateSkyColor(2.0f)).foliageColorOverride(660650).grassColorOverride(660650).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.02F))
                .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST)).build();

        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 25, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 20, 1, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.OBSIDIAN_SPIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.COBALT_ROOTS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.COBALT_EARLIGHT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.BLACKSTONE_CLUSTER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherBiomePlacements.HANGING_EARLIGHT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.BLACKSTONE_BLOBS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(2.0f)
                .downfall(0.0f).specialEffects(effects).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }
}