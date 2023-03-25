package net.regions_unexplored.world.features.treedecorators;


import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.ForgeRegistries;


import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BambooLeaveDecorator extends TrunkVineDecorator {
	public static final BambooLeaveDecorator INSTANCE = new BambooLeaveDecorator();
	public static com.mojang.serialization.Codec<BambooLeaveDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("bamboo_leave_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}


	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			BlockPos newpos = listBlockPos.get(listBlockPos.size()-1);

			BlockPos up1 = new BlockPos(newpos.getX(),newpos.getY()+5,newpos.getZ());
			BlockPos up2 = new BlockPos(newpos.getX(),newpos.getY()+6,newpos.getZ());
			
			BlockPos px1 = new BlockPos(newpos.getX()+2,newpos.getY(),newpos.getZ());
			BlockPos px2 = new BlockPos(newpos.getX()+2,newpos.getY(),newpos.getZ()+1);
			BlockPos px3 = new BlockPos(newpos.getX()+2,newpos.getY(),newpos.getZ()-1);
			
			BlockPos nx1 = new BlockPos(newpos.getX()-2,newpos.getY(),newpos.getZ());
			BlockPos nx2 = new BlockPos(newpos.getX()-2,newpos.getY(),newpos.getZ()+1);
			BlockPos nx3 = new BlockPos(newpos.getX()-2,newpos.getY(),newpos.getZ()-1);
			
			BlockPos pz1 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+2);
			BlockPos pz2 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()+2);
			BlockPos pz3 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()+2);
			
			BlockPos nz1 = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-2);
			BlockPos nz2 = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ()-2);
			BlockPos nz3 = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ()-2);

			BlockPos px = new BlockPos(newpos.getX()+1,newpos.getY(),newpos.getZ());
			BlockPos nx = new BlockPos(newpos.getX()-1,newpos.getY(),newpos.getZ());
			BlockPos pz = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()+1);
			BlockPos nz = new BlockPos(newpos.getX(),newpos.getY(),newpos.getZ()-1);

			BlockPos pxt = px.above();
			BlockPos nxt = nx.above();
			BlockPos pzt = pz.above();
			BlockPos nzt = nz.above();

			BlockPos pxq = pxt.above();
			BlockPos nxq = nxt.above();
			BlockPos pzq = pzt.above();
			BlockPos nzq = nzt.above();

			BlockPos pxc = pxq.above();
			BlockPos nxc = nxq.above();
			BlockPos pzc = pzq.above();
			BlockPos nzc = nzq.above();

			BlockPos pxz = pxc.above();
			BlockPos nxz = nxc.above();
			BlockPos pzz = pzc.above();
			BlockPos nzz = nzc.above();

			BlockPos pxo = px.below();
			BlockPos nxo = nx.below();
			BlockPos pzo = pz.below();
			BlockPos nzo = nz.below();

			BlockPos pxm = pxo.below();
			BlockPos nxm = nxo.below();
			BlockPos pzm = pzo.below();
			BlockPos nzm = nzo.below();

			BlockPos pxp = pxm.below();
			BlockPos nxp = nxm.below();
			BlockPos pzp = pzm.below();
			BlockPos nzp = nzm.below();
			
			if (Feature.isAir(levelReader, px1)) {
			biConsumer.accept( px1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px2)) {
			biConsumer.accept( px2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, px3)) {
			biConsumer.accept( px3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, nx1)) {
			biConsumer.accept( nx1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx2)) {
			biConsumer.accept( nx2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx3)) {
			biConsumer.accept( nx3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, pz1)) {
			biConsumer.accept( pz1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz2)) {
			biConsumer.accept( pz2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz3)) {
			biConsumer.accept( pz3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, nz1)) {
			biConsumer.accept( nz1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz2)) {
			biConsumer.accept( nz2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz3)) {
			biConsumer.accept( nz3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, px)) {
			biConsumer.accept( px, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nx)) {
			biConsumer.accept( nx, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz)) {
			biConsumer.accept( pz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nz)) {
			biConsumer.accept( pz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxt)) {
			biConsumer.accept( pxt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxt)) {
			biConsumer.accept( nxt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzt)) {
			biConsumer.accept( pzt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzt)) {
			biConsumer.accept( pzt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxq)) {
			biConsumer.accept( pxq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxq)) {
			biConsumer.accept( nxq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pz)) {
			biConsumer.accept( pzq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzq)) {
			biConsumer.accept( pzq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxc)) {
			biConsumer.accept( pxc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxc)) {
			biConsumer.accept( nxc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzc)) {
			biConsumer.accept( pzc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzc)) {
			biConsumer.accept( pzc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxz)) {
			biConsumer.accept( pxz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxz)) {
			biConsumer.accept( nxz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzz)) {
			biConsumer.accept( pzz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzz)) {
			biConsumer.accept( pzz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (Feature.isAir(levelReader, up1)) {
			biConsumer.accept( up1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, up2)) {
			biConsumer.accept( up2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxo)) {
			biConsumer.accept( pxo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxo)) {
			biConsumer.accept( nxo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzo)) {
			biConsumer.accept( pzo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzo)) {
			biConsumer.accept( pzo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxm)) {
			biConsumer.accept( pxm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxm)) {
			biConsumer.accept( nxm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzm)) {
			biConsumer.accept( pzm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzm)) {
			biConsumer.accept( pzm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (Feature.isAir(levelReader, pxp)) {
			biConsumer.accept( pxp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nxp)) {
			biConsumer.accept( nxp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, pzp)) {
			biConsumer.accept( pzp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (Feature.isAir(levelReader, nzp)) {
			biConsumer.accept( pzp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
		}
	}

