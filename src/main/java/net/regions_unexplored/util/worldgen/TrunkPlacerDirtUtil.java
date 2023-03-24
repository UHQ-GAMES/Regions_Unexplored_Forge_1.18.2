package net.regions_unexplored.util.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class TrunkPlacerDirtUtil {
    public static boolean isForestGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get())||p_70304_.is(RegionsUnexploredBlocks.FOREST_DIRT.get()) ;
        });
    }
    public static boolean isPlainsGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get())||p_70304_.is(RegionsUnexploredBlocks.PLAINS_DIRT.get()) ;
        });
    }
    public static boolean isAlphaGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get())||p_70304_.is(Blocks.DIRT) ;
        });
    }
}
