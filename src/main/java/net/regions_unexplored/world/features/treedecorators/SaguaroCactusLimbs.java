package net.regions_unexplored.world.features.treedecorators;

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

public class SaguaroCactusLimbs extends TrunkVineDecorator {
	public static final SaguaroCactusLimbs INSTANCE = new SaguaroCactusLimbs();
	public static com.mojang.serialization.Codec<SaguaroCactusLimbs> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
				
			int bpx1 = context.random().nextInt(2)+3;
			int bpx2 = context.random().nextInt(2)+3;
			int bpx3 = context.random().nextInt(2)+3;
			int bpx4 = context.random().nextInt(2)+3;
			
			BlockPos newpos = context.logs().get(bpx1);
			BlockPos newpos1 = context.logs().get(bpx2);
			BlockPos newpos2 = context.logs().get(bpx3);
			BlockPos newpos3 = context.logs().get(bpx4);
			
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

			if (isReplaceable(context.level(), px)) {
				context.setBlock(px, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_WEST));
			}

			if (isReplaceable(context.level(), nx)) {
				context.setBlock(nx, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_WEST));
			}

			if (isReplaceable(context.level(), pz)) {
			    context.setBlock(pz, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_SOUTH));
			}

			if (isReplaceable(context.level(), nz)) {
			    context.setBlock(nz, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_SOUTH));
			}


			
			if (isReplaceable(context.level(), px1)) {
				context.setBlock(px1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.WEST_UP));
			}

			if (isReplaceable(context.level(), nx1)) {
				context.setBlock(nx1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.EAST_UP));
			}

			if (isReplaceable(context.level(), pz1)) {
			    context.setBlock(pz1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.NORTH_UP));
			}

			if (isReplaceable(context.level(), nz1)) {
			    context.setBlock(nz1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SaguaroCactusBlock.SHAPE, SaguaroCactusShape.SOUTH_UP));
			}



			if (isReplaceable(context.level(), pxd)) {
				context.setBlock(pxd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), nxd)) {
				context.setBlock(nxd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), pzd)) {
			    context.setBlock(pzd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), nzd)) {
			    context.setBlock(nzd, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}



			if (isReplaceable(context.level(), pxd1)) {
				context.setBlock(pxd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), nxd1)) {
				context.setBlock(nxd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), pzd1)) {
			    context.setBlock(pzd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}

			if (isReplaceable(context.level(), nzd1)) {
			    context.setBlock(nzd1, RegionsUnexploredBlocks.SAGUARO_CACTUS.get().defaultBlockState());
			}


			if (context.random().nextInt(2)==0){
			if (context.isAir(pxd2)) {
				context.setBlock(pxd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}
			
			if (context.random().nextInt(2)==0){
			if (context.isAir(nxd2)) {
				context.setBlock(nxd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

			if (context.random().nextInt(2)==0){
			if (context.isAir(pzd2)) {
			    context.setBlock(pzd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

			if (context.random().nextInt(2)==0){
			if (context.isAir(nzd2)) {
			    context.setBlock(nzd2, RegionsUnexploredBlocks.CACTUS_FLOWER.get().defaultBlockState());
			}}

		}

	public static boolean isReplaceablePlant(BlockState p_159760_) {
      	return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
   	}

   	public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
      	return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
   	}

   	public static boolean isFluids(BlockState p_159760_) {
      	return p_159760_.is(RegionsUnexploredTags.FLUIDS);
   	}

   	public static boolean isFluid(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
      	return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isFluids);
   	}
}