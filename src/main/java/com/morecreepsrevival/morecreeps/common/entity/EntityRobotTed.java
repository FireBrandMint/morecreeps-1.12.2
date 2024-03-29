package com.morecreepsrevival.morecreeps.common.entity;

import com.morecreepsrevival.morecreeps.common.items.CreepsItemHandler;
import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.pathfinding.NodeProcessor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRobotTed extends EntityCreepBase implements IMob, IEntityCanChangeSize
{

    public int floattimer;

    public EntityRobotTed(World worldIn)
    {
        super(worldIn);

        setCreepTypeName("Robot Ted");

        creatureType = EnumCreatureType.MONSTER;

        setModelSize(2.5f);

        setSize(2.5f * 0.75f, 2.5f * 1.85f);

        baseHealth = (float)rand.nextInt(20) + 25.0f;

        baseSpeed = 0.25d;

        floattimer = 0;

        updateAttributes();


    }

    @Override
    protected void updateTexture()
    {
        setTexture("textures/entity/robotted.png");
    }

    @Override
    protected void initEntityAI()
    {
        clearAITasks();

        NodeProcessor nodeProcessor = getNavigator().getNodeProcessor();

        nodeProcessor.setCanSwim(true);

        nodeProcessor.setCanEnterDoors(true);



        tasks.addTask(1, new EntityAISwimming(this));

        tasks.addTask(2, new EntityAIBreakDoor(this));

        tasks.addTask(3, new EntityAIAttackMelee(this, 1.0d, true));

        tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.5d));

        tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0d));

        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));

        tasks.addTask(6, new EntityAIWatchClosest(this, EntityRobotTodd.class, 8.0f));

        tasks.addTask(6, new EntityAILookIdle(this));

        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

        targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));

        targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityRobotTodd.class, true));
    }

    @Override
    public float getEyeHeight()
    {
        return 2.0f;
    }

    protected void dropItemsOnDeath()
    {
        if (rand.nextInt(5) == 0)
        {
            dropItem(CreepsItemHandler.ram16k, rand.nextInt(3) + 1);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        fallDistance += -1.5f;

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier)
    {
    }

    @Override
    public boolean canBleed() {
        return false;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return CreepsSoundHandler.tedInsultSound;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return CreepsSoundHandler.robotHurtSound;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return CreepsSoundHandler.tedDeadSound;
    }

    @Override
    public float maxShrink() { return 0.6f; }

    @Override
    public float getShrinkRayAmount() { return 0.15f; }

    @Override
    public void onShrink(EntityShrink source) {

    }
    @Override
    public float maxGrowth() {
        return 6.0f;
    }

    @Override
    public float getGrowRayAmount()
    {
        return 0.15F;
    }

    @Override
    public void onGrow(EntityGrow source) {
        this.increaseMoveSpeed(0.15f);
    }
}
