package com.deanveloper.skullcreator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Dean B on 12/28/2016.
 */
public class SkullCreatorTesterPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		if (!getDescription().getVersion().endsWith("SNAPSHOT")) {
			throw new IllegalStateException("This is not intended to run as a plugin!");
		} else {
			Bukkit.getLogger().info("Loaded!");
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String lbl, String[] args) {
		Player p = (Player) sender;

		if (args[0].equals("item")) {
			p.getInventory().setItemInMainHand(
					SkullCreator.itemFromBase64(
							"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3Jh" +
									"ZnQubmV0L3RleHR1cmUvOTU1ZDYxMWE4NzhlODIxMjMxNzQ5YjI5NjU3MDhjYWQ5NDI2" +
									"NTA2NzJkYjA5ZTI2ODQ3YTg4ZTJmYWMyOTQ2In19fQ=="
					)
			);
		} else if (args[0].equals("block")) {
			SkullCreator.blockWithBase64(
					p.getLocation().getBlock(),
					"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3Jh" +
							"ZnQubmV0L3RleHR1cmUvOTU1ZDYxMWE4NzhlODIxMjMxNzQ5YjI5NjU3MDhjYWQ5NDI2" +
							"NTA2NzJkYjA5ZTI2ODQ3YTg4ZTJmYWMyOTQ2In19fQ=="
			);
		}

		return true;
	}
}
