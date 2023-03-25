package net.regions_unexplored.world.level.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import javax.annotation.Nullable;

public class TillableDirtBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public TillableDirtBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {

        if (ToolActions.SHOVEL_FLATTEN == action && context.getItemInHand().canPerformAction(ToolActions.SHOVEL_FLATTEN)) {
            Block block = state.getBlock();
            if (block == RegionsUnexploredBlocks.FOREST_COARSE_DIRT.get()) {
                return RegionsUnexploredBlocks.FOREST_DIRT_PATH.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.FOREST_DIRT.get()) {
                return RegionsUnexploredBlocks.FOREST_DIRT_PATH.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.PLAINS_COARSE_DIRT.get()) {
                return RegionsUnexploredBlocks.PLAINS_DIRT_PATH.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.PLAINS_DIRT.get()) {
                return RegionsUnexploredBlocks.PLAINS_DIRT_PATH.get().defaultBlockState();
            } else {
                return null;
            }

        }

        if (ToolActions.HOE_TILL == action && context.getItemInHand().canPerformAction(ToolActions.HOE_TILL)) {
            Block block = state.getBlock();
            if (block == RegionsUnexploredBlocks.FOREST_COARSE_DIRT.get()) {
                return RegionsUnexploredBlocks.FOREST_DIRT.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.FOREST_DIRT.get()) {
                return RegionsUnexploredBlocks.FOREST_FARMLAND.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.PLAINS_COARSE_DIRT.get()) {
                return RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState();
            } else if (block == RegionsUnexploredBlocks.PLAINS_DIRT.get()) {
                return RegionsUnexploredBlocks.PLAINS_FARMLAND.get().defaultBlockState();
            } else {
                return null;
            }

        }
        return null;
    }
}