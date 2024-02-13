package com.wildfire.bustlingbeaches.entity.client;

import com.wildfire.bustlingbeaches.BustlingBeaches;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer URCHIN =
            new EntityModelLayer(new Identifier(BustlingBeaches.MOD_ID, "urchin"), "main");

    public static final EntityModelLayer BLUEFOOT =
            new EntityModelLayer(new Identifier(BustlingBeaches.MOD_ID, "bluefoot"),"main");
}
