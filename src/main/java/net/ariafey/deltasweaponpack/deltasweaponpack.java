package net.ariafey.deltasweaponpack;

import net.ariafey.deltasweaponpack.block.ModBlocks;
import net.ariafey.deltasweaponpack.effect.ModEffects;
import net.ariafey.deltasweaponpack.item.ModItems;
import net.ariafey.deltasweaponpack.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class deltasweaponpack implements ModInitializer {
	public static final String MOD_ID = "deltasweaponpack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModEffects.registerEffects();

		LOGGER.info("Nice! Thanks for installing DWP!");
	}
}
