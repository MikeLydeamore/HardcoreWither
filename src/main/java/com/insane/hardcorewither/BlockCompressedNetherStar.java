package com.insane.hardcorewither;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCompressedNetherStar extends Block {
	
	IIcon[] icons = new IIcon[3];
	
	public BlockCompressedNetherStar()
	{
		super(Material.rock);
		this.setBlockName("compressedNetherStar");
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		String base = "hardcorewither:compressednetherstar";
		for (int i = 0 ; i < 3 ; i++)
		{
			icons[i] = register.registerIcon(base+i);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return icons[meta];
	}

}
