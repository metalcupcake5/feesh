package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RodOfLegends extends ItemType {

    public RodOfLegends(){
        super("ROD_OF_LEGENDS");
    }

    @Override
    public ItemStack makeNewStack(){
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Stinky" + ChatColor.DARK_PURPLE + "Rod of Legends");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+130");
        lores.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+120");
        lores.add(ChatColor.GRAY + "Sea Creature Chance: " + ChatColor.RED + "+6%");
        lores.add("");
        lores.add(ChatColor.GRAY + "Increases fishing speed by " + ChatColor.BLUE + "70%");
        lores.add("");
        lores.add(ChatColor.RED + "Requires Fishing Level 16");
        lores.add("");
        lores.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC FISHING ROD");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Map<String, Double> getStats(){
        Map<String, Double> stats = new HashMap<>();
        stats.put("seaCreatureChance", 6.0);
        stats.put("strength", 120.0);
        stats.put("damage", 130.0);
        return stats;
    }
}
