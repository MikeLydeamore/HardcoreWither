package com.insane.hardcorewither;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=HardcoreWither.MODID, version=HardcoreWither.VERSION)
public class HardcoreWither {
	
	public static final String MODID = "hardcorewither";
	public static final String VERSION = "0.0.1";
	
	@Mod.Instance(MODID)
	public static HardcoreWither instance;
	
	public static Block compressedNetherStarBlock;	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new HandlerWither());
		
		compressedNetherStarBlock = new BlockCompressedNetherStar();
		GameRegistry.registerBlock(compressedNetherStarBlock, ItemBlockCompressedNetherStar.class, "compressedNetherStar");
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(compressedNetherStarBlock),
				new Object[] {"xxx","xxx","xxx", 'x', Items.nether_star});
		for (int i = 0 ; i < 2 ; i++)
		{
			GameRegistry.addRecipe(new ItemStack(compressedNetherStarBlock, 1, i+1), 
					new Object[] {"xxx","xxx","xxx",'x', new ItemStack(compressedNetherStarBlock, 1, i)});
		}
	}
}
