package net.regions_unexplored.world.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.item.RegionsUnexploredItems;

public class RegionsUnexploredTabs {
    public static CreativeModeTab TAB_REGIONS_UNEXPLORED_BUILDING_BLOCKS;
    public static CreativeModeTab TAB_REGIONS_UNEXPLORED_DECORATIONS;
    public static CreativeModeTab TAB_REGIONS_UNEXPLORED_OTHER;
    public static CreativeModeTab TAB_REGIONS_UNEXPLORED_NETHER;

    public static void load() {
        TAB_REGIONS_UNEXPLORED_BUILDING_BLOCKS = new CreativeModeTab("regions_unexplored_building_blocks_tab") {
        @Override
        public ItemStack makeIcon() {return new ItemStack(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get());}

        @OnlyIn(Dist.CLIENT)
        public boolean hasSearchBar() {return false;}
        };

        TAB_REGIONS_UNEXPLORED_DECORATIONS = new CreativeModeTab("regions_unexplored_decorations_tab") {
            @Override
            public ItemStack makeIcon() {return new ItemStack(RegionsUnexploredBlocks.WHITE_TRILLIUM.get());}

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {return false;}
        };

        TAB_REGIONS_UNEXPLORED_OTHER = new CreativeModeTab("regions_unexplored_other_tab") {
            @Override
            public ItemStack makeIcon() {return new ItemStack(RegionsUnexploredItems.BAOBAB_CHEST_BOAT.get());}

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {return false;}
        };

        TAB_REGIONS_UNEXPLORED_NETHER = new CreativeModeTab("regions_unexplored_nether_tab") {
            @Override
            public ItemStack makeIcon() {return new ItemStack(RegionsUnexploredBlocks.MYCOTOXIC_NYLIUM.get());}

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {return false;}
        };
    }

}
