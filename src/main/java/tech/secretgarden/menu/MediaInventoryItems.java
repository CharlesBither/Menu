package tech.secretgarden.menu;

import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;

public class MediaInventoryItems {
    public ItemStack initializeWebsite() {
        ItemStack website = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta meta = website.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "www.SecretGarden.Tech");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Go to Secret Garden's");
        lore.add(ChatColor.LIGHT_PURPLE + "website!");
        meta.setLore(lore);
        website.setItemMeta(meta);
        return website;
    }

    public ItemStack initializeDiscord() {
        ItemStack discord = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta meta = discord.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Discord");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Join our Discord!");
        meta.setLore(lore);
        discord.setItemMeta(meta);
        return discord;
    }

    public ItemStack initializeIg() {
        ItemStack ig = new ItemStack(Material.AMETHYST_BLOCK);
        ItemMeta meta = ig.getItemMeta();
        meta.setDisplayName("Instagram");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Join our IG");
        meta.setLore(lore);
        ig.setItemMeta(meta);
        return ig;
    }

    public ItemStack initializeFacebook() {
        ItemStack facebook = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta meta = facebook.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "Facebook");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Join our Facebook");
        meta.setLore(lore);
        facebook.setItemMeta(meta);
        return facebook;
    }

    public TextComponent websiteLink() {
        TextComponent textComponent = new TextComponent();
        textComponent.setText("Click me to go to www.SecretGarden.tech");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://secretgarden.tech/"));
        return textComponent;
    }

    public TextComponent discordLink() {
        TextComponent textComponent = new TextComponent();
        textComponent.setText("Click me to join our Discord!");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/wEWv77xbHB"));
        return textComponent;
    }

    public TextComponent igLink() {
        TextComponent textComponent = new TextComponent();
        textComponent.setText("Click me to join our Instagram!");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.instagram.com/secretgardenminecraft/"));
        return textComponent;
    }

    public TextComponent facebookLink() {
        TextComponent textComponent = new TextComponent();
        textComponent.setText("Click me to join our Facebook!");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.facebook.com/SecretGardenMinecraft/"));
        return textComponent;
    }
}
