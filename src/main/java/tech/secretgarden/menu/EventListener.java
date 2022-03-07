package tech.secretgarden.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.createInventory;

public class EventListener implements Listener {
    private final Compass compass = new Compass();
    private final MenuInventoryItems menuInventoryItems = new MenuInventoryItems();
    private final WarpInventoryItems warpInventoryItems = new WarpInventoryItems();

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                item.isSimilar(compass.initialize())) {
            Inventory menuInventory = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Menu");

            for (int i = 0; i < menuInventory.getSize(); i++) {
                if (i == 9) { menuInventory.setItem(9, menuInventoryItems.compass()); }
                else if (i == 10) { menuInventory.setItem(i, menuInventoryItems.spawnEgg()); }
                else if (i == 11) { menuInventory.setItem(i, menuInventoryItems.zombieHead()); }
                else if (i == 12) { menuInventory.setItem(i, menuInventoryItems.goldenShovel()); }
                else if (i == 13) { menuInventory.setItem(i, menuInventoryItems.greenGlass()); }
                else if (i == 14) { menuInventory.setItem(i, menuInventoryItems.book()); }
                else if (i == 15) { menuInventory.setItem(i, menuInventoryItems.map()); }
                else if (i == 26) { menuInventory.setItem(i, menuInventoryItems.star()); }
                else {
                    menuInventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                }
            }
            player.openInventory(menuInventory);

            /*
            //slot 9 id second row first column
            menuInventory.setItem(9, menuInventoryItems.compass());
            menuInventory.setItem(10, menuInventoryItems.spawnEgg());
            menuInventory.setItem(11, menuInventoryItems.zombieHead());
            menuInventory.setItem(12, menuInventoryItems.goldenShovel());
            menuInventory.setItem(13, menuInventoryItems.greenGlass());
            menuInventory.setItem(14, menuInventoryItems.book());
            menuInventory.setItem(15, menuInventoryItems.map());
            player.openInventory(menuInventory);

             */
        }
    }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if (e.getClickedInventory() != null && e.getCurrentItem() != null) {
            System.out.println("test");
            Inventory inventory = e.getClickedInventory();
            Player player = (Player) e.getWhoClicked();
            if (e.getView().getTitle().contains("Menu") && e.getView().getTopInventory().equals(inventory)) {
                System.out.println("test1");

                //------------------------------------------ MENU ITEMS ---------------------------------------------------------------
                if (e.getCurrentItem().isSimilar(menuInventoryItems.compass())) {
                    System.out.println("you clicked a compass");
                    //If player click on warps button
                    e.setCancelled(true);
                    Inventory warpInventory = Bukkit.createInventory(null, 27,ChatColor.GREEN + "Warps");

                    for (int i = 0; i < warpInventory.getSize(); i++) {
                        if (i == 9) { warpInventory.setItem(9, warpInventoryItems.spawn()); }
                        else if (i == 10) { warpInventory.setItem(i, warpInventoryItems.shop()); }
                        else if (i == 11) { warpInventory.setItem(i, warpInventoryItems.survival()); }
                        else if (i == 12) { warpInventory.setItem(i, warpInventoryItems.hardcore()); }
                        else if (i == 13) { warpInventory.setItem(i, warpInventoryItems.resource()); }
                        else if (i == 26) { warpInventory.setItem(i, menuInventoryItems.star()); }
                        else {
                            warpInventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                        }
                    }
                    player.openInventory(warpInventory);
                }
                if (e.getCurrentItem().isSimilar(new ItemStack(Material.PARROT_SPAWN_EGG))) {
                    //pet menu
                    e.setCancelled(true);
                    player.performCommand("pet");
                }
                if (e.getCurrentItem().isSimilar(new ItemStack(Material.ZOMBIE_HEAD))) {
                    //deathchest
                    e.setCancelled(true);
                    player.performCommand("dc list");
                }
                if (e.getCurrentItem().isSimilar(new ItemStack(Material.GOLDEN_SHOVEL))) {
                    //claim kit
                    e.setCancelled(true);
                    player.performCommand("kit claim");
                }
                if (e.getCurrentItem().isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE))) {
                    //Scoreboard toggle
                    e.setCancelled(true);
                    player.performCommand("tm scoreboard toggle");
                }
                else {
                    e.setCancelled(true);
                }
            }
            //---------------------------------------- END OF MENU ITEMS -----------------------------------------------------
            //---------------------------------------- WARP ITEMS -------------------------------------------------------------
            if (e.getView().getTitle().contains("Warps") && e.getView().getTopInventory().equals(inventory)) {
                if (e.getCurrentItem().isSimilar(warpInventoryItems.spawn())) {
                    e.setCancelled(true);
                    player.performCommand("spawn");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.shop())) {
                    e.setCancelled(true);
                    player.performCommand("warp shop");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.survival())) {
                    e.setCancelled(true);
                    player.performCommand("warp survival");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.hardcore())) {
                    e.setCancelled(true);
                    player.performCommand("warp hardcore");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.resource())) {
                    e.setCancelled(true);
                    player.performCommand("warp resource");
                }
            }
        }

    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore())
            player.getInventory().addItem(compass.initialize());
    }


    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.getInventory().addItem(compass.initialize());
    }
}