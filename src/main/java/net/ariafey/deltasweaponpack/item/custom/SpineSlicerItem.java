package net.ariafey.deltasweaponpack.item.custom;

import net.ariafey.deltasweaponpack.util.ModTags;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpineSlicerItem extends SwordItem {
    public SpineSlicerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    
    
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.deltasweaponpack.spine_slicer.spine_slicer_lore"));
        tooltip.add(new TranslatableText("item.deltasweaponpack.spine_slicer.spine_slicer_lore2"));
    }
    
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        if(((ModTags.Entities.EASY_SPINE.contains(target.getType())) || (attacker.getHorizontalFacing().asRotation() >= target.getHorizontalFacing().asRotation() - 20
                && attacker.getHorizontalFacing().asRotation() <= target.getHorizontalFacing().asRotation() +20)) && !(ModTags.Entities.NO_SPINE.contains(target.getType())))
        {
            target.damage(DamageSource.mob(attacker), 32);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 3));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 2));
            // This doesn't seem to work, so its a TODO to make it have more feedback.
            // world.addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, target.getX(), target.getY(), target.getZ(), 0.0, 0.5, 0.0);
            
        }
        return super.postHit(stack, target, attacker);
    }
}
