package net.regions_unexplored.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

@Mod.EventBusSubscriber(modid = RegionsUnexploredMod.MOD_ID)
public class BurnTimes {
    @SubscribeEvent
    public static void burnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (
                        item == RegionsUnexploredBlocks.ALPHA_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.ALPHA_STAIRS.get().asItem()||
                        //Larch
                        item == RegionsUnexploredBlocks.LARCH_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_LARCH_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_LARCH_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.LARCH_TRAPDOOR.get().asItem()||
                        //Cypress
                        item == RegionsUnexploredBlocks.CYPRESS_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_CYPRESS_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_CYPRESS_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_TRAPDOOR.get().asItem()||
                        //Maple
                        item == RegionsUnexploredBlocks.MAPLE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_MAPLE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_MAPLE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_TRAPDOOR.get().asItem()||
                        //Dead
                        item == RegionsUnexploredBlocks.DEAD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_DEAD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_DEAD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_TRAPDOOR.get().asItem()||
                        //Willow
                        item == RegionsUnexploredBlocks.WILLOW_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_WILLOW_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_WILLOW_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_TRAPDOOR.get().asItem()||
                        //Blackwood
                        item == RegionsUnexploredBlocks.BLACKWOOD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_BLACKWOOD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_TRAPDOOR.get().asItem()||
                        //Pine
                        item == RegionsUnexploredBlocks.PINE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_PINE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_PINE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_TRAPDOOR.get().asItem()||
                        //Joshua
                        item == RegionsUnexploredBlocks.JOSHUA_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_JOSHUA_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_JOSHUA_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_TRAPDOOR.get().asItem()||
                        //Eucalyptus
                        item == RegionsUnexploredBlocks.EUCALYPTUS_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_TRAPDOOR.get().asItem()||
                        //Redwood
                        item == RegionsUnexploredBlocks.REDWOOD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_REDWOOD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_REDWOOD_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_TRAPDOOR.get().asItem()||
                        //Mangrove
                        item == RegionsUnexploredBlocks.MAUVE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_MAUVE_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_MAUVE_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_TRAPDOOR.get().asItem()||
                        //Baobab
                        item == RegionsUnexploredBlocks.BAOBAB_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_BAOBAB_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_BAOBAB_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_TRAPDOOR.get().asItem()||
                        //Palm
                        item == RegionsUnexploredBlocks.PALM_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_PALM_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_PALM_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_TRAPDOOR.get().asItem()||
                        //Cherry
                        item == RegionsUnexploredBlocks.CHERRY_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_CHERRY_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.STRIPPED_CHERRY_WOOD.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_TRAPDOOR.get().asItem()||
                        //Cherry
                        item == RegionsUnexploredBlocks.SCULKWOOD_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_LOG_DARK.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_LOG_TRANSITION.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_PRESSURE_PLATE.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_FENCE.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_FENCE_GATE.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_TRAPDOOR.get().asItem()||
                        //Painted Planks
                        item == RegionsUnexploredBlocks.WHITE_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.GRAY_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACK_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.RED_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.ORANGE_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAGENTA_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.YELLOW_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIME_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.PINK_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.CYAN_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.PURPLE_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLUE_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.BROWN_PAINTED_PLANKS.get().asItem()||
                        item == RegionsUnexploredBlocks.GREEN_PAINTED_PLANKS.get().asItem()||
                        //Painted Stairs
                        item == RegionsUnexploredBlocks.WHITE_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.GRAY_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACK_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.RED_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.ORANGE_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.MAGENTA_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.YELLOW_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.LIME_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.PINK_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.CYAN_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.PURPLE_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.BLUE_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.BROWN_PAINTED_STAIRS.get().asItem()||
                        item == RegionsUnexploredBlocks.GREEN_PAINTED_STAIRS.get().asItem()
        ) {
            event.setBurnTime(300);
        }

        if (
                        item == RegionsUnexploredBlocks.LARCH_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_DOOR.get().asItem()||
                        item == RegionsUnexploredBlocks.BAMBOO_LOG.get().asItem()||
                        item == RegionsUnexploredBlocks.BAMBOO_LOG_LEAVES.get().asItem()
        ) {
            event.setBurnTime(200);
        }

        if (
                        item == RegionsUnexploredBlocks.LARCH_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.WHITE_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_GRAY_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.GRAY_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACK_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.RED_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.ORANGE_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.MAGENTA_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.LIGHT_BLUE_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.YELLOW_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.LIME_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.PINK_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.CYAN_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.PURPLE_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.BLUE_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.BROWN_PAINTED_SLAB.get().asItem()||
                        item == RegionsUnexploredBlocks.GREEN_PAINTED_SLAB.get().asItem()
        ) {
            event.setBurnTime(150);
        }

        if (
                        item == RegionsUnexploredBlocks.LARCH_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.GOLDEN_LARCH_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.RED_MAPLE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.ORANGE_MAPLE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_PINE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.RED_CHERRY_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.PINK_CHERRY_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.WHITE_CHERRY_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.BAMBOO_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.APPLE_OAK_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.FLOWERING_SAPLING.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_SAPLING.get().asItem()||

                        item == RegionsUnexploredBlocks.LARCH_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.SCULKWOOD_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.CYPRESS_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.MAPLE_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.DEAD_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.WILLOW_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.BLACKWOOD_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.PINE_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.JOSHUA_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.EUCALYPTUS_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.REDWOOD_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.MAUVE_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.BAOBAB_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.PALM_BUTTON.get().asItem()||
                        item == RegionsUnexploredBlocks.CHERRY_BUTTON.get().asItem()
        ) {
            event.setBurnTime(100);
        }
    }
}
