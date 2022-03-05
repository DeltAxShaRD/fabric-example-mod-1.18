package net.ariafey.deltasweaponpack.block.custom;

import net.ariafey.deltasweaponpack.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class JumpPad extends Block {
    public JumpPad(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient) {
            if(entity instanceof LivingEntity livingEntity) {
                livingEntity.addVelocity(0.0, 1.25, 0.0);
            }
        }
        if(world.isClient) {
            if (entity instanceof LivingEntity livingEntity) {
                world.playSoundFromEntity(null, livingEntity, ModSounds.JUMP, SoundCategory.BLOCKS, 1f, 1f);
            }
            if (entity instanceof PlayerEntity player) {
                player.addVelocity(0.0, 1.25, 0.0); //This is pretty dumb, you need to be on client to change a player's velocity?
                world.playSound(player, pos, ModSounds.JUMP, SoundCategory.BLOCKS, 1f, 1f);
                
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0f, DamageSource.FALL);
        }
    }
}



