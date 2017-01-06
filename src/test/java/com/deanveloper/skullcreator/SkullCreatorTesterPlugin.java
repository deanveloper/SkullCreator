package com.deanveloper.skullcreator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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

        if (args[0].equals("from")) {
            if (args[1].equals("url")) {
                p.getInventory().setItemInMainHand(
                        SkullCreator.fromUrl(SkullCreator.Type.ITEM,
                                "http://textures.minecraft.net/texture/" +
                                        "955d611a878e821231749b2965708cad942650672db09e26847a88e2fac2946")
                );
            } else if (args[1].equals("base64")) {
                p.getInventory().setItemInMainHand(
                        SkullCreator.fromBase64(
                                SkullCreator.Type.ITEM,
                                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3Jh" +
                                        "ZnQubmV0L3RleHR1cmUvOTU1ZDYxMWE4NzhlODIxMjMxNzQ5YjI5NjU3MDhjYWQ5NDI2" +
                                        "NTA2NzJkYjA5ZTI2ODQ3YTg4ZTJmYWMyOTQ2In19fQ=="
                        )
                );
            }
        } else if (args[0].equals("name")) {
            // Check if performing a bukkit API operation
            // on the item removes the head information.
            ItemStack item = p.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("lmao");
            item.setItemMeta(meta);
        }

        return true;
    }
}
