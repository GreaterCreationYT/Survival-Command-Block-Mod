
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalcommandblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.survivalcommandblock.world.inventory.SurvivalCommandBlockGUIMenu;
import net.mcreator.survivalcommandblock.world.inventory.GreaterCraftingTableGUIMenu;
import net.mcreator.survivalcommandblock.SurvivalCommandBlockMod;

public class SurvivalCommandBlockModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SurvivalCommandBlockMod.MODID);
	public static final RegistryObject<MenuType<GreaterCraftingTableGUIMenu>> GREATER_CRAFTING_TABLE_GUI = REGISTRY.register("greater_crafting_table_gui", () -> IForgeMenuType.create(GreaterCraftingTableGUIMenu::new));
	public static final RegistryObject<MenuType<SurvivalCommandBlockGUIMenu>> SURVIVAL_COMMAND_BLOCK_GUI = REGISTRY.register("survival_command_block_gui", () -> IForgeMenuType.create(SurvivalCommandBlockGUIMenu::new));
}
