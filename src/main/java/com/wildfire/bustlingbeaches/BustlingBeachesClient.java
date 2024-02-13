package com.wildfire.bustlingbeaches;

import com.wildfire.bustlingbeaches.block.ModBlocks;
import com.wildfire.bustlingbeaches.entity.ModEntities;
import com.wildfire.bustlingbeaches.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class BustlingBeachesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEACHED_SEAGRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIDAL_GROWTH, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.URCHIN, UrchinRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.URCHIN, UrchinModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.BLUEFOOT, BlueFootRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLUEFOOT, BlueFootModel::getTexturedModelData);

    }
}
