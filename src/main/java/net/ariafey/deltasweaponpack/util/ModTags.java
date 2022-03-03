package net.ariafey.deltasweaponpack.util;

import net.ariafey.deltasweaponpack.deltasweaponpack;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final Tag.Identified<Block> DOWSING_ROD_DETECTABLE_BLOCKS =
                createTag("dowsing_rod_detectable_blocks");
        public static final Tag.Identified<Block> GOD_BLOCK =
                createCommonTag("god_blocks");
        public static final Tag.Identified<Block> GOD_ORE =
                createCommonTag("god_blocks");
        public static final Tag.Identified<Block> GOD_PRESSURE_PLATE =
                createCommonTag("god_blocks");


        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(deltasweaponpack.MOD_ID, name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {
        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(deltasweaponpack.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
    public static class Entities {
        public static final Tag.Identified<EntityType<?>> NO_SPINE =
                createCommonTag("no_spine");
        public static final Tag.Identified<EntityType<?>> EASY_SPINE =
                createCommonTag("easy_spine");
        
        
        private static Tag.Identified<EntityType<?>> createTag(String name) {
            return TagFactory.ENTITY_TYPE.create(new Identifier(deltasweaponpack.MOD_ID, name));
        }
        private static Tag.Identified<EntityType<?>> createCommonTag(String name) {
            return TagFactory.ENTITY_TYPE.create(new Identifier("c", name));
        }
    }
}
