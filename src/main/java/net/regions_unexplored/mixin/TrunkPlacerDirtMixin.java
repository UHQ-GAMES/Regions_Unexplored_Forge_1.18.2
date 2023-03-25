
package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.util.worldgen.TrunkPlacerDirtUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import java.util.function.BiConsumer;


@Mixin(TrunkPlacer.class)
public abstract class TrunkPlacerDirtMixin {
    @Inject(at=@At("HEAD"), method = "setDirtAt(Lnet/minecraft/world/level/LevelSimulatedReader;Ljava/util/function/BiConsumer;Ljava/util/Random;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)V", cancellable = true)
    private static void setDirtAt(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> dirt, Random random, BlockPos pos, TreeConfiguration configuration, CallbackInfo ci) {
        if (TrunkPlacerDirtUtil.isForestGrass(level, pos)) {
            dirt.accept(pos, RegionsUnexploredBlocks.FOREST_DIRT.get().defaultBlockState());
        }
        if (TrunkPlacerDirtUtil.isPlainsGrass(level, pos)) {
            dirt.accept(pos, RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState());
        }
        if (TrunkPlacerDirtUtil.isAlphaGrass(level, pos)) {
            dirt.accept(pos, RegionsUnexploredBlocks.FOREST_DIRT.get().defaultBlockState());
        }
    }
}