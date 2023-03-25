package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.data.worldgen.features.feature.*;
import net.regions_unexplored.data.worldgen.features.feature.LavaDeltaFeature;
import net.regions_unexplored.data.worldgen.features.feature.bioshroom.GiantBioshroomConfiguration;
import net.regions_unexplored.data.worldgen.features.feature.bioshroom.GiantBlueBioshroomFeature;
import net.regions_unexplored.data.worldgen.features.feature.bioshroom.GiantGreenBioshroomFeature;
import net.regions_unexplored.data.worldgen.features.feature.bioshroom.PinkBioshroomFeature;
import net.regions_unexplored.data.worldgen.features.feature.redstonefeatures.*;
import net.regions_unexplored.data.worldgen.features.feature.tree.LargeJoshuaTreeFeature;
import net.regions_unexplored.data.worldgen.features.feature.tree.MapleTreeFeature;
import net.regions_unexplored.data.worldgen.features.feature.tree.MediumJoshuaTreeFeature;
import net.regions_unexplored.data.worldgen.features.feature.tree.TallSaplingFeature;
import net.regions_unexplored.data.worldgen.features.feature.tree.config.RuTreeConfiguration;
import net.regions_unexplored.data.worldgen.features.feature.tree.config.TallSaplingConfiguration;
import net.regions_unexplored.data.worldgen.features.treefeature.GiantSculkWillowFeature;
import net.regions_unexplored.data.worldgen.features.treefeature.NetherWillowFeature;
import net.regions_unexplored.data.worldgen.features.treefeature.SculkWillowFeature;
import net.regions_unexplored.data.worldgen.structures.MeadowRock;
import net.regions_unexplored.data.worldgen.structures.Spires;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class RuFeatureRegistry {
    public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, RegionsUnexploredMod.MOD_ID);
    private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
    public static final RegistryObject<Feature<?>> ICE_SPIRES = registerStructure("ice_spires", Spires::feature,
            new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, Spires.GENERATE_BIOMES, Spires::placedFeature));
    public static final RegistryObject<Feature<?>> MEADOW_ROCKS = registerStructure("meadow_rocks", MeadowRock::feature, new FeatureRegistration(
            GenerationStep.Decoration.SURFACE_STRUCTURES, MeadowRock.GENERATE_BIOMES, MeadowRock::placedFeature));

    @SubscribeEvent
    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
            if (registration.biomes() == null || registration.biomes().contains(event.getName()))
                event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
        }
    }

    private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
                                              Supplier<Holder<PlacedFeature>> placedFeature) {
    }


    public static final Feature<GiantBioshroomConfiguration> GIANT_GREEN_BIOSHROOM;
    public static final Feature<GiantBioshroomConfiguration> GIANT_BLUE_BIOSHROOM;

    public static final Feature<RuTreeConfiguration> MAPLE_TREE;

    public static final Feature<NoneFeatureConfiguration> WATER_CATTAIL;
    public static final Feature<TallSaplingConfiguration> TALL_SAPLING;
    //LEGACY
    public static final Feature<NoneFeatureConfiguration> ROCK_PILLAR;
    public static final Feature<NoneFeatureConfiguration> LARGE_JOSHUA_TREE;
    public static final Feature<NoneFeatureConfiguration> MEDIUM_JOSHUA_TREE;
    public static final Feature<NoneFeatureConfiguration> GIANT_PINK_BIOSHROOM;
    public static final Feature<NoneFeatureConfiguration> SCULK_WILLOW;
    public static final Feature<NoneFeatureConfiguration> GIANT_SCULK_WILLOW;
    public static final Feature<BlockStateConfiguration> NETHER_MEADOW_ROCK;
    public static final Feature<NoneFeatureConfiguration> GLISTERING_IVY;
    public static final Feature<NoneFeatureConfiguration> HANGING_EARLIGHT;
    public static final Feature<NoneFeatureConfiguration> OBSIDIAN_SPIRE;
    public static final Feature<NoneFeatureConfiguration> NETHER_WILLOW;
    public static final Feature<NoneFeatureConfiguration> HANGING_PRISMARITE;
    public static final Feature<ColumnFeatureConfiguration> BASALT_BLOB;
    public static final Feature<NoneFeatureConfiguration> ASH_VENT;
    public static final Feature<NoneFeatureConfiguration> LAVA_FALL;
    public static final Feature<VegetationPatchConfiguration> OVERWORLD_LAVA_DELTA;
    public static final Feature<PointedRedstoneConfiguration> POINTED_REDSTONE;
    public static final Feature<LargePointedRedstoneConfiguration> LARGE_POINTED_REDSTONE;
    public static final Feature<PointedRedstoneClusterConfiguration> POINTED_REDSTONE_CLUSTER;

    public RuFeatureRegistry() {

    }
    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String key, F value) {
        value.setRegistryName(new ResourceLocation(RegionsUnexploredMod.MOD_ID, key));
        ForgeRegistries.FEATURES.register(value);
        return value;
    }

    private static RegistryObject<Feature<?>> registerStructure(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
        FEATURE_REGISTRATIONS.add(featureRegistration);
        return REGISTRY.register(registryname, feature);
    }


    static {
        GIANT_GREEN_BIOSHROOM = register("giant_green_bioshroom", new GiantGreenBioshroomFeature(GiantBioshroomConfiguration.CODEC));
        GIANT_BLUE_BIOSHROOM = register("giant_blue_bioshroom", new GiantBlueBioshroomFeature(GiantBioshroomConfiguration.CODEC));

        MAPLE_TREE = register("maple_tree", new MapleTreeFeature(RuTreeConfiguration.CODEC));

        WATER_CATTAIL = register("water_cattail", new WaterCattailFeature(NoneFeatureConfiguration.CODEC));
        TALL_SAPLING = register("tall_sapling", new TallSaplingFeature(TallSaplingConfiguration.CODEC));
        //LEGACY
        ROCK_PILLAR = register("rock_pillar", new RockPillarFeature(NoneFeatureConfiguration.CODEC));
        LARGE_JOSHUA_TREE = register("large_joshua_tree", new LargeJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
        MEDIUM_JOSHUA_TREE = register("medium_joshua_tree", new MediumJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
        GIANT_PINK_BIOSHROOM = register("giant_pink_bioshroom", new PinkBioshroomFeature(NoneFeatureConfiguration.CODEC));
        SCULK_WILLOW = register("sculk_willow", new SculkWillowFeature(NoneFeatureConfiguration.CODEC));
        GIANT_SCULK_WILLOW = register("giant_sculk_willow", new GiantSculkWillowFeature(NoneFeatureConfiguration.CODEC));
        NETHER_MEADOW_ROCK = register("nether_meadow_rock", new NetherBlockBlobFeature(BlockStateConfiguration.CODEC));
        GLISTERING_IVY = register("glistering_ivy", new GlisteringIvyFeature(NoneFeatureConfiguration.CODEC));
        HANGING_EARLIGHT = register("hanging_earlight", new HangingEarlightFeature(NoneFeatureConfiguration.CODEC));
        OBSIDIAN_SPIRE = register("obsidian_spire", new ObsidianSpireFeature(NoneFeatureConfiguration.CODEC));
        NETHER_WILLOW = register("nether_willow", new NetherWillowFeature(NoneFeatureConfiguration.CODEC));
        HANGING_PRISMARITE = register("hanging_prismarite", new HangingPrismariteFeature(NoneFeatureConfiguration.CODEC));
        BASALT_BLOB = register("basalt_blob", new BasaltBlobFeature(ColumnFeatureConfiguration.CODEC));
        ASH_VENT = register("scorch_vent", new AshVentFeature(NoneFeatureConfiguration.CODEC));
        LAVA_FALL = register("lava_fall", new LavaFallFeature(NoneFeatureConfiguration.CODEC));
        OVERWORLD_LAVA_DELTA = register("overworld_lava_delta", new LavaDeltaFeature(VegetationPatchConfiguration.CODEC));
        POINTED_REDSTONE = register("pointed_redstone", new PointedRedstoneFeature(PointedRedstoneConfiguration.CODEC));
        LARGE_POINTED_REDSTONE = register("large_pointed_redstone", new LargePointedRedstoneFeature(LargePointedRedstoneConfiguration.CODEC));
        POINTED_REDSTONE_CLUSTER = register("pointed_redstone_cluster", new PointedRedstoneClusterFeature(PointedRedstoneClusterConfiguration.CODEC));

    }
}