package tech.secretgarden.menu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tech.secretgarden.stash.Stash;

public final class Menu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Menu plugin has loaded");
        getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);

        if (getStashAPI() != null) {
            System.out.println("Stash plugin was found");
        } else {
            System.out.println("Stash was not found");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Stash getStashAPI() {
        Plugin stashPlugin = Bukkit.getPluginManager().getPlugin("Stash");
        if (stashPlugin instanceof Stash) {
            return (Stash) stashPlugin;
        } else {
            return null;
        }
    }
}
