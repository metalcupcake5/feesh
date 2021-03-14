package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RodOfTheSea extends ItemType {

    public RodOfTheSea() {
        super("ROD_OF_THE_SEA");
    }

    @Override
    public ItemStack makeNewStack(){
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Rod of the Sea");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+150");
        lores.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+150");
        lores.add(ChatColor.GRAY + "Sea Creature Chance: " + ChatColor.RED + "+7%");
        lores.add("");
        lores.add(ChatColor.GRAY + "Increases fishing speed by " + ChatColor.BLUE + "75%");
        lores.add("");
        lores.add(ChatColor.RED + "Requires Fishing Level 22");
        lores.add("");
        lores.add("" + ChatColor.GOLD + ChatColor.BOLD + "LEGENDARY FISHING ROD");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Map<String, Integer> getStats(){
        Map<String, Integer> stats = new HashMap<>();
        stats.put("seaCreatureChance", 7);
        stats.put("strength", 150);
        stats.put("damage", 150);
        return stats;
    }
}
