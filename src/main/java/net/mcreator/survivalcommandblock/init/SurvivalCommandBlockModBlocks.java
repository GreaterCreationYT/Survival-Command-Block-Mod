
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalcommandblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.survivalcommandblock.block.GreaterCraftingTableBlock;
import net.mcreator.survivalcommandblock.SurvivalCommandBlockMod;

public class SurvivalCommandBlockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SurvivalCommandBlockMod.MODID);
	public static final RegistryObject<Block> GREATER_CRAFTING_TABLE = REGISTRY.register("greater_crafting_table", () -> new GreaterCraftingTableBlock());
}
