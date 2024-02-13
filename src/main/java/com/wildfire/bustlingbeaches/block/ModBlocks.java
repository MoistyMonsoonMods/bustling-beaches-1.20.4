package com.wildfire.bustlingbeaches.block;

import com.wildfire.bustlingbeaches.BustlingBeaches;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BEACHED_SEAGRASS = registerBlock("beached_seagrass",
            new CarpetBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CARPET).nonOpaque()));
    public static final Block TIDAL_GROWTH = registerBlock("tidal_growth",
            new GlowLichenBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).nonOpaque()));





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BustlingBeaches.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BustlingBeaches.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        BustlingBeaches.LOGGER.info("Registering Mod Blocks for " + BustlingBeaches.MOD_ID);
    }
}
