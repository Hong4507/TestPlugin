package me.hong.datouskywars;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ConfigCommand implements CommandExecutor {

    private Main main;

    public ConfigCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("DatouSkywars.use")) {
                if (args.length == 0) {
                    player.sendMessage(main.getConfig().getString("Test.Cocomelon"));
                    player.sendMessage(main.getConfig().getInt("Number") + "");
                    if (main.getConfig().getBoolean("Boolean")) {
                        player.sendMessage("This feature is enabled!");
                    }
                    for (String string : main.getConfig().getStringList("String-List")) {
                        player.sendMessage(string);
                    }
                }
                if (args.length == 2 && args[0].equalsIgnoreCase("new")) {
                    if (args[1].equalsIgnoreCase("boolean")) {
                        main.getConfig().set("Boolean", false);
                    }
                    if (args[1].equalsIgnoreCase("number")) {
                        int number = main.getConfig().getInt("Number");
                        main.getConfig().set("Number", number += 1);
                    }
                    if (args[1].equalsIgnoreCase("list")) {
                        List<String> list = main.getConfig().getStringList("String-List");
                        list.add("hahaha");
                        main.getConfig().set("String-List", list);
                    }
                    main.saveConfig();
                    player.sendMessage("Config revised successfully!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use it!");
            }
        }

        return false;
    }
}
