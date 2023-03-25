package net.regions_unexplored.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.entity.custom.RuBoat;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.stream.Stream;

public class RuBoatRenderer extends BoatRenderer
{
    private final Map<RuBoat.ModelType, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public RuBoatRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.boatResources = Stream.of(RuBoat.ModelType.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) ->
                Pair.of(new ResourceLocation(RegionsUnexploredMod.MOD_ID, getTextureLocation(model)), createBoatModel(context, model))));
    }

    @Override
    public @NotNull Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        return (Pair)this.boatResources.get(((RuBoat)boat).getModel());
    }

    private static String getTextureLocation(RuBoat.ModelType type) {
        return "textures/entity/boat/" + type.getName() + ".png";
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, RuBoat.ModelType type) {
        ModelLayerLocation modellayerlocation = boatTextureLocation(type);
        ModelPart baked = context.bakeLayer(modellayerlocation);
        return new BoatModel(baked);
    }

    private static ModelLayerLocation getModel(String name, String model) {
        return new ModelLayerLocation(new ResourceLocation(RegionsUnexploredMod.MOD_ID, name), model);
    }

    public static ModelLayerLocation boatTextureLocation(RuBoat.ModelType type) {
        return getModel("boat/" + type.getName(), "main");
    }
}