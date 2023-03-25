package net.regions_unexplored.data.worldgen.structures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.regions_unexplored.data.worldgen.structures.biomefix.SpiresFix;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Spires extends Feature<NoneFeatureConfiguration> {
    public static Spires FEATURE = null;
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
    public static Holder<PlacedFeature> PLACED_FEATURE = null;

    public static Feature<?> feature() {
        FEATURE = new Spires();
        CONFIGURED_FEATURE = FeatureUtils.register("regions_unexplored:ice_spires", FEATURE, FeatureConfiguration.NONE);
        PLACED_FEATURE = PlacementUtils.register("regions_unexplored:ice_spires", CONFIGURED_FEATURE, List.of());
        return FEATURE;
    }

    public static Holder<PlacedFeature> placedFeature() {
        return PLACED_FEATURE;
    }

    public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("regions_unexplored:spires"));
    private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);
    private final List<Block> base_blocks;
    private StructureTemplate template = null;

    public Spires() {
        super(NoneFeatureConfiguration.CODEC);
        base_blocks = List.of(Blocks.SNOW_BLOCK);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        if (!generate_dimensions.contains(context.level().getLevel().dimension()))
            return false;
        boolean anyPlaced = false;
        if ((context.random().nextInt(1000000) + 1) <= 1000000) {
            int count = context.random().nextInt(2) + 2;
            for (int a = 0; a < count; a++) {

                Random random = new Random();
                int struct = random.nextInt(5);
                String o1 = "null";
                if(struct==0)o1="spire1";
                else if(struct==1)o1="spire2";
                else if(struct==2)o1="spire3";
                else if(struct==3)o1="spire4";
                else if(struct==4)o1="spire5";

                template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("regions_unexplored", o1));
                int i = context.origin().getX() + context.random().nextInt(16);
                int k = context.origin().getZ() + context.random().nextInt(16);
                int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k) - 1;
                if (!base_blocks.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock()))
                    continue;
                BlockPos spawnTo = new BlockPos(i + -2, j - random.nextInt(4), k + -2);
                WorldGenLevel world = context.level();
                int x = spawnTo.getX();
                int y = spawnTo.getY();
                int z = spawnTo.getZ();
                if (!SpiresFix.execute(world, x, y, z))
                    continue;
                if (template.placeInWorld(
                        context.level(), spawnTo, spawnTo, new StructurePlaceSettings().setMirror(Mirror.NONE).setRotation(Rotation.NONE)
                                .setRandom(context.random()).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR).setIgnoreEntities(false),
                        context.random(), 2)) {
                    anyPlaced = true;
                }
            }
        }
        return anyPlaced;
    }
}
