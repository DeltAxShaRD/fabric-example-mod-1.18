package net.ariafey.deltasweaponpack.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.ariafey.deltasweaponpack.item.ModItems.UMBRASHINE;

public class UmbrashineSwordItem extends SwordItem {

    private static int lightningnumber;
    private static int lightningX;
    private static int lightningY;
    private static int lightningZ;
    private static int h;

    public UmbrashineSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (player.getMainHandStack().getItem() == UMBRASHINE) {
                    //TODO, add attributes here
                }

            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.deltasweaponpack.umbrashine.umbrashine_lore"));
        tooltip.add(new TranslatableText("item.deltasweaponpack.umbrashine.umbrashine_lore2"));
        tooltip.add(new TranslatableText("item.deltasweaponpack.umbrashine.umbrashine_lore3"));
        tooltip.add(new TranslatableText("item.deltasweaponpack.umbrashine.umbrashine_lore4"));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        assert player != null;
        if(player.getPitch() <= 90 && player.getPitch() >= 70) {
            LightningWave(context);
        }
        return(super.useOnBlock(context));
    }

    private void LightningWave(ItemUsageContext context) {
        lightningnumber = 5; //How many blocks it starts away from the player. I use 5 to avoid self damage. (unless you move that is ;) )
        PlayerEntity player = context.getPlayer();
        assert player != null;
        World world = context.getWorld();

        lightningX = player.getBlockX();
        lightningY = player.getBlockY();
        lightningZ = player.getBlockZ();
        Runnable runnable2 = () -> {
            if (world.isRaining()) {
                h = 10;
            } else {
                h = 5;
            }
            for(int i = 0; i<= h; i++) {
                try {
                    Thread t = Thread.currentThread();
                    System.out.println("Runnable: " + t);
                    LightningStrike(player, world);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(runnable2);
        t.start();




        player.getItemCooldownManager().set(this, 100);
    }

    private static void LightningStrike(PlayerEntity player, World world) {
        //God this took me so long to figure out, if you haven't noticed by now, I'm a beginner. This is my first mod that I coded by hand.
        LightningEntity Bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        Bolt.setPosition((lightningX + lightningnumber), (lightningY + 100), lightningZ);
        for (int i = 1; i <= 200; i++) {
            Block blockBelow = world.getBlockState(Bolt.getBlockPos().down(i)).getBlock();
            if (blockBelow != Blocks.AIR && blockBelow != Blocks.VOID_AIR && blockBelow != Blocks.CAVE_AIR) {
                Bolt.setPosition(Bolt.getX(),  Bolt.getY() - i, Bolt.getZ());
                break;
            }
        }
        world.spawnEntity(Bolt);
        LightningEntity Bolt2 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        Bolt2.setPosition((lightningX - lightningnumber), lightningY + 100, lightningZ);
        for (int i = 1; i <= 200; i++) {
            Block blockBelow = world.getBlockState(Bolt2.getBlockPos().down(i)).getBlock();
            if (blockBelow != Blocks.AIR && blockBelow != Blocks.VOID_AIR && blockBelow != Blocks.CAVE_AIR) {
                Bolt2.setPosition(Bolt2.getX(),  Bolt2.getY() - i, Bolt2.getZ());
                break;
            }
        }
        world.spawnEntity(Bolt2);
        LightningEntity Bolt3 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        Bolt3.setPosition(lightningX, lightningY + 100, (lightningZ + lightningnumber));
        for (int i = 1; i <= 200; i++) {
            Block blockBelow = world.getBlockState(Bolt3.getBlockPos().down(i)).getBlock();
            if (blockBelow != Blocks.AIR && blockBelow != Blocks.VOID_AIR && blockBelow != Blocks.CAVE_AIR) {
                Bolt3.setPosition(Bolt3.getX(),  Bolt3.getY() - i, Bolt3.getZ());
                break;
            }
        }
        world.spawnEntity(Bolt3);
        LightningEntity Bolt4 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        Bolt4.setPosition(lightningX, lightningY + 100, (lightningZ - lightningnumber));
        for (int i = 1; i <= 200; i++) {
            Block blockBelow = world.getBlockState(Bolt4.getBlockPos().down(i)).getBlock();
            if (blockBelow != Blocks.AIR && blockBelow != Blocks.VOID_AIR && blockBelow != Blocks.CAVE_AIR) {
                Bolt4.setPosition(Bolt4.getX(),  Bolt4.getY() - i, Bolt4.getZ());
                break;
            }
        }
        world.spawnEntity(Bolt4);
        lightningnumber = lightningnumber + 2;
    }


    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

}
