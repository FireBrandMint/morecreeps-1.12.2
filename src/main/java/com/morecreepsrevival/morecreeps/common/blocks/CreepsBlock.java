package com.morecreepsrevival.morecreeps.common.blocks;

import com.morecreepsrevival.morecreeps.common.MoreCreepsAndWeirdos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class CreepsBlock extends Block {

    public CreepsBlock(String blockName, Material material) {
        super(material);
        setBlockName(blockName);
        setCreativeTab(MoreCreepsAndWeirdos.creativeTab);
    }

    public CreepsBlock setBlockName(String blockName) {
        setRegistryName(new ResourceLocation(MoreCreepsAndWeirdos.modid, blockName));
        setUnlocalizedName(MoreCreepsAndWeirdos.modid + "." + blockName);
        return this;
    }
}
