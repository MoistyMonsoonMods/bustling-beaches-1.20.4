package com.wildfire.bustlingbeaches;

import com.wildfire.bustlingbeaches.block.ModBlocks;
import com.wildfire.bustlingbeaches.entity.ModEntities;
import com.wildfire.bustlingbeaches.entity.custom.BlueFootEntity;
import com.wildfire.bustlingbeaches.entity.custom.UrchinEntity;
import com.wildfire.bustlingbeaches.item.ModItemGroups;
import com.wildfire.bustlingbeaches.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BustlingBeaches implements ModInitializer {
	public static final String MOD_ID = "bustlingbeaches";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.URCHIN, UrchinEntity.createUrchinAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLUEFOOT, BlueFootEntity.createBlueFootAttributes());
	}
}