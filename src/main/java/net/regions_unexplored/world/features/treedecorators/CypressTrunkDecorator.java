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

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class CypressTrunkDecorator extends TrunkVineDecorator {
	public static final CypressTrunkDecorator INSTANCE = new CypressTrunkDecorator();
	public static com.mojang.serialization.Codec<CypressTrunkDecorator> codec;
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
			int i1 = context.random().nextInt(3)+3;
			int i2 = context.random().nextInt(3)+3;
			int i3 = context.random().nextInt(3)+3;
			int i4 = context.random().nextInt(3)+3;
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);

			BlockPos bp = newpos.west();
			if(i<=0){
				context.setBlock(bp, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i1 && i>0){
				context.setBlock(bp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp1 = newpos.east();
			if(i<=0){
				context.setBlock(bp1, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i2 && i>0){
				context.setBlock(bp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp2 = newpos.north();
			if(i<=0){
				context.setBlock(bp2, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i3 && i>0){
				context.setBlock(bp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			

			BlockPos bp3 = newpos.south();
			if(i<=0){
				context.setBlock(bp3, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=i4 && i>0){
				context.setBlock(bp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}
			
			}
		}
	}

