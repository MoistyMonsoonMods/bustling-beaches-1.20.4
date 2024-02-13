package com.wildfire.bustlingbeaches.entity.client;

import com.wildfire.bustlingbeaches.BustlingBeaches;
import com.wildfire.bustlingbeaches.entity.custom.UrchinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class UrchinRenderer extends MobEntityRenderer<UrchinEntity, UrchinModel<UrchinEntity>> {
    private static final Identifier TEXTURE = new Identifier(BustlingBeaches.MOD_ID, "textures/entity/urchin.png");

    public UrchinRenderer(EntityRendererFactory.Context context) {
        super(context, new UrchinModel<>(context.getPart(ModModelLayers.URCHIN)),0.6f);
    }

    @Override
    public Identifier getTexture(UrchinEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(UrchinEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
