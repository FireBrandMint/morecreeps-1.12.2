package com.morecreepsrevival.morecreeps.common.items;

import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nonnull;

public class ItemVhammer extends CreepsItemSword {

    public ItemVhammer() {
        super("vhammer", ToolMaterial.IRON);
        setMaxDamage(40);
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }
}
