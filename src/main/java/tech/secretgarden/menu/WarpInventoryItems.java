package tech.secretgarden.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WarpInventoryItems {
    public ItemStack spawn() {
        ItemStack spawn = new ItemStack(Material.PURPUR_BLOCK);
        ItemMeta meta = spawn.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Spawn");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to Spawn");
        meta.setLore(lore);
        spawn.setItemMeta(meta);
        return spawn;
    }

    public ItemStack shop() {
        ItemStack shop = new ItemStack(Material.DIAMOND);
        ItemMeta meta = shop.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Shop");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to the Shop");
        meta.setLore(lore);
        shop.setItemMeta(meta);
        return shop;
    }

    public ItemStack survival() {
        ItemStack survival = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = survival.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Survival");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to the");
        lore.add(ChatColor.LIGHT_PURPLE + "Survival World");
        meta.setLore(lore);
        survival.setItemMeta(meta);
        return survival;
    }

    public ItemStack crates() {
        ItemStack crates = new ItemStack(Material.CHEST);
        ItemMeta meta = crates.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Crates");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to Crates");
        meta.setLore(lore);
        crates.setItemMeta(meta);
        return crates;
    }

    public ItemStack resource() {
        ItemStack resource = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = resource.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Resource");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to the");
        lore.add(ChatColor.LIGHT_PURPLE + "Resource World");
        meta.setLore(lore);
        resource.setItemMeta(meta);
        return resource;
    }

    public ItemStack creative() {
        ItemStack resource = new ItemStack(Material.BRUSH);
        ItemMeta meta = resource.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Creative");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to the");
        lore.add(ChatColor.LIGHT_PURPLE + "Creative World");
        meta.setLore(lore);
        resource.setItemMeta(meta);
        return resource;
    }
}
