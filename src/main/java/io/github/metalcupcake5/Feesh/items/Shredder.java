package io.github.metalcupcake5.Feesh.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
        lores.add(ChatColor.AQUA + "Blub");
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
