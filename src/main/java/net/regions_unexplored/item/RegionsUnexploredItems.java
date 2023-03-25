package net.regions_unexplored.item;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RegionsUnexploredBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.world.item.RegionsUnexploredTabs;

public class RegionsUnexploredItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RegionsUnexploredMod.MOD_ID);

    public static final RegistryObject<Item> BAOBAB_SIGN = ITEMS.register("baobab_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.BAOBAB_SIGN.get(), RegionsUnexploredBlocks.BAOBAB_WALL_SIGN.get()));
    public static final RegistryObject<Item> BLACKWOOD_SIGN = ITEMS.register("blackwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.BLACKWOOD_SIGN.get(), RegionsUnexploredBlocks.BLACKWOOD_WALL_SIGN.get()));
    public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register("cherry_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.CHERRY_SIGN.get(), RegionsUnexploredBlocks.CHERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> CYPRESS_SIGN = ITEMS.register("cypress_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.CYPRESS_SIGN.get(), RegionsUnexploredBlocks.CYPRESS_WALL_SIGN.get()));
    public static final RegistryObject<Item> DEAD_SIGN = ITEMS.register("dead_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.DEAD_SIGN.get(), RegionsUnexploredBlocks.DEAD_WALL_SIGN.get()));
    public static final RegistryObject<Item> EUCALYPTUS_SIGN = ITEMS.register("eucalyptus_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.EUCALYPTUS_SIGN.get(), RegionsUnexploredBlocks.EUCALYPTUS_WALL_SIGN.get()));
    public static final RegistryObject<Item> JOSHUA_SIGN = ITEMS.register("joshua_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.JOSHUA_SIGN.get(), RegionsUnexploredBlocks.JOSHUA_WALL_SIGN.get()));
    public static final RegistryObject<Item> LARCH_SIGN = ITEMS.register("larch_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.LARCH_SIGN.get(), RegionsUnexploredBlocks.LARCH_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.MAPLE_SIGN.get(), RegionsUnexploredBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAUVE_SIGN = ITEMS.register("mauve_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.MAUVE_SIGN.get(), RegionsUnexploredBlocks.MAUVE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PALM_SIGN = ITEMS.register("palm_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.PALM_SIGN.get(), RegionsUnexploredBlocks.PALM_WALL_SIGN.get()));
    public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.PINE_SIGN.get(), RegionsUnexploredBlocks.PINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> REDWOOD_SIGN = ITEMS.register("redwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.REDWOOD_SIGN.get(), RegionsUnexploredBlocks.REDWOOD_WALL_SIGN.get()));
    public static final RegistryObject<Item> SCULKWOOD_SIGN = ITEMS.register("sculkwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.SCULKWOOD_SIGN.get(), RegionsUnexploredBlocks.SCULKWOOD_WALL_SIGN.get()));
    public static final RegistryObject<Item> WILLOW_SIGN = ITEMS.register("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER), RegionsUnexploredBlocks.WILLOW_SIGN.get(), RegionsUnexploredBlocks.WILLOW_WALL_SIGN.get()));

    public static final RegistryObject<Item> BAOBAB_BOAT = ITEMS.register("baobab_boat", () -> new RuBoatItem(RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> BLACKWOOD_BOAT = ITEMS.register("blackwood_boat", () -> new RuBoatItem(RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new RuBoatItem(RuBoat.ModelType.CHERRY, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> CYPRESS_BOAT = ITEMS.register("cypress_boat", () -> new RuBoatItem(RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> DEAD_BOAT = ITEMS.register("dead_boat", () -> new RuBoatItem(RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> EUCALYPTUS_BOAT = ITEMS.register("eucalyptus_boat", () -> new RuBoatItem(RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> JOSHUA_BOAT = ITEMS.register("joshua_boat", () -> new RuBoatItem(RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> LARCH_BOAT = ITEMS.register("larch_boat", () -> new RuBoatItem(RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat", () -> new RuBoatItem(RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> MAUVE_BOAT = ITEMS.register("mauve_boat", () -> new RuBoatItem(RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> PALM_BOAT = ITEMS.register("palm_boat", () -> new RuBoatItem(RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat", () -> new RuBoatItem(RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> REDWOOD_BOAT = ITEMS.register("redwood_boat", () -> new RuBoatItem(RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> SCULKWOOD_BOAT = ITEMS.register("sculkwood_boat", () -> new RuBoatItem(RuBoat.ModelType.SCULKWOOD, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));
    public static final RegistryObject<Item> WILLOW_BOAT = ITEMS.register("willow_boat", () -> new RuBoatItem(RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1).tab(RegionsUnexploredTabs.TAB_REGIONS_UNEXPLORED_OTHER)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
