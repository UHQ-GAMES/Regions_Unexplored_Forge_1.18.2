package net.regions_unexplored.init;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class BlockFeatureCompat {

    public static void setup() {
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.ALPHA_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.ALPHA_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BAOBAB_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BAOBAB_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BLACKWOOD_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BLACKWOOD_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CHERRY_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CHERRY_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.RED_CHERRY_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.RED_CHERRY_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PINK_CHERRY_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PINK_CHERRY_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.WHITE_CHERRY_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.WHITE_CHERRY_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CYPRESS_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CYPRESS_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DEAD_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DEAD_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.EUCALYPTUS_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.JOSHUA_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.JOSHUA_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.LARCH_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.LARCH_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.GOLDEN_LARCH_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.GOLDEN_LARCH_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MAPLE_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MAPLE_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.RED_MAPLE_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.RED_MAPLE_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.ORANGE_MAPLE_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.ORANGE_MAPLE_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PALM_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PALM_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PINE_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PINE_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DEAD_PINE_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DEAD_PINE_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.REDWOOD_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.REDWOOD_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.SCULKWOOD_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.WILLOW_SAPLING.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.WILLOW_LEAVES.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CACTUS_FLOWER.get());
        registerCompostableItems(0.1F, RegionsUnexploredBlocks.DUCKWEED.get());

        registerCompostableItems(0.3F, RegionsUnexploredBlocks.ACACIA_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BAOBAB_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BIRCH_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.BLACKWOOD_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CHERRY_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.CYPRESS_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DEAD_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.DARK_OAK_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.EUCALYPTUS_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.JUNGLE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.JOSHUA_BEARD.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.LARCH_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MAPLE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MAUVE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MANGROVE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.OAK_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PALM_BEARD.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.PINE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.REDWOOD_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.SPRUCE_BRANCH.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.WILLOW_BRANCH.get());


        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_ACACIA_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_BAOBAB_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_BIRCH_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_BLACKWOOD_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_CHERRY_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_RED_CHERRY_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_PINK_CHERRY_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_WHITE_CHERRY_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_CYPRESS_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_DEAD_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_DEAD_PINE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_DARK_OAK_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_EUCALYPTUS_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_FLOWERING_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_JUNGLE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_JOSHUA_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_GOLDEN_LARCH_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_LARCH_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_MAPLE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_RED_MAPLE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_ORANGE_MAPLE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_MAUVE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_OAK_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_PALM_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_PINE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_REDWOOD_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_SPRUCE_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_SILVER_BIRCH_SAPLING.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_WILLOW_SAPLING.get());

        registerCompostableItems(0.35F, RegionsUnexploredBlocks.GREEN_BIOSHROOM.get());
        registerCompostableItems(0.35F, RegionsUnexploredBlocks.BLUE_BIOSHROOM.get());
        registerCompostableItems(0.35F, RegionsUnexploredBlocks.PINK_BIOSHROOM.get());
        registerCompostableItems(0.35F, RegionsUnexploredBlocks.YELLOW_BIOSHROOM.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_GREEN_BIOSHROOM.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_BLUE_BIOSHROOM.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_PINK_BIOSHROOM.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TALL_YELLOW_BIOSHROOM.get());

        registerCompostableItems(0.3F, RegionsUnexploredBlocks.MEDIUM_GRASS.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.SEEDED_GRASS.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.SEEDED_TALL_GRASS.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.STEPPE_GRASS.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.STEPPE_SHRUB.get());
        registerCompostableItems(0.2F, RegionsUnexploredBlocks.DEAD_STEPPE_SHRUB.get());
        registerCompostableItems(0.2F, RegionsUnexploredBlocks.TALL_STEPPE_GRASS.get());
        registerCompostableItems(0.25F, RegionsUnexploredBlocks.SANDY_GRASS.get());
        registerCompostableItems(0.3F, RegionsUnexploredBlocks.SANDY_TALL_GRASS.get());
        registerCompostableItems(0.2F, RegionsUnexploredBlocks.SMALL_DESERT_SHRUB.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.ELEPHANT_EAR.get());
        registerCompostableItems(0.2F, RegionsUnexploredBlocks.FROZEN_GRASS.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.BLUE_LUPINE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.PINK_LUPINE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.PURPLE_LUPINE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.RED_LUPINE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.YELLOW_LUPINE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.HYSSOP.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.FIREWEED.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.DAISY.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.FELICIA_DAISY.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.WARATAH.get());
        registerCompostableItems(0.2F, RegionsUnexploredBlocks.WILTING_TRILLIUM.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.WHITE_TRILLIUM.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.POPPY_BUSH.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.ALPHA_ROSE.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.ALPHA_DANDELION.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TASSEL.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.TSUBAKI.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.BARLEY.get());
        registerCompostableItems(0.65F, RegionsUnexploredBlocks.CATTAIL.get());
        registerCompostableItems(0.5F, RegionsUnexploredBlocks.BARREL_CACTUS.get());

        registerCompostableItems(0.2f, RegionsUnexploredBlocks.MYCOTOXIC_GRASS.get());
        registerCompostableItems(0.3f, RegionsUnexploredBlocks.MYCOTOXIC_DAISY.get());
        registerCompostableItems(0.2f, RegionsUnexploredBlocks.GLISTERING_SPROUT.get());
        registerCompostableItems(0.3f, RegionsUnexploredBlocks.GLISTER_BULB.get());
        registerCompostableItems(0.3f, RegionsUnexploredBlocks.GLISTERING_IVY.get());
        registerCompostableItems(0.3f, RegionsUnexploredBlocks.GLISTER_SPIRE.get());
        registerCompostableItems(0.2f, RegionsUnexploredBlocks.COBALT_ROOTS.get());
        registerCompostableItems(0.3f, RegionsUnexploredBlocks.SCULKWOOD_SAPLING.get());
        registerCompostableItems(0.1f, RegionsUnexploredBlocks.SCULK_SPROUT.get());

        registerFlammableBlock(RegionsUnexploredBlocks.SILVER_BIRCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.SILVER_BIRCH_LOG_BASE.get(), 5, 5);

        registerFlammableBlock(RegionsUnexploredBlocks.BAMBOO_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.BAMBOO_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_BAMBOO_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.BAMBOO_LOG_LEAVES.get(), 5, 5);

        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_BAOBAB_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_BAOBAB_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.RED_CHERRY_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.PINK_CHERRY_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.WHITE_CHERRY_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_CHERRY_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_CHERRY_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_CYPRESS_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_CYPRESS_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_JOSHUA_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_JOSHUA_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.GOLDEN_LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_LARCH_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_LARCH_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.RED_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.ORANGE_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_MAPLE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_MAPLE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_MAUVE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_MAUVE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.PALM_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_PALM_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_PALM_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.PINE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_LOG_TRANSITION.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_PINE_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_PINE_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_REDWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_REDWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_LEAVES.get(), 30, 60);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_WILLOW_LOG.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.STRIPPED_WILLOW_WOOD.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_STAIRS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_FENCE.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_FENCE_GATE.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.SPANISH_MOSS.get(), 15, 100);

        registerFlammableBlock(RegionsUnexploredBlocks.SAGUARO_CACTUS.get(), 5, 5);
        registerFlammableBlock(RegionsUnexploredBlocks.SAGUARO_CACTUS_CORNER.get(), 5, 5);

        registerFlammableBlock(RegionsUnexploredBlocks.MEDIUM_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SEEDED_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SEEDED_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.STEPPE_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.DEAD_STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_STEPPE_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SANDY_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SANDY_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SMALL_DESERT_SHRUB.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.ELEPHANT_EAR.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.FROZEN_GRASS.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BLUE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.PINK_LUPINE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.PURPLE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.RED_LUPINE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.YELLOW_LUPINE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.HYSSOP.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.FIREWEED.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.DAISY.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.FELICIA_DAISY.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.WARATAH.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.WILTING_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.WHITE_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_ROSE.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.ALPHA_DANDELION.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TASSEL.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TSUBAKI.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BARLEY.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.CATTAIL.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BARREL_CACTUS.get(), 60, 100);

        registerFlammableBlock(RegionsUnexploredBlocks.ACACIA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BAOBAB_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BIRCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACKWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.CHERRY_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.CYPRESS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.DEAD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.DARK_OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.EUCALYPTUS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.JUNGLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.JOSHUA_BEARD.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.LARCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.MAPLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.MAUVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.MANGROVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.PALM_BEARD.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.PINE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.REDWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.SPRUCE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.WILLOW_BRANCH.get(), 30, 100);


        registerFlammableBlock(RegionsUnexploredBlocks.TALL_ACACIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_BAOBAB_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_BLACKWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_CHERRY_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_RED_CHERRY_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_PINK_CHERRY_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_WHITE_CHERRY_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_CYPRESS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_DEAD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_DEAD_PINE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_DARK_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_EUCALYPTUS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_FLOWERING_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_JUNGLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_JOSHUA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_GOLDEN_LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_RED_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_ORANGE_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_MAUVE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_PALM_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_PINE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_REDWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_SPRUCE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_SILVER_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RegionsUnexploredBlocks.TALL_WILLOW_SAPLING.get(), 60, 100);

        registerFlammableBlock(RegionsUnexploredBlocks.RED_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.RED_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.RED_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.ORANGE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.ORANGE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.ORANGE_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.YELLOW_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.YELLOW_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.YELLOW_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.LIME_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIME_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIME_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.GREEN_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.GREEN_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.GREEN_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.BLUE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLUE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLUE_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.MAGENTA_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAGENTA_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.MAGENTA_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.PURPLE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PURPLE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PURPLE_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.PINK_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINK_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.PINK_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.BROWN_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BROWN_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BROWN_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.WHITE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WHITE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.WHITE_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.GRAY_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.GRAY_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.GRAY_PAINTED_STAIRS.get(), 5, 20);

        registerFlammableBlock(RegionsUnexploredBlocks.BLACK_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACK_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RegionsUnexploredBlocks.BLACK_PAINTED_STAIRS.get(), 5, 20);

        //StripBlocks

        registerStrippableBlock(RegionsUnexploredBlocks.BAOBAB_LOG.get(), RegionsUnexploredBlocks.STRIPPED_BAOBAB_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.BAOBAB_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_BAOBAB_WOOD.get());
        
        registerStrippableBlock(RegionsUnexploredBlocks.BLACKWOOD_LOG.get(), RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.BLACKWOOD_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.CHERRY_LOG.get(), RegionsUnexploredBlocks.STRIPPED_CHERRY_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.CHERRY_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_CHERRY_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.CYPRESS_LOG.get(), RegionsUnexploredBlocks.STRIPPED_CYPRESS_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.CYPRESS_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_CYPRESS_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.DEAD_LOG.get(), RegionsUnexploredBlocks.STRIPPED_DEAD_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.DEAD_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_DEAD_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.EUCALYPTUS_LOG.get(), RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.EUCALYPTUS_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.JOSHUA_LOG.get(), RegionsUnexploredBlocks.STRIPPED_JOSHUA_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.JOSHUA_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_JOSHUA_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.LARCH_LOG.get(), RegionsUnexploredBlocks.STRIPPED_LARCH_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.LARCH_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_LARCH_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.MAPLE_LOG.get(), RegionsUnexploredBlocks.STRIPPED_MAPLE_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.MAPLE_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_MAPLE_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.MAUVE_LOG.get(), RegionsUnexploredBlocks.STRIPPED_MAUVE_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.MAUVE_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_MAUVE_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.PALM_LOG.get(), RegionsUnexploredBlocks.STRIPPED_PALM_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.PALM_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_PALM_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.PINE_LOG.get(), RegionsUnexploredBlocks.STRIPPED_PINE_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.PINE_LOG_TRANSITION.get(), RegionsUnexploredBlocks.STRIPPED_PINE_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.PINE_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_PINE_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.REDWOOD_LOG.get(), RegionsUnexploredBlocks.STRIPPED_REDWOOD_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.REDWOOD_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_REDWOOD_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.WILLOW_LOG.get(), RegionsUnexploredBlocks.STRIPPED_WILLOW_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.WILLOW_WOOD.get(), RegionsUnexploredBlocks.STRIPPED_WILLOW_WOOD.get());

        registerStrippableBlock(RegionsUnexploredBlocks.SILVER_BIRCH_LOG_BASE.get(), Blocks.STRIPPED_BIRCH_LOG);

        registerStrippableBlock(RegionsUnexploredBlocks.SCULKWOOD_LOG_TRANSITION.get(), RegionsUnexploredBlocks.SCULKWOOD_LOG.get());
        registerStrippableBlock(RegionsUnexploredBlocks.SCULKWOOD_LOG_DARK.get(), RegionsUnexploredBlocks.SCULKWOOD_LOG.get());

        registerStrippableBlock(RegionsUnexploredBlocks.BAMBOO_LOG_LEAVES.get(), RegionsUnexploredBlocks.BAMBOO_LOG.get());
        //ShovelBlocks
        registerShovelled(RegionsUnexploredBlocks.STONE_GRASS_BLOCK.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.VIRIDESCENT_NYLIUM.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.PRISMOSS.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get(), RegionsUnexploredBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.MOSSY_STONE.get(), Blocks.STONE.defaultBlockState());

        registerShovelled(RegionsUnexploredBlocks.DEEPSLATE_GRASS_BLOCK.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get(), Blocks.DEEPSLATE.defaultBlockState());

        registerShovelled(RegionsUnexploredBlocks.CHALK_GRASS_BLOCK.get(), RegionsUnexploredBlocks.CHALK.get().defaultBlockState());
    }
    
    public static void registerCompostableItems(float possibility, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), possibility);
    }

    public static void registerStrippableBlock(Block log, Block strippedLog) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log, strippedLog);
    }

    public static void registerShovelled(Block block, BlockState shovelledBlock) {
        ShovelItem.FLATTENABLES = Maps.newHashMap(ShovelItem.FLATTENABLES);
        ShovelItem.FLATTENABLES.put(block, shovelledBlock);
    }

    public static void registerFlammableBlock(Block block, int spreadSpeed, int flammability) {
        FireBlock fireblock = (FireBlock)Blocks.FIRE;
        fireblock.setFlammable(block, spreadSpeed, flammability);
    }
}
