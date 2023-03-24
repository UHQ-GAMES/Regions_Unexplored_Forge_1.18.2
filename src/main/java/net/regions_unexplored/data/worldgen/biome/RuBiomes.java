package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuBiomes {

    public static final ResourceKey<Biome> REDSTONE_CAVES = register("redstone_caves");
    public static final ResourceKey<Biome> BIOSHROOM_CAVES = register("bioshroom_caves");
    public static final ResourceKey<Biome> PRISMACHASM = register("prismachasm");
    public static final ResourceKey<Biome> LUSH_DELTA = register("lush_delta");
    public static final ResourceKey<Biome> SCORCHING_CAVES = register("scorching_caves");
    public static final ResourceKey<Biome> TROPICS = register("tropics");
    public static final ResourceKey<Biome> SMOULDERING_WOODLAND = register("smouldering_woodland");
    public static final ResourceKey<Biome> GRASSY_BEACH = register("grassy_beach");
    public static final ResourceKey<Biome> DRY_BUSHLAND = register("dry_bushland");
    public static final ResourceKey<Biome> ORCHARD = register("orchard");
    public static final ResourceKey<Biome> SPIRES = register("spires");
    public static final ResourceKey<Biome> FROZEN_TUNDRA = register("frozen_tundra");
    public static final ResourceKey<Biome> BAMBOO_FOREST = register("bamboo_forest");
    public static final ResourceKey<Biome> BAOBAB_SAVANNA = register("baobab_savanna");
    public static final ResourceKey<Biome> LUPINE_PLAINS = register("lupine_plains");
    public static final ResourceKey<Biome> LUSH_HILLS = register("lush_hills");
    public static final ResourceKey<Biome> FLOWER_FIELD = register("flower_field");
    public static final ResourceKey<Biome> ARID_MOUNTAINS = register("arid_mountains");
    public static final ResourceKey<Biome> MAPLE_FOREST = register("maple_forest");
    public static final ResourceKey<Biome> CHERRY_HILLS = register("cherry_hills");
    public static final ResourceKey<Biome> CHALK_CLIFFS = register("chalk_cliffs");
    public static final ResourceKey<Biome> PUMPKIN_FIELDS = register("pumpkin_fields");
    public static final ResourceKey<Biome> WILLOW_FOREST = register("willow_forest");
    public static final ResourceKey<Biome> RAINFOREST = register("rainforest");
    public static final ResourceKey<Biome> OLD_GROWTH_RAINFOREST = register("old_growth_rainforest");
    public static final ResourceKey<Biome> FEN = register("fen");
    public static final ResourceKey<Biome> FUNGAL_FEN = register("fungal_fen");
    public static final ResourceKey<Biome> SAGUARO_DESERT = register("saguaro_desert");
    public static final ResourceKey<Biome> OUTBACK = register("outback");
    public static final ResourceKey<Biome> MEADOW = register("meadow");
    public static final ResourceKey<Biome> FLOODED_PLAINS = register("flooded_plains");
    public static final ResourceKey<Biome> ALPHA_GROVE = register("alpha_grove");
    public static final ResourceKey<Biome> JOSHUA_DESERT = register("joshua_desert");
    public static final ResourceKey<Biome> STEPPE = register("steppe");
    public static final ResourceKey<Biome> ICY_HEIGHTS = register("icy_heights");
    public static final ResourceKey<Biome> MAUVE_HILLS = register("mauve_hills");
    public static final ResourceKey<Biome> AUTUMNAL_MAPLE_FOREST = register("autumnal_maple_forest");
    public static final ResourceKey<Biome> TEMPERATE_GROVE = register("temperate_grove");
    public static final ResourceKey<Biome> GRASSLAND = register("grassland");
    public static final ResourceKey<Biome> BAYOU = register("bayou");
    public static final ResourceKey<Biome> GIANT_BAYOU = register("giant_bayou");
    public static final ResourceKey<Biome> TOWERING_CLIFFS = register("towering_cliffs");
    public static final ResourceKey<Biome> BLACKWOOD_FOREST = register("blackwood_forest");
    public static final ResourceKey<Biome> PRAIRIE = register("prairie");
    public static final ResourceKey<Biome> BARLEY_FIELDS = register("barley_fields");
    public static final ResourceKey<Biome> POPPY_FIELDS = register("poppy_fields");
    public static final ResourceKey<Biome> HIGHLAND_FIELDS = register("highland_fields");
    public static final ResourceKey<Biome> GRAVEL_BEACH = register("gravel_beach");
    public static final ResourceKey<Biome> BOREAL_FOREST = register("boreal_forest");
    public static final ResourceKey<Biome> PINE_FOREST = register("pine_forest");
    public static final ResourceKey<Biome> COLD_BOREAL_FOREST = register("cold_boreal_forest");
    public static final ResourceKey<Biome> GOLDEN_BOREAL_FOREST = register("golden_boreal_forest");
    public static final ResourceKey<Biome> SILVER_BIRCH_FOREST = register("silver_birch_forest");
    public static final ResourceKey<Biome> DECIDUOUS_FOREST = register("deciduous_forest");
    public static final ResourceKey<Biome> COLD_DECIDUOUS_FOREST = register("cold_deciduous_forest");
    public static final ResourceKey<Biome> SHRUBLAND = register("shrubland");
    public static final ResourceKey<Biome> PINE_SLOPES = register("pine_slopes");
    public static final ResourceKey<Biome> MOUNTAINS = register("mountains");
    public static final ResourceKey<Biome> MUDDY_RIVER = register("muddy_river");
    public static final ResourceKey<Biome> COLD_RIVER = register("cold_river");
    public static final ResourceKey<Biome> REDWOODS = register("redwoods");
    public static final ResourceKey<Biome> SPARSE_REDWOODS = register("sparse_redwoods");
    public static final ResourceKey<Biome> EUCALYPTUS_FOREST = register("eucalyptus_forest");
    public static final ResourceKey<Biome> FROZEN_FOREST = register("frozen_forest");
    public static final ResourceKey<Biome> ICY_DESERT = register("icy_desert");

    public static final ResourceKey<Biome> MYCOTOXIC_UNDERGROWTH = register("mycotoxic_undergrowth");
    public static final ResourceKey<Biome> GLISTERING_MEADOW = register("glistering_meadow");
    public static final ResourceKey<Biome> REDSTONE_HELL = register("redstone_hell");
    public static final ResourceKey<Biome> CORRUPTED_HOLT = register("corrupted_holt");
    public static final ResourceKey<Biome> BLACKSTONE_BASIN = register("blackstone_basin");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}