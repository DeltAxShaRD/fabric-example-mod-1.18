package net.ariafey.deltasweaponpack.block.custom;

import net.ariafey.deltasweaponpack.block.ModBlocks;
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
                double d = 1;
                for(int i = 1; i <= 4 ; i++) {
                    if(world.getBlockState(pos.down(i + 1)).getBlock() == ModBlocks.JUMP_PAD) {
                        d++;
                    } else if(!(world.getBlockState(pos.down(i)).getBlock() == ModBlocks.JUMP_PAD)) {
                        break;
                    }
                }
                livingEntity.addVelocity(0.0, 1 + (d / 8), 0.0);
            }
        }
        if(world.isClient) {
            if (entity instanceof LivingEntity livingEntity) {
                world.playSoundFromEntity(null, livingEntity, ModSounds.JUMP, SoundCategory.BLOCKS, 1f, 1f);
            }
            if (entity instanceof PlayerEntity player) {
                double d = 1;
                for(int i = 0; i <= 4 ; i++) {
                    if(world.getBlockState(pos.down(i + 1)).getBlock() == ModBlocks.JUMP_PAD) {
                        d++;
                    } else if(!(world.getBlockState(pos.down(i)).getBlock() == ModBlocks.JUMP_PAD)) {
                        break;
                    }
                }
                player.addVelocity(0.0, 1 + (d / 8), 0.0); //This is pretty dumb, you need to be on client to change a player's velocity?
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



