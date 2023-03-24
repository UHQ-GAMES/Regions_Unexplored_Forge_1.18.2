package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RegionsUnexploredBlocks;

public class PrismossBlock extends Block implements BonemealableBlock {
   public PrismossBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean bool) {
      return level.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      //NORTH
      if(level.getBlockState(pos.north()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
         level.setBlock(pos.north(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH
      if(level.getBlockState(pos.south()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //EAST
      if(level.getBlockState(pos.east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.east(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.east(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //WEST
      if(level.getBlockState(pos.west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.west(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.west(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //NORTH-EAST
      if(level.getBlockState(pos.north().east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().east(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north().east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().east(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //NORTH-WEST
      if(level.getBlockState(pos.north().west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().west(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.north().west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.north().west(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.north().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.north().west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH-EAST
      if(level.getBlockState(pos.south().east()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().east(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south().east()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().east(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().east().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().east().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      //SOUTH-WEST
      if(level.getBlockState(pos.south().west()).is(BlockTags.STONE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().west(), RegionsUnexploredBlocks.PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }
      else if(level.getBlockState(pos.south().west()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)){
         if(random.nextInt(2)==0){
            level.setBlock(pos.south().west(), RegionsUnexploredBlocks.DEEPSLATE_PRISMOSS.get().defaultBlockState(), 2);
            if(level.getBlockState(pos.south().west().above()).isAir() & random.nextInt(2)==0){
               level.setBlock(pos.south().west().above(), RegionsUnexploredBlocks.PRISMOSS_SPROUT.get().defaultBlockState(), 2);
            }
         }
      }

   }

}
