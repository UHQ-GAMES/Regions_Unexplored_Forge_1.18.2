package net.regions_unexplored.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.config.RegionsUnexploredCommonConfigs;
import net.regions_unexplored.world.item.RegionsUnexploredTabs;
import net.regions_unexplored.world.level.block.BranchBlock;

import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RuColors {
    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PRISMARITE_CLUSTER.get(), renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PRISMAGLASS.get(), renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.LARGE_PRISMARITE_CLUSTER.get(), renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.HANGING_PRISMARITE.get(), renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PRISMOSS_SPROUT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CAVE_HYSSOP.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDSTONE_BUD.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDSTONE_BULB.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POINTED_REDSTONE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MEDIUM_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SEEDED_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.STEPPE_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.STEPPE_SHRUB.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.STONE_BUD.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SEEDED_TALL_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_STEPPE_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ELEPHANT_EAR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_STEPPE_SHRUB.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SMALL_DESERT_SHRUB.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SANDY_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SANDY_TALL_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BARREL_CACTUS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CACTUS_FLOWER.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.FROZEN_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLUE_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINK_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PURPLE_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.YELLOW_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.RED_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.HYSSOP.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.FIREWEED.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DAISY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.FELICIA_DAISY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WARATAH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WHITE_TRILLIUM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POPPY_BUSH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ALPHA_DANDELION.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ALPHA_ROSE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WILTING_TRILLIUM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DORCEL.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLUE_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GREEN_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.YELLOW_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINK_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_BLUE_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_GREEN_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_YELLOW_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_PINK_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BARLEY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TASSEL.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TSUBAKI.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SPANISH_MOSS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SPANISH_MOSS_PLANT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DUCKWEED.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CATTAIL.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAMBOO_LOG.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAMBOO_LOG_LEAVES.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JOSHUA_LEAVES.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SCULKWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_SCULKWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SCULK_SPROUT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SCULK_TENDRIL.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MYCOTOXIC_DAISY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MYCOTOXIC_GRASS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GLISTER_SPIRE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GLISTERING_IVY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GLISTERING_IVY_PLANT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GLISTERING_SPROUT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GLISTER_BULB.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.COBALT_ROOTS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.COBALT_EARLIGHT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.HANGING_EARLIGHT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.HANGING_EARLIGHT_PLANT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SCULKWOOD_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SCULKWOOD_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DIRT_PLACEMENT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MUD_PLACEMENT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GRASS_PLACEMENT.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SAND_PLACEMENT.get(), renderType -> renderType == RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_ACACIA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_BAOBAB_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_BIRCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_BLACKWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_CYPRESS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_DARK_OAK_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_DEAD_PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_DEAD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_EUCALYPTUS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_FLOWERING_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_GOLDEN_LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_JOSHUA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_JUNGLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_MAUVE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_OAK_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_ORANGE_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_PALM_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_PINK_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_RED_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_RED_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_REDWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_SILVER_BIRCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_SPRUCE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_WHITE_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.TALL_WILLOW_SAPLING.get(), renderType -> renderType == RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ACACIA_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAOBAB_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BIRCH_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLACKWOOD_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CHERRY_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CYPRESS_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DARK_OAK_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JOSHUA_BEARD.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JUNGLE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.LARCH_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MANGROVE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAPLE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAUVE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.OAK_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PALM_BEARD.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDWOOD_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SPRUCE_BRANCH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WILLOW_BRANCH.get(), renderType -> renderType == RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_WOOD.get(), renderType -> renderType == RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_LOG.get(), renderType -> renderType == RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ALPHA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.APPLE_OAK_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.FLOWERING_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAMBOO_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.SILVER_BIRCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAOBAB_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLACKWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.RED_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINK_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WHITE_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CYPRESS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JOSHUA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.GOLDEN_LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.RED_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ORANGE_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAUVE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PALM_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WILLOW_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PRISMOSS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAOBAB_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BAOBAB_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLACKWOOD_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.BLACKWOOD_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CHERRY_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CHERRY_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CYPRESS_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.CYPRESS_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.DEAD_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.EUCALYPTUS_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JOSHUA_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.JOSHUA_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.LARCH_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.LARCH_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAPLE_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAPLE_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAUVE_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.MAUVE_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINE_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PINE_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDWOOD_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.REDWOOD_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WILLOW_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.WILLOW_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PALM_DOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.PALM_TRAPDOOR.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_CAVE_HYSSOP.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BLUE_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PINK_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PURPLE_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_RED_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_YELLOW_LUPINE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_HYSSOP.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_FIREWEED.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_DAISY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_FELICIA_DAISY.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_WARATAH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_WHITE_TRILLIUM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_ALPHA_ROSE.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_ALPHA_DANDELION.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BARREL_CACTUS.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_POPPY_BUSH.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_WILTING_TRILLIUM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_DORCEL.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_CACTUS_FLOWER.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_GREEN_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BLUE_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PINK_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_YELLOW_BIOSHROOM.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_ALPHA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_APPLE_OAK_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_FLOWERING_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_SILVER_BIRCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BAMBOO_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BAOBAB_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_BLACKWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_RED_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PINK_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_WHITE_CHERRY_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_CYPRESS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_DEAD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_DEAD_PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_EUCALYPTUS_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_JOSHUA_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_GOLDEN_LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_LARCH_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_RED_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_MAUVE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PALM_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_PINE_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_REDWOOD_SAPLING.get(), renderType -> renderType == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegionsUnexploredBlocks.POTTED_WILLOW_SAPLING.get(), renderType -> renderType == RenderType.cutout());
    }
    @SubscribeEvent
    public static void grassBlockColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D);
        },      RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.MEDIUM_GRASS.get(),
                RegionsUnexploredBlocks.STEPPE_GRASS.get(),
                RegionsUnexploredBlocks.STONE_BUD.get(),
                RegionsUnexploredBlocks.SEEDED_TALL_GRASS.get(),
                RegionsUnexploredBlocks.SEEDED_GRASS.get()
        );
    }

    @SubscribeEvent
    public static void grassItemColorLoad(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> {
            return GrassColor.get(0.5D, 1.0D);
        },      RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get(),
                RegionsUnexploredBlocks.MEDIUM_GRASS.get(),
                RegionsUnexploredBlocks.STEPPE_GRASS.get(),
                RegionsUnexploredBlocks.STONE_BUD.get(),
                RegionsUnexploredBlocks.SEEDED_TALL_GRASS.get(),
                RegionsUnexploredBlocks.SEEDED_GRASS.get()
        );
    }

    @SubscribeEvent
    public static void foliageBlockColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.get(0.5D, 1.0D);
        },          RegionsUnexploredBlocks.STEPPE_SHRUB.get(),
                    RegionsUnexploredBlocks.TALL_STEPPE_GRASS.get(),
                    RegionsUnexploredBlocks.ELEPHANT_EAR.get(),
                    RegionsUnexploredBlocks.BAOBAB_LEAVES.get(),
                    RegionsUnexploredBlocks.CHERRY_LEAVES.get(),
                    RegionsUnexploredBlocks.APPLE_OAK_LEAVES.get(),
                    RegionsUnexploredBlocks.FLOWERING_LEAVES.get(),
                    RegionsUnexploredBlocks.CYPRESS_LEAVES.get(),
                    RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get(),
                    RegionsUnexploredBlocks.PALM_LEAVES.get(),
                    RegionsUnexploredBlocks.JOSHUA_LEAVES.get(),
                    RegionsUnexploredBlocks.PINE_LEAVES.get(),
                    RegionsUnexploredBlocks.REDWOOD_LEAVES.get(),
                    RegionsUnexploredBlocks.WILLOW_LEAVES.get(),
                    RegionsUnexploredBlocks.TALL_REDWOOD_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_PINE_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_WILLOW_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_OAK_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_DARK_OAK_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_PALM_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_FLOWERING_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_JOSHUA_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_CHERRY_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_ACACIA_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_JUNGLE_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_EUCALYPTUS_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_CYPRESS_SAPLING.get(),
                    RegionsUnexploredBlocks.TALL_BAOBAB_SAPLING.get()
        );
    }

    @SubscribeEvent
    public static void foliageItemColorLoad(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> {
                return FoliageColor.get(0.5D, 1.0D);
        },          RegionsUnexploredBlocks.STEPPE_SHRUB.get(),
                    RegionsUnexploredBlocks.TALL_STEPPE_GRASS.get(),
                    RegionsUnexploredBlocks.ELEPHANT_EAR.get(),
                    RegionsUnexploredBlocks.BAOBAB_LEAVES.get(),
                    RegionsUnexploredBlocks.CHERRY_LEAVES.get(),
                    RegionsUnexploredBlocks.APPLE_OAK_LEAVES.get(),
                    RegionsUnexploredBlocks.FLOWERING_LEAVES.get(),
                    RegionsUnexploredBlocks.JOSHUA_LEAVES.get(),
                    RegionsUnexploredBlocks.CYPRESS_LEAVES.get(),
                    RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get(),
                    RegionsUnexploredBlocks.PALM_LEAVES.get(),
                    RegionsUnexploredBlocks.PINE_LEAVES.get(),
                    RegionsUnexploredBlocks.REDWOOD_LEAVES.get(),
                    RegionsUnexploredBlocks.WILLOW_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void spruceBlockColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return FoliageColor.getEvergreenColor();
        }, RegionsUnexploredBlocks.TALL_SPRUCE_SAPLING.get());
    }

    @SubscribeEvent
    public static void birchBlockColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return FoliageColor.getBirchColor();
        }, RegionsUnexploredBlocks.TALL_BIRCH_SAPLING.get());
    }

    @SubscribeEvent
    public static void rainbowCrystalColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? getRainbowColor(world, pos) : FoliageColor.getDefaultColor();
        },RegionsUnexploredBlocks.PRISMARITE_CLUSTER.get(), RegionsUnexploredBlocks.LARGE_PRISMARITE_CLUSTER.get(), RegionsUnexploredBlocks.PRISMOSS.get(),RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get(),RegionsUnexploredBlocks.PRISMOSS_SPROUT.get());
    }

    @SubscribeEvent
    public static void rainbowCrystalYColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? getRainbowColor(world, pos) : FoliageColor.getDefaultColor();
        },RegionsUnexploredBlocks.HANGING_PRISMARITE.get());
    }

    @SubscribeEvent
    public static void rainbowGlassColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
            return world != null && pos != null ? getRainbowGlassColor(world, pos) : FoliageColor.getDefaultColor();
        },RegionsUnexploredBlocks.PRISMAGLASS.get());
    }

    @SubscribeEvent
    public static void rainbowEucalyptusColorLoad(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {
                    return world != null && pos != null ? getRainbowEucalyptusColor(world, pos) : FoliageColor.getDefaultColor();
                },      RegionsUnexploredBlocks.EUCALYPTUS_LOG.get(),
                RegionsUnexploredBlocks.EUCALYPTUS_WOOD.get()
        );
    }

    public static int getRainbowColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getZ()) / 50.0F, 1.0F, 1.0F);
        return rainbow.getRGB();
    }

    public static int getRainbowGlassColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) / 35.0F, 1.0F, 1.0F);
        return rainbow.getRGB();
    }

    public static int getRainbowEucalyptusColor(BlockAndTintGetter world, BlockPos pos) {
        Color rainbow = Color.getHSBColor(((float)pos.getX() + (float)pos.getY() + (float)pos.getZ()) /
                        RegionsUnexploredCommonConfigs.EUCALYPTUS_TRANSITION_SIZE.get().floatValue(),
                RegionsUnexploredCommonConfigs.EUCALYPTUS_SATURATION.get().floatValue(),
                RegionsUnexploredCommonConfigs.EUCALYPTUS_BRIGHTNESS.get().floatValue());
        return rainbow.getRGB();
    }

}
