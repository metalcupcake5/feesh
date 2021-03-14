package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shredder extends ItemType{

    public Shredder(){
        super("SHREDDER");
    }

    @Override
    public ItemStack makeNewStack(){
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Shredder");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+235");
        lores.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+15");
        lores.add("");
        lores.add(ChatColor.GRAY + "Ferocity: " + ChatColor.GREEN + "+50");
        lores.add("");
        lores.add(ChatColor.GRAY + "Gives " + ChatColor.BLUE + "strength " + ChatColor.GRAY + "every 50");
        lores.add(ChatColor.GRAY + "bait used + " + ChatColor.BLUE + "damage " + ChatColor.GRAY + "per 10");
        lores.add(ChatColor.GRAY + "fish caught.");
        lores.add(" ");
        lores.add(ChatColor.RED + "Bonus Strength (15 cap): " + ChatColor.GRAY + "1000000000000");
        lores.add(ChatColor.RED + "Bonus Damage (115 cap): " + ChatColor.GRAY + "1000000000000");
        lores.add(ChatColor.AQUA + "Blub");
        lores.add(ChatColor.GRAY + "Increases fishing speed by " + ChatColor.BLUE + "75%");
        lores.add("");
        lores.add("" + ChatColor.GOLD + ChatColor.BOLD + "LEGENDARY FISHING WEAPON");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Map<String, Integer> getStats(){
        Map<String, Integer> stats = new HashMap<>();
        return stats;
    }
}
