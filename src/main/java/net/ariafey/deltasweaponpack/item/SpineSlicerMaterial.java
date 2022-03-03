package net.ariafey.deltasweaponpack.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SpineSlicerMaterial implements ToolMaterial {
    public static final SpineSlicerMaterial INSTANCE = new SpineSlicerMaterial();
    @Override
    public int getDurability() {
        return 1;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3;
    }

    @Override
    public float getAttackDamage() {
        return 0f;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.HAND;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
