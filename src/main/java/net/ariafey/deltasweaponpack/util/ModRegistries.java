package net.ariafey.deltasweaponpack.util;

import net.ariafey.deltasweaponpack.command.ReturnHomeCommand;
import net.ariafey.deltasweaponpack.command.SetHomeCommand;
import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.ariafey.deltasweaponpack.event.ModPlayerEventCopyFrom;
import net.ariafey.deltasweaponpack.item.ModItems;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModStuffs() {
        registerFuels();
        registerCommands();
        registerEvents();
    }

    private static void registerFuels() {
        System.out.println("Registering Fuels for " + deltasweaponpack.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.CREATIVEFUEL, 1000000);
        
    }
    
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
    
    
    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
