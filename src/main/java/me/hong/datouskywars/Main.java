package me.hong.datouskywars;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("config").setExecutor(new ConfigCommand(this));

        getServer().getConsoleSender().sendMessage("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage("Plugin disabled!");
    }
}
