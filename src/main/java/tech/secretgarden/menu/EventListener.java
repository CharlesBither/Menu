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

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                item.isSimilar(compass.initialize())) {
            Inventory menuInventory = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Menu");
            //slot 9 id second row first column
            menuInventory.setItem(9, new ItemStack(Material.COMPASS));
            menuInventory.setItem(10, new ItemStack(Material.PARROT_SPAWN_EGG));
            menuInventory.setItem(11, new ItemStack(Material.ZOMBIE_HEAD));
            menuInventory.setItem(12, new ItemStack(Material.GOLDEN_SHOVEL));
            menuInventory.setItem(13, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
            menuInventory.setItem(14, new ItemStack(Material.BOOK));
            menuInventory.setItem(15, new ItemStack(Material.MAP));
            player.openInventory(menuInventory);
        }
    }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
            Inventory inventory = e.getClickedInventory();
            if (e.getView().getTitle().contains("menu") && e.getView().getTopInventory().equals(inventory)) {
                Player player = (Player) e.getWhoClicked();
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().isSimilar(new ItemStack(Material.COMPASS))) {
                        Inventory warpInventory = Bukkit.createInventory(null, 27,ChatColor.GREEN + "Warps");
                        warpInventory.setItem(9, null);
                        warpInventory.setItem(10, null);
                        warpInventory.setItem(11, null);
                        warpInventory.setItem(12, null);
                        warpInventory.setItem(13, null);
                        warpInventory.setItem(14, null);
                        warpInventory.setItem(15, null);
                        warpInventory.setItem(16, null);
                        player.openInventory(warpInventory);
                    }
                    if (e.getCurrentItem().isSimilar(new ItemStack(Material.PARROT_SPAWN_EGG))) {
                        Inventory warpInventory = Bukkit.createInventory(null, 27,ChatColor.GREEN + "Pets");
                        warpInventory.setItem(9, null);
                        warpInventory.setItem(10, null);
                        warpInventory.setItem(11, null);
                        warpInventory.setItem(12, null);
                        warpInventory.setItem(13, null);
                        warpInventory.setItem(14, null);
                        warpInventory.setItem(15, null);
                        warpInventory.setItem(16, null);
                        player.openInventory(warpInventory);
                    }
                    if (e.getCurrentItem().isSimilar(new ItemStack(Material.ZOMBIE_HEAD))) {
                        player.performCommand("dc list");
                    }
                    if (e.getCurrentItem().isSimilar(new ItemStack(Material.GOLDEN_SHOVEL))) {
                        player.performCommand("kit claim");
                    }
                    if (e.getCurrentItem().isSimilar(new ItemStack(Material.GREEN_STAINED_GLASS_PANE))) {
                        player.performCommand("tm scoreboard toggle");
                    }
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

    /*
    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.getInventory().addItem(compass.initialize());
    }

     */
}