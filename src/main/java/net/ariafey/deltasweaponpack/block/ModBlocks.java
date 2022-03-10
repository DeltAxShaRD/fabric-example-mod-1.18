package net.ariafey.deltasweaponpack.block;

// Why is this broken? import net.ariafey.deltasweaponpack.block.custom.InversePressurePlateBlock;

import net.ariafey.deltasweaponpack.block.custom.JumpPad;
import net.ariafey.deltasweaponpack.block.custom.SpeedyBlock;
import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.ariafey.deltasweaponpack.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    
    public static final Block GOD_BLOCK = registerBlock("god_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f).sounds(BlockSoundGroup.METAL).requiresTool()), ModItemGroups.DELTA_STUFF);
    public static final Block GOD_ORE = registerBlock("god_ore",
            new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.DEEPSLATE).strength(6f).requiresTool()), ModItemGroups.DELTA_STUFF);
    public static final Block DEEPSLATE_AZAL_ORE = registerBlock("deepslate_azal_ore",
            new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.DEEPSLATE).strength(5.5f).requiresTool().luminance(4)), ModItemGroups.DELTA_STUFF);
    public static final Block AZAL_ORE = registerBlock("azal_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool().luminance(2)), ModItemGroups.DELTA_STUFF);
    public static final Block AZAL_GEMSTONE_BLOCK = registerBlock("azal_gemstone_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).sounds(BlockSoundGroup.METAL).requiresTool()), ModItemGroups.DELTA_STUFF);
    
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.SPONGE).strength(0f).sounds(BlockSoundGroup.SHROOMLIGHT)), ModItemGroups.DELTA_STUFF);
    public static final Block JUMP_PAD = registerBlock("jump_pad",
            new JumpPad(FabricBlockSettings.of(Material.SPONGE).strength(0f).sounds(BlockSoundGroup.SHROOMLIGHT)), ModItemGroups.DELTA_STUFF);
    
    //TODO - make this damn thing work.
    //public static final Block GOD_PRESSURE_PLATE = registerBlock("god_pressure_plate",
    //new InversePressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
    //FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroups.DELTA_STUFF);
    
    
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(deltasweaponpack.MOD_ID, name), block);
    }
    
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(deltasweaponpack.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    
    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for " + deltasweaponpack.MOD_ID);
        
    }
}
