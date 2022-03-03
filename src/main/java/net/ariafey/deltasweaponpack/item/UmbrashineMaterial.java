package net.ariafey.deltasweaponpack.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class UmbrashineMaterial implements ToolMaterial {
    public static final UmbrashineMaterial INSTANCE = new UmbrashineMaterial();
    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5;
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
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
