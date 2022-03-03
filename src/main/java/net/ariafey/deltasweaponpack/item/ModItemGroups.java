package net.ariafey.deltasweaponpack.item;

import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DELTA_STUFF = FabricItemGroupBuilder.build(new Identifier(deltasweaponpack.MOD_ID, "delta_stuff"),
            () -> new ItemStack(ModItems.GOD_INGOT));
}
