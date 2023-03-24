package net.regions_unexplored.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

public class RegionsUnexploredParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES,
            RegionsUnexploredMod.MOD_ID);
    public static final RegistryObject<ParticleType<?>> MAUVE = REGISTRY.register("mauve", () -> new SimpleParticleType(true));
    public static final RegistryObject<ParticleType<?>> MYCOTOXIC_SPORE = REGISTRY.register("mycotoxic_spore", () -> new SimpleParticleType(false));
}