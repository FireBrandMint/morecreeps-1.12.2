package com.morecreepsrevival.morecreeps.common.entity;

import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.NodeProcessor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class EntityRockMonster extends EntityCreepBase implements IEntityCanChangeSize {

    public EntityRockMonster(World worldIn)
    {
        super(worldIn);

        setCreepTypeName("Rock Monster");
        creatureType = EnumCreatureType.MONSTER;

        setSize(2f, 2f);
        getEntityBoundingBox().offset(0d, 0d, 0d);

        baseSpeed = 0.25d;
        baseHealth = 60f;

        baseAttackDamage = 4f;

        experienceValue = 10;

        updateAttributes();
    }

    @Override
    protected void updateTexture()
    {
        setTexture("textures/entity/rockmonster.png");
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    @Override
    protected void initEntityAI() {
        clearAITasks();

        NodeProcessor nodeProcessor = getNavigator().getNodeProcessor();

        nodeProcessor.setCanSwim(true);

        nodeProcessor.setCanEnterDoors(false);

        tasks.addTask(1, new EntityAISwimming(this));

        tasks.addTask(2, new EntityAIBreakDoor(this));

        tasks.addTask(3, new AIAttackEntity());

        tasks.addTask(4, new EntityAIWander(this, 0.85d));

        tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0d));

        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 24.0f));

        tasks.addTask(6, new EntityAILookIdle(this));

        targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
    }

    public class AIAttackEntity extends EntityAIBase {

        public EntityRockMonster rockM = EntityRockMonster.this;
        public int attackTime;
        public AIAttackEntity() {}

        @Override
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.rockM.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }
        public void updateTask()
        {
            --attackTime;
            EntityLivingBase entitylivingbase = this.rockM.getAttackTarget();
            double d0 = this.rockM.getDistanceSq(entitylivingbase);

            if (d0 < 4.0D)
            {
                if (this.attackTime <= 0)
                {
                    this.attackTime = 10;
                    entitylivingbase.motionX = motionX * 3D;
                    entitylivingbase.motionY = rand.nextFloat() * 2.533F;
                    entitylivingbase.motionZ = motionZ * 3D;
                    this.rockM.attackEntityAsMob(entitylivingbase);
                }

                this.rockM.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }
            else if (d0 < 256.0D)
            {
                this.rockM.getLookHelper().setLookPositionWithEntity(this.rockM.getAttackTarget(), 30.0F, 30.0F);
                this.rockM.getMoveHelper().setMoveTo(this.rockM.getAttackTarget().posX, this.rockM.getAttackTarget().posY, this.rockM.getAttackTarget().posZ, 1.0D);

            }
        }
    }

    @Override
    protected void dropItemsOnDeath()
    {
        if (rand.nextInt(5) == 0)
        {
            dropItem(Item.getItemFromBlock(Blocks.SAND), rand.nextInt(5) + 1);
        }

        if (rand.nextInt(5) == 0)
        {
            dropItem(Item.getItemFromBlock(Blocks.GRAVEL), rand.nextInt(2) + 1);
        }
        if (rand.nextInt(5) == 0)
        {
            dropItem(Item.getItemFromBlock(Blocks.COBBLESTONE), rand.nextInt(4) + 1);
        }
        if (rand.nextInt(20) == 0)
        {
            dropItem(Items.IRON_INGOT, rand.nextInt(3) + 1);
        }
        if (rand.nextInt(20) == 0)
        {
            dropItem(Item.getItemFromBlock(Blocks.MOSSY_COBBLESTONE), 5);
        }
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return CreepsSoundHandler.rockMonster;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return CreepsSoundHandler.rockMonsterHurt;
    }

    @Override
    public float maxShrink() { return 0.4f; }

    @Override
    public float getShrinkRayAmount() { return 0.2f; }

    @Override
    public void onShrink(EntityShrink source) {

    }
    @Override
    public float maxGrowth() {
        return 4.0f;
    }

    @Override
    public float getGrowRayAmount()
    {
        return 0.2F;
    }

    @Override
    public void onGrow(EntityGrow source) {

    }

}
