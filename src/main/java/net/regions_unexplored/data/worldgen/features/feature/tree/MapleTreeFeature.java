package net.regions_unexplored.data.worldgen.features.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import java.util.Random;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.data.tags.RegionsUnexploredTags;
import net.regions_unexplored.data.worldgen.features.feature.tree.config.RuTreeConfiguration;
import net.regions_unexplored.world.level.block.BranchBlock;

import java.util.Random;

public class MapleTreeFeature extends Feature<RuTreeConfiguration> {

    public MapleTreeFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        Random Random = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;

        int check = 0;
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height_main) {
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            else{
                checkPos.move(Direction.UP);
                check = check + 1;
            }
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            placeLog(level, placePos, Random, treeConfiguration);
            if(placeCheck == 0){
                placeRoot(level, placePos, Random, treeConfiguration);
            }
            if(placeCheck == height_main){
                placeLeavesBlob(level, placePos, Random, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).is(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get())){
            level.setBlock(pos, RegionsUnexploredBlocks.FOREST_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get())){
            level.setBlock(pos, RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(Random, pos), 2);
        }
        else{
            return true;
        }

        if(level.getBlockState(pos.below()).is(RegionsUnexploredBlocks.FOREST_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RegionsUnexploredBlocks.FOREST_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RegionsUnexploredBlocks.PLAINS_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RegionsUnexploredBlocks.PLAINS_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RegionsUnexploredBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        return true;
    }
    public boolean placeBranches(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        if(isReplaceable(level, pos.north())&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(Random, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(isReplaceable(level, pos.south())&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(Random, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(isReplaceable(level, pos.east())&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(Random, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(isReplaceable(level, pos.west())&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(Random, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        return true;
    }

    public boolean placeRoot(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = 2;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            placeLog(level, placePos, Random, treeConfiguration);
            placePos.move(Direction.DOWN);
            i++;
        }
        return true;
    }

    public boolean placeLeavesBlobLayer(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        int k = random.nextInt(3);
        int l = random.nextInt(3);
        placeLeavesBlock(level, pos, Random, treeConfiguration);
        placeLeavesBlock(level, pos.north(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().north(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().east().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().north().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().west().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.north().north().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().south(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().east().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().south().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().west().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south().south().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.east().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.west().west(), Random, treeConfiguration);
        if(i==0){
            placeLeavesBlock(level, pos.north().north().east().east(), Random, treeConfiguration);
        }
        if(j==0){
            placeLeavesBlock(level, pos.north().north().west().west(), Random, treeConfiguration);
        }
        if(k==0){
            placeLeavesBlock(level, pos.south().south().east().east(), Random, treeConfiguration);
        }
        if(l==0){
            placeLeavesBlock(level, pos.south().south().west().west(), Random, treeConfiguration);
        }
        return true;
    }
    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(3);
        if(n==0){
            placeLeavesBlock(level, pos.north().east(), Random, treeConfiguration);
        }
        else if(n==1){
            placeLeavesBlock(level, pos.north().east().above(), Random, treeConfiguration);
        }
        else{
            placeLeavesBlock(level, pos.below().north().north(), Random, treeConfiguration);
        }
        int s = random.nextInt(3);
        if(s==0){
            placeLeavesBlock(level, pos.north().west(), Random, treeConfiguration);
        }
        else if(s==1){
            placeLeavesBlock(level, pos.north().west().above(), Random, treeConfiguration);
        }
        else{
            placeLeavesBlock(level, pos.below().south().south(), Random, treeConfiguration);
        }
        int e = random.nextInt(3);
        if(e==0){
            placeLeavesBlock(level, pos.south().east(), Random, treeConfiguration);
        }
        else if(e==1){
            placeLeavesBlock(level, pos.south().east().above(), Random, treeConfiguration);
        }
        else{
            placeLeavesBlock(level, pos.below().east().east(), Random, treeConfiguration);
        }
        int w = random.nextInt(3);
        if(w==0){
            placeLeavesBlock(level, pos.south().west(), Random, treeConfiguration);
        }
        else if(w==1){
            placeLeavesBlock(level, pos.south().west().above(), Random, treeConfiguration);
        }
        else{
            placeLeavesBlock(level, pos.below().west().west(), Random, treeConfiguration);
        }

        placeBranches(level, pos.below().below().below(), Random, treeConfiguration);
        placeBeehiveOrLeaves(level, pos.below().below().below().below(), Random, treeConfiguration);
        //Upper
        placeLeavesBlock(level, pos, Random, treeConfiguration);
        placeLeavesBlock(level, pos.north(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.south(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.above().above(), Random, treeConfiguration);
        //lower

        placeLeavesBlock(level, pos.below(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().north(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().north().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().north().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().south(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().south().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().south().west(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().east(), Random, treeConfiguration);
        placeLeavesBlock(level, pos.below().west(), Random, treeConfiguration);
        placeLeavesBlobLayer(level, pos.below().below(), Random, treeConfiguration);
        placeLeavesBlobLayer(level, pos.below().below().below(), Random, treeConfiguration);
        return true;
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).getMaterial().isReplaceable()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(Random, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        return true;
    }

    public boolean checkReplaceable(LevelAccessor level, BlockPos pos) {
        if(level.isOutsideBuildHeight(pos)){
            return false;
        }
        if(!isReplaceable(level, pos)) {
            return false;
        }
        return true;
    }

    public boolean placeBeehiveOrLeaves(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration){
        Random random = new Random();
        int chance = random.nextInt(400);
        if (level.getBlockState(pos.north()).isAir()) {
            if(chance==0){
            placeLeavesBlock(level,pos.north().above(), Random, treeConfiguration);
            level.setBlock(pos.north(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, Direction.NORTH), 2);
            level.getBlockEntity(pos.north(), BlockEntityType.BEEHIVE).ifPresent((addBee) -> {
                int j = 2 + random.nextInt(2);
                for(int k = 0; k < j; ++k) {
                    CompoundTag compoundtag = new CompoundTag();
                    compoundtag.putString("id", Registry.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                    addBee.storeBee(compoundtag, random.nextInt(599), false);
                }
            });
        }
            else{
                placeLeavesBlock(level, pos.north(), Random, treeConfiguration);
            }
        }
        if (level.getBlockState(pos.south()).isAir()) {
            if(chance==1){
                placeLeavesBlock(level,pos.south().above(), Random, treeConfiguration);
                level.setBlock(pos.south(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, Direction.SOUTH), 2);
                level.getBlockEntity(pos.south(), BlockEntityType.BEEHIVE).ifPresent((addBee) -> {
                    int j = 2 + random.nextInt(2);
                    for(int k = 0; k < j; ++k) {
                        CompoundTag compoundtag = new CompoundTag();
                        compoundtag.putString("id", Registry.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                        addBee.storeBee(compoundtag, random.nextInt(599), false);
                    }
                });
            }
            else{
                placeLeavesBlock(level, pos.south(), Random, treeConfiguration);
            }
        }
        if (level.getBlockState(pos.east()).isAir()) {
            if(chance==2){
                placeLeavesBlock(level,pos.east().above(), Random, treeConfiguration);
                level.setBlock(pos.east(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, Direction.EAST), 2);
                level.getBlockEntity(pos.east(), BlockEntityType.BEEHIVE).ifPresent((addBee) -> {
                    int j = 2 + random.nextInt(2);
                    for(int k = 0; k < j; ++k) {
                        CompoundTag compoundtag = new CompoundTag();
                        compoundtag.putString("id", Registry.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                        addBee.storeBee(compoundtag, random.nextInt(599), false);
                    }
                });
            }
            else{
                placeLeavesBlock(level, pos.east(), Random, treeConfiguration);
            }
        }
        if (level.getBlockState(pos.west()).isAir()) {
            if(chance==3){
                placeLeavesBlock(level,pos.west().above(), Random, treeConfiguration);
                level.setBlock(pos.west(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, Direction.WEST), 2);
                level.getBlockEntity(pos.west(), BlockEntityType.BEEHIVE).ifPresent((addBee) -> {
                    int j = 2 + random.nextInt(2);
                    for(int k = 0; k < j; ++k) {
                        CompoundTag compoundtag = new CompoundTag();
                        compoundtag.putString("id", Registry.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                        addBee.storeBee(compoundtag, random.nextInt(599), false);
                    }
                });
            }
            else{
                placeLeavesBlock(level, pos.west(), Random, treeConfiguration);
            }
        }
        return true;
    }
    
    public static boolean isReplaceableDirtBlock(BlockState state) {
        return state.is(RegionsUnexploredTags.TREE_GRASS_REPLACEABLES);
    }


    public static boolean isReplaceableDirt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, MapleTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RegionsUnexploredTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, MapleTreeFeature::isReplaceableBlock);
    }
}