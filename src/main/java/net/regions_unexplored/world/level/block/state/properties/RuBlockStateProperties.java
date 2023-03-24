package net.regions_unexplored.world.level.block.state.properties;

import net.minecraft.world.level.block.state.properties.*;

public class RuBlockStateProperties {
    public static final BooleanProperty HAS_GRAVITY = BooleanProperty.create("has_gravity");
    public static final BooleanProperty LEAVES = BooleanProperty.create("leaves");
    public static final BooleanProperty NATURAL = BooleanProperty.create("natural");
    public static final BooleanProperty IS_EVEN = BooleanProperty.create("is_even");
    public static final EnumProperty<SaguaroCactusShape> CACTUS_SHAPE = EnumProperty.create("cactus_shape", SaguaroCactusShape.class);
    public static final EnumProperty<HangingPrismariteShape> HANGING_PRISMARITE_SHAPE = EnumProperty.create("hanging_prismarite_shape", HangingPrismariteShape.class);
}
