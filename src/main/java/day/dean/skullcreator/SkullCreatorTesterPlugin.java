package day.dean.skullcreator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author deanveloper on 12/28/2016.
 */
public class SkullCreatorTesterPlugin extends JavaPlugin {

	private static final String TEST_SKULL = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDllY2NjNWMxYzc5YWE3ODI2YTE1YTdmNWYxMmZiNDAzMjgxNTdjNTI0MjE2NGJhMmFlZjQ3ZTVkZTlhNWNmYyJ9fX0=";

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
					SkullCreator.itemWithBase64(SkullCreator.createSkull(), TEST_SKULL)
			);
		} else if (args[0].equals("block")) {
			SkullCreator.blockWithBase64(p.getLocation().getBlock(), TEST_SKULL);
		}

		return true;
	}
}
