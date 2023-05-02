
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalcommandblock.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.survivalcommandblock.client.gui.SurvivalCommandBlockGUIScreen;
import net.mcreator.survivalcommandblock.client.gui.GreaterCraftingTableGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SurvivalCommandBlockModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SurvivalCommandBlockModMenus.GREATER_CRAFTING_TABLE_GUI.get(), GreaterCraftingTableGUIScreen::new);
			MenuScreens.register(SurvivalCommandBlockModMenus.SURVIVAL_COMMAND_BLOCK_GUI.get(), SurvivalCommandBlockGUIScreen::new);
		});
	}
}
