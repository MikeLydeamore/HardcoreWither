package com.insane.hardcorewither;

import java.util.UUID;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class HandlerWither {
	
	private static float increaseHealthAmount = 600;
	
	private static UUID addHealthUUID = UUID.fromString("5ce6bafc-a0c7-4b45-93e3-ac27991e6f83");
	private static AttributeModifier addHealth = new AttributeModifier(addHealthUUID,
			"addWitherHealth", increaseHealthAmount, 0);
	
	@SubscribeEvent
	public void onWitherJoin(EntityJoinWorldEvent event)
	{
		if (event.entity != null && event.entity instanceof EntityWither)
		{
			EntityWither wither = (EntityWither) event.entity;
			if (wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).getModifier(addHealthUUID) == null)
			{
				wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(addHealth);
				wither.setHealth(wither.getHealth() + increaseHealthAmount);
			}
		}
	}
	
	private static int maxDamageAmount = 20;
	
	@SubscribeEvent
	public void onWitherDamaged(LivingHurtEvent event)
	{
		if (event.entity != null && event.entity instanceof EntityWither && event.ammount > maxDamageAmount)
		{
			event.ammount = maxDamageAmount;
		}
			
	}
	
	private static float witherDamageMultiplier = 3;
	@SubscribeEvent
	public void onPlayerDamageByWither(LivingHurtEvent event)
	{
		if (event.entity != null && event.source.getSourceOfDamage() != null
				&& event.source.getSourceOfDamage() instanceof EntityWither)
		{
			event.ammount *= witherDamageMultiplier;
		}
	}

}
