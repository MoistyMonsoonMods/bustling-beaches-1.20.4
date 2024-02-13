package com.wildfire.bustlingbeaches.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class UrchinEntity extends WaterCreatureEntity {
    public UrchinEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }

    static final TargetPredicate ATTACK_PREDICATE = TargetPredicate.createNonAttackable().ignoreDistanceScalingFactor().ignoreVisibility();

    public void tickMovement() {
        super.tickMovement();
        if (this.isAlive()) {
            List<MobEntity> list = this.getWorld().getEntitiesByClass(MobEntity.class, this.getBoundingBox().expand(0.3), entity -> ATTACK_PREDICATE.test(this, (LivingEntity)entity));
            for (MobEntity mobEntity : list) {
                if (!mobEntity.isAlive()) continue;
                this.sting(mobEntity);
            }
        }
    }

    private void sting(MobEntity mob) {
        if (mob.damage(this.getDamageSources().mobAttack(this), 1)) {
            mob.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60 , 0), this);
            this.playSound(SoundEvents.ENTITY_PUFFER_FISH_STING, 1.0f, 1.0f);
        }
    }

    public void onPlayerCollision(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity && player.damage(this.getDamageSources().mobAttack(this), 1)) {
            if (!this.isSilent()) {
                ((ServerPlayerEntity)player).networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PUFFERFISH_STING, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60 * 3, 0), this);
        }
    }


    public boolean isCollidable() {
        return this.isAlive();
    }

    public static DefaultAttributeContainer.Builder createUrchinAttributes() {
        return MobEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 1);
    }


}
