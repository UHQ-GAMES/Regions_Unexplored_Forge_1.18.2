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
        ForgeRegistries.TREE_DECORATOR_TYPES.register("bamboo_leave_decorator", BambooLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("cypress_trunk_decorator", CypressTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("birch_stem_decorator", BirchStemDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("blackwood_bioshroom", BlackwoodBioshroom.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("blackwood_branch_decorator", BlackwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("dead_branch_decorator", DeadBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("dead_pine_branch_decorator", DeadPineBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("dead_placer", DeadPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("dead_stem_decorator", DeadStemDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("eucalyptus_leave_decorator", EucalyptusLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("eucalyptus_trunk_decorator", EucalyptusTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("giant_cypress_leave_decorator", GiantCypressLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("giant_cypress_trunk_decorator", GiantCypressTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("giant_redwood_branch_decorator", GiantRedwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("maple_placer", MaplePlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("oak_placer", OakPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("palm_leaves_placer", PalmLeavesPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("pine_branch_decorator", PineBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("pine_trunk_decorator", PineTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("redwood_branch_decorator", RedwoodBranchDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("redwood_leave_decorator", RedwoodLeaveDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("redwood_trunk_decorator", RedwoodTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("saguaro_cactus_limbs", SaguaroCactusLimbs.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("silver_birch_placer", SilverBirchPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("spanish_moss_decorator", SpanishMossDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("silver_birch_trunk_decorator", SilverBirchTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("small_yellow_bioshroom_caps", SmallYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("medium_yellow_bioshroom_caps", MediumYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("big_yellow_bioshroom_caps", BigYellowBioshroomCaps.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("willow_palm_placer", WillowPalmPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("willow_placer", WillowPlacer.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("willow_trunk_decorator", WillowTrunkDecorator.tdt);

        RegionsUnexploredTabs.load();
        RuBiomeRegistry.registerBiomes();
        RuBiomeRegistry.BIOME_REGISTER.register(bus);
        RegionsUnexploredBlockEntities.BLOCK_ENTITIES.register(bus);
        RegionsUnexploredEntities.ENTITIES.register(bus);
        RuNoises.NOISE_PARAMETERS.register(bus);

        RegionsUnexploredItems.register(bus);
        RegionsUnexploredBlocks.register(bus);

        RuFeatureRegistry.REGISTRY.register(bus);
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
            Regions.register(new RuRegionModifiedVanilla(RegionsUnexploredCommonConfigs.REGION_VANILLA_MODIFIED_WEIGHT.get()));
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
