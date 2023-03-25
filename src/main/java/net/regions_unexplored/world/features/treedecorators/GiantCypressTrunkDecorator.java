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

public class GiantCypressTrunkDecorator extends TrunkVineDecorator {
	public static final GiantCypressTrunkDecorator INSTANCE = new GiantCypressTrunkDecorator();
	public static com.mojang.serialization.Codec<GiantCypressTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		tdt.setRegistryName("giant_cypress_trunk_decorator");
		
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> biConsumer, Random random, List<BlockPos> listBlockPos, List<BlockPos> listBlockPos2) {
			int i1 = random.nextInt(3)+7;
			int i2 = random.nextInt(3)+7;
			int i3 = random.nextInt(3)+7;
			int i4 = random.nextInt(3)+7;

			int ii1 = random.nextInt(2)+2;
			int ii2 = random.nextInt(2)+2;
			int ii3 = random.nextInt(2)+2;
			int ii4 = random.nextInt(2)+2;

			int iii1 = random.nextInt(2)+3;
			int iii2 = random.nextInt(2)+3;
			int iii3 = random.nextInt(2)+3;
			int iii4 = random.nextInt(2)+3;
			for(int i = 0; i < listBlockPos.size(); i++){
			BlockPos newpos = listBlockPos.get(i);

			BlockPos bp = newpos.west();
			if(i<=0){
				biConsumer.accept(bp, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				biConsumer.accept(bp.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
			}
			else if(i<=i1 && i>0){
				biConsumer.accept(bp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpn = bp.north();
				if(i<=0){
					biConsumer.accept(bpn, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpn.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=iii1 && i>0){
					biConsumer.accept(bpn, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bps = bp.south();
				if(i<=0){
					biConsumer.accept(bps, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bps.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=iii2 && i>0){
					biConsumer.accept(bps, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bpp = bp.west();
				if(i<=0){
					biConsumer.accept(bpp, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpp.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=ii1 && i>0){
					biConsumer.accept(bpp, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp1 = newpos.east();
			if(i<=0){
				biConsumer.accept(bp1, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				biConsumer.accept(bp1.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
			}
			else if(i<=i2 && i>0){
				biConsumer.accept(bp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}


				BlockPos bpn1 = bp1.north();
				if(i<=0){
					biConsumer.accept(bpn1, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpn1.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=iii3 && i>0){
					biConsumer.accept(bpn1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}

				BlockPos bps1 = bp1.south();
				if(i<=0){
					biConsumer.accept(bps1, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bps1.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=iii4 && i>0){
					biConsumer.accept(bps1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}






				BlockPos bpp1 = bp1.east();
				if(i<=0){
					biConsumer.accept(bpp1, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpp1.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=ii2 && i>0){
					biConsumer.accept(bpp1, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp2 = newpos.north();
			if(i<=0){
				biConsumer.accept(bp2, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				biConsumer.accept(bp2.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
			}
			else if(i<=i3 && i>0){
				biConsumer.accept(bp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpp2 = bp2.north();
				if(i<=0){
					biConsumer.accept(bpp2, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpp2.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=ii3 && i>0){
					biConsumer.accept(bpp2, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			

			BlockPos bp3 = newpos.south();
			if(i<=0){
				biConsumer.accept(bp3, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				biConsumer.accept(bp3.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
			}
			else if(i<=i4 && i>0){
				biConsumer.accept(bp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
			}

				BlockPos bpp3 = bp3.south();
				if(i<=0){
					biConsumer.accept(bpp3, RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
					biConsumer.accept(bpp3.below(), RegionsUnexploredBlocks.FOREST_MUD.get().defaultBlockState());
				}
				else if(i<=ii4 && i>0){
					biConsumer.accept(bpp3, RegionsUnexploredBlocks.CYPRESS_LOG.get().defaultBlockState());
				}
			
			}
		}
	}

