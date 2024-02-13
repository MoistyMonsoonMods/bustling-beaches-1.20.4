//package com.wildfire.bustlingbeaches.entity.custom;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.LeavesBlock;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.Flutterer;
//import net.minecraft.entity.ai.FuzzyTargeting;
//import net.minecraft.entity.ai.control.FlightMoveControl;
//import net.minecraft.entity.ai.goal.*;
//import net.minecraft.entity.ai.pathing.BirdNavigation;
//import net.minecraft.entity.ai.pathing.EntityNavigation;
//import net.minecraft.entity.ai.pathing.PathNodeType;
//import net.minecraft.entity.attribute.DefaultAttributeContainer;
//import net.minecraft.entity.attribute.EntityAttributes;
//import net.minecraft.entity.mob.MobEntity;
//import net.minecraft.entity.mob.PathAwareEntity;
//import net.minecraft.entity.passive.AnimalEntity;
//import net.minecraft.entity.passive.PassiveEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.registry.tag.BlockTags;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.util.math.*;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//
//public class BlueFootEntity extends AnimalEntity implements Flutterer {
//
//    public BlueFootEntity(EntityType<? extends AnimalEntity> entityType, World world) {
//        super(entityType, world);
//        this.moveControl = new FlightMoveControl(this, 10, false);
//        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0f);
//        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0f);
//    }
//    public float flapProgress;
//    public float maxWingDeviation;
//    public float prevMaxWingDeviation;
//    public float prevFlapProgress;
//    private float flapSpeed = 1.0f;
//    private float field_28640 = 1.0f;
//
//    @Override
//    protected void initGoals() {
//        this.goalSelector.add(0, new SwimGoal(this));
//        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
//        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
//        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
//        this.goalSelector.add(4, new LookAroundGoal(this));
//    }
//
//    public static DefaultAttributeContainer.Builder createBlueFootAttributes() {
//        return MobEntity.createMobAttributes()
//                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
//                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
//                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.4)
//                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
//    }
//
//    @Override
//    public void tickMovement() {
//        super.tickMovement();
//        this.flapWings();
//    }
//
//    private void flapWings() {
//        this.prevFlapProgress = this.flapProgress;
//        this.prevMaxWingDeviation = this.maxWingDeviation;
//        this.maxWingDeviation += (float)(this.isOnGround() || this.hasVehicle() ? -1 : 4) * 0.3f;
//        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0f, 1.0f);
//        if (!this.isOnGround() && this.flapSpeed < 1.0f) {
//            this.flapSpeed = 1.0f;
//        }
//        this.flapSpeed *= 0.9f;
//        Vec3d vec3d = this.getVelocity();
//        if (!this.isOnGround() && vec3d.y < 0.0) {
//            this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
//        }
//        this.flapProgress += this.flapSpeed * 2.0f;
//    }
//
//    @Override
//    public boolean isInAir() {
//        return !this.isOnGround();
//    }
//
//    @Override
//    protected boolean isFlappingWings() {
//        return this.speed > this.field_28640;
//    }
//
//    @Override
//    protected void addFlapEffects() {
//        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15f, 1.0f);
//        this.field_28640 = this.speed + this.maxWingDeviation / 2.0f;
//    }
//
//    @Override
//    public EntityNavigation createNavigation(World world) {
//        BirdNavigation birdNavigation = new BirdNavigation(this, world);
//        birdNavigation.setCanPathThroughDoors(false);
//        birdNavigation.setCanSwim(true);
//        birdNavigation.setCanEnterOpenDoors(true);
//        return birdNavigation;
//    }
//    @Override
//    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
//    }
//
//
//    @Nullable
//    @Override
//    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
//        return null;
//    }
//
//    static class FlyOntoTreeGoal
//            extends FlyGoal {
//        public FlyOntoTreeGoal(PathAwareEntity pathAwareEntity, double d) {
//            super(pathAwareEntity, d);
//        }
//
//        @Override
//        @Nullable
//        protected Vec3d getWanderTarget() {
//            Vec3d vec3d = null;
//            if (this.mob.isTouchingWater()) {
//                vec3d = FuzzyTargeting.find(this.mob, 15, 15);
//            }
//            if (this.mob.getRandom().nextFloat() >= this.probability) {
//                vec3d = this.locateTree();
//            }
//            return vec3d == null ? super.getWanderTarget() : vec3d;
//        }
//
//        @Nullable
//        private Vec3d locateTree() {
//            BlockPos blockPos = this.mob.getBlockPos();
//            BlockPos.Mutable mutable = new BlockPos.Mutable();
//            BlockPos.Mutable mutable2 = new BlockPos.Mutable();
//            Iterable<BlockPos> iterable = BlockPos.iterate(MathHelper.floor(this.mob.getX() - 3.0), MathHelper.floor(this.mob.getY() - 6.0), MathHelper.floor(this.mob.getZ() - 3.0), MathHelper.floor(this.mob.getX() + 3.0), MathHelper.floor(this.mob.getY() + 6.0), MathHelper.floor(this.mob.getZ() + 3.0));
//            for (BlockPos blockPos2 : iterable) {
//                BlockState blockState;
//                boolean bl;
//                if (blockPos.equals(blockPos2) || !(bl = (blockState = this.mob.getWorld().getBlockState(mutable2.set((Vec3i) blockPos2, Direction.DOWN))).getBlock() instanceof LeavesBlock || blockState.isIn(BlockTags.LOGS)) || !this.mob.getWorld().isAir(blockPos2) || !this.mob.getWorld().isAir(mutable.set((Vec3i) blockPos2, Direction.UP)))
//                    continue;
//                return Vec3d.ofBottomCenter(blockPos2);
//            }
//            return null;
//        }
//    }
//}
//


