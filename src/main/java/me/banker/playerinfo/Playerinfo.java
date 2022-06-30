package me.banker.playerinfo;

import me.banker.playerinfo.commands.PlayerInfoCommand;
import me.banker.playerinfo.listeners.PlayerinfoListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Playerinfo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Playerinfo enabled!");
        getCommand("playerinfo").setExecutor(new PlayerInfoCommand());

        getServer().getPluginManager().registerEvents(new PlayerinfoListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
