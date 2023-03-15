package com.morecreepsrevival.morecreeps.common.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleBreaking;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import java.util.Random;

public class CreepsUtil {
    static final float fullRadian = 3.1415926536F;

    static ParticleBreaking.Factory eatingParticlesFactory = new ParticleBreaking.Factory();

    /**
     * Returns a random 2d position vector.
     */
    public static Vec2f RandomVector2dNormalized (java.util.Random rand)
    {
        //Guliver Jham here, this code does 2 things:
        //it randomises the 2d angle and then turns it into a vector.
        float randfactor = (float)GetRandomUnit(rand);
        float resultangle = fullRadian * randfactor;

        return new Vec2f(MathHelper.cos(resultangle), MathHelper.sin(resultangle));
    }

    /**
     * Returns a random 3d position vector.
     */
    public static Vec3d RandomVector3dNormalized (java.util.Random rand)
    {
        //Guliver Jham here, this code does 2 things:
        //it randomises both vertical and horizontal angles, and then turns them into a vector.
        float randfactorhorizontal = (float)GetRandomUnit(rand);
        float randfactorvertical = (float)GetRandomUnit(rand);
        float horizontalangle = fullRadian * randfactorhorizontal;
        float verticalangle = fullRadian * randfactorvertical;

        return new Vec3d(MathHelper.cos(horizontalangle), MathHelper.cos(verticalangle), MathHelper.sin(horizontalangle));
    }

    /**
     * Returns a number between 0 and 1.
     */
    public static double GetRandomUnit(java.util.Random rand)
    {
        return rand.nextInt(100000) * 0.00001;
    }
    /**
     * Returns a number between -1 and 1.
     */
    public static double GetRandomUnitMinus(java.util.Random rand)
    {
        return (rand.nextInt(200000) - 100000) * 0.00001;
    }

    public static void SpawnEatingParticle(
            World world, double xCoordIn, double yCoordIn, double zCoordIn,
            double xSpeedIn, double ySpeedIn, double zSpeedIn, float size, Item itemFodder)
    {
        if(Minecraft.getMinecraft().isGamePaused()) return;

        Particle toSpawn = eatingParticlesFactory.createParticle(
                -1,
                world,
                xCoordIn,
                yCoordIn,
                zCoordIn,
                xSpeedIn,
                ySpeedIn,
                zSpeedIn,
                Item.getIdFromItem(itemFodder)
        );

        toSpawn.multipleParticleScaleBy(size);

        Minecraft.getMinecraft().effectRenderer.addEffect(toSpawn);
    }

    public static void SpawnEatingParticleRGB(
            World world, double xCoordIn, double yCoordIn, double zCoordIn,
            double xSpeedIn, double ySpeedIn, double zSpeedIn, float size,
            float colorRed, float colorGreen, float colorBlue, Item itemFodder)
    {
        if(Minecraft.getMinecraft().isGamePaused()) return;

        Particle toSpawn = eatingParticlesFactory.createParticle(
                -1,
                world,
                xCoordIn,
                yCoordIn,
                zCoordIn,
                xSpeedIn,
                ySpeedIn,
                zSpeedIn,
                Item.getIdFromItem(itemFodder)
        );

        toSpawn.multipleParticleScaleBy(size);
        toSpawn.setRBGColorF(colorRed, colorGreen, colorBlue);

        Minecraft.getMinecraft().effectRenderer.addEffect(toSpawn);
    }

    public static boolean TryPlaceTorch(World world, BlockPos pos)
    {
        IBlockState basestate = Blocks.TORCH.getDefaultState();
        //Blocks.TORCH.getBlockState().getBaseState().withProperty(BlockTorch.FACING, EnumFacing.DOWN);

        if(!world.isAirBlock(pos)) return false;

        Block block = basestate.getBlock();

        EnumFacing facing = EnumFacing.DOWN;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.NORTH, block))
            facing = EnumFacing.NORTH;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.SOUTH, block))
            facing = EnumFacing.SOUTH;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.WEST, block))
            facing = EnumFacing.WEST;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.EAST, block))
            facing = EnumFacing.EAST;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.UP, block))
            facing = EnumFacing.UP;

        boolean sucess = facing != EnumFacing.DOWN;

        if (sucess) world.setBlockState(pos, basestate.withProperty(BlockTorch.FACING, facing), 2);

        return sucess;
    }

    public static boolean TryPlaceRedstoneTorch(World world, BlockPos pos)
    {
        IBlockState basestate = Blocks.REDSTONE_TORCH.getDefaultState();
        //Blocks.TORCH.getBlockState().getBaseState().withProperty(BlockTorch.FACING, EnumFacing.DOWN);

        if(!world.isAirBlock(pos)) return false;

        Block block = basestate.getBlock();

        EnumFacing facing = EnumFacing.DOWN;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.NORTH, block))
            facing = EnumFacing.NORTH;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.SOUTH, block))
            facing = EnumFacing.SOUTH;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.WEST, block))
            facing = EnumFacing.WEST;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.EAST, block))
            facing = EnumFacing.EAST;

        if(CreepsUtil.CanPlaceTorchOn(world, pos, EnumFacing.UP, block))
            facing = EnumFacing.UP;

        boolean sucess = facing != EnumFacing.DOWN;

        if (sucess) world.setBlockState(pos, basestate.withProperty(BlockTorch.FACING, facing), 2);

        return sucess;
    }

    private static boolean CanPlaceTorchOn(World worldIn, BlockPos pos, EnumFacing facing, Block block)
    {
        EnumFacing enumfacing = facing;
        EnumFacing.Axis enumfacing$axis = enumfacing.getAxis();
        EnumFacing enumfacing1 = enumfacing.getOpposite();
        BlockPos blockpos = pos.offset(enumfacing1);

        IBlockState state = worldIn.getBlockState(pos);

        if (worldIn.getBlockState(blockpos).getBlockFaceShape(worldIn, blockpos, enumfacing) != BlockFaceShape.SOLID)
        {
            return false;
        }

        return true;
    }
}