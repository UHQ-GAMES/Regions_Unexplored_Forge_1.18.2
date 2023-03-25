package net.regions_unexplored.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.entity.RegionsUnexploredEntities;
import net.regions_unexplored.item.RegionsUnexploredItems;

import java.util.Arrays;

public class RuBoat extends Boat {
    public RuBoat(EntityType<? extends RuBoat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public RuBoat(Level level, double x, double y, double z) {
        this((EntityType<RuBoat>) RegionsUnexploredEntities.BOAT.get(), level);
        this.setPos(x, y, z); this.xo = x; this.yo = y; this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return switch (ModelType.byId(this.entityData.get(DATA_ID_TYPE))) {
            case BAOBAB -> RegionsUnexploredItems.BAOBAB_BOAT.get();
            case BLACKWOOD -> RegionsUnexploredItems.BLACKWOOD_BOAT.get();
            case CHERRY -> RegionsUnexploredItems.CHERRY_BOAT.get();
            case CYPRESS -> RegionsUnexploredItems.CYPRESS_BOAT.get();
            case DEAD -> RegionsUnexploredItems.DEAD_BOAT.get();
            case EUCALYPTUS -> RegionsUnexploredItems.EUCALYPTUS_BOAT.get();
            case JOSHUA -> RegionsUnexploredItems.JOSHUA_BOAT.get();
            case LARCH -> RegionsUnexploredItems.LARCH_BOAT.get();
            case MAPLE -> RegionsUnexploredItems.MAPLE_BOAT.get();
            case MAUVE -> RegionsUnexploredItems.MAUVE_BOAT.get();
            case PALM -> RegionsUnexploredItems.PALM_BOAT.get();
            case PINE -> RegionsUnexploredItems.PINE_BOAT.get();
            case REDWOOD -> RegionsUnexploredItems.REDWOOD_BOAT.get();
            case SCULKWOOD -> RegionsUnexploredItems.SCULKWOOD_BOAT.get();
            case WILLOW -> RegionsUnexploredItems.WILLOW_BOAT.get();
        };
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("model", getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("model", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_TYPE, ModelType.byName(tag.getString("model")).ordinal());
        }
    }

    @Override
    protected void checkFallDamage(double distance, boolean bool, BlockState state, BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;
        if (!this.isPassenger()) {
            if (bool) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Boat.Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
                    if (!this.level.isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for(int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getBoatType().getPlanks());
                            }

                            for(int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && distance < 0.0D) {
                this.fallDistance -= (float)distance;
            }

        }
    }

    public void setModel(ModelType model) {
        this.entityData.set(DATA_ID_TYPE, model.ordinal());
    }

    public ModelType getModel() {
        return ModelType.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Deprecated
    public void setType(Boat.Type type) {
    }

    @Deprecated
    public Boat.Type getBoatType() {
        return Type.OAK;
    }

    public enum ModelType {
        BAOBAB("baobab", RegionsUnexploredBlocks.BAOBAB_PLANKS.get()),
        BLACKWOOD("blackwood", RegionsUnexploredBlocks.BLACKWOOD_PLANKS.get()),
        CHERRY("cherry", RegionsUnexploredBlocks.CHERRY_PLANKS.get()),
        CYPRESS("cypress", RegionsUnexploredBlocks.CYPRESS_PLANKS.get()),
        DEAD("dead", RegionsUnexploredBlocks.DEAD_PLANKS.get()),
        EUCALYPTUS("eucalyptus", RegionsUnexploredBlocks.EUCALYPTUS_PLANKS.get()),
        JOSHUA("joshua", RegionsUnexploredBlocks.JOSHUA_PLANKS.get()),
        LARCH("larch", RegionsUnexploredBlocks.LARCH_PLANKS.get()),
        MAPLE("maple", RegionsUnexploredBlocks.MAPLE_PLANKS.get()),
        MAUVE("mauve", RegionsUnexploredBlocks.MAUVE_PLANKS.get()),
        PALM("palm", RegionsUnexploredBlocks.PALM_PLANKS.get()),
        PINE("pine", RegionsUnexploredBlocks.PINE_PLANKS.get()),
        REDWOOD("redwood", RegionsUnexploredBlocks.REDWOOD_PLANKS.get()),
        SCULKWOOD("sculkwood", RegionsUnexploredBlocks.SCULKWOOD_PLANKS.get()),
        WILLOW("willow", RegionsUnexploredBlocks.WILLOW_PLANKS.get());

        private final String name;
        private final Block planks;

        ModelType(String name, Block planks) {
            this.name = name;
            this.planks = planks;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static ModelType byId(int id) {
            ModelType[] model = values();
            return model[id < 0 || id >= model.length ? 0 : id];
        }

        public static ModelType byName(String name) {
            ModelType[] model = values();
            return Arrays.stream(model).filter(t -> t.getName().equals(name)).findFirst().orElse(model[0]);
        }
    }
}