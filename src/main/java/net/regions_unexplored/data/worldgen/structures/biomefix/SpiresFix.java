package net.regions_unexplored.data.worldgen.structures.biomefix;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;

public class SpiresFix {
    public static boolean execute(LevelAccessor level, double x, double y, double z) {
        if (level.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("regions_unexplored:spires"))) {
            return true;
        }
        return false;
    }
}
