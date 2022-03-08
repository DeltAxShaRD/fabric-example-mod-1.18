package net.ariafey.deltasweaponpack.block.custom;

import net.ariafey.deltasweaponpack.block.ModBlocks;
import net.ariafey.deltasweaponpack.sound.ModSounds;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class SpeedyBlock extends Block {
    public SpeedyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient()) {
            int i = 1;
            for(int f = 1; f <= 4 ; f++) {
                if(world.getBlockState(pos.down(i + 1)).getBlock() == ModBlocks.SPEEDY_BLOCK) {
                    i++;
                } else if(!(world.getBlockState(pos.down(i)).getBlock() == ModBlocks.SPEEDY_BLOCK)) {
                    break;
                }
            }
            if(entity instanceof PlayerEntity player) {
                if(!player.hasStatusEffect(StatusEffects.SPEED)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, i));
                }
            }
            if(entity instanceof LivingEntity livingEntity) {
                if(!livingEntity.hasStatusEffect(StatusEffects.SPEED)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, i));
                }
            }
        }
        if(world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(!player.hasStatusEffect(StatusEffects.SPEED)) {
                    world.playSound(player, pos, ModSounds.BOOST, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}


