package com.morecreepsrevival.morecreeps.proxy;

import com.morecreepsrevival.morecreeps.client.particles.FxFoam;
import com.morecreepsrevival.morecreeps.client.particles.FxPee;
import com.morecreepsrevival.morecreeps.common.command.LevelUpTamedCreature;
import com.morecreepsrevival.morecreeps.common.items.CreepsItemHandler;
import com.morecreepsrevival.morecreeps.client.render.*;
import com.morecreepsrevival.morecreeps.common.entity.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityGuineaPig.class, new RenderGuineaPigFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityTombstone.class, new RenderTombstoneFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityTrophy.class, new RenderTrophyFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBabyMummy.class, new RenderBabyMummyFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBlackSoul.class, new RenderBlackSoulFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummyFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityGooGoat.class, new RenderGooGoatFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityKid.class, new RenderKidFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityLolliman.class, new RenderLollimanFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPyramidGuardian.class, new RenderPyramidGuardianFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityGooDonut.class, new RenderCreepsItemFactory(CreepsItemHandler.gooDonut));

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilCreature.class, new RenderEvilCreatureFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityCastleCritter.class, new RenderCastleCritterFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityCastleGuard.class, new RenderCastleGuardFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityCastleKing.class, new RenderCastleKingFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityG.class, new RenderGFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRobotTodd.class, new RenderRobotToddFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRobotTed.class, new RenderRobotTedFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityLawyerFromHell.class, new RenderLawyerFromHellFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityMoney.class, new RenderCreepsItemFactory(CreepsItemHandler.money));

        RenderingRegistry.registerEntityRenderingHandler(EntityBigBaby.class, new RenderBigBabyFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityShrink.class, new RenderCreepsItemFactory(CreepsItemHandler.shrinkShrink));

        RenderingRegistry.registerEntityRenderingHandler(EntitySchlump.class, new RenderSchlumpFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRay.class, new RenderCreepsItemFactory(CreepsItemHandler.rayRay));

        RenderingRegistry.registerEntityRenderingHandler(EntityDevRay.class, new RenderCreepsItemFactory(CreepsItemHandler.dev_rayRay));

        RenderingRegistry.registerEntityRenderingHandler(EntityThief.class, new RenderThiefFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityFloob.class, new RenderFloobFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityFloobShip.class, new RenderFloobShipFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityHorseHead.class, new RenderHorseHeadFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityHotdog.class, new RenderHotdogFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityDigBug.class, new RenderDigBugFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBubbleScum.class, new RenderBubbleScumFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRatMan.class, new RenderRatManFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntitySneakySal.class, new RenderSneakySalFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPrisoner.class, new RenderPrisonerFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderCreepsItemFactory(CreepsItemHandler.bulletBullet));

        RenderingRegistry.registerEntityRenderingHandler(EntitySnowDevil.class, new RenderSnowDevilFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilChicken.class, new RenderEvilChickenFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilPig.class, new RenderEvilPigFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityDogHouse.class, new RenderDogHouseFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBlorp.class, new RenderBlorpFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityCamel.class, new RenderCamelFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityZebra.class, new RenderZebraFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRocketGiraffe.class, new RenderRocketGiraffeFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilScientist.class, new RenderEvilScientistFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityFrisbee.class, new RenderCreepsItemFactory(CreepsItemHandler.frisbee));

        RenderingRegistry.registerEntityRenderingHandler(EntityManDog.class, new RenderManDogFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityCaveman.class, new RenderCavemanFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilLight.class, new RenderEvilLightFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilEgg.class, new RenderCreepsItemFactory(CreepsItemHandler.evilEgg));

        RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderCreepsItemFactory(CreepsItemHandler.rocket));

        RenderingRegistry.registerEntityRenderingHandler(EntityHunchback.class, new RenderHunchbackFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityHunchbackSkeleton.class, new RenderHunchbackSkeletonFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityBum.class, new RenderBumFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityEvilSnowman.class, new RenderEvilSnowmanFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPreacher.class, new RenderPreacherFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityGrowbotGregg.class, new RenderGrowbotGreggFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityGrow.class, new RenderCreepsItemFactory(CreepsItemHandler.shrinkShrink));

        RenderingRegistry.registerEntityRenderingHandler(EntityCamelJockey.class, new RenderCamelJockeyFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPonyGirl.class, new RenderPonyGirlFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityInvisibleMan.class, new RenderInvisibleManFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPonyCloud.class, new RenderPonyCloudFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityPony.class, new RenderPonyFactory());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new LevelUpTamedCreature());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Override
    public boolean isJumpKeyDown(EntityPlayer player)
    {
        return Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode());
    }

    @Override
    public void pee(EntityCreepBase entity)
    {
        double d = -MathHelper.sin((entity.rotationYaw * (float)Math.PI) / 180.0f);

        double d1 = MathHelper.cos((entity.rotationYaw * (float)Math.PI) / 180.0f);

        for (int i = 0; i < 25; i++)
        {
            FxPee pee = new FxPee(entity.world, entity.posX + d * 0.20000000000000001d, (entity.posY + 0.75d) - (double)((1.0f - entity.getModelSize()) * 0.8f), entity.posZ + d1 * 0.20000000000000001d, 0.0d, 0.0d, 0.0d, d, d1);

            Minecraft.getMinecraft().effectRenderer.addEffect(pee);
        }
    }
    public void foam(EntityPlayer entity) {
        Vec3d vec3 = entity.getLookVec();
        vec3.scale(0.5);
        double r = Math.sqrt(vec3.x * vec3.x + vec3.y * vec3.y + vec3.z * vec3.z);
        double theta = (double)(entity.rotationPitch * 3.1415927F / 180.0F);
        double phi = (double)(entity.rotationYaw * 3.1415927F / 180.0F);
        double d = r * (double)(-MathHelper.sin((float)phi)) * (double)MathHelper.cos((float)theta);
        double d1 = r * (double)(-MathHelper.sin((float)theta));
        double d2 = r * (double)MathHelper.cos((float)phi) * (double)MathHelper.cos((float)theta);
        double[] motion = new double[]{entity.motionX, entity.motionY, entity.motionZ};

        for(int i = 0; i < 20; ++i) {
            FxFoam foam = new FxFoam(entity.world, entity.posX + motion[0] + vec3.x, entity.posY + motion[1] + vec3.y + 1.75, entity.posZ + motion[2] + vec3.z, 1.2, 1.2, 1.2, d, d1, d2);
            foam.multipleParticleScaleBy(5.0F);
            foam.multiplyVelocity(3.0F);
            Minecraft.getMinecraft().effectRenderer.addEffect(foam);
        }

    }

    public void foame(EntityExtinguisherSmoke entity) {
        Vec3d vec3 = entity.getLookVec();
        vec3.scale(0.5);
        double r = Math.sqrt(vec3.x * vec3.x + vec3.y * vec3.y + vec3.z * vec3.z);
        double theta = (double)(entity.rotationPitch * 3.1415927F / 180.0F);
        double phi = (double)(entity.rotationYaw * 3.1415927F / 180.0F);
        double d = r * (double)(-MathHelper.sin((float)phi)) * (double)MathHelper.cos((float)theta);
        double d1 = r * (double)(-MathHelper.sin((float)theta));
        double d2 = r * (double)MathHelper.cos((float)phi) * (double)MathHelper.cos((float)theta);
        double random_d = Math.floor(Math.random() * 1.4 - 0.2);
        double random_d1 = Math.floor(Math.random() * 1.4 - 0.2);
        double random_d2 = Math.floor(Math.random() * 1.4 - 0.2);
        d += random_d;
        d1 += random_d1;
        d2 += random_d2;
        double[] motion = new double[]{entity.motionX, entity.motionY, entity.motionZ};

        for(int i = 0; i < 5; ++i) {
            FxFoam foam = new FxFoam(entity.world, entity.posX + motion[0] + vec3.x, entity.posY + motion[1] + vec3.y, entity.posZ + motion[2] + vec3.z, 1.2, 1.2, 1.2, d, d1, d2);
            foam.multipleParticleScaleBy(2.5F);
            foam.multiplyVelocity(1.4F);
            Minecraft.getMinecraft().effectRenderer.addEffect(foam);
        }

    }
}
