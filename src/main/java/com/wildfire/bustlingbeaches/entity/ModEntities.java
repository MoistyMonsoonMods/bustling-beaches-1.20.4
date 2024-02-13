package com.wildfire.bustlingbeaches.entity;

import com.wildfire.bustlingbeaches.BustlingBeaches;
import com.wildfire.bustlingbeaches.entity.custom.BlueFootEntity;
import com.wildfire.bustlingbeaches.entity.custom.UrchinEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<UrchinEntity> URCHIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BustlingBeaches.MOD_ID, "urchin"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, UrchinEntity::new).dimensions(EntityDimensions.fixed(1f,1f)).build());

    public static final EntityType<BlueFootEntity> BLUEFOOT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BustlingBeaches.MOD_ID, "bluefoot"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BlueFootEntity::new).dimensions(EntityDimensions.fixed(0.5f,1f)).build());


    public static void registerModEntities() {
        BustlingBeaches.LOGGER.info("Registering Entities for " + BustlingBeaches.MOD_ID);
    }

}


