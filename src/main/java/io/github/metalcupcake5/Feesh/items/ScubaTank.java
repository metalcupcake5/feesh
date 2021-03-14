package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScubaTank extends ItemType{

    public ScubaTank(){
        super("SCUBA_TANK");
    }

    @Override
    public ItemStack makeNewStack(){
        ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Scuba Tank");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GOLD + "Item Ability: air™ " + ChatColor.YELLOW + ChatColor.BOLD + "LEFT CLICK");
        lores.add(ChatColor.GRAY + "You may add " + ChatColor.BLUE + "bottles of air " + ChatColor.GRAY + "into");
        lores.add(ChatColor.GRAY + "this scuba tank's storage to");
        lores.add(ChatColor.GRAY + "breathe normally underwater.");
        lores.add("");
        lores.add("" + ChatColor.RED + ChatColor.BOLD + "SPECIAL QUEST ITEM");
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
