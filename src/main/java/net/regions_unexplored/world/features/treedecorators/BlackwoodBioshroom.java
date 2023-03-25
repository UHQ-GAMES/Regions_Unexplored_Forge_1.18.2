package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BlackwoodBioshroom extends TrunkVineDecorator {
	public static final BlackwoodBioshroom INSTANCE = new BlackwoodBioshroom();
	public static com.mojang.serialization.Codec<BlackwoodBioshroom> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("blackwood_bioshrooms");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
		int type = random.nextInt(4);
			if(type==0){
				BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(levelReader, px1)) {
					biConsumer.accept(px1, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1e)) {
					biConsumer.accept(px1e, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1w)) {
					biConsumer.accept(px1w, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s)) {
					biConsumer.accept(px1s, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n)) {
					biConsumer.accept(px1n, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.west())) {
					biConsumer.accept(px1s.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.west())) {
					biConsumer.accept(px1n.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.east())) {
					biConsumer.accept(px1s.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.east())) {
					biConsumer.accept(px1n.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
			if(type==1){
				BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(levelReader, px1)) {
					biConsumer.accept(px1, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1e)) {
					biConsumer.accept(px1e, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1w)) {
					biConsumer.accept(px1w, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s)) {
					biConsumer.accept(px1s, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n)) {
					biConsumer.accept(px1n, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.west())) {
					biConsumer.accept(px1s.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.west())) {
					biConsumer.accept(px1n.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.east())) {
					biConsumer.accept(px1s.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.east())) {
					biConsumer.accept(px1n.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}

			}
			if(type==2){
				BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(levelReader, px1)) {
					biConsumer.accept(px1, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.north())) {
					biConsumer.accept(px1.north(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.south())) {
					biConsumer.accept(px1.south(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.east())) {
					biConsumer.accept(px1.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.west())) {
					biConsumer.accept(px1.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}


				if (isReplaceable(levelReader, px1s)) {
					biConsumer.accept(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n)) {
					biConsumer.accept(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1e)) {
					biConsumer.accept(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1w)) {
					biConsumer.accept(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(levelReader, px1s.west())) {
					biConsumer.accept(px1s.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.west())) {
					biConsumer.accept(px1n.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.east())) {
					biConsumer.accept(px1s.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.east())) {
					biConsumer.accept(px1n.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
			if(type==3){
				BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(levelReader, px1)) {
					biConsumer.accept(px1, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.north())) {
					biConsumer.accept(px1.north(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.south())) {
					biConsumer.accept(px1.south(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.east())) {
					biConsumer.accept(px1.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1.west())) {
					biConsumer.accept(px1.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}


				if (isReplaceable(levelReader, px1s)) {
					biConsumer.accept(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n)) {
					biConsumer.accept(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1e)) {
					biConsumer.accept(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(levelReader, px1w)) {
					biConsumer.accept(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(levelReader, px1s.west())) {
					biConsumer.accept(px1s.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.west())) {
					biConsumer.accept(px1n.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.east())) {
					biConsumer.accept(px1s.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.east())) {
					biConsumer.accept(px1n.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
		}

		public static boolean isReplaceablePlant(BlockState p_159760_) {
			return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
		}

		public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
			return p_65789_.isStateAtPosition(p_65790_, BlackwoodBioshroom::isReplaceablePlant);
		}
	}

