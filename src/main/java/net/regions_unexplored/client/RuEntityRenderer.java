package net.regions_unexplored.client;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.entity.RegionsUnexploredEntities;
import net.regions_unexplored.entity.client.RuBoatRenderer;
import net.regions_unexplored.entity.custom.RuBoat;

@Mod.EventBusSubscriber(modid = RegionsUnexploredMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RuEntityRenderer
{
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        // Register boat layer definitions
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();

        for (RuBoat.ModelType type : RuBoat.ModelType.values())
        {
            ForgeHooksClient.registerLayerDefinition(RuBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
        }

        // Register entity renderers
        event.registerEntityRenderer((EntityType<RuBoat>) RegionsUnexploredEntities.BOAT.get(), context -> new RuBoatRenderer(context));
    }
}
