package net.ariafey.deltasweaponpack.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent CHERRY = new FoodComponent.Builder().hunger(2).saturationModifier(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100), 1f).build();
}
