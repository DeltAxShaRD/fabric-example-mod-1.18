package net.ariafey.deltasweaponpack.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeathScytheItem extends SwordItem {
    public DeathScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    boolean HasSoul;
    LivingEntity Soul;
    
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!(Soul == null)) {
            HasSoul = true;
        } else {
            HasSoul = false;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    
    @Override
    public boolean hasGlint(ItemStack stack) {
        return HasSoul;
    }
    
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.deathTime >= 1) {
            Soul = target;
        }
        return super.postHit(stack, target, attacker);
    }
    
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Soul != null) {
            String soulType = Soul.getName().getString();
            tooltip.add(new LiteralText(soulType));
        }
    }
    
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        if(!world.isClient()) {
            if (Soul != null) {
                world.spawnEntity(Soul);
                stack.damage(1, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
        }
        return super.useOnBlock(context);
    }
}
