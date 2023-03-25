package net.regions_unexplored;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.block.entity.RegionsUnexploredBlockEntities;
import net.regions_unexplored.block.entity.RuWoodTypes;
import net.regions_unexplored.data.worldgen.RuNetherSurfaceRuleData;
import net.regions_unexplored.data.worldgen.RuSurfaceRuleData;
import net.regions_unexplored.data.worldgen.noise.RuNoises;
import net.regions_unexplored.entity.RegionsUnexploredEntities;
import net.regions_unexplored.init.PottedPlantCompat;
import net.regions_unexplored.client.particle.RegionsUnexploredParticleTypes;
import net.regions_unexplored.config.RegionsUnexploredCommonConfigs;
import net.regions_unexplored.data.worldgen.biome.RuBiomeRegistry;
import net.regions_unexplored.data.worldgen.features.RuFeatureRegistry;
import net.regions_unexplored.init.BlockFeatureCompat;
import net.regions_unexplored.item.RegionsUnexploredItems;
import net.regions_unexplored.world.features.treedecorators.*;
import net.regions_unexplored.world.item.RegionsUnexploredTabs;
import net.regions_unexplored.world.level.biome.*;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.List;

@Mod(RegionsUnexploredMod.MOD_ID)
public class RegionsUnexploredMod {
    public static final String MOD_ID = "regions_unexplored";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RegionsUnexploredMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RegionsUnexploredCommonConfigs.SPEC, "regions_unexplored-common.toml");

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //register decorators before anything
        ForgeRegistries.TREE_DECORATOR_TYPES.register(BambooLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(CypressTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(BirchStemDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(BlackwoodBioshroom.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(BlackwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(DeadBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(DeadPineBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(DeadPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(DeadStemDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(EucalyptusLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(EucalyptusTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(GiantCypressLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(GiantCypressTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(GiantRedwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(MaplePlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(OakPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(PalmLeavesPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(PineBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(PineTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(RedwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(RedwoodLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(RedwoodTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(SaguaroCactusLimbs.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(SilverBirchPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(SpanishMossDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(SilverBirchTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(SmallYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(MediumYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(BigYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(WillowPalmPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(WillowPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register(WillowTrunkDecorator.tdt);

        RegionsUnexploredTabs.load();
        RuBiomeRegistry.registerBiomes();
        RuBiomeRegistry.BIOME_REGISTER.register(bus);
        RegionsUnexploredBlockEntities.BLOCK_ENTITIES.register(bus);
        RegionsUnexploredEntities.ENTITIES.register(bus);
        RuNoises.NOISE_PARAMETERS.register(bus);
        RuFeatureRegistry.REGISTRY.register(bus);

        RegionsUnexploredItems.register(bus);
        RegionsUnexploredBlocks.register(bus);

        RegionsUnexploredParticleTypes.REGISTRY.register(bus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        WoodType.register(RuWoodTypes.BAOBAB);
        WoodType.register(RuWoodTypes.BLACKWOOD);
        WoodType.register(RuWoodTypes.CHERRY);
        WoodType.register(RuWoodTypes.CYPRESS);
        WoodType.register(RuWoodTypes.DEAD);
        WoodType.register(RuWoodTypes.EUCALYPTUS);
        WoodType.register(RuWoodTypes.JOSHUA);
        WoodType.register(RuWoodTypes.LARCH);
        WoodType.register(RuWoodTypes.MAPLE);
        WoodType.register(RuWoodTypes.MAUVE);
        WoodType.register(RuWoodTypes.PALM);
        WoodType.register(RuWoodTypes.PINE);
        WoodType.register(RuWoodTypes.REDWOOD);
        WoodType.register(RuWoodTypes.SCULKWOOD);
        WoodType.register(RuWoodTypes.WILLOW);
        BlockEntityRenderers.register(RegionsUnexploredBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new RuRegionPrimary(RegionsUnexploredCommonConfigs.REGION_PRIMARY_WEIGHT.get()));
            Regions.register(new RuRegionSecondary(RegionsUnexploredCommonConfigs.REGION_SECONDARY_WEIGHT.get()));
            Regions.register(new RuRegionNether(RegionsUnexploredCommonConfigs.REGION_NETHER_WEIGHT.get()));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, RegionsUnexploredMod.MOD_ID, RuSurfaceRuleData.makeRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, RegionsUnexploredMod.MOD_ID, RuNetherSurfaceRuleData.makeRules());
            BlockFeatureCompat.setup();
            PottedPlantCompat.setup();
            Sheets.addWoodType(RuWoodTypes.BAOBAB);
            Sheets.addWoodType(RuWoodTypes.BLACKWOOD);
            Sheets.addWoodType(RuWoodTypes.CHERRY);
            Sheets.addWoodType(RuWoodTypes.CYPRESS);
            Sheets.addWoodType(RuWoodTypes.DEAD);
            Sheets.addWoodType(RuWoodTypes.EUCALYPTUS);
            Sheets.addWoodType(RuWoodTypes.JOSHUA);
            Sheets.addWoodType(RuWoodTypes.LARCH);
            Sheets.addWoodType(RuWoodTypes.MAPLE);
            Sheets.addWoodType(RuWoodTypes.MAUVE);
            Sheets.addWoodType(RuWoodTypes.PALM);
            Sheets.addWoodType(RuWoodTypes.PINE);
            Sheets.addWoodType(RuWoodTypes.REDWOOD);
            Sheets.addWoodType(RuWoodTypes.SCULKWOOD);
            Sheets.addWoodType(RuWoodTypes.WILLOW);
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
