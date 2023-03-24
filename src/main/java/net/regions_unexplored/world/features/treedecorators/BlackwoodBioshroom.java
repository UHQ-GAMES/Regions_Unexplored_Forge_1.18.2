/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.regionsunexplored as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
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

public class BlackwoodBioshroom extends TrunkVineDecorator {
	public static final BlackwoodBioshroom INSTANCE = new BlackwoodBioshroom();
	public static com.mojang.serialization.Codec<BlackwoodBioshroom> codec;
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
	public void place(Context context) {
		int type = context.random().nextInt(4);
			if(type==0){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
			if(type==1){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}

			}
			if(type==2){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}


				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RegionsUnexploredBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
			}
			if(type==3){
				BlockPos newpos = context.logs().get(context.logs().size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

				if (isReplaceable(context.level(), px1)) {
					context.setBlock(px1, RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.north())) {
					context.setBlock(px1.north(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.south())) {
					context.setBlock(px1.south(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.east())) {
					context.setBlock(px1.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1.west())) {
					context.setBlock(px1.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}


				if (isReplaceable(context.level(), px1s)) {
					context.setBlock(px1s, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n)) {
					context.setBlock(px1n, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1e)) {
					context.setBlock(px1e, Blocks.SHROOMLIGHT.defaultBlockState());
				}
				if (isReplaceable(context.level(), px1w)) {
					context.setBlock(px1w, Blocks.SHROOMLIGHT.defaultBlockState());
				}

				if (isReplaceable(context.level(), px1s.west())) {
					context.setBlock(px1s.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.west())) {
					context.setBlock(px1n.west(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1s.east())) {
					context.setBlock(px1s.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(context.level(), px1n.east())) {
					context.setBlock(px1n.east(), RegionsUnexploredBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState());
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

