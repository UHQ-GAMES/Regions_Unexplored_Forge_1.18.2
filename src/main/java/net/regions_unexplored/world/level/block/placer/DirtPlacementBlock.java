package net.regions_unexplored.world.level.block.placer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
/*
*
* INTERNAL_FEATURE_PLACING_HELPER
*
* */
public class DirtPlacementBlock extends BushBlock {
    public DirtPlacementBlock() {
        super(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().noCollission());
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(RegionsUnexploredBlocks.FOREST_DIRT.get()) || state.is(RegionsUnexploredBlocks.PLAINS_DIRT.get())
                || state.is(RegionsUnexploredBlocks.PLAINS_COARSE_DIRT.get())
                || state.is(RegionsUnexploredBlocks.FOREST_COARSE_DIRT.get())
                || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.PODZOL) || state.is(Blocks.ROOTED_DIRT);
    }


    @Override
    public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
        BlockPos blockpos = p_51030_.below();
        return this.mayPlaceOn(p_51029_.getBlockState(blockpos), p_51029_, blockpos);
    }
}

