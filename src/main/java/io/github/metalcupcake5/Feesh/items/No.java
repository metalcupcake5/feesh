package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class No extends ItemType{

    public No() {
        super("NO");
    }

    @Override
    public ItemStack makeNewStack(){
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "No Rod");
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "No Power: " + ChatColor.RED + "+1000");
        lores.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+Infinity");
        lores.add(ChatColor.GRAY + "Sea Creature Chance: " + ChatColor.RED + "+Infinity%");
        lores.add(ChatColor.AQUA + "No");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
