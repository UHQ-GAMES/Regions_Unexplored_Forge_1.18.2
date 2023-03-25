package net.regions_unexplored.world.level.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.util.worldgen.CheckBiomeConfig;

import java.util.function.Consumer;

public class RegionPrimaryBiomeBuilder {
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]
            {
                    Climate.Parameter.span(-1.0F, -0.45F),
                    Climate.Parameter.span(-0.45F, -0.15F),
                    Climate.Parameter.span(-0.15F, 0.2F),
                    Climate.Parameter.span(0.2F, 0.55F),
                    Climate.Parameter.span(0.55F, 1.0F)
            };

    private final Climate.Parameter[] humidities = new Climate.Parameter[]
            {
                    Climate.Parameter.span(-1.0F, -0.35F),
                    Climate.Parameter.span(-0.35F, -0.1F),
                    Climate.Parameter.span(-0.1F, 0.1F),
                    Climate.Parameter.span(0.1F, 0.3F),
                    Climate.Parameter.span(0.3F, 1.0F)
            };

    private final Climate.Parameter[] erosions = new Climate.Parameter[]
            {
                    Climate.Parameter.span(-1.0F, -0.78F),
                    Climate.Parameter.span(-0.78F, -0.375F),
                    Climate.Parameter.span(-0.375F, -0.2225F),
                    Climate.Parameter.span(-0.2225F, 0.05F),
                    Climate.Parameter.span(0.05F, 0.45F),
                    Climate.Parameter.span(0.45F, 0.55F),
                    Climate.Parameter.span(0.55F, 1.0F)
            };
    
    private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);

    private final ResourceKey<Biome>[][] VANILLA_OCEANS = new ResourceKey[][]{
            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}};

    private final ResourceKey<Biome>[][] VANILLA_MIDDLE_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    private final ResourceKey<Biome>[][] VANILLA_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    private final ResourceKey<Biome>[][] VANILLA_PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};

    private final ResourceKey<Biome>[][] VANILLA_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};

    private final ResourceKey<Biome>[][] VANILLA_SHATTERED_BIOMES = new ResourceKey[][]{
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    private final ResourceKey<Biome>[][] VANILLA_RIVER_BIOMES = new ResourceKey[][]{
            {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER}};

    private final ResourceKey<Biome>[][] VANILLA_RIVER_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER}};

    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_DESERT, RuBiomes.FROZEN_TUNDRA, RuBiomes.FROZEN_TUNDRA, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST},
            /*COOL*/    {RuBiomes.PUMPKIN_FIELDS, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST, RuBiomes.MAPLE_FOREST, RuBiomes.BOREAL_FOREST},
            /*NEUTRAL*/ {RuBiomes.ORCHARD, RuBiomes.SHRUBLAND, RuBiomes.PINE_FOREST, RuBiomes.TEMPERATE_GROVE, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.PRAIRIE, RuBiomes.DECIDUOUS_FOREST, RuBiomes.PRAIRIE, RuBiomes.BARLEY_FIELDS, RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.BAOBAB_SAVANNA, RuBiomes.BAOBAB_SAVANNA, RuBiomes.SAGUARO_DESERT, RuBiomes.SAGUARO_DESERT, RuBiomes.OLD_GROWTH_RAINFOREST}};

    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.SPIRES, RuBiomes.FROZEN_TUNDRA, RuBiomes.FROZEN_TUNDRA, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST, RuBiomes.BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST},
            /*NEUTRAL*/ {RuBiomes.ORCHARD, RuBiomes.SHRUBLAND, RuBiomes.PINE_FOREST, RuBiomes.TEMPERATE_GROVE, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.BARLEY_FIELDS, RuBiomes.DECIDUOUS_FOREST, RuBiomes.PRAIRIE, RuBiomes.REDWOODS, RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.DRY_BUSHLAND, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.JOSHUA_DESERT, RuBiomes.OLD_GROWTH_RAINFOREST}};

    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.COLD_BOREAL_FOREST},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST, RuBiomes.BOREAL_FOREST, RuBiomes.BOREAL_FOREST},
            /*NEUTRAL*/ {RuBiomes.HIGHLAND_FIELDS, RuBiomes.HIGHLAND_FIELDS, RuBiomes.DECIDUOUS_FOREST, RuBiomes.HIGHLAND_FIELDS, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE, RuBiomes.STEPPE, RuBiomes.RAINFOREST, RuBiomes.RAINFOREST, RuBiomes.RAINFOREST}};

    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.SPIRES, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.COLD_BOREAL_FOREST},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST, RuBiomes.BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST},
            /*NEUTRAL*/ {RuBiomes.HIGHLAND_FIELDS, RuBiomes.HIGHLAND_FIELDS, RuBiomes.DECIDUOUS_FOREST, RuBiomes.TEMPERATE_GROVE, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.REDWOODS, RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE, RuBiomes.STEPPE, RuBiomes.RAINFOREST, RuBiomes.OLD_GROWTH_RAINFOREST, RuBiomes.RAINFOREST}};

    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS, RuBiomes.ICY_HEIGHTS},
            /*COOL*/    {RuBiomes.TOWERING_CLIFFS, RuBiomes.TOWERING_CLIFFS, RuBiomes.TOWERING_CLIFFS, RuBiomes.TOWERING_CLIFFS, RuBiomes.TOWERING_CLIFFS},
            /*NEUTRAL*/ {RuBiomes.LUSH_HILLS, RuBiomes.LUSH_HILLS, RuBiomes.LUSH_HILLS, RuBiomes.LUSH_HILLS, RuBiomes.LUSH_HILLS},
            /*WARM*/    {RuBiomes.PRAIRIE, RuBiomes.PRAIRIE, RuBiomes.DECIDUOUS_FOREST, RuBiomes.REDWOODS, RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.BAOBAB_SAVANNA, RuBiomes.BAOBAB_SAVANNA, RuBiomes.SAGUARO_DESERT, RuBiomes.SAGUARO_DESERT, RuBiomes.OLD_GROWTH_RAINFOREST}};

    private final ResourceKey<Biome>[][] RIVER_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER},
            /*NEUTRAL*/ {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER},
            /*HOT*/     {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER}};

    private final ResourceKey<Biome>[][] RIVER_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER},
            /*NEUTRAL*/ {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.BLACKWOOD_FOREST},
            /*WARM*/    {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER},
            /*HOT*/     {RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER, RuBiomes.MUDDY_RIVER}};

    protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
            this.addOffCoastBiomes(builder);
            this.addInlandBiomes(builder);
            this.addUndergroundBiomes(builder);
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
        this.addSurfaceBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.SMOULDERING_WOODLAND) ? RuBiomes.SMOULDERING_WOODLAND :Biomes.MUSHROOM_FIELDS);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];
            this.addSurfaceBiome(builder, climate$parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.VANILLA_OCEANS[0][i]);
            this.addSurfaceBiome(builder, climate$parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.VANILLA_OCEANS[1][i]);
        }

    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
        this.addMidSlice(builder, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(builder, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(builder, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(builder, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(builder, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(builder, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(builder, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(builder, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(builder, Climate.Parameter.span(0.26666668F, 0.4F));
        this.addHighSlice(builder, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(builder, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(builder, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(builder, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrArid = this.pickMiddleBiomeOrAridIfHot(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrAridOrCold = this.pickMiddleBiomeOrAridIfHotOrSlopeIfCold(i, j, weirdness);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(i, j, weirdness);
                ResourceKey<Biome> shatteredBiome = this.pickShatteredBiome(i, j, weirdness);
                ResourceKey<Biome> maybePickToweringCliffs = this.maybePickToweringCliffsBiome(i, j, weirdness, shatteredBiome);
                ResourceKey<Biome> peakBiomes = this.pickPeakBiome(i, j, weirdness);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, peakBiomes);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], weirdness, 0.0F, middleBiomeOrAridOrCold);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, peakBiomes);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, maybePickToweringCliffs);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiome);
            }
        }

    }

    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrArid = this.pickMiddleBiomeOrAridIfHot(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrAridOrCold = this.pickMiddleBiomeOrAridIfHotOrSlopeIfCold(i, j, weirdness);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(i, j, weirdness);
                ResourceKey<Biome> shatteredBiome = this.pickShatteredBiome(i, j, weirdness);
                ResourceKey<Biome> maybePickToweringCliffs = this.maybePickToweringCliffsBiome(i, j, weirdness, middleBiome);
                ResourceKey<Biome> slopeBiome = this.pickSlopeBiome(i, j, weirdness);
                ResourceKey<Biome> peakBiome = this.pickPeakBiome(i, j, weirdness);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], weirdness, 0.0F, slopeBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, peakBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], weirdness, 0.0F, middleBiomeOrAridOrCold);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, slopeBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, maybePickToweringCliffs);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiome);
            }
        }

    }

    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
        ResourceKey<Biome> chalkCliffs = CheckBiomeConfig.isBiomeEnabled(RuBiomes.CHALK_CLIFFS) ? RuBiomes.CHALK_CLIFFS : Biomes.STONY_SHORE;
        this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[0], this.temperatures[2]), this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
        this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, chalkCliffs);
        //SWAMP_REPLACE
        ResourceKey<Biome> bayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.BAYOU) ? RuBiomes.BAYOU : Biomes.SWAMP;
        ResourceKey<Biome> giantBayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.GIANT_BAYOU) ? RuBiomes.GIANT_BAYOU : Biomes.SWAMP;
        this.addSurfaceBiome(builder, this.temperatures[1], this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FEN) ? RuBiomes.FEN : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[2], this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, weirdness.max() < 0L ? giantBayouBiome : bayouBiome);
        //MANGROVE_REPLACE
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[3], this.humidities[4]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[0], this.humidities[2]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FLOODED_PLAINS) ? RuBiomes.FLOODED_PLAINS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], this.humidities[4], Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], Climate.Parameter.span(this.humidities[0], this.humidities[3]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.DRY_BUSHLAND) ? RuBiomes.DRY_BUSHLAND : Biomes.SWAMP);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrArid = this.pickMiddleBiomeOrAridIfHot(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrAridOrCold = this.pickMiddleBiomeOrAridIfHotOrSlopeIfCold(i, j, weirdness);
                ResourceKey<Biome> plateauBiome = this.pickPlateauBiome(i, j, weirdness);
                ResourceKey<Biome> shatteredBiome = this.pickShatteredBiome(i, j, weirdness);
                ResourceKey<Biome> beachBiome = this.pickBeachBiome(i, j);
                ResourceKey<Biome> maybePickToweringCliffs = this.maybePickToweringCliffsBiome(i, j, weirdness, middleBiome);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(i, j, weirdness);
                ResourceKey<Biome> slopeBiome = this.pickSlopeBiome(i, j, weirdness);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, slopeBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, middleBiomeOrAridOrCold);
                this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, i == 0 ? slopeBiome : plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, plateauBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, middleBiomeOrArid);
                if (weirdness.max() < 0L) {
                    this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, beachBiome);
                    this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiome);
                } else {
                    this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiome);
                }

                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, maybePickToweringCliffs);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, shatteredBiome);
                if (weirdness.max() < 0L) {
                    this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, beachBiome);
                } else {
                    this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, middleBiome);
                }

                if (i == 0) {
                    this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiome);
                }
            }
        }

    }

    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
        ResourceKey<Biome> chalkCliffs = CheckBiomeConfig.isBiomeEnabled(RuBiomes.CHALK_CLIFFS) ? RuBiomes.CHALK_CLIFFS : Biomes.STONY_SHORE;
        this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[0], this.temperatures[2]), this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, Biomes.STONY_SHORE);
        this.addSurfaceBiome(builder, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, chalkCliffs);
        //SWAMP_REPLACE
        ResourceKey<Biome> bayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.BAYOU) ? RuBiomes.BAYOU : Biomes.SWAMP;
        ResourceKey<Biome> giantBayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.GIANT_BAYOU) ? RuBiomes.GIANT_BAYOU : Biomes.SWAMP;
        this.addSurfaceBiome(builder, this.temperatures[1], this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FEN) ? RuBiomes.FEN : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[2], this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, weirdness.max() < 0L ? giantBayouBiome : bayouBiome);
        //MANGROVE_REPLACE
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[3], this.humidities[4]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[0], this.humidities[2]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FLOODED_PLAINS) ? RuBiomes.FLOODED_PLAINS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], this.humidities[4], Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], Climate.Parameter.span(this.humidities[0], this.humidities[3]), Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.DRY_BUSHLAND) ? RuBiomes.DRY_BUSHLAND : Biomes.SWAMP);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiome = this.pickMiddleBiome(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrArid = this.pickMiddleBiomeOrAridIfHot(i, j, weirdness);
                ResourceKey<Biome> middleBiomeOrAridOrCold = this.pickMiddleBiomeOrAridIfHotOrSlopeIfCold(i, j, weirdness);
                ResourceKey<Biome> beachBiome = this.pickBeachBiome(i, j);
                ResourceKey<Biome> maybePickToweringCliffs = this.maybePickToweringCliffsBiome(i, j, weirdness, middleBiome);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(i, j, weirdness);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeOrAridOrCold);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, beachBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, maybePickToweringCliffs);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, middleBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, beachBiome);
                if (i == 0) {
                    this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiome);
                }
            }
        }

    }

    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter weirdness) {
        ResourceKey<Biome> chalkCliffs = CheckBiomeConfig.isBiomeEnabled(RuBiomes.CHALK_CLIFFS) ? RuBiomes.CHALK_CLIFFS : Biomes.STONY_SHORE;
        //SWAMP_REPLACE
        ResourceKey<Biome> bayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.BAYOU) ? RuBiomes.BAYOU : Biomes.SWAMP;
        ResourceKey<Biome> giantBayouBiome = CheckBiomeConfig.isBiomeEnabled(RuBiomes.GIANT_BAYOU) ? RuBiomes.GIANT_BAYOU : Biomes.SWAMP;
        this.addSurfaceBiome(builder, this.temperatures[1], this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FEN) ? RuBiomes.FEN : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[2], this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, weirdness.max() < 0L ? giantBayouBiome : bayouBiome);
        //MANGROVE_REPLACE
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[3], this.humidities[4]), Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[3], Climate.Parameter.span(this.humidities[0], this.humidities[2]), Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.FLOODED_PLAINS) ? RuBiomes.FLOODED_PLAINS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], this.humidities[4], Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.TROPICS) ? RuBiomes.TROPICS : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.temperatures[4], Climate.Parameter.span(this.humidities[0], this.humidities[3]), Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.DRY_BUSHLAND) ? RuBiomes.DRY_BUSHLAND : Biomes.SWAMP);
        this.addSurfaceBiome(builder, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, Biomes.FROZEN_RIVER);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiomeOrArid = this.pickMiddleBiomeOrAridIfHot(i, j, weirdness);
                ResourceKey<Biome> riverBiome = this.pickRiverBiome(i, j, weirdness);
                ResourceKey<Biome> cliffBiome = this.temperatures[i].max() <= -0.45F ? Biomes.STONY_SHORE: chalkCliffs;
                ResourceKey<Biome> maybePickCliff = weirdness.max() < 0L ? cliffBiome : riverBiome;
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeOrArid);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, maybePickCliff);
                this.addSurfaceBiome(builder, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, riverBiome);
                this.addSurfaceBiome(builder, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, riverBiome);
                this.addSurfaceBiome(builder, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, riverBiome);
            }
        }

    }

    private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder) {
        this.addUndergroundBiome(builder, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-1.0F, -0.79F), this.FULL_RANGE, Climate.Parameter.span(-1.0F, 0.0F), 0.0F, Biomes.DRIPSTONE_CAVES);
        this.addUndergroundBiome(builder, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-1.0F, -0.79F), this.FULL_RANGE, Climate.Parameter.span(0.0F, 1.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.REDSTONE_CAVES) ? RuBiomes.REDSTONE_CAVES : Biomes.DRIPSTONE_CAVES);

        this.addUndergroundBiome(builder, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.775F, 1.0F), this.FULL_RANGE, Climate.Parameter.span(-1.0F, 0.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.PRISMACHASM) ? RuBiomes.PRISMACHASM : Biomes.DRIPSTONE_CAVES);
        this.addUndergroundBiome(builder, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.775F, 1.0F), this.FULL_RANGE, Climate.Parameter.span(0.0F, 1.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.REDSTONE_CAVES) ? RuBiomes.REDSTONE_CAVES : Biomes.DRIPSTONE_CAVES);

        this.addUndergroundBiome(builder, this.FULL_RANGE, Climate.Parameter.span(-1.0F, -0.69F), this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-1.0F, 0.0F), 0.0F, Biomes.LUSH_CAVES);
        this.addUndergroundBiome(builder, this.FULL_RANGE, Climate.Parameter.span(-1.0F, -0.69F), this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.0F, 1.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.LUSH_DELTA) ? RuBiomes.LUSH_DELTA : Biomes.LUSH_CAVES);

        this.addUndergroundBiome(builder, this.FULL_RANGE, Climate.Parameter.span(0.65F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-1.0F, 0.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.BIOSHROOM_CAVES) ? RuBiomes.BIOSHROOM_CAVES : Biomes.LUSH_CAVES);
        this.addUndergroundBiome(builder, this.FULL_RANGE, Climate.Parameter.span(0.65F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.0F, 1.0F), 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.LUSH_DELTA) ? RuBiomes.LUSH_DELTA : Biomes.LUSH_CAVES);

        this.addBottomBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
        this.addBottomBiome(builder, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[2], this.erosions[3]), this.FULL_RANGE, 0.0F, CheckBiomeConfig.isBiomeEnabled(RuBiomes.SCORCHING_CAVES) ? RuBiomes.SCORCHING_CAVES : Biomes.LUSH_CAVES);
    }

    private ResourceKey<Biome> pickMiddleBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        if (weirdness.max() < 0L) {
            if(CheckBiomeConfig.isBiomeEnabled(this.MIDDLE_BIOMES[temperature][humidity])){
                return this.MIDDLE_BIOMES[temperature][humidity];
            }
            else{
                return this.VANILLA_MIDDLE_BIOMES[temperature][humidity];
            }
        } else {
            if(this.MIDDLE_BIOMES_VARIANT[temperature][humidity]==null){
                if(CheckBiomeConfig.isBiomeEnabled(this.MIDDLE_BIOMES[temperature][humidity])){
                    return this.MIDDLE_BIOMES[temperature][humidity];
                }
                else{
                    return this.VANILLA_MIDDLE_BIOMES[temperature][humidity];
                }
            }
            else{
                if(CheckBiomeConfig.isBiomeEnabled(this.MIDDLE_BIOMES_VARIANT[temperature][humidity])){
                    return this.MIDDLE_BIOMES_VARIANT[temperature][humidity];
                }
                else{
                    return this.VANILLA_MIDDLE_BIOMES_VARIANT[temperature][humidity];
                }
            }
        }
    }

    private ResourceKey<Biome> pickMiddleBiomeOrAridIfHot(int temperature, int humidity, Climate.Parameter weirdness) {
        return temperature == 4 ? this.pickBadlandsBiome(humidity, weirdness) : this.pickMiddleBiome(temperature, humidity, weirdness);
    }

    private ResourceKey<Biome> pickMiddleBiomeOrAridIfHotOrSlopeIfCold(int temperature, int humidity, Climate.Parameter weirdness) {
        return temperature == 0 ? this.pickSlopeBiome(temperature, humidity, weirdness) : this.pickMiddleBiomeOrAridIfHot(temperature, humidity, weirdness);
    }

    private ResourceKey<Biome> maybePickToweringCliffsBiome(int temperature, int humidity, Climate.Parameter weirdness, ResourceKey<Biome> fallbackBiome) {
        ResourceKey<Biome> resourceKey = CheckBiomeConfig.isBiomeEnabled(RuBiomes.TOWERING_CLIFFS) ? RuBiomes.TOWERING_CLIFFS : Biomes.WINDSWEPT_SAVANNA;
        return temperature > 1 && humidity < 4 && weirdness.max() >= 0L ? resourceKey : fallbackBiome;
    }

    private ResourceKey<Biome> pickShatteredCoastBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> resourceKey = weirdness.max() >= 0L ? this.pickMiddleBiome(temperature, humidity, weirdness) : this.pickBeachBiome(temperature, humidity);
        return this.maybePickToweringCliffsBiome(temperature, humidity, weirdness, resourceKey);
    }

    private ResourceKey<Biome> pickBeachBiome(int temperature, int humidity) {
        if (temperature <= 1) {
            return CheckBiomeConfig.isBiomeEnabled(RuBiomes.GRAVEL_BEACH) ? RuBiomes.GRAVEL_BEACH : Biomes.BEACH;
        }
        else if(temperature == 4){
            return Biomes.BEACH;
        }
        else {
            return CheckBiomeConfig.isBiomeEnabled(RuBiomes.GRASSY_BEACH) ? RuBiomes.GRASSY_BEACH : Biomes.BEACH;
        }
    }

    private ResourceKey<Biome> pickBadlandsBiome(int humidity, Climate.Parameter weirdness) {
        if (humidity < 2) {
            if(weirdness.max() < 0L){
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.ARID_MOUNTAINS) ? RuBiomes.ARID_MOUNTAINS : Biomes.BADLANDS;
            }
            else{
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.ARID_MOUNTAINS) ? RuBiomes.ARID_MOUNTAINS : Biomes.ERODED_BADLANDS;
            }
        } else {
            if(humidity < 3){
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.ARID_MOUNTAINS) ? RuBiomes.ARID_MOUNTAINS : Biomes.BADLANDS;
            }
            else{
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.ARID_MOUNTAINS) ? RuBiomes.ARID_MOUNTAINS : Biomes.WOODED_BADLANDS;
            }
        }
    }

    private ResourceKey<Biome> pickPlateauBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        if (weirdness.max() < 0L) {
            if(CheckBiomeConfig.isBiomeEnabled(this.PLATEAU_BIOMES[temperature][humidity])){
                return this.PLATEAU_BIOMES[temperature][humidity];
            }
            else{
                return this.VANILLA_PLATEAU_BIOMES[temperature][humidity];
            }
        } else {
            if(this.PLATEAU_BIOMES_VARIANT[temperature][humidity]==null){
                if(CheckBiomeConfig.isBiomeEnabled(this.PLATEAU_BIOMES[temperature][humidity])){
                    return this.PLATEAU_BIOMES[temperature][humidity];
                }
                else{
                    return this.VANILLA_PLATEAU_BIOMES[temperature][humidity];
                }
            }
            else{
                if(CheckBiomeConfig.isBiomeEnabled(this.PLATEAU_BIOMES_VARIANT[temperature][humidity])){
                    return this.PLATEAU_BIOMES_VARIANT[temperature][humidity];
                }
                else{
                    return this.VANILLA_PLATEAU_BIOMES_VARIANT[temperature][humidity];
                }
            }
        }
    }

    private ResourceKey<Biome> pickPeakBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        if (temperature < 1) {
            return weirdness.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
        }
        else if (temperature == 1) {
            if(humidity < 3){
                return weirdness.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
            }
            else{
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.MOUNTAINS) ? RuBiomes.MOUNTAINS : Biomes.JAGGED_PEAKS;
            }
        }
        else if (temperature > 1 && temperature < 3) {
            return CheckBiomeConfig.isBiomeEnabled(RuBiomes.MOUNTAINS) ? RuBiomes.MOUNTAINS : Biomes.JAGGED_PEAKS;
        }
        else {
            return temperature == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(humidity, weirdness);
        }
    }

    private ResourceKey<Biome> pickSlopeBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> coldDeciduousForest = CheckBiomeConfig.isBiomeEnabled(RuBiomes.COLD_DECIDUOUS_FOREST) ? RuBiomes.COLD_DECIDUOUS_FOREST : Biomes.GROVE;
        ResourceKey<Biome> icyDesert = CheckBiomeConfig.isBiomeEnabled(RuBiomes.ICY_DESERT) ? RuBiomes.ICY_DESERT : Biomes.SNOWY_SLOPES;
        if (temperature >= 3) {
            return this.pickPlateauBiome(temperature, humidity, weirdness);
        }
        else if(temperature < 1){

            return humidity <= 1 ? icyDesert : coldDeciduousForest;
        }
        else if(temperature ==1){
            if(humidity < 3){
                return weirdness.max() < 0L ? Biomes.GROVE : Biomes.SNOWY_SLOPES;
            }
            else{
                return CheckBiomeConfig.isBiomeEnabled(RuBiomes.PINE_SLOPES) ? RuBiomes.PINE_SLOPES: Biomes.GROVE;
            }
        }
        else {
            return CheckBiomeConfig.isBiomeEnabled(RuBiomes.PINE_SLOPES) ? RuBiomes.PINE_SLOPES: Biomes.GROVE;
        }
    }

    private ResourceKey<Biome> pickShatteredBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> resourceKey = CheckBiomeConfig.isBiomeEnabled(this.SHATTERED_BIOMES[temperature][humidity]) ? this.SHATTERED_BIOMES[temperature][humidity] : this.VANILLA_SHATTERED_BIOMES[temperature][humidity];
        return resourceKey == null ? this.pickMiddleBiome(temperature, humidity, weirdness) : resourceKey;
    }

    private ResourceKey<Biome> pickRiverBiome(int temperature, int humidity, Climate.Parameter weirdness) {
        if (weirdness.max() < 0L) {
            if(CheckBiomeConfig.isBiomeEnabled(this.RIVER_BIOMES[temperature][humidity])){
                return this.RIVER_BIOMES[temperature][humidity];
            }
            else{
                return this.VANILLA_RIVER_BIOMES[temperature][humidity];
            }
        } else {
            if(this.RIVER_BIOMES_VARIANT[temperature][humidity]==null){
                if(CheckBiomeConfig.isBiomeEnabled(this.RIVER_BIOMES[temperature][humidity])){
                    return this.RIVER_BIOMES[temperature][humidity];
                }
                else{
                    return this.VANILLA_RIVER_BIOMES[temperature][humidity];
                }
            }
            else{
                if(CheckBiomeConfig.isBiomeEnabled(this.RIVER_BIOMES_VARIANT[temperature][humidity])){
                    return this.RIVER_BIOMES_VARIANT[temperature][humidity];
                }
                else{
                    return this.VANILLA_RIVER_BIOMES_VARIANT[temperature][humidity];
                }
            }
        }
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
    }

    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), weirdness, offset), biome));
    }

    private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.1F), weirdness, offset), biome));
    }
}
