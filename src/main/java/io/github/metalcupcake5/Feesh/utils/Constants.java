package io.github.metalcupcake5.Feesh.utils;

import io.github.metalcupcake5.Feesh.Feesh;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static Inventory scubaTankInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Scuba Tank Storage");
        ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta glassMeta = blank.getItemMeta();
        glassMeta.setDisplayName(" ");
        blank.setItemMeta(glassMeta);
        for (int i = 0; i < 27; i++) {
            if((i+1) % 9 == 0 || i % 9 == 0){
                inventory.setItem(i, blank);
            }
            if(i > 0 && i < 8 && i != 4) {
                inventory.setItem(i, blank);
            }
            if(i > 18 && i < 26) {
                inventory.setItem(i, blank);
            }
        }
        ItemStack timer = new ItemStack(Material.PAPER);
        ItemMeta timerMeta = timer.getItemMeta();
        timerMeta.setDisplayName(ChatColor.BLUE + "Water Breathing");
        List<String> lores = new ArrayList<>();
        int oxygenLeft = Feesh.oxygenLeft.getOrDefault(player.getUniqueId(), 0);
        lores.add(ChatColor.GRAY + "You have " + ChatColor.BLUE + oxygenLeft);
        lores.add(ChatColor.GRAY + "seconds of water breathing left!");
        timerMeta.setLore(lores);
        timer.setItemMeta(timerMeta);
        inventory.setItem(4, timer);
        /*int bottles = FishingUtils.getBottles(oxygenLeft);
        for(int i = 0; i < bottles; i++) {
            inventory.setItem(bottles+9, bottleAirAdded());
        }*/
        return inventory;
    }

    public static ItemStack bottleAirAdded() {
        ItemStack item = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Bottle Of Air");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "This bottle of air is providing air");
        lores.add(ChatColor.GRAY + "for you for " + ChatColor.GREEN + "3:00 " + ChatColor.GRAY + "mins");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
