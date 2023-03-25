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

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class SmallYellowBioshroomCaps extends TrunkVineDecorator {
	public static final SmallYellowBioshroomCaps INSTANCE = new SmallYellowBioshroomCaps();
	public static com.mojang.serialization.Codec<SmallYellowBioshroomCaps> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("small_yellow_bioshroom_caps");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
				BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
				BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());
				BlockPos px1e = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
				BlockPos px1w = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
				BlockPos px1s = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
				BlockPos px1n = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);

				if (isReplaceable(levelReader, px1)) {
					biConsumer.accept(px1, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1e)) {
					biConsumer.accept(px1e, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1w)) {
					biConsumer.accept(px1w, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s)) {
					biConsumer.accept(px1s, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n)) {
					biConsumer.accept(px1n, RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.west())) {
					biConsumer.accept(px1s.west(), RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.west())) {
					biConsumer.accept(px1n.west(), RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1s.east())) {
					biConsumer.accept(px1s.east(), RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
				if (isReplaceable(levelReader, px1n.east())) {
					biConsumer.accept(px1n.east(), RegionsUnexploredBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState());
				}
		}

		public static boolean isReplaceablePlant(BlockState p_159760_) {
			return p_159760_.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
		}

		public static boolean isReplaceable(LevelSimulatedReader p_65789_, BlockPos p_65790_) {
			return p_65789_.isStateAtPosition(p_65790_, SaguaroCactusLimbs::isReplaceablePlant);
		}
	}

