package net.regions_unexplored.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegionsUnexploredParticles {
    @SubscribeEvent
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register((SimpleParticleType) RegionsUnexploredParticleTypes.MAUVE.get(), MauveParticle::provider);
        Minecraft.getInstance().particleEngine.register((SimpleParticleType) RegionsUnexploredParticleTypes.MYCOTOXIC_SPORE.get(), MycotoxicSporeParticle::provider);
    }
}

