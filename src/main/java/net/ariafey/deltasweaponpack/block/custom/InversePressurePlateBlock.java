package net.ariafey.deltasweaponpack.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InversePressurePlateBlock extends PressurePlateBlock {
    private final ActivationRule mytype;
    public InversePressurePlateBlock(ActivationRule mytype, Settings settings) {
        super(mytype, settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(POWERED, true));
        this.mytype = mytype;
    }

    @Override
    protected void playPressSound(WorldAccess world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 0.3f, 1.5f);
    }

    @Override
    protected void playDepressSound(WorldAccess world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 0.3f, 1.7f);
    }

    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        List<Entity> list;
        Box box = BOX.offset(pos);
        switch (this.mytype) {
            case EVERYTHING: {
                list = world.getOtherEntities(null, box);
                break;
            }
            default: {
                return 15;
            }
        }
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity.canAvoidTraps()) continue;
                return 0;
            }
        }
        return 15;
    }

    @Override
    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return (BlockState)state.with(POWERED, rsOut > 0);
    }

    @Override
    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) != false ? 0 : 15;
    }
    
    @Override
    protected void updatePlateState(@Nullable Entity entity, World world, BlockPos pos, BlockState state, int output) {
        boolean bl2;
        int i = this.getRedstoneOutput(world, pos);
        boolean bl = output < 15;
        boolean bl3 = bl2 = i < 15;
        if (output != i) {
            BlockState blockState = this.setRedstoneOutput(state, i);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            this.updateNeighbors(world, pos);
            world.scheduleBlockRerenderIfNeeded(pos, state, blockState);
        }
        if (!bl2 && bl) {
            this.playDepressSound(world, pos);
            world.emitGameEvent(entity, GameEvent.BLOCK_UNPRESS, pos);
        } else if (bl2 && !bl) {
            this.playPressSound(world, pos);
            world.emitGameEvent(entity, GameEvent.BLOCK_PRESS, pos);
        }
        if (bl2) {
            world.createAndScheduleBlockTick(new BlockPos(pos), this, this.getTickRate());
        }
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient) {
            return;
        }
        int i = this.getRedstoneOutput(state);
        if (i == 15) {
            this.updatePlateState(entity, world, pos, state, i);
        }
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (moved || state.isOf(newState.getBlock())) {
            return;
        }
        if (this.getRedstoneOutput(state) < 15) {
            this.updateNeighbors(world, pos);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}