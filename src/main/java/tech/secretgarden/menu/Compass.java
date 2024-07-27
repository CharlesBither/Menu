package tech.secretgarden.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Compass {
    public ItemStack initialize() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta menuMeta = compass.getItemMeta();
        menuMeta.setDisplayName("" + ChatColor.DARK_PURPLE + "Menu");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("" + ChatColor.LIGHT_PURPLE + "Your guidebook to");
        lore.add("" + ChatColor.LIGHT_PURPLE + "Secret Garden");
        lore.add("" + ChatColor.LIGHT_PURPLE + "Right-click to open!");
        menuMeta.setLore(lore);
        menuMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        menuMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        menuMeta.setCustomModelData(6669000);
        compass.setItemMeta(menuMeta);
        return compass;
    }
}