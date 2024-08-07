package tech.secretgarden.menu;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
    private final Compass compass = new Compass();
    private final MenuInventoryItems menuInventoryItems = new MenuInventoryItems();
    private final WarpInventoryItems warpInventoryItems = new WarpInventoryItems();
    private final MediaInventoryItems mediaInventoryItems = new MediaInventoryItems();
    private final Inventories inventories = new Inventories();

    //TAB api
    TabAPI tab = TabAPI.getInstance();

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        String uuid = player.getUniqueId().toString();
        if (item.hasItemMeta())
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().hasCustomModelData()) {
            if (item.getItemMeta().getCustomModelData() == 6669000) { player.openInventory(inventories.menuInventory(uuid)); }
        }
    }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if (e.getClickedInventory() != null && e.getCurrentItem() != null) {
            Inventory inventory = e.getClickedInventory();
            Player player = (Player) e.getWhoClicked();
            String uuid = player.getUniqueId().toString();
            if (e.getView().getTitle().contains("Menu") && e.getView().getTopInventory().equals(inventory)) {

                //------------------------------------------ MENU ITEMS ---------------------------------------------------------------
                if (e.getCurrentItem().isSimilar(menuInventoryItems.initializeStash()) || e.getCurrentItem().isSimilar(menuInventoryItems.initializeStashWithItems())) {
                    //stash/chest button
                    e.setCancelled(true);
                    player.performCommand("stash");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.compass())) {
                    //If player click on warps button
                    e.setCancelled(true);
                    player.openInventory(inventories.warpInventory());
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.spawnEgg())) {
                    //pet menu
                    e.setCancelled(true);
                    player.performCommand("pet");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.zombieHead())) {
                    //deathchest
                    e.setCancelled(true);
                    player.performCommand("dc list");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.goldenShovel())) {
                    //claim kit
                    e.setCancelled(true);
                    player.performCommand("kit claim");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.scoreboard())) {
                    //Scoreboard toggle
                    e.setCancelled(true);
                    TabPlayer tabPlayer = tab.getPlayer(e.getWhoClicked().getUniqueId());
                    tab.getScoreboardManager().toggleScoreboard(tabPlayer, false);
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.book())) {
                    e.setCancelled(true);
                    player.performCommand("vote");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.map())) {
                    e.setCancelled(true);

                    player.openInventory(inventories.mediaInventory());

                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.star())) {
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
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
                    player.performCommand("warp smp");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.crates())) {
                    e.setCancelled(true);
                    player.performCommand("warp crates");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.resource())) {
                    e.setCancelled(true);
                    player.performCommand("warp resource");
                }
                if (e.getCurrentItem().isSimilar(warpInventoryItems.creative())) {
                    e.setCancelled(true);
                    player.performCommand("warp creative");
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.star())) {
                    e.setCancelled(true);
                    player.openInventory(inventories.menuInventory(uuid));
                }
            }
            //---------------------------------------- END OF WARP ITEMS -----------------------------------------------------
            //---------------------------------------- MEDIA ITEMS -------------------------------------------------------------
            if (e.getView().getTitle().contains("Social Media") && e.getView().getTopInventory().equals(inventory)) {
                if (e.getCurrentItem().isSimilar(mediaInventoryItems.initializeDiscord())) {
                    e.setCancelled(true);
                    player.spigot().sendMessage(mediaInventoryItems.discordLink());
                    e.getWhoClicked().closeInventory();
                }
                if (e.getCurrentItem().isSimilar(mediaInventoryItems.initializeWebsite())) {
                    e.setCancelled(true);
                    player.spigot().sendMessage(mediaInventoryItems.websiteLink());
                    e.getWhoClicked().closeInventory();
                }
                if (e.getCurrentItem().isSimilar(mediaInventoryItems.initializeIg())) {
                    e.setCancelled(true);
                    player.spigot().sendMessage(mediaInventoryItems.igLink());
                    e.getWhoClicked().closeInventory();
                }
                if (e.getCurrentItem().isSimilar(menuInventoryItems.star())) {
                    e.setCancelled(true);
                    player.openInventory(inventories.menuInventory(uuid));
                }
                else {
                    e.setCancelled(true);
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