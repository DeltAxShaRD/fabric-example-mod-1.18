package net.ariafey.deltasweaponpack.util;

import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.ariafey.deltasweaponpack.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        System.out.println("Registering Fuels for " + deltasweaponpack.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.CREATIVEFUEL, 1000000);

    }
}
