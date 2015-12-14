package com.insane.hardcorewither;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCompressedNetherStar extends ItemBlock {
	
	public ItemBlockCompressedNetherStar(Block block)
	{
		super(block);
		setHasSubtypes(true);
		this.setUnlocalizedName("compressedNetherStar");
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return getUnlocalizedName() + "." + stack.getItemDamage();
	}

}
