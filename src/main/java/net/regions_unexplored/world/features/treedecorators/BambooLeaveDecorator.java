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
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraftforge.registries.ForgeRegistries;


import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.minecraft.core.BlockPos;

public class BambooLeaveDecorator extends TrunkVineDecorator {
	public static final BambooLeaveDecorator INSTANCE = new BambooLeaveDecorator();
	public static Codec<BambooLeaveDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
			BlockPos newpos = context.logs().get(context.logs().size()-1);

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
			
			if (context.isAir(px1)) {
			context.setBlock(px1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px2)) {
			context.setBlock(px2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(px3)) {
			context.setBlock(px3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(nx1)) {
			context.setBlock(nx1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx2)) {
			context.setBlock(nx2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx3)) {
			context.setBlock(nx3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(pz1)) {
			context.setBlock(pz1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz2)) {
			context.setBlock(pz2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz3)) {
			context.setBlock(pz3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(nz1)) {
			context.setBlock(nz1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz2)) {
			context.setBlock(nz2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz3)) {
			context.setBlock(nz3, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(px)) {
			context.setBlock(px, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nx)) {
			context.setBlock(nx, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz)) {
			context.setBlock(pz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nz)) {
			context.setBlock(pz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxt)) {
			context.setBlock(pxt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxt)) {
			context.setBlock(nxt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzt)) {
			context.setBlock(pzt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzt)) {
			context.setBlock(pzt, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxq)) {
			context.setBlock(pxq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxq)) {
			context.setBlock(nxq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pz)) {
			context.setBlock(pzq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzq)) {
			context.setBlock(pzq, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxc)) {
			context.setBlock(pxc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxc)) {
			context.setBlock(nxc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzc)) {
			context.setBlock(pzc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzc)) {
			context.setBlock(pzc, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxz)) {
			context.setBlock(pxz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxz)) {
			context.setBlock(nxz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzz)) {
			context.setBlock(pzz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzz)) {
			context.setBlock(pzz, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			
			if (context.isAir(up1)) {
			context.setBlock(up1, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(up2)) {
			context.setBlock(up2, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxo)) {
			context.setBlock(pxo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxo)) {
			context.setBlock(nxo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzo)) {
			context.setBlock(pzo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzo)) {
			context.setBlock(pzo, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxm)) {
			context.setBlock(pxm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxm)) {
			context.setBlock(nxm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzm)) {
			context.setBlock(pzm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzm)) {
			context.setBlock(pzm, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}

			if (context.isAir(pxp)) {
			context.setBlock(pxp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nxp)) {
			context.setBlock(nxp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(pzp)) {
			context.setBlock(pzp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
			if (context.isAir(nzp)) {
			context.setBlock(pzp, RegionsUnexploredBlocks.BAMBOO_LEAVES.get().defaultBlockState());
			}
		}
	}

