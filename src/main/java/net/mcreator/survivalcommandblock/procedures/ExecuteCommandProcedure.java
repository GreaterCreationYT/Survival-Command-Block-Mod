package net.mcreator.survivalcommandblock.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class ExecuteCommandProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		boolean nothing = false;
		if ((guistate.containsKey("text:Command") ? ((EditBox) guistate.get("text:Command")).getValue() : "").equals("")) {
			nothing = true;
		}
		if (!nothing) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), (guistate.containsKey("text:Command") ? ((EditBox) guistate.get("text:Command")).getValue() : ""));
				}
			}
		}
	}
}
