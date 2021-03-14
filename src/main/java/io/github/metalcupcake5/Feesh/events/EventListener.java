package io.github.metalcupcake5.Feesh.events;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.utils.Constants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventListener implements Listener {

    private final Feesh plugin;

    public EventListener(Feesh plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        if(inventory.getName().equals("Scuba Tank Storage")){

        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if(inventory.getName().equals("Scuba Tank Storage")){
            ItemStack item = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();
            if(item.equals(ItemManager.BOTTLE_OF_AIR.makeNewStack())){
                int nextSlot = 10;
                for(int i = 10; i < 17; i++){
                    if(inventory.getItem(i) != null){
                        nextSlot++;
                    }
                }
                if(nextSlot != 17) {
                    inventory.setItem(nextSlot, Constants.bottleAirAdded());
                    event.setCurrentItem(null);
                    UUID uuid = player.getUniqueId();
                    if(Feesh.oxygenLeft.containsKey(uuid)){
                        int current = Feesh.oxygenLeft.get(uuid);
                        Feesh.oxygenLeft.put(uuid, current + 180);
                    } else {
                        Feesh.oxygenLeft.put(uuid, 180);
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
                    player.updateInventory();
                    return;
                } else {
                    player.sendMessage(ChatColor.RED + "You have the max amount of bottles added!");
                    player.closeInventory();
                }
            } else {
                event.setCancelled(true);
            }
        }
    }

}
