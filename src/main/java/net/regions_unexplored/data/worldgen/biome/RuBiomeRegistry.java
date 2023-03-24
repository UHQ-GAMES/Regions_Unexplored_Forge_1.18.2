package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.config.RegionsUnexploredCommonConfigs;
import net.regions_unexplored.world.level.biome.*;
import terrablender.api.Regions;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RuBiomeRegistry {
    public static DeferredRegister<Biome> BIOME_REGISTER = DeferredRegister.create(Registry.BIOME_REGISTRY, RegionsUnexploredMod.MOD_ID);

    public static void registerBiomes() {
        register(RuBiomes.LUSH_DELTA, RuOverworldBiomes::lushDelta);
        register(RuBiomes.SCORCHING_CAVES, RuOverworldBiomes::scorch);
        register(RuBiomes.PRISMACHASM, RuOverworldBiomes::prismachasm);
        register(RuBiomes.REDSTONE_CAVES, RuOverworldBiomes::redstoneCaves);
        register(RuBiomes.BIOSHROOM_CAVES, RuOverworldBiomes::bioshroomCaves);
        register(RuBiomes.TROPICS, RuOverworldBiomes::tropics);
        register(RuBiomes.SMOULDERING_WOODLAND, RuOverworldBiomes::smoulderingWoodland);
        register(RuBiomes.GRASSY_BEACH, RuOverworldBiomes::grassyBeach);
        register(RuBiomes.DRY_BUSHLAND, RuOverworldBiomes::dryBushland);
        register(RuBiomes.ORCHARD, RuOverworldBiomes::orchard);
        register(RuBiomes.SPIRES, RuOverworldBiomes::spires);
        register(RuBiomes.FROZEN_TUNDRA, RuOverworldBiomes::frozenTundra);
        register(RuBiomes.BAMBOO_FOREST, RuOverworldBiomes::bambooForest);
        register(RuBiomes.BAOBAB_SAVANNA, RuOverworldBiomes::baobabSavanna);
        register(RuBiomes.LUPINE_PLAINS, RuOverworldBiomes::lupinePlains);
        register(RuBiomes.LUSH_HILLS, RuOverworldBiomes::lushHills);
        register(RuBiomes.FLOWER_FIELD, RuOverworldBiomes::flowerField);
        register(RuBiomes.ALPHA_GROVE, RuOverworldBiomes::alphaGrove);
        register(RuBiomes.ARID_MOUNTAINS, RuOverworldBiomes::aridMountains);
        register(RuBiomes.JOSHUA_DESERT, RuOverworldBiomes::joshuaDesert);
        register(RuBiomes.MAPLE_FOREST, RuOverworldBiomes::mapleForest);
        register(RuBiomes.CHERRY_HILLS, RuOverworldBiomes::cherryHills);
        register(RuBiomes.CHALK_CLIFFS, RuOverworldBiomes::chalkCliffs);
        register(RuBiomes.PUMPKIN_FIELDS, RuOverworldBiomes::pumpkinFields);
        register(RuBiomes.WILLOW_FOREST, RuOverworldBiomes::mixedForest);
        register(RuBiomes.RAINFOREST, RuOverworldBiomes::rainforest);
        register(RuBiomes.OLD_GROWTH_RAINFOREST, RuOverworldBiomes::oldGrowthRainforest);
        register(RuBiomes.FEN, RuOverworldBiomes::fen);
        register(RuBiomes.FUNGAL_FEN, RuOverworldBiomes::fungalFen);
        register(RuBiomes.SAGUARO_DESERT, RuOverworldBiomes::saguaroDesert);
        register(RuBiomes.OUTBACK, RuOverworldBiomes::outback);
        register(RuBiomes.MEADOW, RuOverworldBiomes::meadow);
        register(RuBiomes.STEPPE, RuOverworldBiomes::steppe);
        register(RuBiomes.ICY_HEIGHTS, RuOverworldBiomes::icyHeights);
        register(RuBiomes.AUTUMNAL_MAPLE_FOREST, RuOverworldBiomes::autumnalMapleForest);
        register(RuBiomes.FROZEN_FOREST, RuOverworldBiomes::frozenForest);
        register(RuBiomes.ICY_DESERT, RuOverworldBiomes::icyDesert);
        register(RuBiomes.TEMPERATE_GROVE, RuOverworldBiomes::temperateGrove);
        register(RuBiomes.GRASSLAND, RuOverworldBiomes::grassland);
        register(RuBiomes.BAYOU, RuOverworldBiomes::bayou);
        register(RuBiomes.GIANT_BAYOU, RuOverworldBiomes::giantBayou);
        register(RuBiomes.TOWERING_CLIFFS, RuOverworldBiomes::toweringCliffs);
        register(RuBiomes.FLOODED_PLAINS, RuOverworldBiomes::floodedPlains);
        register(RuBiomes.BLACKWOOD_FOREST, RuOverworldBiomes::blackwoodForest);
        register(RuBiomes.PRAIRIE, RuOverworldBiomes::prairie);
        register(RuBiomes.MUDDY_RIVER, RuOverworldBiomes::muddyRiver);
        register(RuBiomes.COLD_RIVER, RuOverworldBiomes::coldRiver);
        register(RuBiomes.BARLEY_FIELDS, RuOverworldBiomes::barleyFields);
        register(RuBiomes.POPPY_FIELDS, RuOverworldBiomes::poppyFields);
        register(RuBiomes.GRAVEL_BEACH, RuOverworldBiomes::gravelBeach);
        register(RuBiomes.BOREAL_FOREST, RuOverworldBiomes::borealForest);
        register(RuBiomes.SILVER_BIRCH_FOREST, RuOverworldBiomes::silverBirchForest);
        register(RuBiomes.SHRUBLAND, RuOverworldBiomes::shrubland);
        register(RuBiomes.PINE_SLOPES, RuOverworldBiomes::pineSlopes);
        register(RuBiomes.MAUVE_HILLS, RuOverworldBiomes::mauveHills);
        register(RuBiomes.MOUNTAINS, RuOverworldBiomes::mountains);
        register(RuBiomes.PINE_FOREST, RuOverworldBiomes::pineForest);
        register(RuBiomes.EUCALYPTUS_FOREST, RuOverworldBiomes::eucalyptusForest);
        register(RuBiomes.REDWOODS, RuOverworldBiomes::redwoodForest);
        register(RuBiomes.SPARSE_REDWOODS, RuOverworldBiomes::sparseRedwoods);
        register(RuBiomes.HIGHLAND_FIELDS, RuOverworldBiomes::highlandFields);
        register(RuBiomes.DECIDUOUS_FOREST, RuOverworldBiomes::deciduousForest);
        register(RuBiomes.COLD_DECIDUOUS_FOREST, RuOverworldBiomes::coldDeciduousForest);
        register(RuBiomes.COLD_BOREAL_FOREST, RuOverworldBiomes::coldBorealForest);
        register(RuBiomes.GOLDEN_BOREAL_FOREST, RuOverworldBiomes::goldenBorealForest);

        register(RuBiomes.MYCOTOXIC_UNDERGROWTH, RuNetherBiomes::mycotoxicUndergrowth);
        register(RuBiomes.GLISTERING_MEADOW, RuNetherBiomes::glisteringMeadow);
        register(RuBiomes.REDSTONE_HELL, RuNetherBiomes::redstoneHell);
        register(RuBiomes.CORRUPTED_HOLT, RuNetherBiomes::corruptedHolt);
        register(RuBiomes.BLACKSTONE_BASIN, RuNetherBiomes::blackstoneBasin);
    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier) {
        return BIOME_REGISTER.register(key.location().getPath(), biomeSupplier);
    }
}