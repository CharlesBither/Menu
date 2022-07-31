package tech.secretgarden.menu;

import me.neznamy.tab.api.TabAPI;
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
        TabAPI tab = TabAPI.getInstance();


        if (getStashAPI() != null) {
            System.out.println("Stash plugin was found");
        } else {
            System.out.println("Stash was not found");
        }
//        if (getTabAPI() == null) {
//            System.out.println("TAB was not found");
//        } else {
//            System.out.println("TAB was found");
//        }
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

//    public TAB getTabAPI() {
//        Plugin tabPlugin = Bukkit.getPluginManager().getPlugin("TAB");
//        if (tabPlugin instanceof TAB) {
//            return (TAB) tabPlugin;
//        } else {
//            return null;
//        }
//    }

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
