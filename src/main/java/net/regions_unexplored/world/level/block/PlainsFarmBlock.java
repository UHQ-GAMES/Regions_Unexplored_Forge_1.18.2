package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import java.util.Random;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class PlainsFarmBlock extends Block {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
    public static final int MAX_MOISTURE = 7;

    public PlainsFarmBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, Integer.valueOf(0)));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter getter, BlockPos pos, Direction direction, IPlantable plantable) {
        BlockState plant = plantable.getPlant(getter, pos.relative(direction));
        net.minecraftforge.common.PlantType type = plantable.getPlantType(getter, pos.relative(direction));
        if (net.minecraftforge.common.PlantType.CROP.equals(type)) {
            return true;
        } else if (net.minecraftforge.common.PlantType.PLAINS.equals(type)) {
            return true;
        }
        return false;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (direction == Direction.UP && !state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, state1, level, pos, pos1);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos.above());
        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.canSurvive(level, pos)) {
            turnToDirt(state, level, pos);
        }

    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        int i = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (i > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!isUnderCrops(level, pos)) {
                turnToDirt(state, level, pos);
            }
        } else if (i < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }

    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float v) {
        if (!level.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(level, pos, RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState(), v, entity)) { // Forge: Move logic to Entity#canTrample
            turnToDirt(state, level, pos);
        }

        super.fallOn(level, state, pos, entity, v);
    }

    public static void turnToDirt(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState(), level, pos));
    }

    private static boolean isUnderCrops(BlockGetter getter, BlockPos pos) {
        BlockState plant = getter.getBlockState(pos.above());
        BlockState state = getter.getBlockState(pos);
        return plant.getBlock() instanceof IPlantable && state.canSustainPlant(getter, pos, Direction.UP, (IPlantable)plant.getBlock());
    }

    private static boolean isNearWater(LevelReader level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (level.getFluidState(blockpos).is(FluidTags.WATER)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(level, pos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(MOISTURE);
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }
}
