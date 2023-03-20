package com.morecreepsrevival.morecreeps.common.items;

import com.morecreepsrevival.morecreeps.common.entity.EntityCreepBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

//OC test item, headwear user
//simply scans headwear, and does something different for each
//from Guliver Jham, trying to test some original shit
//really just a test item, if somebody actually sees this, don't
//expect to see this in survival, i just want to test concepts.

public class HeadwearActivator extends CreepsItem
{
    public HeadwearActivator()
    {
        this("headwear_activator", false);
    }

    public HeadwearActivator(String itemName, boolean noCreativeTab)
    {
        super(itemName, noCreativeTab);

        setMaxStackSize(1);

        setMaxDamage(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        //gets helmet
        //player.inventory.armorInventory.get(0)

        int itemid = Item.getIdFromItem(player.inventory.armorInventory.get(3).getItem());
        //player.sendMessage(new TextComponentString("" + itemid));
        //player.sendMessage(new TextComponentString("" + Item.getIdFromItem(Items.IRON_HELMET)));


        if(itemid == Item.getIdFromItem(Items.IRON_HELMET))
            whenIronHelmet(world, player);

        return super.onItemRightClick(world, player, hand);
    }

    private void whenIronHelmet(World world, EntityPlayer player)
    {
        player.getCooldownTracker().setCooldown(this, 100);

        double xp = player.posX;
        double yp = player.posY;
        double zp = player.posZ;

        double size = 8D;

        List entitieswithin = world.getEntitiesInAABBexcluding(
                player, new AxisAlignedBB(xp - size,  yp, zp - size, xp + size, yp + size, zp + size),
                null
        );

        for (Object o : entitieswithin) {
            Entity curr = (Entity) o;

            if(
                            !curr.isCreatureType(EnumCreatureType.MONSTER, false)
            ) continue;

            curr.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player, curr), 10f);
        }
    }
}
