package net.regions_unexplored.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.entity.custom.RuBoat;

public class RegionsUnexploredEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RegionsUnexploredMod.MOD_ID);


    public static RegistryObject<EntityType<?>> BOAT = ENTITIES.register("boat", () ->
            EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
                    .clientTrackingRange(10).build(RegionsUnexploredMod.MOD_ID + ":boat"));


    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}