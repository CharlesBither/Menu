package tech.secretgarden.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuInventoryItems {
    public ItemStack compass() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Warps");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Teleport to one of");
        lore.add(ChatColor.LIGHT_PURPLE + "the following warps.");
        meta.setLore(lore);
        compass.setItemMeta(meta);
        return compass;
    }

    public ItemStack spawnEgg() {
        ItemStack spawnEgg = new ItemStack(Material.PARROT_SPAWN_EGG);
        ItemMeta meta = spawnEgg.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Pets");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Open your pet menu");
        meta.setLore(lore);
        spawnEgg.setItemMeta(meta);
        return spawnEgg;
    }

    public ItemStack zombieHead() {
        ItemStack zombieHead = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta meta = zombieHead.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Death Chest");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Open your Death");
        lore.add(ChatColor.LIGHT_PURPLE + "Chest list");
        meta.setLore(lore);
        zombieHead.setItemMeta(meta);
        return zombieHead;
    }

    public ItemStack goldenShovel() {
        ItemStack goldenShovel = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemMeta meta = goldenShovel.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Grief Prevention");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "get a golden shovel");
        lore.add(ChatColor.LIGHT_PURPLE + "and a stick");
        meta.setLore(lore);
        goldenShovel.setItemMeta(meta);
        return goldenShovel;
    }

    public ItemStack scoreboard() {
        ItemStack scoreboard = new ItemStack(Material.OAK_SIGN);
        ItemMeta meta = scoreboard.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Toggle scoreboard");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Enable/Disable scoreboard");
        meta.setLore(lore);
        scoreboard.setItemMeta(meta);
        return scoreboard;
    }

    public ItemStack book() {
        ItemStack book = new ItemStack(Material.BOOK);
        ItemMeta meta = book.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Vote");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Vote for us to");
        lore.add(ChatColor.LIGHT_PURPLE + "receive a reward!");
        meta.setLore(lore);
        book.setItemMeta(meta);
        return book;
    }

    public ItemStack map() {
        ItemStack map = new ItemStack(Material.MAP);
        ItemMeta meta = map.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "Social Media");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Take a look at our");
        lore.add(ChatColor.LIGHT_PURPLE + "website, Discord,");
        lore.add(ChatColor.LIGHT_PURPLE + "Facebook, and IG");
        meta.setLore(lore);
        map.setItemMeta(meta);
        return map;
    }

    public ItemStack star() {
        ItemStack star = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = star.getItemMeta();
        meta.setDisplayName("Back");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go Back");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        star.setItemMeta(meta);
        return star;
    }

    public ItemStack initializeStash() {
        ItemStack stash = new ItemStack(Material.CHEST);
        ItemMeta meta = stash.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Stash");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Open your Stash");
        meta.setLore(lore);
        stash.setItemMeta(meta);
        return stash;
    }

    public ItemStack initializeStashWithItems() {
        ItemStack stash = new ItemStack(Material.ENDER_CHEST);
        ItemMeta meta = stash.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Stash");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GOLD + "There are items in your stash!");
        meta.setLore(lore);
        stash.setItemMeta(meta);
        return stash;
    }
}
