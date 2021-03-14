package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottleOfAir extends ItemType {
    public BottleOfAir() {
        super("BOTTLE_OF_AIR");
    }

    @Override
    public ItemStack makeNewStack() {
        ItemStack item = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Bottle Of Air");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "This item may be added to the");
        lores.add(ChatColor.BLUE + "Scuba Tank " + ChatColor.GRAY + "to be able");
        lores.add(ChatColor.GRAY + "to breathe normally underwater.");
        lores.add("");
        lores.add("" + ChatColor.RED + ChatColor.BOLD + "SPECIAL QUEST ITEM");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();
        return stats;
    }
}
