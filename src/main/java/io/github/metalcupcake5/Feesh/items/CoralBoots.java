package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoralBoots extends ItemType {
    public CoralBoots() {
        super("CORAL_BOOTS");
    }

    @Override
    public ItemStack makeNewStack() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Coral Boots");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "Treasure Chance: " + ChatColor.RED + "+0.2%");
        lores.add("");
        lores.add(ChatColor.YELLOW + "Full Set Bonus: Searcher");
        lores.add(ChatColor.GRAY + "Increases overall " + ChatColor.BLUE + "coral catches " + ChatColor.GRAY + "by " + ChatColor.BLUE + "5%" + ChatColor.GRAY + ".");
        lores.add("");
        lores.add(ChatColor.DARK_RED + "❣ " + ChatColor.RED + "Requires " + ChatColor.GREEN + "Fishing Skill 23");
        lores.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC BOOTS");
        meta.setLore(lores);
        meta.setColor(Color.YELLOW);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = new HashMap<>();
        stats.put("treasureChance", 0.2);
        return stats;
    }
}
