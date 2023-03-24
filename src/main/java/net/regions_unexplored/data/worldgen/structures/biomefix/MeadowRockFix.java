package net.regions_unexplored.data.worldgen.structures.biomefix;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;

public class MeadowRockFix {
    public static boolean execute(LevelAccessor level, double x, double y, double z) {
        if (level.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("regions_unexplored:meadow"))) {
            return true;
        }
        if (level.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("regions_unexplored:temperate_grove"))) {
            return true;
        }
        if (level.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("regions_unexplored:golden_boreal_forest"))) {
            return true;
        }
        if (level.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("regions_unexplored:lush_hills"))) {
            return true;
        }
        return false;
    }
}
