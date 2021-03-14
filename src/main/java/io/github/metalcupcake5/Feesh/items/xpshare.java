package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xpshare extends ItemType {
    public xpshare() {
        super("XP_SHARE");
    }

    @Override
    public ItemStack makeNewStack() {
        ItemStack item = new ItemStack(Material.MELON_SEEDS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("XP SHARE THING");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "xp share very real");
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
