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

import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class SilverBirchPlacer extends TrunkVineDecorator {
	public static final SilverBirchPlacer INSTANCE = new SilverBirchPlacer();
	public static com.mojang.serialization.Codec<SilverBirchPlacer> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("silver_birch_placer");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);
			BlockPos px1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ());


		biConsumer.accept(px1, RegionsUnexploredBlocks.SILVER_BIRCH_LEAVES.get().defaultBlockState());
			
		}
	}

