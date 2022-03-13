package tech.secretgarden.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventories {

    private final MenuInventoryItems menuInventoryItems = new MenuInventoryItems();
    private final WarpInventoryItems warpInventoryItems = new WarpInventoryItems();
    private final MediaInventoryItems mediaInventoryItems = new MediaInventoryItems();
    private final StashMethods stashMethods = new StashMethods();

    public Inventory menuInventory(String uuid) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Menu");
        ItemStack stashButton;

        if (stashMethods.stashHasItems(uuid)) {
            stashButton = menuInventoryItems.initializeStashWithItems();
        } else {
            stashButton = menuInventoryItems.initializeStash();
        }

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i == 8) { inventory.setItem(i, stashButton); }
            else if (i == 10) { inventory.setItem(i, menuInventoryItems.compass()); }
            else if (i == 11) { inventory.setItem(i, menuInventoryItems.spawnEgg()); }
            else if (i == 12) { inventory.setItem(i, menuInventoryItems.zombieHead()); }
            else if (i == 13) { inventory.setItem(i, menuInventoryItems.goldenShovel()); }
            else if (i == 14) { inventory.setItem(i, menuInventoryItems.greenGlass()); }
            else if (i == 15) { inventory.setItem(i, menuInventoryItems.book()); }
            else if (i == 16) { inventory.setItem(i, menuInventoryItems.map()); }
            else if (i == 26) { inventory.setItem(i, menuInventoryItems.star()); }
            else {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }
        return inventory;
    }

    public Inventory warpInventory() {
        Inventory inventory = Bukkit.createInventory(null, 27,ChatColor.GREEN + "Warps");
        //Creates and opens warp menu
        for (int i = 0; i < inventory.getSize(); i++) {
            if (i == 11) { inventory.setItem(i, warpInventoryItems.spawn()); }
            else if (i == 12) { inventory.setItem(i, warpInventoryItems.shop()); }
            else if (i == 13) { inventory.setItem(i, warpInventoryItems.survival()); }
            else if (i == 14) { inventory.setItem(i, warpInventoryItems.hardcore()); }
            else if (i == 15) { inventory.setItem(i, warpInventoryItems.resource()); }
            else if (i == 26) { inventory.setItem(i, menuInventoryItems.star()); }
            else {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }
        return inventory;
    }

    public Inventory mediaInventory() {
        Inventory inventory = Bukkit.createInventory(null, 9, "Social Media");
        for (int i = 0; i < inventory.getSize(); i++) {
            if (i == 2) { inventory.setItem(i, mediaInventoryItems.initializeDiscord()); }
            else if (i == 3) { inventory.setItem(i, mediaInventoryItems.initializeWebsite()); }
            else if (i == 4) { inventory.setItem(i, mediaInventoryItems.initializeIg()); }
            else if (i == 5) { inventory.setItem(i, mediaInventoryItems.initializeFacebook()); }
            else if (i == 6) { inventory.setItem(i, menuInventoryItems.star()); }
            else {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
        }
        return inventory;
    }
}
