package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.regions_unexplored.world.level.block.SaguaroCactusBlock;
import net.regions_unexplored.world.level.block.state.properties.SaguaroCactusShape;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class SaguaroCactusLimbs extends TrunkVineDecorator {
	public static final SaguaroCactusLimbs INSTANCE = new SaguaroCactusLimbs();
	public static com.mojang.serialization.Codec<SaguaroCactusLimbs> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("saguaro_cactus_limbs");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
				
			int bpx1 = random.nextInt(2)+3;
			int bpx2 = random.nextInt(2)+3;
			int bpx3 = random.nextInt(2)+3;
			int bpx4 = random.nextInt(2)+3;
			
			BlockPos newpos = listBlockPos.get(bpx1);
			BlockPos newpos1 = listBlockPos.get(bpx2);
			BlockPos newpos2 = listBlockPos.get(bpx3);
			BlockPos newpos3 = listBlockPos.get(bpx4);
			
			BlockPos px = newpos.west();
			BlockPos nx = newpos1.east();
			BlockPos pz = newpos2.north();
			BlockPos nz = newpos3.south();

			BlockPos px1 = px.west();
			BlockPos nx1 = nx.east();
			BlockPos pz1 = pz.north();
			BlockPos nz1 = nz.south();
			
			BlockPos pxd = px1.above();
			BlockPos nxd = nx1.above();
			BlockPos pzd = pz1.above();
			BlockPos nzd = nz1.above();
			
			BlockPos pxd1 = pxd.above();
			BlockPos nxd1 = nxd.above();
			BlockPos pzd1 = pzd.above();
			BlockPos nzd1 = nzd.above();
			
			BlockPos pxd2 = pxd1.above();
			BlockPos nxd2 = nxd1.above();
			BlockPos pzd2 = pzd1.above();
			BlockPos nzd2 = nzd1.above();

			if (isReplaceable(levelReader, px)) {
				biConsumer.accept(px, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_WEST));
			}

			if (isReplaceable(levelReader, nx)) {
				biConsumer.accept(nx, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_WEST));
			}

			if (isReplaceable(levelReader, pz)) {
			    biConsumer.accept(pz, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_SOUTH));
			}

			if (isReplaceable(levelReader, nz)) {
			    biConsumer.accept(nz, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_SOUTH));
			}


			
			if (isReplaceable(levelReader, px1)) {
				biConsumer.accept(px1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.WEST_UP));
			}

			if (isReplaceable(levelReader, nx1)) {
				biConsumer.accept(nx1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_UP));
			}

			if (isReplaceable(levelReader, pz1)) {
			    biConsumer.accept(pz1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_UP));
			}

			if (isReplaceable(levelReader, nz1)) {
			    biConsumer.accept(nz1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.SOUTH_UP));
			}



			if (isReplaceable(levelReader, pxd)) {
				biConsumer.accept(pxd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, nxd)) {
				biConsumer.accept(nxd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, pzd)) {
			    biConsumer.accept(pzd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, nzd)) {
			    biConsumer.accept(nzd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}



			if (isReplaceable(levelReader, pxd1)) {
				biConsumer.accept(pxd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, nxd1)) {
				biConsumer.accept(nxd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, pzd1)) {
			    biConsumer.accept(pzd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(levelReader, nzd1)) {
			    biConsumer.accept(nzd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}


			if (random.nextInt(2)==0){
			if (isAirBlock(levelReader, pxd2)) {
				biConsumer.accept(pxd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}
			
			if (random.nextInt(2)==0){
			if (isAirBlock(levelReader, nxd2)) {
				biConsumer.accept(nxd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

			if (random.nextInt(2)==0){
			if (isAirBlock(levelReader, pzd2)) {
			    biConsumer.accept(pzd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

			if (random.nextInt(2)==0){
			if (isAirBlock(levelReader, nzd2)) {
			    biConsumer.accept(nzd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

		}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
      	return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
   	}

   	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
      	return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
   	}

	public static boolean isAir(BlockState p_159760_) {
		return p_159760_.is(Blocks.AIR)||p_159760_.is(Blocks.CAVE_AIR)||p_159760_.is(Blocks.VOID_AIR);
	}

	public static boolean isAirBlock(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
		return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isAir);
	}

   	public static boolean isFluids(BlockState p_159760_) {
      	return p_159760_.is(RegionsUnexploredTags.FLUIDS);
   	}

   	public static boolean isFluid(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
      	return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isFluids);
   	}
}