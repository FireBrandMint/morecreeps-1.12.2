package com.morecreepsrevival.morecreeps.common.items;

import com.morecreepsrevival.morecreeps.common.helpers.CreepsUtil;
import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import com.morecreepsrevival.morecreeps.common.world.JailManager;
import com.morecreepsrevival.morecreeps.common.world.WorldGenCastle;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGemSword extends CreepsItemSword
{
    public ItemGemSword()
    {
        super("gem_sword", ToolMaterial.DIAMOND);

        setMaxDamage(256);
    }

    @Override
    public float getAttackDamage()
    {
        return 25.0f;
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, IBlockState blockState)
    {
        return 55.0f;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockState)
    {
        return true;
    }


    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int itemSlot, boolean isSelected)
    {
        super.onUpdate(itemStack, world, entity, itemSlot, isSelected);

        if (isSelected && entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if (player.isSwingInProgress)
            {
                player.playSound(CreepsSoundHandler.gemSwordSound, getSoundVolume(), getSoundPitch());
            }
        }
    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        BlockPos bpos = new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ);

        //if(!worldIn.isRemote) new WorldGenCastle().generate(worldIn, itemRand, bpos);
        if(!worldIn.isRemote) JailManager.buildJail(playerIn, worldIn, itemRand);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public float getSoundVolume()
    {
        return 0.3f;
    }
}
