package net.regions_unexplored.data.worldgen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.config.RegionsUnexploredCommonConfigs;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.data.worldgen.noise.RuNoises;
import net.regions_unexplored.data.worldgen.noise.RuleWeight;

public class RuSurfaceRuleData
{
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource GRANITE = makeStateRule(Blocks.GRANITE);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(RegionsUnexploredBlocks.FOREST_MUD.get());
    private static final SurfaceRules.RuleSource MOSSY_STONE = makeStateRule(RegionsUnexploredBlocks.MOSSY_STONE.get());
    private static final SurfaceRules.RuleSource VANILLA_MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource ASH = makeStateRule(RegionsUnexploredBlocks.ASH.get());
    private static final SurfaceRules.RuleSource VIRIDESCENT_NYLIUM = makeStateRule(RegionsUnexploredBlocks.VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_VIRIDESCENT_NYLIUM = makeStateRule(RegionsUnexploredBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource PRISMOSS = makeStateRule(RegionsUnexploredBlocks.PRISMOSS.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_PRISMOSS = makeStateRule(RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get());
    private static final SurfaceRules.RuleSource FOREST_GRASS_BLOCK = makeStateRule(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource FOREST_DIRT = makeStateRule(RegionsUnexploredBlocks.FOREST_DIRT.get());
    private static final SurfaceRules.RuleSource FOREST_COARSE_DIRT = makeStateRule(RegionsUnexploredBlocks.FOREST_COARSE_DIRT.get());
    private static final SurfaceRules.RuleSource PLAINS_GRASS_BLOCK = makeStateRule(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource PLAINS_DIRT = makeStateRule(RegionsUnexploredBlocks.PLAINS_DIRT.get());
    private static final SurfaceRules.RuleSource PLAINS_COARSE_DIRT = makeStateRule(RegionsUnexploredBlocks.PLAINS_COARSE_DIRT.get());
    private static final SurfaceRules.RuleSource ALPHA_GRASS = makeStateRule(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ALPHA_DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource CHALK_GRASS_BLOCK = makeStateRule(RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource CHALK = makeStateRule(RegionsUnexploredBlocks.CHALK.get());
    private static final SurfaceRules.RuleSource RAW_REDSTONE = makeStateRule(RegionsUnexploredBlocks.RAW_REDSTONE_BLOCK.get());
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        if(RegionsUnexploredCommonConfigs.TOGGLE_CUSTOM_DIRTS.get()){
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT, RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES, RuBiomes.FROZEN_FOREST), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), POWDER_SNOW)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_FOREST),SNOW_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDWOODS), PODZOL),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PINE_SLOPES), COARSE_DIRT),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SAND),

                            //PUMPKIN_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PUMPKIN_FIELDS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.5D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), PODZOL))),

                            //PODZOL/COARSE_DIRT SURFACE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DECIDUOUS_FOREST, RuBiomes.RAINFOREST, RuBiomes.PINE_FOREST, RuBiomes.OLD_GROWTH_RAINFOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),

                            //ICY_DESERT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SNOW_BLOCK), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), PACKED_ICE)), GRAVEL)),

                            //OUTBACK
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.OUTBACK),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(20)), TERRACOTTA), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(60)), RED_SAND))),

                            //SMOULDERING_WOODLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SMOULDERING_WOODLAND),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), FOREST_GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), FOREST_COARSE_DIRT), ASH)),

                            //FUNGAL_FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FUNGAL_FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), MYCELIUM), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.1D), MYCELIUM)))),

                            //FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.0D), WATER))), SurfaceRules.ifTrue(surfaceNoiseAbove(1.1D), COARSE_DIRT))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SAND),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAYOU),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GIANT_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), VANILLA_MUD), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), VANILLA_MUD))),

                            //POPPY_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.POPPY_FIELDS),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(50)), COARSE_DIRT)),

                            //FROZEN_TUNDRA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_TUNDRA),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SNOW_BLOCK)),

                            //WILLOW_FOREST
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.WILLOW_FOREST),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), STONE)),

                            //DRY_BUSHLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DRY_BUSHLAND),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(40)), PLAINS_COARSE_DIRT)),

                            //BAOBAB_SAVANNA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), TERRACOTTA), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //TOWERING_CLIFFS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), COBBLESTONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), GRAVEL),STONE)), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),COBBLESTONE)))),

                            //MAPLE_FOREST
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), STONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE),STONE)), SurfaceRules.ifTrue(shieldNoise(0.0D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),MOSSY_STONE)))),

                            //LUSH_HILLS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //JOSHUA_DESERT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)),

                            //ALPHA_GROVE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), ALPHA_GRASS), SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0), AIR))),

                            //ARID_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ARID_MOUNTAINS),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1)), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.45D), GRASS_BLOCK), TERRACOTTA))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),COARSE_DIRT),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.05D),COARSE_DIRT)))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKWOOD_FOREST, RuBiomes.BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST), FOREST_GRASS_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), PLAINS_GRASS_BLOCK)
                    )))),

                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),PACKED_ICE))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GRAVEL_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.CHALK_CLIFFS), SurfaceRules.sequence(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),CHALK_GRASS_BLOCK), CHALK)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),CHALK)))),

                            //BAOBAB_SAVANNA BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfaceNoiseAbove(1.75D)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),TERRACOTTA))),

                            //LUSH_HILLS/CLIFFS BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS, RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ALPHA_GROVE BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),ALPHA_DIRT)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL))),

                            //JOSHUA_DESERT BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GIANT_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),VANILLA_MUD)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), VANILLA_MUD))))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SAND)))),

                            //MIXED_FOREST BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.WILLOW_FOREST),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.05D),
                                                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT))),
                                            SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(186), 0),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SNOW_BLOCK)))),

                            //ARID_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ARID_MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR), SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1)), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.45D), DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR), TERRACOTTA))),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b1", VerticalAnchor.absolute(76), VerticalAnchor.absolute(76)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b2", VerticalAnchor.absolute(79), VerticalAnchor.absolute(79)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b3", VerticalAnchor.absolute(80), VerticalAnchor.absolute(80)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b4", VerticalAnchor.absolute(81), VerticalAnchor.absolute(81)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b5", VerticalAnchor.absolute(82), VerticalAnchor.absolute(82)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b6", VerticalAnchor.absolute(87), VerticalAnchor.absolute(87)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b7", VerticalAnchor.absolute(94), VerticalAnchor.absolute(94)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b8", VerticalAnchor.absolute(96), VerticalAnchor.absolute(96)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b9", VerticalAnchor.absolute(98), VerticalAnchor.absolute(98)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b11", VerticalAnchor.absolute(109), VerticalAnchor.absolute(109)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b12", VerticalAnchor.absolute(115), VerticalAnchor.absolute(115)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b13", VerticalAnchor.absolute(118), VerticalAnchor.absolute(118)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b14", VerticalAnchor.absolute(119), VerticalAnchor.absolute(119)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b15", VerticalAnchor.absolute(123), VerticalAnchor.absolute(123)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b16", VerticalAnchor.absolute(128), VerticalAnchor.absolute(128)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b17", VerticalAnchor.absolute(131), VerticalAnchor.absolute(131)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b18", VerticalAnchor.absolute(134), VerticalAnchor.absolute(134)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b19", VerticalAnchor.absolute(137), VerticalAnchor.absolute(137)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b20", VerticalAnchor.absolute(139), VerticalAnchor.absolute(139)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b21", VerticalAnchor.absolute(142), VerticalAnchor.absolute(142)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b22", VerticalAnchor.absolute(148), VerticalAnchor.absolute(148)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b23", VerticalAnchor.absolute(153), VerticalAnchor.absolute(153)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b24", VerticalAnchor.absolute(159), VerticalAnchor.absolute(159)), COARSE_DIRT),
                                    TERRACOTTA))),

                            //CANADIAN/MAPLE_FOREST_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ICY_DESERT_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)),

                            //DEFAULT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKWOOD_FOREST, RuBiomes.SMOULDERING_WOODLAND, RuBiomes.BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),FOREST_DIRT)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),PLAINS_DIRT)),
                            SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),GRASS_BLOCK), DIRT)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT))
                    )),
                    //REDSTONE_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDSTONE_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(40)),RAW_REDSTONE)))),

                    //BIOSHROOM_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BIOSHROOM_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bioshroom_caves_nylium", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), DEEPSLATE_VIRIDESCENT_NYLIUM), VIRIDESCENT_NYLIUM)))),

                    //PRISMACHASM
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PRISMACHASM),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("prismachasm_prismoss", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), DEEPSLATE_PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), DEEPSLATE_PRISMOSS))), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), PRISMOSS)))))),

                    //BEDROCK
                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK)
            );}
        else{
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT, RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES, RuBiomes.FROZEN_FOREST), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), POWDER_SNOW)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_FOREST),SNOW_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDWOODS), PODZOL),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PINE_SLOPES), COARSE_DIRT),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SAND),

                            //PUMPKIN_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PUMPKIN_FIELDS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.5D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), PODZOL))),

                            //PODZOL/COARSE_DIRT SURFACE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DECIDUOUS_FOREST, RuBiomes.RAINFOREST, RuBiomes.PINE_FOREST, RuBiomes.OLD_GROWTH_RAINFOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),

                            //ICY_DESERT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SNOW_BLOCK), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), PACKED_ICE)), GRAVEL)),

                            //OUTBACK
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.OUTBACK),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(20)), TERRACOTTA), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(60)), RED_SAND))),

                            //SMOULDERING_WOODLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SMOULDERING_WOODLAND),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT), ASH)),

                            //FUNGAL_FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FUNGAL_FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), MYCELIUM), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.1D), MYCELIUM)))),

                            //FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.0D), WATER))), SurfaceRules.ifTrue(surfaceNoiseAbove(1.1D), COARSE_DIRT))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SAND),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAYOU),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GIANT_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), VANILLA_MUD), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), VANILLA_MUD))),

                            //POPPY_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.POPPY_FIELDS),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(50)), COARSE_DIRT)),

                            //FROZEN_TUNDRA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_TUNDRA),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SNOW_BLOCK)),

                            //WILLOW_FOREST
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.WILLOW_FOREST),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), STONE)),

                            //DRY_BUSHLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DRY_BUSHLAND),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(40)), COARSE_DIRT)),

                            //BAOBAB_SAVANNA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), TERRACOTTA), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //TOWERING_CLIFFS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), COBBLESTONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), GRAVEL),STONE)), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),COBBLESTONE)))),

                            //MAPLE_FOREST
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), STONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE),STONE)), SurfaceRules.ifTrue(shieldNoise(0.0D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),MOSSY_STONE)))),

                            //LUSH_HILLS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //JOSHUA_DESERT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)),

                            //ALPHA_GROVE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), ALPHA_GRASS), SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0), AIR))),

                            //ARID_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ARID_MOUNTAINS),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1)), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.45D), GRASS_BLOCK), TERRACOTTA))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),COARSE_DIRT),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.05D),COARSE_DIRT)))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKWOOD_FOREST, RuBiomes.BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST), GRASS_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), GRASS_BLOCK)
                    )))),

                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),PACKED_ICE))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GRAVEL_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.CHALK_CLIFFS), SurfaceRules.sequence(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),CHALK_GRASS_BLOCK), CHALK)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),CHALK)))),

                            //BAOBAB_SAVANNA BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfaceNoiseAbove(1.75D)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),TERRACOTTA))),

                            //LUSH_HILLS/CLIFFS BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS, RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ALPHA_GROVE BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),ALPHA_DIRT)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL))),

                            //JOSHUA_DESERT BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GIANT_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),VANILLA_MUD)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), VANILLA_MUD))))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SAND)))),

                            //MIXED_FOREST BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.WILLOW_FOREST),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), 0.05D),
                                                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT))),
                                            SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(186), 0),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SNOW_BLOCK)))),

                            //ARID_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ARID_MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR), SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1)), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.45D), DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR), TERRACOTTA))),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b1", VerticalAnchor.absolute(76), VerticalAnchor.absolute(76)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b2", VerticalAnchor.absolute(79), VerticalAnchor.absolute(79)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b3", VerticalAnchor.absolute(80), VerticalAnchor.absolute(80)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b4", VerticalAnchor.absolute(81), VerticalAnchor.absolute(81)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b5", VerticalAnchor.absolute(82), VerticalAnchor.absolute(82)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b6", VerticalAnchor.absolute(87), VerticalAnchor.absolute(87)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b7", VerticalAnchor.absolute(94), VerticalAnchor.absolute(94)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b8", VerticalAnchor.absolute(96), VerticalAnchor.absolute(96)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b9", VerticalAnchor.absolute(98), VerticalAnchor.absolute(98)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b11", VerticalAnchor.absolute(109), VerticalAnchor.absolute(109)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b12", VerticalAnchor.absolute(115), VerticalAnchor.absolute(115)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b13", VerticalAnchor.absolute(118), VerticalAnchor.absolute(118)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b14", VerticalAnchor.absolute(119), VerticalAnchor.absolute(119)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b15", VerticalAnchor.absolute(123), VerticalAnchor.absolute(123)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b16", VerticalAnchor.absolute(128), VerticalAnchor.absolute(128)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b17", VerticalAnchor.absolute(131), VerticalAnchor.absolute(131)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b18", VerticalAnchor.absolute(134), VerticalAnchor.absolute(134)), CALCITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b19", VerticalAnchor.absolute(137), VerticalAnchor.absolute(137)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b20", VerticalAnchor.absolute(139), VerticalAnchor.absolute(139)), STONE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b21", VerticalAnchor.absolute(142), VerticalAnchor.absolute(142)), COARSE_DIRT),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b22", VerticalAnchor.absolute(148), VerticalAnchor.absolute(148)), GRANITE),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b23", VerticalAnchor.absolute(153), VerticalAnchor.absolute(153)), TERRACOTTA),
                                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("b24", VerticalAnchor.absolute(159), VerticalAnchor.absolute(159)), COARSE_DIRT),
                                    TERRACOTTA))),

                            //MAPLE_FOREST_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ICY_DESERT_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)),

                            //DEFAULT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKWOOD_FOREST, RuBiomes.SMOULDERING_WOODLAND, RuBiomes.BOREAL_FOREST, RuBiomes.COLD_BOREAL_FOREST, RuBiomes.GOLDEN_BOREAL_FOREST), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)),
                            SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),GRASS_BLOCK), DIRT)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT))
                    )),
                    //REDSTONE_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDSTONE_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(40)),RAW_REDSTONE)))),

                    //BIOSHROOM_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BIOSHROOM_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bioshroom_caves_nylium", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), DEEPSLATE_VIRIDESCENT_NYLIUM), VIRIDESCENT_NYLIUM)))),

                    //PRISMACHASM
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PRISMACHASM),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("prismachasm_prismoss", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), DEEPSLATE_PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), DEEPSLATE_PRISMOSS))), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), PRISMOSS)))))),

                    //BEDROCK
                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK)
            );}
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource shieldNoise(double noise) {
        return SurfaceRules.noiseCondition(RuNoises.SHIELD.getKey(), noise / 8.25D, Double.MAX_VALUE);
    }
}