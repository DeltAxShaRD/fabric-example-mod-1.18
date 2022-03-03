package net.ariafey.deltasweaponpack.item;

import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.ariafey.deltasweaponpack.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item GOD_INGOT = registerItem("god_ingot",
            new Item(new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).fireproof()));
    
    public static final Item AZALS_GEMSTONE = registerItem("azals_gemstone",
            new Item(new FabricItemSettings().group(ModItemGroups.DELTA_STUFF)));

    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).maxDamage(64)));

    public static final Item UMBRASHINE = registerItem("umbrashine",
            new UmbrashineSwordItem(UmbrashineMaterial.INSTANCE, 249, -2f, new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).fireproof().rarity(Rarity.EPIC).maxCount(1)));

    public static final Item CHERRY = registerItem("cherry",
            new Item(new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).food(ModFoodComponents.CHERRY)));

    public static final Item CREATIVEFUEL = registerItem("creative_fuel",
            new Item(new FabricItemSettings().group(ModItemGroups.DELTA_STUFF)));

    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DowsingRodTabletItem(new FabricItemSettings().maxCount(1).group(ModItemGroups.DELTA_STUFF)));
    
    public static final Item SPINE_SLICER = registerItem("spine_slicer",
            new SpineSlicerItem(SpineSlicerMaterial.INSTANCE, 2, -2f, new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).maxCount(1).rarity(Rarity.UNCOMMON).maxDamage(600)));
    
    public static final Item DEATH_SCYTHE = registerItem("death_scythe",
            new DeathScytheItem(DeathScytheMaterial.INSTANCE, 19, -3.5f, new FabricItemSettings().group(ModItemGroups.DELTA_STUFF).maxCount(1).rarity(Rarity.RARE).maxDamage(200)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(deltasweaponpack.MOD_ID, name), item);
    }
    public static void registerModItems() {
        deltasweaponpack.LOGGER.info("Registering Mod Items for " + deltasweaponpack.MOD_ID);
    }
}
