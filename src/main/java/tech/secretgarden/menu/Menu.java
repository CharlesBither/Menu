package tech.secretgarden.menu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Menu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Menu plugin has loaded");
        getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
