package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.VineBlock;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class SpanishMossDecorator extends LeaveVineDecorator {
    public static final SpanishMossDecorator INSTANCE = new SpanishMossDecorator();
    public static com.mojang.serialization.Codec<SpanishMossDecorator> codec;
    public static TreeDecoratorType<?> tdt;
    static {
        codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
        tdt = new TreeDecoratorType<>(codec);
        tdt.setRegistryName("spanish_moss_leave_decorator");
        
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return tdt;
    }

    @Override
    public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
        listBlockPos2.forEach((blockpos) -> {
            if (random.nextInt(4) == 0) {
                BlockPos bp = blockpos.below();
                if (isAirBlock(levelReader,bp)) {
                    addVine(levelReader, bp , random,  biConsumer);
                }
            }

        });
    }

    private static void addVine(LevelSimulatedReader levelReader, BlockPos pos, Random random, BiConsumer<BlockPos, BlockState> biConsumer) {
        int size = random.nextInt(4);
        BlockPos place = pos;
        for(int i = 0; i<=size; i++){
            if(isAirBlock(levelReader,place)){
                if(i==size){
                    biConsumer.accept(place, RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState());
                }
                else {
                    biConsumer.accept(place, RegionsUnexploredBlocks.SPANISH_MOSS_PLANT.get().defaultBlockState());
                }
                place = place.below();
            }
            else{
                if(i!=0){
                    biConsumer.accept(place.above(), RegionsUnexploredBlocks.SPANISH_MOSS.get().defaultBlockState());
                }
                break;
            }
        }
    }

    public static boolean isAir(BlockState p_159760_) {
        return p_159760_.is(Blocks.AIR)||p_159760_.is(Blocks.CAVE_AIR)||p_159760_.is(Blocks.VOID_AIR);
    }

    public static boolean isAirBlock(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
        return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isAir);
    }
}
