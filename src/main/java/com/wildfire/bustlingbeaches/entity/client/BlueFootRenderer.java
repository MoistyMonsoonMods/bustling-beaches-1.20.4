package com.wildfire.bustlingbeaches.entity.client;

import com.wildfire.bustlingbeaches.BustlingBeaches;
import com.wildfire.bustlingbeaches.entity.custom.BlueFootEntity;
import com.wildfire.bustlingbeaches.entity.custom.UrchinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BlueFootRenderer extends MobEntityRenderer<BlueFootEntity, BlueFootModel<BlueFootEntity>> {
    private static final Identifier TEXTURE = new Identifier(BustlingBeaches.MOD_ID, "textures/entity/blue_foot.png");

    public BlueFootRenderer(EntityRendererFactory.Context context) {
        super(context, new BlueFootModel<>(context.getPart(ModModelLayers.BLUEFOOT)),0.4f);
    }

    @Override
    public Identifier getTexture(BlueFootEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BlueFootEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}