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
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class CypressTrunkDecorator extends TrunkVineDecorator {
	public static final CypressTrunkDecorator INSTANCE = new CypressTrunkDecorator();
	public static com.mojang.serialization.Codec<CypressTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("cypress_trunk_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			int i1 = random.nextInt(3)+3;
			int i2 = random.nextInt(3)+3;
			int i3 = random.nextInt(3)+3;
			int i4 = random.nextInt(3)+3;
			for(int i = 0; i < listBlockPos.size(); i++){
			BlockPos newpos = listBlockPos.get(i);

			BlockPos bp = newpos.west();
			if(i<=0){
				biConsumer.accept(bp, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i1 && i>0){
				biConsumer.accept(bp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp1 = newpos.east();
			if(i<=0){
				biConsumer.accept(bp1, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i2 && i>0){
				biConsumer.accept(bp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp2 = newpos.north();
			if(i<=0){
				biConsumer.accept(bp2, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i3 && i>0){
				biConsumer.accept(bp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp3 = newpos.south();
			if(i<=0){
				biConsumer.accept(bp3, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i4 && i>0){
				biConsumer.accept(bp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			
			}
		}
	}

