package net.regions_unexplored.world.level.block.grass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class RuFlowerBlock extends FlowerBlock {
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    protected static final VoxelShape SHAPE_TALL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 14.0D, 11.0D);
    protected static final VoxelShape SHAPE_BUSH = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SHAPE_DAISY = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);

    public RuFlowerBlock(MobEffect mobEffect, int i, Properties properties) {
        super(mobEffect, i, properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        if(state== RegionsUnexploredBlocks.POPPY_BUSH.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.BLUE_LUPINE.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.PINK_LUPINE.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.PURPLE_LUPINE.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.YELLOW_LUPINE.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.RED_LUPINE.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.HYSSOP.get().defaultBlockState()){
            return SHAPE_BUSH.move(vec3.x, vec3.y, vec3.z);
        }
        if(state== RegionsUnexploredBlocks.FIREWEED.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.WILTING_TRILLIUM.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.WHITE_TRILLIUM.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.WARATAH.get().defaultBlockState()){
            return SHAPE_TALL.move(vec3.x, vec3.y, vec3.z);
        }
        if(state== RegionsUnexploredBlocks.DAISY.get().defaultBlockState()
                ||state== RegionsUnexploredBlocks.FELICIA_DAISY.get().defaultBlockState()){
            return SHAPE_DAISY.move(vec3.x, vec3.y, vec3.z);
        }
        else{
            return SHAPE.move(vec3.x, vec3.y, vec3.z);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }
}
