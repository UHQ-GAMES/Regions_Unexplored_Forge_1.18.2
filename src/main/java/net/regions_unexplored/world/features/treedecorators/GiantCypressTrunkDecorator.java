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
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class GiantCypressTrunkDecorator extends TrunkVineDecorator {
	public static final GiantCypressTrunkDecorator INSTANCE = new GiantCypressTrunkDecorator();
	public static com.mojang.serialization.Codec<GiantCypressTrunkDecorator> codec;
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
			int i1 = context.random().nextInt(3)+7;
			int i2 = context.random().nextInt(3)+7;
			int i3 = context.random().nextInt(3)+7;
			int i4 = context.random().nextInt(3)+7;

			int ii1 = context.random().nextInt(2)+2;
			int ii2 = context.random().nextInt(2)+2;
			int ii3 = context.random().nextInt(2)+2;
			int ii4 = context.random().nextInt(2)+2;

			int iii1 = context.random().nextInt(2)+3;
			int iii2 = context.random().nextInt(2)+3;
			int iii3 = context.random().nextInt(2)+3;
			int iii4 = context.random().nextInt(2)+3;
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);

			BlockPos bp = newpos.west();
			if(i<=0){
				context.setBlock(bp, Blocks.MUD.defaultBlockState());
				context.setBlock(bp.below(), Blocks.MUD.defaultBlockState());
			}
			else if(i<=i1 && i>0){
				context.setBlock(bp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpn = bp.north();
				if(i<=0){
					context.setBlock(bpn, Blocks.MUD.defaultBlockState());
					context.setBlock(bpn.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=iii1 && i>0){
					context.setBlock(bpn, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bps = bp.south();
				if(i<=0){
					context.setBlock(bps, Blocks.MUD.defaultBlockState());
					context.setBlock(bps.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=iii2 && i>0){
					context.setBlock(bps, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bpp = bp.west();
				if(i<=0){
					context.setBlock(bpp, Blocks.MUD.defaultBlockState());
					context.setBlock(bpp.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=ii1 && i>0){
					context.setBlock(bpp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp1 = newpos.east();
			if(i<=0){
				context.setBlock(bp1, Blocks.MUD.defaultBlockState());
				context.setBlock(bp1.below(), Blocks.MUD.defaultBlockState());
			}
			else if(i<=i2 && i>0){
				context.setBlock(bp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}


				BlockPos bpn1 = bp1.north();
				if(i<=0){
					context.setBlock(bpn1, Blocks.MUD.defaultBlockState());
					context.setBlock(bpn1.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=iii3 && i>0){
					context.setBlock(bpn1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bps1 = bp1.south();
				if(i<=0){
					context.setBlock(bps1, Blocks.MUD.defaultBlockState());
					context.setBlock(bps1.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=iii4 && i>0){
					context.setBlock(bps1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}






				BlockPos bpp1 = bp1.east();
				if(i<=0){
					context.setBlock(bpp1, Blocks.MUD.defaultBlockState());
					context.setBlock(bpp1.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=ii2 && i>0){
					context.setBlock(bpp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp2 = newpos.north();
			if(i<=0){
				context.setBlock(bp2, Blocks.MUD.defaultBlockState());
				context.setBlock(bp2.below(), Blocks.MUD.defaultBlockState());
			}
			else if(i<=i3 && i>0){
				context.setBlock(bp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpp2 = bp2.north();
				if(i<=0){
					context.setBlock(bpp2, Blocks.MUD.defaultBlockState());
					context.setBlock(bpp2.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=ii3 && i>0){
					context.setBlock(bpp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp3 = newpos.south();
			if(i<=0){
				context.setBlock(bp3, Blocks.MUD.defaultBlockState());
				context.setBlock(bp3.below(), Blocks.MUD.defaultBlockState());
			}
			else if(i<=i4 && i>0){
				context.setBlock(bp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpp3 = bp3.south();
				if(i<=0){
					context.setBlock(bpp3, Blocks.MUD.defaultBlockState());
					context.setBlock(bpp3.below(), Blocks.MUD.defaultBlockState());
				}
				else if(i<=ii4 && i>0){
					context.setBlock(bpp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			
			}
		}
	}

