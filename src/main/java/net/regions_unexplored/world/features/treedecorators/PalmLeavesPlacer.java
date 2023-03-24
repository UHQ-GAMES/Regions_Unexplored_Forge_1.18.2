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

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class PalmLeavesPlacer extends TrunkVineDecorator {
	public static final PalmLeavesPlacer INSTANCE = new PalmLeavesPlacer();
	public static com.mojang.serialization.Codec<PalmLeavesPlacer> codec;
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
		BlockPos newpos = context.logs().get(context.logs().size()-1);
			BlockPos px1 = new BlockPos(newpos.getX()+1,newpos.getY()+1,newpos.getZ());
			BlockPos px2 = new BlockPos(newpos.getX()+2,newpos.getY()+1,newpos.getZ());
			BlockPos px3 = new BlockPos(newpos.getX()+3,newpos.getY()+1,newpos.getZ());
			BlockPos px4 = new BlockPos(newpos.getX()+3,newpos.getY(),newpos.getZ());
			BlockPos px5 = new BlockPos(newpos.getX()+2,newpos.getY()+2,newpos.getZ());
			
			BlockPos nx1 = new BlockPos(newpos.getX()-1,newpos.getY()+1,newpos.getZ());
			BlockPos nx2 = new BlockPos(newpos.getX()-2,newpos.getY()+1,newpos.getZ());
			BlockPos nx3 = new BlockPos(newpos.getX()-3,newpos.getY()+1,newpos.getZ());
			BlockPos nx4 = new BlockPos(newpos.getX()-3,newpos.getY(),newpos.getZ());
			BlockPos nx5 = new BlockPos(newpos.getX()-2,newpos.getY()+2,newpos.getZ());

			
			BlockPos pz1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+1);
			BlockPos pz2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+2);
			BlockPos pz3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()+3);
			BlockPos pz4 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+3);
			BlockPos pz5 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ()+2);
			
			BlockPos nz1 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-1);
			BlockPos nz2 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-2);
			BlockPos nz3 = new BlockPos(newpos.getX(),newpos.getY()+1,newpos.getZ()-3);
			BlockPos nz4 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-3);
			BlockPos nz5 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ()-2);

			
			BlockPos y1 = new BlockPos(newpos.getX(),newpos.getY()+2,newpos.getZ());
			
			BlockPos fn1 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()+1);
			BlockPos fn2 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()+1);
			BlockPos fn3 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()-1);
			BlockPos fn4 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()-1);
			
			BlockPos fp1 = new BlockPos(newpos.getX()+1,newpos.getY()-1,newpos.getZ());
			BlockPos fp2 = new BlockPos(newpos.getX()-1,newpos.getY()-1,newpos.getZ());
			BlockPos fp3 = new BlockPos(newpos.getX(),newpos.getY()-1,newpos.getZ()+1);
			BlockPos fp4 = new BlockPos(newpos.getX(),newpos.getY()-1,newpos.getZ()-1);
			if (context.isAir(y1)) {
			context.setBlock(y1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(fn1)) {
			context.setBlock(fn1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fn2)) {
			context.setBlock(fn2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fn3)) {
			context.setBlock(fn3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fn4)) {
			context.setBlock(fn4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(fp1)) {
			context.setBlock(fp1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fp2)) {
			context.setBlock(fp2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fp3)) {
			context.setBlock(fp3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(fp4)) {
			context.setBlock(fp4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(px1)) {
			context.setBlock(px1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px2)) {
			context.setBlock(px2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px3)) {
			context.setBlock(px3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px4)) {
			context.setBlock(px4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px5)) {
			context.setBlock(px5, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(nx1)) {
			context.setBlock(nx1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx2)) {
			context.setBlock(nx2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx3)) {
			context.setBlock(nx3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx4)) {
			context.setBlock(nx4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx5)) {
			context.setBlock(nx5, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pz1)) {
			context.setBlock(pz1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz2)) {
			context.setBlock(pz2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz3)) {
			context.setBlock(pz3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz4)) {
			context.setBlock(pz4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz5)) {
			context.setBlock(pz5, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(nz1)) {
			context.setBlock(nz1, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz2)) {
			context.setBlock(nz2, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz3)) {
			context.setBlock(nz3, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz4)) {
			context.setBlock(nz4, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz5)) {
			context.setBlock(nz5, RegionsUnexploredBlocks.PALM_LEAVES.get().defaultBlockState());
			}
		}
	}

